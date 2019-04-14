package ods.vm.gatling.scenarios

import io.gatling.core.Predef.scenario
import ods.vm.gatling.base.{ActionsProduct, BaseUrl, GenerateToken}
import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._


/**
  * Created by Victoria on 06.04.2019.
  */
object HPScenario {

var token = ""
  /**
    * HP
    * */
  val openHomePage: ScenarioBuilder = scenario("Open Home Page")
    .exec(GenerateToken.getToken)
    .exec(GenerateToken.checkToken)
    .exec(addCookie(Cookie("token","${token}").withDomain(BaseUrl.domain)))
    .foreach(ActionsProduct.topIDs, "id") {
      exec(ActionsProduct.getProductById)
    }
    .exec(session => {
    token = session("token").as[String]
    println("token:" + token)
    session }  )
}
