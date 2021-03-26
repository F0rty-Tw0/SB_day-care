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
        String sql = "INSERT INTO xgroups(grpName) VALUES(?)";
        jdbcTemplate.update(sql, myGroup.getGrpName());
        return null;
    };

    // READ
    @Override
    public Group findGroupById(int grpId) {
        String sql = "SELECT * FROM xgroups WHERE grpId=?";
        RowMapper<Group> rowMapper = new BeanPropertyRowMapper<>(Group.class);
        Group myGroup = jdbcTemplate.queryForObject(sql, rowMapper, grpId);
        return myGroup;
    };

    @Override
    public Group sellectLastGroup() {
        String sql = "SELECT * FROM xgroups ORDER BY grpId DESC LIMIT 1";
        RowMapper<Group> rowMapper = new BeanPropertyRowMapper<>(Group.class);
        Group myGroup = jdbcTemplate.queryForObject(sql, rowMapper);
        return myGroup;
    };

    @Override
    public List<Group> viewAllGroups() {
        String sql = "SELECT * FROM xgroups";
        RowMapper<Group> rowMapper = new BeanPropertyRowMapper<>(Group.class);
        return jdbcTemplate.query(sql, rowMapper);
    };

    // UPDATE
    @Override
    public Group editGroup(int grpId, Group myGroup) {
        String sql = "UPDATE xgroups SET grpName=? WHERE grpId=?";
        jdbcTemplate.update(sql, myGroup.getGrpName(), grpId);
        return null;
    };

    // DELETE
    @Override
    public boolean deleteGroup(int grpId) {
        String updateEmp = "UPDATE employees SET empGrpId = 2 WHERE empGrpId=?";
        String updateKids = "UPDATE kids SET kidGrpId = 2 WHERE kidGrpId=?";
        String sql = "DELETE FROM xgroups WHERE grpId=?";
        jdbcTemplate.update(updateEmp, grpId);
        jdbcTemplate.update(updateKids, grpId);
        return jdbcTemplate.update(sql, grpId) >= 0;
    };

}
