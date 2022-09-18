package service;

import model.Customer;
import model.IRoom;
import model.Reservation;

import java.util.*;

public class ReservationService {

    private static ReservationService SingleInstance = new ReservationService();

    private Map<String, IRoom> rooms = new HashMap<>();

    private Map<String, List<Reservation>> stringListMap = new HashMap<>();

    private ReservationService() {
    }

    public static ReservationService getSingleInstance(){

        return SingleInstance;
    }

    public void addRoom(IRoom room){
        rooms.put(room.getRoomNumber(), room);
    }

    public IRoom getARoom(String roomNumber){
        return rooms.get(roomNumber);
    }

    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate){
        Reservation reservation = new Reservation(customer, room, checkInDate, checkOutDate);

        List<Reservation> reservationList = getCustomersReservation(customer);

        if(reservationList == null){
            reservationList = new ArrayList<>();
        }else {
            reservationList.add(reservation);
            stringListMap.put(customer.getEmail(), reservationList);
        }
        return reservation;
    }

    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate){
        return null;
    }

    public List<Reservation> getCustomersReservation(Customer customer){
        return stringListMap.get(customer.getEmail());
    }

    public List<Reservation> getAllCustomerReservation(){
        List<Reservation> allCustomerReservation = new ArrayList<>();
        for (List<Reservation> reservation : stringListMap.values()
             ) {
            allCustomerReservation.addAll(reservation);
        }
        return allCustomerReservation;
    }

    public void printAllReservation(){
         List<Reservation> reservationList = getAllCustomerReservation();

         if(reservationList == null){
             System.out.println("No room reserved");
         }else{
             for (Reservation reservation : reservationList
                  ) {
                 System.out.println(reservation + "\n");
             }
         }
    }

}
