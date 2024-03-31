(ns happygapi.analytics.management
  "Google Analytics API: management.
  Views and manages your Google Analytics data.
  See: https://developers.google.com/analytics/api/reference/rest/v3/management"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn clientId-hashClientId$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/clientId/hashClientId
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:clientId string, :kind string, :webPropertyId string}
  
  Hashes the given Client ID."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/clientId:hashClientId"
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

(defn goals-get$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/goals/get
  
  Required parameters: accountId, goalId, profileId, webPropertyId
  
  Optional parameters: none
  
  Gets a goal to which the user has access."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:goalId :webPropertyId :profileId :accountId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}/goals/{goalId}"
     #{:goalId :webPropertyId :profileId :accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn goals-insert$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/goals/insert
  
  Required parameters: accountId, profileId, webPropertyId
  
  Optional parameters: none
  
  Body: 
  
  {:eventDetails {:eventConditions [{:comparisonType string,
                                     :comparisonValue string,
                                     :expression string,
                                     :matchType string,
                                     :type string}],
                  :useEventValue boolean},
   :updated string,
   :visitNumPagesDetails {:comparisonType string,
                          :comparisonValue string},
   :name string,
   :value number,
   :selfLink string,
   :type string,
   :urlDestinationDetails {:caseSensitive boolean,
                           :firstStepRequired boolean,
                           :matchType string,
                           :steps [{:name string,
                                    :number integer,
                                    :url string}],
                           :url string},
   :created string,
   :parentLink {:href string, :type string},
   :visitTimeOnSiteDetails {:comparisonType string,
                            :comparisonValue string},
   :webPropertyId string,
   :active boolean,
   :id string,
   :kind string,
   :internalWebPropertyId string,
   :profileId string,
   :accountId string}
  
  Create a new goal."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:webPropertyId :profileId :accountId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}/goals"
     #{:webPropertyId :profileId :accountId}
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

(defn goals-list$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/goals/list
  
  Required parameters: accountId, profileId, webPropertyId
  
  Optional parameters: max-results, start-index
  
  Lists goals to which the user has access."
  {:scopes ["https://www.googleapis.com/auth/analytics"
            "https://www.googleapis.com/auth/analytics.edit"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:webPropertyId :profileId :accountId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}/goals"
     #{:webPropertyId :profileId :accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn goals-patch$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/goals/patch
  
  Required parameters: accountId, goalId, profileId, webPropertyId
  
  Optional parameters: none
  
  Body: 
  
  {:eventDetails {:eventConditions [{:comparisonType string,
                                     :comparisonValue string,
                                     :expression string,
                                     :matchType string,
                                     :type string}],
                  :useEventValue boolean},
   :updated string,
   :visitNumPagesDetails {:comparisonType string,
                          :comparisonValue string},
   :name string,
   :value number,
   :selfLink string,
   :type string,
   :urlDestinationDetails {:caseSensitive boolean,
                           :firstStepRequired boolean,
                           :matchType string,
                           :steps [{:name string,
                                    :number integer,
                                    :url string}],
                           :url string},
   :created string,
   :parentLink {:href string, :type string},
   :visitTimeOnSiteDetails {:comparisonType string,
                            :comparisonValue string},
   :webPropertyId string,
   :active boolean,
   :id string,
   :kind string,
   :internalWebPropertyId string,
   :profileId string,
   :accountId string}
  
  Updates an existing goal. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:goalId :webPropertyId :profileId :accountId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}/goals/{goalId}"
     #{:goalId :webPropertyId :profileId :accountId}
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

(defn goals-update$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/goals/update
  
  Required parameters: accountId, goalId, profileId, webPropertyId
  
  Optional parameters: none
  
  Body: 
  
  {:eventDetails {:eventConditions [{:comparisonType string,
                                     :comparisonValue string,
                                     :expression string,
                                     :matchType string,
                                     :type string}],
                  :useEventValue boolean},
   :updated string,
   :visitNumPagesDetails {:comparisonType string,
                          :comparisonValue string},
   :name string,
   :value number,
   :selfLink string,
   :type string,
   :urlDestinationDetails {:caseSensitive boolean,
                           :firstStepRequired boolean,
                           :matchType string,
                           :steps [{:name string,
                                    :number integer,
                                    :url string}],
                           :url string},
   :created string,
   :parentLink {:href string, :type string},
   :visitTimeOnSiteDetails {:comparisonType string,
                            :comparisonValue string},
   :webPropertyId string,
   :active boolean,
   :id string,
   :kind string,
   :internalWebPropertyId string,
   :profileId string,
   :accountId string}
  
  Updates an existing goal."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:goalId :webPropertyId :profileId :accountId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}/goals/{goalId}"
     #{:goalId :webPropertyId :profileId :accountId}
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

(defn experiments-delete$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/experiments/delete
  
  Required parameters: accountId, experimentId, profileId, webPropertyId
  
  Optional parameters: none
  
  Delete an experiment."
  {:scopes ["https://www.googleapis.com/auth/analytics"
            "https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:webPropertyId :profileId :experimentId :accountId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}/experiments/{experimentId}"
     #{:webPropertyId :profileId :experimentId :accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn experiments-get$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/experiments/get
  
  Required parameters: accountId, experimentId, profileId, webPropertyId
  
  Optional parameters: none
  
  Returns an experiment to which the user has access."
  {:scopes ["https://www.googleapis.com/auth/analytics"
            "https://www.googleapis.com/auth/analytics.edit"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:webPropertyId :profileId :experimentId :accountId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}/experiments/{experimentId}"
     #{:webPropertyId :profileId :experimentId :accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn experiments-insert$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/experiments/insert
  
  Required parameters: accountId, profileId, webPropertyId
  
  Optional parameters: none
  
  Body: 
  
  {:description string,
   :equalWeighting boolean,
   :winnerFound boolean,
   :trafficCoverage number,
   :startTime string,
   :updated string,
   :name string,
   :rewriteVariationUrlsAsOriginal boolean,
   :endTime string,
   :snippet string,
   :selfLink string,
   :created string,
   :minimumExperimentLengthInDays integer,
   :parentLink {:href string, :type string},
   :webPropertyId string,
   :reasonExperimentEnded string,
   :objectiveMetric string,
   :winnerConfidenceLevel number,
   :editableInGaUi boolean,
   :status string,
   :id string,
   :kind string,
   :internalWebPropertyId string,
   :profileId string,
   :servingFramework string,
   :variations [{:name string,
                 :status string,
                 :url string,
                 :weight number,
                 :won boolean}],
   :accountId string,
   :optimizationType string}
  
  Create a new experiment."
  {:scopes ["https://www.googleapis.com/auth/analytics"
            "https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:webPropertyId :profileId :accountId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}/experiments"
     #{:webPropertyId :profileId :accountId}
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

(defn experiments-list$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/experiments/list
  
  Required parameters: accountId, profileId, webPropertyId
  
  Optional parameters: max-results, start-index
  
  Lists experiments to which the user has access."
  {:scopes ["https://www.googleapis.com/auth/analytics"
            "https://www.googleapis.com/auth/analytics.edit"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:webPropertyId :profileId :accountId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}/experiments"
     #{:webPropertyId :profileId :accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn experiments-patch$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/experiments/patch
  
  Required parameters: accountId, experimentId, profileId, webPropertyId
  
  Optional parameters: none
  
  Body: 
  
  {:description string,
   :equalWeighting boolean,
   :winnerFound boolean,
   :trafficCoverage number,
   :startTime string,
   :updated string,
   :name string,
   :rewriteVariationUrlsAsOriginal boolean,
   :endTime string,
   :snippet string,
   :selfLink string,
   :created string,
   :minimumExperimentLengthInDays integer,
   :parentLink {:href string, :type string},
   :webPropertyId string,
   :reasonExperimentEnded string,
   :objectiveMetric string,
   :winnerConfidenceLevel number,
   :editableInGaUi boolean,
   :status string,
   :id string,
   :kind string,
   :internalWebPropertyId string,
   :profileId string,
   :servingFramework string,
   :variations [{:name string,
                 :status string,
                 :url string,
                 :weight number,
                 :won boolean}],
   :accountId string,
   :optimizationType string}
  
  Update an existing experiment. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/analytics"
            "https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:webPropertyId :profileId :experimentId :accountId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}/experiments/{experimentId}"
     #{:webPropertyId :profileId :experimentId :accountId}
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

(defn experiments-update$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/experiments/update
  
  Required parameters: accountId, experimentId, profileId, webPropertyId
  
  Optional parameters: none
  
  Body: 
  
  {:description string,
   :equalWeighting boolean,
   :winnerFound boolean,
   :trafficCoverage number,
   :startTime string,
   :updated string,
   :name string,
   :rewriteVariationUrlsAsOriginal boolean,
   :endTime string,
   :snippet string,
   :selfLink string,
   :created string,
   :minimumExperimentLengthInDays integer,
   :parentLink {:href string, :type string},
   :webPropertyId string,
   :reasonExperimentEnded string,
   :objectiveMetric string,
   :winnerConfidenceLevel number,
   :editableInGaUi boolean,
   :status string,
   :id string,
   :kind string,
   :internalWebPropertyId string,
   :profileId string,
   :servingFramework string,
   :variations [{:name string,
                 :status string,
                 :url string,
                 :weight number,
                 :won boolean}],
   :accountId string,
   :optimizationType string}
  
  Update an existing experiment."
  {:scopes ["https://www.googleapis.com/auth/analytics"
            "https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:webPropertyId :profileId :experimentId :accountId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}/experiments/{experimentId}"
     #{:webPropertyId :profileId :experimentId :accountId}
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

(defn profileFilterLinks-delete$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/profileFilterLinks/delete
  
  Required parameters: accountId, linkId, profileId, webPropertyId
  
  Optional parameters: none
  
  Delete a profile filter link."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:linkId :webPropertyId :profileId :accountId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}/profileFilterLinks/{linkId}"
     #{:linkId :webPropertyId :profileId :accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn profileFilterLinks-get$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/profileFilterLinks/get
  
  Required parameters: accountId, linkId, profileId, webPropertyId
  
  Optional parameters: none
  
  Returns a single profile filter link."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:linkId :webPropertyId :profileId :accountId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}/profileFilterLinks/{linkId}"
     #{:linkId :webPropertyId :profileId :accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn profileFilterLinks-insert$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/profileFilterLinks/insert
  
  Required parameters: accountId, profileId, webPropertyId
  
  Optional parameters: none
  
  Body: 
  
  {:filterRef {:accountId string,
               :href string,
               :id string,
               :kind string,
               :name string},
   :id string,
   :kind string,
   :profileRef {:accountId string,
                :href string,
                :id string,
                :internalWebPropertyId string,
                :kind string,
                :name string,
                :webPropertyId string},
   :rank integer,
   :selfLink string}
  
  Create a new profile filter link."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:webPropertyId :profileId :accountId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}/profileFilterLinks"
     #{:webPropertyId :profileId :accountId}
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

(defn profileFilterLinks-list$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/profileFilterLinks/list
  
  Required parameters: accountId, profileId, webPropertyId
  
  Optional parameters: max-results, start-index
  
  Lists all profile filter links for a profile."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:webPropertyId :profileId :accountId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}/profileFilterLinks"
     #{:webPropertyId :profileId :accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn profileFilterLinks-patch$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/profileFilterLinks/patch
  
  Required parameters: accountId, linkId, profileId, webPropertyId
  
  Optional parameters: none
  
  Body: 
  
  {:filterRef {:accountId string,
               :href string,
               :id string,
               :kind string,
               :name string},
   :id string,
   :kind string,
   :profileRef {:accountId string,
                :href string,
                :id string,
                :internalWebPropertyId string,
                :kind string,
                :name string,
                :webPropertyId string},
   :rank integer,
   :selfLink string}
  
  Update an existing profile filter link. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:linkId :webPropertyId :profileId :accountId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}/profileFilterLinks/{linkId}"
     #{:linkId :webPropertyId :profileId :accountId}
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

(defn profileFilterLinks-update$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/profileFilterLinks/update
  
  Required parameters: accountId, linkId, profileId, webPropertyId
  
  Optional parameters: none
  
  Body: 
  
  {:filterRef {:accountId string,
               :href string,
               :id string,
               :kind string,
               :name string},
   :id string,
   :kind string,
   :profileRef {:accountId string,
                :href string,
                :id string,
                :internalWebPropertyId string,
                :kind string,
                :name string,
                :webPropertyId string},
   :rank integer,
   :selfLink string}
  
  Update an existing profile filter link."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:linkId :webPropertyId :profileId :accountId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}/profileFilterLinks/{linkId}"
     #{:linkId :webPropertyId :profileId :accountId}
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

(defn filters-delete$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/filters/delete
  
  Required parameters: accountId, filterId
  
  Optional parameters: none
  
  Delete a filter."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:filterId :accountId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/filters/{filterId}"
     #{:filterId :accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn filters-get$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/filters/get
  
  Required parameters: accountId, filterId
  
  Optional parameters: none
  
  Returns filters to which the user has access."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:filterId :accountId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/filters/{filterId}"
     #{:filterId :accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn filters-insert$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/filters/insert
  
  Required parameters: accountId
  
  Optional parameters: none
  
  Body: 
  
  {:advancedDetails {:fieldAIndex integer,
                     :outputToFieldIndex integer,
                     :fieldA string,
                     :extractB string,
                     :fieldB string,
                     :outputConstructor string,
                     :outputToField string,
                     :fieldBRequired boolean,
                     :fieldARequired boolean,
                     :extractA string,
                     :caseSensitive boolean,
                     :overrideOutputField boolean,
                     :fieldBIndex integer},
   :searchAndReplaceDetails {:caseSensitive boolean,
                             :field string,
                             :fieldIndex integer,
                             :replaceString string,
                             :searchString string},
   :updated string,
   :name string,
   :selfLink string,
   :type string,
   :created string,
   :parentLink {:href string, :type string},
   :uppercaseDetails {:field string, :fieldIndex integer},
   :lowercaseDetails {:field string, :fieldIndex integer},
   :id string,
   :kind string,
   :includeDetails {:caseSensitive boolean,
                    :expressionValue string,
                    :field string,
                    :fieldIndex integer,
                    :kind string,
                    :matchType string},
   :excludeDetails {:caseSensitive boolean,
                    :expressionValue string,
                    :field string,
                    :fieldIndex integer,
                    :kind string,
                    :matchType string},
   :accountId string}
  
  Create a new filter."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:accountId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/filters"
     #{:accountId}
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

(defn filters-list$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/filters/list
  
  Required parameters: accountId
  
  Optional parameters: max-results, start-index
  
  Lists all filters for an account"
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:accountId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/filters"
     #{:accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn filters-patch$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/filters/patch
  
  Required parameters: accountId, filterId
  
  Optional parameters: none
  
  Body: 
  
  {:advancedDetails {:fieldAIndex integer,
                     :outputToFieldIndex integer,
                     :fieldA string,
                     :extractB string,
                     :fieldB string,
                     :outputConstructor string,
                     :outputToField string,
                     :fieldBRequired boolean,
                     :fieldARequired boolean,
                     :extractA string,
                     :caseSensitive boolean,
                     :overrideOutputField boolean,
                     :fieldBIndex integer},
   :searchAndReplaceDetails {:caseSensitive boolean,
                             :field string,
                             :fieldIndex integer,
                             :replaceString string,
                             :searchString string},
   :updated string,
   :name string,
   :selfLink string,
   :type string,
   :created string,
   :parentLink {:href string, :type string},
   :uppercaseDetails {:field string, :fieldIndex integer},
   :lowercaseDetails {:field string, :fieldIndex integer},
   :id string,
   :kind string,
   :includeDetails {:caseSensitive boolean,
                    :expressionValue string,
                    :field string,
                    :fieldIndex integer,
                    :kind string,
                    :matchType string},
   :excludeDetails {:caseSensitive boolean,
                    :expressionValue string,
                    :field string,
                    :fieldIndex integer,
                    :kind string,
                    :matchType string},
   :accountId string}
  
  Updates an existing filter. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:filterId :accountId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/filters/{filterId}"
     #{:filterId :accountId}
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

(defn filters-update$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/filters/update
  
  Required parameters: accountId, filterId
  
  Optional parameters: none
  
  Body: 
  
  {:advancedDetails {:fieldAIndex integer,
                     :outputToFieldIndex integer,
                     :fieldA string,
                     :extractB string,
                     :fieldB string,
                     :outputConstructor string,
                     :outputToField string,
                     :fieldBRequired boolean,
                     :fieldARequired boolean,
                     :extractA string,
                     :caseSensitive boolean,
                     :overrideOutputField boolean,
                     :fieldBIndex integer},
   :searchAndReplaceDetails {:caseSensitive boolean,
                             :field string,
                             :fieldIndex integer,
                             :replaceString string,
                             :searchString string},
   :updated string,
   :name string,
   :selfLink string,
   :type string,
   :created string,
   :parentLink {:href string, :type string},
   :uppercaseDetails {:field string, :fieldIndex integer},
   :lowercaseDetails {:field string, :fieldIndex integer},
   :id string,
   :kind string,
   :includeDetails {:caseSensitive boolean,
                    :expressionValue string,
                    :field string,
                    :fieldIndex integer,
                    :kind string,
                    :matchType string},
   :excludeDetails {:caseSensitive boolean,
                    :expressionValue string,
                    :field string,
                    :fieldIndex integer,
                    :kind string,
                    :matchType string},
   :accountId string}
  
  Updates an existing filter."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:filterId :accountId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/filters/{filterId}"
     #{:filterId :accountId}
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

(defn customMetrics-get$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/customMetrics/get
  
  Required parameters: accountId, customMetricId, webPropertyId
  
  Optional parameters: none
  
  Get a custom metric to which the user has access."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:customMetricId :webPropertyId :accountId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/customMetrics/{customMetricId}"
     #{:customMetricId :webPropertyId :accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn customMetrics-insert$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/customMetrics/insert
  
  Required parameters: accountId, webPropertyId
  
  Optional parameters: none
  
  Body: 
  
  {:max_value string,
   :index integer,
   :updated string,
   :name string,
   :selfLink string,
   :type string,
   :created string,
   :scope string,
   :parentLink {:href string, :type string},
   :webPropertyId string,
   :min_value string,
   :active boolean,
   :id string,
   :kind string,
   :accountId string}
  
  Create a new custom metric."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:webPropertyId :accountId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/customMetrics"
     #{:webPropertyId :accountId}
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

(defn customMetrics-list$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/customMetrics/list
  
  Required parameters: accountId, webPropertyId
  
  Optional parameters: max-results, start-index
  
  Lists custom metrics to which the user has access."
  {:scopes ["https://www.googleapis.com/auth/analytics"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:webPropertyId :accountId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/customMetrics"
     #{:webPropertyId :accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn customMetrics-patch$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/customMetrics/patch
  
  Required parameters: accountId, customMetricId, webPropertyId
  
  Optional parameters: ignoreCustomDataSourceLinks
  
  Body: 
  
  {:max_value string,
   :index integer,
   :updated string,
   :name string,
   :selfLink string,
   :type string,
   :created string,
   :scope string,
   :parentLink {:href string, :type string},
   :webPropertyId string,
   :min_value string,
   :active boolean,
   :id string,
   :kind string,
   :accountId string}
  
  Updates an existing custom metric. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:customMetricId :webPropertyId :accountId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/customMetrics/{customMetricId}"
     #{:customMetricId :webPropertyId :accountId}
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

(defn customMetrics-update$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/customMetrics/update
  
  Required parameters: accountId, customMetricId, webPropertyId
  
  Optional parameters: ignoreCustomDataSourceLinks
  
  Body: 
  
  {:max_value string,
   :index integer,
   :updated string,
   :name string,
   :selfLink string,
   :type string,
   :created string,
   :scope string,
   :parentLink {:href string, :type string},
   :webPropertyId string,
   :min_value string,
   :active boolean,
   :id string,
   :kind string,
   :accountId string}
  
  Updates an existing custom metric."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:customMetricId :webPropertyId :accountId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/customMetrics/{customMetricId}"
     #{:customMetricId :webPropertyId :accountId}
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

(defn webpropertyUserLinks-delete$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/webpropertyUserLinks/delete
  
  Required parameters: accountId, linkId, webPropertyId
  
  Optional parameters: none
  
  Removes a user from the given web property."
  {:scopes ["https://www.googleapis.com/auth/analytics.manage.users"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:linkId :webPropertyId :accountId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/entityUserLinks/{linkId}"
     #{:linkId :webPropertyId :accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn webpropertyUserLinks-insert$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/webpropertyUserLinks/insert
  
  Required parameters: accountId, webPropertyId
  
  Optional parameters: none
  
  Body: 
  
  {:entity {:accountRef {:href string,
                         :id string,
                         :kind string,
                         :name string},
            :profileRef {:accountId string,
                         :href string,
                         :id string,
                         :internalWebPropertyId string,
                         :kind string,
                         :name string,
                         :webPropertyId string},
            :webPropertyRef {:accountId string,
                             :href string,
                             :id string,
                             :internalWebPropertyId string,
                             :kind string,
                             :name string}},
   :id string,
   :kind string,
   :permissions {:effective [string], :local [string]},
   :selfLink string,
   :userRef {:email string, :id string, :kind string}}
  
  Adds a new user to the given web property."
  {:scopes ["https://www.googleapis.com/auth/analytics.manage.users"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:webPropertyId :accountId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/entityUserLinks"
     #{:webPropertyId :accountId}
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

(defn webpropertyUserLinks-list$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/webpropertyUserLinks/list
  
  Required parameters: accountId, webPropertyId
  
  Optional parameters: max-results, start-index
  
  Lists webProperty-user links for a given web property."
  {:scopes ["https://www.googleapis.com/auth/analytics.manage.users"
            "https://www.googleapis.com/auth/analytics.manage.users.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:webPropertyId :accountId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/entityUserLinks"
     #{:webPropertyId :accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn webpropertyUserLinks-update$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/webpropertyUserLinks/update
  
  Required parameters: accountId, linkId, webPropertyId
  
  Optional parameters: none
  
  Body: 
  
  {:entity {:accountRef {:href string,
                         :id string,
                         :kind string,
                         :name string},
            :profileRef {:accountId string,
                         :href string,
                         :id string,
                         :internalWebPropertyId string,
                         :kind string,
                         :name string,
                         :webPropertyId string},
            :webPropertyRef {:accountId string,
                             :href string,
                             :id string,
                             :internalWebPropertyId string,
                             :kind string,
                             :name string}},
   :id string,
   :kind string,
   :permissions {:effective [string], :local [string]},
   :selfLink string,
   :userRef {:email string, :id string, :kind string}}
  
  Updates permissions for an existing user on the given web property."
  {:scopes ["https://www.googleapis.com/auth/analytics.manage.users"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:linkId :webPropertyId :accountId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/entityUserLinks/{linkId}"
     #{:linkId :webPropertyId :accountId}
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

(defn webPropertyAdWordsLinks-delete$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/webPropertyAdWordsLinks/delete
  
  Required parameters: accountId, webPropertyAdWordsLinkId, webPropertyId
  
  Optional parameters: none
  
  Deletes a web property-Google Ads link."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:webPropertyAdWordsLinkId :webPropertyId :accountId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/entityAdWordsLinks/{webPropertyAdWordsLinkId}"
     #{:webPropertyAdWordsLinkId :webPropertyId :accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn webPropertyAdWordsLinks-get$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/webPropertyAdWordsLinks/get
  
  Required parameters: accountId, webPropertyAdWordsLinkId, webPropertyId
  
  Optional parameters: none
  
  Returns a web property-Google Ads link to which the user has access."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:webPropertyAdWordsLinkId :webPropertyId :accountId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/entityAdWordsLinks/{webPropertyAdWordsLinkId}"
     #{:webPropertyAdWordsLinkId :webPropertyId :accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn webPropertyAdWordsLinks-insert$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/webPropertyAdWordsLinks/insert
  
  Required parameters: accountId, webPropertyId
  
  Optional parameters: none
  
  Body: 
  
  {:adWordsAccounts [{:autoTaggingEnabled boolean,
                      :customerId string,
                      :kind string}],
   :entity {:webPropertyRef {:accountId string,
                             :href string,
                             :id string,
                             :internalWebPropertyId string,
                             :kind string,
                             :name string}},
   :id string,
   :kind string,
   :name string,
   :profileIds [string],
   :selfLink string}
  
  Creates a webProperty-Google Ads link."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:webPropertyId :accountId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/entityAdWordsLinks"
     #{:webPropertyId :accountId}
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

(defn webPropertyAdWordsLinks-list$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/webPropertyAdWordsLinks/list
  
  Required parameters: accountId, webPropertyId
  
  Optional parameters: max-results, start-index
  
  Lists webProperty-Google Ads links for a given web property."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:webPropertyId :accountId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/entityAdWordsLinks"
     #{:webPropertyId :accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn webPropertyAdWordsLinks-patch$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/webPropertyAdWordsLinks/patch
  
  Required parameters: accountId, webPropertyAdWordsLinkId, webPropertyId
  
  Optional parameters: none
  
  Body: 
  
  {:adWordsAccounts [{:autoTaggingEnabled boolean,
                      :customerId string,
                      :kind string}],
   :entity {:webPropertyRef {:accountId string,
                             :href string,
                             :id string,
                             :internalWebPropertyId string,
                             :kind string,
                             :name string}},
   :id string,
   :kind string,
   :name string,
   :profileIds [string],
   :selfLink string}
  
  Updates an existing webProperty-Google Ads link. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:webPropertyAdWordsLinkId :webPropertyId :accountId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/entityAdWordsLinks/{webPropertyAdWordsLinkId}"
     #{:webPropertyAdWordsLinkId :webPropertyId :accountId}
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

(defn webPropertyAdWordsLinks-update$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/webPropertyAdWordsLinks/update
  
  Required parameters: accountId, webPropertyAdWordsLinkId, webPropertyId
  
  Optional parameters: none
  
  Body: 
  
  {:adWordsAccounts [{:autoTaggingEnabled boolean,
                      :customerId string,
                      :kind string}],
   :entity {:webPropertyRef {:accountId string,
                             :href string,
                             :id string,
                             :internalWebPropertyId string,
                             :kind string,
                             :name string}},
   :id string,
   :kind string,
   :name string,
   :profileIds [string],
   :selfLink string}
  
  Updates an existing webProperty-Google Ads link."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:webPropertyAdWordsLinkId :webPropertyId :accountId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/entityAdWordsLinks/{webPropertyAdWordsLinkId}"
     #{:webPropertyAdWordsLinkId :webPropertyId :accountId}
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

(defn webproperties-get$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/webproperties/get
  
  Required parameters: accountId, webPropertyId
  
  Optional parameters: none
  
  Gets a web property to which the user has access."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:webPropertyId :accountId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}"
     #{:webPropertyId :accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn webproperties-insert$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/webproperties/insert
  
  Required parameters: accountId
  
  Optional parameters: none
  
  Body: 
  
  {:permissions {:effective [string]},
   :defaultProfileId string,
   :starred boolean,
   :websiteUrl string,
   :updated string,
   :name string,
   :industryVertical string,
   :selfLink string,
   :created string,
   :parentLink {:href string, :type string},
   :level string,
   :id string,
   :kind string,
   :childLink {:href string, :type string},
   :internalWebPropertyId string,
   :dataRetentionTtl string,
   :profileCount integer,
   :dataRetentionResetOnNewActivity boolean,
   :accountId string}
  
  Create a new property if the account has fewer than 20 properties. Web properties are visible in the Google Analytics interface only if they have at least one profile."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:accountId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties"
     #{:accountId}
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

(defn webproperties-list$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/webproperties/list
  
  Required parameters: accountId
  
  Optional parameters: max-results, start-index
  
  Lists web properties to which the user has access."
  {:scopes ["https://www.googleapis.com/auth/analytics"
            "https://www.googleapis.com/auth/analytics.edit"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:accountId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties"
     #{:accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn webproperties-patch$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/webproperties/patch
  
  Required parameters: accountId, webPropertyId
  
  Optional parameters: none
  
  Body: 
  
  {:permissions {:effective [string]},
   :defaultProfileId string,
   :starred boolean,
   :websiteUrl string,
   :updated string,
   :name string,
   :industryVertical string,
   :selfLink string,
   :created string,
   :parentLink {:href string, :type string},
   :level string,
   :id string,
   :kind string,
   :childLink {:href string, :type string},
   :internalWebPropertyId string,
   :dataRetentionTtl string,
   :profileCount integer,
   :dataRetentionResetOnNewActivity boolean,
   :accountId string}
  
  Updates an existing web property. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:webPropertyId :accountId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}"
     #{:webPropertyId :accountId}
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

(defn webproperties-update$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/webproperties/update
  
  Required parameters: accountId, webPropertyId
  
  Optional parameters: none
  
  Body: 
  
  {:permissions {:effective [string]},
   :defaultProfileId string,
   :starred boolean,
   :websiteUrl string,
   :updated string,
   :name string,
   :industryVertical string,
   :selfLink string,
   :created string,
   :parentLink {:href string, :type string},
   :level string,
   :id string,
   :kind string,
   :childLink {:href string, :type string},
   :internalWebPropertyId string,
   :dataRetentionTtl string,
   :profileCount integer,
   :dataRetentionResetOnNewActivity boolean,
   :accountId string}
  
  Updates an existing web property."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:webPropertyId :accountId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}"
     #{:webPropertyId :accountId}
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

(defn customDimensions-get$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/customDimensions/get
  
  Required parameters: accountId, customDimensionId, webPropertyId
  
  Optional parameters: none
  
  Get a custom dimension to which the user has access."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:customDimensionId :webPropertyId :accountId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/customDimensions/{customDimensionId}"
     #{:customDimensionId :webPropertyId :accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn customDimensions-insert$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/customDimensions/insert
  
  Required parameters: accountId, webPropertyId
  
  Optional parameters: none
  
  Body: 
  
  {:index integer,
   :updated string,
   :name string,
   :selfLink string,
   :created string,
   :scope string,
   :parentLink {:href string, :type string},
   :webPropertyId string,
   :active boolean,
   :id string,
   :kind string,
   :accountId string}
  
  Create a new custom dimension."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:webPropertyId :accountId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/customDimensions"
     #{:webPropertyId :accountId}
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

(defn customDimensions-list$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/customDimensions/list
  
  Required parameters: accountId, webPropertyId
  
  Optional parameters: max-results, start-index
  
  Lists custom dimensions to which the user has access."
  {:scopes ["https://www.googleapis.com/auth/analytics"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:webPropertyId :accountId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/customDimensions"
     #{:webPropertyId :accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn customDimensions-patch$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/customDimensions/patch
  
  Required parameters: accountId, customDimensionId, webPropertyId
  
  Optional parameters: ignoreCustomDataSourceLinks
  
  Body: 
  
  {:index integer,
   :updated string,
   :name string,
   :selfLink string,
   :created string,
   :scope string,
   :parentLink {:href string, :type string},
   :webPropertyId string,
   :active boolean,
   :id string,
   :kind string,
   :accountId string}
  
  Updates an existing custom dimension. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:customDimensionId :webPropertyId :accountId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/customDimensions/{customDimensionId}"
     #{:customDimensionId :webPropertyId :accountId}
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

(defn customDimensions-update$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/customDimensions/update
  
  Required parameters: accountId, customDimensionId, webPropertyId
  
  Optional parameters: ignoreCustomDataSourceLinks
  
  Body: 
  
  {:index integer,
   :updated string,
   :name string,
   :selfLink string,
   :created string,
   :scope string,
   :parentLink {:href string, :type string},
   :webPropertyId string,
   :active boolean,
   :id string,
   :kind string,
   :accountId string}
  
  Updates an existing custom dimension."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:customDimensionId :webPropertyId :accountId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/customDimensions/{customDimensionId}"
     #{:customDimensionId :webPropertyId :accountId}
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

(defn segments-list$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/segments/list
  
  Required parameters: none
  
  Optional parameters: max-results, start-index
  
  Lists segments to which the user has access."
  {:scopes ["https://www.googleapis.com/auth/analytics"
            "https://www.googleapis.com/auth/analytics.edit"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/segments"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn accountSummaries-list$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/accountSummaries/list
  
  Required parameters: none
  
  Optional parameters: max-results, start-index
  
  Lists account summaries (lightweight tree comprised of accounts/properties/profiles) to which the user has access."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accountSummaries"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn accountUserLinks-delete$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/accountUserLinks/delete
  
  Required parameters: accountId, linkId
  
  Optional parameters: none
  
  Removes a user from the given account."
  {:scopes ["https://www.googleapis.com/auth/analytics.manage.users"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:linkId :accountId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/entityUserLinks/{linkId}"
     #{:linkId :accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn accountUserLinks-insert$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/accountUserLinks/insert
  
  Required parameters: accountId
  
  Optional parameters: none
  
  Body: 
  
  {:entity {:accountRef {:href string,
                         :id string,
                         :kind string,
                         :name string},
            :profileRef {:accountId string,
                         :href string,
                         :id string,
                         :internalWebPropertyId string,
                         :kind string,
                         :name string,
                         :webPropertyId string},
            :webPropertyRef {:accountId string,
                             :href string,
                             :id string,
                             :internalWebPropertyId string,
                             :kind string,
                             :name string}},
   :id string,
   :kind string,
   :permissions {:effective [string], :local [string]},
   :selfLink string,
   :userRef {:email string, :id string, :kind string}}
  
  Adds a new user to the given account."
  {:scopes ["https://www.googleapis.com/auth/analytics.manage.users"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:accountId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/entityUserLinks"
     #{:accountId}
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

(defn accountUserLinks-list$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/accountUserLinks/list
  
  Required parameters: accountId
  
  Optional parameters: max-results, start-index
  
  Lists account-user links for a given account."
  {:scopes ["https://www.googleapis.com/auth/analytics.manage.users"
            "https://www.googleapis.com/auth/analytics.manage.users.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:accountId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/entityUserLinks"
     #{:accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn accountUserLinks-update$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/accountUserLinks/update
  
  Required parameters: accountId, linkId
  
  Optional parameters: none
  
  Body: 
  
  {:entity {:accountRef {:href string,
                         :id string,
                         :kind string,
                         :name string},
            :profileRef {:accountId string,
                         :href string,
                         :id string,
                         :internalWebPropertyId string,
                         :kind string,
                         :name string,
                         :webPropertyId string},
            :webPropertyRef {:accountId string,
                             :href string,
                             :id string,
                             :internalWebPropertyId string,
                             :kind string,
                             :name string}},
   :id string,
   :kind string,
   :permissions {:effective [string], :local [string]},
   :selfLink string,
   :userRef {:email string, :id string, :kind string}}
  
  Updates permissions for an existing user on the given account."
  {:scopes ["https://www.googleapis.com/auth/analytics.manage.users"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:linkId :accountId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/entityUserLinks/{linkId}"
     #{:linkId :accountId}
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

(defn profileUserLinks-delete$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/profileUserLinks/delete
  
  Required parameters: accountId, linkId, profileId, webPropertyId
  
  Optional parameters: none
  
  Removes a user from the given view (profile)."
  {:scopes ["https://www.googleapis.com/auth/analytics.manage.users"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:linkId :webPropertyId :profileId :accountId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}/entityUserLinks/{linkId}"
     #{:linkId :webPropertyId :profileId :accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn profileUserLinks-insert$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/profileUserLinks/insert
  
  Required parameters: accountId, profileId, webPropertyId
  
  Optional parameters: none
  
  Body: 
  
  {:entity {:accountRef {:href string,
                         :id string,
                         :kind string,
                         :name string},
            :profileRef {:accountId string,
                         :href string,
                         :id string,
                         :internalWebPropertyId string,
                         :kind string,
                         :name string,
                         :webPropertyId string},
            :webPropertyRef {:accountId string,
                             :href string,
                             :id string,
                             :internalWebPropertyId string,
                             :kind string,
                             :name string}},
   :id string,
   :kind string,
   :permissions {:effective [string], :local [string]},
   :selfLink string,
   :userRef {:email string, :id string, :kind string}}
  
  Adds a new user to the given view (profile)."
  {:scopes ["https://www.googleapis.com/auth/analytics.manage.users"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:webPropertyId :profileId :accountId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}/entityUserLinks"
     #{:webPropertyId :profileId :accountId}
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

(defn profileUserLinks-list$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/profileUserLinks/list
  
  Required parameters: accountId, profileId, webPropertyId
  
  Optional parameters: max-results, start-index
  
  Lists profile-user links for a given view (profile)."
  {:scopes ["https://www.googleapis.com/auth/analytics.manage.users"
            "https://www.googleapis.com/auth/analytics.manage.users.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:webPropertyId :profileId :accountId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}/entityUserLinks"
     #{:webPropertyId :profileId :accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn profileUserLinks-update$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/profileUserLinks/update
  
  Required parameters: accountId, linkId, profileId, webPropertyId
  
  Optional parameters: none
  
  Body: 
  
  {:entity {:accountRef {:href string,
                         :id string,
                         :kind string,
                         :name string},
            :profileRef {:accountId string,
                         :href string,
                         :id string,
                         :internalWebPropertyId string,
                         :kind string,
                         :name string,
                         :webPropertyId string},
            :webPropertyRef {:accountId string,
                             :href string,
                             :id string,
                             :internalWebPropertyId string,
                             :kind string,
                             :name string}},
   :id string,
   :kind string,
   :permissions {:effective [string], :local [string]},
   :selfLink string,
   :userRef {:email string, :id string, :kind string}}
  
  Updates permissions for an existing user on the given view (profile)."
  {:scopes ["https://www.googleapis.com/auth/analytics.manage.users"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:linkId :webPropertyId :profileId :accountId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}/entityUserLinks/{linkId}"
     #{:linkId :webPropertyId :profileId :accountId}
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

(defn uploads-deleteUploadData$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/uploads/deleteUploadData
  
  Required parameters: accountId, customDataSourceId, webPropertyId
  
  Optional parameters: none
  
  Body: 
  
  {:customDataImportUids [string]}
  
  Delete data associated with a previous upload."
  {:scopes ["https://www.googleapis.com/auth/analytics"
            "https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:webPropertyId :accountId :customDataSourceId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/customDataSources/{customDataSourceId}/deleteUploadData"
     #{:webPropertyId :accountId :customDataSourceId}
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

(defn uploads-get$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/uploads/get
  
  Required parameters: accountId, customDataSourceId, uploadId, webPropertyId
  
  Optional parameters: none
  
  List uploads to which the user has access."
  {:scopes ["https://www.googleapis.com/auth/analytics"
            "https://www.googleapis.com/auth/analytics.edit"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:uploadId :webPropertyId :accountId :customDataSourceId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/customDataSources/{customDataSourceId}/uploads/{uploadId}"
     #{:uploadId :webPropertyId :accountId :customDataSourceId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn uploads-list$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/uploads/list
  
  Required parameters: accountId, customDataSourceId, webPropertyId
  
  Optional parameters: max-results, start-index
  
  List uploads to which the user has access."
  {:scopes ["https://www.googleapis.com/auth/analytics"
            "https://www.googleapis.com/auth/analytics.edit"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:webPropertyId :accountId :customDataSourceId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/customDataSources/{customDataSourceId}/uploads"
     #{:webPropertyId :accountId :customDataSourceId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn uploads-uploadData$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/uploads/uploadData
  
  Required parameters: accountId, customDataSourceId, webPropertyId
  
  Optional parameters: none
  
  Upload data for a custom data source."
  {:scopes ["https://www.googleapis.com/auth/analytics"
            "https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:webPropertyId :accountId :customDataSourceId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/customDataSources/{customDataSourceId}/uploads"
     #{:webPropertyId :accountId :customDataSourceId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn customDataSources-list$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/customDataSources/list
  
  Required parameters: accountId, webPropertyId
  
  Optional parameters: max-results, start-index
  
  List custom data sources to which the user has access."
  {:scopes ["https://www.googleapis.com/auth/analytics"
            "https://www.googleapis.com/auth/analytics.edit"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:webPropertyId :accountId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/customDataSources"
     #{:webPropertyId :accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn profiles-delete$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/profiles/delete
  
  Required parameters: accountId, profileId, webPropertyId
  
  Optional parameters: none
  
  Deletes a view (profile)."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:webPropertyId :profileId :accountId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}"
     #{:webPropertyId :profileId :accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn profiles-get$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/profiles/get
  
  Required parameters: accountId, profileId, webPropertyId
  
  Optional parameters: none
  
  Gets a view (profile) to which the user has access."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:webPropertyId :profileId :accountId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}"
     #{:webPropertyId :profileId :accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn profiles-insert$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/profiles/insert
  
  Required parameters: accountId, webPropertyId
  
  Optional parameters: none
  
  Body: 
  
  {:timezone string,
   :permissions {:effective [string]},
   :starred boolean,
   :websiteUrl string,
   :botFilteringEnabled boolean,
   :updated string,
   :name string,
   :defaultPage string,
   :selfLink string,
   :type string,
   :created string,
   :parentLink {:href string, :type string},
   :webPropertyId string,
   :stripSiteSearchCategoryParameters boolean,
   :siteSearchCategoryParameters string,
   :currency string,
   :enhancedECommerceTracking boolean,
   :id string,
   :kind string,
   :childLink {:href string, :type string},
   :internalWebPropertyId string,
   :stripSiteSearchQueryParameters boolean,
   :excludeQueryParameters string,
   :accountId string,
   :eCommerceTracking boolean,
   :siteSearchQueryParameters string}
  
  Create a new view (profile)."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:webPropertyId :accountId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/profiles"
     #{:webPropertyId :accountId}
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

(defn profiles-list$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/profiles/list
  
  Required parameters: accountId, webPropertyId
  
  Optional parameters: max-results, start-index
  
  Lists views (profiles) to which the user has access."
  {:scopes ["https://www.googleapis.com/auth/analytics"
            "https://www.googleapis.com/auth/analytics.edit"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:webPropertyId :accountId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/profiles"
     #{:webPropertyId :accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn profiles-patch$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/profiles/patch
  
  Required parameters: accountId, profileId, webPropertyId
  
  Optional parameters: none
  
  Body: 
  
  {:timezone string,
   :permissions {:effective [string]},
   :starred boolean,
   :websiteUrl string,
   :botFilteringEnabled boolean,
   :updated string,
   :name string,
   :defaultPage string,
   :selfLink string,
   :type string,
   :created string,
   :parentLink {:href string, :type string},
   :webPropertyId string,
   :stripSiteSearchCategoryParameters boolean,
   :siteSearchCategoryParameters string,
   :currency string,
   :enhancedECommerceTracking boolean,
   :id string,
   :kind string,
   :childLink {:href string, :type string},
   :internalWebPropertyId string,
   :stripSiteSearchQueryParameters boolean,
   :excludeQueryParameters string,
   :accountId string,
   :eCommerceTracking boolean,
   :siteSearchQueryParameters string}
  
  Updates an existing view (profile). This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:webPropertyId :profileId :accountId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}"
     #{:webPropertyId :profileId :accountId}
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

(defn profiles-update$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/profiles/update
  
  Required parameters: accountId, profileId, webPropertyId
  
  Optional parameters: none
  
  Body: 
  
  {:timezone string,
   :permissions {:effective [string]},
   :starred boolean,
   :websiteUrl string,
   :botFilteringEnabled boolean,
   :updated string,
   :name string,
   :defaultPage string,
   :selfLink string,
   :type string,
   :created string,
   :parentLink {:href string, :type string},
   :webPropertyId string,
   :stripSiteSearchCategoryParameters boolean,
   :siteSearchCategoryParameters string,
   :currency string,
   :enhancedECommerceTracking boolean,
   :id string,
   :kind string,
   :childLink {:href string, :type string},
   :internalWebPropertyId string,
   :stripSiteSearchQueryParameters boolean,
   :excludeQueryParameters string,
   :accountId string,
   :eCommerceTracking boolean,
   :siteSearchQueryParameters string}
  
  Updates an existing view (profile)."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:webPropertyId :profileId :accountId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}"
     #{:webPropertyId :profileId :accountId}
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

(defn remarketingAudience-delete$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/remarketingAudience/delete
  
  Required parameters: accountId, remarketingAudienceId, webPropertyId
  
  Optional parameters: none
  
  Delete a remarketing audience."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:webPropertyId :remarketingAudienceId :accountId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/remarketingAudiences/{remarketingAudienceId}"
     #{:webPropertyId :remarketingAudienceId :accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn remarketingAudience-get$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/remarketingAudience/get
  
  Required parameters: accountId, remarketingAudienceId, webPropertyId
  
  Optional parameters: none
  
  Gets a remarketing audience to which the user has access."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:webPropertyId :remarketingAudienceId :accountId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/remarketingAudiences/{remarketingAudienceId}"
     #{:webPropertyId :remarketingAudienceId :accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn remarketingAudience-insert$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/remarketingAudience/insert
  
  Required parameters: accountId, webPropertyId
  
  Optional parameters: none
  
  Body: 
  
  {:description string,
   :updated string,
   :name string,
   :audienceType string,
   :created string,
   :audienceDefinition {:includeConditions {:daysToLookBack integer,
                                            :isSmartList boolean,
                                            :kind string,
                                            :membershipDurationDays integer,
                                            :segment string}},
   :webPropertyId string,
   :id string,
   :kind string,
   :internalWebPropertyId string,
   :stateBasedAudienceDefinition {:excludeConditions {:exclusionDuration string,
                                                      :segment string},
                                  :includeConditions {:daysToLookBack integer,
                                                      :isSmartList boolean,
                                                      :kind string,
                                                      :membershipDurationDays integer,
                                                      :segment string}},
   :linkedAdAccounts [{:eligibleForSearch boolean,
                       :linkedAccountId string,
                       :type string,
                       :webPropertyId string,
                       :remarketingAudienceId string,
                       :status string,
                       :id string,
                       :kind string,
                       :internalWebPropertyId string,
                       :accountId string}],
   :accountId string,
   :linkedViews [string]}
  
  Creates a new remarketing audience."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:webPropertyId :accountId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/remarketingAudiences"
     #{:webPropertyId :accountId}
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

(defn remarketingAudience-list$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/remarketingAudience/list
  
  Required parameters: accountId, webPropertyId
  
  Optional parameters: max-results, start-index, type
  
  Lists remarketing audiences to which the user has access."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:webPropertyId :accountId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/remarketingAudiences"
     #{:webPropertyId :accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn remarketingAudience-patch$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/remarketingAudience/patch
  
  Required parameters: accountId, remarketingAudienceId, webPropertyId
  
  Optional parameters: none
  
  Body: 
  
  {:description string,
   :updated string,
   :name string,
   :audienceType string,
   :created string,
   :audienceDefinition {:includeConditions {:daysToLookBack integer,
                                            :isSmartList boolean,
                                            :kind string,
                                            :membershipDurationDays integer,
                                            :segment string}},
   :webPropertyId string,
   :id string,
   :kind string,
   :internalWebPropertyId string,
   :stateBasedAudienceDefinition {:excludeConditions {:exclusionDuration string,
                                                      :segment string},
                                  :includeConditions {:daysToLookBack integer,
                                                      :isSmartList boolean,
                                                      :kind string,
                                                      :membershipDurationDays integer,
                                                      :segment string}},
   :linkedAdAccounts [{:eligibleForSearch boolean,
                       :linkedAccountId string,
                       :type string,
                       :webPropertyId string,
                       :remarketingAudienceId string,
                       :status string,
                       :id string,
                       :kind string,
                       :internalWebPropertyId string,
                       :accountId string}],
   :accountId string,
   :linkedViews [string]}
  
  Updates an existing remarketing audience. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:webPropertyId :remarketingAudienceId :accountId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/remarketingAudiences/{remarketingAudienceId}"
     #{:webPropertyId :remarketingAudienceId :accountId}
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

(defn remarketingAudience-update$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/remarketingAudience/update
  
  Required parameters: accountId, remarketingAudienceId, webPropertyId
  
  Optional parameters: none
  
  Body: 
  
  {:description string,
   :updated string,
   :name string,
   :audienceType string,
   :created string,
   :audienceDefinition {:includeConditions {:daysToLookBack integer,
                                            :isSmartList boolean,
                                            :kind string,
                                            :membershipDurationDays integer,
                                            :segment string}},
   :webPropertyId string,
   :id string,
   :kind string,
   :internalWebPropertyId string,
   :stateBasedAudienceDefinition {:excludeConditions {:exclusionDuration string,
                                                      :segment string},
                                  :includeConditions {:daysToLookBack integer,
                                                      :isSmartList boolean,
                                                      :kind string,
                                                      :membershipDurationDays integer,
                                                      :segment string}},
   :linkedAdAccounts [{:eligibleForSearch boolean,
                       :linkedAccountId string,
                       :type string,
                       :webPropertyId string,
                       :remarketingAudienceId string,
                       :status string,
                       :id string,
                       :kind string,
                       :internalWebPropertyId string,
                       :accountId string}],
   :accountId string,
   :linkedViews [string]}
  
  Updates an existing remarketing audience."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:webPropertyId :remarketingAudienceId :accountId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/remarketingAudiences/{remarketingAudienceId}"
     #{:webPropertyId :remarketingAudienceId :accountId}
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

(defn accounts-list$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/accounts/list
  
  Required parameters: none
  
  Optional parameters: max-results, start-index
  
  Lists all accounts to which the user has access."
  {:scopes ["https://www.googleapis.com/auth/analytics"
            "https://www.googleapis.com/auth/analytics.edit"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn unsampledReports-delete$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/unsampledReports/delete
  
  Required parameters: accountId, profileId, unsampledReportId, webPropertyId
  
  Optional parameters: none
  
  Deletes an unsampled report."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:unsampledReportId :webPropertyId :profileId :accountId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}/unsampledReports/{unsampledReportId}"
     #{:unsampledReportId :webPropertyId :profileId :accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn unsampledReports-get$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/unsampledReports/get
  
  Required parameters: accountId, profileId, unsampledReportId, webPropertyId
  
  Optional parameters: none
  
  Returns a single unsampled report."
  {:scopes ["https://www.googleapis.com/auth/analytics"
            "https://www.googleapis.com/auth/analytics.edit"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:unsampledReportId :webPropertyId :profileId :accountId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}/unsampledReports/{unsampledReportId}"
     #{:unsampledReportId :webPropertyId :profileId :accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn unsampledReports-insert$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/unsampledReports/insert
  
  Required parameters: accountId, profileId, webPropertyId
  
  Optional parameters: none
  
  Body: 
  
  {:end-date string,
   :filters string,
   :updated string,
   :selfLink string,
   :created string,
   :webPropertyId string,
   :dimensions string,
   :title string,
   :status string,
   :segment string,
   :id string,
   :kind string,
   :profileId string,
   :start-date string,
   :accountId string,
   :cloudStorageDownloadDetails {:bucketId string, :objectId string},
   :metrics string,
   :driveDownloadDetails {:documentId string},
   :downloadType string}
  
  Create a new unsampled report."
  {:scopes ["https://www.googleapis.com/auth/analytics"
            "https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:webPropertyId :profileId :accountId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}/unsampledReports"
     #{:webPropertyId :profileId :accountId}
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

(defn unsampledReports-list$
  "https://developers.google.com/analytics/api/reference/rest/v3/management/unsampledReports/list
  
  Required parameters: accountId, profileId, webPropertyId
  
  Optional parameters: max-results, start-index
  
  Lists unsampled reports to which the user has access."
  {:scopes ["https://www.googleapis.com/auth/analytics"
            "https://www.googleapis.com/auth/analytics.edit"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:webPropertyId :profileId :accountId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}/unsampledReports"
     #{:webPropertyId :profileId :accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
