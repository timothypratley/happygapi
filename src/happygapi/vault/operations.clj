(ns happygapi.vault.operations
  "G Suite Vault API
  Archiving and eDiscovery for G Suite.
  See: https://developers.google.com/vault"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn delete$
  "Required parameters: name
  
  Deletes a long-running operation. This method indicates that the client is
  no longer interested in the operation result. It does not cancel the
  operation. If the server doesn't support this method, it returns
  `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes nil}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://vault.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
