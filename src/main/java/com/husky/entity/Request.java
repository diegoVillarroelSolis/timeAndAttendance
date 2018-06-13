package com.husky.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.awt.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Luis on 03/06/2018.
 */
@Entity
public class Request {

    private Long id;
    private User user;
    private FloatingHoliday floatingHoliday;

    private Date dateSend;
    @Value("${some.key:Pending}")
    private String statusRequest;
    private String descriptionRequest;
    public Request() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "userId")
    @JsonIgnore
    public User getUser() {
        return user;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public Date getDateSend() {
        return dateSend;
    }

    public void setDateSend(Date dateSend) {
        this.dateSend = dateSend;
    }

    public String getStatusRequest() {
        return statusRequest;
    }

    public void setStatusRequest(String statusRequest) {
        this.statusRequest = statusRequest;
    }

    //@ManyToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "floatingHoliday_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "floatingHoliday_id", referencedColumnName = "id", nullable = false, unique = true)
    @JsonIgnore
    public FloatingHoliday getFloatingHoliday() {
        return floatingHoliday;
    }

    public void setFloatingHoliday(FloatingHoliday floatingHoliday) {
        this.floatingHoliday = floatingHoliday;
    }

    public String getDescriptionRequest() {
        return descriptionRequest;
    }

    public void setDescriptionRequest(String descriptionRequest) {
        this.descriptionRequest = descriptionRequest;
    }
}
