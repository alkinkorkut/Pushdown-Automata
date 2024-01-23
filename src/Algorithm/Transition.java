package Algorithm;

public class Transition {
    private String fromState;
    private String toState;
    private String symbol;
    private String pop;
    private String push;

    public Transition () { } // Default constructor

    public Transition(String fromState, String symbol, String pop, String push, String toState) {
        this.fromState = fromState;
        this.toState = toState;
        this.symbol = symbol;
        this.pop = pop;
        this.push = push;
    }

    public String getFromState() {
        return fromState;
    }

    public String getToState() {
        return toState;
    }

    public String getSymbol() {
        return symbol;
    }

    public boolean isNonDeterministic() {
        return symbol.equals("ε") && pop.equals("ε") && push.equals("ε");
    }

    public String getPop() {
        return pop;
    }

    public String getPush() {
        return push;
    }

    public boolean isEpsilon() {
        return symbol.equals("ε");
    }





}
