package com.example.demo.service;

import com.example.demo.model.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ItemServiceTest {

	//TODO: SpringBoot:Practical 4 - Unit Testing continue
	//Complete the TODO below
	
    private ItemService itemService;
    private ItemServiceAnalysis itemServiceAnalysis;

    @BeforeEach
    void setUp() {
        itemService = new ItemService();
        itemServiceAnalysis = new ItemServiceAnalysis();
    }

    @Test
    void testCreateItem() {
        Item item = itemService.createItem("Test Value");
        assertNotNull(item);
        assertEquals("Test Value", item.value());
        assertTrue(item.id() > 0);
    }

    @Test
    void testCreateItemWithProvidedId_Success() {
        Optional<Item> optionalItem = itemService.createItemWithProvidedId(100L, "Manual ID Item");
        
     // TODO: complete the optionalItem.get().id() is equal to 100L above
        assertTrue(optionalItem.isPresent());
        assertEquals(100L, optionalItem.get().id()); 
        assertEquals("Manual ID Item", optionalItem.get().value());
     
    }

    @Test
    void testGetItemById() {
        Item created = itemService.createItem("Lookup");
        Optional<Item> fetched = itemService.getItemById(created.id());
        
     // TODO: complete the assert result above
        assertTrue(fetched.isPresent()); // ✅ Completed: Ensure item is found
        assertEquals(created.id(), fetched.get().id()); // Optional: confirm ID matches
        assertEquals("Lookup", fetched.get().value()); // Optional: confirm value
     
    }

    @Test
    void testGetAllItems() {
        itemService.createItem("One");
        itemService.createItem("Two");
        List<Item> items = itemService.getAllItems();
        assertEquals(2, items.size());
    }

    @Test
    void testUpdateItem_Success() {
        Item created = itemService.createItem("Before");
        Optional<Item> updated = itemService.updateItem(created.id(), "After");
        assertTrue(updated.isPresent());
        assertEquals("After", updated.get().value());
    }

    @Test
    void testDeleteItem_Success() {
        Item created = itemService.createItem("Delete Me");
        boolean result = itemService.deleteItem(created.id());
        assertTrue(result); // ✅ Completed: Ensure delete operation was successful

        // Optional: ensure item is no longer retrievable
        
        // TODO: complete the assert result above
        Optional<Item> check = itemService.getItemById(created.id());
        assertFalse(check.isPresent());
        
    }

    @Test
    void testDeleteItem_NotFound() {
        boolean result = itemService.deleteItem(12345L);
        
     // TODO: complete the assert result above
        assertFalse(result); // ✅ Completed: Expect false when deleting non-existent item
     
    }
    
    @Test
    void testGetAllItemByDemo() {
    	itemService.createItem("demo");
    	itemService.createItem("notdemo");
    	List<Item> items = itemServiceAnalysis.getAllItemsByDemo();
    	assertEquals(1, items.size());
    }
}
