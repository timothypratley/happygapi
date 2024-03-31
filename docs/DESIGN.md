# HappyGAPI Design

A function oriented, happy way to call Google APIs from Clojure/Script.

TODO: The ClojureScript part

## Context

### Calling an API is hard

> Everybody wants to be a bodybuilder,
> but nobody wants to lift no heavy-ass weights.
>
> -- Ronnie Coleman

Everybody wants to be a data savant,
but nobody wants to call no tricksy-doody APIs.

![](https://i0.wp.com/www.muscleandfitness.com/wp-content/uploads/2019/02/ronnie-coleman-squat-barbell-1109.jpg?quality=86&strip=all)

Making a request is easy - [`clj-http`](https://github.com/dakrone/clj-http).
(Side note: v3 has changed quite a lot!)
But there is a lot more to it:

* Authentication and authorization
* What resources are available and what parameters can be passed?
* Request validation
* Response comprehension
* Paging
* Handling failures and retries
* Rate maximization
* Concurrency (with rates and retries)

Despite this, web APIs are often described as easy.
Companies like to pretend it's easy and users like to imagine that it's easy.
Nobody talks about the hard parts.
This situation often ends with frustration and failure.

Part of the difference between Amazonica and Cognitect is trying to make you think it's a function call,
but it's not! Stop pretending.
A client with stateful stuff.
Call request with a data object.

Getting stuff out. Return or something else?


### Google APIs

* Very wide! Everything from consumer cloud (docs, videos, email, ...) to professional cloud services (OCR, batch processing, databases, servers, ...)
* Has a lot of good stuff, both consumer and professional. OCR, Translate, Dataflow
* Competitive pricing
* Well defined, regular, documented
* Hardly ever used?
* The Java API is horrifically over specific, a nightmare for Clojure programmers to use,
  like HttpServletRequest [death by specificity](https://www.youtube.com/watch?v=aSEQfqNYNAc),
  but 1000x worse
* Authentication model is necessarily complex

### Amazon APIs

* Maintained by Cognitect
* Macros? Magical?
* Widely used
* Monopoly?

### Other APIs

* Often have unmaintained wrappers 

## The Hard Parts

### Auth

* Basic username/password.
  Easy for users.
  Secure, **except** that it encourages users to store a plain text file containing credentials, which is risky.
  If those credentials are stolen,
  your account is compromised until password reset.
  Not widely offered/used. Not an option for GAPI).
* Secret token. Please put it in the header, query parameters are secure but can appear in server logs as plain text. Easy and common, but often lacks fine-grained permissions. Github tokens can be limited in certain ways. For GAPI, the token is only useful for public APIs. It won't give you access to your data. Popular because it's really just basic auth, but with the ability to create multiple tokens?
* OAuth2 tokens. Enables 3rd party applications to be permitted access to user data on a per-user and per-scope basis. Necessary for many Google APIs. Requires you to have an "app". Probably confusing to most users who don't want to make an "app", just want their data.
  "Apps" have a secret token which is used to get access tokens. End users are redirected to Google to sign in and grant access, then redirected back to the "app" with the access token. Access tokens are end user specific and expire.
  Needs Google side configuration and a local http listening process.
  Somewhat bizarre choice? Is Google the only company that does this? Why?
  By the way, secrets often get saved in plain text files!
  This is less troublesome than in basic auth, as users can't log in with the secret.
  Apps can be spoofed with secrets, so don't store them in plain text for a real app.
  By the way, tokens are often saved in plain text files!
  At least they expire, but yeah pretty risky if you ask me.
  For GAPI you can create service accounts, which don't require interactive login (so yeah not really much different from tokens huh).

### More about OAuth2

TODO: insert diagrams

#### Simplistic view

```
  App -secret-> Google
  Google -access-> User
  User -access-> App
```

#### Reality

```
  ...
  App -secret-> Google
  ...
  Google -access-> User
  ...
  User -access-> App
  ...
```


### For Users

Poor API usage:

* Not used at all (GAPI)
* Doesn't handle failure
* Bespoke, brittle paging/throttling

API usage is often a last resort.

### For Providers

Companies don't want you to use their API!
Their priority is to prevent overuse (quotas) and misuse (auth).

API libraries are often out of date,
and rarely address user problems.
Never concerned with paging or throttling.

## The Solution: HappyGAPI

A library!

Generate code from the webservice description document (A big JSON file).

TODO: I like the big JSON file, do other companies have these (AWS?)

TODO: Can it be made compatible with things like Swagger?

TODO: Compare, contrast, and learn from https://github.com/cognitect-labs/aws-api

### Generate Code

* Docstrings
* Symbol resolution
* Exploration, autocomplete
* Parameter validation

Makes consuming the API a pleasure!
I can use my IDE features like "help" and "autocomplete" to quickly make requests with confidence that I got them right.

But there is value in having EVERYTHING be data (we can have both).

### Maintenance

Automatically release schema changes?

### Batteries included

#### Auth

Oauth2

Credential lookup (looks for secret.json etc... is there a way to encourage encrypting credentials?)

Dynamic var?

#### Paging

#### Rate maximization

There's already a good throttling library (but does it allow rate maximization)?
Make it easy to use.

#### Error Handling and Retries

Dynamic var?

There's a retry library, is it enough?

#### Concurrency

This is maybe just error handling and rate maximization? Or a task system? Or something else?


## Design Decisions

### Namespace Organization

Originally I chose to follow the api organization as closely as possible,
but upon reflection I think it would be better to collect resources:

`happygapi.youtube.videos/list$` vs `happygapi.youtube/videos-list`

1. The methods often overlap core functions like `list`, `get` etc.
2. Less requires are necessary when working with an API (YouTube has multiple resources).
3. Easier to search for functionality with autocomplete

This could be a non-breaking change by generating BOTH, but I think that would be confusing.
Given there probably aren't many users, I plan to just break this.

### Mutability

Pass `auth` to every call, or use a global?

I originally chose to pass it to every call, the proper functional choice. But upon reflection I'd rather it be a dynamically bound function.

This could be a non-breaking change by generating BOTH, but I think that would be confusing.
Given there probably aren't many users, I plan to just break this.



### Oauth2

Should really be a separate library.

This could be a non-breaking change by generating BOTH, but I think that would be confusing.
Given there probably aren't many users, I plan to just break this.

### Default Scopes

Originally some default scopes were included for convenience.
But they are arbitrary and bad.
I plan to break this.

### Typed Clojure annotations? Malli?

These seem like they would be helpful

### Should the required parameters be positional args?

Probably not? Maybe worth discussion.

### Should record the GAPI version when publising
