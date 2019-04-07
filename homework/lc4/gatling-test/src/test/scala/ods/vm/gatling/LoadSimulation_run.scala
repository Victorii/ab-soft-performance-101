package ods.vm.gatling

import io.gatling.core.scenario.Simulation
import ods.vm.gatling.scenarios.{CartScenario, HPScenario, ProductScenario}
import io.gatling.core.Predef._
/**
  * Created by Victoria on 07.04.2019.
  *
  * The report is based on a run this class.
  */

class LoadSimulation_run extends Simulation{

  val scenario1 = scenario("Users: HP -> all product -> product details -> add to cart -> view cart -> checkout")
    .exec(HPScenario.openHomePage)
    .exec(ProductScenario.viewAllProducts)
    .exec(ProductScenario.viewProductDetails)
    .exec(CartScenario.addProductToCart)
    .exec(CartScenario.viewCart)
    .exec(CartScenario.checkout)
    .inject(rampUsers(3) during 180) //rampUsers(60) during 3600


  val scenario2  = scenario("Users: HP -> all product -> product details -> all product -> product details")
    .exec(HPScenario.openHomePage)
    .exec(ProductScenario.viewAllProducts)
    .exec(ProductScenario.viewProductDetails)
    .exec(ProductScenario.viewAllProducts)
    .exec(ProductScenario.viewProductDetails)
    .inject(rampUsers(20) during 180) //rampUsers(400) during 3600


  val scenario3  = scenario("Users: HP -> all product -> product details -> add to cart -> product details")
    .exec(HPScenario.openHomePage)
    .exec(ProductScenario.viewAllProducts)
    .exec(ProductScenario.viewProductDetails)
    .exec(CartScenario.addProductToCart)
    .exec(ProductScenario.viewProductDetails)
    .inject(rampUsers(11) during 180) //rampUsers(220) during 3600

  val scenario4  = scenario("Users: HP -> all product -> product details -> add to cart -> product details -> view cart -> checkout")
    .exec(HPScenario.openHomePage)
    .exec(ProductScenario.viewAllProducts)
    .exec(ProductScenario.viewProductDetails)
    .exec(CartScenario.addProductToCart)
    .exec(ProductScenario.viewProductDetails)
    .exec(CartScenario.viewCart)
    .exec(CartScenario.checkout)
    .inject(rampUsers(1) during 180) //rampUsers(20) during 3600

  val scenario5  = scenario("Users: HP -> all product -> product details -> add to cart")
    .exec(HPScenario.openHomePage)
    .exec(ProductScenario.viewAllProducts)
    .exec(ProductScenario.viewProductDetails)
    .exec(CartScenario.addProductToCart)
    .inject(rampUsers(5) during 180) //rampUsers(100) during 3600

  val scenario6  = scenario("Users: HP -> all product -> product details -> view cart")
    .exec(HPScenario.openHomePage)
    .exec(ProductScenario.viewAllProducts)
    .exec(ProductScenario.viewProductDetails)
    .exec(CartScenario.viewCart)
    .inject(rampUsers(1) during 180) //rampUsers(20) during 3600

  val scenario7  = scenario("Users: HP -> all product -> product details -> view cart -> product details")
    .exec(HPScenario.openHomePage)
    .exec(ProductScenario.viewAllProducts)
    .exec(ProductScenario.viewProductDetails)
    .exec(CartScenario.viewCart)
    .exec(ProductScenario.viewProductDetails)
    .inject(rampUsers(8) during 180) //rampUsers(160) during 3600

  val scenario8  = scenario("Users: HP -> all product -> product details")
    .exec(HPScenario.openHomePage)
    .exec(ProductScenario.viewAllProducts)
    .exec(ProductScenario.viewProductDetails)
    .inject(rampUsers(1) during 180) //rampUsers(20) during 3600


  setUp(scenario1,scenario2,scenario3,scenario4,scenario5,scenario6,scenario7,scenario8)
}
