package test;

import jdi.User;
import jdi.UserService;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

import static com.epam.http.requests.ServiceInit.init;

public class JDI_Test {
    private Random random;
    private UserService userService;
    private User randomUser;
    @BeforeClass
    public void initServices(){
         random = new Random();
         userService = init(UserService.class);
    }
    @BeforeMethod
    public void initRandomUser(){
        randomUser = new User("testLogin"+random.nextInt(), "pass"+random.nextInt());
    }
    @Test
    public void positiveRegistertest(){
       userService.registerNewUser(randomUser).hasStatusCode(201); //.hasStatusCode(201)
    }
}
