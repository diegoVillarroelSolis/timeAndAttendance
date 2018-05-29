package com.husky.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "request")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "request_id")
    private long id;

    private String name;
    private LocalDateTime dateSendRequest;

    private String status;

    private LocalDateTime floatingHolidayDateRequest;

    @ManyToOne
    @JoinColumn(name = "person_id")
    @JsonBackReference
    private User user;


    @ManyToOne
    @JoinColumn(name = "floating_id")

    @JsonBackReference
    private FloatingHoliday floatingHoliday;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDateSendRequest() {
        return dateSendRequest;
    }

    public void setDateSendRequest(LocalDateTime dateSendRequest) {
        this.dateSendRequest = dateSendRequest;
    }


    public LocalDateTime getFloatingHolidayDateRequest() {
        return floatingHolidayDateRequest;
    }

    public void setFloatingHolidayDateRequest(LocalDateTime floatingHolidayDateRequest) {
        this.floatingHolidayDateRequest = floatingHolidayDateRequest;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public FloatingHoliday getFloatingHoliday() {
        return floatingHoliday;
    }

    public void setFloatingHoliday(FloatingHoliday floatingHoliday) {
        this.floatingHoliday = floatingHoliday;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}