package api;

import io.restassured.http.ContentType;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class ReqresTest {
    private final static String URL = "https://reqres.in/";

    @Test
    public void checkAvatarIdTest(){

        // given() - Osnovnoi method. s nego nachinautsa vse zaprosi po HTTP protokolu
        List<UserData> users = given()
                .when().contentType(ContentType.JSON)
                .get(URL+"api/users?page=2").then().log().all()
                .extract().body().jsonPath().getList("data", UserData.class);
// Vmesto get() mogut bit lubie http metodi!
        users.stream().forEach(x-> {
            Assert.assertTrue(x.getAvatar().contains(x.getId().toString()));
        });
        Assert.assertTrue(users.stream().allMatch(x->x.getEmail().endsWith("@reqres.in")));
    }
}
// https://www.youtube.com/watch?v=gxzXOMxIt4w
// https://www.youtube.com/watch?v=z9Tvxh6uQzI
// АПИ и ГУИ вместе! https://www.youtube.com/watch?v=V6NotcHVhG0