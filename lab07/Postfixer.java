package lab07;

import java.util.*;



//Extension of Chapter 14.4 Case Study: Expression Evaluator

public class Postfixer {


	/**
	*  Determines if the first operator has same or greater
    *  precedence than the second
	*
	* @param op1 the first operator
	* @param op2 the second operator
	* @return the boolean result
	*/
	private static boolean hasPrecedence(String op1, String op2) {
		  int precedenceChecker = opToPrcd(op1);
		  int precedenceChecker2 = opToPrcd(op2);
		  if (precedenceChecker < precedenceChecker2) {
			  System.out.println("op1 has greater precedence than op2");
		    return true;
		  }
		  if (precedenceChecker == precedenceChecker2) {
		    System.out.println("both strings have same precedence");
		    return true;
		  }

		  return false; // placeholder
		}


	/**
	* Converts an operator to its precedence priority
	*
	* We expect you to be able to handle +, -, *, /, ^, and (
	* (why don't you need ")" as well? see algorithm in part 4)
	*
	* The order of these is as follows:
	*    ^, * and /, + and -, (
	*
	* @param op a string representing an operator, e.g. "+" or "-"
	* @return an integer value reflecting its precedence
	*/
	private static int opToPrcd(String op) {
		  String[] operatorCheck = {
		    "+",
		    "-",
		    "/",
		    "*",
		    "^",
		    "("
		    
		  };
		  for (int i = 0; i < operatorCheck.length - 1; i++) {
		    if (operatorCheck[i] == "+" || operatorCheck[i] == "-") {
		      return 3;
		    }
		    if (operatorCheck[i] == "/" || operatorCheck[i] == "*") {
		      return 2;
		    }
		    if (operatorCheck[i] == "(" ||operatorCheck[i] == ")") {
		      return 4;
		    }
		    if (operatorCheck[i] == "^") return 1;
		  }

		  return - 1; // placeholder
		}

	/**
	* determines if the input token is an operator
	*
	* @param token the string token to check
	* @return a boolean reflecting the result
	*/
	private static boolean isOperator(String token) {
		  String[] operatorCheck = {
		    "+",
		    "-",
		    "/",
		    "*",
		    "^",
		    "(",
		    ")"
		  };
		  for (int i = 0; i < operatorCheck.length - 1; i++) {
		    if (operatorCheck[i] == token) return true;
		  }

		  return false;
		}

	/**
    * Evaluates an expression
    *
    * NOTE Beware the order of pop and evaluation when receiving operand1
    * and operand2 as input.
    *
    * @param operand1 the first operand
    * @param operator the operator to apply
    * @param operand2 the second operand
    * @return a double expressing the result
    * @throws IllegalArgumentException if operator passed is not one of
    *  "+", "-", "*", "/", or "^"
    *
	*/
	private static double evaluate(double operand1, String operator, double operand2) {
	    double result = 0.0;
	    if (isOperator(operator)== true) {// re-factor with ternary operators
	        //try {
	            if (operator == "*") {
	                result = operand1 * operand2;
	                //return result;
	            }
	            else if (operator == "^") {
	                result = Math.pow(operand1, operand2);
	                //return result;
	            }
	            else if (operator == "/") {
	                result = operand1 / operand2;
	                //return result;
	            }
	            else if (operator == "+") {
	                result = operand1 + operand2;
	                //return result;
	            }
	            else if (operator == "-") {
	                result = operand1 - operand2;
	            }
	            else 
	            	 throw new IllegalArgumentException("the variable passed to operator is not a operator ");
	       // } catch (IllegalArgumentException e) {
	           // System.out.println("the variable passed to operator needs to be a operator");
	        //}
	    }
	    return result;//make sure this is being reached
	}


