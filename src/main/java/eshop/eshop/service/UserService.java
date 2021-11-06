package eshop.eshop.service;

import java.util.List;

import eshop.eshop.model.Role;
import eshop.eshop.model.User;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);

    /* Add Role to user*/
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    User getUserById(Long id);

    /* 
    TO BE IMPLEMENTED: for each request return only 50 users
    */
    List<User> getUsers();
}
