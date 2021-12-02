package unl.cse;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PostfixEvaluator {

	private static final Set<String> OPERATORS = new HashSet<String>(Arrays.asList("+", "-", "*", "/"));
	private final Stack<String> stack;
	
    /**
     * Constructor
     */
    public PostfixEvaluator() {
        this.stack = new Stack<String>();
    }

    private boolean isOperator(String s){
    	return OPERATORS.contains(s);
    }
    
    private String evaluate(String a, String b, String op) {
    	double d1 = Double.parseDouble(a);
    	double d2 = Double.parseDouble(b);
    	double result;
    	if(op.equals("+")) {
    		result = d1 + d2;
    	} else if(op.equals("-")) {
    		result = d1 - d2;
    	} else if(op.equals("*")) {
    		result = d1 * d2;
    	} else if(op.equals("/")) {
    		result = d1 / d2;
    	} else {
    		throw new IllegalStateException("Unrecognized operator: "+op);
    	}
    	return Double.toString(result);
    }

    /**
     * Evaluates the given arithmetic expression in postfix format
     * change this method
     * @param expression
     * @return
     */
    double evaluateExpression(String expression) {
    	String values[] = expression.split("\\s+");
    	String num1 = "";
    	String num2 = "";
    	String op = "";
    	for(String v : values) {
    		/*
    		 * TODO: implement this method
    		 * Hint: 
    		 *   If v is an operator:
    		 *      pop b, a off the stack and call this.evaluate
    		 *      push the result back onto the top of the stack
    		 *   Else
    		 *      push the operand (number) onto the stack
    		 */
    		if (!OPERATORS.contains(v))
    			stack.push(v);
    		if (OPERATORS.contains(v))
    		{
    			num1 = stack.pop();
        		num2 = stack.pop();
    			stack.push(this.evaluate(num2,num1,v));
    		}
    	}
    	//At this point, the final result should be on the top of the stack,
    	//we pop it off, parse it and return the result
    	Double d = Double.parseDouble(this.stack.pop());
        return d;
    }

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {

        PostfixEvaluator postfixEvaluator = new PostfixEvaluator();
        System.out.print("Please enter the Arithmatic Expression (Postfix form) to evaluate: ");
        Scanner myScanner = new Scanner(System.in);
        String expression = myScanner.nextLine();
        myScanner.close();
        System.out.println(expression);
        System.out.println("Result: " + postfixEvaluator.evaluateExpression(expression));
    }
}
