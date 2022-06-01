package com.herokuapp.booker.restful.bookingInfo;

import com.herokuapp.booker.restful.model.BookingPojo;
import com.herokuapp.booker.restful.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class BookingGetTest extends TestBase {

    @Test
    public void getAllBookings() {

        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setUsername("admin");
        bookingPojo.setPassword("password123");

        Response response = given()
                .body(bookingPojo)
                .when()
                .get("/booking");
                response.then().statusCode(200);
                response.prettyPrint();
    }

    @Test
    public void getBookingById() {

        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setUsername("admin");
        bookingPojo.setPassword("password123");

        Response response = given()
                .pathParam("id",4119)
                .body(bookingPojo)
                .when()
                .get("/booking"+"/{id}");
        response.then().statusCode(200);

        response.prettyPrint();
    }

}
