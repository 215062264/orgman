package ac.za.cput.adp3.xyzcongolmerate.repository.user.impl;

import ac.za.cput.adp3.xyzcongolmerate.domain.user.UserDemography;
import ac.za.cput.adp3.xyzcongolmerate.repository.user.UserDemographyRepository;

import java.util.HashSet;
import java.util.Set;

public class UserDemographyRepositoryImpl implements UserDemographyRepository {

    private Set<UserDemography> userDemographyDB;
    private static UserDemographyRepository userDemographyRepository = null;

    private UserDemographyRepositoryImpl() {
        this.userDemographyDB = new HashSet<>();
    }

    public static UserDemographyRepository getUserDemographyRepository() {
        if (userDemographyRepository == null) userDemographyRepository = new UserDemographyRepositoryImpl();
        return userDemographyRepository;
    }

    public UserDemography findUD(String userEmail){
        return this.userDemographyDB.stream()
                .filter(user -> user.getUserEmail()
                        .trim()
                        .equals(userEmail))
                .findAny()
                .orElse(null);
    }

    //TODO: Implement body
    @Override
    public UserDemography create(UserDemography userDemography) {
      this.userDemographyDB.add(userDemography);
      return userDemography;
    }

    //TODO: Implement body
    @Override
    public UserDemography read(String userEmail) {
        UserDemography user = findUD(userEmail);
        return user;
    }

    //TODO: Implement body
    @Override
    public UserDemography update(UserDemography userDemography) {
        UserDemography toDelete = findUD(userDemography.getUserEmail());
        if(toDelete != null){
            this.userDemographyDB.remove(toDelete);
            return create(userDemography);
        }
        return null;
    }

    //TODO: Implement body
    @Override
    public void delete(String userEmail) {
        UserDemography user = findUD(userEmail);
        if (user != null) {
            userDemographyDB.remove(user);
        }
    }

    //TODO: Implement body
    @Override
    public Set<UserDemography> getAll() {
        return this.userDemographyDB;
    }
}
