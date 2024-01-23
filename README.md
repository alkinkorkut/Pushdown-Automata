# Pushdown-Automata (PDA)

The Pushdown Automaton (PDA) is implemented in this project by using Java programming language. 
It takes the information about the PDA from a text file and simulate the PDA for given strings. During 
the simulation progress, it will first provide the path (route taken) about the visited states and at the 
end the decision is determined whether the string(s) is/are accepted or rejected.

All logic is implemented based on the object oriented programming paradigm. The program reads the 
input from a text file (“input.txt”) to define the specifications of a pushdown automaton. These 
inputs consists of number of variables in input and stack alphabet, number of states, number of goal 
states, states, goal state(s), start state, variables (symbols) of the input and stack, transition relations 
and string information to be detected by PDA. 

<h2>Input File Format</h2>

• Line 1 consists of number of variables in input alphabet. </br>
• Line 2 consists of number of variables in stack alphabet. </br>
• Line 3 consists of number of goal states. </br>
• Line 4 consists of number of states. </br>
• Line 5 consists of state(s). </br>
• Line 6 consists of start state. </br>
• Line 7 consists of goal state(s). </br>
• Line 8 consists of stack alphabet. </br>
• Line 9 consists of initial stack symbol. </br>
• Line 10 consists of input alphabet. </br>
• Consecutive lines consists of transition relations. </br>
• After transition relations last consecutive lines consists of strings to be detected. </br>

<i>
Sample input file: 

2 </br> 
2 </br>
2 </br>
4 </br>
q1 q2 q3 q4 </br>
q1 </br>
q1 q4 </br>
X Y </br>
X </br>
0 1 </br>
q1 ε ε X q2 </br>
q2 0 ε Y q2 </br>
q2 1 Y ε q3 </br>
q3 1 Y ε q3 </br>
q3 ε X ε q4 </br>
0011 </br>
0111 </br>
</i>

<h2>Output File Format</h2> 
 
The route taken will be written in the first lines. The decision whether the string is accepted 
or rejected by the PDA will be written after. When the program executes, the output file will 
be generated if it is not in the directory of the project and the output will be available in the 
“output.txt”. Also after the execution, the output can be seen in the terminal. 

<i>
Sample output file: 
  
q1 q2 q2 q2 q3 q3 q4 (route taken) </br>
Accepted </br>
q1 q2 q2 q3 (route taken) </br>
Rejected
</i>

<h2>Conclusion</h2>

Based on the input parameters, the program effectively simulates a pushdown automaton, offering 
insights into the acceptance or rejection of input strings. Additional improvements might be made for 
a more complete and adaptable solution.
