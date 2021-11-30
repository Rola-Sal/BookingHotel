package com.HotelsProject.BookingHotel.services;

import com.HotelsProject.BookingHotel.entities.Customer;
import com.HotelsProject.BookingHotel.repos.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BookingService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    CustomerRepository customerRepository;

    public String bookHotel(int customerID, int cityID,int hotelID , String strBook){
        String url = "http://localhost:8080///cities/" + cityID + "/hotels/" + hotelID ;
        String str = restTemplate.getForObject(url,
                String.class);
        if (!customerRepository.existsById(customerID)) return "not valid customer Id ";
        Customer customer = customerRepository.findById(customerID).get();
        customer.setHotel_id(hotelID);
        customerRepository.save(customer);
        return str + " hotel booked successfully";

        }
    }

