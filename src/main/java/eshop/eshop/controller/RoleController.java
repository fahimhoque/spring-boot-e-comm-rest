package eshop.eshop.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eshop.eshop.model.Role;
import eshop.eshop.service.RoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/role")
@RequiredArgsConstructor
@Slf4j
public class RoleController {
    private final RoleService roleService;

    @PostMapping("/create")
    public ResponseEntity<Role> createRole(@RequestBody Role role) {
        log.info("Creating role: {}", role);
        return ResponseEntity.ok(roleService.saveRole(role));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Role>> getAllRoles() {
        log.info("Getting all roles");
        return ResponseEntity.ok(roleService.findAll());
    }

    @GetMapping("/all/{id}")
    public ResponseEntity<Role> getRoleById(Long id) {
        log.info("Getting role by id: {}", id);
        return ResponseEntity.ok(roleService.findRoleById(id));
    }
}
