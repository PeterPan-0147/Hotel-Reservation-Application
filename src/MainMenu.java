import api.HotelResource;
import model.IRoom;
import model.Reservation;

import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class MainMenu {

    static HotelResource hotelResource = HotelResource.getSingleInstance();

    public static void displayMainMenu(){
        System.out.println("\n Welcome to the Hotel reservation Application\n" +
                            "-----------------------------------------------\n" +
                            "1. Find and reserve a room\n" +
                            "2. See my reservations\n" +
                            "3. Create an Account\n" +
                            "4. Admin\n" +
                            "5. Exit\n" +
                            "------------------------------------------------\n" +
                            "Please select a number for the menu option:\n");
    }

    public static void mainMenu(){
        String input = "";
        Scanner scanner = new Scanner(System.in);

        displayMainMenu();

        try {
            do {
                input = scanner.nextLine();
                if (input.length() == 1){
                    switch (input.substring(0)){
                        case "1": //findAndReserveRoom();
                            break;
                        case "2": seeMyReservations();
                            break;
                        case "3": createAnAccount();
                            break;
                        case "4": AdminMenu.adminMenu();
                            break;
                        case "5": System.out.println("Exit");
                            break;
                        default: System.out.println("Invalid input\n");
                            break;
                    }
                }else {
                    System.out.println("Invalid input\n");
                }
            }while (input.substring(0) != "5" || input.length() != 1);

        }catch (IllegalArgumentException e){
            e.getLocalizedMessage();
        }


    }

    static void createAnAccount(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input Email Address");
        String email = scanner.nextLine();

        System.out.println("Input First Name");
        String firstName = scanner.nextLine();

        System.out.println("Input Last Name");
        String lastName = scanner.nextLine();

        try {
            hotelResource.createACustomer(email, firstName, lastName);
            System.out.println("User created successfully");
            displayMainMenu();
        }catch (IllegalArgumentException e){
            e.printStackTrace();
            createAnAccount();
        }
    }

    static void displayReservations(List<Reservation> reservations){
        if(reservations.isEmpty()){
            System.out.println("Reservation not found");
        }else {
            reservations.forEach(reservation -> System.out.println("\n" + reservation));
        }
    }

    static void seeMyReservations(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input your Email address");
        String email = scanner.nextLine();
        displayReservations((List<Reservation>) hotelResource.getCustomersReservations(email));
    }

    static void displayRooms(List<IRoom> iRooms){
        if(iRooms.isEmpty()){
            System.out.println("Rooms not found");
        }else{
            iRooms.forEach(System.out::println);
        }
    }
}
