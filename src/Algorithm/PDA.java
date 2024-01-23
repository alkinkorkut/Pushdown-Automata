package Algorithm;

import Main.FetchInput;

import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PDA {

    private FetchInput inputFile;


    // Other constructor for initialization
    public PDA(FetchInput inputFile) {
        this.inputFile = inputFile;
    }

    // Default constructor
    public PDA() { }

    // Method to model the PDA
    public void modelOfPda() {
        try {
            System.out.println("----------------------------------------");
            FileWriter fW = new FileWriter("src/output.txt");
            String instantState = inputFile.getStartState();
            inputFile.getTransitions().removeIf(t -> t.getFromState().equals(t.getToState()) && t.isNonDeterministic());
            for (String str : inputFile.getStringsToBeDetected()) {
                RecursivePart recur = new RecursivePart(inputFile);
                recur.routeTaken.add(instantState);
                List<String> outcome = recur.recur(str, inputFile);
                fW.write(outcome + "");
                System.out.println(outcome);
                boolean boo = (inputFile.getFinalStates().contains(outcome.get(outcome.size() - 1)));
                if (!boo) {
                    fW.write("\nRejected\n");
                    System.out.println("Rejected");
                } else {
                    fW.write("\nAccepted\n");
                    System.out.println("Accepted");
                }
                instantState = inputFile.getStartState();
                fW.write("\n");
            }
            fW.close();
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }


    private static class RecursivePart {
        public List<String> routeTaken = new ArrayList<>();
        public FetchInput file;
        public PdaStack stack = new PdaStack();
        public RecursivePart() { } // Default constructor

        // Other constructor
        private RecursivePart(FetchInput file, PdaStack stack) throws IOException {
            this.stack = stack;
            this.file = file;
        }

        // Other constructor 2
        public RecursivePart(FetchInput file) throws IOException {
            this.file = file;
        }

        public List<String> recur(String input, FetchInput f) throws IOException {
            if (stack.stackSymbolsOfThePDA.isEmpty()
                    && input.length() == 0) {
                return this.routeTaken;
            }

            Iterator<Transition> iterator = f.getTransitions().iterator();
            while (iterator.hasNext()) {
                Transition transition = iterator.next();
                if (transition.getFromState().equals(getLastFromRouteTaken(routeTaken))) {
                    boolean boo1 = transition.isNonDeterministic();
                    if (boo1) {
                        PdaStack stackForRecursion = new PdaStack(stack);
                        RecursivePart recurrence = createInstance(stackForRecursion);
                        recurrence.routeTaken.add(transition.getToState());
                        routeTaken.addAll(recurrence.recur(input, f));
//                        System.out.println("---");
//                        System.out.println("routeTaken: " + routeTaken);
//                        System.out.println("---");
                        return routeTaken;
                    }
                    else if (transition.isEpsilon()) {
                        PdaStack stackForRecursion = new PdaStack(stack);
                        RecursivePart reccurP = new RecursivePart(f, stackForRecursion);
                        boolean boo2 = !transition.getPop().equals("ε");
                        if (boo2) {
                            if (stackForRecursion.top().equals(transition.getPop())) {
                                stackForRecursion.pop();
                                stackForRecursion.push(transition.getPush());
                                reccurP.routeTaken.add(transition.getToState());
                                routeTaken.addAll(reccurP.recur(input, f));
//                                System.out.println("---");
//                                System.out.println("routeTaken: " + routeTaken);
//                                System.out.println("---");
                            }
                        } else {
                            stackForRecursion.push(transition.getPush());
                            reccurP.routeTaken.add(transition.getToState());
                            routeTaken.addAll(reccurP.recur(input, f));
//                            System.out.println("---");
//                            System.out.println("routeTaken: " + routeTaken);
//                            System.out.println("---");
                        }
//                        System.out.println("---");
//                        System.out.println("routeTaken: " + routeTaken);
//                        System.out.println("---");
                        return routeTaken;
                    } else {
                        boolean boo3 = getLastFromRouteTaken(routeTaken).equals(transition.getFromState())
                                && input.length() != 0;
                        if (boo3) {
                            boolean boo4 = transition.getSymbol().equals(input.charAt(0) + "");
                            if (boo4) {
                                if (!transition.getPop().equals("ε")) {
                                    if (stack.top().equals(transition.getPop())) {
                                        stack.pop();
                                        stack.push(transition.getPush());
                                        routeTaken.add(transition.getToState());
//                                        System.out.println("---");
//                                        System.out.println("routeTaken: " + routeTaken);
//                                        System.out.println("---");
                                        return this.recur(input.substring(1), f);
                                    }
                                } else {
                                    stack.push(transition.getPush());
                                    routeTaken.add(transition.getToState());
//                                    System.out.println("---");
//                                    System.out.println("routeTaken: " + routeTaken);
//                                    System.out.println("---");
                                    return this.recur(input.substring(1), f);
                                }
//                                System.out.println("---");
//                                System.out.println("routeTaken: " + routeTaken);
//                                System.out.println("---");
                                return routeTaken;
                            }
                        }
                    }
                }
            }
            return new ArrayList<>();
        }

        private String getLastFromRouteTaken(List<String> routeTaken) {
            String str = routeTaken.get(routeTaken.size() - 1);
            return str;
        }

        private RecursivePart createInstance(PdaStack stack) throws IOException {
            return new RecursivePart(file, stack);
        }
    }
}



