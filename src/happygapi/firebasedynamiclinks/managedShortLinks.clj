(ns happygapi.firebasedynamiclinks.managedShortLinks
  "Firebase Dynamic Links API: managedShortLinks.
  Programmatically creates and manages Firebase Dynamic Links.
  See: https://firebase.google.com/docs/dynamic-links/api/reference/rest/v1/managedShortLinks"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn create$
  "https://firebase.google.com/docs/dynamic-links/api/reference/rest/v1/managedShortLinks/create
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :sdkVersion string,
   :dynamicLinkInfo {:socialMetaTagInfo SocialMetaTagInfo,
                     :analyticsInfo AnalyticsInfo,
                     :desktopInfo DesktopInfo,
                     :link string,
                     :navigationInfo NavigationInfo,
                     :iosInfo IosInfo,
                     :domainUriPrefix string,
                     :androidInfo AndroidInfo,
                     :dynamicLinkDomain string},
   :suffix {:customSuffix string, :option string},
   :longDynamicLink string}
  
  Creates a managed short Dynamic Link given either a valid long Dynamic Link or details such as Dynamic Link domain, Android and iOS app information. The created short Dynamic Link will not expire. This differs from CreateShortDynamicLink in the following ways: - The request will also contain a name for the link (non unique name for the front end). - The response must be authenticated with an auth token (generated with the admin service account). - The link will appear in the FDL list of links in the console front end. The Dynamic Link domain in the request must be owned by requester's Firebase project."
  {:scopes ["https://www.googleapis.com/auth/firebase"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firebasedynamiclinks.googleapis.com/"
     "v1/managedShortLinks:create"
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
