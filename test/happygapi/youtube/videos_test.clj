(ns happygapi.youtube.videos-test
  (:require [clojure.string :as str]
            [clojure.test :refer :all]
            [happygapi.youtube.videos :as videos]
            [happygapi.youtube.channels :as channels]
            [happygapi.youtube.playlistItems :as playlistItems]
            [happy.oauth2-credentials :as credentials]))

(deftest get$-test
  (credentials/init!)
  (testing "Youtube API calls"
    (let [channels (channels/list$ (credentials/auth!)
                                   {:part        "contentDetails,statistics"
                                    :forUsername "ClojureTV"})
          channel-id (-> channels :items first :id)
          _ (prn channel-id channels)
          uploads-playlist-id (-> channels :items first :contentDetails :relatedPlaylists :uploads)
          playlist (playlistItems/list$ (credentials/auth!)
                                        {:part       "contentDetails,id"
                                         :playlistId uploads-playlist-id
                                         :maxResults 50})
          _ (prn playlist)
          video-ids (->> playlist :items (map (comp :videoId :contentDetails)))
          videos (videos/list$ (credentials/auth!)
                               {:part "snippet,contentDetails,statistics"
                                :id   (str/join "," video-ids)})]
      (is (= 50 (count (-> videos :items)))))))
