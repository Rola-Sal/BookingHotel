package com.HotelsProject.BookingHotel.services;

import com.HotelsProject.BookingHotel.entities.Customer;
import com.HotelsProject.BookingHotel.repos.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class BookingService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Autowired
    CustomerRepository customerRepository;

    public String bookHotel(int customerID, int cityID,int hotelID , String strBook){
        String url = "http://hotels-in-cities///cities/" + cityID + "/hotels/" + hotelID ;
        //restTemplate.getForObject( url , return type );
        String str = restTemplate.getForObject(url, String.class);

        //we used WebCleint Builder instead of RestTemplate
        /* String str = webClientBuilder.build()
                .get() //Rest methode (get,post, ..etc)
                .uri(url) //url that we want to access
                .retrieve()
                .bodyToMono(String.class) // type of the return
                .block();
        */
        if (!customerRepository.existsById(customerID)) return "not valid customer Id ";
        Customer customer = customerRepository.findById(customerID).get();
        customer.setHotel_id(hotelID);
        customerRepository.save(customer);
        return str + " hotel booked successfully";

        }
    }

