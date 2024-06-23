package com.gpro.consulting.ordre.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Calendar;

@MappedSuperclass
@Data
public class BaseEntity {

    public BaseEntity() {
    }

    @Column(name = "creationDate")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Calendar creationDate;

    @Column(name = "modificationDate")
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Calendar modificationDate;

    @Column(name = "deletionDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar deletionDate;

    @Column(name = "creator_identifier")
    private String creatorIdentifier;

    @Column(name = "latest_updater_identifier")
    private String latestUpdaterId;

    @Column(name = "version")
    private Long version = 0L;

    @Column(name = "archived")
    private boolean archived = false;

    @PreRemove
    private void beforeDelete() {
        this.deletionDate = Calendar.getInstance();
    }

    @PrePersist
    private void OnPrePersist() {
        this.creationDate = Calendar.getInstance();
        this.version = 0L;
    }

    @PreUpdate
    private void OnPreUpdate() {
        this.modificationDate = Calendar.getInstance();
        this.version++;
    }
}
