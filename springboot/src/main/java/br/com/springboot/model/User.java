package br.com.springboot.model;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String username;

}
