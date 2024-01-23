package Algorithm;
import java.util.List;  // Importing List from util library
import java.util.ArrayList; // Importing ArrayList from util library
public class PdaStack {

    public String startSymbol = ""; // Here initializing the first symbol of the stack
    public List<String> stackSymbolsOfThePDA = new ArrayList<>();

    public PdaStack() { } // Default constructor

    // Other constructor for initialization
    public PdaStack(PdaStack stack) {
        this.stackSymbolsOfThePDA = stack.stackSymbolsOfThePDA;
        this.startSymbol = stack.startSymbol;
    }

    // Get the top symbol of the stack
    public String top() {
        if(stackSymbolsOfThePDA.isEmpty()) {
            return null;
        }
        String top = stackSymbolsOfThePDA.get(stackSymbolsOfThePDA.size() - 1);
        return top;
    }

    // Push method of the stack
    public void push(String string) {
        if (!string.equals("ε"))
            stackSymbolsOfThePDA.add(string);
    }

    // Pop method of the stack
    public String pop() {
        if (stackSymbolsOfThePDA.isEmpty()) {
            return "";
        } else {
            String last = this.top();
            stackSymbolsOfThePDA.remove(stackSymbolsOfThePDA.size() - 1);
            return last;
        }
    }
}
