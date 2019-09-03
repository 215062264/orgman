package ac.za.cput.adp3.xyzcongolmerate.repository.user.impl;

import ac.za.cput.adp3.xyzcongolmerate.domain.user.User;
import ac.za.cput.adp3.xyzcongolmerate.repository.user.UserRepository;

import java.util.HashSet;
import java.util.Set;

public class UserRepositoryImpl implements UserRepository {

    private Set<User> userDB;
    private static UserRepository userRepository = null;

    private UserRepositoryImpl() {
        this.userDB = new HashSet<>();
    }

    public static UserRepository getUserRepository() {
        if (userRepository == null) userRepository = new UserRepositoryImpl();
        return userRepository;
    }

    public User findUser(String UserEmail){
        return this.userDB.stream()
                .filter(user -> user.getUserEmail()
                        .trim()
                        .equals(UserEmail))
                .findAny()
                .orElse(null);
    }

    //TODO: Implement body
    @Override
    public User create(User user) {
        this.userDB.add(user);
        return user;
    }

    //TODO: Implement body
    @Override
    public User read(String email) {
        User user = findUser(email);
        return user;
    }

    //TODO: Implement body
    @Override
    public User update(User user) {
        User toDelete = findUser(user.getUserEmail());
        if(toDelete != null){
            this.userDB.remove(toDelete);
            return create(user);
        }
        return null;
    }

    //TODO: Implement body
    @Override
    public void delete(String email) {
        User user = findUser(email);
        if (user != null) {
            userDB.remove(user);
        }
    }

    //TODO: Implement body
    @Override
    public Set<User> getAll() {
        return this.userDB;
    }
}
