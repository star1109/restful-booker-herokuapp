package com.herokuapp.booker.restful.bookingInfo;

import com.herokuapp.booker.restful.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class BookingDeleteTest extends TestBase {

    @Test
    public void deleteBookingById() {

        Response response = given()
                .header("Authorization", "Bearer ba41816a2250d319d94b675bc82065a88bf3a7bdf4783dce41165818018dd9b3")
                .header("Content-Type", "application/json")
                .pathParam("id", 2117)
                .when()
                .delete("/booking/{id}");
        response.then().statusCode(201);
        response.then().time(lessThan(3000L));
        response.prettyPrint();
    }
}
