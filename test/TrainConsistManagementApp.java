package test;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TrainConsistManagementApp {

    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    private Map<String, List<Bogie>> groupBogies(List<Bogie> list) {
        return list.stream().collect(Collectors.groupingBy(b -> b.name));
    }

    @Test
    public void testGrouping_BogiesGroupedByType() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("Sleeper", 70));
        
        Map<String, List<Bogie>> result = groupBogies(bogies);
        
        assertTrue(result.containsKey("Sleeper"));
        assertEquals(2, result.get("Sleeper").size());
    }

    @Test
    public void testGrouping_MultipleBogiesInSameGroup() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("AC Chair", 60));
        
        Map<String, List<Bogie>> result = groupBogies(bogies);
        
        assertEquals(2, result.get("AC Chair").size());
    }

    @Test
    public void testGrouping_DifferentBogieTypes() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("First Class", 24));
        
        Map<String, List<Bogie>> result = groupBogies(bogies);
        
        assertEquals(2, result.size());
        assertTrue(result.containsKey("Sleeper"));
        assertTrue(result.containsKey("First Class"));
    }

    @Test
    public void testGrouping_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();
        Map<String, List<Bogie>> result = groupBogies(bogies);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testGrouping_SingleBogieCategory() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("General", 90));
        bogies.add(new Bogie("General", 100));
        
        Map<String, List<Bogie>> result = groupBogies(bogies);
        
        assertEquals(1, result.keySet().size());
        assertEquals(2, result.get("General").size());
    }

    @Test
    public void testGrouping_MapContainsCorrectKeys() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        
        Map<String, List<Bogie>> result = groupBogies(bogies);
        
        assertTrue(result.containsKey("Sleeper"));
        assertTrue(result.containsKey("AC Chair"));
        assertFalse(result.containsKey("First Class"));
    }

    @Test
    public void testGrouping_GroupSizeValidation() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("Sleeper", 70));
        bogies.add(new Bogie("AC Chair", 60));
        
        Map<String, List<Bogie>> result = groupBogies(bogies);
        
        assertEquals(2, result.get("Sleeper").size());
        assertEquals(1, result.get("AC Chair").size());
    }

    @Test
    public void testGrouping_OriginalListUnchanged() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        int originalSize = bogies.size();
        
        groupBogies(bogies);
        
        assertEquals(originalSize, bogies.size());
    }
}