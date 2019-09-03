package ac.za.cput.adp3.xyzcongolmerate.factory.user;

import ac.za.cput.adp3.xyzcongolmerate.domain.user.User;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserFactoryTest {

    //TODO: implement method body ONLY!
    @Test
    public void buildUser() {
        User user = UserFactory.buildUser("kyle@mail.com", "Kyle", "Josias");
        System.out.println("Email:"+ user.getUserEmail()+" \tFirst name: "+user.getFirstName()+"\tLast name: "+user.getLastName());
        Assert.assertNotNull(user);
        /**
         * Your implementation goes here
         *
         * INSTRUCTION
         * 1. Remove line [//TODO: implement method body ONLY!]
         * 1. Remove line [throw new UnsupportedOperationException("Not yet supported.");]
         * 2. Test the UserFactory class
         * 3. Assert that the an object is created.
         */
    }
}