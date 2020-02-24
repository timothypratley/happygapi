(ns happygapi.vault.matters
  "G Suite Vault API
  Archiving and eDiscovery for G Suite.
  See: https://developers.google.com/vault"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn removePermissions$
  "Required parameters: matterId
  
  Removes an account as a matter collaborator."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"matterId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vault.googleapis.com/"
     "v1/matters/{matterId}:removePermissions"
     #{"matterId"}
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

(defn get$
  "Required parameters: matterId
  
  Gets the specified matter."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"
            "https://www.googleapis.com/auth/ediscovery.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"matterId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vault.googleapis.com/"
     "v1/matters/{matterId}"
     #{"matterId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn create$
  "Required parameters: none
  
  Creates a new matter with the given name and description. The initial state
  is open, and the owner is the method caller. Returns the created matter
  with default view."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vault.googleapis.com/"
     "v1/matters"
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

(defn addPermissions$
  "Required parameters: matterId
  
  Adds an account as a matter collaborator."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"matterId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vault.googleapis.com/"
     "v1/matters/{matterId}:addPermissions"
     #{"matterId"}
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

(defn update$
  "Required parameters: matterId
  
  Updates the specified matter.
  This updates only the name and description of the matter, identified by
  matter id. Changes to any other fields are ignored.
  Returns the default view of the matter."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"]}
  [auth args]
  {:pre [(util/has-keys? args #{"matterId"})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://vault.googleapis.com/"
     "v1/matters/{matterId}"
     #{"matterId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn delete$
  "Required parameters: matterId
  
  Deletes the specified matter. Returns matter with updated state."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"]}
  [auth args]
  {:pre [(util/has-keys? args #{"matterId"})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://vault.googleapis.com/"
     "v1/matters/{matterId}"
     #{"matterId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn reopen$
  "Required parameters: matterId
  
  Reopens the specified matter. Returns matter with updated state."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"matterId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vault.googleapis.com/"
     "v1/matters/{matterId}:reopen"
     #{"matterId"}
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

(defn close$
  "Required parameters: matterId
  
  Closes the specified matter. Returns matter with updated state."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"matterId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vault.googleapis.com/"
     "v1/matters/{matterId}:close"
     #{"matterId"}
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

(defn undelete$
  "Required parameters: matterId
  
  Undeletes the specified matter. Returns matter with updated state."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"matterId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vault.googleapis.com/"
     "v1/matters/{matterId}:undelete"
     #{"matterId"}
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

(defn list$
  "Required parameters: none
  
  Lists matters the user has access to."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"
            "https://www.googleapis.com/auth/ediscovery.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vault.googleapis.com/"
     "v1/matters"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn exports-create$
  "Required parameters: matterId
  
  Creates an Export."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"matterId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vault.googleapis.com/"
     "v1/matters/{matterId}/exports"
     #{"matterId"}
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

(defn exports-delete$
  "Required parameters: matterId,exportId
  
  Deletes an Export."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"]}
  [auth args]
  {:pre [(util/has-keys? args #{"matterId" "exportId"})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://vault.googleapis.com/"
     "v1/matters/{matterId}/exports/{exportId}"
     #{"matterId" "exportId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn exports-get$
  "Required parameters: matterId,exportId
  
  Gets an Export."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"
            "https://www.googleapis.com/auth/ediscovery.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"matterId" "exportId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vault.googleapis.com/"
     "v1/matters/{matterId}/exports/{exportId}"
     #{"matterId" "exportId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn exports-list$
  "Required parameters: matterId
  
  Lists Exports."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"
            "https://www.googleapis.com/auth/ediscovery.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"matterId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vault.googleapis.com/"
     "v1/matters/{matterId}/exports"
     #{"matterId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn savedQueries-get$
  "Required parameters: matterId,savedQueryId
  
  Retrieves a saved query by Id."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"
            "https://www.googleapis.com/auth/ediscovery.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"matterId" "savedQueryId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vault.googleapis.com/"
     "v1/matters/{matterId}/savedQueries/{savedQueryId}"
     #{"matterId" "savedQueryId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn savedQueries-list$
  "Required parameters: matterId
  
  Lists saved queries within a matter. An empty page token in
  ListSavedQueriesResponse denotes no more saved queries to list."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"
            "https://www.googleapis.com/auth/ediscovery.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"matterId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vault.googleapis.com/"
     "v1/matters/{matterId}/savedQueries"
     #{"matterId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn savedQueries-create$
  "Required parameters: matterId
  
  Creates a saved query."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"matterId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vault.googleapis.com/"
     "v1/matters/{matterId}/savedQueries"
     #{"matterId"}
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

(defn savedQueries-delete$
  "Required parameters: matterId,savedQueryId
  
  Deletes a saved query by Id."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"]}
  [auth args]
  {:pre [(util/has-keys? args #{"matterId" "savedQueryId"})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://vault.googleapis.com/"
     "v1/matters/{matterId}/savedQueries/{savedQueryId}"
     #{"matterId" "savedQueryId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn holds-removeHeldAccounts$
  "Required parameters: matterId,holdId
  
  Removes HeldAccounts from a hold. Returns a list of statuses in the same
  order as the request. If this request leaves the hold with no held
  accounts, the hold will not apply to any accounts."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"matterId" "holdId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vault.googleapis.com/"
     "v1/matters/{matterId}/holds/{holdId}:removeHeldAccounts"
     #{"matterId" "holdId"}
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

(defn holds-addHeldAccounts$
  "Required parameters: holdId,matterId
  
  Adds HeldAccounts to a hold. Returns a list of accounts that have been
  successfully added. Accounts can only be added to an existing account-based
  hold."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"matterId" "holdId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vault.googleapis.com/"
     "v1/matters/{matterId}/holds/{holdId}:addHeldAccounts"
     #{"matterId" "holdId"}
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

(defn holds-get$
  "Required parameters: holdId,matterId
  
  Gets a hold by ID."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"
            "https://www.googleapis.com/auth/ediscovery.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"matterId" "holdId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vault.googleapis.com/"
     "v1/matters/{matterId}/holds/{holdId}"
     #{"matterId" "holdId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn holds-update$
  "Required parameters: matterId,holdId
  
  Updates the OU and/or query parameters of a hold. You cannot add accounts
  to a hold that covers an OU, nor can you add OUs to a hold that covers
  individual accounts. Accounts listed in the hold will be ignored."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"]}
  [auth args]
  {:pre [(util/has-keys? args #{"matterId" "holdId"})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://vault.googleapis.com/"
     "v1/matters/{matterId}/holds/{holdId}"
     #{"matterId" "holdId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn holds-delete$
  "Required parameters: holdId,matterId
  
  Removes a hold by ID. This will release any HeldAccounts on this Hold."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"]}
  [auth args]
  {:pre [(util/has-keys? args #{"matterId" "holdId"})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://vault.googleapis.com/"
     "v1/matters/{matterId}/holds/{holdId}"
     #{"matterId" "holdId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn holds-list$
  "Required parameters: matterId
  
  Lists holds within a matter. An empty page token in ListHoldsResponse
  denotes no more holds to list."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"
            "https://www.googleapis.com/auth/ediscovery.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"matterId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vault.googleapis.com/"
     "v1/matters/{matterId}/holds"
     #{"matterId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn holds-create$
  "Required parameters: matterId
  
  Creates a hold in the given matter."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"matterId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vault.googleapis.com/"
     "v1/matters/{matterId}/holds"
     #{"matterId"}
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

(defn holds-accounts-create$
  "Required parameters: matterId,holdId
  
  Adds a HeldAccount to a hold. Accounts can only be added to a hold that
  has no held_org_unit set. Attempting to add an account to an OU-based
  hold will result in an error."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"matterId" "holdId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vault.googleapis.com/"
     "v1/matters/{matterId}/holds/{holdId}/accounts"
     #{"matterId" "holdId"}
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

(defn holds-accounts-delete$
  "Required parameters: matterId,holdId,accountId
  
  Removes a HeldAccount from a hold. If this request leaves the hold with
  no held accounts, the hold will not apply to any accounts."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"]}
  [auth args]
  {:pre [(util/has-keys? args #{"matterId" "accountId" "holdId"})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://vault.googleapis.com/"
     "v1/matters/{matterId}/holds/{holdId}/accounts/{accountId}"
     #{"matterId" "accountId" "holdId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn holds-accounts-list$
  "Required parameters: matterId,holdId
  
  Lists HeldAccounts for a hold. This will only list individually specified
  held accounts. If the hold is on an OU, then use
  <a href=\"https://developers.google.com/admin-sdk/\">Admin SDK</a>
  to enumerate its members."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"
            "https://www.googleapis.com/auth/ediscovery.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"matterId" "holdId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vault.googleapis.com/"
     "v1/matters/{matterId}/holds/{holdId}/accounts"
     #{"matterId" "holdId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
