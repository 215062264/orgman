package ac.za.cput.adp3.xyzcongolmerate.factory.user;

import ac.za.cput.adp3.xyzcongolmerate.domain.user.UserDemography;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class UserDemographyFactoryTest {

    //TODO: implement method body ONLY!
    @Test
    public void buildUserDemography() {
        Date date = new Date();
        UserDemography userDemography = UserDemographyFactory.buildUserDemography("kyle@mail.com", "CTO", "1", "777", date);
        System.out.println("Email: "+userDemography.getUserEmail()+"\tTitle:"+userDemography.getUserTitle()+"\tDate: "+userDemography.getDateOfBirth());
        Assert.assertNotNull(userDemography);
        /**
         * Your implementation goes here
         *
         * INSTRUCTION
         * 1. Remove line [//TODO: implement method body ONLY!]
         * 2. Remove line [throw new UnsupportedOperationException("Not yet supported.");]
         * 3. Test the UserDemographyFactory class
         * 4. Assert that the an object is created.
         */
    }
}