package com.andybrook.model.customer;

public class Owner {

    private Long id;
    private String compagnyName;
    private String firstName;
    private String lastName;
    private String email;

    public Owner(String compagnyName, String firstName, String lastName, String email) {
        this.id = null;
        this.compagnyName = compagnyName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Owner(Long id, String compagnyName, String firstName, String lastName, String email) {
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

    public String getCompagnyName() {
        return compagnyName;
    }

    public void setCompagnyName(String compagnyName) {
        this.compagnyName = compagnyName;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Owner{");
        sb.append("id=").append(id);
        sb.append(", compagnyName='").append(compagnyName).append('\'');
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
