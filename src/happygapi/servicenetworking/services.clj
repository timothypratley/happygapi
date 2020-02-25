(ns happygapi.servicenetworking.services
  "Service Networking API
  Provides automatic management of network configurations necessary for certain services.
  See: https://cloud.google.com/service-infrastructure/docs/service-networking/getting-started"
  (:require [cheshire.core]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "servicenetworking_schema.edn"))))

(defn validate$
  "Required parameters: parent
  
  Optional parameters: none
  
  Service producers use this method to validate if the consumer provided
  network, project and the requested range is valid. This allows them to use
  a fail-fast mechanism for consumer requests, and not have to wait for
  AddSubnetwork operation completion to determine if user request is invalid."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/service.management"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://servicenetworking.googleapis.com/"
     "v1/{+parent}:validate"
     #{"parent"}
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

(defn disableVpcServiceControls$
  "Required parameters: parent
  
  Optional parameters: none
  
  Disables VPC service controls for a connection."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/service.management"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://servicenetworking.googleapis.com/"
     "v1/{+parent}:disableVpcServiceControls"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn addSubnetwork$
  "Required parameters: parent
  
  Optional parameters: none
  
  For service producers, provisions a new subnet in a
  peered service's shared VPC network in the requested region and with the
  requested size that's expressed as a CIDR range (number of leading bits of
  ipV4 network mask). The method checks against the assigned allocated ranges
  to find a non-conflicting IP address range. The method will reuse a subnet
  if subsequent calls contain the same subnet name, region, and prefix
  length. This method will make producer's tenant project to be a shared VPC
  service project as needed. The response from the `get` operation will be of
  type `Subnetwork` if the operation successfully completes."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/service.management"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://servicenetworking.googleapis.com/"
     "v1/{+parent}:addSubnetwork"
     #{"parent"}
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

(defn searchRange$
  "Required parameters: parent
  
  Optional parameters: none
  
  Service producers can use this method to find a currently unused range
  within consumer allocated ranges.   This returned range is not reserved,
  and not guaranteed to remain unused.
  It will validate previously provided allocated ranges, find
  non-conflicting sub-range of requested size (expressed in
  number of leading bits of ipv4 network mask, as in CIDR range
  notation).
  Operation<response: Range>"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/service.management"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://servicenetworking.googleapis.com/"
     "v1/{+parent}:searchRange"
     #{"parent"}
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

(defn enableVpcServiceControls$
  "Required parameters: parent
  
  Optional parameters: none
  
  Enables VPC service controls for a connection."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/service.management"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://servicenetworking.googleapis.com/"
     "v1/{+parent}:enableVpcServiceControls"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn connections-create$
  "Required parameters: parent
  
  Optional parameters: none
  
  Creates a private connection that establishes a VPC Network Peering
  connection to a VPC network in the service producer's organization.
  The administrator of the service consumer's VPC network invokes this
  method. The administrator must assign one or more allocated IP ranges for
  provisioning subnetworks in the service producer's VPC network. This
  connection is used for all supported services in the service producer's
  organization, so it only needs to be invoked once. The response from the
  `get` operation will be of type `Connection` if the operation successfully
  completes."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/service.management"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://servicenetworking.googleapis.com/"
     "v1/{+parent}/connections"
     #{"parent"}
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

(defn connections-list$
  "Required parameters: parent
  
  Optional parameters: network
  
  List the private connections that are configured in a service consumer's
  VPC network."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/service.management"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://servicenetworking.googleapis.com/"
     "v1/{+parent}/connections"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn connections-patch$
  "Required parameters: name
  
  Optional parameters: updateMask, force
  
  Updates the allocated ranges that are assigned to a connection.
  The response from the `get` operation will be of type `Connection` if the
  operation successfully completes."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/service.management"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://servicenetworking.googleapis.com/"
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
