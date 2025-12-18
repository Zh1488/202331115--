package 版本2;

// 版本2.0/AdditionExercise.java
public class AdditionExercise extends AbstractExercise {
    public AdditionExercise(int operand1, int operand2) {
        super(operand1, operand2);
    }

    @Override
    public int calculate() {
        return operand1 + operand2;
    }

    @Override
    public boolean isValid() {
        return operand1 >= 0 && operand1 <= 100 &&
                operand2 >= 0 && operand2 <= 100 &&
                calculate() <= 100;
    }

    @Override
    public char getOperator() {
        return '+';
    }
}