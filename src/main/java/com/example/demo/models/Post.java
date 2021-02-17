package com.example.demo.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
// @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
// property="id")
public class Post {

    @Id
    private Integer id;
    private LocalDateTime postDate;

    @ManyToOne
    @JoinColumn(name = "userid", insertable = false,  updatable = false)
    private User user;
    private String details;

    private Integer userid;

    public Post() {
    }

    public Post(Integer id, LocalDateTime postDate, User user, String details) {
        this.id = id;
        this.postDate = postDate;
        this.user = user;
        this.details = details;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getPostDate() {
        return this.postDate;
    }

    public void setPostDate(LocalDateTime postDate) {
        this.postDate = postDate;
    }

    @JsonBackReference
    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDetails() {
        return this.details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }


}
