package foodmine.domain

/**
  * Represents Amazon food review row
  */

case class Review (id: Int, productId: String, userId: String, profileName: String, hNom: Int, hDenom: Int, score: Int, time: Long, summary: String, text: String)
