package com.example.pos2.repo;

import com.example.pos2.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories

public interface ItemRepo extends JpaRepository<Item,Integer> {
    List<Item> findAllByItemNameEquals(String name);

    List<Item> findAllByItemNameEqualsAndStatusEquals(String name, boolean status);
}
