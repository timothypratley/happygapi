(ns happygapi.commentanalyzer.comments
  "Perspective Comment Analyzer API: comments.
  The Perspective Comment Analyzer API provides information about the potential impact of a comment on a conversation (e.g. it can provide a score for the \"toxicity\" of a comment). Users can leverage the \"SuggestCommentScore\" method to submit corrections to improve Perspective over time. Users can set the \"doNotStore\" flag to ensure that all submitted comments are automatically deleted after scores are returned.
  See: https://github.com/conversationai/perspectiveapi/blob/master/README.mdapi/reference/rest/v1alpha1/comments"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn analyze$
  "https://github.com/conversationai/perspectiveapi/blob/master/README.mdapi/reference/rest/v1alpha1/comments/analyze
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:sessionId string,
   :communityId string,
   :comment {:text string, :type string},
   :doNotStore boolean,
   :context {:entries [TextEntry],
             :articleAndParentComment ArticleAndParentComment},
   :requestedAttributes {},
   :languages [string],
   :spanAnnotations boolean,
   :clientToken string}
  
  Analyzes the provided text and returns scores for requested attributes."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://commentanalyzer.googleapis.com/"
     "v1alpha1/comments:analyze"
     #{}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn suggestscore$
  "https://github.com/conversationai/perspectiveapi/blob/master/README.mdapi/reference/rest/v1alpha1/comments/suggestscore
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:communityId string,
   :clientToken string,
   :languages [string],
   :comment {:text string, :type string},
   :context {:entries [TextEntry],
             :articleAndParentComment ArticleAndParentComment},
   :attributeScores {},
   :sessionId string}
  
  Suggest comment scores as training data."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://commentanalyzer.googleapis.com/"
     "v1alpha1/comments:suggestscore"
     #{}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
