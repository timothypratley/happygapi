(ns happygapi.commentanalyzer.comments
  "Perspective Comment Analyzer API
  The Perspective Comment Analyzer API provides information about the potential impact of a comment on a conversation (e.g. it can provide a score for the \"toxicity\" of a comment). Users can leverage the \"SuggestCommentScore\" method to submit corrections to improve Perspective over time. Users can set the \"doNotStore\" flag to ensure that all submitted comments are automatically deleted after scores are returned.
  See: https://github.com/conversationai/perspectiveapi/blob/master/README.md"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "commentanalyzer_schema.edn"))))

(defn analyze$
  "Required parameters: none
  
  Optional parameters: none
  
  Analyzes the provided text and returns scores for requested attributes."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://commentanalyzer.googleapis.com/"
     "v1alpha1/comments:analyze"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))

(defn suggestscore$
  "Required parameters: none
  
  Optional parameters: none
  
  Suggest comment scores as training data."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://commentanalyzer.googleapis.com/"
     "v1alpha1/comments:suggestscore"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))
