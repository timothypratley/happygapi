# happygapi

A Clojure library with source generated functions for using Google APIs.


## Rationale

1. Navigate to source
2. See all available resources and methods
3. Data composition (e.g. when defining a "Chart")
4. Clear exception stacktraces on failure 


## Usage

This library is alpha, expect changes.

### Dependencies

Add `happygapi` as a dependency.
You will also need `clj-http` and `cheshire`,
which are not included but necessary.

```clj
[happygapi]
[clj-http]
[cheshire]
```

### Authorization

The `auth` argument can be one of:
```clj
{}
{:query-params {"key" api-key}}
{:headers {"Authorization" (str "Bearer " token)}}
```

Oauth2 mechanisms to get a token are not included in this library,
however under `/test` there is an oauth2 namespace that demonstrates one approach.
Follow the "Getting started" Google API instructions to create an App.
To run the test you need to download `secret.json` from the Google console.


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
