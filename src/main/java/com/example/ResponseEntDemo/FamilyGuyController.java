package com.example.ResponseEntDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/characters")
public class FamilyGuyController {

    @Autowired
    private FamilyGuyCharacterRepo repo;

    public FamilyGuyController(FamilyGuyCharacterRepo repo) {
        this.repo = repo;
    }

    @GetMapping
    public ResponseEntity<List<FamilyGuyCharacter>> getAll() {
        return ResponseEntity.ok(repo.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        return repo.findById(id)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(404).body("Character not found"));
    }

    @PostMapping
    public ResponseEntity<FamilyGuyCharacter> create(@RequestBody FamilyGuyCharacter character) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repo.save(character));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody FamilyGuyCharacter updatedChar) {
        return repo.findById(id).<ResponseEntity<?>>map(c -> {
            if (updatedChar.getName() != null) c.setName(updatedChar.getName());
            if (updatedChar.getAge() != 0) c.setAge(updatedChar.getAge());
            if (updatedChar.getProfession() != null) c.setProfession(updatedChar.getProfession());
            if (updatedChar.getSlangUsed() != null) c.setSlangUsed(updatedChar.getSlangUsed());
            if (updatedChar.getFavoriteThing() != null) c.setFavoriteThing(updatedChar.getFavoriteThing());
            return ResponseEntity.ok(repo.save(c));
        }).orElse(ResponseEntity.status(404).body("Not found"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        return repo.findById(id).<ResponseEntity<?>>map(character -> {
            repo.delete(character);
            return ResponseEntity.ok("Deleted: " + character.getName());
        }).orElse(ResponseEntity.status(404).body("Oops! Character not found"));
    }
}

