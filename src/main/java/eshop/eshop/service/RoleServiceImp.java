package eshop.eshop.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import eshop.eshop.model.Role;
import eshop.eshop.repository.RoleRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service @AllArgsConstructor @Transactional @Slf4j
public class RoleServiceImp implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public Role saveRole(Role role) {
        log.info("Saving role: {}", role);
        return roleRepository.save(role);
    }

    @Override
    public Role findRoleByName(String name) {
        log.info("Finding role by name: {}", name);
        return roleRepository.findByName(name);
    }

    @Override
    public Role findRoleById(Long id) {
        log.info("Finding role by id: {}", id);
        return roleRepository.findById(id).orElse(null);
    }

    @Override
    public List<Role> findAll() {
        log.info("Finding all roles");
        return roleRepository.findAll();
    }


}
