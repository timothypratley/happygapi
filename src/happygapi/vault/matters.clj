(ns happygapi.vault.matters
  "Google Vault API: matters.
  Retention and eDiscovery for Google Workspace. To work with Vault resources, the account must have the [required Vault privileges](https://support.google.com/vault/answer/2799699) and access to the matter. To access a matter, the account must have created the matter, have the matter shared with them, or have the **View All Matters** privilege. For example, to download an export, an account needs the **Manage Exports** privilege and the matter shared with them. 
  See: https://developers.google.com/vaultdocs/reference/rest/v1/matters"
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
   :name string,
   :description string,
   :state string,
   :matterPermissions [{:role string, :accountId string}]}
  
  Creates a matter with the given name and description. The initial state is open, and the owner is the method caller. Returns the created matter with default view."
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
  
  {:matterPermission {:role string, :accountId string},
   :sendEmails boolean,
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
   :name string,
   :description string,
   :state string,
   :matterPermissions [{:role string, :accountId string}]}
  
  Updates the specified matter. This updates only the name and description of the matter, identified by matter ID. Changes to any other fields are ignored. Returns the default view of the matter."
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
  
  Deletes the specified matter. Returns the matter with updated state."
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
  
  Reopens the specified matter. Returns the matter with updated state."
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
  
  Closes the specified matter. Returns the matter with updated state."
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
  
  Undeletes the specified matter. Returns the matter with updated state."
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
  
  Optional parameters: pageSize, pageToken, view, state
  
  Lists matters the requestor has access to."
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

(defn count$
  "https://developers.google.com/vaultapi/reference/rest/v1/matters/count
  
  Required parameters: matterId
  
  Optional parameters: none
  
  Body: 
  
  {:query {:hangoutsChatOptions HangoutsChatOptions,
           :orgUnitInfo OrgUnitInfo,
           :timeZone string,
           :hangoutsChatInfo HangoutsChatInfo,
           :calendarOptions CalendarOptions,
           :startTime string,
           :terms string,
           :searchMethod string,
           :method string,
           :voiceOptions VoiceOptions,
           :endTime string,
           :sharedDriveInfo SharedDriveInfo,
           :accountInfo AccountInfo,
           :corpus string,
           :teamDriveInfo TeamDriveInfo,
           :mailOptions MailOptions,
           :driveOptions DriveOptions,
           :dataScope string,
           :sitesUrlInfo SitesUrlInfo},
   :view string}
  
  Counts the accounts processed by the specified query."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:matterId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vault.googleapis.com/"
     "v1/matters/{matterId}:count"
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
   :parentExportId string,
   :matterId string,
   :cloudStorageSink {:files [CloudStorageFile]},
   :query {:hangoutsChatOptions HangoutsChatOptions,
           :orgUnitInfo OrgUnitInfo,
           :timeZone string,
           :hangoutsChatInfo HangoutsChatInfo,
           :calendarOptions CalendarOptions,
           :startTime string,
           :terms string,
           :searchMethod string,
           :method string,
           :voiceOptions VoiceOptions,
           :endTime string,
           :sharedDriveInfo SharedDriveInfo,
           :accountInfo AccountInfo,
           :corpus string,
           :teamDriveInfo TeamDriveInfo,
           :mailOptions MailOptions,
           :driveOptions DriveOptions,
           :dataScope string,
           :sitesUrlInfo SitesUrlInfo},
   :stats {:exportedArtifactCount string,
           :totalArtifactCount string,
           :sizeInBytes string},
   :exportOptions {:mailOptions MailExportOptions,
                   :groupsOptions GroupsExportOptions,
                   :driveOptions DriveExportOptions,
                   :hangoutsChatOptions HangoutsChatExportOptions,
                   :voiceOptions VoiceExportOptions,
                   :calendarOptions CalendarExportOptions,
                   :region string}}
  
  Creates an export."
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
  
  Deletes an export."
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

(defn exports-get$
  "https://developers.google.com/vaultapi/reference/rest/v1/matters/exports/get
  
  Required parameters: matterId, exportId
  
  Optional parameters: none
  
  Gets an export."
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
  
  Optional parameters: pageSize, pageToken
  
  Lists details about the exports in the specified matter."
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

(defn holds-create$
  "https://developers.google.com/vaultapi/reference/rest/v1/matters/holds/create
  
  Required parameters: matterId
  
  Optional parameters: none
  
  Body: 
  
  {:holdId string,
   :name string,
   :updateTime string,
   :accounts [{:accountId string,
               :holdTime string,
               :email string,
               :firstName string,
               :lastName string}],
   :orgUnit {:orgUnitId string, :holdTime string},
   :corpus string,
   :query {:driveQuery HeldDriveQuery,
           :mailQuery HeldMailQuery,
           :groupsQuery HeldGroupsQuery,
           :hangoutsChatQuery HeldHangoutsChatQuery,
           :voiceQuery HeldVoiceQuery}}
  
  Creates a hold in the specified matter."
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

(defn holds-update$
  "https://developers.google.com/vaultapi/reference/rest/v1/matters/holds/update
  
  Required parameters: matterId, holdId
  
  Optional parameters: none
  
  Body: 
  
  {:holdId string,
   :name string,
   :updateTime string,
   :accounts [{:accountId string,
               :holdTime string,
               :email string,
               :firstName string,
               :lastName string}],
   :orgUnit {:orgUnitId string, :holdTime string},
   :corpus string,
   :query {:driveQuery HeldDriveQuery,
           :mailQuery HeldMailQuery,
           :groupsQuery HeldGroupsQuery,
           :hangoutsChatQuery HeldHangoutsChatQuery,
           :voiceQuery HeldVoiceQuery}}
  
  Updates the scope (organizational unit or accounts) and query parameters of a hold. You cannot add accounts to a hold that covers an organizational unit, nor can you add organizational units to a hold that covers individual accounts. If you try, the unsupported values are ignored."
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
  
  Required parameters: matterId, holdId
  
  Optional parameters: none
  
  Removes the specified hold and releases the accounts or organizational unit covered by the hold. If the data is not preserved by another hold or retention rule, it might be purged."
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

(defn holds-get$
  "https://developers.google.com/vaultapi/reference/rest/v1/matters/holds/get
  
  Required parameters: matterId, holdId
  
  Optional parameters: view
  
  Gets the specified hold."
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

(defn holds-list$
  "https://developers.google.com/vaultapi/reference/rest/v1/matters/holds/list
  
  Required parameters: matterId
  
  Optional parameters: pageSize, pageToken, view
  
  Lists the holds in a matter."
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

(defn holds-addHeldAccounts$
  "https://developers.google.com/vaultapi/reference/rest/v1/matters/holds/addHeldAccounts
  
  Required parameters: matterId, holdId
  
  Optional parameters: none
  
  Body: 
  
  {:emails [string], :accountIds [string]}
  
  Adds accounts to a hold. Returns a list of accounts that have been successfully added. Accounts can be added only to an existing account-based hold."
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

(defn holds-removeHeldAccounts$
  "https://developers.google.com/vaultapi/reference/rest/v1/matters/holds/removeHeldAccounts
  
  Required parameters: matterId, holdId
  
  Optional parameters: none
  
  Body: 
  
  {:accountIds [string]}
  
  Removes the specified accounts from a hold. Returns a list of statuses in the same order as the request."
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

(defn holds-accounts-create$
  "https://developers.google.com/vaultapi/reference/rest/v1/matters/holds/accounts/create
  
  Required parameters: matterId, holdId
  
  Optional parameters: none
  
  Body: 
  
  {:accountId string,
   :holdTime string,
   :email string,
   :firstName string,
   :lastName string}
  
  Adds an account to a hold. Accounts can be added only to a hold that does not have an organizational unit set. If you try to add an account to an organizational unit-based hold, an error is returned."
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
  
  Required parameters: matterId, holdId, accountId
  
  Optional parameters: none
  
  Removes an account from a hold."
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

(defn holds-accounts-list$
  "https://developers.google.com/vaultapi/reference/rest/v1/matters/holds/accounts/list
  
  Required parameters: matterId, holdId
  
  Optional parameters: none
  
  Lists the accounts covered by a hold. This can list only individually-specified accounts covered by the hold. If the hold covers an organizational unit, use the [Admin SDK](https://developers.google.com/admin-sdk/). to list the members of the organizational unit on hold."
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

(defn savedQueries-create$
  "https://developers.google.com/vaultapi/reference/rest/v1/matters/savedQueries/create
  
  Required parameters: matterId
  
  Optional parameters: none
  
  Body: 
  
  {:savedQueryId string,
   :displayName string,
   :query {:hangoutsChatOptions HangoutsChatOptions,
           :orgUnitInfo OrgUnitInfo,
           :timeZone string,
           :hangoutsChatInfo HangoutsChatInfo,
           :calendarOptions CalendarOptions,
           :startTime string,
           :terms string,
           :searchMethod string,
           :method string,
           :voiceOptions VoiceOptions,
           :endTime string,
           :sharedDriveInfo SharedDriveInfo,
           :accountInfo AccountInfo,
           :corpus string,
           :teamDriveInfo TeamDriveInfo,
           :mailOptions MailOptions,
           :driveOptions DriveOptions,
           :dataScope string,
           :sitesUrlInfo SitesUrlInfo},
   :matterId string,
   :createTime string}
  
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

(defn savedQueries-delete$
  "https://developers.google.com/vaultapi/reference/rest/v1/matters/savedQueries/delete
  
  Required parameters: matterId, savedQueryId
  
  Optional parameters: none
  
  Deletes the specified saved query."
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
  
  Retrieves the specified saved query."
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
  
  Optional parameters: pageSize, pageToken
  
  Lists the saved queries in a matter."
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
