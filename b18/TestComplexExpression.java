package b18;

public class TestComplexExpression {

    public static void main(String[] args) {

        String tokenString = "3 1 6 * + 9 *";
        ComplexExpression suffixExp = new ComplexExpression(tokenString);
        double result = suffixExp.interpret();
        System.out.println("Result convert " +tokenString + " : " + result);
        }
}