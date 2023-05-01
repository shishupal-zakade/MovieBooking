package com.threatre.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.threatre.inventory.entity.Inventory;
import com.threatre.inventory.repository.InventoryRepository;

@RestController
@RequestMapping("/theatre/inventory")
public class TheatreInventoryController {

	@Autowired
	InventoryRepository inventoryRepository;

	@PostMapping(value = "/create", consumes = { "application/json" })
	public ResponseEntity<?> createInventory(@RequestBody Inventory inventory) {
		System.out.println("Creating -"+ inventory.toString());
		return ResponseEntity.status(HttpStatus.OK).body(inventoryRepository.save(inventory));
	}

	@PostMapping(value = "/update", consumes = { "application/json" })
	public ResponseEntity<?> updateInventory(@RequestBody Inventory inventory) {
		System.out.println("Updating -"+ inventory.toString());
		return ResponseEntity.status(HttpStatus.OK).body(inventoryRepository.save(inventory));
	}

	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<?> deleteInventory(@PathVariable Integer id) {
		inventoryRepository.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}

	@GetMapping("/getAll")
	public List<Inventory> test() {
		return inventoryRepository.findAll();
	}
}
