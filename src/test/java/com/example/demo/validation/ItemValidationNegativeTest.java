package com.example.demo.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class ItemValidationNegativeTest {

	//TODO: SpringBoot:Practical 3 - Testing: Introduction to unit testing and integration testing with Spring Boot.
	//Complete the code below then commit your code
	//Refer to ItemValidationPositiveTest code as reference

	@Test
	
    @DisplayName("parseAndValidateLongId: Should throw IllegalArgumentException for a non-numeric string")
    void parseAndValidateLongId_InvalidCase_NonNumeric() {
    	// complete the code here
		String idString = "nsodvniowebvew";
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            ItemValidation.parseAndValidateLongId(idString);
        });
        assertEquals("Invalid ID format. ID must be a valid number.", thrown.getMessage());
    }
}
