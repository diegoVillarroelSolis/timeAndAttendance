package com.husky.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "floating_holidays")
public class FloatingHoliday {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "floating_id")
    private long id;

    private LocalDateTime date;
    @Column(name = "hours")
    private int hours;
    private String user_gender;
    private String has_children;
    private String name;

    @OneToMany(mappedBy = "floatingHoliday")
    private Set<Request> requests = new HashSet<Request>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public String getUser_gender() {
        return user_gender;
    }

    public void setUser_gender(String user_gender) {
        this.user_gender = user_gender;
    }

    public String getHas_children() {
        return has_children;
    }

    public void setHas_children(String has_children) {
        this.has_children = has_children;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Request> getRequests() {
        return requests;
    }

    public void setRequests(Set<Request> requests) {
        this.requests = requests;
    }
}