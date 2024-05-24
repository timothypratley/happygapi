(ns happygapi.fitness.users
  "Fitness API: users.
  The Fitness API for managing users' fitness tracking data.
  See: https://developers.google.com/fit/rest/v1/get-starteddocs/reference/rest/v1/users"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn dataset-aggregate$
  "https://developers.google.com/fit/rest/v1/get-startedapi/reference/rest/v1/users/dataset/aggregate
  
  Required parameters: userId
  
  Optional parameters: none
  
  Body: 
  
  {:bucketByActivityType {:minDurationMillis string,
                          :activityDataSourceId string},
   :aggregateBy [{:dataSourceId string, :dataTypeName string}],
   :startTimeMillis string,
   :bucketByTime {:durationMillis string, :period BucketByTimePeriod},
   :filteredDataQualityStandard [string],
   :endTimeMillis string,
   :bucketByActivitySegment {:minDurationMillis string,
                             :activityDataSourceId string},
   :bucketBySession {:minDurationMillis string}}
  
  Aggregates data of a certain type or stream into buckets divided by a given type of boundary. Multiple data sets of multiple types and from multiple sources can be aggregated into exactly one bucket type per request."
  {:scopes ["https://www.googleapis.com/auth/fitness.activity.read"
            "https://www.googleapis.com/auth/fitness.activity.write"
            "https://www.googleapis.com/auth/fitness.blood_glucose.read"
            "https://www.googleapis.com/auth/fitness.blood_glucose.write"
            "https://www.googleapis.com/auth/fitness.blood_pressure.read"
            "https://www.googleapis.com/auth/fitness.blood_pressure.write"
            "https://www.googleapis.com/auth/fitness.body.read"
            "https://www.googleapis.com/auth/fitness.body.write"
            "https://www.googleapis.com/auth/fitness.body_temperature.read"
            "https://www.googleapis.com/auth/fitness.body_temperature.write"
            "https://www.googleapis.com/auth/fitness.heart_rate.read"
            "https://www.googleapis.com/auth/fitness.heart_rate.write"
            "https://www.googleapis.com/auth/fitness.location.read"
            "https://www.googleapis.com/auth/fitness.location.write"
            "https://www.googleapis.com/auth/fitness.nutrition.read"
            "https://www.googleapis.com/auth/fitness.nutrition.write"
            "https://www.googleapis.com/auth/fitness.oxygen_saturation.read"
            "https://www.googleapis.com/auth/fitness.oxygen_saturation.write"
            "https://www.googleapis.com/auth/fitness.reproductive_health.read"
            "https://www.googleapis.com/auth/fitness.reproductive_health.write"
            "https://www.googleapis.com/auth/fitness.sleep.read"
            "https://www.googleapis.com/auth/fitness.sleep.write"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:userId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://fitness.googleapis.com/fitness/v1/users/"
     "{userId}/dataset:aggregate"
     #{:userId}
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

(defn dataSources-update$
  "https://developers.google.com/fit/rest/v1/get-startedapi/reference/rest/v1/users/dataSources/update
  
  Required parameters: userId, dataSourceId
  
  Optional parameters: none
  
  Body: 
  
  {:type string,
   :dataQualityStandard [string],
   :dataStreamName string,
   :device {:type string,
            :manufacturer string,
            :model string,
            :uid string,
            :version string},
   :application {:detailsUrl string,
                 :name string,
                 :packageName string,
                 :version string},
   :dataStreamId string,
   :dataType {:field [DataTypeField], :name string},
   :name string}
  
  Updates the specified data source. The dataStreamId, dataType, type, dataStreamName, and device properties with the exception of version, cannot be modified. Data sources are identified by their dataStreamId."
  {:scopes ["https://www.googleapis.com/auth/fitness.activity.write"
            "https://www.googleapis.com/auth/fitness.blood_glucose.write"
            "https://www.googleapis.com/auth/fitness.blood_pressure.write"
            "https://www.googleapis.com/auth/fitness.body.write"
            "https://www.googleapis.com/auth/fitness.body_temperature.write"
            "https://www.googleapis.com/auth/fitness.heart_rate.write"
            "https://www.googleapis.com/auth/fitness.location.write"
            "https://www.googleapis.com/auth/fitness.nutrition.write"
            "https://www.googleapis.com/auth/fitness.oxygen_saturation.write"
            "https://www.googleapis.com/auth/fitness.reproductive_health.write"
            "https://www.googleapis.com/auth/fitness.sleep.write"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:dataSourceId :userId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://fitness.googleapis.com/fitness/v1/users/"
     "{userId}/dataSources/{dataSourceId}"
     #{:dataSourceId :userId}
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

(defn dataSources-create$
  "https://developers.google.com/fit/rest/v1/get-startedapi/reference/rest/v1/users/dataSources/create
  
  Required parameters: userId
  
  Optional parameters: none
  
  Body: 
  
  {:type string,
   :dataQualityStandard [string],
   :dataStreamName string,
   :device {:type string,
            :manufacturer string,
            :model string,
            :uid string,
            :version string},
   :application {:detailsUrl string,
                 :name string,
                 :packageName string,
                 :version string},
   :dataStreamId string,
   :dataType {:field [DataTypeField], :name string},
   :name string}
  
  Creates a new data source that is unique across all data sources belonging to this user. A data source is a unique source of sensor data. Data sources can expose raw data coming from hardware sensors on local or companion devices. They can also expose derived data, created by transforming or merging other data sources. Multiple data sources can exist for the same data type. Every data point in every dataset inserted into or read from the Fitness API has an associated data source. Each data source produces a unique stream of dataset updates, with a unique data source identifier. Not all changes to data source affect the data stream ID, so that data collected by updated versions of the same application/device can still be considered to belong to the same data source. Data sources are identified using a string generated by the server, based on the contents of the source being created. The dataStreamId field should not be set when invoking this method. It will be automatically generated by the server with the correct format. If a dataStreamId is set, it must match the format that the server would generate. This format is a combination of some fields from the data source, and has a specific order. If it doesn't match, the request will fail with an error. Specifying a DataType which is not a known type (beginning with \"com.google.\") will create a DataSource with a *custom data type*. Custom data types are only readable by the application that created them. Custom data types are *deprecated*; use standard data types instead. In addition to the data source fields included in the data source ID, the developer project number that is authenticated when creating the data source is included. This developer project number is obfuscated when read by any other developer reading public data types."
  {:scopes ["https://www.googleapis.com/auth/fitness.activity.write"
            "https://www.googleapis.com/auth/fitness.blood_glucose.write"
            "https://www.googleapis.com/auth/fitness.blood_pressure.write"
            "https://www.googleapis.com/auth/fitness.body.write"
            "https://www.googleapis.com/auth/fitness.body_temperature.write"
            "https://www.googleapis.com/auth/fitness.heart_rate.write"
            "https://www.googleapis.com/auth/fitness.location.write"
            "https://www.googleapis.com/auth/fitness.nutrition.write"
            "https://www.googleapis.com/auth/fitness.oxygen_saturation.write"
            "https://www.googleapis.com/auth/fitness.reproductive_health.write"
            "https://www.googleapis.com/auth/fitness.sleep.write"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:userId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://fitness.googleapis.com/fitness/v1/users/"
     "{userId}/dataSources"
     #{:userId}
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

(defn dataSources-get$
  "https://developers.google.com/fit/rest/v1/get-startedapi/reference/rest/v1/users/dataSources/get
  
  Required parameters: dataSourceId, userId
  
  Optional parameters: none
  
  Returns the specified data source."
  {:scopes ["https://www.googleapis.com/auth/fitness.activity.read"
            "https://www.googleapis.com/auth/fitness.activity.write"
            "https://www.googleapis.com/auth/fitness.blood_glucose.read"
            "https://www.googleapis.com/auth/fitness.blood_glucose.write"
            "https://www.googleapis.com/auth/fitness.blood_pressure.read"
            "https://www.googleapis.com/auth/fitness.blood_pressure.write"
            "https://www.googleapis.com/auth/fitness.body.read"
            "https://www.googleapis.com/auth/fitness.body.write"
            "https://www.googleapis.com/auth/fitness.body_temperature.read"
            "https://www.googleapis.com/auth/fitness.body_temperature.write"
            "https://www.googleapis.com/auth/fitness.heart_rate.read"
            "https://www.googleapis.com/auth/fitness.heart_rate.write"
            "https://www.googleapis.com/auth/fitness.location.read"
            "https://www.googleapis.com/auth/fitness.location.write"
            "https://www.googleapis.com/auth/fitness.nutrition.read"
            "https://www.googleapis.com/auth/fitness.nutrition.write"
            "https://www.googleapis.com/auth/fitness.oxygen_saturation.read"
            "https://www.googleapis.com/auth/fitness.oxygen_saturation.write"
            "https://www.googleapis.com/auth/fitness.reproductive_health.read"
            "https://www.googleapis.com/auth/fitness.reproductive_health.write"
            "https://www.googleapis.com/auth/fitness.sleep.read"
            "https://www.googleapis.com/auth/fitness.sleep.write"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:dataSourceId :userId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://fitness.googleapis.com/fitness/v1/users/"
     "{userId}/dataSources/{dataSourceId}"
     #{:dataSourceId :userId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn dataSources-delete$
  "https://developers.google.com/fit/rest/v1/get-startedapi/reference/rest/v1/users/dataSources/delete
  
  Required parameters: userId, dataSourceId
  
  Optional parameters: none
  
  Deletes the specified data source. The request will fail if the data source contains any data points."
  {:scopes ["https://www.googleapis.com/auth/fitness.activity.write"
            "https://www.googleapis.com/auth/fitness.blood_glucose.write"
            "https://www.googleapis.com/auth/fitness.blood_pressure.write"
            "https://www.googleapis.com/auth/fitness.body.write"
            "https://www.googleapis.com/auth/fitness.body_temperature.write"
            "https://www.googleapis.com/auth/fitness.heart_rate.write"
            "https://www.googleapis.com/auth/fitness.location.write"
            "https://www.googleapis.com/auth/fitness.nutrition.write"
            "https://www.googleapis.com/auth/fitness.oxygen_saturation.write"
            "https://www.googleapis.com/auth/fitness.reproductive_health.write"
            "https://www.googleapis.com/auth/fitness.sleep.write"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:dataSourceId :userId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://fitness.googleapis.com/fitness/v1/users/"
     "{userId}/dataSources/{dataSourceId}"
     #{:dataSourceId :userId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn dataSources-list$
  "https://developers.google.com/fit/rest/v1/get-startedapi/reference/rest/v1/users/dataSources/list
  
  Required parameters: userId
  
  Optional parameters: dataTypeName
  
  Lists all data sources that are visible to the developer, using the OAuth scopes provided. The list is not exhaustive; the user may have private data sources that are only visible to other developers, or calls using other scopes."
  {:scopes ["https://www.googleapis.com/auth/fitness.activity.read"
            "https://www.googleapis.com/auth/fitness.activity.write"
            "https://www.googleapis.com/auth/fitness.blood_glucose.read"
            "https://www.googleapis.com/auth/fitness.blood_glucose.write"
            "https://www.googleapis.com/auth/fitness.blood_pressure.read"
            "https://www.googleapis.com/auth/fitness.blood_pressure.write"
            "https://www.googleapis.com/auth/fitness.body.read"
            "https://www.googleapis.com/auth/fitness.body.write"
            "https://www.googleapis.com/auth/fitness.body_temperature.read"
            "https://www.googleapis.com/auth/fitness.body_temperature.write"
            "https://www.googleapis.com/auth/fitness.heart_rate.read"
            "https://www.googleapis.com/auth/fitness.heart_rate.write"
            "https://www.googleapis.com/auth/fitness.location.read"
            "https://www.googleapis.com/auth/fitness.location.write"
            "https://www.googleapis.com/auth/fitness.nutrition.read"
            "https://www.googleapis.com/auth/fitness.nutrition.write"
            "https://www.googleapis.com/auth/fitness.oxygen_saturation.read"
            "https://www.googleapis.com/auth/fitness.oxygen_saturation.write"
            "https://www.googleapis.com/auth/fitness.reproductive_health.read"
            "https://www.googleapis.com/auth/fitness.reproductive_health.write"
            "https://www.googleapis.com/auth/fitness.sleep.read"
            "https://www.googleapis.com/auth/fitness.sleep.write"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:userId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://fitness.googleapis.com/fitness/v1/users/"
     "{userId}/dataSources"
     #{:userId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn dataSources-dataPointChanges-list$
  "https://developers.google.com/fit/rest/v1/get-startedapi/reference/rest/v1/users/dataSources/dataPointChanges/list
  
  Required parameters: userId, dataSourceId
  
  Optional parameters: limit, pageToken
  
  Queries for user's data point changes for a particular data source."
  {:scopes ["https://www.googleapis.com/auth/fitness.activity.read"
            "https://www.googleapis.com/auth/fitness.activity.write"
            "https://www.googleapis.com/auth/fitness.blood_glucose.read"
            "https://www.googleapis.com/auth/fitness.blood_glucose.write"
            "https://www.googleapis.com/auth/fitness.blood_pressure.read"
            "https://www.googleapis.com/auth/fitness.blood_pressure.write"
            "https://www.googleapis.com/auth/fitness.body.read"
            "https://www.googleapis.com/auth/fitness.body.write"
            "https://www.googleapis.com/auth/fitness.body_temperature.read"
            "https://www.googleapis.com/auth/fitness.body_temperature.write"
            "https://www.googleapis.com/auth/fitness.heart_rate.read"
            "https://www.googleapis.com/auth/fitness.heart_rate.write"
            "https://www.googleapis.com/auth/fitness.location.read"
            "https://www.googleapis.com/auth/fitness.location.write"
            "https://www.googleapis.com/auth/fitness.nutrition.read"
            "https://www.googleapis.com/auth/fitness.nutrition.write"
            "https://www.googleapis.com/auth/fitness.oxygen_saturation.read"
            "https://www.googleapis.com/auth/fitness.oxygen_saturation.write"
            "https://www.googleapis.com/auth/fitness.reproductive_health.read"
            "https://www.googleapis.com/auth/fitness.reproductive_health.write"
            "https://www.googleapis.com/auth/fitness.sleep.read"
            "https://www.googleapis.com/auth/fitness.sleep.write"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:dataSourceId :userId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://fitness.googleapis.com/fitness/v1/users/"
     "{userId}/dataSources/{dataSourceId}/dataPointChanges"
     #{:dataSourceId :userId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn dataSources-datasets-get$
  "https://developers.google.com/fit/rest/v1/get-startedapi/reference/rest/v1/users/dataSources/datasets/get
  
  Required parameters: datasetId, dataSourceId, userId
  
  Optional parameters: pageToken, limit
  
  Returns a dataset containing all data points whose start and end times overlap with the specified range of the dataset minimum start time and maximum end time. Specifically, any data point whose start time is less than or equal to the dataset end time and whose end time is greater than or equal to the dataset start time."
  {:scopes ["https://www.googleapis.com/auth/fitness.activity.read"
            "https://www.googleapis.com/auth/fitness.activity.write"
            "https://www.googleapis.com/auth/fitness.blood_glucose.read"
            "https://www.googleapis.com/auth/fitness.blood_glucose.write"
            "https://www.googleapis.com/auth/fitness.blood_pressure.read"
            "https://www.googleapis.com/auth/fitness.blood_pressure.write"
            "https://www.googleapis.com/auth/fitness.body.read"
            "https://www.googleapis.com/auth/fitness.body.write"
            "https://www.googleapis.com/auth/fitness.body_temperature.read"
            "https://www.googleapis.com/auth/fitness.body_temperature.write"
            "https://www.googleapis.com/auth/fitness.heart_rate.read"
            "https://www.googleapis.com/auth/fitness.heart_rate.write"
            "https://www.googleapis.com/auth/fitness.location.read"
            "https://www.googleapis.com/auth/fitness.location.write"
            "https://www.googleapis.com/auth/fitness.nutrition.read"
            "https://www.googleapis.com/auth/fitness.nutrition.write"
            "https://www.googleapis.com/auth/fitness.oxygen_saturation.read"
            "https://www.googleapis.com/auth/fitness.oxygen_saturation.write"
            "https://www.googleapis.com/auth/fitness.reproductive_health.read"
            "https://www.googleapis.com/auth/fitness.reproductive_health.write"
            "https://www.googleapis.com/auth/fitness.sleep.read"
            "https://www.googleapis.com/auth/fitness.sleep.write"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:datasetId :dataSourceId :userId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://fitness.googleapis.com/fitness/v1/users/"
     "{userId}/dataSources/{dataSourceId}/datasets/{datasetId}"
     #{:datasetId :dataSourceId :userId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn dataSources-datasets-delete$
  "https://developers.google.com/fit/rest/v1/get-startedapi/reference/rest/v1/users/dataSources/datasets/delete
  
  Required parameters: datasetId, userId, dataSourceId
  
  Optional parameters: none
  
  Performs an inclusive delete of all data points whose start and end times have any overlap with the time range specified by the dataset ID. For most data types, the entire data point will be deleted. For data types where the time span represents a consistent value (such as com.google.activity.segment), and a data point straddles either end point of the dataset, only the overlapping portion of the data point will be deleted."
  {:scopes ["https://www.googleapis.com/auth/fitness.activity.write"
            "https://www.googleapis.com/auth/fitness.blood_glucose.write"
            "https://www.googleapis.com/auth/fitness.blood_pressure.write"
            "https://www.googleapis.com/auth/fitness.body.write"
            "https://www.googleapis.com/auth/fitness.body_temperature.write"
            "https://www.googleapis.com/auth/fitness.heart_rate.write"
            "https://www.googleapis.com/auth/fitness.location.write"
            "https://www.googleapis.com/auth/fitness.nutrition.write"
            "https://www.googleapis.com/auth/fitness.oxygen_saturation.write"
            "https://www.googleapis.com/auth/fitness.reproductive_health.write"
            "https://www.googleapis.com/auth/fitness.sleep.write"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:datasetId :dataSourceId :userId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://fitness.googleapis.com/fitness/v1/users/"
     "{userId}/dataSources/{dataSourceId}/datasets/{datasetId}"
     #{:datasetId :dataSourceId :userId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn dataSources-datasets-patch$
  "https://developers.google.com/fit/rest/v1/get-startedapi/reference/rest/v1/users/dataSources/datasets/patch
  
  Required parameters: dataSourceId, userId, datasetId
  
  Optional parameters: none
  
  Body: 
  
  {:nextPageToken string,
   :maxEndTimeNs string,
   :minStartTimeNs string,
   :dataSourceId string,
   :point [{:endTimeNanos string,
            :rawTimestampNanos string,
            :startTimeNanos string,
            :modifiedTimeMillis string,
            :originDataSourceId string,
            :value [Value],
            :computationTimeMillis string,
            :dataTypeName string}]}
  
  Adds data points to a dataset. The dataset need not be previously created. All points within the given dataset will be returned with subsquent calls to retrieve this dataset. Data points can belong to more than one dataset. This method does not use patch semantics: the data points provided are merely inserted, with no existing data replaced."
  {:scopes ["https://www.googleapis.com/auth/fitness.activity.write"
            "https://www.googleapis.com/auth/fitness.blood_glucose.write"
            "https://www.googleapis.com/auth/fitness.blood_pressure.write"
            "https://www.googleapis.com/auth/fitness.body.write"
            "https://www.googleapis.com/auth/fitness.body_temperature.write"
            "https://www.googleapis.com/auth/fitness.heart_rate.write"
            "https://www.googleapis.com/auth/fitness.location.write"
            "https://www.googleapis.com/auth/fitness.nutrition.write"
            "https://www.googleapis.com/auth/fitness.oxygen_saturation.write"
            "https://www.googleapis.com/auth/fitness.reproductive_health.write"
            "https://www.googleapis.com/auth/fitness.sleep.write"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:datasetId :dataSourceId :userId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://fitness.googleapis.com/fitness/v1/users/"
     "{userId}/dataSources/{dataSourceId}/datasets/{datasetId}"
     #{:datasetId :dataSourceId :userId}
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

(defn sessions-update$
  "https://developers.google.com/fit/rest/v1/get-startedapi/reference/rest/v1/users/sessions/update
  
  Required parameters: userId, sessionId
  
  Optional parameters: none
  
  Body: 
  
  {:description string,
   :application {:detailsUrl string,
                 :name string,
                 :packageName string,
                 :version string},
   :name string,
   :endTimeMillis string,
   :activityType integer,
   :modifiedTimeMillis string,
   :id string,
   :startTimeMillis string,
   :activeTimeMillis string}
  
  Updates or insert a given session."
  {:scopes ["https://www.googleapis.com/auth/fitness.activity.write"
            "https://www.googleapis.com/auth/fitness.sleep.write"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:sessionId :userId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://fitness.googleapis.com/fitness/v1/users/"
     "{userId}/sessions/{sessionId}"
     #{:sessionId :userId}
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

(defn sessions-delete$
  "https://developers.google.com/fit/rest/v1/get-startedapi/reference/rest/v1/users/sessions/delete
  
  Required parameters: sessionId, userId
  
  Optional parameters: none
  
  Deletes a session specified by the given session ID."
  {:scopes ["https://www.googleapis.com/auth/fitness.activity.write"
            "https://www.googleapis.com/auth/fitness.sleep.write"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:sessionId :userId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://fitness.googleapis.com/fitness/v1/users/"
     "{userId}/sessions/{sessionId}"
     #{:sessionId :userId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn sessions-list$
  "https://developers.google.com/fit/rest/v1/get-startedapi/reference/rest/v1/users/sessions/list
  
  Required parameters: userId
  
  Optional parameters: pageToken, endTime, activityType, startTime, includeDeleted
  
  Lists sessions previously created."
  {:scopes ["https://www.googleapis.com/auth/fitness.activity.read"
            "https://www.googleapis.com/auth/fitness.activity.write"
            "https://www.googleapis.com/auth/fitness.blood_glucose.read"
            "https://www.googleapis.com/auth/fitness.blood_glucose.write"
            "https://www.googleapis.com/auth/fitness.blood_pressure.read"
            "https://www.googleapis.com/auth/fitness.blood_pressure.write"
            "https://www.googleapis.com/auth/fitness.body.read"
            "https://www.googleapis.com/auth/fitness.body.write"
            "https://www.googleapis.com/auth/fitness.body_temperature.read"
            "https://www.googleapis.com/auth/fitness.body_temperature.write"
            "https://www.googleapis.com/auth/fitness.heart_rate.read"
            "https://www.googleapis.com/auth/fitness.heart_rate.write"
            "https://www.googleapis.com/auth/fitness.location.read"
            "https://www.googleapis.com/auth/fitness.location.write"
            "https://www.googleapis.com/auth/fitness.nutrition.read"
            "https://www.googleapis.com/auth/fitness.nutrition.write"
            "https://www.googleapis.com/auth/fitness.oxygen_saturation.read"
            "https://www.googleapis.com/auth/fitness.oxygen_saturation.write"
            "https://www.googleapis.com/auth/fitness.reproductive_health.read"
            "https://www.googleapis.com/auth/fitness.reproductive_health.write"
            "https://www.googleapis.com/auth/fitness.sleep.read"
            "https://www.googleapis.com/auth/fitness.sleep.write"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:userId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://fitness.googleapis.com/fitness/v1/users/"
     "{userId}/sessions"
     #{:userId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
