(ns happygapi.classroom.registrations
  "Google Classroom API: registrations.
  Manages classes, rosters, and invitations in Google Classroom.
  See: https://developers.google.com/classroom/api/reference/rest/v1/registrations"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn create$
  "https://developers.google.com/classroom/api/reference/rest/v1/registrations/create
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:cloudPubsubTopic {:topicName string},
   :expiryTime string,
   :feed {:courseWorkChangesInfo CourseWorkChangesInfo,
          :courseRosterChangesInfo CourseRosterChangesInfo,
          :feedType string},
   :registrationId string}
  
  Creates a `Registration`, causing Classroom to start sending notifications from the provided `feed` to the destination provided in `cloudPubSubTopic`. Returns the created `Registration`. Currently, this will be the same as the argument, but with server-assigned fields such as `expiry_time` and `id` filled in. Note that any value specified for the `expiry_time` or `id` fields will be ignored. While Classroom may validate the `cloudPubSubTopic` and return errors on a best effort basis, it is the caller's responsibility to ensure that it exists and that Classroom has permission to publish to it. This method may return the following error codes: * `PERMISSION_DENIED` if: * the authenticated user does not have permission to receive notifications from the requested field; or * the current user has not granted access to the current Cloud project with the appropriate scope for the requested feed. Note that domain-wide delegation of authority is not currently supported for this purpose. If the request has the appropriate scope, but no grant exists, a Request Errors is returned. * another access error is encountered. * `INVALID_ARGUMENT` if: * no `cloudPubsubTopic` is specified, or the specified `cloudPubsubTopic` is not valid; or * no `feed` is specified, or the specified `feed` is not valid. * `NOT_FOUND` if: * the specified `feed` cannot be located, or the requesting user does not have permission to determine whether or not it exists; or * the specified `cloudPubsubTopic` cannot be located, or Classroom has not been granted permission to publish to it."
  {:scopes ["https://www.googleapis.com/auth/classroom.push-notifications"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/registrations"
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

(defn delete$
  "https://developers.google.com/classroom/api/reference/rest/v1/registrations/delete
  
  Required parameters: registrationId
  
  Optional parameters: none
  
  Deletes a `Registration`, causing Classroom to stop sending notifications for that `Registration`."
  {:scopes ["https://www.googleapis.com/auth/classroom.push-notifications"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:registrationId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/registrations/{registrationId}"
     #{:registrationId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
