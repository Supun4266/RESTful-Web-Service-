package com.learn.SpringBootCrud.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ValueGenerationType;

@Entity(name = "customer")
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id" )

    private long id;
    @NotEmpty(message = "First Name is required")
    @Size(min = 5, message = "First Name should br at least 5 characters")
    @Column(name = "first_name")
    private String firstName;
    @NotEmpty(message = "First Name is required")
    @Size(min = 5, message = "First Name should br at least 5 characters")
    @Column(name ="last_name")
    private String lastName;
    @NotEmpty(message = "Email is required")
    @Email(message = "pls enter validate email")
    @Column(name ="email")
    private String email;
    @Column(name ="phone")
    private String phone;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
