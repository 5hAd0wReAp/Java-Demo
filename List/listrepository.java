package edu.cmcc.cpt.demo.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

public class listrepository {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<List> findAll() {
        String sql = "SELECT list_id, list_name, created_at, updated_at FROM task_lists";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(List.class));
    }

    public List findById(int id) {
        String sql = "SELECT list_id, list_name, created_at, updated_at FROM task_lists WHERE list_id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(List.class), id);
    }

    public int save(List list) {
        String sql = "INSERT INTO task_lists (list_name) VALUES (?)";
        return jdbcTemplate.update(sql, list.getListName());
    }

    public int update(int id, List list) {
        String sql = "UPDATE task_lists SET list_name = ?, updated_at = CURRENT_TIMESTAMP WHERE list_id = ?";
        return jdbcTemplate.update(sql, list.getListName(), id);
    }

    public int deleteById(int id) {
        String sql = "DELETE FROM task_lists WHERE list_id = ?";
        return jdbcTemplate.update(sql, id);
    }
}
