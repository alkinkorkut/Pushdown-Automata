// ALKIN KORKUT Pushdown Automata
// CS410 - Project_2

package Main;
import Algorithm.PDA;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        long start_time = System.currentTimeMillis(); // Start time of the program
        FetchInput fetchInput = new FetchInput(); // Read the data from input file
        System.out.println("----------------------------------------");
        PDA pda = new PDA(fetchInput); // PDA object instance
        pda.modelOfPda(); // PDA model
        long end_time = System.currentTimeMillis(); // End time of the program
        long total_time = end_time - start_time; // Total time of the program
        System.out.println("----------------------------------------");
        System.out.println("Computation Time: " + total_time + " in milliseconds");
    }
}
