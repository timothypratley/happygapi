(ns happygapi.commentanalyzer.comments
  "Perspective Comment Analyzer API
  The Perspective Comment Analyzer API provides information about the potential impact of a comment on a conversation (e.g. it can provide a score for the \"toxicity\" of a comment). Users can leverage the \"SuggestCommentScore\" method to submit corrections to improve Perspective over time. Users can set the \"doNotStore\" flag to ensure that all submitted comments are automatically deleted after scores are returned.
  See: https://github.com/conversationai/perspectiveapi/blob/master/README.md"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn analyze$
  "Required parameters: none
  
  Analyzes the provided text and returns scores for requested attributes."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
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
      :body body}
     auth))))

(defn suggestscore$
  "Required parameters: none
  
  Suggest comment scores as training data."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
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
      :body body}
     auth))))
