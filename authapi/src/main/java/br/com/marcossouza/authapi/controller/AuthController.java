package br.com.marcossouza.authapi.controller;

import br.com.marcossouza.authapi.dto.ApiResponse;
import br.com.marcossouza.authapi.dto.LoginRequest;
import br.com.marcossouza.authapi.dto.RegisterRequest;
import br.com.marcossouza.authapi.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/auth")

public class AuthController {
    private final AuthService authService;
    public AuthController(AuthService authService) {
        this.authService = authService;
    }
    @PostMapping("/register")
    public ResponseEntity<ApiResponse<Void>> register(@Valid @RequestBody RegisterRequest request) {
        authService.register(request);
        return ResponseEntity.ok(ApiResponse.success("User created successfully", null));
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<String>> login(@Valid @RequestBody LoginRequest request) {
        String token = authService.login(request);
        return ResponseEntity.ok(ApiResponse.success("Login successful", token));
    }
    @GetMapping("/private")
    public ResponseEntity<String> privatePage(Principal principal) {
        return ResponseEntity.ok("Hello, " + principal.getName() + "! You are authenticated.");
    }
}
