package com.mrc.miniboot.repo;

import com.mrc.miniboot.entity.Item.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Integer> {
    //根据warehouseId查询
    List<Item> findByWarehouseId(int warehouseId);
}
