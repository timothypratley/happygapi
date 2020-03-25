(ns happygapi.vault.matters
  "G Suite Vault API: matters.
  Archiving and eDiscovery for G Suite.
  See: https://developers.google.com/vaultapi/reference/rest/v1/matters"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn removePermissions$
  "https://developers.google.com/vaultapi/reference/rest/v1/matters/removePermissions
  
  Required parameters: matterId
  
  Optional parameters: none
  
  Body: 
  
  {:accountId string}
  
  Removes an account as a matter collaborator."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:matterId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vault.googleapis.com/"
     "v1/matters/{matterId}:removePermissions"
     #{:matterId}
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

(defn get$
  "https://developers.google.com/vaultapi/reference/rest/v1/matters/get
  
  Required parameters: matterId
  
  Optional parameters: view
  
  Gets the specified matter."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"
            "https://www.googleapis.com/auth/ediscovery.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:matterId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vault.googleapis.com/"
     "v1/matters/{matterId}"
     #{:matterId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn create$
  "https://developers.google.com/vaultapi/reference/rest/v1/matters/create
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:matterId string,
   :state string,
   :name string,
   :matterPermissions [{:role string, :accountId string}],
   :description string}
  
  Creates a new matter with the given name and description. The initial state
  is open, and the owner is the method caller. Returns the created matter
  with default view."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vault.googleapis.com/"
     "v1/matters"
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

(defn addPermissions$
  "https://developers.google.com/vaultapi/reference/rest/v1/matters/addPermissions
  
  Required parameters: matterId
  
  Optional parameters: none
  
  Body: 
  
  {:sendEmails boolean,
   :matterPermission {:role string, :accountId string},
   :ccMe boolean}
  
  Adds an account as a matter collaborator."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:matterId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vault.googleapis.com/"
     "v1/matters/{matterId}:addPermissions"
     #{:matterId}
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

(defn update$
  "https://developers.google.com/vaultapi/reference/rest/v1/matters/update
  
  Required parameters: matterId
  
  Optional parameters: none
  
  Body: 
  
  {:matterId string,
   :state string,
   :name string,
   :matterPermissions [{:role string, :accountId string}],
   :description string}
  
  Updates the specified matter.
  This updates only the name and description of the matter, identified by
  matter id. Changes to any other fields are ignored.
  Returns the default view of the matter."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:matterId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://vault.googleapis.com/"
     "v1/matters/{matterId}"
     #{:matterId}
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

(defn delete$
  "https://developers.google.com/vaultapi/reference/rest/v1/matters/delete
  
  Required parameters: matterId
  
  Optional parameters: none
  
  Deletes the specified matter. Returns matter with updated state."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:matterId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://vault.googleapis.com/"
     "v1/matters/{matterId}"
     #{:matterId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn reopen$
  "https://developers.google.com/vaultapi/reference/rest/v1/matters/reopen
  
  Required parameters: matterId
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Reopens the specified matter. Returns matter with updated state."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:matterId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vault.googleapis.com/"
     "v1/matters/{matterId}:reopen"
     #{:matterId}
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

(defn close$
  "https://developers.google.com/vaultapi/reference/rest/v1/matters/close
  
  Required parameters: matterId
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Closes the specified matter. Returns matter with updated state."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:matterId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vault.googleapis.com/"
     "v1/matters/{matterId}:close"
     #{:matterId}
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

(defn undelete$
  "https://developers.google.com/vaultapi/reference/rest/v1/matters/undelete
  
  Required parameters: matterId
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Undeletes the specified matter. Returns matter with updated state."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:matterId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vault.googleapis.com/"
     "v1/matters/{matterId}:undelete"
     #{:matterId}
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

(defn list$
  "https://developers.google.com/vaultapi/reference/rest/v1/matters/list
  
  Required parameters: none
  
  Optional parameters: state, pageToken, pageSize, view
  
  Lists matters the user has access to."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"
            "https://www.googleapis.com/auth/ediscovery.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vault.googleapis.com/"
     "v1/matters"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn holds-removeHeldAccounts$
  "https://developers.google.com/vaultapi/reference/rest/v1/matters/holds/removeHeldAccounts
  
  Required parameters: matterId, holdId
  
  Optional parameters: none
  
  Body: 
  
  {:accountIds [string]}
  
  Removes HeldAccounts from a hold. Returns a list of statuses in the same
  order as the request. If this request leaves the hold with no held
  accounts, the hold will not apply to any accounts."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:holdId :matterId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vault.googleapis.com/"
     "v1/matters/{matterId}/holds/{holdId}:removeHeldAccounts"
     #{:holdId :matterId}
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

(defn holds-get$
  "https://developers.google.com/vaultapi/reference/rest/v1/matters/holds/get
  
  Required parameters: holdId, matterId
  
  Optional parameters: view
  
  Gets a hold by ID."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"
            "https://www.googleapis.com/auth/ediscovery.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:holdId :matterId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vault.googleapis.com/"
     "v1/matters/{matterId}/holds/{holdId}"
     #{:holdId :matterId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn holds-addHeldAccounts$
  "https://developers.google.com/vaultapi/reference/rest/v1/matters/holds/addHeldAccounts
  
  Required parameters: holdId, matterId
  
  Optional parameters: none
  
  Body: 
  
  {:emails [string], :accountIds [string]}
  
  Adds HeldAccounts to a hold. Returns a list of accounts that have been
  successfully added. Accounts can only be added to an existing account-based
  hold."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:holdId :matterId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vault.googleapis.com/"
     "v1/matters/{matterId}/holds/{holdId}:addHeldAccounts"
     #{:holdId :matterId}
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

(defn holds-update$
  "https://developers.google.com/vaultapi/reference/rest/v1/matters/holds/update
  
  Required parameters: matterId, holdId
  
  Optional parameters: none
  
  Body: 
  
  {:accounts [{:lastName string,
               :email string,
               :accountId string,
               :firstName string,
               :holdTime string}],
   :query {:mailQuery HeldMailQuery,
           :groupsQuery HeldGroupsQuery,
           :hangoutsChatQuery HeldHangoutsChatQuery,
           :driveQuery HeldDriveQuery},
   :orgUnit {:holdTime string, :orgUnitId string},
   :corpus string,
   :updateTime string,
   :name string,
   :holdId string}
  
  Updates the OU and/or query parameters of a hold. You cannot add accounts
  to a hold that covers an OU, nor can you add OUs to a hold that covers
  individual accounts. Accounts listed in the hold will be ignored."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:holdId :matterId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://vault.googleapis.com/"
     "v1/matters/{matterId}/holds/{holdId}"
     #{:holdId :matterId}
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

(defn holds-delete$
  "https://developers.google.com/vaultapi/reference/rest/v1/matters/holds/delete
  
  Required parameters: holdId, matterId
  
  Optional parameters: none
  
  Removes a hold by ID. This will release any HeldAccounts on this Hold."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:holdId :matterId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://vault.googleapis.com/"
     "v1/matters/{matterId}/holds/{holdId}"
     #{:holdId :matterId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn holds-list$
  "https://developers.google.com/vaultapi/reference/rest/v1/matters/holds/list
  
  Required parameters: matterId
  
  Optional parameters: view, pageToken, pageSize
  
  Lists holds within a matter. An empty page token in ListHoldsResponse
  denotes no more holds to list."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"
            "https://www.googleapis.com/auth/ediscovery.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:matterId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vault.googleapis.com/"
     "v1/matters/{matterId}/holds"
     #{:matterId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn holds-create$
  "https://developers.google.com/vaultapi/reference/rest/v1/matters/holds/create
  
  Required parameters: matterId
  
  Optional parameters: none
  
  Body: 
  
  {:accounts [{:lastName string,
               :email string,
               :accountId string,
               :firstName string,
               :holdTime string}],
   :query {:mailQuery HeldMailQuery,
           :groupsQuery HeldGroupsQuery,
           :hangoutsChatQuery HeldHangoutsChatQuery,
           :driveQuery HeldDriveQuery},
   :orgUnit {:holdTime string, :orgUnitId string},
   :corpus string,
   :updateTime string,
   :name string,
   :holdId string}
  
  Creates a hold in the given matter."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:matterId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vault.googleapis.com/"
     "v1/matters/{matterId}/holds"
     #{:matterId}
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

(defn holds-accounts-list$
  "https://developers.google.com/vaultapi/reference/rest/v1/matters/holds/accounts/list
  
  Required parameters: matterId, holdId
  
  Optional parameters: none
  
  Lists HeldAccounts for a hold. This will only list individually specified
  held accounts. If the hold is on an OU, then use
  <a href=\"https://developers.google.com/admin-sdk/\">Admin SDK</a>
  to enumerate its members."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"
            "https://www.googleapis.com/auth/ediscovery.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:holdId :matterId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vault.googleapis.com/"
     "v1/matters/{matterId}/holds/{holdId}/accounts"
     #{:holdId :matterId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn holds-accounts-create$
  "https://developers.google.com/vaultapi/reference/rest/v1/matters/holds/accounts/create
  
  Required parameters: matterId, holdId
  
  Optional parameters: none
  
  Body: 
  
  {:lastName string,
   :email string,
   :accountId string,
   :firstName string,
   :holdTime string}
  
  Adds a HeldAccount to a hold. Accounts can only be added to a hold that
  has no held_org_unit set. Attempting to add an account to an OU-based
  hold will result in an error."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:holdId :matterId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vault.googleapis.com/"
     "v1/matters/{matterId}/holds/{holdId}/accounts"
     #{:holdId :matterId}
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

(defn holds-accounts-delete$
  "https://developers.google.com/vaultapi/reference/rest/v1/matters/holds/accounts/delete
  
  Required parameters: holdId, accountId, matterId
  
  Optional parameters: none
  
  Removes a HeldAccount from a hold. If this request leaves the hold with
  no held accounts, the hold will not apply to any accounts."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:holdId :matterId :accountId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://vault.googleapis.com/"
     "v1/matters/{matterId}/holds/{holdId}/accounts/{accountId}"
     #{:holdId :matterId :accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn exports-get$
  "https://developers.google.com/vaultapi/reference/rest/v1/matters/exports/get
  
  Required parameters: matterId, exportId
  
  Optional parameters: none
  
  Gets an Export."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"
            "https://www.googleapis.com/auth/ediscovery.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:exportId :matterId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vault.googleapis.com/"
     "v1/matters/{matterId}/exports/{exportId}"
     #{:exportId :matterId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn exports-list$
  "https://developers.google.com/vaultapi/reference/rest/v1/matters/exports/list
  
  Required parameters: matterId
  
  Optional parameters: pageToken, pageSize
  
  Lists Exports."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"
            "https://www.googleapis.com/auth/ediscovery.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:matterId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vault.googleapis.com/"
     "v1/matters/{matterId}/exports"
     #{:matterId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn exports-create$
  "https://developers.google.com/vaultapi/reference/rest/v1/matters/exports/create
  
  Required parameters: matterId
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :createTime string,
   :requester {:email string, :displayName string},
   :status string,
   :id string,
   :matterId string,
   :cloudStorageSink {:files [CloudStorageFile]},
   :query {:hangoutsChatOptions HangoutsChatOptions,
           :orgUnitInfo OrgUnitInfo,
           :timeZone string,
           :hangoutsChatInfo HangoutsChatInfo,
           :startTime string,
           :terms string,
           :searchMethod string,
           :method string,
           :endTime string,
           :sharedDriveInfo SharedDriveInfo,
           :accountInfo AccountInfo,
           :corpus string,
           :teamDriveInfo TeamDriveInfo,
           :mailOptions MailOptions,
           :driveOptions DriveOptions,
           :dataScope string},
   :stats {:totalArtifactCount string,
           :sizeInBytes string,
           :exportedArtifactCount string},
   :exportOptions {:groupsOptions GroupsExportOptions,
                   :driveOptions DriveExportOptions,
                   :mailOptions MailExportOptions,
                   :region string,
                   :hangoutsChatOptions HangoutsChatExportOptions}}
  
  Creates an Export."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:matterId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vault.googleapis.com/"
     "v1/matters/{matterId}/exports"
     #{:matterId}
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

(defn exports-delete$
  "https://developers.google.com/vaultapi/reference/rest/v1/matters/exports/delete
  
  Required parameters: matterId, exportId
  
  Optional parameters: none
  
  Deletes an Export."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:exportId :matterId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://vault.googleapis.com/"
     "v1/matters/{matterId}/exports/{exportId}"
     #{:exportId :matterId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn savedQueries-delete$
  "https://developers.google.com/vaultapi/reference/rest/v1/matters/savedQueries/delete
  
  Required parameters: matterId, savedQueryId
  
  Optional parameters: none
  
  Deletes a saved query by Id."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:matterId :savedQueryId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://vault.googleapis.com/"
     "v1/matters/{matterId}/savedQueries/{savedQueryId}"
     #{:matterId :savedQueryId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn savedQueries-get$
  "https://developers.google.com/vaultapi/reference/rest/v1/matters/savedQueries/get
  
  Required parameters: matterId, savedQueryId
  
  Optional parameters: none
  
  Retrieves a saved query by Id."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"
            "https://www.googleapis.com/auth/ediscovery.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:matterId :savedQueryId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vault.googleapis.com/"
     "v1/matters/{matterId}/savedQueries/{savedQueryId}"
     #{:matterId :savedQueryId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn savedQueries-list$
  "https://developers.google.com/vaultapi/reference/rest/v1/matters/savedQueries/list
  
  Required parameters: matterId
  
  Optional parameters: pageToken, pageSize
  
  Lists saved queries within a matter. An empty page token in
  ListSavedQueriesResponse denotes no more saved queries to list."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"
            "https://www.googleapis.com/auth/ediscovery.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:matterId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vault.googleapis.com/"
     "v1/matters/{matterId}/savedQueries"
     #{:matterId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn savedQueries-create$
  "https://developers.google.com/vaultapi/reference/rest/v1/matters/savedQueries/create
  
  Required parameters: matterId
  
  Optional parameters: none
  
  Body: 
  
  {:query {:hangoutsChatOptions HangoutsChatOptions,
           :orgUnitInfo OrgUnitInfo,
           :timeZone string,
           :hangoutsChatInfo HangoutsChatInfo,
           :startTime string,
           :terms string,
           :searchMethod string,
           :method string,
           :endTime string,
           :sharedDriveInfo SharedDriveInfo,
           :accountInfo AccountInfo,
           :corpus string,
           :teamDriveInfo TeamDriveInfo,
           :mailOptions MailOptions,
           :driveOptions DriveOptions,
           :dataScope string},
   :matterId string,
   :createTime string,
   :savedQueryId string,
   :displayName string}
  
  Creates a saved query."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:matterId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vault.googleapis.com/"
     "v1/matters/{matterId}/savedQueries"
     #{:matterId}
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
