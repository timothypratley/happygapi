(ns happygapi.serviceusage.services
  "Service Usage API
  Enables services that service consumers want to use on Google Cloud Platform, lists the available or enabled services, or disables services that service consumers no longer use.
  See: https://cloud.google.com/service-usage/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn get$
  "Required parameters: name
  
  Returns the service configuration and enabled state for a given service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://serviceusage.googleapis.com/"
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

(defn list$
  "Required parameters: parent
  
  List all services available to the specified project, and the current
  state of those services with respect to the project. The list includes
  all public services, all services for which the calling user has the
  `servicemanagement.services.bind` permission, and all services that have
  already been enabled on the project. The list can be filtered to
  only include services in a specific state, for example to only include
  services enabled on the project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://serviceusage.googleapis.com/"
     "v1/{+parent}/services"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn disable$
  "Required parameters: name
  
  Disable a service so that it can no longer be used with a project.
  This prevents unintended usage that may cause unexpected billing
  charges or security leaks.
  
  It is not valid to call the disable method on a service that is not
  currently enabled. Callers will receive a `FAILED_PRECONDITION` status if
  the target service is not currently enabled."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/service.management"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://serviceusage.googleapis.com/"
     "v1/{+name}:disable"
     #{"name"}
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

(defn batchEnable$
  "Required parameters: parent
  
  Enable multiple services on a project. The operation is atomic: if enabling
  any service fails, then the entire batch fails, and no state changes occur.
  To enable a single service, use the `EnableService` method instead."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/service.management"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://serviceusage.googleapis.com/"
     "v1/{+parent}/services:batchEnable"
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

(defn enable$
  "Required parameters: name
  
  Enable a service so that it can be used with a project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/service.management"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://serviceusage.googleapis.com/"
     "v1/{+name}:enable"
     #{"name"}
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
