package service;

import model.Customer;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CustomerService {

    private static CustomerService SingleInstance = new CustomerService();

    private Map<String, Customer> customerMap = new HashMap<>();

    private CustomerService() {
    }

    public static CustomerService getSingleInstance(){
        return SingleInstance;
    }

    public void addCustomer(String email, String firstName, String lastName){
        customerMap.put(email, new Customer(firstName, lastName, email));
    }

    public Customer getCustomer(String customerEmail){
        return customerMap.get(customerEmail);
    }

    public Collection<Customer> getAllCustomers(){
        return customerMap.values();
    }

}
