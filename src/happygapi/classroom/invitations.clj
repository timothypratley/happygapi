(ns happygapi.classroom.invitations
  "Google Classroom API: invitations.
  Manages classes, rosters, and invitations in Google Classroom.
  See: https://developers.google.com/classroom/api/reference/rest/v1/invitations"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn accept$
  "https://developers.google.com/classroom/api/reference/rest/v1/invitations/accept
  
  Required parameters: id
  
  Optional parameters: none
  
  Accepts an invitation, removing it and adding the invited user to the
  teachers or students (as appropriate) of the specified course. Only the
  invited user may accept an invitation.
  
  This method returns the following error codes:
  
  * `PERMISSION_DENIED` if the requesting user is not permitted to accept the
  requested invitation or for access errors.
  * `FAILED_PRECONDITION` for the following request errors:
      * CourseMemberLimitReached
      * CourseNotModifiable
      * CourseTeacherLimitReached
      * UserGroupsMembershipLimitReached
  * `NOT_FOUND` if no invitation exists with the requested ID."
  {:scopes ["https://www.googleapis.com/auth/classroom.rosters"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/invitations/{id}:accept"
     #{:id}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn delete$
  "https://developers.google.com/classroom/api/reference/rest/v1/invitations/delete
  
  Required parameters: id
  
  Optional parameters: none
  
  Deletes an invitation.
  
  This method returns the following error codes:
  
  * `PERMISSION_DENIED` if the requesting user is not permitted to delete the
  requested invitation or for access errors.
  * `NOT_FOUND` if no invitation exists with the requested ID."
  {:scopes ["https://www.googleapis.com/auth/classroom.rosters"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/invitations/{id}"
     #{:id}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/classroom/api/reference/rest/v1/invitations/get
  
  Required parameters: id
  
  Optional parameters: none
  
  Returns an invitation.
  
  This method returns the following error codes:
  
  * `PERMISSION_DENIED` if the requesting user is not permitted to view the
  requested invitation or for access errors.
  * `NOT_FOUND` if no invitation exists with the requested ID."
  {:scopes ["https://www.googleapis.com/auth/classroom.rosters"
            "https://www.googleapis.com/auth/classroom.rosters.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/invitations/{id}"
     #{:id}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/classroom/api/reference/rest/v1/invitations/list
  
  Required parameters: none
  
  Optional parameters: userId, pageToken, pageSize, courseId
  
  Returns a list of invitations that the requesting user is permitted to
  view, restricted to those that match the list request.
  
  *Note:* At least one of `user_id` or `course_id` must be supplied. Both
  fields can be supplied.
  
  This method returns the following error codes:
  
  * `PERMISSION_DENIED` for access errors."
  {:scopes ["https://www.googleapis.com/auth/classroom.rosters"
            "https://www.googleapis.com/auth/classroom.rosters.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/invitations"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn create$
  "https://developers.google.com/classroom/api/reference/rest/v1/invitations/create
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:role string, :userId string, :courseId string, :id string}
  
  Creates an invitation. Only one invitation for a user and course may exist
  at a time. Delete and re-create an invitation to make changes.
  
  This method returns the following error codes:
  
  * `PERMISSION_DENIED` if the requesting user is not permitted to create
  invitations for this course or for access errors.
  * `NOT_FOUND` if the course or the user does not exist.
  * `FAILED_PRECONDITION` if the requested user's account is disabled or if
  the user already has this role or a role with greater permissions.
  * `ALREADY_EXISTS` if an invitation for the specified user and course
  already exists."
  {:scopes ["https://www.googleapis.com/auth/classroom.rosters"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/invitations"
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
