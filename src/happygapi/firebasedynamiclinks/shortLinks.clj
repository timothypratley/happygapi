(ns happygapi.firebasedynamiclinks.shortLinks
  "Firebase Dynamic Links API: shortLinks.
  Programmatically creates and manages Firebase Dynamic Links.
  See: https://firebase.google.com/docs/dynamic-links/api/reference/rest/v1/shortLinks"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn create$
  "https://firebase.google.com/docs/dynamic-links/api/reference/rest/v1/shortLinks/create
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:suffix {:option string, :customSuffix string},
   :longDynamicLink string,
   :sdkVersion string,
   :dynamicLinkInfo {:socialMetaTagInfo SocialMetaTagInfo,
                     :analyticsInfo AnalyticsInfo,
                     :desktopInfo DesktopInfo,
                     :link string,
                     :navigationInfo NavigationInfo,
                     :iosInfo IosInfo,
                     :domainUriPrefix string,
                     :androidInfo AndroidInfo,
                     :dynamicLinkDomain string}}
  
  Creates a short Dynamic Link given either a valid long Dynamic Link or details such as Dynamic Link domain, Android and iOS app information. The created short Dynamic Link will not expire. Repeated calls with the same long Dynamic Link or Dynamic Link information will produce the same short Dynamic Link. The Dynamic Link domain in the request must be owned by requester's Firebase project."
  {:scopes ["https://www.googleapis.com/auth/firebase"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firebasedynamiclinks.googleapis.com/"
     "v1/shortLinks"
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
