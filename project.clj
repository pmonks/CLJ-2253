;
; Copyright 2018 Peter Monks
; SPDX-License-Identifier: Apache-2.0
;
; Licensed under the Apache License, Version 2.0 (the "License");
; you may not use this file except in compliance with the License.
; You may obtain a copy of the License at
;
;     http://www.apache.org/licenses/LICENSE-2.0
;
; Unless required by applicable law or agreed to in writing, software
; distributed under the License is distributed on an "AS IS" BASIS,
; WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
; See the License for the specific language governing permissions and
; limitations under the License.
;

(defproject clj-commons/clj-2253 "0.2.0-SNAPSHOT"
  :description         "A workaround for https://dev.clojure.org/jira/browse/CLJ-2253"
  :url                 "https://github.com/clj-commons/CLJ-2253"
  :license             {:spdx-license-identifier "Apache-2.0"
                        :name                    "Apache License, Version 2.0"
                        :url                     "http://www.apache.org/licenses/LICENSE-2.0"}
  :min-lein-version    "2.8.1"
  :repositories        [["sonatype-snapshots" {:url "https://oss.sonatype.org/content/groups/public" :snapshots true}]
                        ["jitpack"            {:url "https://jitpack.io"}]]
  :dependencies        [[org.clojure/clojure "1.10.0"]]
  :profiles            {:dev  {:plugins [[lein-licenses "0.2.2"]]}
                        :test {:dependencies [[http-kit "2.3.0"]]}
                        :1.5  {:dependencies [[org.clojure/clojure "1.5.1"]]}
                        :1.6  {:dependencies [[org.clojure/clojure "1.6.0"]]}
                        :1.7  {:dependencies [[org.clojure/clojure "1.7.0"]]}
                        :1.8  {:dependencies [[org.clojure/clojure "1.8.0"]]}
                        :1.9  {:dependencies [[org.clojure/clojure "1.9.0"]]}
                        :1.10 {:dependencies [[org.clojure/clojure "1.10.0"]]}}
  :deploy-repositories [
                         ["snapshots" {:url      "https://clojars.org/repo"
                                       :username :env/clojars_username
                                       :password :env/clojars_password}]
                         ["releases"  {:url      "https://clojars.org/repo"
                                       :username :env/clojars_username
                                       :password :env/clojars_password}]
                       ])
