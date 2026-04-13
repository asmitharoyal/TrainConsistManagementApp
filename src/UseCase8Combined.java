import java.util.*;
import java.util.stream.Collectors;

// MAIN CLASS
public class UseCase8Combined {

    // Bogie class
    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return name + " -> " + capacity;
        }
    }

    // FILTER METHOD
    public static List<Bogie> filterBogies(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.capacity > threshold)
                .collect(Collectors.toList());
    }

    // MAIN METHOD
    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("UC8 - Filter Passenger Bogies Using Streams");
        System.out.println("======================================\n");

        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General", 90));

        System.out.println("All Bogies:");
        bogies.forEach(System.out::println);

        List<Bogie> filtered = filterBogies(bogies, 60);

        System.out.println("\nFiltered Bogies (Capacity > 60):");
        filtered.forEach(System.out::println);

        System.out.println("\nUC8 filtering completed...\n");

        // RUN TESTS
        runTests();
    }

    // =========================
    // SIMPLE TEST CASES (NO JUNIT)
    // =========================
    public static void runTests() {
        System.out.println("Running Test Cases...\n");

        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General", 90));

        // Test 1: Greater than threshold
        List<Bogie> result1 = filterBogies(bogies, 70);
        System.out.println("Test 1 (Capacity > 70): " + (result1.size() == 2 ? "PASS" : "FAIL"));

        // Test 2: Equal to threshold
        List<Bogie> result2 = filterBogies(bogies, 72);
        boolean contains72 = result2.stream().anyMatch(b -> b.capacity == 72);
        System.out.println("Test 2 (Exclude 72): " + (!contains72 ? "PASS" : "FAIL"));

        // Test 3: No match
        List<Bogie> result3 = filterBogies(bogies, 200);
        System.out.println("Test 3 (No match): " + (result3.isEmpty() ? "PASS" : "FAIL"));

        // Test 4: All match
        List<Bogie> result4 = filterBogies(bogies, 10);
        System.out.println("Test 4 (All match): " + (result4.size() == 4 ? "PASS" : "FAIL"));

        // Test 5: Empty list
        List<Bogie> result5 = filterBogies(new ArrayList<>(), 50);
        System.out.println("Test 5 (Empty list): " + (result5.isEmpty() ? "PASS" : "FAIL"));

        // Test 6: Original list unchanged
        filterBogies(bogies, 60);
        System.out.println("Test 6 (Original unchanged): " + (bogies.size() == 4 ? "PASS" : "FAIL"));

        System.out.println("\nAll Tests Completed.");
    }
}