	/**
	* give a description of the purpose of this method
	* @param line fill in
	* @return fill in
	*/
	public static double infixEvaluator(String line) {

	    StringSplitter data = new StringSplitter(line);
	    Stack < String > operators = new Stack < String > ();
	    Stack < Double > operands = new Stack < Double > ();
	    
	    String tokenOfData = data.next();
	    while (data.hasNext()) { //number
	        if (tokenOfData.equals("(")) { // 1.2
	            operators.push(tokenOfData);
	            
	        }
	        else if (tokenOfData.equals(")")) { //1.3
	            while (!operators.peek().equals("(")) { //1.3.1 !a.equals(b)
	                
	                	double result = evaluate(operands.pop(), operators.pop(), operands.pop()); //need to implement has-precedence 
		                operands.push(result); 
		               
	            }
	            operators.pop();
	             //check if "(" is being popped
	        } //end of "("  if statements
	        else if ((isOperator(tokenOfData)==true) ) { //1.1&& !data.peek().equals(")")
	            
	            	double i = Double.parseDouble(data.peek());
		            operands.push(i);
	            
	        }
	        else {
	        	 while (!(operators.isEmpty()) && (hasPrecedence(operators.peek(), tokenOfData) == true)) { // maybe change to data.next
	        		 String op = operators.pop();
	        		 double op1 =operands.pop();
	        		 double op2 = operands.pop();
	        		 double result = evaluate(op1, op, op2); //need to implement has-precedence 
	 	            operands.push(result);
	 	        }
	        	 operators.push(tokenOfData);
	        }
	       
	        
	    } //this column means that we traversed through the stack
	    
	    while (!operators.isEmpty()) {
	        double result = evaluate(operands.pop(), operators.pop(), operands.pop()); //need to implement has-precedence 
	        operands.push(result);
	    }
	    //check if the operator stack is empty
	    double resultOfOperands = operands.pop();

	    return resultOfOperands; // placeholder

	}

	/**
	* give a description of the purpose of this method
	* @param line fill in
	* @return fill in
	*/
	public static String toPostfix(String line){// finish this helper method 
		return null; // placeholder
	}


	public static void main(String[] args){

        if (infixEvaluator("10 + 2") != 12)
            System.err.println("test1 failed --> your answer should have been 12");

        if (infixEvaluator("10 - 2 * 2 + 1") != 7)
            System.err.println("test1 failed --> your answer should have been 12");

        if (infixEvaluator("100 * 2 + 12") != 212)
            System.err.println("test2 failed --> your answer should have been 212");

        if (infixEvaluator("100 * ( 2 + 12 )") != 1400)
            System.err.println("test3 failed --> your answer should have been 1400");

        if (infixEvaluator("100 * ( 2 + 12 ) / 14") != 100)
            System.err.println("test4 failed --> your answer should have been 100");


        System.out.println("Lab Testing Done!!!");
        
        
        
       //Testing for helper methods 
        /*String helperTest_1 = "*";
        String helperTest_2 = "(";
        String helperTest_3 = "-";
        String helperTest_4 = "3";
        String helperTest_5 = "^";*/
        /* uncomment the below lines for assignmemt */
		// if (!toPostfix(new String("(4+5)")).equals("45+"))
		//     System.err.println("test1 failed --> should have been 45+");

		// if (!toPostfix(new String("((4+5)*6)")).equals("45+6*"))
		//     System.err.println("test2 failed --> should have been 45+6*");

		// if (!toPostfix(new String("((4+((5*6)/7))-8)")).equals("456*7/+8-"))
		//     System.err.println("test3 failed --> should have been 456*7/+8-");

		// if (!toPostfix(new String("((4+5*(6-7))/8)")).equals("4567-*+8/"))
		//     System.err.println("test4 failed --> should have been 4567-*+8/");

		// if (!toPostfix(new String("(9+(8*7-(6/5^4)*3)*2)")).equals("987*654^/3*-2*+"))
		//     System.err.println("test5 failed --> should have been 987*654^/3*-2*+");


        // System.out.println("Assignment Testing Done!!!");


	}

}
