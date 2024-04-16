package com.example.library.entites;
import jakarta.persistence.*;



@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    @Column(length = 50, nullable = false)
    private String street;
    @Column(length = 50, nullable = false)
    private String postalCode;
    @Column(length = 50, nullable = false)
    private String city;

    public Address (){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


}
