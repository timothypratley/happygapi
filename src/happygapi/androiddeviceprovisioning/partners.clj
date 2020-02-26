(ns happygapi.androiddeviceprovisioning.partners
  "Android Device Provisioning Partner API
  Automates Android zero-touch enrollment for device resellers, customers, and EMMs.
  See: https://developers.google.com/zero-touch/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string
   (slurp (io/resource "androiddeviceprovisioning_schema.edn"))))

(defn devices-get$
  "Required parameters: name
  
  Optional parameters: none
  
  Gets a device."
  {:scopes nil}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://androiddeviceprovisioning.googleapis.com/"
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

(defn devices-findByOwner$
  "Required parameters: partnerId
  
  Optional parameters: none
  
  Finds devices claimed for customers. The results only contain devices
  registered to the reseller that's identified by the `partnerId` argument.
  The customer's devices purchased from other resellers don't appear in the
  results."
  {:scopes nil}
  [auth args body]
  {:pre [(util/has-keys? args #{"partnerId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androiddeviceprovisioning.googleapis.com/"
     "v1/partners/{+partnerId}/devices:findByOwner"
     #{"partnerId"}
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

(defn devices-findByIdentifier$
  "Required parameters: partnerId
  
  Optional parameters: none
  
  Finds devices by hardware identifiers, such as IMEI."
  {:scopes nil}
  [auth args body]
  {:pre [(util/has-keys? args #{"partnerId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androiddeviceprovisioning.googleapis.com/"
     "v1/partners/{+partnerId}/devices:findByIdentifier"
     #{"partnerId"}
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

(defn devices-unclaim$
  "Required parameters: partnerId
  
  Optional parameters: none
  
  Unclaims a device from a customer and removes it from zero-touch
  enrollment."
  {:scopes nil}
  [auth args body]
  {:pre [(util/has-keys? args #{"partnerId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androiddeviceprovisioning.googleapis.com/"
     "v1/partners/{+partnerId}/devices:unclaim"
     #{"partnerId"}
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

(defn devices-claimAsync$
  "Required parameters: partnerId
  
  Optional parameters: none
  
  Claims a batch of devices for a customer asynchronously. Adds the devices
  to zero-touch enrollment. To learn more, read [Long‑running batch
  operations](/zero-touch/guides/how-it-works#operations)."
  {:scopes nil}
  [auth args body]
  {:pre [(util/has-keys? args #{"partnerId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androiddeviceprovisioning.googleapis.com/"
     "v1/partners/{+partnerId}/devices:claimAsync"
     #{"partnerId"}
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

(defn devices-updateMetadataAsync$
  "Required parameters: partnerId
  
  Optional parameters: none
  
  Updates the reseller metadata attached to a batch of devices. This method
  updates devices asynchronously and returns an `Operation` that can be used
  to track progress. Read [Long‑running batch
  operations](/zero-touch/guides/how-it-works#operations)."
  {:scopes nil}
  [auth args body]
  {:pre [(util/has-keys? args #{"partnerId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androiddeviceprovisioning.googleapis.com/"
     "v1/partners/{+partnerId}/devices:updateMetadataAsync"
     #{"partnerId"}
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

(defn devices-unclaimAsync$
  "Required parameters: partnerId
  
  Optional parameters: none
  
  Unclaims a batch of devices for a customer asynchronously. Removes the
  devices from zero-touch enrollment. To learn more, read [Long‑running batch
  operations](/zero-touch/guides/how-it-works#operations)."
  {:scopes nil}
  [auth args body]
  {:pre [(util/has-keys? args #{"partnerId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androiddeviceprovisioning.googleapis.com/"
     "v1/partners/{+partnerId}/devices:unclaimAsync"
     #{"partnerId"}
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

(defn devices-metadata$
  "Required parameters: metadataOwnerId, deviceId
  
  Optional parameters: none
  
  Updates reseller metadata associated with the device."
  {:scopes nil}
  [auth args body]
  {:pre [(util/has-keys? args #{"metadataOwnerId" "deviceId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androiddeviceprovisioning.googleapis.com/"
     "v1/partners/{+metadataOwnerId}/devices/{+deviceId}/metadata"
     #{"metadataOwnerId" "deviceId"}
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

(defn devices-claim$
  "Required parameters: partnerId
  
  Optional parameters: none
  
  Claims a device for a customer and adds it to zero-touch enrollment. If the
  device is already claimed by another customer, the call returns an error."
  {:scopes nil}
  [auth args body]
  {:pre [(util/has-keys? args #{"partnerId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androiddeviceprovisioning.googleapis.com/"
     "v1/partners/{+partnerId}/devices:claim"
     #{"partnerId"}
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

(defn customers-list$
  "Required parameters: partnerId
  
  Optional parameters: pageToken, pageSize
  
  Lists the customers that are enrolled to the reseller identified by the
  `partnerId` argument. This list includes customers that the reseller
  created and customers that enrolled themselves using the portal."
  {:scopes nil}
  [auth args]
  {:pre [(util/has-keys? args #{"partnerId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://androiddeviceprovisioning.googleapis.com/"
     "v1/partners/{+partnerId}/customers"
     #{"partnerId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn customers-create$
  "Required parameters: parent
  
  Optional parameters: none
  
  Creates a customer for zero-touch enrollment. After the method returns
  successfully, admin and owner roles can manage devices and EMM configs
  by calling API methods or using their zero-touch enrollment portal.
  The customer receives an email that welcomes them to zero-touch enrollment
  and explains how to sign into the portal."
  {:scopes nil}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androiddeviceprovisioning.googleapis.com/"
     "v1/{+parent}/customers"
     #{"parent"}
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

(defn vendors-list$
  "Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Lists the vendors of the partner."
  {:scopes nil}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://androiddeviceprovisioning.googleapis.com/"
     "v1/{+parent}/vendors"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn vendors-customers-list$
  "Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Lists the customers of the vendor."
  {:scopes nil}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://androiddeviceprovisioning.googleapis.com/"
     "v1/{+parent}/customers"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
