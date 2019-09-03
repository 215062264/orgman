package ac.za.cput.adp3.xyzcongolmerate.factory.user;

import ac.za.cput.adp3.xyzcongolmerate.domain.user.UserRole;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserRoleFactoryTest {

    //TODO: implement method body ONLY!
    @Test
    public void buildUserRole() {
        UserRole userRole = UserRoleFactory.buildUserRole("SARAT", "kyle@mail.com", "777");
        System.out.println("Email: " + userRole.getUserEmail()+ "\tOrgCode: "+userRole.getOrgCode());
        Assert.assertNotNull(userRole);
        /**
         * Your implementation goes here
         *
         * INSTRUCTION
         * 1. Remove line [//TODO: implement method body ONLY!]
         * 2. Remove line [throw new UnsupportedOperationException("Not yet supported.");]
         * 3. Test the UserRoleFactory class
         * 4. Assert that the an object is created.
         */
    }
}