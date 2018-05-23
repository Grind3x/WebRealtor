package com.gmail.grind3x.model;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Apartments {
    @XmlElement(name = "apartment")
    private List<Apartment> apartments = new ArrayList<>();

    public Apartments() {
    }

    public void addApartment(Apartment apartment) {
        if (apartment == null) {
            throw new IllegalArgumentException();
        }
        apartments.add(apartment);
    }

    public List<Apartment> getApartments() {
        return apartments;
    }

    public List<Apartment> getApartmentsByNumberOfRooms(int numberOfRooms) {
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

    public List<Apartment> getApartmentsByFloor(int floor) {
        List<Apartment> list = new ArrayList<>();
        for (Apartment apartment : apartments) {
            if (apartment.getFloor() == floor) {
                list.add(apartment);
            }
        }
        return list;
    }

    public Apartment getApartmentByAddress(String address) {
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

    public List<Apartment> getApartmentsByCostRange(double low, double high) {
        if (low > high) {
            throw new IllegalArgumentException("The upper parameter can not be less than the lower!");
        }
        List<Apartment> list = new ArrayList<>();
        for (Apartment apartment : apartments) {
            if ((apartment.getCost() >= low) && (apartment.getCost() <= high)) {
                list.add(apartment);
            }
        }
        return list;
    }

    public boolean changeApartmentCost(String address, double cost) {
        if (address == null) {
            throw new IllegalArgumentException("adress is null");
        }

        Apartment apartment;
        if ((apartment = getApartmentByAddress(address)) != null) {
            apartment.setCost(cost);
            return true;
        }
        return false;
    }
    public boolean removeApartment(String address) {
        if (address == null) {
            throw new IllegalArgumentException("address is null!");
        }

        for (int i = 0; i < apartments.size(); i++) {
            if (apartments.get(i).getAddress().equals(address)) {
                apartments.remove(i);
                return true;
            }
        }
        return false;
    }

    public void toXML(File file) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Apartments.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(this, file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static Apartments fromXML(String xmlString) {
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(Apartments.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return (Apartments) unmarshaller.unmarshal(new StringReader(xmlString));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString() {
        return "com.gmail.grind3x.model.Apartments{" +
                "apartments=" + apartments +
                '}';
    }
}
