| | | |
|---:|:---:|:---:|
| [**main**](https://github.com/pmonks/CLJ-2253/tree/main) | [![CI](https://github.com/pmonks/CLJ-2253/workflows/CI/badge.svg?branch=main)](https://github.com/pmonks/CLJ-2253/actions?query=workflow%3Aci) | [![Dependencies](https://github.com/pmonks/CLJ-2253/workflows/dependencies/badge.svg?branch=main)](https://github.com/pmonks/CLJ-2253/actions?query=workflow%3Adependencies) |
| [**dev**](https://github.com/pmonks/CLJ-2253/tree/dev)  | [![CI](https://github.com/pmonks/CLJ-2253/workflows/CI/badge.svg?branch=dev)](https://github.com/pmonks/CLJ-2253/actions?query=workflow%3ACI) | [![Dependencies](https://github.com/pmonks/CLJ-2253/workflows/dependencies/badge.svg?branch=dev)](https://github.com/pmonks/CLJ-2253/actions?query=workflow%3Adependencies) |

[![Latest Version](https://img.shields.io/clojars/v/com.github.pmonks/CLJ-2253)](https://clojars.org/com.github.pmonks/CLJ-2253/) [![Open Issues](https://img.shields.io/github/issues/pmonks/CLJ-2253.svg)](https://github.com/pmonks/CLJ-2253/issues) [![License](https://img.shields.io/github/license/pmonks/CLJ-2253.svg)](https://github.com/pmonks/CLJ-2253/blob/main/LICENSE)

# CLJ-2253

This library implements a workaround for [CLJ-2253](https://dev.clojure.org/jira/browse/CLJ-2253).  Simply require (or use) this namespace before using `slurp` and you're done.

## Installation

CLJ-2253 is available as a Maven artifact from [Clojars](https://clojars.org/com.github.pmonks/CLJ-2253).

### Trying it Out

If you use the Clojure CLI tools:

```shell
$ clj -Sdeps '{:deps {com.github.pmonks/CLJ-2253 {:mvn/version "#.#.#"}}}'  # Where #.#.# is replaced with an actual version number
```

If you use Leiningen:

```shell
$ lein try com.github.pmonks/CLJ-2253
```

Either way, you will be dropped in a REPL with the library downloaded and ready for use.

## Usage

The functionality is provided by a single namespace, `CLJ-2253`, that will work its hacky magic as soon as it's `require`d.

Require it in the REPL:

```clojure
(require '[CLJ-2253])
```

Require it in your project:

```clojure
(ns my-app.core
  (:require [CLJ-2253]))
```

## Contributor Information

[Contributing Guidelines](https://github.com/pmonks/CLJ-2253/blob/main/.github/CONTRIBUTING.md)

[GitHub project](https://github.com/pmonks/CLJ-2253)

[Bug Tracker](https://github.com/pmonks/CLJ-2253/issues)

### Developer Workflow

The repository has two permanent branches: `main` and `dev`.  **All development must occur either in branch `dev`, or (preferably) in feature branches off of `dev`.**  All PRs must also be submitted against `dev`; the `main` branch is **only** updated from `dev` via PRs created by the core development team.  All other changes submitted to `main` will be rejected.

This model allows otherwise unrelated changes to be batched up in the `dev` branch, integration tested there, and then released en masse to the `main` branch, which will trigger automated generation and deployment of the release.

### Why are there so many different groupIds on Clojars for this project?

The project was originally developed under my personal GitHub account.  In 2018 it was transferred to the `clj-commons` GitHub organisation, but then, as that group refined their scope and mission, it was determined that it no longer belonged there, and the project were transferred back in late 2021.  During this time the build tooling for the project also changed from Leiningen to tools.build, which created further groupId churn (tools.build introduced special, useful semantics for `com.github.username` groupIds that don't exist with Leiningen or Clojars).

## License

Copyright 2018 Peter Monks

Distributed under the [Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0).

SPDX-License-Identifier: [Apache-2.0](https://spdx.org/licenses/Apache-2.0)

### Dependency Licenses

To see the licenses for all dependencies used by this project, please run:

```shell
$ clj -T:build licenses
```

To see each dependency and its license(s) in detail, run:

```shell
$ clj -T:build licenses :output :detailed
```
