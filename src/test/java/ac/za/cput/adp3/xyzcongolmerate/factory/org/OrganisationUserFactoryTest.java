package ac.za.cput.adp3.xyzcongolmerate.factory.org;

import ac.za.cput.adp3.xyzcongolmerate.domain.org.OrganisationUser;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrganisationUserFactoryTest {

    //TODO: implement method body ONLY!
    @Test
    public void buildOrganisationUser() {
        OrganisationUser organisationUser = OrganisationUserFactory.buildOrganisationUser("SARAT", "kyle@gmail.com");
        System.out.println("Email: "+organisationUser.getUserEmail());
        Assert.assertNotNull(organisationUser);
        /**
         * Your implementation goes here
         *
         * INSTRUCTION
         * 1. Remove line [//TODO: implement method body ONLY!]
         * 1. Remove line [throw new UnsupportedOperationException("Not yet supported.");]
         * 2. Test the OrganisationUserFactory class
         * 3. Assert that the an object is created.
         */
    }
}