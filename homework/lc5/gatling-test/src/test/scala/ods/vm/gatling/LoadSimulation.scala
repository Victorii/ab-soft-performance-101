package ods.vm.gatling

import io.gatling.core.scenario.Simulation
import ods.vm.gatling.scenarios.{CartScenario, HPScenario, ProductScenario}
import io.gatling.core.Predef._


/**
  * Created by Victoria on 06.04.2019.
  */
class LoadSimulation extends Simulation{

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
    .inject(rampUsers(60) during 3600)

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
    .inject(rampUsers(20) during 3600)

  val scenario2  = scenario("Users: HP -> all product (2 times) -> product details (2 times)")
    .exec(HPScenario.openHomePage)
    .exec(ProductScenario.viewAllProducts)
    .exec(ProductScenario.viewProductDetails)
    .exec(ProductScenario.viewAllProducts)
    .exec(ProductScenario.viewProductDetails)
    .inject(rampUsers(400) during 3600)


  val scenario3  = scenario("Users: HP -> product details")
    .exec(HPScenario.openHomePage)
    .exec(ProductScenario.viewProductDetails)
    .inject(rampUsers(260) during 3600)



  val scenario5  = scenario("Users: HP -> all product -> product details -> add to cart")
    .exec(HPScenario.openHomePage)
    .exec(ProductScenario.viewAllProducts)
    .exec(ProductScenario.viewProductDetails)
    .exec(CartScenario.addProductToCart)
    .inject(rampUsers(60) during 3600)

  val scenario6  = scenario("Users: HP -> all product -> view cart")
    .exec(HPScenario.openHomePage)
    .exec(ProductScenario.viewAllProducts)
    .exec(CartScenario.viewCart)
    .inject(rampUsers(20) during 3600)

  val scenario7  = scenario("Users: HP -> all product -> product details -> view cart -> product details")
    .exec(HPScenario.openHomePage)
    .exec(ProductScenario.viewAllProducts)
    .exec(ProductScenario.viewProductDetails)
    .exec(CartScenario.viewCart)
    .exec(ProductScenario.viewProductDetails)
    .inject(rampUsers(160) during 3600)

  val scenario8  = scenario("Users: HP -> all product -> product details")
    .exec(HPScenario.openHomePage)
    .exec(ProductScenario.viewAllProducts)
    .exec(ProductScenario.viewProductDetails)
    .inject(rampUsers(20) during 3600)


  setUp(scenario1,scenario2,scenario3,scenario4,scenario5,scenario6,scenario7,scenario8)

}
