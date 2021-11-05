package eshop.eshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import eshop.eshop.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
    
}
