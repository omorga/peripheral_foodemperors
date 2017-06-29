package com.isssr.foodemperors.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by marco on 19/05/17.
 */
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty
    private String id;

    @JsonProperty
    @NotNull
    private String name;

    @JsonProperty
    @NotNull
    private String surname;

    @JsonProperty
    @NotNull
    private String role;

    @JsonProperty
    @NotNull
    private String username;

    @JsonProperty
    private String date;

    @JsonProperty
    @NotNull
    private String password;

    @JsonProperty
    @Embedded
    private List<String> qualifications;

    @JsonProperty
    private String location;

    @JsonProperty
    @Embedded
    private List<String> skills;

    @JsonProperty
    private String note;

    public User() {

    }

    public User(String name, String surname, String role, String username, String date, String password,
                ArrayList<String> qualifications, String location, ArrayList<String> skills, String note){
        this.name = name;
        this.surname = surname;
        this.role = role;
        this.username = username;
        this.date = date;
        this.password = password;
        this.qualifications = qualifications;

        this.location = location;
        this.skills = skills;
        this.note = note;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public List<String> getQualifications() {
        return qualifications;
    }

    public void setQualifications(ArrayList<String> qualifications) {
        this.qualifications = qualifications;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}