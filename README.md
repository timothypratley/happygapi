# HappyGAPI

A Clojure library for calling [Google APIs](https://developers.google.com/apis-explorer); gsheets, drive, bigquery and so on.


## Rationale

HappyGAPI defines functions for calling GAPI so you don't have to!

HappyGAPI generates source code:
1. Navigate to source
2. See all available resources and methods
3. Clear exceptions on failure
4. The function doc-strings contain a description, a link to online docs, and example inputs
5. Needs to be regenerated to discovery API updates

HappyGAPI accepts data instead of an objects.
Data composes flexibly and is straight-forward to construct.

Oauth2 works "out of the box" for standalone, and with minimal configuration in a web server.

The discovery of GAPIs was inspired by [clj-gapi](https://github.com/ianbarber/clj-gapi).
See Google API discovery: https://developers.google.com/discovery/v1/getting_started


## Usage

Add the dependency to the project file:

![clojars version](https://clojars.org/happygapi/latest-version.svg)

Require `happygapi.<<api>>.<<resource>>` in the code:

```clojure
(ns my.ns
  (:require [happygapi.sheets.spreadsheets :as gsheets]
            [happy.oauth2-credentials :as credentials]))
```

Call the api:

```clojure
(gsheets/get$ (credentials/auth!) {:spreadsheetId "xyz"})

(gsheets/values-batchUpdate$ (credentials/auth!)
                             {:spreadsheetId spreadsheet-id}
                             {:valueInputOption "USER_ENTERED"
                              :data             [{:range  "Sheet1"
                                                  :values [[1 2 3]
                                                           [4 5 6]]}]})
```

Functions are generated according to this pattern:

```
(happygapi.<<api>>.<<resource>>/<<?subresource(s)>>-<<method>>$ auth params ?body)
```

Where `auth` is a map to apply to the request, `params` and `body` align with REST documentation.
For example see [batchUpdate](https://developers.google.com/sheets/api/reference/rest/v4/spreadsheets.values/batchUpdate).

The json-schema files are written as edn to resources.
I plan to add json-schema validation to the body soon.


### Authorization

The `auth` argument can be one of:

```clojure
{}                                                   ; anonymous
{:query-params {"key" api-key}}                      ; api-key
{:headers {"Authorization" (str "Bearer " token)}}   ; oauth2 token
```

The `auth` argument gets merged into the request.
You can specify additional request options if you want to.

To participate in oauth2 you need to fetch and store tokens.

To create an app in the Google Console, follow [Setting up OAuth 2.0](https://support.google.com/googleapi/answer/6158849?hl=en).

There are two methods for obtaining a token:
* User redirects, which prompt a user to authorize your app.
  Download the `secret.json` from the [Google Console](https://console.cloud.google.com/).
  Do not add this file to source control, keep it secured.
  This method is suitable if you want users to grant your app access to their data.
* Service account private key (suitable for server to server).
  [Create a Service account](https://developers.google.com/identity/protocols/oauth2/service-account)
  and download a `service.json` key file.
  Do not add this file to source control, keep it secured.
  This method is suitable for automated jobs.

The [`happy.oauth2-credentials`](src/happy/oauth2_credentials.clj) namespace provides a convenient way to
manage authorization.
By default, it tries to read `secret.json` or `service.json` from disk in the current directory.
You can pass in configuration map of the same shape instead.
`happy.oauth2-credentials` stores tokens on disk.
If you want to use HappyGAPI in a web app, you should instead store and fetch tokens from your database.
This can be done by calling `init!` with a `fetch` and `store` function, or by creating your own implementation of `auth!`.

The [`happy.oauth2-capture-redirect`](src/happy/oauth2_capture_redirect.clj)
namespace provides a listener to capture a code when the user is redirected to your site from the oauth2 provider.
If you use it, you will need to include [ring](https://github.com/ring-clojure/ring) as a dependency.
Web applications should instead define a route to capture the code.

The [`happy.oauth2`](src/happy/oauth2.clj) namespace provides generic functions to support oauth2 authorization so that you can assemble only the parts you need.


## Retries

HappyGAPI leaves retries up to the consuming application.
However if you are doing many requests, it is likely you will want to retry failed requests,
as failures can happen for a variety of availability reasons.

Providing your own retry strategy can be done by redefining the `happy.util/get-response` behavior:

```clj
(defmacro with-get-response-retries
  [& body]
  `(let [get-response# @#'hu/get-response]
     (with-redefs [hu/get-response (fn get-response-with-retries# [& args#]
                                     (again/with-retries [2000 5000 10000 15000]
                                                         (apply get-response# args#)))]
       ~@body)))
```

Now you can wrap calls using `with-get-response-retries`:

```clj
(with-get-response-retries
  (g.sheets/create$ (credentials/auth!)
                    {}
                    {:properties {:title title}}))
```

This example uses the [again](https://github.com/liwp/again) library.


## Contributing

Issues, pull requests, and suggestions are welcome.


## Updating

Building pulls down the latest schema.
You can build it yourself if this library has not been updated in a while.
Please email me if you'd like me to push an updated version.


## Building

The api namespaces can be generated by running `happy.lion/-main`

```
lein run
```

## Testing

To run the tests you need to download `secret.json` from the Google console.

```
lein test
```


## Deploying

```
lein deploy
```

## License

Copyright © 2020 Timothy Pratley

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
