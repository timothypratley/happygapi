(ns happygapi.language.documents
  "Cloud Natural Language API
  Provides natural language understanding technologies, such as sentiment analysis, entity recognition, entity sentiment analysis, and other text annotations, to developers.
  See: https://cloud.google.com/natural-language/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn analyzeEntities$
  "Required parameters: none
  
  Finds named entities (currently proper names and common nouns) in the text
  along with entity types, salience, mentions for each entity, and
  other properties."
  {:scopes ["https://www.googleapis.com/auth/cloud-language"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://language.googleapis.com/"
     "v1/documents:analyzeEntities"
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

(defn analyzeSyntax$
  "Required parameters: none
  
  Analyzes the syntax of the text and provides sentence boundaries and
  tokenization along with part of speech tags, dependency trees, and other
  properties."
  {:scopes ["https://www.googleapis.com/auth/cloud-language"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://language.googleapis.com/"
     "v1/documents:analyzeSyntax"
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

(defn annotateText$
  "Required parameters: none
  
  A convenience method that provides all the features that analyzeSentiment,
  analyzeEntities, and analyzeSyntax provide in one call."
  {:scopes ["https://www.googleapis.com/auth/cloud-language"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://language.googleapis.com/"
     "v1/documents:annotateText"
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

(defn classifyText$
  "Required parameters: none
  
  Classifies a document into categories."
  {:scopes ["https://www.googleapis.com/auth/cloud-language"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://language.googleapis.com/"
     "v1/documents:classifyText"
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

(defn analyzeSentiment$
  "Required parameters: none
  
  Analyzes the sentiment of the provided text."
  {:scopes ["https://www.googleapis.com/auth/cloud-language"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://language.googleapis.com/"
     "v1/documents:analyzeSentiment"
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

(defn analyzeEntitySentiment$
  "Required parameters: none
  
  Finds entities, similar to AnalyzeEntities in the text and analyzes
  sentiment associated with each entity and its mentions."
  {:scopes ["https://www.googleapis.com/auth/cloud-language"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://language.googleapis.com/"
     "v1/documents:analyzeEntitySentiment"
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
