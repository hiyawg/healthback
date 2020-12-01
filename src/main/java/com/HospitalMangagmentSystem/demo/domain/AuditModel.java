package com.HospitalMangagmentSystem.demo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(
        value={"CreatedAt", "UpdatedAt",},
        allowGetters = true
)

public class AuditModel implements Serializable {
    

	@Temporal(TemporalType.TIMESTAMP)
    @Column(name="CreatedAt", nullable = false, updatable = false)
    @CreatedDate
    private Date CreatedAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="UpdatedAt" , nullable = false, updatable = false)
    @CreatedDate
    private Date UpdatedAt;

    public Date getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(Date createdAt) {
        CreatedAt = createdAt;
    }

    public Date getUpdatedAt() {
        return UpdatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        UpdatedAt = updatedAt;
    }
}

