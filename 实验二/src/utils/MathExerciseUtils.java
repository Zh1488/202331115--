// utils/MathExerciseUtils.java
package utils;

import java.util.Random;
import java.util.HashSet;

/**
 * 数学练习工具类
 * 提供生成算式、检查答案、格式化输出等通用功能
 */
public class MathExerciseUtils {
    private static Random random = new Random();

    /**
     * 生成一个100以内的随机整数
     * @return 0-100之间的随机整数
     */
    public static int generateRandomNumber() {
        return random.nextInt(101); // 0到100 inclusive
    }

    /**
     * 生成指定范围内的随机整数
     * @param min 最小值
     * @param max 最大值
     * @return min-max之间的随机整数
     */
    public static int generateRandomNumber(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    /**
     * 随机决定运算符（加法或减法）
     * @return '+' 或 '-'
     */
    public static char generateRandomOperator() {
        return random.nextBoolean() ? '+' : '-';
    }

    /**
     * 计算算式结果
     * @param num1 第一个数
     * @param num2 第二个数
     * @param operator 运算符 ('+' 或 '-')
     * @return 计算结果
     */
    public static int calculateResult(int num1, int num2, char operator) {
        if (operator == '+') {
            return num1 + num2;
        } else {
            return num1 - num2;
        }
    }

    /**
     * 验证算式是否有效（针对100以内加减法）
     * @param num1 第一个数
     * @param num2 第二个数
     * @param operator 运算符
     * @return true如果算式有效，否则false
     */
    public static boolean isValidExpression(int num1, int num2, char operator) {
        if (operator == '+') {
            return (num1 + num2) <= 100;
        } else {
            return (num1 - num2) >= 0;
        }
    }

    /**
     * 生成有效的算式（保证结果在合理范围内）
     * @param operator 运算符
     * @return 包含两个操作数的数组 [num1, num2]
     */
    public static int[] generateValidExpression(char operator) {
        int num1, num2;

        do {
            num1 = generateRandomNumber();
            num2 = generateRandomNumber();

            // 对于减法，确保num1 >= num2
            if (operator == '-' && num1 < num2) {
                int temp = num1;
                num1 = num2;
                num2 = temp;
            }

        } while (!isValidExpression(num1, num2, operator));

        return new int[]{num1, num2};
    }

    /**
     * 将算式格式化为字符串
     * @param num1 第一个数
     * @param num2 第二个数
     * @param operator 运算符
     * @param includeAnswer 是否包含答案
     * @return 格式化后的算式字符串
     */
    public static String formatExpression(int num1, int num2, char operator, boolean includeAnswer) {
        String expression = String.format("%3d %c %3d = ", num1, operator, num2);

        if (includeAnswer) {
            int result = calculateResult(num1, num2, operator);
            expression += String.format("%3d", result);
        }

        return expression;
    }
}