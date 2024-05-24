(ns happygapi.drivelabels.labels
  "Drive Labels API: labels.
  An API for managing Drive Labels
  See: https://developers.google.com/drive/labelsdocs/reference/rest/v2/labels"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn disable$
  "https://developers.google.com/drive/labelsapi/reference/rest/v2/labels/disable
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:updateMask string,
   :writeControl {:requiredRevisionId string},
   :useAdminAccess boolean,
   :languageCode string,
   :disabledPolicy {:hideInSearch boolean, :showInApply boolean}}
  
  Disable a published Label. Disabling a Label will result in a new disabled published revision based on the current published revision. If there is a draft revision, a new disabled draft revision will be created based on the latest draft revision. Older draft revisions will be deleted. Once disabled, a label may be deleted with `DeleteLabel`."
  {:scopes ["https://www.googleapis.com/auth/drive.admin.labels"
            "https://www.googleapis.com/auth/drive.labels"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://drivelabels.googleapis.com/"
     "v2/{+name}:disable"
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

(defn get$
  "https://developers.google.com/drive/labelsapi/reference/rest/v2/labels/get
  
  Required parameters: name
  
  Optional parameters: view, languageCode, useAdminAccess
  
  Get a label by its resource name. Resource name may be any of: * `labels/{id}` - See `labels/{id}@latest` * `labels/{id}@latest` - Gets the latest revision of the label. * `labels/{id}@published` - Gets the current published revision of the label. * `labels/{id}@{revision_id}` - Gets the label at the specified revision ID."
  {:scopes ["https://www.googleapis.com/auth/drive.admin.labels"
            "https://www.googleapis.com/auth/drive.admin.labels.readonly"
            "https://www.googleapis.com/auth/drive.labels"
            "https://www.googleapis.com/auth/drive.labels.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://drivelabels.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn updatePermissions$
  "https://developers.google.com/drive/labelsapi/reference/rest/v2/labels/updatePermissions
  
  Required parameters: parent
  
  Optional parameters: useAdminAccess
  
  Body: 
  
  {:group string,
   :person string,
   :name string,
   :role string,
   :audience string,
   :email string}
  
  Updates a Label's permissions. If a permission for the indicated principal doesn't exist, a new Label Permission is created, otherwise the existing permission is updated. Permissions affect the Label resource as a whole, are not revisioned, and do not require publishing."
  {:scopes ["https://www.googleapis.com/auth/drive.admin.labels"
            "https://www.googleapis.com/auth/drive.labels"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://drivelabels.googleapis.com/"
     "v2/{+parent}/permissions"
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

(defn enable$
  "https://developers.google.com/drive/labelsapi/reference/rest/v2/labels/enable
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:writeControl {:requiredRevisionId string},
   :useAdminAccess boolean,
   :languageCode string}
  
  Enable a disabled Label and restore it to its published state. This will result in a new published revision based on the current disabled published revision. If there is an existing disabled draft revision, a new revision will be created based on that draft and will be enabled."
  {:scopes ["https://www.googleapis.com/auth/drive.admin.labels"
            "https://www.googleapis.com/auth/drive.labels"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://drivelabels.googleapis.com/"
     "v2/{+name}:enable"
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

(defn create$
  "https://developers.google.com/drive/labelsapi/reference/rest/v2/labels/create
  
  Required parameters: none
  
  Optional parameters: languageCode, useAdminAccess
  
  Body: 
  
  {:disabler {:person string},
   :properties {:title string, :description string},
   :appliedCapabilities {:canRemove boolean,
                         :canRead boolean,
                         :canApply boolean},
   :appliedLabelPolicy {:copyMode string},
   :creator {:person string},
   :publisher {:person string},
   :publishTime string,
   :revisionCreateTime string,
   :name string,
   :fields [{:disabler GoogleAppsDriveLabelsV2UserInfo,
             :properties GoogleAppsDriveLabelsV2FieldProperties,
             :appliedCapabilities GoogleAppsDriveLabelsV2FieldAppliedCapabilities,
             :dateOptions GoogleAppsDriveLabelsV2FieldDateOptions,
             :creator GoogleAppsDriveLabelsV2UserInfo,
             :publisher GoogleAppsDriveLabelsV2UserInfo,
             :integerOptions GoogleAppsDriveLabelsV2FieldIntegerOptions,
             :createTime string,
             :schemaCapabilities GoogleAppsDriveLabelsV2FieldSchemaCapabilities,
             :queryKey string,
             :lifecycle GoogleAppsDriveLabelsV2Lifecycle,
             :updateTime string,
             :disableTime string,
             :displayHints GoogleAppsDriveLabelsV2FieldDisplayHints,
             :id string,
             :userOptions GoogleAppsDriveLabelsV2FieldUserOptions,
             :updater GoogleAppsDriveLabelsV2UserInfo,
             :selectionOptions GoogleAppsDriveLabelsV2FieldSelectionOptions,
             :textOptions GoogleAppsDriveLabelsV2FieldTextOptions,
             :lockStatus GoogleAppsDriveLabelsV2LockStatus}],
   :createTime string,
   :revisionId string,
   :labelType string,
   :schemaCapabilities {:canEnable boolean,
                        :canDisable boolean,
                        :canDelete boolean,
                        :canUpdate boolean},
   :lifecycle {:disabledPolicy GoogleAppsDriveLabelsV2LifecycleDisabledPolicy,
               :state string,
               :hasUnpublishedChanges boolean},
   :customer string,
   :disableTime string,
   :displayHints {:disabled boolean,
                  :shownInApply boolean,
                  :priority string,
                  :hiddenInSearch boolean},
   :id string,
   :revisionCreator {:person string},
   :lockStatus {:locked boolean},
   :learnMoreUri string}
  
  Creates a new Label."
  {:scopes ["https://www.googleapis.com/auth/drive.admin.labels"
            "https://www.googleapis.com/auth/drive.labels"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://drivelabels.googleapis.com/"
     "v2/labels"
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
  "https://developers.google.com/drive/labelsapi/reference/rest/v2/labels/delete
  
  Required parameters: name
  
  Optional parameters: useAdminAccess, writeControl.requiredRevisionId
  
  Permanently deletes a Label and related metadata on Drive Items. Once deleted, the Label and related Drive item metadata will be deleted. Only draft Labels, and disabled Labels may be deleted."
  {:scopes ["https://www.googleapis.com/auth/drive.admin.labels"
            "https://www.googleapis.com/auth/drive.labels"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://drivelabels.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/drive/labelsapi/reference/rest/v2/labels/list
  
  Required parameters: none
  
  Optional parameters: pageToken, minimumRole, useAdminAccess, customer, view, pageSize, languageCode, publishedOnly
  
  List labels."
  {:scopes ["https://www.googleapis.com/auth/drive.admin.labels"
            "https://www.googleapis.com/auth/drive.admin.labels.readonly"
            "https://www.googleapis.com/auth/drive.labels"
            "https://www.googleapis.com/auth/drive.labels.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://drivelabels.googleapis.com/"
     "v2/labels"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn updateLabelCopyMode$
  "https://developers.google.com/drive/labelsapi/reference/rest/v2/labels/updateLabelCopyMode
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:view string,
   :useAdminAccess boolean,
   :copyMode string,
   :languageCode string}
  
  Updates a Label's `CopyMode`. Changes to this policy are not revisioned, do not require publishing, and take effect immediately."
  {:scopes ["https://www.googleapis.com/auth/drive.admin.labels"
            "https://www.googleapis.com/auth/drive.labels"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://drivelabels.googleapis.com/"
     "v2/{+name}:updateLabelCopyMode"
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

(defn delta$
  "https://developers.google.com/drive/labelsapi/reference/rest/v2/labels/delta
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:writeControl {:requiredRevisionId string},
   :view string,
   :requests [{:disableField GoogleAppsDriveLabelsV2DeltaUpdateLabelRequestDisableFieldRequest,
               :deleteSelectionChoice GoogleAppsDriveLabelsV2DeltaUpdateLabelRequestDeleteSelectionChoiceRequest,
               :enableSelectionChoice GoogleAppsDriveLabelsV2DeltaUpdateLabelRequestEnableSelectionChoiceRequest,
               :disableSelectionChoice GoogleAppsDriveLabelsV2DeltaUpdateLabelRequestDisableSelectionChoiceRequest,
               :createSelectionChoice GoogleAppsDriveLabelsV2DeltaUpdateLabelRequestCreateSelectionChoiceRequest,
               :createField GoogleAppsDriveLabelsV2DeltaUpdateLabelRequestCreateFieldRequest,
               :updateSelectionChoiceProperties GoogleAppsDriveLabelsV2DeltaUpdateLabelRequestUpdateSelectionChoicePropertiesRequest,
               :enableField GoogleAppsDriveLabelsV2DeltaUpdateLabelRequestEnableFieldRequest,
               :updateLabel GoogleAppsDriveLabelsV2DeltaUpdateLabelRequestUpdateLabelPropertiesRequest,
               :updateField GoogleAppsDriveLabelsV2DeltaUpdateLabelRequestUpdateFieldPropertiesRequest,
               :updateFieldType GoogleAppsDriveLabelsV2DeltaUpdateLabelRequestUpdateFieldTypeRequest,
               :deleteField GoogleAppsDriveLabelsV2DeltaUpdateLabelRequestDeleteFieldRequest}],
   :useAdminAccess boolean,
   :languageCode string}
  
  Updates a single Label by applying a set of update requests resulting in a new draft revision. The batch update is all-or-nothing: If any of the update requests are invalid, no changes are applied. The resulting draft revision must be published before the changes may be used with Drive Items."
  {:scopes ["https://www.googleapis.com/auth/drive.admin.labels"
            "https://www.googleapis.com/auth/drive.labels"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://drivelabels.googleapis.com/"
     "v2/{+name}:delta"
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

(defn publish$
  "https://developers.google.com/drive/labelsapi/reference/rest/v2/labels/publish
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:languageCode string,
   :writeControl {:requiredRevisionId string},
   :useAdminAccess boolean}
  
  Publish all draft changes to the Label. Once published, the Label may not return to its draft state. See `google.apps.drive.labels.v2.Lifecycle` for more information. Publishing a Label will result in a new published revision. All previous draft revisions will be deleted. Previous published revisions will be kept but are subject to automated deletion as needed. Once published, some changes are no longer permitted. Generally, any change that would invalidate or cause new restrictions on existing metadata related to the Label will be rejected. For example, the following changes to a Label will be rejected after the Label is published: * The label cannot be directly deleted. It must be disabled first, then deleted. * Field.FieldType cannot be changed. * Changes to Field validation options cannot reject something that was previously accepted. * Reducing the max entries."
  {:scopes ["https://www.googleapis.com/auth/drive.admin.labels"
            "https://www.googleapis.com/auth/drive.labels"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://drivelabels.googleapis.com/"
     "v2/{+name}:publish"
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

(defn permissions-delete$
  "https://developers.google.com/drive/labelsapi/reference/rest/v2/labels/permissions/delete
  
  Required parameters: name
  
  Optional parameters: useAdminAccess
  
  Deletes a Label's permission. Permissions affect the Label resource as a whole, are not revisioned, and do not require publishing."
  {:scopes ["https://www.googleapis.com/auth/drive.admin.labels"
            "https://www.googleapis.com/auth/drive.labels"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://drivelabels.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn permissions-batchDelete$
  "https://developers.google.com/drive/labelsapi/reference/rest/v2/labels/permissions/batchDelete
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:requests [{:useAdminAccess boolean, :name string}],
   :useAdminAccess boolean}
  
  Deletes Label permissions. Permissions affect the Label resource as a whole, are not revisioned, and do not require publishing."
  {:scopes ["https://www.googleapis.com/auth/drive.admin.labels"
            "https://www.googleapis.com/auth/drive.labels"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://drivelabels.googleapis.com/"
     "v2/{+parent}/permissions:batchDelete"
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

(defn permissions-list$
  "https://developers.google.com/drive/labelsapi/reference/rest/v2/labels/permissions/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, useAdminAccess, pageToken
  
  Lists a Label's permissions."
  {:scopes ["https://www.googleapis.com/auth/drive.admin.labels"
            "https://www.googleapis.com/auth/drive.admin.labels.readonly"
            "https://www.googleapis.com/auth/drive.labels"
            "https://www.googleapis.com/auth/drive.labels.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://drivelabels.googleapis.com/"
     "v2/{+parent}/permissions"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn permissions-batchUpdate$
  "https://developers.google.com/drive/labelsapi/reference/rest/v2/labels/permissions/batchUpdate
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:useAdminAccess boolean,
   :requests [{:useAdminAccess boolean,
               :parent string,
               :labelPermission GoogleAppsDriveLabelsV2LabelPermission}]}
  
  Updates Label permissions. If a permission for the indicated principal doesn't exist, a new Label Permission is created, otherwise the existing permission is updated. Permissions affect the Label resource as a whole, are not revisioned, and do not require publishing."
  {:scopes ["https://www.googleapis.com/auth/drive.admin.labels"
            "https://www.googleapis.com/auth/drive.labels"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://drivelabels.googleapis.com/"
     "v2/{+parent}/permissions:batchUpdate"
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

(defn permissions-create$
  "https://developers.google.com/drive/labelsapi/reference/rest/v2/labels/permissions/create
  
  Required parameters: parent
  
  Optional parameters: useAdminAccess
  
  Body: 
  
  {:group string,
   :person string,
   :name string,
   :role string,
   :audience string,
   :email string}
  
  Updates a Label's permissions. If a permission for the indicated principal doesn't exist, a new Label Permission is created, otherwise the existing permission is updated. Permissions affect the Label resource as a whole, are not revisioned, and do not require publishing."
  {:scopes ["https://www.googleapis.com/auth/drive.admin.labels"
            "https://www.googleapis.com/auth/drive.labels"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://drivelabels.googleapis.com/"
     "v2/{+parent}/permissions"
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

(defn locks-list$
  "https://developers.google.com/drive/labelsapi/reference/rest/v2/labels/locks/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists the LabelLocks on a Label."
  {:scopes ["https://www.googleapis.com/auth/drive.admin.labels"
            "https://www.googleapis.com/auth/drive.admin.labels.readonly"
            "https://www.googleapis.com/auth/drive.labels"
            "https://www.googleapis.com/auth/drive.labels.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://drivelabels.googleapis.com/"
     "v2/{+parent}/locks"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn revisions-updatePermissions$
  "https://developers.google.com/drive/labelsapi/reference/rest/v2/labels/revisions/updatePermissions
  
  Required parameters: parent
  
  Optional parameters: useAdminAccess
  
  Body: 
  
  {:group string,
   :person string,
   :name string,
   :role string,
   :audience string,
   :email string}
  
  Updates a Label's permissions. If a permission for the indicated principal doesn't exist, a new Label Permission is created, otherwise the existing permission is updated. Permissions affect the Label resource as a whole, are not revisioned, and do not require publishing."
  {:scopes ["https://www.googleapis.com/auth/drive.admin.labels"
            "https://www.googleapis.com/auth/drive.labels"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://drivelabels.googleapis.com/"
     "v2/{+parent}/permissions"
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

(defn revisions-locks-list$
  "https://developers.google.com/drive/labelsapi/reference/rest/v2/labels/revisions/locks/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Lists the LabelLocks on a Label."
  {:scopes ["https://www.googleapis.com/auth/drive.admin.labels"
            "https://www.googleapis.com/auth/drive.admin.labels.readonly"
            "https://www.googleapis.com/auth/drive.labels"
            "https://www.googleapis.com/auth/drive.labels.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://drivelabels.googleapis.com/"
     "v2/{+parent}/locks"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn revisions-permissions-batchDelete$
  "https://developers.google.com/drive/labelsapi/reference/rest/v2/labels/revisions/permissions/batchDelete
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:requests [{:useAdminAccess boolean, :name string}],
   :useAdminAccess boolean}
  
  Deletes Label permissions. Permissions affect the Label resource as a whole, are not revisioned, and do not require publishing."
  {:scopes ["https://www.googleapis.com/auth/drive.admin.labels"
            "https://www.googleapis.com/auth/drive.labels"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://drivelabels.googleapis.com/"
     "v2/{+parent}/permissions:batchDelete"
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

(defn revisions-permissions-batchUpdate$
  "https://developers.google.com/drive/labelsapi/reference/rest/v2/labels/revisions/permissions/batchUpdate
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:useAdminAccess boolean,
   :requests [{:useAdminAccess boolean,
               :parent string,
               :labelPermission GoogleAppsDriveLabelsV2LabelPermission}]}
  
  Updates Label permissions. If a permission for the indicated principal doesn't exist, a new Label Permission is created, otherwise the existing permission is updated. Permissions affect the Label resource as a whole, are not revisioned, and do not require publishing."
  {:scopes ["https://www.googleapis.com/auth/drive.admin.labels"
            "https://www.googleapis.com/auth/drive.labels"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://drivelabels.googleapis.com/"
     "v2/{+parent}/permissions:batchUpdate"
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

(defn revisions-permissions-list$
  "https://developers.google.com/drive/labelsapi/reference/rest/v2/labels/revisions/permissions/list
  
  Required parameters: parent
  
  Optional parameters: useAdminAccess, pageSize, pageToken
  
  Lists a Label's permissions."
  {:scopes ["https://www.googleapis.com/auth/drive.admin.labels"
            "https://www.googleapis.com/auth/drive.admin.labels.readonly"
            "https://www.googleapis.com/auth/drive.labels"
            "https://www.googleapis.com/auth/drive.labels.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://drivelabels.googleapis.com/"
     "v2/{+parent}/permissions"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn revisions-permissions-create$
  "https://developers.google.com/drive/labelsapi/reference/rest/v2/labels/revisions/permissions/create
  
  Required parameters: parent
  
  Optional parameters: useAdminAccess
  
  Body: 
  
  {:group string,
   :person string,
   :name string,
   :role string,
   :audience string,
   :email string}
  
  Updates a Label's permissions. If a permission for the indicated principal doesn't exist, a new Label Permission is created, otherwise the existing permission is updated. Permissions affect the Label resource as a whole, are not revisioned, and do not require publishing."
  {:scopes ["https://www.googleapis.com/auth/drive.admin.labels"
            "https://www.googleapis.com/auth/drive.labels"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://drivelabels.googleapis.com/"
     "v2/{+parent}/permissions"
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

(defn revisions-permissions-delete$
  "https://developers.google.com/drive/labelsapi/reference/rest/v2/labels/revisions/permissions/delete
  
  Required parameters: name
  
  Optional parameters: useAdminAccess
  
  Deletes a Label's permission. Permissions affect the Label resource as a whole, are not revisioned, and do not require publishing."
  {:scopes ["https://www.googleapis.com/auth/drive.admin.labels"
            "https://www.googleapis.com/auth/drive.labels"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://drivelabels.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
