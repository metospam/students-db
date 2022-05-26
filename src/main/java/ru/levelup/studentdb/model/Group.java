package ru.levelup.studentdb.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "groups", schema = "edu_schema")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "groups_id_seq")
    @SequenceGenerator(name = "groups_id_seq", schema = "edu_schema", allocationSize = 1)
    private Long id;

    @Column(name = "groupname")
    private String name;

    @ManyToMany
    private List<Student> students;

    public Group(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return name;
    }
}