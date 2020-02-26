(ns happygapi.classroom.userProfiles
  "Google Classroom API
  Manages classes, rosters, and invitations in Google Classroom.
  See: https://developers.google.com/classroom/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "classroom_schema.edn"))))

(defn get$
  "Required parameters: userId
  
  Optional parameters: none
  
  Returns a user profile.
  
  This method returns the following error codes:
  
  * `PERMISSION_DENIED` if the requesting user is not permitted to access
  this user profile, if no profile exists with the requested ID, or for
  access errors."
  {:scopes ["https://www.googleapis.com/auth/classroom.profile.emails"
            "https://www.googleapis.com/auth/classroom.profile.photos"
            "https://www.googleapis.com/auth/classroom.rosters"
            "https://www.googleapis.com/auth/classroom.rosters.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"userId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/userProfiles/{userId}"
     #{"userId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn guardians-delete$
  "Required parameters: studentId, guardianId
  
  Optional parameters: none
  
  Deletes a guardian.
  
  The guardian will no longer receive guardian notifications and the guardian
  will no longer be accessible via the API.
  
  This method returns the following error codes:
  
  * `PERMISSION_DENIED` if no user that matches the provided `student_id`
    is visible to the requesting user, if the requesting user is not
    permitted to manage guardians for the student identified by the
    `student_id`, if guardians are not enabled for the domain in question,
    or for other access errors.
  * `INVALID_ARGUMENT` if a `student_id` is specified, but its format cannot
    be recognized (it is not an email address, nor a `student_id` from the
    API).
  * `NOT_FOUND` if the requesting user is permitted to modify guardians for
    the requested `student_id`, but no `Guardian` record exists for that
    student with the provided `guardian_id`."
  {:scopes ["https://www.googleapis.com/auth/classroom.guardianlinks.students"]}
  [auth args]
  {:pre [(util/has-keys? args #{"guardianId" "studentId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/userProfiles/{studentId}/guardians/{guardianId}"
     #{"guardianId" "studentId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn guardians-list$
  "Required parameters: studentId
  
  Optional parameters: pageToken, invitedEmailAddress, pageSize
  
  Returns a list of guardians that the requesting user is permitted to
  view, restricted to those that match the request.
  
  To list guardians for any student that the requesting user may view
  guardians for, use the literal character `-` for the student ID.
  
  This method returns the following error codes:
  
  * `PERMISSION_DENIED` if a `student_id` is specified, and the requesting
    user is not permitted to view guardian information for that student, if
    `\"-\"` is specified as the `student_id` and the user is not a domain
    administrator, if guardians are not enabled for the domain in question,
    if the `invited_email_address` filter is set by a user who is not a
    domain administrator, or for other access errors.
  * `INVALID_ARGUMENT` if a `student_id` is specified, but its format cannot
    be recognized (it is not an email address, nor a `student_id` from the
    API, nor the literal string `me`). May also be returned if an invalid
    `page_token` is provided.
  * `NOT_FOUND` if a `student_id` is specified, and its format can be
    recognized, but Classroom has no record of that student."
  {:scopes ["https://www.googleapis.com/auth/classroom.guardianlinks.me.readonly"
            "https://www.googleapis.com/auth/classroom.guardianlinks.students"
            "https://www.googleapis.com/auth/classroom.guardianlinks.students.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"studentId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/userProfiles/{studentId}/guardians"
     #{"studentId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn guardians-get$
  "Required parameters: studentId, guardianId
  
  Optional parameters: none
  
  Returns a specific guardian.
  
  This method returns the following error codes:
  
  * `PERMISSION_DENIED` if no user that matches the provided `student_id`
    is visible to the requesting user, if the requesting user is not
    permitted to view guardian information for the student identified by the
    `student_id`, if guardians are not enabled for the domain in question,
    or for other access errors.
  * `INVALID_ARGUMENT` if a `student_id` is specified, but its format cannot
    be recognized (it is not an email address, nor a `student_id` from the
    API, nor the literal string `me`).
  * `NOT_FOUND` if the requesting user is permitted to view guardians for
    the requested `student_id`, but no `Guardian` record exists for that
    student that matches the provided `guardian_id`."
  {:scopes ["https://www.googleapis.com/auth/classroom.guardianlinks.me.readonly"
            "https://www.googleapis.com/auth/classroom.guardianlinks.students"
            "https://www.googleapis.com/auth/classroom.guardianlinks.students.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"guardianId" "studentId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/userProfiles/{studentId}/guardians/{guardianId}"
     #{"guardianId" "studentId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn guardianInvitations-list$
  "Required parameters: studentId
  
  Optional parameters: pageToken, invitedEmailAddress, states, pageSize
  
  Returns a list of guardian invitations that the requesting user is
  permitted to view, filtered by the parameters provided.
  
  This method returns the following error codes:
  
  * `PERMISSION_DENIED` if a `student_id` is specified, and the requesting
    user is not permitted to view guardian invitations for that student, if
    `\"-\"` is specified as the `student_id` and the user is not a domain
    administrator, if guardians are not enabled for the domain in question,
    or for other access errors.
  * `INVALID_ARGUMENT` if a `student_id` is specified, but its format cannot
    be recognized (it is not an email address, nor a `student_id` from the
    API, nor the literal string `me`). May also be returned if an invalid
    `page_token` or `state` is provided.
  * `NOT_FOUND` if a `student_id` is specified, and its format can be
    recognized, but Classroom has no record of that student."
  {:scopes ["https://www.googleapis.com/auth/classroom.guardianlinks.students"
            "https://www.googleapis.com/auth/classroom.guardianlinks.students.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"studentId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/userProfiles/{studentId}/guardianInvitations"
     #{"studentId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn guardianInvitations-get$
  "Required parameters: invitationId, studentId
  
  Optional parameters: none
  
  Returns a specific guardian invitation.
  
  This method returns the following error codes:
  
  * `PERMISSION_DENIED` if the requesting user is not permitted to view
    guardian invitations for the student identified by the `student_id`, if
    guardians are not enabled for the domain in question, or for other
    access errors.
  * `INVALID_ARGUMENT` if a `student_id` is specified, but its format cannot
    be recognized (it is not an email address, nor a `student_id` from the
    API, nor the literal string `me`).
  * `NOT_FOUND` if Classroom cannot find any record of the given student or
    `invitation_id`. May also be returned if the student exists, but the
    requesting user does not have access to see that student."
  {:scopes ["https://www.googleapis.com/auth/classroom.guardianlinks.students"
            "https://www.googleapis.com/auth/classroom.guardianlinks.students.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"studentId" "invitationId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/userProfiles/{studentId}/guardianInvitations/{invitationId}"
     #{"studentId" "invitationId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn guardianInvitations-patch$
  "Required parameters: studentId, invitationId
  
  Optional parameters: updateMask
  
  Modifies a guardian invitation.
  
  Currently, the only valid modification is to change the `state` from
  `PENDING` to `COMPLETE`. This has the effect of withdrawing the invitation.
  
  This method returns the following error codes:
  
  * `PERMISSION_DENIED` if the current user does not have permission to
    manage guardians, if guardians are not enabled for the domain in question
    or for other access errors.
  * `FAILED_PRECONDITION` if the guardian link is not in the `PENDING` state.
  * `INVALID_ARGUMENT` if the format of the student ID provided
    cannot be recognized (it is not an email address, nor a `user_id` from
    this API), or if the passed `GuardianInvitation` has a `state` other than
    `COMPLETE`, or if it modifies fields other than `state`.
  * `NOT_FOUND` if the student ID provided is a valid student ID, but
    Classroom has no record of that student, or if the `id` field does not
    refer to a guardian invitation known to Classroom."
  {:scopes ["https://www.googleapis.com/auth/classroom.guardianlinks.students"]}
  [auth args]
  {:pre [(util/has-keys? args #{"studentId" "invitationId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/userProfiles/{studentId}/guardianInvitations/{invitationId}"
     #{"studentId" "invitationId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn guardianInvitations-create$
  "Required parameters: studentId
  
  Optional parameters: none
  
  Creates a guardian invitation, and sends an email to the guardian asking
  them to confirm that they are the student's guardian.
  
  Once the guardian accepts the invitation, their `state` will change to
  `COMPLETED` and they will start receiving guardian notifications. A
  `Guardian` resource will also be created to represent the active guardian.
  
  The request object must have the `student_id` and
  `invited_email_address` fields set. Failing to set these fields, or
  setting any other fields in the request, will result in an error.
  
  This method returns the following error codes:
  
  * `PERMISSION_DENIED` if the current user does not have permission to
    manage guardians, if the guardian in question has already rejected
    too many requests for that student, if guardians are not enabled for the
    domain in question, or for other access errors.
  * `RESOURCE_EXHAUSTED` if the student or guardian has exceeded the guardian
    link limit.
  * `INVALID_ARGUMENT` if the guardian email address is not valid (for
    example, if it is too long), or if the format of the student ID provided
    cannot be recognized (it is not an email address, nor a `user_id` from
    this API). This error will also be returned if read-only fields are set,
    or if the `state` field is set to to a value other than `PENDING`.
  * `NOT_FOUND` if the student ID provided is a valid student ID, but
    Classroom has no record of that student.
  * `ALREADY_EXISTS` if there is already a pending guardian invitation for
    the student and `invited_email_address` provided, or if the provided
    `invited_email_address` matches the Google account of an existing
    `Guardian` for this user."
  {:scopes ["https://www.googleapis.com/auth/classroom.guardianlinks.students"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"studentId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/userProfiles/{studentId}/guardianInvitations"
     #{"studentId"}
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
