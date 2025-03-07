package edu.cmcc.cpt.demo.Task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable int id) {
        Task task = taskRepository.findById(id);
        return task != null ? ResponseEntity.ok(task) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<String> createTask(@RequestBody Task task) {
        taskRepository.save(task);
        return ResponseEntity.ok("Task created successfully.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateTask(@PathVariable int id, @RequestBody Task task) {
        int rowsAffected = taskRepository.update(id, task);
        return rowsAffected > 0 ? ResponseEntity.ok("Task updated successfully.") : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable int id) {
        int rowsAffected = taskRepository.deleteById(id);
        return rowsAffected > 0 ? ResponseEntity.ok("Task deleted successfully.") : ResponseEntity.notFound().build();
    }
}

    // Index for faster username lookup
    public static final String CREATE_INDEX =
        "CREATE INDEX idx_username ON public.users USING btree (username);";
}
