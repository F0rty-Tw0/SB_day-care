package com.example.day_care.Service.ParentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.example.day_care.Model.Parent;
import com.example.day_care.Repository.ParentRepository.InterfaceParent;

@Service
public class ParentServiceCRUD implements InterfaceParentService {
    @Autowired
    InterfaceParent interfaceParent;

    // CREATE
    @Override
    public Parent addParent(Parent myParent) {
        return interfaceParent.addParent(myParent);
    };

    // READ
    @Override
    public Parent findParentById(int parentId) {
        return interfaceParent.findParentById(parentId);
    };

    @Override
    public Parent sellectLastParent() {
        return interfaceParent.sellectLastParent();
    };

    @Override
    public List<Parent> viewAllParents() {
        return interfaceParent.viewAllParents();
    };

    // UPDATE
    @Override
    public Parent editParent(int parentId, Parent myParent) {
        return interfaceParent.editParent(parentId, myParent);
    };

    // DELETE
    @Override
    public boolean deleteParent(int parentId) {
        return interfaceParent.deleteParent(parentId);
    };
}
