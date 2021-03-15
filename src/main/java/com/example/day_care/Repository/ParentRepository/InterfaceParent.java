package com.example.day_care.Repository.ParentRepository;

import java.util.List;

import com.example.day_care.Model.Parent;

public interface InterfaceParent {
    // CREATE
    public Parent addParent(Parent myParent);

    // READ
    public Parent findParentById(int parrentId);

    public Parent sellectLastParent();

    public List<Parent> viewAllParents();

    // UPDATE
    public Parent editParent(int parrentId, Parent myParent);

    // DELETE
    public boolean deleteParent(int parrentId);
}
