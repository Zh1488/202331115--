package v_01;// CalculationSystem-V0.1.java
import utils.MathExerciseUtils;

/**
 * 加减法口算练习系统 - 版本0.1
 * 故事一：生成50道100以内加法/减法算式的习题
 */
public class CalculationSystemV01 {

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("   加减法口算练习系统 - v0.1");
        System.out.println("========================================");
        System.out.println("故事一：生成50道100以内加减法算式");
        System.out.println("========================================\n");

        // 生成50道题目
        for (int i = 1; i <= 50; i++) {
            // 随机决定运算符
            char operator = MathExerciseUtils.generateRandomOperator();

            // 生成有效的算式
            int[] numbers = MathExerciseUtils.generateValidExpression(operator);
            int num1 = numbers[0];
            int num2 = numbers[1];

            // 输出算式（不包含答案）
            String expression = MathExerciseUtils.formatExpression(num1, num2, operator, false);
            System.out.printf("第%2d题: %s%n", i, expression);
        }

        System.out.println("\n========================================");
        System.out.println("      题目生成完成！共50题");
        System.out.println("========================================");
    }
}