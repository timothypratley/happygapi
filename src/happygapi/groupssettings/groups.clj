(ns happygapi.groupssettings.groups
  "Groups Settings API: groups.
  Manages permission levels and related settings of a group.
  See: https://developers.google.com/google-apps/groups-settings/get_startedapi/reference/rest/v1/groups"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/google-apps/groups-settings/get_startedapi/reference/rest/v1/groups/get
  
  Required parameters: groupUniqueId
  
  Optional parameters: none
  Gets one resource by id."
  {:scopes ["https://www.googleapis.com/auth/apps.groups.settings"]}
  [auth args]
  {:pre [(util/has-keys? args #{:groupUniqueId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/groups/v1/groups/"
     "{groupUniqueId}"
     #{:groupUniqueId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://developers.google.com/google-apps/groups-settings/get_startedapi/reference/rest/v1/groups/patch
  
  Required parameters: groupUniqueId
  
  Optional parameters: none
  
  Body: 
  
  {:description string,
   :sendMessageDenyNotification string,
   :whoCanModifyMembers string,
   :whoCanViewMembership string,
   :whoCanViewGroup string,
   :whoCanMoveTopicsOut string,
   :whoCanMarkDuplicate string,
   :email string,
   :whoCanModerateMembers string,
   :whoCanInvite string,
   :whoCanDeleteAnyPost string,
   :whoCanJoin string,
   :whoCanMoveTopicsIn string,
   :allowWebPosting string,
   :maxMessageBytes integer,
   :whoCanMarkFavoriteReplyOnOwnTopic string,
   :whoCanBanUsers string,
   :whoCanPostMessage string,
   :favoriteRepliesOnTop string,
   :whoCanAssistContent string,
   :whoCanUnassignTopic string,
   :name string,
   :whoCanMarkNoResponseNeeded string,
   :allowExternalMembers string,
   :defaultMessageDenyNotificationText string,
   :whoCanApproveMembers string,
   :isArchived string,
   :whoCanApproveMessages string,
   :includeCustomFooter string,
   :whoCanHideAbuse string,
   :whoCanContactOwner string,
   :spamModerationLevel string,
   :customFooterText string,
   :whoCanUnmarkFavoriteReplyOnAnyTopic string,
   :whoCanModifyTagsAndCategories string,
   :whoCanMarkFavoriteReplyOnAnyTopic string,
   :whoCanAdd string,
   :whoCanMakeTopicsSticky string,
   :whoCanTakeTopics string,
   :primaryLanguage string,
   :whoCanPostAnnouncements string,
   :whoCanAssignTopics string,
   :whoCanDiscoverGroup string,
   :replyTo string,
   :whoCanLockTopics string,
   :kind string,
   :whoCanDeleteTopics string,
   :whoCanEnterFreeFormTags string,
   :messageModerationLevel string,
   :includeInGlobalAddressList string,
   :whoCanModerateContent string,
   :archiveOnly string,
   :messageDisplayFont string,
   :customRolesEnabledForSettingsToBeMerged string,
   :whoCanAddReferences string,
   :customReplyTo string,
   :whoCanLeaveGroup string,
   :allowGoogleCommunication string,
   :enableCollaborativeInbox string,
   :showInGroupDirectory string,
   :membersCanPostAsTheGroup string}
  
  Updates an existing resource. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/apps.groups.settings"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:groupUniqueId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/groups/v1/groups/"
     "{groupUniqueId}"
     #{:groupUniqueId}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://developers.google.com/google-apps/groups-settings/get_startedapi/reference/rest/v1/groups/update
  
  Required parameters: groupUniqueId
  
  Optional parameters: none
  
  Body: 
  
  {:description string,
   :sendMessageDenyNotification string,
   :whoCanModifyMembers string,
   :whoCanViewMembership string,
   :whoCanViewGroup string,
   :whoCanMoveTopicsOut string,
   :whoCanMarkDuplicate string,
   :email string,
   :whoCanModerateMembers string,
   :whoCanInvite string,
   :whoCanDeleteAnyPost string,
   :whoCanJoin string,
   :whoCanMoveTopicsIn string,
   :allowWebPosting string,
   :maxMessageBytes integer,
   :whoCanMarkFavoriteReplyOnOwnTopic string,
   :whoCanBanUsers string,
   :whoCanPostMessage string,
   :favoriteRepliesOnTop string,
   :whoCanAssistContent string,
   :whoCanUnassignTopic string,
   :name string,
   :whoCanMarkNoResponseNeeded string,
   :allowExternalMembers string,
   :defaultMessageDenyNotificationText string,
   :whoCanApproveMembers string,
   :isArchived string,
   :whoCanApproveMessages string,
   :includeCustomFooter string,
   :whoCanHideAbuse string,
   :whoCanContactOwner string,
   :spamModerationLevel string,
   :customFooterText string,
   :whoCanUnmarkFavoriteReplyOnAnyTopic string,
   :whoCanModifyTagsAndCategories string,
   :whoCanMarkFavoriteReplyOnAnyTopic string,
   :whoCanAdd string,
   :whoCanMakeTopicsSticky string,
   :whoCanTakeTopics string,
   :primaryLanguage string,
   :whoCanPostAnnouncements string,
   :whoCanAssignTopics string,
   :whoCanDiscoverGroup string,
   :replyTo string,
   :whoCanLockTopics string,
   :kind string,
   :whoCanDeleteTopics string,
   :whoCanEnterFreeFormTags string,
   :messageModerationLevel string,
   :includeInGlobalAddressList string,
   :whoCanModerateContent string,
   :archiveOnly string,
   :messageDisplayFont string,
   :customRolesEnabledForSettingsToBeMerged string,
   :whoCanAddReferences string,
   :customReplyTo string,
   :whoCanLeaveGroup string,
   :allowGoogleCommunication string,
   :enableCollaborativeInbox string,
   :showInGroupDirectory string,
   :membersCanPostAsTheGroup string}
  
  Updates an existing resource."
  {:scopes ["https://www.googleapis.com/auth/apps.groups.settings"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:groupUniqueId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/groups/v1/groups/"
     "{groupUniqueId}"
     #{:groupUniqueId}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
