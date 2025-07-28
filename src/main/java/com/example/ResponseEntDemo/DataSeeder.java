package com.example.ResponseEntDemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSeeder {

    @Bean
    public CommandLineRunner loadCharacters(FamilyGuyCharacterRepo repo) {
        return args -> {
            if (repo.count() == 0) {
                repo.save(new FamilyGuyCharacter(0, "Peter Griffin", 43, "Factory Worker", "Freakin' sweet", "Beer"));
                repo.save(new FamilyGuyCharacter(0, "Lois Griffin", 40, "Piano Teacher", "Peter!", "Family"));
                repo.save(new FamilyGuyCharacter(0, "Stewie Griffin", 1, "Evil Genius", "Victory is mine!", "Time travel"));
                repo.save(new FamilyGuyCharacter(0, "Brian Griffin", 7, "Writer", "You know what really grinds my gears?", "Martinis"));
                repo.save(new FamilyGuyCharacter(0, "Meg Griffin", 17, "Student", "Shut up, Meg", "Attention"));
                repo.save(new FamilyGuyCharacter(0, "Chris Griffin", 15, "Student", "Dad?", "Drawing"));
            }
        };
    }
}

