package com.learn.SpringBootCrud.repository;

import com.learn.SpringBootCrud.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface  CustomerRepository extends CrudRepository<Customer,Long> {
}
