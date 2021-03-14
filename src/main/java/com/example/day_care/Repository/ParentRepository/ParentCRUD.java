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
    public Parent findParentById(int parrentId) {
        String sql = "SELECT * FROM parents WHERE parrentId=?";
        RowMapper<Parent> rowMapper = new BeanPropertyRowMapper<>(Parent.class);
        Parent myParent = jdbcTemplate.queryForObject(sql, rowMapper, parrentId);
        return myParent;
    };

    public List<Parent> viewAllParents() {
        String sql = "SELECT * FROM parents";
        RowMapper<Parent> rowMapper = new BeanPropertyRowMapper<>(Parent.class);
        return jdbcTemplate.query(sql, rowMapper);
    };

    // UPDATE
    @Override
    public Parent editParent(int parrentId, Parent myParent) {
        return null;
    };

    // DELETE
    @Override
    public boolean deleteParent(int parrentId) {
        String sql = "DELETE FROM parents WHERE parrentId=?";
        return jdbcTemplate.update(sql, parrentId) >= 0;
    };
}
