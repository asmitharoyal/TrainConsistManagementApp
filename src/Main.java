import java.util.LinkedHashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        // Create LinkedHashSet to maintain insertion order with uniqueness
        Set<String> trainFormation = new LinkedHashSet<>();

        // Attach bogies
        trainFormation.add("Engine");
        trainFormation.add("Sleeper");
        trainFormation.add("Cargo");
        trainFormation.add("Guard");

        // Attempt to add a duplicate bogie
        trainFormation.add("Sleeper");

        // Display final formation (insertion order preserved, duplicates ignored)
        System.out.println("Final train formation:");
        System.out.println(trainFormation);
    }
}