(ns happygapi.analytics.management
  "Google Analytics API
  Views and manages your Google Analytics data.
  See: https://developers.google.com/analytics/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn clientId-hashClientId$
  "Required parameters: none
  
  Hashes the given Client ID."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/clientId:hashClientId"
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

(defn goals-get$
  "Required parameters: accountId,goalId,profileId,webPropertyId
  
  Gets a goal to which the user has access."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"accountId" "webPropertyId" "profileId" "goalId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}/goals/{goalId}"
     #{"accountId" "webPropertyId" "profileId" "goalId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn goals-insert$
  "Required parameters: accountId,profileId,webPropertyId
  
  Create a new goal."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth args body]
  {:pre [(util/has-keys?
          args
          #{"accountId" "webPropertyId" "profileId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}/goals"
     #{"accountId" "webPropertyId" "profileId"}
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

(defn goals-list$
  "Required parameters: accountId,profileId,webPropertyId
  
  Lists goals to which the user has access."
  {:scopes ["https://www.googleapis.com/auth/analytics"
            "https://www.googleapis.com/auth/analytics.edit"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"accountId" "webPropertyId" "profileId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}/goals"
     #{"accountId" "webPropertyId" "profileId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn goals-patch$
  "Required parameters: accountId,goalId,profileId,webPropertyId
  
  Updates an existing goal. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"accountId" "webPropertyId" "profileId" "goalId"})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}/goals/{goalId}"
     #{"accountId" "webPropertyId" "profileId" "goalId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn goals-update$
  "Required parameters: accountId,goalId,profileId,webPropertyId
  
  Updates an existing goal."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"accountId" "webPropertyId" "profileId" "goalId"})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}/goals/{goalId}"
     #{"accountId" "webPropertyId" "profileId" "goalId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn experiments-delete$
  "Required parameters: accountId,experimentId,profileId,webPropertyId
  
  Delete an experiment."
  {:scopes ["https://www.googleapis.com/auth/analytics"
            "https://www.googleapis.com/auth/analytics.edit"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"accountId" "webPropertyId" "profileId" "experimentId"})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}/experiments/{experimentId}"
     #{"accountId" "webPropertyId" "profileId" "experimentId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn experiments-get$
  "Required parameters: accountId,experimentId,profileId,webPropertyId
  
  Returns an experiment to which the user has access."
  {:scopes ["https://www.googleapis.com/auth/analytics"
            "https://www.googleapis.com/auth/analytics.edit"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"accountId" "webPropertyId" "profileId" "experimentId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}/experiments/{experimentId}"
     #{"accountId" "webPropertyId" "profileId" "experimentId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn experiments-insert$
  "Required parameters: accountId,profileId,webPropertyId
  
  Create a new experiment."
  {:scopes ["https://www.googleapis.com/auth/analytics"
            "https://www.googleapis.com/auth/analytics.edit"]}
  [auth args body]
  {:pre [(util/has-keys?
          args
          #{"accountId" "webPropertyId" "profileId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}/experiments"
     #{"accountId" "webPropertyId" "profileId"}
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

(defn experiments-list$
  "Required parameters: accountId,profileId,webPropertyId
  
  Lists experiments to which the user has access."
  {:scopes ["https://www.googleapis.com/auth/analytics"
            "https://www.googleapis.com/auth/analytics.edit"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"accountId" "webPropertyId" "profileId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}/experiments"
     #{"accountId" "webPropertyId" "profileId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn experiments-patch$
  "Required parameters: accountId,experimentId,profileId,webPropertyId
  
  Update an existing experiment. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/analytics"
            "https://www.googleapis.com/auth/analytics.edit"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"accountId" "webPropertyId" "profileId" "experimentId"})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}/experiments/{experimentId}"
     #{"accountId" "webPropertyId" "profileId" "experimentId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn experiments-update$
  "Required parameters: accountId,experimentId,profileId,webPropertyId
  
  Update an existing experiment."
  {:scopes ["https://www.googleapis.com/auth/analytics"
            "https://www.googleapis.com/auth/analytics.edit"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"accountId" "webPropertyId" "profileId" "experimentId"})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}/experiments/{experimentId}"
     #{"accountId" "webPropertyId" "profileId" "experimentId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn profileFilterLinks-delete$
  "Required parameters: accountId,linkId,profileId,webPropertyId
  
  Delete a profile filter link."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"accountId" "webPropertyId" "linkId" "profileId"})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}/profileFilterLinks/{linkId}"
     #{"accountId" "webPropertyId" "linkId" "profileId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn profileFilterLinks-get$
  "Required parameters: accountId,linkId,profileId,webPropertyId
  
  Returns a single profile filter link."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"accountId" "webPropertyId" "linkId" "profileId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}/profileFilterLinks/{linkId}"
     #{"accountId" "webPropertyId" "linkId" "profileId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn profileFilterLinks-insert$
  "Required parameters: accountId,profileId,webPropertyId
  
  Create a new profile filter link."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth args body]
  {:pre [(util/has-keys?
          args
          #{"accountId" "webPropertyId" "profileId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}/profileFilterLinks"
     #{"accountId" "webPropertyId" "profileId"}
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

(defn profileFilterLinks-list$
  "Required parameters: accountId,profileId,webPropertyId
  
  Lists all profile filter links for a profile."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"accountId" "webPropertyId" "profileId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}/profileFilterLinks"
     #{"accountId" "webPropertyId" "profileId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn profileFilterLinks-patch$
  "Required parameters: accountId,linkId,profileId,webPropertyId
  
  Update an existing profile filter link. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"accountId" "webPropertyId" "linkId" "profileId"})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}/profileFilterLinks/{linkId}"
     #{"accountId" "webPropertyId" "linkId" "profileId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn profileFilterLinks-update$
  "Required parameters: accountId,linkId,profileId,webPropertyId
  
  Update an existing profile filter link."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"accountId" "webPropertyId" "linkId" "profileId"})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}/profileFilterLinks/{linkId}"
     #{"accountId" "webPropertyId" "linkId" "profileId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn filters-delete$
  "Required parameters: accountId,filterId
  
  Delete a filter."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth args]
  {:pre [(util/has-keys? args #{"accountId" "filterId"})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/filters/{filterId}"
     #{"accountId" "filterId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn filters-get$
  "Required parameters: accountId,filterId
  
  Returns filters to which the user has access."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"accountId" "filterId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/filters/{filterId}"
     #{"accountId" "filterId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn filters-insert$
  "Required parameters: accountId
  
  Create a new filter."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"accountId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/filters"
     #{"accountId"}
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

(defn filters-list$
  "Required parameters: accountId
  
  Lists all filters for an account"
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"accountId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/filters"
     #{"accountId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn filters-patch$
  "Required parameters: accountId,filterId
  
  Updates an existing filter. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth args]
  {:pre [(util/has-keys? args #{"accountId" "filterId"})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/filters/{filterId}"
     #{"accountId" "filterId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn filters-update$
  "Required parameters: accountId,filterId
  
  Updates an existing filter."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth args]
  {:pre [(util/has-keys? args #{"accountId" "filterId"})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/filters/{filterId}"
     #{"accountId" "filterId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn customMetrics-get$
  "Required parameters: accountId,customMetricId,webPropertyId
  
  Get a custom metric to which the user has access."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"accountId" "customMetricId" "webPropertyId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/customMetrics/{customMetricId}"
     #{"accountId" "customMetricId" "webPropertyId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn customMetrics-insert$
  "Required parameters: accountId,webPropertyId
  
  Create a new custom metric."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"accountId" "webPropertyId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/customMetrics"
     #{"accountId" "webPropertyId"}
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

(defn customMetrics-list$
  "Required parameters: accountId,webPropertyId
  
  Lists custom metrics to which the user has access."
  {:scopes ["https://www.googleapis.com/auth/analytics"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"accountId" "webPropertyId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/customMetrics"
     #{"accountId" "webPropertyId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn customMetrics-patch$
  "Required parameters: accountId,customMetricId,webPropertyId
  
  Updates an existing custom metric. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"accountId" "customMetricId" "webPropertyId"})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/customMetrics/{customMetricId}"
     #{"accountId" "customMetricId" "webPropertyId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn customMetrics-update$
  "Required parameters: accountId,customMetricId,webPropertyId
  
  Updates an existing custom metric."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"accountId" "customMetricId" "webPropertyId"})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/customMetrics/{customMetricId}"
     #{"accountId" "customMetricId" "webPropertyId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn webpropertyUserLinks-delete$
  "Required parameters: accountId,linkId,webPropertyId
  
  Removes a user from the given web property."
  {:scopes ["https://www.googleapis.com/auth/analytics.manage.users"]}
  [auth args]
  {:pre [(util/has-keys? args #{"accountId" "webPropertyId" "linkId"})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/entityUserLinks/{linkId}"
     #{"accountId" "webPropertyId" "linkId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn webpropertyUserLinks-insert$
  "Required parameters: accountId,webPropertyId
  
  Adds a new user to the given web property."
  {:scopes ["https://www.googleapis.com/auth/analytics.manage.users"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"accountId" "webPropertyId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/entityUserLinks"
     #{"accountId" "webPropertyId"}
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

(defn webpropertyUserLinks-list$
  "Required parameters: accountId,webPropertyId
  
  Lists webProperty-user links for a given web property."
  {:scopes ["https://www.googleapis.com/auth/analytics.manage.users"
            "https://www.googleapis.com/auth/analytics.manage.users.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"accountId" "webPropertyId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/entityUserLinks"
     #{"accountId" "webPropertyId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn webpropertyUserLinks-update$
  "Required parameters: accountId,linkId,webPropertyId
  
  Updates permissions for an existing user on the given web property."
  {:scopes ["https://www.googleapis.com/auth/analytics.manage.users"]}
  [auth args]
  {:pre [(util/has-keys? args #{"accountId" "webPropertyId" "linkId"})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/entityUserLinks/{linkId}"
     #{"accountId" "webPropertyId" "linkId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn webPropertyAdWordsLinks-delete$
  "Required parameters: accountId,webPropertyAdWordsLinkId,webPropertyId
  
  Deletes a web property-Google Ads link."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"webPropertyAdWordsLinkId" "accountId" "webPropertyId"})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/entityAdWordsLinks/{webPropertyAdWordsLinkId}"
     #{"webPropertyAdWordsLinkId" "accountId" "webPropertyId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn webPropertyAdWordsLinks-get$
  "Required parameters: accountId,webPropertyAdWordsLinkId,webPropertyId
  
  Returns a web property-Google Ads link to which the user has access."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"webPropertyAdWordsLinkId" "accountId" "webPropertyId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/entityAdWordsLinks/{webPropertyAdWordsLinkId}"
     #{"webPropertyAdWordsLinkId" "accountId" "webPropertyId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn webPropertyAdWordsLinks-insert$
  "Required parameters: accountId,webPropertyId
  
  Creates a webProperty-Google Ads link."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"accountId" "webPropertyId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/entityAdWordsLinks"
     #{"accountId" "webPropertyId"}
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

(defn webPropertyAdWordsLinks-list$
  "Required parameters: accountId,webPropertyId
  
  Lists webProperty-Google Ads links for a given web property."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"accountId" "webPropertyId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/entityAdWordsLinks"
     #{"accountId" "webPropertyId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn webPropertyAdWordsLinks-patch$
  "Required parameters: accountId,webPropertyAdWordsLinkId,webPropertyId
  
  Updates an existing webProperty-Google Ads link. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"webPropertyAdWordsLinkId" "accountId" "webPropertyId"})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/entityAdWordsLinks/{webPropertyAdWordsLinkId}"
     #{"webPropertyAdWordsLinkId" "accountId" "webPropertyId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn webPropertyAdWordsLinks-update$
  "Required parameters: accountId,webPropertyAdWordsLinkId,webPropertyId
  
  Updates an existing webProperty-Google Ads link."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"webPropertyAdWordsLinkId" "accountId" "webPropertyId"})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/entityAdWordsLinks/{webPropertyAdWordsLinkId}"
     #{"webPropertyAdWordsLinkId" "accountId" "webPropertyId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn webproperties-get$
  "Required parameters: accountId,webPropertyId
  
  Gets a web property to which the user has access."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"accountId" "webPropertyId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}"
     #{"accountId" "webPropertyId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn webproperties-insert$
  "Required parameters: accountId
  
  Create a new property if the account has fewer than 20 properties. Web properties are visible in the Google Analytics interface only if they have at least one profile."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"accountId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties"
     #{"accountId"}
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

(defn webproperties-list$
  "Required parameters: accountId
  
  Lists web properties to which the user has access."
  {:scopes ["https://www.googleapis.com/auth/analytics"
            "https://www.googleapis.com/auth/analytics.edit"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"accountId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties"
     #{"accountId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn webproperties-patch$
  "Required parameters: accountId,webPropertyId
  
  Updates an existing web property. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth args]
  {:pre [(util/has-keys? args #{"accountId" "webPropertyId"})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}"
     #{"accountId" "webPropertyId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn webproperties-update$
  "Required parameters: accountId,webPropertyId
  
  Updates an existing web property."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth args]
  {:pre [(util/has-keys? args #{"accountId" "webPropertyId"})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}"
     #{"accountId" "webPropertyId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn customDimensions-get$
  "Required parameters: accountId,customDimensionId,webPropertyId
  
  Get a custom dimension to which the user has access."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"accountId" "webPropertyId" "customDimensionId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/customDimensions/{customDimensionId}"
     #{"accountId" "webPropertyId" "customDimensionId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn customDimensions-insert$
  "Required parameters: accountId,webPropertyId
  
  Create a new custom dimension."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"accountId" "webPropertyId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/customDimensions"
     #{"accountId" "webPropertyId"}
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

(defn customDimensions-list$
  "Required parameters: accountId,webPropertyId
  
  Lists custom dimensions to which the user has access."
  {:scopes ["https://www.googleapis.com/auth/analytics"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"accountId" "webPropertyId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/customDimensions"
     #{"accountId" "webPropertyId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn customDimensions-patch$
  "Required parameters: accountId,customDimensionId,webPropertyId
  
  Updates an existing custom dimension. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"accountId" "webPropertyId" "customDimensionId"})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/customDimensions/{customDimensionId}"
     #{"accountId" "webPropertyId" "customDimensionId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn customDimensions-update$
  "Required parameters: accountId,customDimensionId,webPropertyId
  
  Updates an existing custom dimension."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"accountId" "webPropertyId" "customDimensionId"})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/customDimensions/{customDimensionId}"
     #{"accountId" "webPropertyId" "customDimensionId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn segments-list$
  "Required parameters: none
  
  Lists segments to which the user has access."
  {:scopes ["https://www.googleapis.com/auth/analytics"
            "https://www.googleapis.com/auth/analytics.edit"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/segments"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn accountSummaries-list$
  "Required parameters: none
  
  Lists account summaries (lightweight tree comprised of accounts/properties/profiles) to which the user has access."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accountSummaries"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn accountUserLinks-delete$
  "Required parameters: accountId,linkId
  
  Removes a user from the given account."
  {:scopes ["https://www.googleapis.com/auth/analytics.manage.users"]}
  [auth args]
  {:pre [(util/has-keys? args #{"accountId" "linkId"})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/entityUserLinks/{linkId}"
     #{"accountId" "linkId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn accountUserLinks-insert$
  "Required parameters: accountId
  
  Adds a new user to the given account."
  {:scopes ["https://www.googleapis.com/auth/analytics.manage.users"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"accountId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/entityUserLinks"
     #{"accountId"}
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

(defn accountUserLinks-list$
  "Required parameters: accountId
  
  Lists account-user links for a given account."
  {:scopes ["https://www.googleapis.com/auth/analytics.manage.users"
            "https://www.googleapis.com/auth/analytics.manage.users.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"accountId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/entityUserLinks"
     #{"accountId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn accountUserLinks-update$
  "Required parameters: accountId,linkId
  
  Updates permissions for an existing user on the given account."
  {:scopes ["https://www.googleapis.com/auth/analytics.manage.users"]}
  [auth args]
  {:pre [(util/has-keys? args #{"accountId" "linkId"})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/entityUserLinks/{linkId}"
     #{"accountId" "linkId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn profileUserLinks-delete$
  "Required parameters: accountId,linkId,profileId,webPropertyId
  
  Removes a user from the given view (profile)."
  {:scopes ["https://www.googleapis.com/auth/analytics.manage.users"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"accountId" "webPropertyId" "linkId" "profileId"})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}/entityUserLinks/{linkId}"
     #{"accountId" "webPropertyId" "linkId" "profileId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn profileUserLinks-insert$
  "Required parameters: accountId,profileId,webPropertyId
  
  Adds a new user to the given view (profile)."
  {:scopes ["https://www.googleapis.com/auth/analytics.manage.users"]}
  [auth args body]
  {:pre [(util/has-keys?
          args
          #{"accountId" "webPropertyId" "profileId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}/entityUserLinks"
     #{"accountId" "webPropertyId" "profileId"}
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

(defn profileUserLinks-list$
  "Required parameters: accountId,profileId,webPropertyId
  
  Lists profile-user links for a given view (profile)."
  {:scopes ["https://www.googleapis.com/auth/analytics.manage.users"
            "https://www.googleapis.com/auth/analytics.manage.users.readonly"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"accountId" "webPropertyId" "profileId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}/entityUserLinks"
     #{"accountId" "webPropertyId" "profileId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn profileUserLinks-update$
  "Required parameters: accountId,linkId,profileId,webPropertyId
  
  Updates permissions for an existing user on the given view (profile)."
  {:scopes ["https://www.googleapis.com/auth/analytics.manage.users"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"accountId" "webPropertyId" "linkId" "profileId"})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}/entityUserLinks/{linkId}"
     #{"accountId" "webPropertyId" "linkId" "profileId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn uploads-deleteUploadData$
  "Required parameters: accountId,customDataSourceId,webPropertyId
  
  Delete data associated with a previous upload."
  {:scopes ["https://www.googleapis.com/auth/analytics"
            "https://www.googleapis.com/auth/analytics.edit"]}
  [auth args body]
  {:pre [(util/has-keys?
          args
          #{"customDataSourceId" "accountId" "webPropertyId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/customDataSources/{customDataSourceId}/deleteUploadData"
     #{"customDataSourceId" "accountId" "webPropertyId"}
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

(defn uploads-get$
  "Required parameters: accountId,customDataSourceId,uploadId,webPropertyId
  
  List uploads to which the user has access."
  {:scopes ["https://www.googleapis.com/auth/analytics"
            "https://www.googleapis.com/auth/analytics.edit"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"customDataSourceId"
            "accountId"
            "uploadId"
            "webPropertyId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/customDataSources/{customDataSourceId}/uploads/{uploadId}"
     #{"customDataSourceId" "accountId" "uploadId" "webPropertyId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn uploads-list$
  "Required parameters: accountId,customDataSourceId,webPropertyId
  
  List uploads to which the user has access."
  {:scopes ["https://www.googleapis.com/auth/analytics"
            "https://www.googleapis.com/auth/analytics.edit"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"customDataSourceId" "accountId" "webPropertyId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/customDataSources/{customDataSourceId}/uploads"
     #{"customDataSourceId" "accountId" "webPropertyId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn uploads-uploadData$
  "Required parameters: accountId,customDataSourceId,webPropertyId
  
  Upload data for a custom data source."
  {:scopes ["https://www.googleapis.com/auth/analytics"
            "https://www.googleapis.com/auth/analytics.edit"]}
  [auth args body]
  {:pre [(util/has-keys?
          args
          #{"customDataSourceId" "accountId" "webPropertyId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/customDataSources/{customDataSourceId}/uploads"
     #{"customDataSourceId" "accountId" "webPropertyId"}
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

(defn customDataSources-list$
  "Required parameters: accountId,webPropertyId
  
  List custom data sources to which the user has access."
  {:scopes ["https://www.googleapis.com/auth/analytics"
            "https://www.googleapis.com/auth/analytics.edit"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"accountId" "webPropertyId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/customDataSources"
     #{"accountId" "webPropertyId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn profiles-delete$
  "Required parameters: accountId,profileId,webPropertyId
  
  Deletes a view (profile)."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"accountId" "webPropertyId" "profileId"})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}"
     #{"accountId" "webPropertyId" "profileId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn profiles-get$
  "Required parameters: accountId,profileId,webPropertyId
  
  Gets a view (profile) to which the user has access."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"accountId" "webPropertyId" "profileId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}"
     #{"accountId" "webPropertyId" "profileId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn profiles-insert$
  "Required parameters: accountId,webPropertyId
  
  Create a new view (profile)."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"accountId" "webPropertyId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/profiles"
     #{"accountId" "webPropertyId"}
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

(defn profiles-list$
  "Required parameters: accountId,webPropertyId
  
  Lists views (profiles) to which the user has access."
  {:scopes ["https://www.googleapis.com/auth/analytics"
            "https://www.googleapis.com/auth/analytics.edit"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"accountId" "webPropertyId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/profiles"
     #{"accountId" "webPropertyId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn profiles-patch$
  "Required parameters: accountId,profileId,webPropertyId
  
  Updates an existing view (profile). This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"accountId" "webPropertyId" "profileId"})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}"
     #{"accountId" "webPropertyId" "profileId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn profiles-update$
  "Required parameters: accountId,profileId,webPropertyId
  
  Updates an existing view (profile)."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"accountId" "webPropertyId" "profileId"})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}"
     #{"accountId" "webPropertyId" "profileId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn remarketingAudience-delete$
  "Required parameters: accountId,remarketingAudienceId,webPropertyId
  
  Delete a remarketing audience."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"accountId" "remarketingAudienceId" "webPropertyId"})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/remarketingAudiences/{remarketingAudienceId}"
     #{"accountId" "remarketingAudienceId" "webPropertyId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn remarketingAudience-get$
  "Required parameters: accountId,remarketingAudienceId,webPropertyId
  
  Gets a remarketing audience to which the user has access."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"accountId" "remarketingAudienceId" "webPropertyId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/remarketingAudiences/{remarketingAudienceId}"
     #{"accountId" "remarketingAudienceId" "webPropertyId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn remarketingAudience-insert$
  "Required parameters: accountId,webPropertyId
  
  Creates a new remarketing audience."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"accountId" "webPropertyId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/remarketingAudiences"
     #{"accountId" "webPropertyId"}
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

(defn remarketingAudience-list$
  "Required parameters: accountId,webPropertyId
  
  Lists remarketing audiences to which the user has access."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"accountId" "webPropertyId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/remarketingAudiences"
     #{"accountId" "webPropertyId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn remarketingAudience-patch$
  "Required parameters: accountId,remarketingAudienceId,webPropertyId
  
  Updates an existing remarketing audience. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"accountId" "remarketingAudienceId" "webPropertyId"})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/remarketingAudiences/{remarketingAudienceId}"
     #{"accountId" "remarketingAudienceId" "webPropertyId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn remarketingAudience-update$
  "Required parameters: accountId,remarketingAudienceId,webPropertyId
  
  Updates an existing remarketing audience."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"accountId" "remarketingAudienceId" "webPropertyId"})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/remarketingAudiences/{remarketingAudienceId}"
     #{"accountId" "remarketingAudienceId" "webPropertyId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn accounts-list$
  "Required parameters: none
  
  Lists all accounts to which the user has access."
  {:scopes ["https://www.googleapis.com/auth/analytics"
            "https://www.googleapis.com/auth/analytics.edit"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn unsampledReports-delete$
  "Required parameters: accountId,profileId,unsampledReportId,webPropertyId
  
  Deletes an unsampled report."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"accountId"
            "unsampledReportId"
            "webPropertyId"
            "profileId"})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}/unsampledReports/{unsampledReportId}"
     #{"accountId" "unsampledReportId" "webPropertyId" "profileId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn unsampledReports-get$
  "Required parameters: accountId,profileId,unsampledReportId,webPropertyId
  
  Returns a single unsampled report."
  {:scopes ["https://www.googleapis.com/auth/analytics"
            "https://www.googleapis.com/auth/analytics.edit"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"accountId"
            "unsampledReportId"
            "webPropertyId"
            "profileId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}/unsampledReports/{unsampledReportId}"
     #{"accountId" "unsampledReportId" "webPropertyId" "profileId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn unsampledReports-insert$
  "Required parameters: accountId,profileId,webPropertyId
  
  Create a new unsampled report."
  {:scopes ["https://www.googleapis.com/auth/analytics"
            "https://www.googleapis.com/auth/analytics.edit"]}
  [auth args body]
  {:pre [(util/has-keys?
          args
          #{"accountId" "webPropertyId" "profileId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}/unsampledReports"
     #{"accountId" "webPropertyId" "profileId"}
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

(defn unsampledReports-list$
  "Required parameters: accountId,profileId,webPropertyId
  
  Lists unsampled reports to which the user has access."
  {:scopes ["https://www.googleapis.com/auth/analytics"
            "https://www.googleapis.com/auth/analytics.edit"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"accountId" "webPropertyId" "profileId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}/unsampledReports"
     #{"accountId" "webPropertyId" "profileId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
