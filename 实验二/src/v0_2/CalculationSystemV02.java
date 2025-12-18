package v_02;// CalculationSystem-V0.2.java
import utils.MathExerciseUtils;

/**
 * 加减法口算练习系统 - 版本0.2
 * 故事二：每行多显示几个算式，并显示答案
 */
public class CalculationSystemV02 {

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("   加减法口算练习系统 - v0.2");
        System.out.println("========================================");
        System.out.println("故事二：显示答案，每行多题，整齐排列");
        System.out.println("========================================\n");

        final int QUESTIONS_PER_ROW = 5; // 每行显示5道题
        int questionCount = 0;

        // 生成50道题目
        for (int i = 1; i <= 50; i++) {
            // 随机决定运算符
            char operator = MathExerciseUtils.generateRandomOperator();

            // 生成有效的算式
            int[] numbers = MathExerciseUtils.generateValidExpression(operator);
            int num1 = numbers[0];
            int num2 = numbers[1];

            // 输出算式（包含答案）
            String expression = MathExerciseUtils.formatExpression(num1, num2, operator, true);
            System.out.printf("第%2d题: %s\t", i, expression);

            questionCount++;

            // 每行显示QUESTIONS_PER_ROW道题后换行
            if (questionCount % QUESTIONS_PER_ROW == 0) {
                System.out.println();
            }
        }

        // 如果最后一行未满，补上换行
        if (questionCount % QUESTIONS_PER_ROW != 0) {
            System.out.println();
        }

        System.out.println("\n========================================");
        System.out.println("      题目生成完成！共50题");
        System.out.println("      每行显示" + QUESTIONS_PER_ROW + "题，含答案");
        System.out.println("========================================");
    }
}