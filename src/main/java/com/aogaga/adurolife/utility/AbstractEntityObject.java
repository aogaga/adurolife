package com.aogaga.adurolife.utility;

import javax.persistence.*;

import java.util.Date;
@MappedSuperclass
public class AbstractEntityObject implements Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Version
    private Integer version;

    private Date createdAt;
    private Date updatedAt;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Date getCreatedAt() {
        return createdAt;
    }


    public Date getUpdatedAt() {
        return updatedAt;
    }


    @PreUpdate
    public void updateTimeStamps() {
        updatedAt = new Date();
    }

    @PrePersist
    public void createdTimeStamps() {
        if (createdAt==null) {
            createdAt = new Date();
        }
    }

}