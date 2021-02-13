package com.HospitalMangagmentSystem.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * The persistent class for the attachment database table.
 *
 */
@Entity
@NamedQuery(name="ImageAttachment.findAll", query="SELECT m FROM ImageAttachment m")
@JsonIgnoreProperties("imageatt")
public class ImageAttachment implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int imageid;

    private String name;


    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "username", nullable = false)
    private User user;



    public ImageAttachment() {
    }






    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }



    public int getImageid() {
        return imageid;
    }



    public void setImageid(int imageid) {
        this.imageid = imageid;
    }

}