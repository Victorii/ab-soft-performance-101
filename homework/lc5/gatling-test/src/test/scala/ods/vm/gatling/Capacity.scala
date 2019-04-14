package ods.vm.gatling

import io.gatling.core.scenario.Simulation
import ods.vm.gatling.scenarios.{CartScenario, HPScenario, ProductScenario}
import io.gatling.core.Predef._

/**
  * Created by Victoria on 14.04.2019.
  */
class Capacity  extends Simulation{

  val scenario1 = scenario("Users: HP -> all product (5 times) -> product details (5 times)" +
    " -> add to cart (5 times) -> view cart -> checkout")
    .exec(HPScenario.openHomePage)
    .exec(ProductScenario.viewAllProducts)
    .exec(ProductScenario.viewProductDetails)
    .exec(CartScenario.addProductToCart)
    .exec(ProductScenario.viewAllProducts)
    .exec(ProductScenario.viewProductDetails)
    .exec(CartScenario.addProductToCart)
    .exec(ProductScenario.viewAllProducts)
    .exec(ProductScenario.viewProductDetails)
    .exec(CartScenario.addProductToCart)
    .exec(ProductScenario.viewAllProducts)
    .exec(ProductScenario.viewProductDetails)
    .exec(CartScenario.addProductToCart)
    .exec(ProductScenario.viewAllProducts)
    .exec(ProductScenario.viewProductDetails)
    .exec(CartScenario.addProductToCart)
    .exec(CartScenario.viewCart)
    .exec(CartScenario.checkout)
    .inject(rampUsers(30) during 180)

  val scenario4  = scenario("Users: HP -> all product (2 times) -> product details (2 times) -> add to cart (2 times) -> " +
    "product details -> checkout")
    .exec(HPScenario.openHomePage)
    .exec(ProductScenario.viewAllProducts)
    .exec(ProductScenario.viewProductDetails)
    .exec(CartScenario.addProductToCart)
    .exec(ProductScenario.viewAllProducts)
    .exec(ProductScenario.viewProductDetails)
    .exec(CartScenario.addProductToCart)
    .exec(CartScenario.checkout)
    .inject(rampUsers(26) during 180)

  val scenario2  = scenario("Users: HP -> all product (2 times) -> product details (2 times)")
    .exec(HPScenario.openHomePage)
    .exec(ProductScenario.viewAllProducts)
    .exec(ProductScenario.viewProductDetails)
    .exec(ProductScenario.viewAllProducts)
    .exec(ProductScenario.viewProductDetails)
    .inject(rampUsers(64) during 180)


  val scenario3  = scenario("Users: HP -> product details")
    .exec(HPScenario.openHomePage)
    .exec(ProductScenario.viewProductDetails)
    .inject(rampUsers(49) during 180)



  val scenario5  = scenario("Users: HP -> all product -> product details -> add to cart")
    .exec(HPScenario.openHomePage)
    .exec(ProductScenario.viewAllProducts)
    .exec(ProductScenario.viewProductDetails)
    .exec(CartScenario.addProductToCart)
    .inject(rampUsers(30) during 180)

  val scenario6  = scenario("Users: HP -> all product -> view cart")
    .exec(HPScenario.openHomePage)
    .exec(ProductScenario.viewAllProducts)
    .exec(CartScenario.viewCart)
    .inject(rampUsers(26) during 180)

  val scenario7  = scenario("Users: HP -> all product -> product details -> view cart -> product details")
    .exec(HPScenario.openHomePage)
    .exec(ProductScenario.viewAllProducts)
    .exec(ProductScenario.viewProductDetails)
    .exec(CartScenario.viewCart)
    .exec(ProductScenario.viewProductDetails)
    .inject(rampUsers(40) during 180)

  val scenario8  = scenario("Users: HP -> all product -> product details")
    .exec(HPScenario.openHomePage)
    .exec(ProductScenario.viewAllProducts)
    .exec(ProductScenario.viewProductDetails)
    .inject(rampUsers(26) during 180)


  setUp(scenario1,scenario2,scenario3,scenario4,scenario5,scenario6,scenario7,scenario8)
}
