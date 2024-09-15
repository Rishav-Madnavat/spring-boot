package com.jeriv.cabbook.models;

import java.sql.Timestamp;
import java.time.Instant;

import lombok.ToString;

@ToString
public class BaseEntity {

    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Boolean isActive = Boolean.FALSE;
    
    public BaseEntity() {
        this.createdAt = Timestamp.from(Instant.now());
        this.updatedAt = Timestamp.from(Instant.now());
        this.isActive = Boolean.TRUE;
    }
}
