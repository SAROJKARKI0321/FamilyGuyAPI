package com.example.ResponseEntDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AppUserRepo appUserRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
        public ResponseEntity<?> register(@RequestBody AppUser appUser){
            if(appUserRepo.findByUsername(appUser.getUsername())!=null){
                return ResponseEntity.badRequest().body("User already exist");
        }
            appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
            appUserRepo.save(appUser);
            return ResponseEntity.ok("User registerd sucesfully");

    }
}
