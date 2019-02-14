package io.github.hobbstech.springdatajpahelper.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Data
public class BaseEntity implements Serializable {

    @Temporal(TemporalType.TIMESTAMP)
    @Column
    @CreationTimestamp
    private Date dateCreated;

    @Temporal(TemporalType.TIMESTAMP)
    @Column
    @UpdateTimestamp
    private Date dateLastUpdated;

    @Version
    private int version;

}
