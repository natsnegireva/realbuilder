package com.geekbrains.realbuilder.hibernate5.model;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "students")
@Data
@NamedQueries({
        @NamedQuery(name = "countAll", query = "select count(s) from Students s"),
        @NamedQuery(name = "findByName", query = "from Students s where s.name = :name"),
        @NamedQuery(name = "deleteById", query = "delete from Students s where s.id = :id")
})
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "mark")
    private Integer mark;

    public Students() {
    }

    public Students(Long id, String name, Integer mark) {
        this.id = id;
        this.name = name;
        this.mark = mark;
    }

    public Students(String name, Integer mark) {
        this.name = name;
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Student {id= " + id + ", name= " + name + ", mark= " + mark + "}";
    }

}
