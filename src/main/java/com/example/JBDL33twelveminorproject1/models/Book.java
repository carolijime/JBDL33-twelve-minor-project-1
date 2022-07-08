package com.example.JBDL33twelveminorproject1.models;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int cost;

    //because it is an enum, we use this. If value is not specified, it will use the default one, which is 'ordinal'
    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    @ManyToOne
    @JoinColumn
    private Author author;

    //one student can have multiple books
    //joincolumn will create a foreign key (NOTE: in student's class we have to make a by-directional relationship for it to work
    //it will name the field in the DB by default with [field name] + [other table id column name] (e.x: student_id)
    //@JoinColumn(name="name") in case we would like to join by another column that is not the id field of the table
    @ManyToOne
    @JoinColumn
    private Student student;

//    private Student tempColumn; //just for explaining back reference

    @OneToMany(mappedBy = "my_book")
    private List<Transaction> transactionList;

    //automatically will add the creation date to the record
    @CreationTimestamp
    private Date createdOn;

    //automatically will add/update the update time to the record
    @UpdateTimestamp
    private Date updatedOn;
}
