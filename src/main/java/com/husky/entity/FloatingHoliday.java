package com.husky.entity;

import javax.persistence.*;
import java.util.*;

/**
 * Created by Luis on 03/06/2018.
 */
@Entity
public class FloatingHoliday {

    private Long id;
    private Date date;
    private int  hour;

    private Gender userGender;
    private boolean userParent;
    private String description;

    private Collection<Request> requests;
    public FloatingHoliday() {
    }

    public FloatingHoliday(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    public Long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public int getHour() {
        return hour;
    }

    @Enumerated(EnumType.STRING)
    public Gender getUserGender() {
        return userGender;
    }

    public boolean isUserParent() {
        return userParent;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public void setUserGender(Gender userGender) {
        this.userGender = userGender;
    }

    public void setUserParent(boolean userParent) {
        this.userParent = userParent;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @OneToMany(mappedBy = "floatingHoliday")
    public Collection<Request> getRequests() {
        return requests;
    }

    public void setRequests(Collection<Request> requests) {
        this.requests = requests;
    }
}
