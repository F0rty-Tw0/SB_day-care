package com.example.day_care.Service.ParentService;

import java.util.List;

import com.example.day_care.Model.Parent;

public interface InterfaceParentService {
    // CREATE
    public Parent addParent(Parent myParent);

    // READ
    public Parent findParentById(int parentId);

    public Parent sellectLastParent();

    public List<Parent> viewAllParents();

    // UPDATE
    public Parent editParent(int parentId, Parent myParent);

    // DELETE
    public boolean deleteParent(int parentId);
}
