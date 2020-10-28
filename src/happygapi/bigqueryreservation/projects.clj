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

(defn locations-searchAssignments$
  "https://cloud.google.com/bigquery/api/reference/rest/v1/projects/locations/searchAssignments
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize, query
  
  Looks up assignments for a specified resource for a particular region. If the request is about a project: 1. Assignments created on the project will be returned if they exist. 2. Otherwise assignments created on the closest ancestor will be returned. 3. Assignments for different JobTypes will all be returned. The same logic applies if the request is about a folder. If the request is about an organization, then assignments created on the organization will be returned (organization doesn't have ancestors). Comparing to ListAssignments, there are some behavior differences: 1. permission on the assignee will be verified in this API. 2. Hierarchy lookup (project->folder->organization) happens in this API. 3. Parent here is `projects/*/locations/*`, instead of `projects/*/locations/*reservations/*`. **Note** \"-\" cannot be used for projects nor locations."
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

(defn locations-updateBiReservation$
  "https://cloud.google.com/bigquery/api/reference/rest/v1/projects/locations/updateBiReservation
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:updateTime string, :name string, :size string}
  
  Updates a BI reservation. Only fields specified in the `field_mask` are updated. A singleton BI reservation always exists with default size 0. In order to reserve BI capacity it needs to be updated to an amount greater than 0. In order to release BI capacity reservation size must be set to 0."
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

(defn locations-searchAllAssignments$
  "https://cloud.google.com/bigquery/api/reference/rest/v1/projects/locations/searchAllAssignments
  
  Required parameters: parent
  
  Optional parameters: pageSize, query, pageToken
  
  Looks up assignments for a specified resource for a particular region. If the request is about a project: 1. Assignments created on the project will be returned if they exist. 2. Otherwise assignments created on the closest ancestor will be returned. 3. Assignments for different JobTypes will all be returned. The same logic applies if the request is about a folder. If the request is about an organization, then assignments created on the organization will be returned (organization doesn't have ancestors). Comparing to ListAssignments, there are some behavior differences: 1. permission on the assignee will be verified in this API. 2. Hierarchy lookup (project->folder->organization) happens in this API. 3. Parent here is `projects/*/locations/*`, instead of `projects/*/locations/*reservations/*`."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://bigqueryreservation.googleapis.com/"
     "v1/{+parent}:searchAllAssignments"
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
   :failureStatus {:details [{}], :message string, :code integer},
   :plan string,
   :state string,
   :commitmentEndTime string,
   :commitmentStartTime string,
   :name string,
   :renewalPlan string}
  
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

(defn locations-capacityCommitments-merge$
  "https://cloud.google.com/bigquery/api/reference/rest/v1/projects/locations/capacityCommitments/merge
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:capacityCommitmentIds [string]}
  
  Merges capacity commitments of the same plan into a single commitment. The resulting capacity commitment has the greater commitment_end_time out of the to-be-merged capacity commitments. Attempting to merge capacity commitments of different plan will fail with the error code `google.rpc.Code.FAILED_PRECONDITION`."
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

(defn locations-capacityCommitments-patch$
  "https://cloud.google.com/bigquery/api/reference/rest/v1/projects/locations/capacityCommitments/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:slotCount string,
   :failureStatus {:details [{}], :message string, :code integer},
   :plan string,
   :state string,
   :commitmentEndTime string,
   :commitmentStartTime string,
   :name string,
   :renewalPlan string}
  
  Updates an existing capacity commitment. Only `plan` and `renewal_plan` fields can be updated. Plan can only be changed to a plan of a longer commitment period. Attempting to change to a plan with shorter commitment period will fail with the error code `google.rpc.Code.FAILED_PRECONDITION`."
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

(defn locations-capacityCommitments-delete$
  "https://cloud.google.com/bigquery/api/reference/rest/v1/projects/locations/capacityCommitments/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a capacity commitment. Attempting to delete capacity commitment before its commitment_end_time will fail with the error code `google.rpc.Code.FAILED_PRECONDITION`."
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

(defn locations-capacityCommitments-split$
  "https://cloud.google.com/bigquery/api/reference/rest/v1/projects/locations/capacityCommitments/split
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:slotCount string}
  
  Splits capacity commitment to two commitments of the same plan and `commitment_end_time`. A common use case is to enable downgrading commitments. For example, in order to downgrade from 10000 slots to 8000, you might split a 10000 capacity commitment into commitments of 2000 and 8000. Then, you would change the plan of the first one to `FLEX` and then delete it."
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

(defn locations-capacityCommitments-list$
  "https://cloud.google.com/bigquery/api/reference/rest/v1/projects/locations/capacityCommitments/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
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

(defn locations-reservations-list$
  "https://cloud.google.com/bigquery/api/reference/rest/v1/projects/locations/reservations/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
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

(defn locations-reservations-patch$
  "https://cloud.google.com/bigquery/api/reference/rest/v1/projects/locations/reservations/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:updateTime string,
   :creationTime string,
   :name string,
   :slotCapacity string,
   :ignoreIdleSlots boolean}
  
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

(defn locations-reservations-create$
  "https://cloud.google.com/bigquery/api/reference/rest/v1/projects/locations/reservations/create
  
  Required parameters: parent
  
  Optional parameters: reservationId
  
  Body: 
  
  {:updateTime string,
   :creationTime string,
   :name string,
   :slotCapacity string,
   :ignoreIdleSlots boolean}
  
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
  
  Deletes a reservation. Returns `google.rpc.Code.FAILED_PRECONDITION` when reservation has assignments."
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

(defn locations-reservations-assignments-create$
  "https://cloud.google.com/bigquery/api/reference/rest/v1/projects/locations/reservations/assignments/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:name string, :jobType string, :assignee string, :state string}
  
  Creates an assignment object which allows the given project to submit jobs of a certain type using slots from the specified reservation. Currently a resource (project, folder, organization) can only have one assignment per each (job_type, location) combination, and that reservation will be used for all jobs of the matching type. Different assignments can be created on different levels of the projects, folders or organization hierarchy. During query execution, the assignment is looked up at the project, folder and organization levels in that order. The first assignment found is applied to the query. When creating assignments, it does not matter if other assignments exist at higher levels. Example: * The organization `organizationA` contains two projects, `project1` and `project2`. * Assignments for all three entities (`organizationA`, `project1`, and `project2`) could all be created and mapped to the same or different reservations. Returns `google.rpc.Code.PERMISSION_DENIED` if user does not have 'bigquery.admin' permissions on the project using the reservation and the project that owns this reservation. Returns `google.rpc.Code.INVALID_ARGUMENT` when location of the assignment does not match location of the reservation."
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

(defn locations-reservations-assignments-delete$
  "https://cloud.google.com/bigquery/api/reference/rest/v1/projects/locations/reservations/assignments/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a assignment. No expansion will happen. Example: * Organization `organizationA` contains two projects, `project1` and `project2`. * Reservation `res1` exists and was created previously. * CreateAssignment was used previously to define the following associations between entities and reservations: `` and `` In this example, deletion of the `` assignment won't affect the other assignment ``. After said deletion, queries from `project1` will still use `res1` while queries from `project2` will switch to use on-demand mode."
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

(defn locations-reservations-assignments-move$
  "https://cloud.google.com/bigquery/api/reference/rest/v1/projects/locations/reservations/assignments/move
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:destinationId string}
  
  Moves an assignment under a new reservation. This differs from removing an existing assignment and recreating a new one by providing a transactional change that ensures an assignee always has an associated reservation."
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

(defn locations-reservations-assignments-list$
  "https://cloud.google.com/bigquery/api/reference/rest/v1/projects/locations/reservations/assignments/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Lists assignments. Only explicitly created assignments will be returned. Example: * Organization `organizationA` contains two projects, `project1` and `project2`. * Reservation `res1` exists and was created previously. * CreateAssignment was used previously to define the following associations between entities and reservations: `` and `` In this example, ListAssignments will just return the above two assignments for reservation `res1`, and no expansion/merge will happen. The wildcard \"-\" can be used for reservations in the request. In that case all assignments belongs to the specified project and location will be listed. **Note** \"-\" cannot be used for projects nor locations."
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
