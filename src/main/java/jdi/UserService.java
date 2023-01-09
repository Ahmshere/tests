package jdi;
// JDI Dark для API автоестов

import com.epam.http.annotations.*;
import com.epam.http.requests.RestMethod;

@ServiceDomain("http://85.192.34.140:8080/api")
public class UserService {
    //Rest method - eto sushnost? kotoraya derzit vsu inf o zaprose.
    @POST("/register")
    @ContentType(io.restassured.http.ContentType.JSON)
    private RestMethod registerUser;

    @GET("/user")
    @ContentType(io.restassured.http.ContentType.JSON)
    private RestMethod getUserInfo;

    @PUT("/user")
    @ContentType(io.restassured.http.ContentType.JSON)
    private RestMethod updatePasswordUser;

    @DELETE
    @ContentType(io.restassured.http.ContentType.JSON)
    private RestMethod deleteUser;

    public JDIAssertedResponse registerNewUser(User user){
        return new JDIAssertedResponse(registerUser.body(user).call());
    }
}
