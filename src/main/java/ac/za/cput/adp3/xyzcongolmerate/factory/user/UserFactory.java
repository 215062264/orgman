package ac.za.cput.adp3.xyzcongolmerate.factory.user;

import ac.za.cput.adp3.xyzcongolmerate.domain.user.User;

public class UserFactory {

    //TODO: implement method body ONLY!
    public static User buildUser(String userEmail, String firstName, String lastName) {
        return new User.Builder().firstName(firstName).lastName(lastName).userEmail(userEmail).build();
        /**
         * Your implementation goes here
         * INSTRUCTIONS
         * 1. Remove line [//TODO: implement method body ONLY!]
         * 2. Remove line [throw new UnsupportedOperationException("Not supported yet.");]
         * 3. Build and return an object of User
         */
    }
}
