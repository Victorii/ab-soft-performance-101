package ods.vm.gatling.base

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef.jdbcFeeder
/**
  * Created by Victoria on 31.03.2019.
  */
object GenerateToken {

  val getToken = http("Get token").
    get(BaseUrl.auth_server + "/api/auth/generate_token").
    check(status.is(200)).
    check(jsonPath("$.token").saveAs("token"))


  val checkToken = http("Check Token").
    get(BaseUrl.auth_server + "/api/auth/validate_token/" + "${token}").
    check(status.is(200));
}
