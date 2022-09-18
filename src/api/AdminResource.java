package api;

import model.Customer;
import model.IRoom;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.List;

public class AdminResource {

    static AdminResource SingleInstance = new AdminResource();

    CustomerService customerService = CustomerService.getSingleInstance();

    ReservationService reservationService =  ReservationService.getSingleInstance();

    public AdminResource() {
    }

    public static AdminResource getSingleInstance(){
        return SingleInstance;
    }

    public Customer getCustomer(String email){
        return  customerService.getCustomer(email);
    }

    public void addRoom(List<IRoom> rooms){
        rooms.forEach(reservationService::addRoom);
    }

    public Collection<IRoom> getAllRooms(){
        return null;
    }

    public Collection<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    public void displayAllReservations(){
        reservationService.printAllReservation();
    }
}
