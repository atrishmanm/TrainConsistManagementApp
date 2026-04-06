package test.java;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class TrainConsistManagementAppTest {

    @Test
    void testCargo_SafeAssignment() {
        TrainConsistManagementApp.GoodsBogie bogie = new TrainConsistManagementApp.GoodsBogie("Cylindrical");
        bogie.assignCargo("Petroleum");
        assertEquals("Petroleum", bogie.cargo);
    }

    @Test
    void testCargo_UnsafeAssignmentHandled() {
        TrainConsistManagementApp.GoodsBogie bogie = new TrainConsistManagementApp.GoodsBogie("Rectangular");
        assertDoesNotThrow(() -> bogie.assignCargo("Petroleum"));
    }

    @Test
    void testCargo_CargoNotAssignedAfterFailure() {
        TrainConsistManagementApp.GoodsBogie bogie = new TrainConsistManagementApp.GoodsBogie("Rectangular");
        bogie.assignCargo("Petroleum");
        assertNull(bogie.cargo);
    }

    @Test
    void testCargo_ProgramContinuesAfterException() {
        TrainConsistManagementApp.GoodsBogie bogie1 = new TrainConsistManagementApp.GoodsBogie("Rectangular");
        TrainConsistManagementApp.GoodsBogie bogie2 = new TrainConsistManagementApp.GoodsBogie("Cylindrical");
        
        bogie1.assignCargo("Petroleum"); 
        bogie2.assignCargo("Grains");
        
        assertEquals("Grains", bogie2.cargo);
    }

    @Test
    void testCargo_FinallyBlockExecution() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        
        TrainConsistManagementApp.GoodsBogie bogie = new TrainConsistManagementApp.GoodsBogie("Rectangular");
        bogie.assignCargo("Petroleum");
        
        String output = outContent.toString();
        assertTrue(output.contains("Cargo validation completed for Rectangular bogie"));
        
        System.setOut(originalOut);
    }
}