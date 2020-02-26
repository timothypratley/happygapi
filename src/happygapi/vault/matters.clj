(ns happygapi.vault.matters
  "G Suite Vault API
  Archiving and eDiscovery for G Suite.
  See: https://developers.google.com/vault"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "vault_schema.edn"))))

(defn removePermissions$
  "Required parameters: matterId
  
  Optional parameters: none
  
  Removes an account as a matter collaborator."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"matterId"})
         (json-schema/validate schemas args)]}
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
      :body (json/generate-string body)}
     auth))))

(defn get$
  "Required parameters: matterId
  
  Optional parameters: view
  
  Gets the specified matter."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"
            "https://www.googleapis.com/auth/ediscovery.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"matterId"})
         (json-schema/validate schemas args)]}
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
  
  Optional parameters: none
  
  Creates a new matter with the given name and description. The initial state
  is open, and the owner is the method caller. Returns the created matter
  with default view."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
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
      :body (json/generate-string body)}
     auth))))

(defn addPermissions$
  "Required parameters: matterId
  
  Optional parameters: none
  
  Adds an account as a matter collaborator."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"matterId"})
         (json-schema/validate schemas args)]}
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
      :body (json/generate-string body)}
     auth))))

(defn update$
  "Required parameters: matterId
  
  Optional parameters: none
  
  Updates the specified matter.
  This updates only the name and description of the matter, identified by
  matter id. Changes to any other fields are ignored.
  Returns the default view of the matter."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"matterId"})
         (json-schema/validate schemas args)]}
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
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))

(defn delete$
  "Required parameters: matterId
  
  Optional parameters: none
  
  Deletes the specified matter. Returns matter with updated state."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"]}
  [auth args]
  {:pre [(util/has-keys? args #{"matterId"})
         (json-schema/validate schemas args)]}
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
  
  Optional parameters: none
  
  Reopens the specified matter. Returns matter with updated state."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"matterId"})
         (json-schema/validate schemas args)]}
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
      :body (json/generate-string body)}
     auth))))

(defn close$
  "Required parameters: matterId
  
  Optional parameters: none
  
  Closes the specified matter. Returns matter with updated state."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"matterId"})
         (json-schema/validate schemas args)]}
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
      :body (json/generate-string body)}
     auth))))

(defn undelete$
  "Required parameters: matterId
  
  Optional parameters: none
  
  Undeletes the specified matter. Returns matter with updated state."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"matterId"})
         (json-schema/validate schemas args)]}
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
      :body (json/generate-string body)}
     auth))))

(defn list$
  "Required parameters: none
  
  Optional parameters: state, pageToken, pageSize, view
  
  Lists matters the user has access to."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"
            "https://www.googleapis.com/auth/ediscovery.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
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

(defn savedQueries-get$
  "Required parameters: savedQueryId, matterId
  
  Optional parameters: none
  
  Retrieves a saved query by Id."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"
            "https://www.googleapis.com/auth/ediscovery.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"matterId" "savedQueryId"})
         (json-schema/validate schemas args)]}
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
  
  Optional parameters: pageToken, pageSize
  
  Lists saved queries within a matter. An empty page token in
  ListSavedQueriesResponse denotes no more saved queries to list."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"
            "https://www.googleapis.com/auth/ediscovery.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"matterId"})
         (json-schema/validate schemas args)]}
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
  
  Optional parameters: none
  
  Creates a saved query."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"matterId"})
         (json-schema/validate schemas args)]}
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
      :body (json/generate-string body)}
     auth))))

(defn savedQueries-delete$
  "Required parameters: matterId, savedQueryId
  
  Optional parameters: none
  
  Deletes a saved query by Id."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"]}
  [auth args]
  {:pre [(util/has-keys? args #{"matterId" "savedQueryId"})
         (json-schema/validate schemas args)]}
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
  "Required parameters: holdId, matterId
  
  Optional parameters: none
  
  Removes HeldAccounts from a hold. Returns a list of statuses in the same
  order as the request. If this request leaves the hold with no held
  accounts, the hold will not apply to any accounts."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"matterId" "holdId"})
         (json-schema/validate schemas args)]}
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
      :body (json/generate-string body)}
     auth))))

