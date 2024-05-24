(ns happygapi.walletobjects.media
  "Google Wallet API: media.
  API for issuers to save and manage Google Wallet Objects.
  See: https://developers.google.com/pay/passesdocs/reference/rest/v1/media"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn download$
  "https://developers.google.com/pay/passesapi/reference/rest/v1/media/download
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Downloads rotating barcode values for the transit object referenced by the given object ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/transitObject/{resourceId}/downloadRotatingBarcodeValues"
     #{:resourceId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn upload$
  "https://developers.google.com/pay/passesapi/reference/rest/v1/media/upload
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Body: 
  
  {:blob {:path string,
          :sha256Hash string,
          :algorithm string,
          :hash string,
          :contentTypeInfo ContentTypeInfo,
          :diffChecksumsResponse DiffChecksumsResponse,
          :objectId ObjectId,
          :crc32cHash integer,
          :isPotentialRetry boolean,
          :diffVersionResponse DiffVersionResponse,
          :blobRef string,
          :bigstoreObjectRef string,
          :cosmoBinaryReference string,
          :md5Hash string,
          :token string,
          :filename string,
          :diffUploadResponse DiffUploadResponse,
          :sha1Hash string,
          :diffDownloadResponse DiffDownloadResponse,
          :compositeMedia [CompositeMedia],
          :referenceType string,
          :length string,
          :downloadParameters DownloadParameters,
          :blobstore2Info Blobstore2Info,
          :hashVerified boolean,
          :contentType string,
          :diffUploadRequest DiffUploadRequest,
          :timestamp string,
          :inline string,
          :mediaId string},
   :mediaRequestInfo {:currentBytes string,
                      :notificationType string,
                      :requestReceivedParamsServingInfo string,
                      :totalBytes string,
                      :requestId string,
                      :diffObjectVersion string,
                      :finalStatus integer,
                      :customData string,
                      :totalBytesIsEstimated boolean}}
  
  Uploads rotating barcode values for the transit object referenced by the given object ID. Note the max upload size is specified in google3/production/config/cdd/apps-upload/customers/payments-consumer-passes/config.gcl and enforced by Scotty."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/transitObject/{resourceId}/uploadRotatingBarcodeValues"
     #{:resourceId}
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
