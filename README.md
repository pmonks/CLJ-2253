[![Build Status](https://travis-ci.org/pmonks/CLJ-2253.svg?branch=master)](https://travis-ci.org/pmonks/CLJ-2253)
[![Open Issues](https://img.shields.io/github/issues/pmonks/CLJ-2253.svg)](https://github.com/pmonks/CLJ-2253/issues)
[![Average time to resolve an issue](http://isitmaintained.com/badge/resolution/pmonks/CLJ-2253.svg)](http://isitmaintained.com/project/pmonks/CLJ-2253 "Average time to resolve an issue")
[![License](https://img.shields.io/github/license/pmonks/CLJ-2253.svg)](https://github.com/pmonks/CLJ-2253/blob/master/LICENSE)
[![Dependencies Status](https://versions.deps.co/pmonks/CLJ-2253/status.svg)](https://versions.deps.co/pmonks/CLJ-2253)

# CLJ-2253

This library implements a workaround for [CLJ-2253](https://dev.clojure.org/jira/browse/CLJ-2253).  Simply require (or use) this namespace before using `slurp` and you're done.

## Installation

CLJ-2253 is available as a Maven artifact from [Clojars](https://clojars.org/org.pmonks/clj-2253).
Plonk the following in your project.clj :dependencies, `lein deps` and you should be good to go:

```clojure
[org.clojars.pmonks/clj-2253 "#.#.#"]   ; Where #.#.# is replaced with an actual version number
```

The latest released version is:

[![Clojars Project](https://img.shields.io/clojars/v/org.clojars.pmonks/clj-2253.svg)](https://clojars.org/org.clojars.pmonks/clj-2253)

### Trying it Out
Alternatively, you may prefer to kick the library's tyres without creating a project.  This is a snap with the awesome [`lein try` plugin](https://github.com/rkneufeld/lein-try):

```shell
$ lein try org.clojars.pmonks/CLJ-2253
```

You will be dropped in a REPL with the library downloaded and ready for use.

## Usage

The functionality is provided by a single namespace, `CLJ-2253`, that will work it's hacky magic as soon as its loaded.

Require it in the REPL (incl. a `lein try` REPL):

```clojure
(require '[CLJ-2253] :reload-all)
```

Require it in your project:

```clojure
(ns my-app.core
  (:require [CLJ-2253]))
```

## Contributor Information

[GitHub project](https://github.com/pmonks/CLJ-2253)

[Bug Tracker](https://github.com/pmonks/CLJ-2253/issues)

## License

Copyright 2018 Peter Monks

Distributed under the [Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0).

SPDX-License-Identifier: [Apache-2.0](https://spdx.org/licenses/Apache-2.0)

### 3rd Party Licenses

To see the full list of licenses of all third party libraries used by this project, please run:

```shell
$ lein licenses :csv | cut -d , -f3 | sort | uniq
```

To see the dependencies and licenses in detail, run:

```shell
$ lein licenses
```