(defn holds-get$
  "Required parameters: matterId, holdId
  
  Optional parameters: view
  
  Gets a hold by ID."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"
            "https://www.googleapis.com/auth/ediscovery.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"matterId" "holdId"})
         (json-schema/validate schemas args)]}
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

(defn holds-addHeldAccounts$
  "Required parameters: holdId, matterId
  
  Optional parameters: none
  
  Adds HeldAccounts to a hold. Returns a list of accounts that have been
  successfully added. Accounts can only be added to an existing account-based
  hold."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"matterId" "holdId"})
         (json-schema/validate schemas args)]}
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
      :body (json/generate-string body)}
     auth))))

(defn holds-update$
  "Required parameters: holdId, matterId
  
  Optional parameters: none
  
  Updates the OU and/or query parameters of a hold. You cannot add accounts
  to a hold that covers an OU, nor can you add OUs to a hold that covers
  individual accounts. Accounts listed in the hold will be ignored."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"matterId" "holdId"})
         (json-schema/validate schemas args)]}
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
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))

(defn holds-delete$
  "Required parameters: matterId, holdId
  
  Optional parameters: none
  
  Removes a hold by ID. This will release any HeldAccounts on this Hold."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"]}
  [auth args]
  {:pre [(util/has-keys? args #{"matterId" "holdId"})
         (json-schema/validate schemas args)]}
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
  
  Optional parameters: view, pageToken, pageSize
  
  Lists holds within a matter. An empty page token in ListHoldsResponse
  denotes no more holds to list."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"
            "https://www.googleapis.com/auth/ediscovery.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"matterId"})
         (json-schema/validate schemas args)]}
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
  
  Optional parameters: none
  
  Creates a hold in the given matter."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"matterId"})
         (json-schema/validate schemas args)]}
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
      :body (json/generate-string body)}
     auth))))

(defn holds-accounts-create$
  "Required parameters: matterId, holdId
  
  Optional parameters: none
  
  Adds a HeldAccount to a hold. Accounts can only be added to a hold that
  has no held_org_unit set. Attempting to add an account to an OU-based
  hold will result in an error."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"matterId" "holdId"})
         (json-schema/validate schemas args)]}
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
      :body (json/generate-string body)}
     auth))))

(defn holds-accounts-delete$
  "Required parameters: holdId, accountId, matterId
  
  Optional parameters: none
  
  Removes a HeldAccount from a hold. If this request leaves the hold with
  no held accounts, the hold will not apply to any accounts."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"]}
  [auth args]
  {:pre [(util/has-keys? args #{"matterId" "accountId" "holdId"})
         (json-schema/validate schemas args)]}
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
  "Required parameters: holdId, matterId
  
  Optional parameters: none
  
  Lists HeldAccounts for a hold. This will only list individually specified
  held accounts. If the hold is on an OU, then use
  <a href=\"https://developers.google.com/admin-sdk/\">Admin SDK</a>
  to enumerate its members."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"
            "https://www.googleapis.com/auth/ediscovery.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"matterId" "holdId"})
         (json-schema/validate schemas args)]}
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

(defn exports-delete$
  "Required parameters: matterId, exportId
  
  Optional parameters: none
  
  Deletes an Export."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"]}
  [auth args]
  {:pre [(util/has-keys? args #{"matterId" "exportId"})
         (json-schema/validate schemas args)]}
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
  "Required parameters: matterId, exportId
  
  Optional parameters: none
  
  Gets an Export."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"
            "https://www.googleapis.com/auth/ediscovery.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"matterId" "exportId"})
         (json-schema/validate schemas args)]}
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
  
  Optional parameters: pageToken, pageSize
  
  Lists Exports."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"
            "https://www.googleapis.com/auth/ediscovery.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"matterId"})
         (json-schema/validate schemas args)]}
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

(defn exports-create$
  "Required parameters: matterId
  
  Optional parameters: none
  
  Creates an Export."
  {:scopes ["https://www.googleapis.com/auth/ediscovery"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"matterId"})
         (json-schema/validate schemas args)]}
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
      :body (json/generate-string body)}
     auth))))
