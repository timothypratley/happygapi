(ns happygapi.classroom.courses
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

(defn delete$
  "Required parameters: id
  
  Optional parameters: none
  
  Deletes a course.
  
  This method returns the following error codes:
  
  * `PERMISSION_DENIED` if the requesting user is not permitted to delete the
  requested course or for access errors.
  * `NOT_FOUND` if no course exists with the requested ID."
  {:scopes ["https://www.googleapis.com/auth/classroom.courses"]}
  [auth args]
  {:pre [(util/has-keys? args #{"id"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{id}"
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
  
  Optional parameters: teacherId, courseStates, studentId, pageToken, pageSize
  
  Returns a list of courses that the requesting user is permitted to view,
  restricted to those that match the request. Returned courses are ordered by
  creation time, with the most recently created coming first.
  
  This method returns the following error codes:
  
  * `PERMISSION_DENIED` for access errors.
  * `INVALID_ARGUMENT` if the query argument is malformed.
  * `NOT_FOUND` if any users specified in the query arguments do not exist."
  {:scopes ["https://www.googleapis.com/auth/classroom.courses"
            "https://www.googleapis.com/auth/classroom.courses.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn create$
  "Required parameters: none
  
  Optional parameters: none
  
  Creates a course.
  
  The user specified in `ownerId` is the owner of the created course
  and added as a teacher.
  
  This method returns the following error codes:
  
  * `PERMISSION_DENIED` if the requesting user is not permitted to create
  courses or for access errors.
  * `NOT_FOUND` if the primary teacher is not a valid user.
  * `FAILED_PRECONDITION` if the course owner's account is disabled or for
  the following request errors:
      * UserGroupsMembershipLimitReached
  * `ALREADY_EXISTS` if an alias was specified in the `id` and
  already exists."
  {:scopes ["https://www.googleapis.com/auth/classroom.courses"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses"
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

(defn get$
  "Required parameters: id
  
  Optional parameters: none
  
  Returns a course.
  
  This method returns the following error codes:
  
  * `PERMISSION_DENIED` if the requesting user is not permitted to access the
  requested course or for access errors.
  * `NOT_FOUND` if no course exists with the requested ID."
  {:scopes ["https://www.googleapis.com/auth/classroom.courses"
            "https://www.googleapis.com/auth/classroom.courses.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"id"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{id}"
     #{"id"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "Required parameters: id
  
  Optional parameters: updateMask
  
  Updates one or more fields in a course.
  
  This method returns the following error codes:
  
  * `PERMISSION_DENIED` if the requesting user is not permitted to modify the
  requested course or for access errors.
  * `NOT_FOUND` if no course exists with the requested ID.
  * `INVALID_ARGUMENT` if invalid fields are specified in the update mask or
  if no update mask is supplied.
  * `FAILED_PRECONDITION` for the following request errors:
      * CourseNotModifiable"
  {:scopes ["https://www.googleapis.com/auth/classroom.courses"]}
  [auth args]
  {:pre [(util/has-keys? args #{"id"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{id}"
     #{"id"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "Required parameters: id
  
  Optional parameters: none
  
  Updates a course.
  
  This method returns the following error codes:
  
  * `PERMISSION_DENIED` if the requesting user is not permitted to modify the
  requested course or for access errors.
  * `NOT_FOUND` if no course exists with the requested ID.
  * `FAILED_PRECONDITION` for the following request errors:
      * CourseNotModifiable"
  {:scopes ["https://www.googleapis.com/auth/classroom.courses"]}
  [auth args]
  {:pre [(util/has-keys? args #{"id"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/put
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{id}"
     #{"id"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn courseWork-list$
  "Required parameters: courseId
  
  Optional parameters: orderBy, pageToken, pageSize, courseWorkStates
  
  Returns a list of course work that the requester is permitted to view.
  
  Course students may only view `PUBLISHED` course work. Course teachers
  and domain administrators may view all course work.
  
  This method returns the following error codes:
  
  * `PERMISSION_DENIED` if the requesting user is not permitted to access
  the requested course or for access errors.
  * `INVALID_ARGUMENT` if the request is malformed.
  * `NOT_FOUND` if the requested course does not exist."
  {:scopes ["https://www.googleapis.com/auth/classroom.coursework.me"
            "https://www.googleapis.com/auth/classroom.coursework.me.readonly"
            "https://www.googleapis.com/auth/classroom.coursework.students"
            "https://www.googleapis.com/auth/classroom.coursework.students.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"courseId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{courseId}/courseWork"
     #{"courseId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn courseWork-create$
  "Required parameters: courseId
  
  Optional parameters: none
  
  Creates course work.
  
  The resulting course work (and corresponding student submissions) are
  associated with the Developer Console project of the
  [OAuth client ID](https://support.google.com/cloud/answer/6158849) used to
  make the request. Classroom API requests to modify course work and student
  submissions must be made with an OAuth client ID from the associated
  Developer Console project.
  
  This method returns the following error codes:
  
  * `PERMISSION_DENIED` if the requesting user is not permitted to access the
  requested course, create course work in the requested course, share a
  Drive attachment, or for access errors.
  * `INVALID_ARGUMENT` if the request is malformed.
  * `NOT_FOUND` if the requested course does not exist.
  * `FAILED_PRECONDITION` for the following request error:
      * AttachmentNotVisible"
  {:scopes ["https://www.googleapis.com/auth/classroom.coursework.students"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"courseId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{courseId}/courseWork"
     #{"courseId"}
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

(defn courseWork-modifyAssignees$
  "Required parameters: courseId, id
  
  Optional parameters: none
  
  Modifies assignee mode and options of a coursework.
  
  Only a teacher of the course that contains the coursework may
  call this method.
  
  This method returns the following error codes:
  
  * `PERMISSION_DENIED` if the requesting user is not permitted to access the
  requested course or course work or for access errors.
  * `INVALID_ARGUMENT` if the request is malformed.
  * `NOT_FOUND` if the requested course or course work does not exist."
  {:scopes ["https://www.googleapis.com/auth/classroom.coursework.students"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"courseId" "id"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{courseId}/courseWork/{id}:modifyAssignees"
     #{"courseId" "id"}
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

(defn courseWork-get$
  "Required parameters: courseId, id
  
  Optional parameters: none
  
  Returns course work.
  
  This method returns the following error codes:
  
  * `PERMISSION_DENIED` if the requesting user is not permitted to access the
  requested course or course work, or for access errors.
  * `INVALID_ARGUMENT` if the request is malformed.
  * `NOT_FOUND` if the requested course or course work does not exist."
  {:scopes ["https://www.googleapis.com/auth/classroom.coursework.me"
            "https://www.googleapis.com/auth/classroom.coursework.me.readonly"
            "https://www.googleapis.com/auth/classroom.coursework.students"
            "https://www.googleapis.com/auth/classroom.coursework.students.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"courseId" "id"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{courseId}/courseWork/{id}"
     #{"courseId" "id"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn courseWork-patch$
  "Required parameters: id, courseId
  
  Optional parameters: updateMask
  
  Updates one or more fields of a course work.
  
  See google.classroom.v1.CourseWork for details
  of which fields may be updated and who may change them.
  
  This request must be made by the Developer Console project of the
  [OAuth client ID](https://support.google.com/cloud/answer/6158849) used to
  create the corresponding course work item.
  
  This method returns the following error codes:
  
  * `PERMISSION_DENIED` if the requesting developer project did not create
  the corresponding course work, if the user is not permitted to make the
  requested modification to the student submission, or for
  access errors.
  * `INVALID_ARGUMENT` if the request is malformed.
  * `FAILED_PRECONDITION` if the requested course work has already been
  deleted.
  * `NOT_FOUND` if the requested course, course work, or student submission
  does not exist."
  {:scopes ["https://www.googleapis.com/auth/classroom.coursework.students"]}
  [auth args]
  {:pre [(util/has-keys? args #{"courseId" "id"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{courseId}/courseWork/{id}"
     #{"courseId" "id"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn courseWork-delete$
  "Required parameters: courseId, id
  
  Optional parameters: none
  
  Deletes a course work.
  
  This request must be made by the Developer Console project of the
  [OAuth client ID](https://support.google.com/cloud/answer/6158849) used to
  create the corresponding course work item.
  
  This method returns the following error codes:
  
  * `PERMISSION_DENIED` if the requesting developer project did not create
  the corresponding course work, if the requesting user is not permitted
  to delete the requested course or for access errors.
  * `FAILED_PRECONDITION` if the requested course work has already been
  deleted.
  * `NOT_FOUND` if no course exists with the requested ID."
  {:scopes ["https://www.googleapis.com/auth/classroom.coursework.students"]}
  [auth args]
  {:pre [(util/has-keys? args #{"courseId" "id"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{courseId}/courseWork/{id}"
     #{"courseId" "id"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn courseWork-studentSubmissions-list$
  "Required parameters: courseWorkId, courseId
  
  Optional parameters: userId, late, pageToken, pageSize, states
  
  Returns a list of student submissions that the requester is permitted to
  view, factoring in the OAuth scopes of the request.
  `-` may be specified as the `course_work_id` to include student
  submissions for multiple course work items.
  
  Course students may only view their own work. Course teachers
  and domain administrators may view all student submissions.
  
  This method returns the following error codes:
  
  * `PERMISSION_DENIED` if the requesting user is not permitted to access the
  requested course or course work, or for access errors.
  * `INVALID_ARGUMENT` if the request is malformed.
  * `NOT_FOUND` if the requested course does not exist."
  {:scopes ["https://www.googleapis.com/auth/classroom.coursework.me"
            "https://www.googleapis.com/auth/classroom.coursework.me.readonly"
            "https://www.googleapis.com/auth/classroom.coursework.students"
            "https://www.googleapis.com/auth/classroom.coursework.students.readonly"
            "https://www.googleapis.com/auth/classroom.student-submissions.me.readonly"
            "https://www.googleapis.com/auth/classroom.student-submissions.students.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"courseId" "courseWorkId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{courseId}/courseWork/{courseWorkId}/studentSubmissions"
     #{"courseId" "courseWorkId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn courseWork-studentSubmissions-modifyAttachments$
  "Required parameters: id, courseWorkId, courseId
  
  Optional parameters: none
  
  Modifies attachments of student submission.
  
  Attachments may only be added to student submissions belonging to course
  work objects with a `workType` of `ASSIGNMENT`.
  
  This request must be made by the Developer Console project of the
  [OAuth client ID](https://support.google.com/cloud/answer/6158849) used to
  create the corresponding course work item.
  
  This method returns the following error codes:
  
  * `PERMISSION_DENIED` if the requesting user is not permitted to access the
  requested course or course work, if the user is not permitted to modify
  attachments on the requested student submission, or for
  access errors.
  * `INVALID_ARGUMENT` if the request is malformed.
  * `NOT_FOUND` if the requested course, course work, or student submission
  does not exist."
  {:scopes ["https://www.googleapis.com/auth/classroom.coursework.me"
            "https://www.googleapis.com/auth/classroom.coursework.students"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"courseId" "id" "courseWorkId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{courseId}/courseWork/{courseWorkId}/studentSubmissions/{id}:modifyAttachments"
     #{"courseId" "id" "courseWorkId"}
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

(defn courseWork-studentSubmissions-get$
  "Required parameters: courseWorkId, courseId, id
  
  Optional parameters: none
  
  Returns a student submission.
  
  * `PERMISSION_DENIED` if the requesting user is not permitted to access the
  requested course, course work, or student submission or for
  access errors.
  * `INVALID_ARGUMENT` if the request is malformed.
  * `NOT_FOUND` if the requested course, course work, or student submission
  does not exist."
  {:scopes ["https://www.googleapis.com/auth/classroom.coursework.me"
            "https://www.googleapis.com/auth/classroom.coursework.me.readonly"
            "https://www.googleapis.com/auth/classroom.coursework.students"
            "https://www.googleapis.com/auth/classroom.coursework.students.readonly"
            "https://www.googleapis.com/auth/classroom.student-submissions.me.readonly"
            "https://www.googleapis.com/auth/classroom.student-submissions.students.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"courseId" "id" "courseWorkId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{courseId}/courseWork/{courseWorkId}/studentSubmissions/{id}"
     #{"courseId" "id" "courseWorkId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn courseWork-studentSubmissions-patch$
  "Required parameters: id, courseWorkId, courseId
  
  Optional parameters: updateMask
  
  Updates one or more fields of a student submission.
  
  See google.classroom.v1.StudentSubmission for details
  of which fields may be updated and who may change them.
  
  This request must be made by the Developer Console project of the
  [OAuth client ID](https://support.google.com/cloud/answer/6158849) used to
  create the corresponding course work item.
  
  This method returns the following error codes:
  
  * `PERMISSION_DENIED` if the requesting developer project did not create
  the corresponding course work, if the user is not permitted to make the
  requested modification to the student submission, or for
  access errors.
  * `INVALID_ARGUMENT` if the request is malformed.
  * `NOT_FOUND` if the requested course, course work, or student submission
  does not exist."
  {:scopes ["https://www.googleapis.com/auth/classroom.coursework.me"
            "https://www.googleapis.com/auth/classroom.coursework.students"]}
  [auth args]
  {:pre [(util/has-keys? args #{"courseId" "id" "courseWorkId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{courseId}/courseWork/{courseWorkId}/studentSubmissions/{id}"
     #{"courseId" "id" "courseWorkId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn courseWork-studentSubmissions-return$
  "Required parameters: courseWorkId, courseId, id
  
  Optional parameters: none
  
  Returns a student submission.
  
  Returning a student submission transfers ownership of attached Drive
  files to the student and may also update the submission state.
  Unlike the Classroom application, returning a student submission does not
  set assignedGrade to the draftGrade value.
  
  Only a teacher of the course that contains the requested student submission
  may call this method.
  
  This request must be made by the Developer Console project of the
  [OAuth client ID](https://support.google.com/cloud/answer/6158849) used to
  create the corresponding course work item.
  
  This method returns the following error codes:
  
  * `PERMISSION_DENIED` if the requesting user is not permitted to access the
  requested course or course work, return the requested student submission,
  or for access errors.
  * `INVALID_ARGUMENT` if the request is malformed.
  * `NOT_FOUND` if the requested course, course work, or student submission
  does not exist."
  {:scopes ["https://www.googleapis.com/auth/classroom.coursework.students"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"courseId" "id" "courseWorkId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{courseId}/courseWork/{courseWorkId}/studentSubmissions/{id}:return"
     #{"courseId" "id" "courseWorkId"}
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

(defn courseWork-studentSubmissions-reclaim$
  "Required parameters: courseWorkId, courseId, id
  
  Optional parameters: none
  
  Reclaims a student submission on behalf of the student that owns it.
  
  Reclaiming a student submission transfers ownership of attached Drive
  files to the student and updates the submission state.
  
  Only the student that owns the requested student submission may call this
  method, and only for a student submission that has been turned in.
  
  This request must be made by the Developer Console project of the
  [OAuth client ID](https://support.google.com/cloud/answer/6158849) used to
  create the corresponding course work item.
  
  This method returns the following error codes:
  
  * `PERMISSION_DENIED` if the requesting user is not permitted to access the
  requested course or course work, unsubmit the requested student submission,
  or for access errors.
  * `FAILED_PRECONDITION` if the student submission has not been turned in.
  * `INVALID_ARGUMENT` if the request is malformed.
  * `NOT_FOUND` if the requested course, course work, or student submission
  does not exist."
  {:scopes ["https://www.googleapis.com/auth/classroom.coursework.me"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"courseId" "id" "courseWorkId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{courseId}/courseWork/{courseWorkId}/studentSubmissions/{id}:reclaim"
     #{"courseId" "id" "courseWorkId"}
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

(defn courseWork-studentSubmissions-turnIn$
  "Required parameters: id, courseWorkId, courseId
  
  Optional parameters: none
  
  Turns in a student submission.
  
  Turning in a student submission transfers ownership of attached Drive
  files to the teacher and may also update the submission state.
  
  This may only be called by the student that owns the specified student
  submission.
  
  This request must be made by the Developer Console project of the
  [OAuth client ID](https://support.google.com/cloud/answer/6158849) used to
  create the corresponding course work item.
  
  This method returns the following error codes:
  
  * `PERMISSION_DENIED` if the requesting user is not permitted to access the
  requested course or course work, turn in the requested student submission,
  or for access errors.
  * `INVALID_ARGUMENT` if the request is malformed.
  * `NOT_FOUND` if the requested course, course work, or student submission
  does not exist."
  {:scopes ["https://www.googleapis.com/auth/classroom.coursework.me"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"courseId" "id" "courseWorkId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{courseId}/courseWork/{courseWorkId}/studentSubmissions/{id}:turnIn"
     #{"courseId" "id" "courseWorkId"}
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

(defn teachers-get$
  "Required parameters: userId, courseId
  
  Optional parameters: none
  
  Returns a teacher of a course.
  
  This method returns the following error codes:
  
  * `PERMISSION_DENIED` if the requesting user is not permitted to view
  teachers of this course or for access errors.
  * `NOT_FOUND` if no teacher of this course has the requested ID or if the
  course does not exist."
  {:scopes ["https://www.googleapis.com/auth/classroom.profile.emails"
            "https://www.googleapis.com/auth/classroom.profile.photos"
            "https://www.googleapis.com/auth/classroom.rosters"
            "https://www.googleapis.com/auth/classroom.rosters.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"courseId" "userId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{courseId}/teachers/{userId}"
     #{"courseId" "userId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn teachers-list$
  "Required parameters: courseId
  
  Optional parameters: pageToken, pageSize
  
  Returns a list of teachers of this course that the requester
  is permitted to view.
  
  This method returns the following error codes:
  
  * `NOT_FOUND` if the course does not exist.
  * `PERMISSION_DENIED` for access errors."
  {:scopes ["https://www.googleapis.com/auth/classroom.profile.emails"
            "https://www.googleapis.com/auth/classroom.profile.photos"
            "https://www.googleapis.com/auth/classroom.rosters"
            "https://www.googleapis.com/auth/classroom.rosters.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"courseId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{courseId}/teachers"
     #{"courseId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn teachers-create$
  "Required parameters: courseId
  
  Optional parameters: none
  
  Creates a teacher of a course.
  
  This method returns the following error codes:
  
  * `PERMISSION_DENIED` if the requesting user is not  permitted to create
  teachers in this course or for access errors.
  * `NOT_FOUND` if the requested course ID does not exist.
  * `FAILED_PRECONDITION` if the requested user's account is disabled,
  for the following request errors:
      * CourseMemberLimitReached
      * CourseNotModifiable
      * CourseTeacherLimitReached
      * UserGroupsMembershipLimitReached
  * `ALREADY_EXISTS` if the user is already a teacher or student in the
  course."
  {:scopes ["https://www.googleapis.com/auth/classroom.profile.emails"
            "https://www.googleapis.com/auth/classroom.profile.photos"
            "https://www.googleapis.com/auth/classroom.rosters"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"courseId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{courseId}/teachers"
     #{"courseId"}
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

(defn teachers-delete$
  "Required parameters: userId, courseId
  
  Optional parameters: none
  
  Deletes a teacher of a course.
  
  This method returns the following error codes:
  
  * `PERMISSION_DENIED` if the requesting user is not permitted to delete
  teachers of this course or for access errors.
  * `NOT_FOUND` if no teacher of this course has the requested ID or if the
  course does not exist.
  * `FAILED_PRECONDITION` if the requested ID belongs to the primary teacher
  of this course."
  {:scopes ["https://www.googleapis.com/auth/classroom.rosters"]}
  [auth args]
  {:pre [(util/has-keys? args #{"courseId" "userId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{courseId}/teachers/{userId}"
     #{"courseId" "userId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn announcements-create$
  "Required parameters: courseId
  
  Optional parameters: none
  
  Creates an announcement.
  
  This method returns the following error codes:
  
  * `PERMISSION_DENIED` if the requesting user is not permitted to access the
  requested course, create announcements in the requested course, share a
  Drive attachment, or for access errors.
  * `INVALID_ARGUMENT` if the request is malformed.
  * `NOT_FOUND` if the requested course does not exist.
  * `FAILED_PRECONDITION` for the following request error:
      * AttachmentNotVisible"
  {:scopes ["https://www.googleapis.com/auth/classroom.announcements"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"courseId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{courseId}/announcements"
     #{"courseId"}
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

(defn announcements-modifyAssignees$
  "Required parameters: courseId, id
  
  Optional parameters: none
  
  Modifies assignee mode and options of an announcement.
  
  Only a teacher of the course that contains the announcement may
  call this method.
  
  This method returns the following error codes:
  
  * `PERMISSION_DENIED` if the requesting user is not permitted to access the
  requested course or course work or for access errors.
  * `INVALID_ARGUMENT` if the request is malformed.
  * `NOT_FOUND` if the requested course or course work does not exist."
  {:scopes ["https://www.googleapis.com/auth/classroom.announcements"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"courseId" "id"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{courseId}/announcements/{id}:modifyAssignees"
     #{"courseId" "id"}
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

(defn announcements-patch$
  "Required parameters: courseId, id
  
  Optional parameters: updateMask
  
  Updates one or more fields of an announcement.
  
  This method returns the following error codes:
  
  * `PERMISSION_DENIED` if the requesting developer project did not create
  the corresponding announcement or for access errors.
  * `INVALID_ARGUMENT` if the request is malformed.
  * `FAILED_PRECONDITION` if the requested announcement has already been
  deleted.
  * `NOT_FOUND` if the requested course or announcement does not exist"
  {:scopes ["https://www.googleapis.com/auth/classroom.announcements"]}
  [auth args]
  {:pre [(util/has-keys? args #{"courseId" "id"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{courseId}/announcements/{id}"
     #{"courseId" "id"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn announcements-get$
  "Required parameters: courseId, id
  
  Optional parameters: none
  
  Returns an announcement.
  
  This method returns the following error codes:
  
  * `PERMISSION_DENIED` if the requesting user is not permitted to access the
  requested course or announcement, or for access errors.
  * `INVALID_ARGUMENT` if the request is malformed.
  * `NOT_FOUND` if the requested course or announcement does not exist."
  {:scopes ["https://www.googleapis.com/auth/classroom.announcements"
            "https://www.googleapis.com/auth/classroom.announcements.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"courseId" "id"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{courseId}/announcements/{id}"
     #{"courseId" "id"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn announcements-delete$
  "Required parameters: courseId, id
  
  Optional parameters: none
  
  Deletes an announcement.
  
  This request must be made by the Developer Console project of the
  [OAuth client ID](https://support.google.com/cloud/answer/6158849) used to
  create the corresponding announcement item.
  
  This method returns the following error codes:
  
  * `PERMISSION_DENIED` if the requesting developer project did not create
  the corresponding announcement, if the requesting user is not permitted
  to delete the requested course or for access errors.
  * `FAILED_PRECONDITION` if the requested announcement has already been
  deleted.
  * `NOT_FOUND` if no course exists with the requested ID."
  {:scopes ["https://www.googleapis.com/auth/classroom.announcements"]}
  [auth args]
  {:pre [(util/has-keys? args #{"courseId" "id"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{courseId}/announcements/{id}"
     #{"courseId" "id"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn announcements-list$
  "Required parameters: courseId
  
  Optional parameters: orderBy, pageToken, pageSize, announcementStates
  
  Returns a list of announcements that the requester is permitted to view.
  
  Course students may only view `PUBLISHED` announcements. Course teachers
  and domain administrators may view all announcements.
  
  This method returns the following error codes:
  
  * `PERMISSION_DENIED` if the requesting user is not permitted to access
  the requested course or for access errors.
  * `INVALID_ARGUMENT` if the request is malformed.
  * `NOT_FOUND` if the requested course does not exist."
  {:scopes ["https://www.googleapis.com/auth/classroom.announcements"
            "https://www.googleapis.com/auth/classroom.announcements.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"courseId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{courseId}/announcements"
     #{"courseId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn students-delete$
  "Required parameters: userId, courseId
  
  Optional parameters: none
  
  Deletes a student of a course.
  
  This method returns the following error codes:
  
  * `PERMISSION_DENIED` if the requesting user is not permitted to delete
  students of this course or for access errors.
  * `NOT_FOUND` if no student of this course has the requested ID or if the
  course does not exist."
  {:scopes ["https://www.googleapis.com/auth/classroom.rosters"]}
  [auth args]
  {:pre [(util/has-keys? args #{"courseId" "userId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{courseId}/students/{userId}"
     #{"courseId" "userId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn students-get$
  "Required parameters: courseId, userId
  
  Optional parameters: none
  
  Returns a student of a course.
  
  This method returns the following error codes:
  
  * `PERMISSION_DENIED` if the requesting user is not permitted to view
  students of this course or for access errors.
  * `NOT_FOUND` if no student of this course has the requested ID or if the
  course does not exist."
  {:scopes ["https://www.googleapis.com/auth/classroom.profile.emails"
            "https://www.googleapis.com/auth/classroom.profile.photos"
            "https://www.googleapis.com/auth/classroom.rosters"
            "https://www.googleapis.com/auth/classroom.rosters.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"courseId" "userId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{courseId}/students/{userId}"
     #{"courseId" "userId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn students-list$
  "Required parameters: courseId
  
  Optional parameters: pageToken, pageSize
  
  Returns a list of students of this course that the requester
  is permitted to view.
  
  This method returns the following error codes:
  
  * `NOT_FOUND` if the course does not exist.
  * `PERMISSION_DENIED` for access errors."
  {:scopes ["https://www.googleapis.com/auth/classroom.profile.emails"
            "https://www.googleapis.com/auth/classroom.profile.photos"
            "https://www.googleapis.com/auth/classroom.rosters"
            "https://www.googleapis.com/auth/classroom.rosters.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"courseId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{courseId}/students"
     #{"courseId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn students-create$
  "Required parameters: courseId
  
  Optional parameters: enrollmentCode
  
  Adds a user as a student of a course.
  
  This method returns the following error codes:
  
  * `PERMISSION_DENIED` if the requesting user is not permitted to create
  students in this course or for access errors.
  * `NOT_FOUND` if the requested course ID does not exist.
  * `FAILED_PRECONDITION` if the requested user's account is disabled,
  for the following request errors:
      * CourseMemberLimitReached
      * CourseNotModifiable
      * UserGroupsMembershipLimitReached
  * `ALREADY_EXISTS` if the user is already a student or teacher in the
  course."
  {:scopes ["https://www.googleapis.com/auth/classroom.profile.emails"
            "https://www.googleapis.com/auth/classroom.profile.photos"
            "https://www.googleapis.com/auth/classroom.rosters"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"courseId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{courseId}/students"
     #{"courseId"}
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

(defn topics-delete$
  "Required parameters: courseId, id
  
  Optional parameters: none
  
  Deletes a topic.
  
  This method returns the following error codes:
  
  * `PERMISSION_DENIED` if the requesting user is not allowed to delete the
  requested topic or for access errors.
  * `FAILED_PRECONDITION` if the requested topic has already been
  deleted.
  * `NOT_FOUND` if no course or topic exists with the requested ID."
  {:scopes ["https://www.googleapis.com/auth/classroom.topics"]}
  [auth args]
  {:pre [(util/has-keys? args #{"courseId" "id"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{courseId}/topics/{id}"
     #{"courseId" "id"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn topics-patch$
  "Required parameters: id, courseId
  
  Optional parameters: updateMask
  
  Updates one or more fields of a topic.
  
  This method returns the following error codes:
  
  * `PERMISSION_DENIED` if the requesting developer project did not create
  the corresponding topic or for access errors.
  * `INVALID_ARGUMENT` if the request is malformed.
  * `NOT_FOUND` if the requested course or topic does not exist"
  {:scopes ["https://www.googleapis.com/auth/classroom.topics"]}
  [auth args]
  {:pre [(util/has-keys? args #{"courseId" "id"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{courseId}/topics/{id}"
     #{"courseId" "id"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn topics-get$
  "Required parameters: courseId, id
  
  Optional parameters: none
  
  Returns a topic.
  
  This method returns the following error codes:
  
  * `PERMISSION_DENIED` if the requesting user is not permitted to access the
  requested course or topic, or for access errors.
  * `INVALID_ARGUMENT` if the request is malformed.
  * `NOT_FOUND` if the requested course or topic does not exist."
  {:scopes ["https://www.googleapis.com/auth/classroom.topics"
            "https://www.googleapis.com/auth/classroom.topics.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"courseId" "id"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{courseId}/topics/{id}"
     #{"courseId" "id"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn topics-list$
  "Required parameters: courseId
  
  Optional parameters: pageToken, pageSize
  
  Returns the list of topics that the requester is permitted to view.
  
  This method returns the following error codes:
  
  * `PERMISSION_DENIED` if the requesting user is not permitted to access
  the requested course or for access errors.
  * `INVALID_ARGUMENT` if the request is malformed.
  * `NOT_FOUND` if the requested course does not exist."
  {:scopes ["https://www.googleapis.com/auth/classroom.topics"
            "https://www.googleapis.com/auth/classroom.topics.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"courseId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{courseId}/topics"
     #{"courseId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn topics-create$
  "Required parameters: courseId
  
  Optional parameters: none
  
  Creates a topic.
  
  This method returns the following error codes:
  
  * `PERMISSION_DENIED` if the requesting user is not permitted to access the
  requested course, create a topic in the requested course,
  or for access errors.
  * `INVALID_ARGUMENT` if the request is malformed.
  * `NOT_FOUND` if the requested course does not exist."
  {:scopes ["https://www.googleapis.com/auth/classroom.topics"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"courseId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{courseId}/topics"
     #{"courseId"}
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

(defn aliases-delete$
  "Required parameters: alias, courseId
  
  Optional parameters: none
  
  Deletes an alias of a course.
  
  This method returns the following error codes:
  
  * `PERMISSION_DENIED` if the requesting user is not permitted to remove the
  alias or for access errors.
  * `NOT_FOUND` if the alias does not exist.
  * `FAILED_PRECONDITION` if the alias requested does not make sense for the
    requesting user or course (for example, if a user not in a domain
    attempts to delete a domain-scoped alias)."
  {:scopes ["https://www.googleapis.com/auth/classroom.courses"]}
  [auth args]
  {:pre [(util/has-keys? args #{"courseId" "alias"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{courseId}/aliases/{alias}"
     #{"courseId" "alias"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn aliases-list$
  "Required parameters: courseId
  
  Optional parameters: pageToken, pageSize
  
  Returns a list of aliases for a course.
  
  This method returns the following error codes:
  
  * `PERMISSION_DENIED` if the requesting user is not permitted to access the
  course or for access errors.
  * `NOT_FOUND` if the course does not exist."
  {:scopes ["https://www.googleapis.com/auth/classroom.courses"
            "https://www.googleapis.com/auth/classroom.courses.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"courseId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{courseId}/aliases"
     #{"courseId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn aliases-create$
  "Required parameters: courseId
  
  Optional parameters: none
  
  Creates an alias for a course.
  
  This method returns the following error codes:
  
  * `PERMISSION_DENIED` if the requesting user is not permitted to create the
  alias or for access errors.
  * `NOT_FOUND` if the course does not exist.
  * `ALREADY_EXISTS` if the alias already exists.
  * `FAILED_PRECONDITION` if the alias requested does not make sense for the
    requesting user or course (for example, if a user not in a domain
    attempts to access a domain-scoped alias)."
  {:scopes ["https://www.googleapis.com/auth/classroom.courses"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"courseId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{courseId}/aliases"
     #{"courseId"}
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
