package ods.vm.gatling

import io.gatling.core.Predef.{Simulation, _}
import io.gatling.core.structure.PopulationBuilder
import io.gatling.http.Predef._
import ods.vm.gatling.base.{ActionsCart, ActionsProduct, BaseUrl, GenerateToken}

/**
  * Created by Victoria on 03.04.2019.
  */
class Scenario extends Simulation {


  /**
    * HP
    * */

  val openHomePage: PopulationBuilder = scenario("Open Home Page")
    .exec(GenerateToken.getToken) //TODO: Incorrect! Token need save in VAR
    .exec(GenerateToken.checkToken)
    .inject(rampUsers(1000) during 3600)

  /**
    * View All products
    * */
  val viewAllProducts: PopulationBuilder = scenario("View All products")
    .exec(GenerateToken.getToken) //TODO: Incorrect! Token need save in VAR
    .exec(addCookie(Cookie("token", "${token}").withDomain(BaseUrl.domain)))
    .exec(ActionsProduct.getAllProducts)
    .inject(rampUsers(1400) during 3600)

  /**
    * View Product Details
    * */
  val viewProductDetails: PopulationBuilder = scenario("View Product Details")
    .exec(GenerateToken.getToken) //TODO: Incorrect! Token need save in VAR
    .exec(addCookie(Cookie("token", "${token}").withDomain(BaseUrl.domain)))
    .exec(ActionsProduct.getAllProducts) //TODO: Incorrect! ID need save in VAR
    .exec(ActionsProduct.getProductById)
    .inject(rampUsers(6800) during 3600)

  /**
    * Add Product to cart
    * */
  val addProductToCart: PopulationBuilder = scenario("Add Product to cart")
    .exec(GenerateToken.getToken) //TODO: Incorrect! Token need save in VAR
    .exec(addCookie(Cookie("token", "${token}").withDomain(BaseUrl.domain)))
    .exec(ActionsProduct.getAllProducts) //TODO: Incorrect! ID need save in VAR
    .exec(ActionsProduct.addProductToCart)
    .inject(rampUsers(1400) during 3600)//TODO: see in workload model correct number

  /**
    * View Cart
    * */

  val viewCart: PopulationBuilder = scenario("View Cart")
    .exec(GenerateToken.getToken) //TODO: Incorrect! Token need save in VAR
    .exec(addCookie(Cookie("token", "${token}").withDomain(BaseUrl.domain)))
    .exec(ActionsCart.getProductFromCart)
    .inject(rampUsers(3440) during 3600)

  /**
    * Checkout
    * */
  val checkout: PopulationBuilder  = scenario("Checkout")
    .exec(GenerateToken.getToken) //TODO: Incorrect! Token need save in VAR
    .exec(addCookie(Cookie("token", "${token}").withDomain(BaseUrl.domain)))
    .exec(ActionsCart.checkout)
    .inject(rampUsers(80) during 3600)

  //Only for check work
  setUp(viewCart)
}
