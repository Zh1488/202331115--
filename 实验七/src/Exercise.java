public class Exercise {
    private int operand1;
    private int operand2;
    private char operator;
    private int answer;

    public Exercise(int operand1, int operand2, char operator) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operator = operator;
        this.answer = calculate();
    }

    public int calculate() {
        return operator == '+' ? operand1 + operand2 : operand1 - operand2;
    }

    public boolean isValid() {
        if (operand1 < 0 || operand1 > 100 || operand2 < 0 || operand2 > 100) {
            return false;
        }
        int result = calculate();
        return result >= 0 && result <= 100;
    }

    public String toString() {
        return String.format("%3d %c %3d = %3d", operand1, operator, operand2, answer);
    }

    // Getters
    public int getOperand1() { return operand1; }
    public int getOperand2() { return operand2; }
    public char getOperator() { return operator; }
    public int getAnswer() { return answer; }
}