(ns happygapi.classroom.invitations
  "Google Classroom API
  Manages classes, rosters, and invitations in Google Classroom.
  See: https://developers.google.com/classroom/"
  (:require [cheshire.core]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "classroom_schema.edn"))))

(defn create$
  "Required parameters: none
  
  Optional parameters: none
  
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
  [auth args body]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/invitations"
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

(defn accept$
  "Required parameters: id
  
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
  [auth args body]
  {:pre [(util/has-keys? args #{"id"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/invitations/{id}:accept"
     #{"id"}
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

(defn delete$
  "Required parameters: id
  
  Optional parameters: none
  
  Deletes an invitation.
  
  This method returns the following error codes:
  
  * `PERMISSION_DENIED` if the requesting user is not permitted to delete the
  requested invitation or for access errors.
  * `NOT_FOUND` if no invitation exists with the requested ID."
  {:scopes ["https://www.googleapis.com/auth/classroom.rosters"]}
  [auth args]
  {:pre [(util/has-keys? args #{"id"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/invitations/{id}"
     #{"id"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "Required parameters: id
  
  Optional parameters: none
  
  Returns an invitation.
  
  This method returns the following error codes:
  
  * `PERMISSION_DENIED` if the requesting user is not permitted to view the
  requested invitation or for access errors.
  * `NOT_FOUND` if no invitation exists with the requested ID."
  {:scopes ["https://www.googleapis.com/auth/classroom.rosters"
            "https://www.googleapis.com/auth/classroom.rosters.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"id"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/invitations/{id}"
     #{"id"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "Required parameters: none
  
  Optional parameters: userId, pageToken, pageSize, courseId
  
  Returns a list of invitations that the requesting user is permitted to
  view, restricted to those that match the list request.
  
  *Note:* At least one of `user_id` or `course_id` must be supplied. Both
  fields can be supplied.
  
  This method returns the following error codes:
  
  * `PERMISSION_DENIED` for access errors."
  {:scopes ["https://www.googleapis.com/auth/classroom.rosters"
            "https://www.googleapis.com/auth/classroom.rosters.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/invitations"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
