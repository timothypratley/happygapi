(ns happygapi.language.documents
  "Cloud Natural Language API: documents.
  Provides natural language understanding technologies, such as sentiment analysis, entity recognition, entity sentiment analysis, and other text annotations, to developers.
  See: https://cloud.google.com/natural-language/api/reference/rest/v1/documents"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn classifyText$
  "https://cloud.google.com/natural-language/api/reference/rest/v1/documents/classifyText
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:document {:language string,
              :gcsContentUri string,
              :content string,
              :type string}}
  
  Classifies a document into categories."
  {:scopes ["https://www.googleapis.com/auth/cloud-language"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://language.googleapis.com/"
     "v1/documents:classifyText"
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

(defn analyzeEntities$
  "https://cloud.google.com/natural-language/api/reference/rest/v1/documents/analyzeEntities
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:encodingType string,
   :document {:language string,
              :gcsContentUri string,
              :content string,
              :type string}}
  
  Finds named entities (currently proper names and common nouns) in the text along with entity types, salience, mentions for each entity, and other properties."
  {:scopes ["https://www.googleapis.com/auth/cloud-language"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://language.googleapis.com/"
     "v1/documents:analyzeEntities"
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

(defn analyzeEntitySentiment$
  "https://cloud.google.com/natural-language/api/reference/rest/v1/documents/analyzeEntitySentiment
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:document {:language string,
              :gcsContentUri string,
              :content string,
              :type string},
   :encodingType string}
  
  Finds entities, similar to AnalyzeEntities in the text and analyzes sentiment associated with each entity and its mentions."
  {:scopes ["https://www.googleapis.com/auth/cloud-language"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://language.googleapis.com/"
     "v1/documents:analyzeEntitySentiment"
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

(defn analyzeSyntax$
  "https://cloud.google.com/natural-language/api/reference/rest/v1/documents/analyzeSyntax
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:document {:language string,
              :gcsContentUri string,
              :content string,
              :type string},
   :encodingType string}
  
  Analyzes the syntax of the text and provides sentence boundaries and tokenization along with part of speech tags, dependency trees, and other properties."
  {:scopes ["https://www.googleapis.com/auth/cloud-language"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://language.googleapis.com/"
     "v1/documents:analyzeSyntax"
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

(defn annotateText$
  "https://cloud.google.com/natural-language/api/reference/rest/v1/documents/annotateText
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:features {:extractDocumentSentiment boolean,
              :extractEntitySentiment boolean,
              :extractEntities boolean,
              :classifyText boolean,
              :extractSyntax boolean},
   :document {:language string,
              :gcsContentUri string,
              :content string,
              :type string},
   :encodingType string}
  
  A convenience method that provides all the features that analyzeSentiment, analyzeEntities, and analyzeSyntax provide in one call."
  {:scopes ["https://www.googleapis.com/auth/cloud-language"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://language.googleapis.com/"
     "v1/documents:annotateText"
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

(defn analyzeSentiment$
  "https://cloud.google.com/natural-language/api/reference/rest/v1/documents/analyzeSentiment
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:encodingType string,
   :document {:language string,
              :gcsContentUri string,
              :content string,
              :type string}}
  
  Analyzes the sentiment of the provided text."
  {:scopes ["https://www.googleapis.com/auth/cloud-language"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://language.googleapis.com/"
     "v1/documents:analyzeSentiment"
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
