package br.com.marcossouza.authapi.service;

import br.com.marcossouza.authapi.dto.LoginRequest;
import br.com.marcossouza.authapi.dto.RegisterRequest;
import br.com.marcossouza.authapi.exception.BusinessException;
import br.com.marcossouza.authapi.model.Role;
import br.com.marcossouza.authapi.model.User;
import br.com.marcossouza.authapi.repository.UserRepository;
import br.com.marcossouza.authapi.security.JwtSecurity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtSecurity jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthService(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            JwtSecurity jwtService,
            AuthenticationManager authenticationManager
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public void register(RegisterRequest request) {

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new BusinessException("Email already in use", 409);
        }

        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.USER);

        userRepository.save(user);
    }

    public String login(LoginRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow();

        return jwtService.generateToken(
                user.getEmail(),
                user.getRole().name()
        );
    }
}