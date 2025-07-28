package com.example.ResponseEntDemo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepo extends JpaRepository<AppUser,Integer> {
    public AppUser findByUsername(String username);
}
