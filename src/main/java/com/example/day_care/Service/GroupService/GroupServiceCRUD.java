package com.example.day_care.Service.GroupService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.example.day_care.Model.Group;
import com.example.day_care.Repository.GroupRepository.InterfaceGroup;

@Service
public class GroupServiceCRUD implements InterfaceGroupService {
    @Autowired
    InterfaceGroup interfaceGroup;

    // CREATE
    @Override
    public Group addGroup(Group myGroup) {
        return interfaceGroup.addGroup(myGroup);
    };

    // READ
    @Override
    public Group findGroupById(int grpId) {
        return interfaceGroup.findGroupById(grpId);
    };

    @Override
    public Group sellectLastGroup() {
        return interfaceGroup.sellectLastGroup();
    };

    @Override
    public List<Group> viewAllGroups() {
        return interfaceGroup.viewAllGroups();
    };

    // UPDATE
    @Override
    public Group editGroup(int grpId, Group myGroup) {
        return interfaceGroup.editGroup(grpId, myGroup);
    };

    // DELETE
    @Override
    public boolean deleteGroup(int grpId) {
        return interfaceGroup.deleteGroup(grpId);
    };
}
