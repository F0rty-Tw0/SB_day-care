package com.example.day_care.Service.KidService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.example.day_care.Model.Kid;
import com.example.day_care.Repository.KidRepository.InterfaceKid;

@Service
public class KidServiceCRUD implements InterfaceKidService {
    @Autowired
    InterfaceKid interfaceKid;

    // CREATE
    @Override
    public Kid addKid(Kid myKid) {
        return interfaceKid.addKid(myKid);
    };

    // READ
    @Override
    public Kid findKidById(int kidId) {
        return interfaceKid.findKidById(kidId);
    };

    @Override
    public List<Kid> viewAllKids() {
        return interfaceKid.viewAllKids();
    };

    // UPDATE
    @Override
    public Kid editKid(int kidId, Kid myKid) {
        return interfaceKid.editKid(kidId, myKid);
    };

    // DELETE
    @Override
    public boolean deleteKid(int kidId) {
        return interfaceKid.deleteKid(kidId);
    };
}
