package com.herokuapp.booker.restful.bookingInfo;

import com.herokuapp.booker.restful.model.BookingPojo;
import com.herokuapp.booker.restful.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class BookingPatchTest extends TestBase {

    @Test
    public void partiallyUpdateBooking() {
        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setFirstname("Raj");
        bookingPojo.setLastname("Simran");

        Response response = given()
                .header("Authorization", "Bearer ba41816a2250d319d94b675bc82065a88bf3a7bdf4783dce41165818018dd9b3")
                .header("Content-Type", "application/json")
                .header("Cookie", "token=28528346102147d")
                .pathParam("id", 642)
                .body(bookingPojo)
                .when()
                .patch("/booking/{id}");
        response.then().statusCode(200);
        response.then().time(lessThan(3000L));
        response.prettyPrint();
    }
}
