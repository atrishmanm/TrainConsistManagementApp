package test;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class TrainConsistManagementApp {

    static class GoodsBogie {
        String type;
        String cargo;

        GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }
    }

    private boolean checkSafety(List<GoodsBogie> list) {
        return list.stream().allMatch(b -> 
            !(b.type.equalsIgnoreCase("Cylindrical")) || b.cargo.equalsIgnoreCase("Petroleum")
        );
    }

    @Test
    public void testSafety_AllBogiesValid() {
        List<GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        bogies.add(new GoodsBogie("Open", "Coal"));
        
        assertTrue(checkSafety(bogies));
    }

    @Test
    public void testSafety_CylindricalWithInvalidCargo() {
        List<GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new GoodsBogie("Cylindrical", "Coal"));
        
        assertFalse(checkSafety(bogies));
    }

    @Test
    public void testSafety_NonCylindricalBogiesAllowed() {
        List<GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new GoodsBogie("Open", "Coal"));
        bogies.add(new GoodsBogie("Box", "Grain"));
        
        assertTrue(checkSafety(bogies));
    }

    @Test
    public void testSafety_MixedBogiesWithViolation() {
        List<GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new GoodsBogie("Cylindrical", "Petroleum")); // Valid
        bogies.add(new GoodsBogie("Open", "Coal"));            // Valid
        bogies.add(new GoodsBogie("Cylindrical", "Water"));     // Invalid
        
        assertFalse(checkSafety(bogies));
    }

    @Test
    public void testSafety_EmptyBogieList() {
        List<GoodsBogie> bogies = new ArrayList<>();
        assertTrue(checkSafety(bogies));
    }
}