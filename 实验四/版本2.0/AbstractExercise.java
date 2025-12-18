package 版本2;

// 版本2.0/AbstractExercise.java
public abstract class AbstractExercise {
    protected int operand1;
    protected int operand2;
    protected int answer;

    public AbstractExercise(int operand1, int operand2) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.answer = calculate();
    }

    public abstract int calculate();
    public abstract boolean isValid();
    public abstract char getOperator();

    public String toString() {
        return String.format("%3d %c %3d = %3d", operand1, getOperator(), operand2, answer);
    }

    public String toStringWithoutAnswer() {
        return String.format("%3d %c %3d = ", operand1, getOperator(), operand2);
    }

    public int getOperand1() { return operand1; }
    public int getOperand2() { return operand2; }
    public int getAnswer() { return answer; }
}
