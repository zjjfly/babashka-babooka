#!/usr/bin/env bb

(require '[babashka.deps :as deps])

(deps/add-deps '{:deps {dev.weavejester/medley {:mvn/version "1.5.0"}}})

(require '[medley.core :as medley])
(medley/filter-keys #(= % :a) {:a 1 :b 2})
