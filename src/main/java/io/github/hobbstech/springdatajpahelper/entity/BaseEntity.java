package io.github.hobbstech.springdatajpahelper.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@Data
public class BaseEntity {

    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date dateCreated;

    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date dateLastUpdated;

    @Version
    private int version;

}
