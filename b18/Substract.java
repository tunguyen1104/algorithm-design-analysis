package b18;

public class Substract implements Expression{
    
    private final Expression leftExpression;
    private final Expression rightExpression;

    public Substract(Expression leftExpression,Expression rightExpression ){
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }
    @Override
    public double interpret() {
        return leftExpression.interpret() - rightExpression.interpret();
    }

}
