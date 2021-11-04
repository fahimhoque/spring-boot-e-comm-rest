package eshop.eshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import eshop.eshop.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
    User findByUsername(String username);
}
