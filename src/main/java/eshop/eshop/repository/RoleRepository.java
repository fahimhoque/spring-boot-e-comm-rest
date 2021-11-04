package eshop.eshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import eshop.eshop.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
