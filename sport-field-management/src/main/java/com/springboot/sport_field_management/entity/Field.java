package com.springboot.sport_field_management.entity;

import com.springboot.sport_field_management.enums.VenueType;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "field")
public class Field {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "sportType")
    private String sportType;
    @Column(name = "venueType")
    private VenueType venueType;
    @Column(name = "pricePerHour")
    private long pricePerHour;
    @OneToMany(mappedBy = "field")
    private List<Reservation> reservations = new ArrayList<>();

    public Field() {
    }

    public Field(String name, String sportType, VenueType venueType, long pricePerHour, List<Reservation> reservations) {
        this.name = name;
        this.sportType = sportType;
        this.venueType = venueType;
        this.pricePerHour = pricePerHour;
        this.reservations = reservations;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSportType() {
        return sportType;
    }

    public void setSportType(String sportType) {
        this.sportType = sportType;
    }

    public VenueType getVenueType() {
        return venueType;
    }

    public void setVenueType(VenueType venueType) {
        this.venueType = venueType;
    }

    public long getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(long pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    @Override
    public String toString() {
        return "Field{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sportType='" + sportType + '\'' +
                ", venueType=" + venueType +
                ", pricePerHour=" + pricePerHour +
                ", reservations=" + reservations +
                '}';
    }
}