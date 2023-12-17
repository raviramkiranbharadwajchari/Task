package com.Task.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String dateOfBirth;
    private String gender;
    private String address;
    private String city;
    private String state;
    private String loginId;
    private String password;

    public Employee(String name, String dateOfBirth, String gender, String address, String city, String state, String loginId, String password) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.address = address;
        this.city = city;
        this.state = state;
        this.loginId = loginId;
        this.password = password;
    }
}
