package com.andybrook.dao.jpa.entity.customer;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Table(name = "owner")
public class OwnerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "compagnyname", nullable = false)
    private String compagnyName;

    @Column(name = "fistname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Email
    @Column(name = "email")
    private String email;

    public OwnerEntity() {}

    public OwnerEntity(Long id, String compagnyName, String firstName, String lastName, String email) {
        this.id = id;
        this.compagnyName = compagnyName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompagnyName() {
        return compagnyName;
    }

    public OwnerEntity setCompagnyName(String compagnyName) {
        this.compagnyName = compagnyName;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
