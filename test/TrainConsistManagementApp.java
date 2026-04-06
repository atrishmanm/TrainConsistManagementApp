package test;

import static org.junit.Assert.*;
import org.junit.Test;

public class TrainConsistManagementApp {
    static class InvalidCapacityException extends Exception {
        public InvalidCapacityException(String message) { super(message); }
    }

    static class PassengerBogie {
        String type;
        int capacity;

        PassengerBogie(String type, int capacity) throws InvalidCapacityException {
            if (capacity <= 0) {
                throw new InvalidCapacityException("Capacity must be greater than zero");
            }
            this.type = type;
            this.capacity = capacity;
        }
    }

    @Test
    public void testException_ValidCapacityCreation() throws InvalidCapacityException {
        PassengerBogie bogie = new PassengerBogie("Sleeper", 72);
        assertNotNull(bogie);
        assertEquals(72, bogie.capacity);
    }

    @Test(expected = InvalidCapacityException.class)
    public void testException_NegativeCapacityThrowsException() throws InvalidCapacityException {
        new PassengerBogie("Sleeper", -10);
    }

    @Test(expected = InvalidCapacityException.class)
    public void testException_ZeroCapacityThrowsException() throws InvalidCapacityException {
        new PassengerBogie("AC Chair", 0);
    }

    @Test
    public void testException_ExceptionMessageValidation() {
        try {
            new PassengerBogie("First Class", -5);
            fail("Exception should have been thrown");
        } catch (InvalidCapacityException e) {
            assertEquals("Capacity must be greater than zero", e.getMessage());
        }
    }

    @Test
    public void testException_ObjectIntegrityAfterCreation() throws InvalidCapacityException {
        PassengerBogie bogie = new PassengerBogie("AC Chair", 56);
        assertEquals("AC Chair", bogie.type);
        assertEquals(56, bogie.capacity);
    }

    @Test
    public void testException_MultipleValidBogiesCreation() throws InvalidCapacityException {
        PassengerBogie b1 = new PassengerBogie("Sleeper", 72);
        PassengerBogie b2 = new PassengerBogie("First Class", 24);
        assertNotNull(b1);
        assertNotNull(b2);
    }
}