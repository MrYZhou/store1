package com.lar.store.mapper;

import com.lar.store.pojo.Property;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PropertyDAO extends JpaRepository<Property,Integer> {
    List<Property> getAllByPidEquals(int id);
}
