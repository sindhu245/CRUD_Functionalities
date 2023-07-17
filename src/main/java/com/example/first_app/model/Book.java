package com.example.first_app.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "product")
@Data
@ToString
@FieldDefaults (level = AccessLevel.PRIVATE)
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "BookId")
    int id;

    @Column(name = "BookName")
    String bookName;

    @Column(name = "Ttl")
    Integer ttl;

    @Column(name = "TimeStamp")
    Timestamp expiryTime;
}
