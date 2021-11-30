package com.HotelsProject.BookingHotel.Controllers;

import com.HotelsProject.BookingHotel.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {

    @Autowired
    BookingService bookingService;

    @RequestMapping(method = RequestMethod.GET,value="/Hi")
    public String str(){
        return "Hiii";}

    @RequestMapping(method = RequestMethod.GET,value="/customers/{customerID}/cities/{cityID}/hotels/{hotelID}/{strBook}")
    public String bookHotel(@PathVariable Integer customerID, @PathVariable Integer cityID, @PathVariable Integer hotelID, @PathVariable String strBook){
        return bookingService.bookHotel(customerID,cityID, hotelID, strBook);
    }
}
