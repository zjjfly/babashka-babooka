#!/usr/bin/env bb

(require '[babashka.pods :as pods])
(pods/load-pod 'rorokimdim/stash "0.3.1")

(require '[pod.rorokimdim.stash :as stash])

(stash/init {"encryption-key"          "foo"
             "stash-path"              "foo.stash"
             "create-stash-if-missing" true})

(stash/version)
(stash/add 0 "20221210092056" "dream entry")

(stash/get "20221210092056")
(stash/keys 0)
