package com.husky.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "floatingHolidays")
public class FloatingHoliday {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "floatingId")
    private Long id;

    private Date date;
    private int hours;
    @Enumerated(EnumType.STRING)
    private Gender userGender;
    private String hasChildren;
    private String description;


    public FloatingHoliday(){

    }
    public FloatingHoliday(Date date, int hours, Gender userGender, String hasChildren, String description) {
        this.date = date;
        this.hours = hours;
        this.userGender = userGender;
        this.hasChildren = hasChildren;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Gender getUserGender() {
        return userGender;
    }

    public void setUserGender(Gender userGender) {
        this.userGender = userGender;
    }

    public String getHasChildren() {
        return hasChildren;
    }

    public void setHasChildren(String hasChildren) {
        this.hasChildren = hasChildren;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}