package ods.vm.gatling.base

import io.gatling.core.Predef._
import io.gatling.http.Predef._


/**
  * Created by Victoria on 31.03.2019.
  */
object ActionsProduct {

  val getAllProducts = http("Get all products").
    get(BaseUrl.products_service + "/api/products/get_all").
    check(status.is(200)).
    check(jsonPath("$["+generateRandomID(30)+"]._id").find.saveAs("id"))


  def generateRandomID(count: Int) : Int = {
    var random = new scala.util.Random
    random.nextInt(count)
  }


  val getProductById = http("Get product by id").
    get(BaseUrl.products_service+"/api/products/get_product/"+"${id}").
    check(status.is(200)).
    check(substring("\"status\":\"ok\"")).
    check(jsonPath("$.product"))



  val addProductToCart = http("Add product to cart")
    .get(BaseUrl.cart_service+"/api/cart/add_item/" + "${id}")
    .check(status.is(200))
    .check(substring("\"status\":\"ok\""))
    .check(substring("Product added to cart"))

  val topIDs = List("5c76cf4728bb32afe442999d","5c76cf4765291bfd47d1d993",
    "5c76cf47faf55d47ca5a30a2", "5c76cf479ff778c36f642f03","5c76cf47bce1c29b102247e5")

}
