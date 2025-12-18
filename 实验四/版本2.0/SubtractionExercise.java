package 版本2;

// 版本2.0/SubtractionExercise.java
public class SubtractionExercise extends AbstractExercise {
    public SubtractionExercise(int operand1, int operand2) {
        super(operand1, operand2);
    }

    @Override
    public int calculate() {
        return operand1 - operand2;
    }

    @Override
    public boolean isValid() {
        return operand1 >= 0 && operand1 <= 100 &&
                operand2 >= 0 && operand2 <= 100 &&
                operand1 >= operand2 &&
                calculate() >= 0;
    }

    @Override
    public char getOperator() {
        return '-';
    }
}
