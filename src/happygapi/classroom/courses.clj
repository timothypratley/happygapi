(ns happygapi.classroom.courses
  "Google Classroom API: courses.
  Manages classes, rosters, and invitations in Google Classroom.
  See: https://developers.google.com/classroom/docs/reference/rest/v1/courses"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn create$
  "https://developers.google.com/classroom/api/reference/rest/v1/courses/create
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:creationTime string,
   :description string,
   :calendarId string,
   :ownerId string,
   :teacherFolder {:id string, :title string, :alternateLink string},
   :name string,
   :section string,
   :guardiansEnabled boolean,
   :gradebookSettings {:calculationType string,
                       :displaySetting string,
                       :gradeCategories [GradeCategory]},
   :updateTime string,
   :courseMaterialSets [{:title string, :materials [CourseMaterial]}],
   :courseState string,
   :enrollmentCode string,
   :id string,
   :alternateLink string,
   :teacherGroupEmail string,
   :room string,
   :courseGroupEmail string,
   :descriptionHeading string}
  
  Creates a course. The user specified in `ownerId` is the owner of the created course and added as a teacher. A non-admin requesting user can only create a course with themselves as the owner. Domain admins can create courses owned by any user within their domain. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting user is not permitted to create courses or for access errors. * `NOT_FOUND` if the primary teacher is not a valid user. * `FAILED_PRECONDITION` if the course owner's account is disabled or for the following request errors: * UserCannotOwnCourse * UserGroupsMembershipLimitReached * `ALREADY_EXISTS` if an alias was specified in the `id` and already exists."
  {:scopes ["https://www.googleapis.com/auth/classroom.courses"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses"
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

(defn get$
  "https://developers.google.com/classroom/api/reference/rest/v1/courses/get
  
  Required parameters: id
  
  Optional parameters: none
  
  Returns a course. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting user is not permitted to access the requested course or for access errors. * `NOT_FOUND` if no course exists with the requested ID."
  {:scopes ["https://www.googleapis.com/auth/classroom.courses"
            "https://www.googleapis.com/auth/classroom.courses.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{id}"
     #{:id}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://developers.google.com/classroom/api/reference/rest/v1/courses/update
  
  Required parameters: id
  
  Optional parameters: none
  
  Body: 
  
  {:creationTime string,
   :description string,
   :calendarId string,
   :ownerId string,
   :teacherFolder {:id string, :title string, :alternateLink string},
   :name string,
   :section string,
   :guardiansEnabled boolean,
   :gradebookSettings {:calculationType string,
                       :displaySetting string,
                       :gradeCategories [GradeCategory]},
   :updateTime string,
   :courseMaterialSets [{:title string, :materials [CourseMaterial]}],
   :courseState string,
   :enrollmentCode string,
   :id string,
   :alternateLink string,
   :teacherGroupEmail string,
   :room string,
   :courseGroupEmail string,
   :descriptionHeading string}
  
  Updates a course. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting user is not permitted to modify the requested course or for access errors. * `NOT_FOUND` if no course exists with the requested ID. * `FAILED_PRECONDITION` for the following request errors: * CourseNotModifiable"
  {:scopes ["https://www.googleapis.com/auth/classroom.courses"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:id})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{id}"
     #{:id}
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

(defn patch$
  "https://developers.google.com/classroom/api/reference/rest/v1/courses/patch
  
  Required parameters: id
  
  Optional parameters: updateMask
  
  Body: 
  
  {:creationTime string,
   :description string,
   :calendarId string,
   :ownerId string,
   :teacherFolder {:id string, :title string, :alternateLink string},
   :name string,
   :section string,
   :guardiansEnabled boolean,
   :gradebookSettings {:calculationType string,
                       :displaySetting string,
                       :gradeCategories [GradeCategory]},
   :updateTime string,
   :courseMaterialSets [{:title string, :materials [CourseMaterial]}],
   :courseState string,
   :enrollmentCode string,
   :id string,
   :alternateLink string,
   :teacherGroupEmail string,
   :room string,
   :courseGroupEmail string,
   :descriptionHeading string}
  
  Updates one or more fields in a course. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting user is not permitted to modify the requested course or for access errors. * `NOT_FOUND` if no course exists with the requested ID. * `INVALID_ARGUMENT` if invalid fields are specified in the update mask or if no update mask is supplied. * `FAILED_PRECONDITION` for the following request errors: * CourseNotModifiable * InactiveCourseOwner * IneligibleOwner"
  {:scopes ["https://www.googleapis.com/auth/classroom.courses"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:id})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{id}"
     #{:id}
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
  "https://developers.google.com/classroom/api/reference/rest/v1/courses/delete
  
  Required parameters: id
  
  Optional parameters: none
  
  Deletes a course. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting user is not permitted to delete the requested course or for access errors. * `NOT_FOUND` if no course exists with the requested ID."
  {:scopes ["https://www.googleapis.com/auth/classroom.courses"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{id}"
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
  "https://developers.google.com/classroom/api/reference/rest/v1/courses/list
  
  Required parameters: none
  
  Optional parameters: studentId, teacherId, courseStates, pageSize, pageToken
  
  Returns a list of courses that the requesting user is permitted to view, restricted to those that match the request. Returned courses are ordered by creation time, with the most recently created coming first. This method returns the following error codes: * `PERMISSION_DENIED` for access errors. * `INVALID_ARGUMENT` if the query argument is malformed. * `NOT_FOUND` if any users specified in the query arguments do not exist."
  {:scopes ["https://www.googleapis.com/auth/classroom.courses"
            "https://www.googleapis.com/auth/classroom.courses.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn aliases-create$
  "https://developers.google.com/classroom/api/reference/rest/v1/courses/aliases/create
  
  Required parameters: courseId
  
  Optional parameters: none
  
  Body: 
  
  {:alias string}
  
  Creates an alias for a course. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting user is not permitted to create the alias or for access errors. * `NOT_FOUND` if the course does not exist. * `ALREADY_EXISTS` if the alias already exists. * `FAILED_PRECONDITION` if the alias requested does not make sense for the requesting user or course (for example, if a user not in a domain attempts to access a domain-scoped alias)."
  {:scopes ["https://www.googleapis.com/auth/classroom.courses"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:courseId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{courseId}/aliases"
     #{:courseId}
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

(defn aliases-delete$
  "https://developers.google.com/classroom/api/reference/rest/v1/courses/aliases/delete
  
  Required parameters: courseId, alias
  
  Optional parameters: none
  
  Deletes an alias of a course. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting user is not permitted to remove the alias or for access errors. * `NOT_FOUND` if the alias does not exist. * `FAILED_PRECONDITION` if the alias requested does not make sense for the requesting user or course (for example, if a user not in a domain attempts to delete a domain-scoped alias)."
  {:scopes ["https://www.googleapis.com/auth/classroom.courses"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:alias :courseId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{courseId}/aliases/{alias}"
     #{:alias :courseId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn aliases-list$
  "https://developers.google.com/classroom/api/reference/rest/v1/courses/aliases/list
  
  Required parameters: courseId
  
  Optional parameters: pageSize, pageToken
  
  Returns a list of aliases for a course. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting user is not permitted to access the course or for access errors. * `NOT_FOUND` if the course does not exist."
  {:scopes ["https://www.googleapis.com/auth/classroom.courses"
            "https://www.googleapis.com/auth/classroom.courses.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:courseId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{courseId}/aliases"
     #{:courseId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn courseWork-create$
  "https://developers.google.com/classroom/api/reference/rest/v1/courses/courseWork/create
  
  Required parameters: courseId
  
  Optional parameters: none
  
  Body: 
  
  {:creationTime string,
   :description string,
   :individualStudentsOptions {:studentIds [string]},
   :multipleChoiceQuestion {:choices [string]},
   :submissionModificationMode string,
   :creatorUserId string,
   :assigneeMode string,
   :dueTime {:hours integer,
             :minutes integer,
             :seconds integer,
             :nanos integer},
   :topicId string,
   :scheduledTime string,
   :state string,
   :title string,
   :updateTime string,
   :id string,
   :dueDate {:year integer, :month integer, :day integer},
   :alternateLink string,
   :materials [{:driveFile SharedDriveFile,
                :youtubeVideo YouTubeVideo,
                :link Link,
                :form Form}],
   :assignment {:studentWorkFolder DriveFolder},
   :maxPoints number,
   :gradeCategory {:id string,
                   :name string,
                   :weight integer,
                   :defaultGradeDenominator integer},
   :associatedWithDeveloper boolean,
   :courseId string,
   :workType string}
  
  Creates course work. The resulting course work (and corresponding student submissions) are associated with the Developer Console project of the [OAuth client ID](https://support.google.com/cloud/answer/6158849) used to make the request. Classroom API requests to modify course work and student submissions must be made with an OAuth client ID from the associated Developer Console project. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting user is not permitted to access the requested course, create course work in the requested course, share a Drive attachment, or for access errors. * `INVALID_ARGUMENT` if the request is malformed. * `NOT_FOUND` if the requested course does not exist. * `FAILED_PRECONDITION` for the following request error: * AttachmentNotVisible"
  {:scopes ["https://www.googleapis.com/auth/classroom.coursework.students"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:courseId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{courseId}/courseWork"
     #{:courseId}
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

(defn courseWork-patch$
  "https://developers.google.com/classroom/api/reference/rest/v1/courses/courseWork/patch
  
  Required parameters: courseId, id
  
  Optional parameters: updateMask
  
  Body: 
  
  {:creationTime string,
   :description string,
   :individualStudentsOptions {:studentIds [string]},
   :multipleChoiceQuestion {:choices [string]},
   :submissionModificationMode string,
   :creatorUserId string,
   :assigneeMode string,
   :dueTime {:hours integer,
             :minutes integer,
             :seconds integer,
             :nanos integer},
   :topicId string,
   :scheduledTime string,
   :state string,
   :title string,
   :updateTime string,
   :id string,
   :dueDate {:year integer, :month integer, :day integer},
   :alternateLink string,
   :materials [{:driveFile SharedDriveFile,
                :youtubeVideo YouTubeVideo,
                :link Link,
                :form Form}],
   :assignment {:studentWorkFolder DriveFolder},
   :maxPoints number,
   :gradeCategory {:id string,
                   :name string,
                   :weight integer,
                   :defaultGradeDenominator integer},
   :associatedWithDeveloper boolean,
   :courseId string,
   :workType string}
  
  Updates one or more fields of a course work. See google.classroom.v1.CourseWork for details of which fields may be updated and who may change them. This request must be made by the Developer Console project of the [OAuth client ID](https://support.google.com/cloud/answer/6158849) used to create the corresponding course work item. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting developer project did not create the corresponding course work, if the user is not permitted to make the requested modification to the student submission, or for access errors. * `INVALID_ARGUMENT` if the request is malformed. * `FAILED_PRECONDITION` if the requested course work has already been deleted. * `NOT_FOUND` if the requested course, course work, or student submission does not exist."
  {:scopes ["https://www.googleapis.com/auth/classroom.coursework.students"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:id :courseId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{courseId}/courseWork/{id}"
     #{:id :courseId}
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

(defn courseWork-delete$
  "https://developers.google.com/classroom/api/reference/rest/v1/courses/courseWork/delete
  
  Required parameters: courseId, id
  
  Optional parameters: none
  
  Deletes a course work. This request must be made by the Developer Console project of the [OAuth client ID](https://support.google.com/cloud/answer/6158849) used to create the corresponding course work item. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting developer project did not create the corresponding course work, if the requesting user is not permitted to delete the requested course or for access errors. * `FAILED_PRECONDITION` if the requested course work has already been deleted. * `NOT_FOUND` if no course exists with the requested ID."
  {:scopes ["https://www.googleapis.com/auth/classroom.coursework.students"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id :courseId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{courseId}/courseWork/{id}"
     #{:id :courseId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn courseWork-get$
  "https://developers.google.com/classroom/api/reference/rest/v1/courses/courseWork/get
  
  Required parameters: courseId, id
  
  Optional parameters: none
  
  Returns course work. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting user is not permitted to access the requested course or course work, or for access errors. * `INVALID_ARGUMENT` if the request is malformed. * `NOT_FOUND` if the requested course or course work does not exist."
  {:scopes ["https://www.googleapis.com/auth/classroom.coursework.me"
            "https://www.googleapis.com/auth/classroom.coursework.me.readonly"
            "https://www.googleapis.com/auth/classroom.coursework.students"
            "https://www.googleapis.com/auth/classroom.coursework.students.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id :courseId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{courseId}/courseWork/{id}"
     #{:id :courseId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn courseWork-list$
  "https://developers.google.com/classroom/api/reference/rest/v1/courses/courseWork/list
  
  Required parameters: courseId
  
  Optional parameters: courseWorkStates, orderBy, pageSize, pageToken
  
  Returns a list of course work that the requester is permitted to view. Course students may only view `PUBLISHED` course work. Course teachers and domain administrators may view all course work. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting user is not permitted to access the requested course or for access errors. * `INVALID_ARGUMENT` if the request is malformed. * `NOT_FOUND` if the requested course does not exist."
  {:scopes ["https://www.googleapis.com/auth/classroom.coursework.me"
            "https://www.googleapis.com/auth/classroom.coursework.me.readonly"
            "https://www.googleapis.com/auth/classroom.coursework.students"
            "https://www.googleapis.com/auth/classroom.coursework.students.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:courseId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{courseId}/courseWork"
     #{:courseId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn courseWork-modifyAssignees$
  "https://developers.google.com/classroom/api/reference/rest/v1/courses/courseWork/modifyAssignees
  
  Required parameters: courseId, id
  
  Optional parameters: none
  
  Body: 
  
  {:assigneeMode string,
   :modifyIndividualStudentsOptions {:addStudentIds [string],
                                     :removeStudentIds [string]}}
  
  Modifies assignee mode and options of a coursework. Only a teacher of the course that contains the coursework may call this method. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting user is not permitted to access the requested course or course work or for access errors. * `INVALID_ARGUMENT` if the request is malformed. * `NOT_FOUND` if the requested course or course work does not exist."
  {:scopes ["https://www.googleapis.com/auth/classroom.coursework.students"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:id :courseId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{courseId}/courseWork/{id}:modifyAssignees"
     #{:id :courseId}
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

(defn courseWork-studentSubmissions-get$
  "https://developers.google.com/classroom/api/reference/rest/v1/courses/courseWork/studentSubmissions/get
  
  Required parameters: courseId, courseWorkId, id
  
  Optional parameters: none
  
  Returns a student submission. * `PERMISSION_DENIED` if the requesting user is not permitted to access the requested course, course work, or student submission or for access errors. * `INVALID_ARGUMENT` if the request is malformed. * `NOT_FOUND` if the requested course, course work, or student submission does not exist."
  {:scopes ["https://www.googleapis.com/auth/classroom.coursework.me"
            "https://www.googleapis.com/auth/classroom.coursework.me.readonly"
            "https://www.googleapis.com/auth/classroom.coursework.students"
            "https://www.googleapis.com/auth/classroom.coursework.students.readonly"
            "https://www.googleapis.com/auth/classroom.student-submissions.me.readonly"
            "https://www.googleapis.com/auth/classroom.student-submissions.students.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id :courseWorkId :courseId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{courseId}/courseWork/{courseWorkId}/studentSubmissions/{id}"
     #{:id :courseWorkId :courseId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn courseWork-studentSubmissions-patch$
  "https://developers.google.com/classroom/api/reference/rest/v1/courses/courseWork/studentSubmissions/patch
  
  Required parameters: courseId, courseWorkId, id
  
  Optional parameters: updateMask
  
  Body: 
  
  {:creationTime string,
   :shortAnswerSubmission {:answer string},
   :late boolean,
   :multipleChoiceSubmission {:answer string},
   :state string,
   :updateTime string,
   :assignmentSubmission {:attachments [Attachment]},
   :id string,
   :assignedGrade number,
   :submissionHistory [{:stateHistory StateHistory,
                        :gradeHistory GradeHistory}],
   :alternateLink string,
   :userId string,
   :courseWorkType string,
   :courseWorkId string,
   :associatedWithDeveloper boolean,
   :courseId string,
   :draftGrade number}
  
  Updates one or more fields of a student submission. See google.classroom.v1.StudentSubmission for details of which fields may be updated and who may change them. This request must be made by the Developer Console project of the [OAuth client ID](https://support.google.com/cloud/answer/6158849) used to create the corresponding course work item. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting developer project did not create the corresponding course work, if the user is not permitted to make the requested modification to the student submission, or for access errors. * `INVALID_ARGUMENT` if the request is malformed. * `NOT_FOUND` if the requested course, course work, or student submission does not exist."
  {:scopes ["https://www.googleapis.com/auth/classroom.coursework.me"
            "https://www.googleapis.com/auth/classroom.coursework.students"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:id :courseWorkId :courseId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{courseId}/courseWork/{courseWorkId}/studentSubmissions/{id}"
     #{:id :courseWorkId :courseId}
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

(defn courseWork-studentSubmissions-list$
  "https://developers.google.com/classroom/api/reference/rest/v1/courses/courseWork/studentSubmissions/list
  
  Required parameters: courseId, courseWorkId
  
  Optional parameters: userId, states, late, pageSize, pageToken
  
  Returns a list of student submissions that the requester is permitted to view, factoring in the OAuth scopes of the request. `-` may be specified as the `course_work_id` to include student submissions for multiple course work items. Course students may only view their own work. Course teachers and domain administrators may view all student submissions. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting user is not permitted to access the requested course or course work, or for access errors. * `INVALID_ARGUMENT` if the request is malformed. * `NOT_FOUND` if the requested course does not exist."
  {:scopes ["https://www.googleapis.com/auth/classroom.coursework.me"
            "https://www.googleapis.com/auth/classroom.coursework.me.readonly"
            "https://www.googleapis.com/auth/classroom.coursework.students"
            "https://www.googleapis.com/auth/classroom.coursework.students.readonly"
            "https://www.googleapis.com/auth/classroom.student-submissions.me.readonly"
            "https://www.googleapis.com/auth/classroom.student-submissions.students.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:courseWorkId :courseId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{courseId}/courseWork/{courseWorkId}/studentSubmissions"
     #{:courseWorkId :courseId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn courseWork-studentSubmissions-turnIn$
  "https://developers.google.com/classroom/api/reference/rest/v1/courses/courseWork/studentSubmissions/turnIn
  
  Required parameters: courseId, courseWorkId, id
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Turns in a student submission. Turning in a student submission transfers ownership of attached Drive files to the teacher and may also update the submission state. This may only be called by the student that owns the specified student submission. This request must be made by the Developer Console project of the [OAuth client ID](https://support.google.com/cloud/answer/6158849) used to create the corresponding course work item. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting user is not permitted to access the requested course or course work, turn in the requested student submission, or for access errors. * `INVALID_ARGUMENT` if the request is malformed. * `NOT_FOUND` if the requested course, course work, or student submission does not exist."
  {:scopes ["https://www.googleapis.com/auth/classroom.coursework.me"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:id :courseWorkId :courseId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{courseId}/courseWork/{courseWorkId}/studentSubmissions/{id}:turnIn"
     #{:id :courseWorkId :courseId}
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

(defn courseWork-studentSubmissions-reclaim$
  "https://developers.google.com/classroom/api/reference/rest/v1/courses/courseWork/studentSubmissions/reclaim
  
  Required parameters: courseId, courseWorkId, id
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Reclaims a student submission on behalf of the student that owns it. Reclaiming a student submission transfers ownership of attached Drive files to the student and updates the submission state. Only the student that owns the requested student submission may call this method, and only for a student submission that has been turned in. This request must be made by the Developer Console project of the [OAuth client ID](https://support.google.com/cloud/answer/6158849) used to create the corresponding course work item. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting user is not permitted to access the requested course or course work, unsubmit the requested student submission, or for access errors. * `FAILED_PRECONDITION` if the student submission has not been turned in. * `INVALID_ARGUMENT` if the request is malformed. * `NOT_FOUND` if the requested course, course work, or student submission does not exist."
  {:scopes ["https://www.googleapis.com/auth/classroom.coursework.me"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:id :courseWorkId :courseId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{courseId}/courseWork/{courseWorkId}/studentSubmissions/{id}:reclaim"
     #{:id :courseWorkId :courseId}
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

(defn courseWork-studentSubmissions-return$
  "https://developers.google.com/classroom/api/reference/rest/v1/courses/courseWork/studentSubmissions/return
  
  Required parameters: courseId, courseWorkId, id
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Returns a student submission. Returning a student submission transfers ownership of attached Drive files to the student and may also update the submission state. Unlike the Classroom application, returning a student submission does not set assignedGrade to the draftGrade value. Only a teacher of the course that contains the requested student submission may call this method. This request must be made by the Developer Console project of the [OAuth client ID](https://support.google.com/cloud/answer/6158849) used to create the corresponding course work item. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting user is not permitted to access the requested course or course work, return the requested student submission, or for access errors. * `INVALID_ARGUMENT` if the request is malformed. * `NOT_FOUND` if the requested course, course work, or student submission does not exist."
  {:scopes ["https://www.googleapis.com/auth/classroom.coursework.students"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:id :courseWorkId :courseId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{courseId}/courseWork/{courseWorkId}/studentSubmissions/{id}:return"
     #{:id :courseWorkId :courseId}
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

(defn courseWork-studentSubmissions-modifyAttachments$
  "https://developers.google.com/classroom/api/reference/rest/v1/courses/courseWork/studentSubmissions/modifyAttachments
  
  Required parameters: courseId, courseWorkId, id
  
  Optional parameters: none
  
  Body: 
  
  {:addAttachments [{:driveFile DriveFile,
                     :youTubeVideo YouTubeVideo,
                     :link Link,
                     :form Form}]}
  
  Modifies attachments of student submission. Attachments may only be added to student submissions belonging to course work objects with a `workType` of `ASSIGNMENT`. This request must be made by the Developer Console project of the [OAuth client ID](https://support.google.com/cloud/answer/6158849) used to create the corresponding course work item. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting user is not permitted to access the requested course or course work, if the user is not permitted to modify attachments on the requested student submission, or for access errors. * `INVALID_ARGUMENT` if the request is malformed. * `NOT_FOUND` if the requested course, course work, or student submission does not exist."
  {:scopes ["https://www.googleapis.com/auth/classroom.coursework.me"
            "https://www.googleapis.com/auth/classroom.coursework.students"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:id :courseWorkId :courseId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{courseId}/courseWork/{courseWorkId}/studentSubmissions/{id}:modifyAttachments"
     #{:id :courseWorkId :courseId}
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

(defn announcements-delete$
  "https://developers.google.com/classroom/api/reference/rest/v1/courses/announcements/delete
  
  Required parameters: courseId, id
  
  Optional parameters: none
  
  Deletes an announcement. This request must be made by the Developer Console project of the [OAuth client ID](https://support.google.com/cloud/answer/6158849) used to create the corresponding announcement item. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting developer project did not create the corresponding announcement, if the requesting user is not permitted to delete the requested course or for access errors. * `FAILED_PRECONDITION` if the requested announcement has already been deleted. * `NOT_FOUND` if no course exists with the requested ID."
  {:scopes ["https://www.googleapis.com/auth/classroom.announcements"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id :courseId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{courseId}/announcements/{id}"
     #{:id :courseId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn announcements-create$
  "https://developers.google.com/classroom/api/reference/rest/v1/courses/announcements/create
  
  Required parameters: courseId
  
  Optional parameters: none
  
  Body: 
  
  {:creationTime string,
   :individualStudentsOptions {:studentIds [string]},
   :creatorUserId string,
   :assigneeMode string,
   :scheduledTime string,
   :state string,
   :updateTime string,
   :id string,
   :alternateLink string,
   :materials [{:driveFile SharedDriveFile,
                :youtubeVideo YouTubeVideo,
                :link Link,
                :form Form}],
   :courseId string,
   :text string}
  
  Creates an announcement. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting user is not permitted to access the requested course, create announcements in the requested course, share a Drive attachment, or for access errors. * `INVALID_ARGUMENT` if the request is malformed. * `NOT_FOUND` if the requested course does not exist. * `FAILED_PRECONDITION` for the following request error: * AttachmentNotVisible"
  {:scopes ["https://www.googleapis.com/auth/classroom.announcements"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:courseId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{courseId}/announcements"
     #{:courseId}
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

(defn announcements-get$
  "https://developers.google.com/classroom/api/reference/rest/v1/courses/announcements/get
  
  Required parameters: courseId, id
  
  Optional parameters: none
  
  Returns an announcement. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting user is not permitted to access the requested course or announcement, or for access errors. * `INVALID_ARGUMENT` if the request is malformed. * `NOT_FOUND` if the requested course or announcement does not exist."
  {:scopes ["https://www.googleapis.com/auth/classroom.announcements"
            "https://www.googleapis.com/auth/classroom.announcements.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id :courseId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{courseId}/announcements/{id}"
     #{:id :courseId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn announcements-list$
  "https://developers.google.com/classroom/api/reference/rest/v1/courses/announcements/list
  
  Required parameters: courseId
  
  Optional parameters: announcementStates, orderBy, pageSize, pageToken
  
  Returns a list of announcements that the requester is permitted to view. Course students may only view `PUBLISHED` announcements. Course teachers and domain administrators may view all announcements. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting user is not permitted to access the requested course or for access errors. * `INVALID_ARGUMENT` if the request is malformed. * `NOT_FOUND` if the requested course does not exist."
  {:scopes ["https://www.googleapis.com/auth/classroom.announcements"
            "https://www.googleapis.com/auth/classroom.announcements.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:courseId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{courseId}/announcements"
     #{:courseId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn announcements-patch$
  "https://developers.google.com/classroom/api/reference/rest/v1/courses/announcements/patch
  
  Required parameters: courseId, id
  
  Optional parameters: updateMask
  
  Body: 
  
  {:creationTime string,
   :individualStudentsOptions {:studentIds [string]},
   :creatorUserId string,
   :assigneeMode string,
   :scheduledTime string,
   :state string,
   :updateTime string,
   :id string,
   :alternateLink string,
   :materials [{:driveFile SharedDriveFile,
                :youtubeVideo YouTubeVideo,
                :link Link,
                :form Form}],
   :courseId string,
   :text string}
  
  Updates one or more fields of an announcement. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting developer project did not create the corresponding announcement or for access errors. * `INVALID_ARGUMENT` if the request is malformed. * `FAILED_PRECONDITION` if the requested announcement has already been deleted. * `NOT_FOUND` if the requested course or announcement does not exist"
  {:scopes ["https://www.googleapis.com/auth/classroom.announcements"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:id :courseId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{courseId}/announcements/{id}"
     #{:id :courseId}
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

(defn announcements-modifyAssignees$
  "https://developers.google.com/classroom/api/reference/rest/v1/courses/announcements/modifyAssignees
  
  Required parameters: courseId, id
  
  Optional parameters: none
  
  Body: 
  
  {:assigneeMode string,
   :modifyIndividualStudentsOptions {:addStudentIds [string],
                                     :removeStudentIds [string]}}
  
  Modifies assignee mode and options of an announcement. Only a teacher of the course that contains the announcement may call this method. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting user is not permitted to access the requested course or course work or for access errors. * `INVALID_ARGUMENT` if the request is malformed. * `NOT_FOUND` if the requested course or course work does not exist."
  {:scopes ["https://www.googleapis.com/auth/classroom.announcements"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:id :courseId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{courseId}/announcements/{id}:modifyAssignees"
     #{:id :courseId}
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

(defn courseWorkMaterials-create$
  "https://developers.google.com/classroom/api/reference/rest/v1/courses/courseWorkMaterials/create
  
  Required parameters: courseId
  
  Optional parameters: none
  
  Body: 
  
  {:creationTime string,
   :description string,
   :individualStudentsOptions {:studentIds [string]},
   :creatorUserId string,
   :assigneeMode string,
   :topicId string,
   :scheduledTime string,
   :state string,
   :title string,
   :updateTime string,
   :id string,
   :alternateLink string,
   :materials [{:driveFile SharedDriveFile,
                :youtubeVideo YouTubeVideo,
                :link Link,
                :form Form}],
   :courseId string}
  
  Creates a course work material. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting user is not permitted to access the requested course, create course work material in the requested course, share a Drive attachment, or for access errors. * `INVALID_ARGUMENT` if the request is malformed or if more than 20 * materials are provided. * `NOT_FOUND` if the requested course does not exist. * `FAILED_PRECONDITION` for the following request error: * AttachmentNotVisible"
  {:scopes ["https://www.googleapis.com/auth/classroom.courseworkmaterials"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:courseId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{courseId}/courseWorkMaterials"
     #{:courseId}
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

(defn courseWorkMaterials-get$
  "https://developers.google.com/classroom/api/reference/rest/v1/courses/courseWorkMaterials/get
  
  Required parameters: courseId, id
  
  Optional parameters: none
  
  Returns a course work material. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting user is not permitted to access the requested course or course work material, or for access errors. * `INVALID_ARGUMENT` if the request is malformed. * `NOT_FOUND` if the requested course or course work material does not exist."
  {:scopes ["https://www.googleapis.com/auth/classroom.courseworkmaterials"
            "https://www.googleapis.com/auth/classroom.courseworkmaterials.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id :courseId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{courseId}/courseWorkMaterials/{id}"
     #{:id :courseId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn courseWorkMaterials-list$
  "https://developers.google.com/classroom/api/reference/rest/v1/courses/courseWorkMaterials/list
  
  Required parameters: courseId
  
  Optional parameters: courseWorkMaterialStates, orderBy, pageSize, pageToken, materialLink, materialDriveId
  
  Returns a list of course work material that the requester is permitted to view. Course students may only view `PUBLISHED` course work material. Course teachers and domain administrators may view all course work material. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting user is not permitted to access the requested course or for access errors. * `INVALID_ARGUMENT` if the request is malformed. * `NOT_FOUND` if the requested course does not exist."
  {:scopes ["https://www.googleapis.com/auth/classroom.courseworkmaterials"
            "https://www.googleapis.com/auth/classroom.courseworkmaterials.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:courseId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{courseId}/courseWorkMaterials"
     #{:courseId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn courseWorkMaterials-patch$
  "https://developers.google.com/classroom/api/reference/rest/v1/courses/courseWorkMaterials/patch
  
  Required parameters: courseId, id
  
  Optional parameters: updateMask
  
  Body: 
  
  {:creationTime string,
   :description string,
   :individualStudentsOptions {:studentIds [string]},
   :creatorUserId string,
   :assigneeMode string,
   :topicId string,
   :scheduledTime string,
   :state string,
   :title string,
   :updateTime string,
   :id string,
   :alternateLink string,
   :materials [{:driveFile SharedDriveFile,
                :youtubeVideo YouTubeVideo,
                :link Link,
                :form Form}],
   :courseId string}
  
  Updates one or more fields of a course work material. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting developer project for access errors. * `INVALID_ARGUMENT` if the request is malformed. * `FAILED_PRECONDITION` if the requested course work material has already been deleted. * `NOT_FOUND` if the requested course or course work material does not exist"
  {:scopes ["https://www.googleapis.com/auth/classroom.courseworkmaterials"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:id :courseId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{courseId}/courseWorkMaterials/{id}"
     #{:id :courseId}
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

(defn courseWorkMaterials-delete$
  "https://developers.google.com/classroom/api/reference/rest/v1/courses/courseWorkMaterials/delete
  
  Required parameters: courseId, id
  
  Optional parameters: none
  
  Deletes a course work material. This request must be made by the Developer Console project of the [OAuth client ID](https://support.google.com/cloud/answer/6158849) used to create the corresponding course work material item. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting developer project did not create the corresponding course work material, if the requesting user is not permitted to delete the requested course or for access errors. * `FAILED_PRECONDITION` if the requested course work material has already been deleted. * `NOT_FOUND` if no course exists with the requested ID."
  {:scopes ["https://www.googleapis.com/auth/classroom.courseworkmaterials"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id :courseId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{courseId}/courseWorkMaterials/{id}"
     #{:id :courseId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn topics-create$
  "https://developers.google.com/classroom/api/reference/rest/v1/courses/topics/create
  
  Required parameters: courseId
  
  Optional parameters: none
  
  Body: 
  
  {:courseId string, :topicId string, :name string, :updateTime string}
  
  Creates a topic. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting user is not permitted to access the requested course, create a topic in the requested course, or for access errors. * `INVALID_ARGUMENT` if the request is malformed. * `NOT_FOUND` if the requested course does not exist."
  {:scopes ["https://www.googleapis.com/auth/classroom.topics"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:courseId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{courseId}/topics"
     #{:courseId}
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

(defn topics-patch$
  "https://developers.google.com/classroom/api/reference/rest/v1/courses/topics/patch
  
  Required parameters: courseId, id
  
  Optional parameters: updateMask
  
  Body: 
  
  {:courseId string, :topicId string, :name string, :updateTime string}
  
  Updates one or more fields of a topic. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting developer project did not create the corresponding topic or for access errors. * `INVALID_ARGUMENT` if the request is malformed. * `NOT_FOUND` if the requested course or topic does not exist"
  {:scopes ["https://www.googleapis.com/auth/classroom.topics"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:id :courseId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{courseId}/topics/{id}"
     #{:id :courseId}
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

(defn topics-delete$
  "https://developers.google.com/classroom/api/reference/rest/v1/courses/topics/delete
  
  Required parameters: courseId, id
  
  Optional parameters: none
  
  Deletes a topic. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting user is not allowed to delete the requested topic or for access errors. * `FAILED_PRECONDITION` if the requested topic has already been deleted. * `NOT_FOUND` if no course or topic exists with the requested ID."
  {:scopes ["https://www.googleapis.com/auth/classroom.topics"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id :courseId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{courseId}/topics/{id}"
     #{:id :courseId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn topics-get$
  "https://developers.google.com/classroom/api/reference/rest/v1/courses/topics/get
  
  Required parameters: courseId, id
  
  Optional parameters: none
  
  Returns a topic. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting user is not permitted to access the requested course or topic, or for access errors. * `INVALID_ARGUMENT` if the request is malformed. * `NOT_FOUND` if the requested course or topic does not exist."
  {:scopes ["https://www.googleapis.com/auth/classroom.topics"
            "https://www.googleapis.com/auth/classroom.topics.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id :courseId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{courseId}/topics/{id}"
     #{:id :courseId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn topics-list$
  "https://developers.google.com/classroom/api/reference/rest/v1/courses/topics/list
  
  Required parameters: courseId
  
  Optional parameters: pageSize, pageToken
  
  Returns the list of topics that the requester is permitted to view. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting user is not permitted to access the requested course or for access errors. * `INVALID_ARGUMENT` if the request is malformed. * `NOT_FOUND` if the requested course does not exist."
  {:scopes ["https://www.googleapis.com/auth/classroom.topics"
            "https://www.googleapis.com/auth/classroom.topics.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:courseId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{courseId}/topics"
     #{:courseId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn teachers-create$
  "https://developers.google.com/classroom/api/reference/rest/v1/courses/teachers/create
  
  Required parameters: courseId
  
  Optional parameters: none
  
  Body: 
  
  {:courseId string,
   :userId string,
   :profile {:id string,
             :name Name,
             :emailAddress string,
             :photoUrl string,
             :permissions [GlobalPermission],
             :verifiedTeacher boolean}}
  
  Creates a teacher of a course. Domain administrators are permitted to [directly add](https://developers.google.com/classroom/guides/manage-users) users within their domain as teachers to courses within their domain. Non-admin users should send an Invitation instead. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting user is not permitted to create teachers in this course or for access errors. * `NOT_FOUND` if the requested course ID does not exist. * `FAILED_PRECONDITION` if the requested user's account is disabled, for the following request errors: * CourseMemberLimitReached * CourseNotModifiable * CourseTeacherLimitReached * UserGroupsMembershipLimitReached * InactiveCourseOwner * `ALREADY_EXISTS` if the user is already a teacher or student in the course."
  {:scopes ["https://www.googleapis.com/auth/classroom.profile.emails"
            "https://www.googleapis.com/auth/classroom.profile.photos"
            "https://www.googleapis.com/auth/classroom.rosters"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:courseId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{courseId}/teachers"
     #{:courseId}
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

(defn teachers-get$
  "https://developers.google.com/classroom/api/reference/rest/v1/courses/teachers/get
  
  Required parameters: courseId, userId
  
  Optional parameters: none
  
  Returns a teacher of a course. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting user is not permitted to view teachers of this course or for access errors. * `NOT_FOUND` if no teacher of this course has the requested ID or if the course does not exist."
  {:scopes ["https://www.googleapis.com/auth/classroom.profile.emails"
            "https://www.googleapis.com/auth/classroom.profile.photos"
            "https://www.googleapis.com/auth/classroom.rosters"
            "https://www.googleapis.com/auth/classroom.rosters.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:userId :courseId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{courseId}/teachers/{userId}"
     #{:userId :courseId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn teachers-delete$
  "https://developers.google.com/classroom/api/reference/rest/v1/courses/teachers/delete
  
  Required parameters: courseId, userId
  
  Optional parameters: none
  
  Removes the specified teacher from the specified course. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting user is not permitted to delete teachers of this course or for access errors. * `NOT_FOUND` if no teacher of this course has the requested ID or if the course does not exist. * `FAILED_PRECONDITION` if the requested ID belongs to the primary teacher of this course. * `FAILED_PRECONDITION` if the requested ID belongs to the owner of the course Drive folder. * `FAILED_PRECONDITION` if the course no longer has an active owner."
  {:scopes ["https://www.googleapis.com/auth/classroom.rosters"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:userId :courseId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{courseId}/teachers/{userId}"
     #{:userId :courseId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn teachers-list$
  "https://developers.google.com/classroom/api/reference/rest/v1/courses/teachers/list
  
  Required parameters: courseId
  
  Optional parameters: pageSize, pageToken
  
  Returns a list of teachers of this course that the requester is permitted to view. This method returns the following error codes: * `NOT_FOUND` if the course does not exist. * `PERMISSION_DENIED` for access errors."
  {:scopes ["https://www.googleapis.com/auth/classroom.profile.emails"
            "https://www.googleapis.com/auth/classroom.profile.photos"
            "https://www.googleapis.com/auth/classroom.rosters"
            "https://www.googleapis.com/auth/classroom.rosters.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:courseId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{courseId}/teachers"
     #{:courseId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn students-create$
  "https://developers.google.com/classroom/api/reference/rest/v1/courses/students/create
  
  Required parameters: courseId
  
  Optional parameters: enrollmentCode
  
  Body: 
  
  {:courseId string,
   :userId string,
   :profile {:id string,
             :name Name,
             :emailAddress string,
             :photoUrl string,
             :permissions [GlobalPermission],
             :verifiedTeacher boolean},
   :studentWorkFolder {:id string, :title string, :alternateLink string}}
  
  Adds a user as a student of a course. Domain administrators are permitted to [directly add](https://developers.google.com/classroom/guides/manage-users) users within their domain as students to courses within their domain. Students are permitted to add themselves to a course using an enrollment code. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting user is not permitted to create students in this course or for access errors. * `NOT_FOUND` if the requested course ID does not exist. * `FAILED_PRECONDITION` if the requested user's account is disabled, for the following request errors: * CourseMemberLimitReached * CourseNotModifiable * UserGroupsMembershipLimitReached * InactiveCourseOwner * `ALREADY_EXISTS` if the user is already a student or teacher in the course."
  {:scopes ["https://www.googleapis.com/auth/classroom.profile.emails"
            "https://www.googleapis.com/auth/classroom.profile.photos"
            "https://www.googleapis.com/auth/classroom.rosters"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:courseId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{courseId}/students"
     #{:courseId}
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

(defn students-get$
  "https://developers.google.com/classroom/api/reference/rest/v1/courses/students/get
  
  Required parameters: courseId, userId
  
  Optional parameters: none
  
  Returns a student of a course. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting user is not permitted to view students of this course or for access errors. * `NOT_FOUND` if no student of this course has the requested ID or if the course does not exist."
  {:scopes ["https://www.googleapis.com/auth/classroom.profile.emails"
            "https://www.googleapis.com/auth/classroom.profile.photos"
            "https://www.googleapis.com/auth/classroom.rosters"
            "https://www.googleapis.com/auth/classroom.rosters.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:userId :courseId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{courseId}/students/{userId}"
     #{:userId :courseId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn students-delete$
  "https://developers.google.com/classroom/api/reference/rest/v1/courses/students/delete
  
  Required parameters: courseId, userId
  
  Optional parameters: none
  
  Deletes a student of a course. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting user is not permitted to delete students of this course or for access errors. * `NOT_FOUND` if no student of this course has the requested ID or if the course does not exist."
  {:scopes ["https://www.googleapis.com/auth/classroom.rosters"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:userId :courseId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{courseId}/students/{userId}"
     #{:userId :courseId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn students-list$
  "https://developers.google.com/classroom/api/reference/rest/v1/courses/students/list
  
  Required parameters: courseId
  
  Optional parameters: pageSize, pageToken
  
  Returns a list of students of this course that the requester is permitted to view. This method returns the following error codes: * `NOT_FOUND` if the course does not exist. * `PERMISSION_DENIED` for access errors."
  {:scopes ["https://www.googleapis.com/auth/classroom.profile.emails"
            "https://www.googleapis.com/auth/classroom.profile.photos"
            "https://www.googleapis.com/auth/classroom.rosters"
            "https://www.googleapis.com/auth/classroom.rosters.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:courseId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://classroom.googleapis.com/"
     "v1/courses/{courseId}/students"
     #{:courseId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
