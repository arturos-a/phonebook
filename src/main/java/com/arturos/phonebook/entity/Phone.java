package com.arturos.phonebook.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Phone {
    @Id
    @GeneratedValue
    Long phoneId;
    PhoneType type;
    String phone;
    public Phone(String phone) {
        this.setPhone(phone);
    }
    public Phone(Long id, String phone){
        this.phoneId = id;
        this.phone = phone;
    }
    public Phone() {

    }

}
