package com.current.bank.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@MappedSuperclass
@ToString
@EqualsAndHashCode(of = {"id"})
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    protected Date createdAt;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    protected Date updatedAt;
}
