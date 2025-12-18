// TestMathExerciseUtils.java (测试模块)
import utils.MathExerciseUtils;

/**
 * 数学练习工具测试类
 * 用于验证各个功能模块的正确性
 */
public class TestMathExerciseUtils {

    public static void main(String[] args) {
        System.out.println("开始测试数学练习工具类...\n");

        // 测试1：随机数生成
        System.out.println("测试1：随机数生成");
        System.out.println("生成5个0-100的随机数：");
        for (int i = 0; i < 5; i++) {
            System.out.print(MathExerciseUtils.generateRandomNumber() + " ");
        }
        System.out.println("\n");

        // 测试2：算式有效性验证
        System.out.println("测试2：算式有效性验证");
        testExpression(25, 30, '+');  // 应有效：25+30=55
        testExpression(80, 30, '+');  // 应有效：80+30=110（无效）
        testExpression(50, 30, '-');  // 应有效：50-30=20
        testExpression(20, 50, '-');  // 应有效：20-50=-30（无效）
        System.out.println();

        // 测试3：计算结果
        System.out.println("测试3：计算结果");
        System.out.println("25 + 30 = " + MathExerciseUtils.calculateResult(25, 30, '+'));
        System.out.println("50 - 30 = " + MathExerciseUtils.calculateResult(50, 30, '-'));

        System.out.println("\n所有测试完成！");
    }

    private static void testExpression(int num1, int num2, char operator) {
        boolean isValid = MathExerciseUtils.isValidExpression(num1, num2, operator);
        String expression = num1 + " " + operator + " " + num2;
        System.out.println(expression + " : " + (isValid ? "有效" : "无效"));
    }
}