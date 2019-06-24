package interpreter.bytecode;
import java.util.HashMap;

import interpreter.VirtualMachine;
import interpreter.bytecode.BopOperators.*;

public abstract class BopCode extends ByteCode {
    private String operator;
    private static HashMap<String, BopCode> operators = new HashMap<>();

    static {
        operators.put("+", new AddOperator());
        operators.put("-", new SubOperator());
        operators.put("*", new MultiOperator());
        operators.put("/", new DivideOperator());
        operators.put("==", new isEqualOperator());
        operators.put("!=", new notEqualOperator());
        operators.put("<", new LessThanOperator());
        operators.put("<=", new LessEqualOperator());
        operators.put(">", new GreaterThanOperator());
        operators.put(">=", new GreaterEqualOperator());
        operators.put("|", new OrOperator());
        operators.put("&", new AndOperator());
    }

    public void init(String a, String b) {
        operator = a;
    }

    public abstract void execute(VirtualMachine vm);

    public String toString() {
        StringBuffer s = new StringBuffer();
        s.append("BOP " + operator);
        return s.toString();
    }

    public static BopCode getOperator(String token) {
        return operators.get(token);
    }
}
