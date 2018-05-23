package com.gmail.grind3x.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Objects;

@XmlRootElement(name = "apartment")
@XmlType(propOrder = {"numberOfRooms", "address", "floor", "cost"})
public class Apartment {
    private int numberOfRooms;
    private String address;
    private int floor;
    private double cost;

    public Apartment() {
    }

    public Apartment(int numberOfRooms, String address, int floor, double cost) {
        this.numberOfRooms = numberOfRooms;
        this.address = address;
        this.floor = floor;
        this.cost = cost;
    }

    @XmlElement
    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    @XmlElement
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @XmlElement
    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    @XmlElement
    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Apartment apartment = (Apartment) o;
        return numberOfRooms == apartment.numberOfRooms &&
                floor == apartment.floor &&
                Double.compare(apartment.cost, cost) == 0 &&
                Objects.equals(address, apartment.address);
    }

    @Override
    public int hashCode() {

        return Objects.hash(numberOfRooms, address, floor, cost);
    }

    @Override
    public String toString() {
        return "com.gmail.grind3x.model.Apartment{" +
                "numberOfRooms=" + numberOfRooms +
                ", address='" + address + '\'' +
                ", floor=" + floor +
                ", cost=" + cost +
                '}';
    }
}
