package com.zz.ady.dal.monoid

import com.zz.ady.idl.StatsA

trait StatsADimensional extends Dimensional[StatsA] {

  override def dimension(a: StatsA): StatsA =
    StatsA(
        ts = a.ts
      , placementType = a.placementType
      , validType = a.validType
      , sellerCode = a.sellerCode
      , sellerTradingType = a.sellerTradingType
      , buyerTradingType = a.buyerTradingType
      , sellerDealType = a.sellerDealType
      , buyerDealType = a.buyerDealType
      , osType = a.osType
      , dropType = a.dropType
      , interceptionType = a.interceptionType
      , dspId = a.dspId
      , dspAppId = a.dspAppId
      , dspAppPlacementId = a.dspAppPlacementId
      , pubId = a.pubId
      , pubAppId = a.pubAppId
      , pubAppPlacementId = a.pubAppPlacementId
    )

}
