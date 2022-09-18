package model;

import java.util.regex.Pattern;

public class Customer {

    private String firstName;

    private String lastName;

    private String email;

    private static String emailRegex = "^(.+)@(.+).(.+)$";

    public Customer(String firstName, String lastName, String email) {
        this.patternMatches(email, emailRegex);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    private void patternMatches(String email, String emailRegex){
        if(Pattern.compile(emailRegex).matcher(email).matches()){
            System.out.println("Valid Email");
        }else {
            throw new IllegalArgumentException("Invalid Email");
        }
    }

    public String getEmail() {
        return this.email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
