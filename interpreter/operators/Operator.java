package interpreter.operators;

import interpreter.InvalidTokenException;
import java.util.HashMap;

public abstract class Operator {

    private static HashMap<String, Operator> operators;

    static {
       operators = new HashMap<>();
       operators.put("+", new AddOperator());
       operators.put("-", new SubtractOperator());
       operators.put("*", new MultiplyOperator());
       operators.put("/", new DivideOperator());
       operators.put("==", new EqualOperator());
       operators.put("!=", new NotEqualOperator());
       operators.put("<=", new LessThanEqualOperator());
       operators.put(">=", new GreaterThanEqualOperator());
       operators.put("<", new LessThanOperator());
       operators.put(">", new GreaterThanOperator());
       operators.put("&", new LogicalAndOperator());
       operators.put("|", new LogicalOrOperator());

   }

//    /**
//     * retrieve the priority of an Operator
//     * @return priority of an Operator as an int
//     */
//    public abstract int priority();

    /**
     * Abstract method to execute an operator given two operands.
     * @param operandOne first operand of operator
     * @param operandTwo second operand of operator
     * @return an operand of the result of the operation.
     */
    public abstract int execute(int operandOne, int operandTwo);

    /**
     * used to retrieve an operator from our HashMap.
     * This will act as out publicly facing function,
     * granting access to the Operator HashMap.
     *
     * @param token key of the operator we want to retrieve
     * @return reference to a Operator instance.
     */
    public static Operator getOperator(String token) {
        //check if the token is valid
        if(!check(token)){
            new InvalidTokenException();
        }
        //use switch case to call the proper operators
        switch (token){
            case "+":
                return operators.get("+");
            case "-":
                return operators.get("-");
            case "*":
                return operators.get("*");
            case "/":
                return operators.get("/");
            case "==":
                return operators.get("==");
            case "!=":
                return operators.get("!=");
            case "<=":
                return operators.get("<=");
            case ">=":
                return operators.get(">=");
            case "<":
                return operators.get("<");
            case ">":
                return operators.get(">");
            case "&":
                return operators.get("&");
            case "|":
                return operators.get("|");
        }

        return operators.get(token);
    }

    
     /**
     * determines if a given token is a valid operator.
     * please do your best to avoid static checks
     * for example token.equals("+") and so on.
     * Think about what happens if we add more operators.
     */
    public static boolean check(String token) {
        return token.matches(".*[+\\-*/^].*");
    }

}
