package ac.za.cput.adp3.xyzcongolmerate.repository.user.impl;

import ac.za.cput.adp3.xyzcongolmerate.domain.user.UserRole;
import ac.za.cput.adp3.xyzcongolmerate.repository.user.UserRoleRepository;

import java.util.HashSet;
import java.util.Set;

public class UserRoleRepositoryImpl implements UserRoleRepository {

    private Set<UserRole> userRoleDB;
    private static UserRoleRepository userRoleRepository = null;

    private UserRoleRepositoryImpl() {
        this.userRoleDB = new HashSet<>();
    }

    public static UserRoleRepository getUserRoleRepository() {
        if (userRoleRepository == null) userRoleRepository = new UserRoleRepositoryImpl();
        return userRoleRepository;
    }

    public UserRole findUR(String UserEmail){
        return this.userRoleDB.stream()
                .filter(user -> user.getUserEmail()
                        .trim()
                        .equals(UserEmail))
                .findAny()
                .orElse(null);
    }

    //TODO: Implement body
    @Override
    public UserRole create(UserRole userRole) {
        userRoleDB.add(userRole);
        return userRole;
    }

    //TODO: Implement body
    @Override
    public UserRole read(UserRole userRole) {
        UserRole user = findUR(userRole.getUserEmail());
        return user;
    }

    //TODO: Implement body
    @Override
    public UserRole update(UserRole userRole) {
        UserRole toDelete = findUR(userRole.getUserEmail());
        if(toDelete != null){
            this.userRoleDB.remove(toDelete);
            return create(userRole);
        }
        return null;
    }

    //TODO: Implement body
    @Override
    public void delete(UserRole userRole) {
        UserRole user = findUR(userRole.getUserEmail());
        if (user != null) {
            userRoleDB.remove(user);
        }
    }

    //TODO: Implement body
    @Override
    public Set<UserRole> getAll() {
        return this.userRoleDB;
    }
}
