package com.husky.entity;

import javax.persistence.*;
import java.util.*;

@Entity
public class User {

    private Long id;
    private String name;
    private String lastname;
    private Gender gender;
    private boolean isParent;

    private Set<Request> requests;

    public User() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userId")
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }
    @Enumerated(EnumType.STRING)
    public Gender getGender() {
        return gender;
    }

    public boolean isIsParent() {
        return isParent;
    }
    //@OneToMany(mappedBy = "user")
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public Set<Request> getRequests() {
        return requests;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setIsParent(boolean isParent) {
        this.isParent = isParent;
    }

    public void setRequests(Set<Request> requests) {
        this.requests = requests;
    }
}