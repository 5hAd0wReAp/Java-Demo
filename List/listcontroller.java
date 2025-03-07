package list;

public class listcontroller {
    
}
package edu.cmcc.cpt.demo.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lists")
public class listcontroller {
    
    @Autowired
    private ListRepository listRepository;

    @GetMapping
    public List<List> getAllLists() {
        return listRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<List> getListById(@PathVariable int id) {
        List list = listRepository.findById(id);
        return list != null ? ResponseEntity.ok(list) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<String> createList(@RequestBody List list) {
        listRepository.save(list);
        return ResponseEntity.ok("List created successfully.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateList(@PathVariable int id, @RequestBody List list) {
        int rowsAffected = listRepository.update(id, list);
        return rowsAffected > 0 ? ResponseEntity.ok("List updated.") : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteList(@PathVariable int id) {
        int rowsAffected = listRepository.deleteById(id);
        return rowsAffected > 0 ? ResponseEntity.ok("List deleted.") : ResponseEntity.notFound().build();
    }
}
