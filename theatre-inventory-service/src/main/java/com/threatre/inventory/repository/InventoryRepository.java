package com.threatre.inventory.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.threatre.inventory.entity.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
	
//	public List<Inventory> findByInventoryStartTimeLessThanAndInventoryEndtimeGreaterThan(Timestamp time,Timestamp time1);


}