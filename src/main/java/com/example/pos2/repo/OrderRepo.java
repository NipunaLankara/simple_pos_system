package com.example.pos2.repo;

import com.example.pos2.entity.Item;
import com.example.pos2.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories

public interface OrderRepo extends JpaRepository<Order,Integer> {
}
