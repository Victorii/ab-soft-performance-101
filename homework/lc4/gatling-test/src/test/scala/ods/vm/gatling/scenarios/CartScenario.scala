package ods.vm.gatling.scenarios

import io.gatling.http.Predef.{Cookie, addCookie}
import ods.vm.gatling.base.{ActionsCart, ActionsProduct, BaseUrl, GenerateToken}
import io.gatling.core.Predef.{rampUsers, scenario}
import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import ods.vm.gatling.base.{ActionsProduct, BaseUrl, GenerateToken}

/**
  * Created by Victoria on 06.04.2019.
  */
object CartScenario {

  /**
    * Add Product to cart
    * */
  val addProductToCart: ScenarioBuilder = scenario("Add Product to cart")
    .exec(ProductScenario.viewProductDetails)
    .exec(addCookie(Cookie("token", "${token}").withDomain(BaseUrl.domain)))
    .exec(GenerateToken.checkToken)
    .exec(ActionsProduct.addProductToCart)


  /**
    * View Cart
    * */
  val viewCart: ScenarioBuilder = scenario("View Cart")
    .exec(addProductToCart)
    .exec(addCookie(Cookie("token", "${token}").withDomain(BaseUrl.domain)))
    .exec(GenerateToken.checkToken)
    .exec(ActionsCart.getProductFromCart)

  /**
    * Checkout
    * */
  val checkout: ScenarioBuilder  = scenario("Checkout")
    .exec(viewCart)
    .exec(addCookie(Cookie("token", "${token}").withDomain(BaseUrl.domain)))
    .exec(GenerateToken.checkToken)
    .exec(ActionsCart.checkout)
}
