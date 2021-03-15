package com.example.day_care.Repository.KidRepository;

import java.util.List;

import com.example.day_care.Model.Kid;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class KidCRUD implements InterfaceKid {
    @Autowired
    JdbcTemplate jdbcTemplate;

    // CREATE
    @Override
    public Kid addKid(Kid myKid) {
        String sql = "INSERT INTO kids(kidName, kidAge, kidParentId) VALUES(?,?,?)";
        jdbcTemplate.update(sql, myKid.getKidName(), myKid.getKidAge(), myKid.getKidParentId());
        return null;
    };

    // READ
    @Override
    public Kid findKidById(int kidId) {
        String sql = "SELECT * FROM kids WHERE kidId=?";
        RowMapper<Kid> rowMapper = new BeanPropertyRowMapper<>(Kid.class);
        Kid myKid = jdbcTemplate.queryForObject(sql, rowMapper, kidId);
        return myKid;
    };

    @Override
    public List<Kid> viewAllKids() {
        String sql = "SELECT * FROM kids";
        RowMapper<Kid> rowMapper = new BeanPropertyRowMapper<>(Kid.class);
        return jdbcTemplate.query(sql, rowMapper);
    };

    // UPDATE
    @Override
    public Kid editKid(int kidId, Kid myKid) {
        String sql = "UPDATE kids SET kidName, kidAge, kidParentId WHERE kidId=?";
        jdbcTemplate.update(sql, myKid.getKidName(), myKid.getKidAge(), myKid.getKidParentId(), kidId);
        return null;
    };

    // DELETE
    @Override
    public boolean deleteKid(int kidId) {
        String sql = "DELETE FROM kids WHERE kidId=?";
        return jdbcTemplate.update(sql, kidId) >= 0;
    };

}
