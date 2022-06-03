package com.revature.repositories;
import org.springframework.data.repository.CrudRepository;

import com.revature.models.Order;

public interface order_repository extends CrudRepository<Order,Long> {

}
