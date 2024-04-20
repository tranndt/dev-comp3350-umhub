package comp3350.umhub.tests.business;

import comp3350.umhub.business.AccessUsers;
import comp3350.umhub.business.IAccessUsers;
import comp3350.umhub.business.Login;
import comp3350.umhub.persistence.stubs.UserPersistenceStub;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.security.auth.login.LoginException;


public class LoginTest {
    private Login testLogin;

    private final String[] user1Input = {"",""};
    private final String[] user2Input = {"", "password2"};
    private final String[] user3Input = {"user1", ""};
    private final String[] user4Input = {"admin1", "123456"};
    private final String[] user5Input = {"user1","password1"};

    @Before
    public void setUp(){
        IAccessUsers getStubs = new AccessUsers(new UserPersistenceStub());
        testLogin = new Login(getStubs);
    }


    @Test /* Test login with empty username,password */
    public void testInvalidLogin()
    {
        System.out.println("\nStarting test testInvalidLogin");
        try{
            testLogin.login(user1Input[0],user1Input[1]);
            Assert.fail("Exception was not thrown");
        }catch(LoginException e){
            System.out.println("Finished test testInvalidLogin");
        }


    }

    @Test /* Test login with empty username */
    public void testInvalidName()
    {
        System.out.println("\nStarting test testInvalidName");
        try{
            testLogin.login(user2Input[0],user2Input[1]);
            Assert.fail("Exception was not thrown");
        }catch(LoginException e){
            System.out.println("Finished test testInvalidName");
        }


    }

    @Test /* Test login with empty password */
    public void testInvalidPass()
    {
        System.out.println("\nStarting test testInvalidPass");
        try{
            testLogin.login(user3Input[0],user3Input[1]);
            Assert.fail("Exception was not thrown");
        }catch(LoginException e){
            System.out.println("Finished test testInvalidPass");
        }

    }

    @Test /* Test login with valid username,password */
    public void testValidLogin()
    {
        System.out.println("\nStarting test testValidLogin");
        try{
            testLogin.login(user4Input[0],user4Input[1]);
            System.out.println("Finished test testValidLogin");
        }catch(LoginException e){
            Assert.fail("Exception was thrown");
        }

    }

    @Test /* Test login with valid username,password but user not in database*/
    public void testInValidLogin()
    {
        System.out.println("\nStarting test testInValidLogin");
        try{
            testLogin.login(user5Input[0],user5Input[1]);
            Assert.fail("Exception was thrown");
        }catch(LoginException e){
            System.out.println("Finished testInValidLogin");
        }

    }


}

