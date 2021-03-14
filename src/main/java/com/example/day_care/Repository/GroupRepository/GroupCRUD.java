package com.example.day_care.Repository.GroupRepository;

import java.util.List;

import com.example.day_care.Model.Group;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class GroupCRUD implements InterfaceGroup {
    @Autowired
    JdbcTemplate jdbcTemplate;

    // CREATE
    @Override
    public Group addGroup(Group myGroup) {
        String sql = "INSERT INTO xGroups(grpName) VALUES(?)";
        jdbcTemplate.update(sql, myGroup.getGrpName());
        return null;
    };

    // READ
    @Override
    public Group findGroupById(int grpId) {
        String sql = "SELECT * FROM xGroups WHERE grpId=?";
        RowMapper<Group> rowMapper = new BeanPropertyRowMapper<>(Group.class);
        Group myGroup = jdbcTemplate.queryForObject(sql, rowMapper, grpId);
        return myGroup;
    };

    public List<Group> viewAllGroups() {
        String sql = "SELECT * FROM xGroups";
        RowMapper<Group> rowMapper = new BeanPropertyRowMapper<>(Group.class);
        return jdbcTemplate.query(sql, rowMapper);
    };

    // UPDATE
    @Override
    public Group editGroup(int grpId, Group myGroup) {
        return null;
    };

    // DELETE
    @Override
    public boolean deleteGroup(int grpId) {
        String sql = "DELETE FROM xGroups WHERE grpId=?";
        return jdbcTemplate.update(sql, grpId) >= 0;
    };

}
