package ods.vm.gatling.base

import io.gatling.core.Predef._
import io.gatling.http.Predef._

/**
  * Created by Victoria on 03.04.2019.
  */
object ActionsCart {

  val getProductFromCart = http("Get product from cart").
    get(BaseUrl.cart_service + "/api/cart/get_items").
    check(status.is(200))

  val checkout = http("Checkout").
    get(BaseUrl.cart_service + "/api/cart/checkout").
    check(status.is(200))
}
