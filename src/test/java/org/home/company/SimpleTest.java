package org.home.company;

import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.LoginPage;

import static io.restassured.RestAssured.given;


public class SimpleTest {
    private final String VALID_EMAIL = "eapiskunova@gmail.com";

    private final String VALID_PASSWORD = "1234567890";

    private final String BASE_URL = "https://auth-back.weareway.trade/login/oauth/authorize?client_id=36d75bb26334763a0b90&response_type=code&redirect_uri=https%3A%2F%2Fweareway.trade%2Fauth-callback%3Freturn_url%3D%2Fru-ru&scope=read&state=14hex1j5awan\n";


    @Owner("Zhenya")
    @Link(name = "link", url = "https://auth-back.weareway.trade/login/oauth/authorize?client_id=36d75bb26334763a0b90&response_type=code&redirect_uri=https%3A%2F%2Fweareway.tradae%2Fauth-callback%3Freturn_url%3D%2Fru-ru&scope=read")
    @Description("unsuccess login")
    @Test
    public void testUserGetsMessageOnInvalidData() {
        new LoginPage(BASE_URL)
                .putEmail("")
                .putPasswordField("")
                .clickSubmit()
                .assertErrorMessageVisible();

    }

    @Test
    public void testGet() {
        Response response =
                given()
                        .baseUri("https://prod-marketing-back.weareway.trade")
                        .when()
                        .log()
                        .all()
                        .get("/landing/v1/marketplace/ru/info");
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("currency_dest"), "RUB");
    }
}