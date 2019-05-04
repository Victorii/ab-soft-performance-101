package ods.vm.gatling.scenarios

import io.gatling.core.Predef.{rampUsers, scenario}
import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._
import ods.vm.gatling.base.{ActionsCart, ActionsProduct, BaseUrl, GenerateToken}

/**
  * Created by Victoria on 06.04.2019.
  */
object ProductScenario {

  /**
    * View All products
    * */
  val viewAllProducts: ScenarioBuilder = scenario("View All products")
    .exec(addCookie(Cookie("token", "${token}").withDomain(BaseUrl.domain)))
    .exec(GenerateToken.checkToken)
    .exec(ActionsProduct.getAllProducts)
    .exec(ActionsCart.getProductFromCart)

  /**
    * View Product Details
    * */
  val viewProductDetails: ScenarioBuilder = scenario("View Product Details")
    .exec(addCookie(Cookie("token", "${token}").withDomain(BaseUrl.domain)))
    .exec(GenerateToken.checkToken)
    .exec(ActionsProduct.getProductById)
    .exec(ActionsCart.getProductFromCart)
}
