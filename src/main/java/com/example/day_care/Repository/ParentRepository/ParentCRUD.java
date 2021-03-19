package com.example.day_care.Repository.ParentRepository;

import java.util.List;

import com.example.day_care.Model.Parent;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class ParentCRUD implements InterfaceParent {
    @Autowired
    JdbcTemplate jdbcTemplate;

    // CREATE
    @Override
    public Parent addParent(Parent myParent) {
        String sql = "INSERT INTO parents(momName, dadName, phoneNumber, address) VALUES(?,?,?,?)";
        jdbcTemplate.update(sql, myParent.getMomName(), myParent.getDadName(), myParent.getPhoneNumber(),
                myParent.getAddress());
        return null;
    };

    // READ
    @Override
    public Parent findParentById(int parentId) {
        String sql = "SELECT * FROM parents WHERE parentId=?";
        RowMapper<Parent> rowMapper = new BeanPropertyRowMapper<>(Parent.class);
        Parent myParent = jdbcTemplate.queryForObject(sql, rowMapper, parentId);
        return myParent;
    };

    @Override
    public Parent sellectLastParent() { 
        String sql = "SELECT * FROM parents ORDER BY parentId DESC LIMIT 1";
        RowMapper<Parent> rowMapper = new BeanPropertyRowMapper<>(Parent.class);
        Parent myParent = jdbcTemplate.queryForObject(sql, rowMapper);
        return myParent;
    };

    @Override
    public List<Parent> viewAllParents() {
        String sql = "SELECT * FROM parents";
        RowMapper<Parent> rowMapper = new BeanPropertyRowMapper<>(Parent.class);
        return jdbcTemplate.query(sql, rowMapper);
    };

    // UPDATE
    @Override
    public Parent editParent(int parentId, Parent myParent) {
        String sql = "UPDATE parents SET momName=?, dadName=?, phoneNumber=?, address=? WHERE parentId=?";
        jdbcTemplate.update(sql, myParent.getMomName(), myParent.getDadName(), myParent.getPhoneNumber(),
                myParent.getAddress(), parentId);
        return null;
    };

    // DELETE
    @Override
    public boolean deleteParent(int parentId) {
        String sql = "DELETE FROM parents WHERE parentId=?";
        return jdbcTemplate.update(sql, parentId) >= 0;
    };
}
