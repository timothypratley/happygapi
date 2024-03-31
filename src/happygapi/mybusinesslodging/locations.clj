(ns happygapi.mybusinesslodging.locations
  "My Business Lodging API: locations.
  The My Business Lodging API enables managing lodging business information on Google. Note - If you have a quota of 0 after enabling the API, please request for GBP API access.
  See: https://developers.google.com/my-business/api/reference/rest/v1/locations"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn getLodging$
  "https://developers.google.com/my-business/api/reference/rest/v1/locations/getLodging
  
  Required parameters: name
  
  Optional parameters: readMask
  
  Returns the Lodging of a specific location."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://mybusinesslodging.googleapis.com/"
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

(defn updateLodging$
  "https://developers.google.com/my-business/api/reference/rest/v1/locations/updateLodging
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:someUnits {:tier string,
               :bungalowOrVillaException string,
               :privateHome boolean,
               :maxAdultOccupantsCountException string,
               :totalLivingAreas LivingArea,
               :maxChildOccupantsCountException string,
               :executiveFloorException string,
               :suiteException string,
               :bungalowOrVilla boolean,
               :maxAdultOccupantsCount integer,
               :maxChildOccupantsCount integer,
               :tierException string,
               :connectingUnitAvailable boolean,
               :connectingUnitAvailableException string,
               :maxOccupantsCountException string,
               :executiveFloor boolean,
               :privateHomeException string,
               :suite boolean,
               :maxOccupantsCount integer,
               :views ViewsFromUnit},
   :allUnits {:tier string,
              :bungalowOrVillaException string,
              :privateHome boolean,
              :maxAdultOccupantsCountException string,
              :totalLivingAreas LivingArea,
              :maxChildOccupantsCountException string,
              :executiveFloorException string,
              :suiteException string,
              :bungalowOrVilla boolean,
              :maxAdultOccupantsCount integer,
              :maxChildOccupantsCount integer,
              :tierException string,
              :connectingUnitAvailable boolean,
              :connectingUnitAvailableException string,
              :maxOccupantsCountException string,
              :executiveFloor boolean,
              :privateHomeException string,
              :suite boolean,
              :maxOccupantsCount integer,
              :views ViewsFromUnit},
   :healthAndSafety {:enhancedCleaning EnhancedCleaning,
                     :increasedFoodSafety IncreasedFoodSafety,
                     :minimizedContact MinimizedContact,
                     :personalProtection PersonalProtection,
                     :physicalDistancing PhysicalDistancing},
   :transportation {:privateCarService boolean,
                    :transferException string,
                    :transfer boolean,
                    :localShuttleException string,
                    :carRentalOnPropertyException string,
                    :airportShuttle boolean,
                    :airportShuttleException string,
                    :freePrivateCarServiceException string,
                    :privateCarServiceException string,
                    :localShuttle boolean,
                    :freeAirportShuttle boolean,
                    :carRentalOnProperty boolean,
                    :freePrivateCarService boolean,
                    :freeAirportShuttleException string},
   :accessibility {:mobilityAccessible boolean,
                   :mobilityAccessibleException string,
                   :mobilityAccessibleParking boolean,
                   :mobilityAccessibleParkingException string,
                   :mobilityAccessibleElevator boolean,
                   :mobilityAccessibleElevatorException string,
                   :mobilityAccessiblePool boolean,
                   :mobilityAccessiblePoolException string},
   :policies {:checkinTimeException string,
              :allInclusiveAvailable boolean,
              :kidsStayFree boolean,
              :paymentOptions PaymentOptions,
              :checkoutTimeException string,
              :checkinTime TimeOfDay,
              :checkoutTime TimeOfDay,
              :maxKidsStayFreeCountException string,
              :allInclusiveOnlyException string,
              :smokeFreePropertyException string,
              :allInclusiveOnly boolean,
              :allInclusiveAvailableException string,
              :smokeFreeProperty boolean,
              :kidsStayFreeException string,
              :maxChildAge integer,
              :maxChildAgeException string,
              :maxKidsStayFreeCount integer},
   :property {:builtYear integer,
              :builtYearException string,
              :lastRenovatedYear integer,
              :lastRenovatedYearException string,
              :roomsCount integer,
              :roomsCountException string,
              :floorsCount integer,
              :floorsCountException string},
   :name string,
   :wellness {:freeFitnessCenterException string,
              :saunaException string,
              :sauna boolean,
              :fitnessCenterException string,
              :salonException string,
              :salon boolean,
              :doctorOnCallException string,
              :massage boolean,
              :massageException string,
              :freeWeightsException string,
              :spaException string,
              :spa boolean,
              :weightMachine boolean,
              :doctorOnCall boolean,
              :ellipticalMachine boolean,
              :freeWeights boolean,
              :treadmillException string,
              :weightMachineException string,
              :fitnessCenter boolean,
              :ellipticalMachineException string,
              :treadmill boolean,
              :freeFitnessCenter boolean},
   :commonLivingArea {:layout LivingAreaLayout,
                      :features LivingAreaFeatures,
                      :eating LivingAreaEating,
                      :sleeping LivingAreaSleeping,
                      :accessibility LivingAreaAccessibility},
   :connectivity {:wifiAvailable boolean,
                  :wifiAvailableException string,
                  :freeWifi boolean,
                  :freeWifiException string,
                  :publicAreaWifiAvailable boolean,
                  :publicAreaWifiAvailableException string,
                  :publicInternetTerminal boolean,
                  :publicInternetTerminalException string},
   :pools {:poolsCount integer,
           :adultPool boolean,
           :lazyRiver boolean,
           :pool boolean,
           :wavePoolException string,
           :outdoorPoolsCount integer,
           :wadingPoolException string,
           :poolException string,
           :wadingPool boolean,
           :hotTub boolean,
           :outdoorPool boolean,
           :waterPark boolean,
           :indoorPoolsCount integer,
           :indoorPoolException string,
           :waterParkException string,
           :wavePool boolean,
           :indoorPool boolean,
           :lifeguardException string,
           :lazyRiverException string,
           :poolsCountException string,
           :lifeguard boolean,
           :outdoorPoolsCountException string,
           :indoorPoolsCountException string,
           :outdoorPoolException string,
           :waterslide boolean,
           :waterslideException string,
           :hotTubException string,
           :adultPoolException string},
   :pets {:petsAllowed boolean,
          :petsAllowedException string,
          :petsAllowedFree boolean,
          :petsAllowedFreeException string,
          :dogsAllowed boolean,
          :dogsAllowedException string,
          :catsAllowed boolean,
          :catsAllowedException string},
   :parking {:selfParkingAvailableException string,
             :freeSelfParking boolean,
             :freeSelfParkingException string,
             :freeParking boolean,
             :parkingAvailable boolean,
             :freeValetParking boolean,
             :parkingAvailableException string,
             :freeValetParkingException string,
             :valetParkingAvailableException string,
             :freeParkingException string,
             :electricCarChargingStations boolean,
             :valetParkingAvailable boolean,
             :selfParkingAvailable boolean,
             :electricCarChargingStationsException string},
   :housekeeping {:housekeepingAvailable boolean,
                  :housekeepingAvailableException string,
                  :dailyHousekeeping boolean,
                  :dailyHousekeepingException string,
                  :turndownService boolean,
                  :turndownServiceException string},
   :foodAndDrink {:breakfastAvailable boolean,
                  :restaurantException string,
                  :roomService boolean,
                  :buffet boolean,
                  :roomServiceException string,
                  :breakfastAvailableException string,
                  :bar boolean,
                  :breakfastBuffetException string,
                  :tableServiceException string,
                  :restaurant boolean,
                  :vendingMachine boolean,
                  :breakfastBuffet boolean,
                  :freeBreakfastException string,
                  :vendingMachineException string,
                  :buffetException string,
                  :dinnerBuffet boolean,
                  :freeBreakfast boolean,
                  :restaurantsCountException string,
                  :restaurantsCount integer,
                  :dinnerBuffetException string,
                  :tableService boolean,
                  :twentyFourHourRoomServiceException string,
                  :barException string,
                  :twentyFourHourRoomService boolean},
   :sustainability {:energyEfficiency EnergyEfficiency,
                    :waterConservation WaterConservation,
                    :wasteReduction WasteReduction,
                    :sustainableSourcing SustainableSourcing,
                    :sustainabilityCertifications SustainabilityCertifications},
   :guestUnits [{:codes [string],
                 :label string,
                 :features GuestUnitFeatures}],
   :business {:businessCenter boolean,
              :businessCenterException string,
              :meetingRooms boolean,
              :meetingRoomsException string,
              :meetingRoomsCount integer,
              :meetingRoomsCountException string},
   :activities {:watercraftRentalException string,
                :beachAccessException string,
                :golfException string,
                :watercraftRental boolean,
                :tennis boolean,
                :scuba boolean,
                :beachFrontException string,
                :gameRoomException string,
                :nightclubException string,
                :tennisException string,
                :waterSkiingException string,
                :casino boolean,
                :nightclub boolean,
                :privateBeachException string,
                :casinoException string,
                :boutiqueStores boolean,
                :beachAccess boolean,
                :freeBicycleRentalException string,
                :bicycleRental boolean,
                :privateBeach boolean,
                :freeBicycleRental boolean,
                :beachFront boolean,
                :gameRoom boolean,
                :boutiqueStoresException string,
                :freeWatercraftRental boolean,
                :freeWatercraftRentalException string,
                :snorkeling boolean,
                :horsebackRidingException string,
                :snorkelingException string,
                :bicycleRentalException string,
                :golf boolean,
                :waterSkiing boolean,
                :scubaException string,
                :horsebackRiding boolean},
   :metadata {:updateTime string},
   :services {:wakeUpCalls boolean,
              :fullServiceLaundry boolean,
              :convenienceStore boolean,
              :fullServiceLaundryException string,
              :socialHour boolean,
              :elevatorException string,
              :twentyFourHourFrontDesk boolean,
              :languagesSpoken [LanguageSpoken],
              :baggageStorage boolean,
              :twentyFourHourFrontDeskException string,
              :currencyExchangeException string,
              :giftShopException string,
              :wakeUpCallsException string,
              :frontDeskException string,
              :convenienceStoreException string,
              :baggageStorageException string,
              :selfServiceLaundryException string,
              :concierge boolean,
              :selfServiceLaundry boolean,
              :conciergeException string,
              :elevator boolean,
              :frontDesk boolean,
              :giftShop boolean,
              :currencyExchange boolean,
              :socialHourException string},
   :families {:babysitting boolean,
              :babysittingException string,
              :kidsActivities boolean,
              :kidsActivitiesException string,
              :kidsClub boolean,
              :kidsClubException string,
              :kidsFriendly boolean,
              :kidsFriendlyException string}}
  
  Updates the Lodging of a specific location."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://mybusinesslodging.googleapis.com/"
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

(defn lodging-getGoogleUpdated$
  "https://developers.google.com/my-business/api/reference/rest/v1/locations/lodging/getGoogleUpdated
  
  Required parameters: name
  
  Optional parameters: readMask
  
  Returns the Google updated Lodging of a specific location."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://mybusinesslodging.googleapis.com/"
     "v1/{+name}:getGoogleUpdated"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
