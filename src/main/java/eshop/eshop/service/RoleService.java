package eshop.eshop.service;

import java.util.List;

import eshop.eshop.model.Role;

public interface RoleService {
    Role saveRole(Role role);
    Role findRoleByName(String name);
    Role findRoleById(Long id);

    List<Role> findAll();
}
