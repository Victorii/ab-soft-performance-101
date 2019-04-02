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
    check(jsonPath("$["+generateRandomID()+"]._id").find.saveAs("id"))

  //TODO: will be rewritten.  Cant use only first 10 ids
  def generateRandomID() : Int = {
    var random = new scala.util.Random
    random.nextInt(10)
  }

  val getProductById = http("Get product by id").
    get(BaseUrl.products_service+"/api/products/get_product/"+"${id}").
    check(status.is(200))

  val addProductToCart = http("Add product to cart")
    .get(BaseUrl.cart_service+"/api/cart/add_item/" + "${id}")
    .check(status.is(200))

}
