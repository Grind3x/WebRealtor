package com.gmail.grind3x.model;

import java.util.ArrayList;
import java.util.List;

public class Filter {

    public static List<Apartment> getApartmentsByAllParameters(int numberOfRooms, String address, int floor,
                                                               double low, double high, List<Apartment> apartments) {
        if (!address.equals("")) {
            Apartment apartment = Filter.getApartmentByAddress(address, apartments);
            apartments = new ArrayList<>();
            apartments.add(apartment);
        }
        if (numberOfRooms > 0) {
            apartments = Filter.getApartmentsByNumberOfRooms(numberOfRooms, apartments);
        }

        if (floor > 0) {
            apartments = Filter.getApartmentsByFloor(floor, apartments);
        }

        if (low >= 0 & high >= 0) {
            apartments = Filter.getApartmentsByCostRange(low, high, apartments);
        }

        return apartments;
    }

    public static List<Apartment> getApartmentsByCostRange(double low, double high, List<Apartment> apartments) {
        List<Apartment> list = new ArrayList<>();
        if (low == 0 & high > 0) {
            for (Apartment apartment : apartments) {
                if (apartment.getCost() <= high) {
                    list.add(apartment);
                }
            }
            return list;
        }

        if (low > 0 & high == 0) {
            for (Apartment apartment : apartments) {
                if (apartment.getCost() >= low) {
                    list.add(apartment);
                }
            }
            return list;
        }

        if ((low > 0 & high > 0) && (low < high)) {
            for (Apartment apartment : apartments) {
                if (apartment.getCost() >= low && apartment.getCost() <= high) {
                    list.add(apartment);
                }
            }
            return list;
        }
        return apartments;
    }

    public static Apartment getApartmentByAddress(String address, List<Apartment> apartments) {
        if (address == null) {
            throw new IllegalArgumentException();
        }
        for (Apartment apartment : apartments) {
            if (address.equals(apartment.getAddress())) {
                return apartment;
            }
        }
        return null;
    }

    public static List<Apartment> getApartmentsByFloor(int floor, List<Apartment> apartments) {
        List<Apartment> list = new ArrayList<>();
        for (Apartment apartment : apartments) {
            if (apartment.getFloor() == floor) {
                list.add(apartment);
            }
        }
        return list;
    }

    public static List<Apartment> getApartmentsByNumberOfRooms(int numberOfRooms, List<Apartment> apartments) {
        if (numberOfRooms == 0) {
            throw new IllegalArgumentException("Number of rooms can't be 0!");
        }
        List<Apartment> list = new ArrayList<>();
        for (Apartment apartment : apartments) {
            if (apartment.getNumberOfRooms() == numberOfRooms) {
                list.add(apartment);
            }
        }
        return list;
    }
}
