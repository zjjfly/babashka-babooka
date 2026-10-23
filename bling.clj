#!/usr/bin/env bb

(require '[bling.core :refer [bling callout point-of-interest]])

(println (bling [:bold "bold"]
                ", "
                [:italic "italic"]
                ", or "
                [:yellow "colored"]))

(callout {:type :error}
         "Example callout, with :type of :info")

(defn example-custom-callout
  [{:keys [point-of-interest-opts callout-opts]}]
  (let [poi-opts     (merge {:header "Your header message goes here."
                             :body   (str "The body of your message goes here."
                                          "\n"
                                          "Another line of copy."
                                          "\n"
                                          "Another line."
                                          )}
                            point-of-interest-opts)
        message      (point-of-interest poi-opts)
        callout-opts (merge callout-opts
                            {:padding-top 1})]
    (callout callout-opts message)))

(example-custom-callout
  {:point-of-interest-opts {:type   :error
                            :file   "example.ns.core"
                            :line   11
                            :column 1
                            :form   '(+ 1 true)}
   :callout-opts           {:type :error}})
