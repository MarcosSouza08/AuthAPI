package br.com.marcossouza.authapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {

    @GetMapping("/admin/dashboard")
    public ResponseEntity<String> adminOnly() {
        return ResponseEntity.ok("Área do ADMIN.");
    }

    @GetMapping("/user/profile")
    public ResponseEntity<String> userArea() {
        return ResponseEntity.ok("Área do USER.");
    }
}
