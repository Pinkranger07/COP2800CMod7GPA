import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * COP2800C Module 7 Graded Programming Assignment - Species Data Class
 * Submission Date: June 28, 2026
 * SpeciesCounter encapsulates the species data and related operations.
 */
public class SpeciesCounter {

    // Predefined constants
    private static final String FILE_NAME = "PalmerPenguins.csv";
    private static final int NUM_SPECIES = 3;
    private static final String[] SPECIES_NAMES = {"Chinstrap", "Gentoo", "Adelie"};

    // Private fields for encapsulation
    private String[] speciesData;
    private int[] speciesCount;

    /**
     * Reads species data directly using an embedded reader to prevent file-link errors.
     */
    public void readSpeciesData() {
        List<String> records = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            br.readLine(); // Skip header row
            
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",", -1);
                if (values.length > 1) {
                    records.add(values[1]); // Read column index 1
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            this.speciesData = new String[0];
            return;
        }

        this.speciesData = records.toArray(new String[0]);
    }

    /**
     * Creates a new integer array of size NUM_SPECIES and assigns it to speciesCount.
     */
    public void initializeSpeciesCount() {
        this.speciesCount = new int[NUM_SPECIES];
    }

    /**
     * Returns true if speciesData is empty or null, otherwise false.
     */
    public boolean isDataEmpty() {
        return this.speciesData == null || this.speciesData.length == 0;
    }

    /**
     * Iterates through speciesData and updates speciesCount.
     */
    public void countSpecies() {
        if (isDataEmpty()) {
            return;
        }

        for (String species : speciesData) {
            if (species == null) {
                continue;
            }
            
            String cleaned = species.trim().replace("\"", "");
            
            for (int i = 0; i < SPECIES_NAMES.length; i++) {
                if (cleaned.equalsIgnoreCase(SPECIES_NAMES[i])) {
                    speciesCount[i]++;
                    break;
                }
            }
        }
    }

    /**
     * Prints the count of each species using the predefined constants.
     */
    public void printSpeciesCount() {
        if (speciesCount == null) {
            return;
        }

        for (int i = 0; i < NUM_SPECIES; i++) {
            System.out.println(SPECIES_NAMES[i] + " count = " + speciesCount[i]);
        }
    }
}