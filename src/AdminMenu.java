import api.AdminResource;
import model.Customer;
import model.IRoom;


import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class AdminMenu {

    static AdminResource adminResource = AdminResource.getSingleInstance();

    static void displayMenu(){
        System.out.println("\nAdmin menu\n" +
                            "---------------------------------\n" +
                            "1. See all Customers\n" +
                            "2. See all Rooms\n" +
                            "3. See all Reservations\n" +
                            "4. Add a Room\n" +
                            "5. Back to Main Menu\n" +
                            "---------------------------------\n" +
                            "Please select a number for the menu option:\n");
    }
    static void adminMenu(){
        String input = "";
        Scanner scanner = new Scanner(System.in);
        displayMenu();

        try {
            do {
                input = scanner.nextLine();
                if (input.length()==1){
                    switch (input.substring(0)){
                        case "1": seeAllCustomers();
                            break;
                        case "2": seeAllRooms();
                            break;
                        case "3": seeAllReservations();
                            break;
                        case "4": addARoom();
                            break;
                        case "5": MainMenu.mainMenu();
                            break;
                        default: System.out.println("Unknown action\n");
                            break;
                    }
                }else {
                    System.out.println("Invalid action\n");
                }
            }while (input.length() != 1 || input.substring(0) != "5");

        }catch (IllegalArgumentException exception){
            exception.getLocalizedMessage();
        }


    }

    private static void addARoom() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input room Id");
        String roomId = scanner.nextLine();

        System.out.println("Input price per day");
        double price = Double.parseDouble(scanner.nextLine());

        //RoomType roomType =


    }

    private static void seeAllReservations() {
        adminResource.displayAllReservations();
    }

    private static void seeAllRooms() {

        Collection<IRoom> iRooms = adminResource.getAllRooms();

        if (iRooms.isEmpty()){
            System.out.println("Rooms not found");
        }else{
            adminResource.getAllRooms().forEach(System.out::println);
        }
    }

    private static void seeAllCustomers() {
        List<Customer> customerList = (List<Customer>) adminResource.getAllCustomers();

        if (customerList.isEmpty()){
            System.out.println("Customers not found");
        }else {
            adminResource.getAllCustomers().forEach(System.out::println);
        }
    }
}
