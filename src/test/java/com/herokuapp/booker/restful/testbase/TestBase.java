package com.herokuapp.booker.restful.testbase;

import com.herokuapp.booker.restful.utils.TestUtils;
import io.restassured.RestAssured;
import org.junit.BeforeClass;

public class TestBase extends TestUtils {

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";

    }
}
