(ns happygapi.bigqueryreservation.projects
  "BigQuery Reservation API: projects.
  A service to modify your BigQuery flat-rate reservations.
  See: https://cloud.google.com/bigquery/api/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-getBiReservation$
  "https://cloud.google.com/bigquery/api/reference/rest/v1/projects/locations/getBiReservation
  
  Required parameters: name
  
  Optional parameters: none
  
  Retrieves a BI reservation."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://bigqueryreservation.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-updateBiReservation$
  "https://cloud.google.com/bigquery/api/reference/rest/v1/projects/locations/updateBiReservation
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:size string, :updateTime string, :name string}
  
  Updates a BI reservation.
  Only fields specified in the field_mask are updated.
  Singleton BI reservation always exists with default size 0.
  In order to reserve BI capacity it needs to be updated to an amount
  greater than 0. In order to release BI capacity reservation size
  must be set to 0."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://bigqueryreservation.googleapis.com/"
     "v1/{+name}"
     #{:name}
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

(defn locations-searchAssignments$
  "https://cloud.google.com/bigquery/api/reference/rest/v1/projects/locations/searchAssignments
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize, query
  
  Looks up assignments for a specified resource for a particular region.
  If the request is about a project:
    1) Assignments created on the project will be returned if they exist.
    2) Otherwise assignments created on the closest ancestor will be
    returned. 3) Assignments for different JobTypes will all be returned.
  Same logic applies if the request is about a folder.
  If the request is about an organization, then assignments created on the
  organization will be returned (organization doesn't have ancestors).
  Comparing to ListAssignments, there are some behavior
  differences:
    1) permission on the assignee will be verified in this API.
    2) Hierarchy lookup (project->folder->organization) happens in this API.
    3) Parent here is projects/*/locations/*, instead of
    projects/*/locations/*reservations/*.
  Note \"-\" cannot be used for projects
  nor locations."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://bigqueryreservation.googleapis.com/"
     "v1/{+parent}:searchAssignments"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-capacityCommitments-split$
  "https://cloud.google.com/bigquery/api/reference/rest/v1/projects/locations/capacityCommitments/split
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:slotCount string}
  
  Splits capacity commitment to two commitments of the same plan and
  commitment_end_time. A common use case to do that is to perform a downgrade
  e.g., in order to downgrade from 10000 slots to 8000, one might split 10000
  capacity commitment to 2000 and 8000, change the plan of the first one to
  flex and then delete it."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://bigqueryreservation.googleapis.com/"
     "v1/{+name}:split"
     #{:name}
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

(defn locations-capacityCommitments-merge$
  "https://cloud.google.com/bigquery/api/reference/rest/v1/projects/locations/capacityCommitments/merge
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:capacityCommitmentIds [string]}
  
  Merges capacity commitments of the same plan into one. Resulting capacity
  commitment has the longer commitment_end_time out of the two. Attempting to
  merge capacity commitments of different plan will fail with the error code
  `google.rpc.Code.FAILED_PRECONDITION`."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://bigqueryreservation.googleapis.com/"
     "v1/{+parent}/capacityCommitments:merge"
     #{:parent}
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

(defn locations-capacityCommitments-delete$
  "https://cloud.google.com/bigquery/api/reference/rest/v1/projects/locations/capacityCommitments/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a capacity commitment. Attempting to delete capacity commitment
  before its commitment_end_time will fail with the error code
  `google.rpc.Code.FAILED_PRECONDITION`."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://bigqueryreservation.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-capacityCommitments-list$
  "https://cloud.google.com/bigquery/api/reference/rest/v1/projects/locations/capacityCommitments/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Lists all the capacity commitments for the admin project."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://bigqueryreservation.googleapis.com/"
     "v1/{+parent}/capacityCommitments"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-capacityCommitments-create$
  "https://cloud.google.com/bigquery/api/reference/rest/v1/projects/locations/capacityCommitments/create
  
  Required parameters: parent
  
  Optional parameters: enforceSingleAdminProjectPerOrg
  
  Body: 
  
  {:slotCount string,
   :renewalPlan string,
   :failureStatus {:code integer, :message string, :details [{}]},
   :commitmentEndTime string,
   :state string,
   :name string,
   :plan string}
  
  Creates a new capacity commitment resource."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://bigqueryreservation.googleapis.com/"
     "v1/{+parent}/capacityCommitments"
     #{:parent}
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

(defn locations-capacityCommitments-patch$
  "https://cloud.google.com/bigquery/api/reference/rest/v1/projects/locations/capacityCommitments/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:slotCount string,
   :renewalPlan string,
   :failureStatus {:code integer, :message string, :details [{}]},
   :commitmentEndTime string,
   :state string,
   :name string,
   :plan string}
  
  Updates an existing capacity commitment.
  
  Only plan and renewal_plan fields can be updated.
  Plan can only be changed to a plan of a longer commitment period.
  Attempting to change to a plan with shorter commitment period will fail
  with the error code `google.rpc.Code.FAILED_PRECONDITION`."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://bigqueryreservation.googleapis.com/"
     "v1/{+name}"
     #{:name}
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

(defn locations-capacityCommitments-get$
  "https://cloud.google.com/bigquery/api/reference/rest/v1/projects/locations/capacityCommitments/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns information about the capacity commitment."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://bigqueryreservation.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-reservations-list$
  "https://cloud.google.com/bigquery/api/reference/rest/v1/projects/locations/reservations/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Lists all the reservations for the project in the specified location."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://bigqueryreservation.googleapis.com/"
     "v1/{+parent}/reservations"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-reservations-get$
  "https://cloud.google.com/bigquery/api/reference/rest/v1/projects/locations/reservations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns information about the reservation."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://bigqueryreservation.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-reservations-patch$
  "https://cloud.google.com/bigquery/api/reference/rest/v1/projects/locations/reservations/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:slotCapacity string, :name string, :ignoreIdleSlots boolean}
  
  Updates an existing reservation resource."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://bigqueryreservation.googleapis.com/"
     "v1/{+name}"
     #{:name}
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

(defn locations-reservations-create$
  "https://cloud.google.com/bigquery/api/reference/rest/v1/projects/locations/reservations/create
  
  Required parameters: parent
  
  Optional parameters: reservationId
  
  Body: 
  
  {:slotCapacity string, :name string, :ignoreIdleSlots boolean}
  
  Creates a new reservation resource."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://bigqueryreservation.googleapis.com/"
     "v1/{+parent}/reservations"
     #{:parent}
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

(defn locations-reservations-delete$
  "https://cloud.google.com/bigquery/api/reference/rest/v1/projects/locations/reservations/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a reservation.
  Returns `google.rpc.Code.FAILED_PRECONDITION` when reservation has
  assignments."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://bigqueryreservation.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-reservations-assignments-list$
  "https://cloud.google.com/bigquery/api/reference/rest/v1/projects/locations/reservations/assignments/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Lists assignments.
  Only explicitly created assignments will be returned. E.g:
  organizationA contains project1 and project2. Reservation res1 exists.
  CreateAssignment was invoked previously and following assignments were
  created explicitly:
    <organizationA, res1>
    <project1, res1>
  Then this API will just return the above two assignments for reservation
  res1, and no expansion/merge will happen. Wildcard \"-\" can be used for
  reservations in the request. In that case all assignments belongs to the
  specified project and location will be listed. Note
  \"-\" cannot be used for projects nor locations."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://bigqueryreservation.googleapis.com/"
     "v1/{+parent}/assignments"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-reservations-assignments-create$
  "https://cloud.google.com/bigquery/api/reference/rest/v1/projects/locations/reservations/assignments/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:jobType string, :state string, :name string, :assignee string}
  
  Creates an object which allows the given project to submit jobs
  of a certain type using slots from the specified reservation. Currently a
  resource (project, folder, organization) can only have one assignment per
  {job_type, location}, and that reservation will be used for all jobs of the
  matching type. Within the organization, different assignments can be
  created on projects, folders or organization level. During query execution,
  the assignment is looked up at the project, folder and organization levels
  in that order. The first assignment found is applied to the query. When
  creating assignments, it does not matter if other assignments exist at
  higher levels. E.g: organizationA contains project1, project2. Assignments
  for organizationA, project1 and project2 could all be created, mapping to
  the same or different reservations.
  Returns `google.rpc.Code.PERMISSION_DENIED` if user does not have
  'bigquery.admin' permissions on the project using the reservation
  and the project that owns this reservation.
  Returns `google.rpc.Code.INVALID_ARGUMENT` when location of the assignment
  does not match location of the reservation."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://bigqueryreservation.googleapis.com/"
     "v1/{+parent}/assignments"
     #{:parent}
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

(defn locations-reservations-assignments-move$
  "https://cloud.google.com/bigquery/api/reference/rest/v1/projects/locations/reservations/assignments/move
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:destinationId string}
  
  Moves a assignment under a new reservation. Customers can do this by
  deleting the existing assignment followed by creating another assignment
  under the new reservation, but this method provides a transactional way to
  do so, to make sure the assignee always has an associated reservation.
  Without the method customers might see some queries run on-demand which
  might be unexpected."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://bigqueryreservation.googleapis.com/"
     "v1/{+name}:move"
     #{:name}
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

(defn locations-reservations-assignments-delete$
  "https://cloud.google.com/bigquery/api/reference/rest/v1/projects/locations/reservations/assignments/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a assignment. No expansion will happen.
  E.g:
  organizationA contains project1 and project2. Reservation res1 exists.
  CreateAssignment was invoked previously and following assignments were
  created explicitly:
    <organizationA, res1>
    <project1, res1>
  Then deletion of <organizationA, res1> won't affect <project1, res1>. After
  deletion of <organizationA, res1>, queries from project1 will still use
  res1, while queries from project2 will use on-demand mode."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://bigqueryreservation.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
