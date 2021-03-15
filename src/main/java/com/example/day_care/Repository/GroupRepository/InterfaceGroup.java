package com.example.day_care.Repository.GroupRepository;

import java.util.List;

import com.example.day_care.Model.Group;

public interface InterfaceGroup {

    // CREATE
    public Group addGroup(Group myGroup);

    // READ
    public Group findGroupById(int grpId);

    public Group sellectLastGroup();

    public List<Group> viewAllGroups();

    // UPDATE
    public Group editGroup(int grpId, Group myGroup);

    // DELETE
    public boolean deleteGroup(int grpId);

}
