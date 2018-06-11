package com.husky.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.Date;

@Entity
@Table(name = "floatingHolidays")
public class FloatingHoliday {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "floatingId")
    private long id;

    private Date date;
    private int hours;
    @Enumerated(EnumType.STRING)
    private Gender userGender;
    private String hasChildren;
    private String description;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public Gender getUserGender() { return userGender; }

    public void setUserGender(Gender userGender) { this.userGender = userGender; }

    public String getHasChildren() { return hasChildren; }

    public void setHasChildren(String hasChildren) { this.hasChildren = hasChildren; }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}