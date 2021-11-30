package com.HotelsProject.BookingHotel.repos;

import com.HotelsProject.BookingHotel.entities.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
