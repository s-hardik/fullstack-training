package com.programming.techie;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ContactManagerTest {
    ContactManager contactManager;
    @BeforeAll
    public static void setupAll(){
        System.out.println("Should Print Before All Tests");
    }
    @BeforeEach
    public void setup(){
        contactManager = new ContactManager();
    }
    @Test
    @RepeatedTest(value = 5)
    public void shouldCreateContact(){

        contactManager.addContact("hardik", "shah", "0892868830");
        assertFalse(contactManager.getAllContacts().isEmpty());
        assertEquals(1, contactManager.getAllContacts().size());
    }
    @Test
    @ParameterizedTest
    @ValueSource(strings = {"0123456789", "1234567890","32432432423423423432"})
    public void shouldCreateContact1(String phoneNumber){

        contactManager.addContact("hardik", "shah", phoneNumber);
        assertFalse(contactManager.getAllContacts().isEmpty());
        assertEquals(1, contactManager.getAllContacts().size());
    }
    @Test
    @DisplayName("Should Not Create Contact when first name is null")
    public void shouldthrowExceptionIfFirstNameIsNull() {

        assertThrows(RuntimeException.class, () -> {
        contactManager.addContact(null, "shah", "0987654321");
        });
    }
    @Test
    @DisplayName("Should Not Create Contact when last name is null")
    public void shouldthrowExceptionIfLastNameIsNull(){

        assertThrows(RuntimeException.class, () -> {
            contactManager.addContact("Hardik", null, "0987654321");
        });
    }
    @Test
    @DisplayName("Should Not Create Contact when phoneNumber is null")
    public void shouldthrowExceptionIfPhoneNumberIsNull(){

        assertThrows(RuntimeException.class, () -> {
            contactManager.addContact("Hardik", "shah", null);
        });}
    @AfterEach
    public void tearDown(){
        System.out.println("Should Execute After Each Test");
    }
    @AfterAll
    public void tearDownAll(){
        System.out.println("Should Execute End of the Test");
    }
}