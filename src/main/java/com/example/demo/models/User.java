package com.example.demo.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;




@Entity
// @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="id")
public class User {

    @Id
    private Integer id;
    private String firstname;
    private String lastname;

    @ManyToOne
    @JoinColumn(name="locationid", insertable=false, updatable=false)
    private Location location;

    private Integer locationid;

    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Post> posts;


    public User() {
    }

    public User(Integer id, String firstname, String lastname, Location location, String email) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.location = location;
        this.email = email;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getfirstname() {
        return this.firstname;
    }

    public void setfirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @JsonBackReference
    public Location getLocation() {
        return this.location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @JsonManagedReference
    public List<Post> getPosts() {
        return this.posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public Integer getLocationid() {
        return this.locationid;
    }

    public void setLocationid(Integer locationid) {
        this.locationid = locationid;
    }

}
