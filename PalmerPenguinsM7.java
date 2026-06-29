// PalmerPenguinsM7.java
// Nyesha Littles
// 6/28/2026
// Object-Oriented Refactoring and Encapsulation of Species Data

public class PalmerPenguinsM7 {

    public static void main(String[] args) {
        System.out.println("Palmer Penguins M7");

        // Create an instance of SpeciesCounter named "counter"
        SpeciesCounter counter = new SpeciesCounter();

        // Read species data
        counter.readSpeciesData();

        // If data loaded cleanly, initialize, count, and print results
        if (!counter.isDataEmpty()) {
            counter.initializeSpeciesCount();
            counter.countSpecies();
            counter.printSpeciesCount();
        } else {
            System.out.println("Error: Species data could not be loaded. Verify CSV file placement.");
        }
    }
}