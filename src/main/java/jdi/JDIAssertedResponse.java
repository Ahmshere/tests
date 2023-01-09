package jdi;

import com.epam.http.response.RestResponse;
import org.testng.Assert;

import java.util.Optional;

public class JDIAssertedResponse {
    public final RestResponse response;
    public JDIAssertedResponse(RestResponse response) {
        this.response = response;
    }

    // jsonPath - eto ta chast' JSON strukturi, kotoruu nuzno prevratit v java class
    public <T> T as(String jsonPath, Class<T> clazz){
        return response.getRaResponse().then().extract().body().jsonPath().getObject(jsonPath, clazz);
    }
    // proverka na soobsheniya
    public JDIAssertedResponse hasMessage(String expectedMessage){
        /* JSON -
            { "info": {
                "message": "string",
                "status": "string"
                } ...
            }
    ETOT BLOK Ya hochu prevratit v java object
        */
        Message message = as("info", Message.class);
        Assert.assertEquals(message.getMessage(), expectedMessage);
        return this;
    }

    // Status coda
    public JDIAssertedResponse hasStatusCode(Integer expectedStatus){
        int status = response.getStatus().code;
        Assert.assertEquals(status, Optional.ofNullable(expectedStatus));
        return this;
    }
}
