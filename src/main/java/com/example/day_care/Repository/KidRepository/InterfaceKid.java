package com.example.day_care.Repository.KidRepository;

import java.util.List;

import com.example.day_care.Model.Kid;

public interface InterfaceKid {
    // CREATE
    public Kid addKid(Kid myKid);

    // READ
    public Kid findKidById(int kidId);

    public List<Kid> viewAllKids();

    // UPDATE
    public Kid editKid(int kidId, Kid myKid);

    // DELETE
    public boolean deleteKid(int kidId);

}
