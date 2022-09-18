package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class HotelResource {


    static HotelResource SingleInstance = new HotelResource();

    CustomerService customerService = CustomerService.getSingleInstance();

    ReservationService reservationService = ReservationService.getSingleInstance();

    public HotelResource() {
    }

    public static HotelResource getSingleInstance() {
        return SingleInstance;
    }

    public Customer getCustomer(String email){
        return  customerService.getCustomer(email);
    }

    public void createACustomer(String email, String firstName, String lastName){
        customerService.addCustomer(email, firstName, lastName);
    }

    public IRoom getRoom(String roomNumber){
        return reservationService.getARoom(roomNumber);
    }

    public Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date checkOutDate){
        return reservationService.reserveARoom(getCustomer(customerEmail), room, checkInDate, checkOutDate);
    }

    public Collection<Reservation> getCustomersReservations(String customerEmail){
        Customer customer = getCustomer(customerEmail);

        if(customer == null){
            return Collections.emptyList();
        }else{
            reservationService.getCustomersReservation(getCustomer(customerEmail));
        }
        return (Collection<Reservation>) reservationService;
    }

    public Collection<IRoom> findARoom(Date checkIn, Date checkOut){
        return reservationService.findRooms(checkIn, checkOut);
    }
}
