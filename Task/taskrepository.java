package task;

public class taskRepository {
    package edu.cmcc.cpt.demo.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.config.Task;

public class taskRepository {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Task> findAll() {
        String sql = "SELECT task_id, list_id, task_name, due_date, priority, status FROM tasks";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Task.class));
    }

    public Task findById(int id) {
        String sql = "SELECT task_id, list_id, task_name, due_date, priority, status FROM tasks WHERE task_id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Task.class), id);
    }

    public int save(Task task) {
        String sql = "INSERT INTO tasks (list_id, task_name, due_date, priority, status) VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, task.getListId(), task.getTaskName(), task.getDueDate(), task.getPriority(), task.getStatus());
    }

    public int update(int id, Task task) {
        String sql = "UPDATE tasks SET list_id = ?, task_name = ?, due_date = ?, priority = ?, status = ? WHERE task_id = ?";
        return jdbcTemplate.update(sql, task.getListId(), task.getTaskName(), task.getDueDate(), task.getPriority(), task.getStatus(), id);
    }

    public int deleteById(int id) {
        String sql = "DELETE FROM tasks WHERE task_id = ?";
        return jdbcTemplate.update(sql, id);
    }
}

}
