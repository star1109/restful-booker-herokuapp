package com.herokuapp.booker.restful.bookingInfo;

import com.herokuapp.booker.restful.model.BookingPojo;
import com.herokuapp.booker.restful.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class BookingPutTest extends TestBase {

    @Test
    public void updateBookingById() {

        HashMap<Object, Object> bookingdates = new HashMap<>();
        bookingdates.put("checkin", "2018-01-01");
        bookingdates.put("checkout", "2019-01-01");

        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setFirstname("Abc");
        bookingPojo.setLastname("xyz");
        bookingPojo.setTotalprice(11451);
        bookingPojo.setDepositpaid(false);
        bookingPojo.setBookingdates(bookingdates);
        bookingPojo.setAdditionalneeds("Breakfast");

        Response response = given()
                .header("Authorization", "Bearer 0c90e41203eca75")
                .header("Content-Type", "application/json")
                .header("Cookie", "token=28528346102147d")
                .pathParam("id", 2144)
                .body(bookingPojo)
                .when()
                .put("/booking/{id}");
        response.then().statusCode(200);
        response.then().time(lessThan(3000L));
        response.prettyPrint();
    }
}
