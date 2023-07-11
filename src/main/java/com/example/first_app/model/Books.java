package com.example.first_app.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "product")
@Data
@ToString
@FieldDefaults (level = AccessLevel.PRIVATE)
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "BookId")
    int id;

    @Column(name = "BookName")
    String bookName;

    @Column(name = "TimeStamp")
    Timestamp time;

    @Column(name = "Cost")
    long cost;
}
