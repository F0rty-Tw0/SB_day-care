package com.example.day_care.Service.KidService;

import java.util.List;

import com.example.day_care.Model.Kid;

public interface InterfaceKidService {
    // CREATE
    public Kid addKid(Kid myKid);

    // READ
    public Kid findKidById(int kidId);

    public List<Kid> findKidByParentId(int kidParentId);
    
    public List<Kid> findKidByGrpId(int kidGrpId);

    public List<Kid> viewAllKids();

    // UPDATE
    public Kid editKid(int kidId, Kid myKid);

    // DELETE
    public boolean deleteKid(int kidId);
}
