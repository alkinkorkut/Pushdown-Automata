package Main;

import Algorithm.Transition;


import java.util.List;
import java.util.ArrayList;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

import java.io.FileWriter;
import java.io.IOException;

public class FetchInput {
    private List<String> allStates;
    private String firstStackSymbol;
    private List<String> symbolAlphabet;
    private String startState;
    private List<String> finalStates;
    private List<String> stackAlphabet;
    private List<Transition> transitions;
    private List<String> stringsToBeDetected;
    private File inputFile;
    private int numSymbolAlphabet;
    private int numStackAlphabet;
    private int numFinalStates;
    private int numAllStates;


    // Constructor
    public FetchInput() {
        this.inputFile = new File("src/input.txt");

        allStates = new ArrayList<>();
        finalStates = new ArrayList<>();

        transitions = new ArrayList<>();
        stringsToBeDetected = new ArrayList<>();

        symbolAlphabet = new ArrayList<>();
        stackAlphabet = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(this.inputFile);
            int scan = 1;
            while (scanner.hasNext()) {
                String next = scanner.next();
                if (scan == 1) {
                    int numberOfSymbolAlphabet = Integer.parseInt(next); // Reading the number of variables in the symbol alphabet
                    this.numSymbolAlphabet = numberOfSymbolAlphabet;
                    System.out.println("numSymbolAlphabet: " + numSymbolAlphabet);
                    scan = scan + 1;
                } else if (scan == 2) {
                    int numberOfStackAlphabet = Integer.parseInt(next); // Reading the number of variables in the stack alphabet
                    this.numStackAlphabet = numberOfStackAlphabet;
                    System.out.println("numStackAlphabet: " + numStackAlphabet);
                    scan = scan + 1;
                } else if (scan == 3) {
                    int numberOfFinalStates = Integer.parseInt(next); // Reading the number of final states
                    this.numFinalStates = numberOfFinalStates;
                    System.out.println("numFinalStates: " + numFinalStates);
                    scan = scan + 1;
                } else if (scan == 4) {
                    int numberOfAllStates = Integer.parseInt(next); // Reading the number of all states
                    this.numAllStates = numberOfAllStates;
                    System.out.println("numAllStates: " + numAllStates);
                    scan = scan + 1;
                } else if (scan == 5) {
                    for (int j = 0; j < this.numAllStates; j++) { // Loop over all states
                        allStates.add(next); // Adding the state to the list of all states
                        System.out.println("next: " + next);
                        if (j != this.numAllStates - 1){
                            next = scanner.next();
                        }
                    }
                    System.out.println("allStates: " + allStates);
                    scan = scan + 1;
                } else if (scan == 6) {
                    this.startState = next; // Reading the start state
                    System.out.println("startState: " + startState);
                    scan = scan + 1;
                } else if (scan == 7) {
                    for (int j = 0; j < this.numFinalStates; j++) { // Loop over all final states
                        this.finalStates.add(next); // Adding the final state to the list of final states
                        // (Final state and goal state is the same thing.)
                        System.out.println("next: " + next);
                        if (j != this.numFinalStates - 1)
                            next = scanner.next();
                    }
                    System.out.println("finalStates: " + finalStates);
                    scan = scan + 1;
                } else if (scan == 8) {
                    for (int j = 0; j < this.numStackAlphabet; j++) {
                        this.stackAlphabet.add(next);
                        System.out.println("next: " + next);
                        if (j != this.numStackAlphabet - 1)
                            next = scanner.next();
                    }
                    System.out.println("stackAlphabet: " + stackAlphabet);
                    scan = scan + 1;
                } else if (scan == 9) {
                    this.firstStackSymbol = next;
                    System.out.println("firstStackSymbol: " + firstStackSymbol);
                    scan = scan + 1;
                } else if (scan == 10) {
                    for (int j = 0; j < this.numSymbolAlphabet; j++) {
                        this.symbolAlphabet.add(next);
                        System.out.println("next: " + next);
                        if (j != this.numSymbolAlphabet - 1)
                            next = scanner.next();
                    }
                    System.out.println("symbolAlphabet: " + symbolAlphabet);
                    scan = scan + 1;
                } else if (scan == 11) {
                    String[] split = scanner.nextLine().split(" ");
                    boolean boo = true;
                    int cnt = 1;
                    while (scanner.hasNextLine() && split.length > 4) {
                        System.out.println("----------------------------------------");
                        Transition transition;
                        if (boo) {
                            System.out.println("Transition_"+ cnt);
                            System.out.println(next + " " + split[1] + " " +
                                    split[2] + " " + split[3] +  " " + split[4]);
                            transition = new Transition(next,
                                    split[1],
                                    split[2],
                                    split[3],
                                    split[4]);
                            cnt = cnt + 1;
                            boo = false;
                        } else {
                            System.out.println("Transition_"+ cnt);
                            System.out.println(split[0] + " " + split[1] + " " +
                                    split[2] + " " + split[3] + " " + split[4]);
                            transition = new Transition(split[0],
                                    split[1],
                                    split[2],
                                    split[3],
                                    split[4]);
                            cnt = cnt + 1;
                        }
                        transitions.add(transition);
                        split = scanner.nextLine().split(" ");
                        next = split[0];
                        System.out.println("----------------------------------------");
                    }
                    stringsToBeDetected.add(next);
                    scan = scan + 1;
                }
                else if (scan == 12) {
                    stringsToBeDetected.add(next);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException: " + e.getMessage());
        }
    }

    public String getStartState() {
        return startState;
    }

    public List<String> getFinalStates() {
        return finalStates;
    }

    public List<Transition> getTransitions() {
        return transitions;
    }

    public List<String> getStringsToBeDetected() {
        return stringsToBeDetected;
    }
}
