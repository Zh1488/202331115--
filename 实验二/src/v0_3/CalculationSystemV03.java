package v_03;// CalculationSystem-V0.3.java
import utils.MathExerciseUtils;
import java.util.HashSet;

/**
 * 加减法口算练习系统 - 版本0.3
 * 故事三：避免重复算式，控制加减法比例
 */
public class CalculationSystemV03 {

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("   加减法口算练习系统 - v0.3");
        System.out.println("========================================");
        System.out.println("故事三：无重复算式，控制加减法比例");
        System.out.println("========================================\n");

        final int TOTAL_QUESTIONS = 50;
        final int QUESTIONS_PER_ROW = 4;
        final double ADDITION_RATIO = 0.6; // 60%加法题，40%减法题
        final int ADDITION_COUNT = (int)(TOTAL_QUESTIONS * ADDITION_RATIO);

        HashSet<String> usedExpressions = new HashSet<>();
        int questionCount = 0;
        int additionCount = 0;
        int subtractionCount = 0;

        System.out.println("题目要求：");
        System.out.println("- 总共 " + TOTAL_QUESTIONS + " 道题");
        System.out.println("- 加法题比例: " + (ADDITION_RATIO * 100) + "% (" + ADDITION_COUNT + " 题)");
        System.out.println("- 减法题比例: " + ((1-ADDITION_RATIO) * 100) + "% (" + (TOTAL_QUESTIONS-ADDITION_COUNT) + " 题)");
        System.out.println("- 无重复算式");
        System.out.println("========================================\n");

        // 生成题目直到达到总数
        while (questionCount < TOTAL_QUESTIONS) {
            // 根据比例决定运算符
            char operator;
            if (additionCount < ADDITION_COUNT && subtractionCount < (TOTAL_QUESTIONS - ADDITION_COUNT)) {
                // 两种题型都还需要，随机选择
                operator = MathExerciseUtils.generateRandomOperator();
            } else if (additionCount < ADDITION_COUNT) {
                // 只缺加法题
                operator = '+';
            } else {
                // 只缺减法题
                operator = '-';
            }

            // 生成有效的算式
            int[] numbers = MathExerciseUtils.generateValidExpression(operator);
            int num1 = numbers[0];
            int num2 = numbers[1];

            // 创建算式唯一标识（避免重复）
            String expressionKey = num1 + "" + operator + "" + num2;

            // 检查是否重复
            if (!usedExpressions.contains(expressionKey)) {
                usedExpressions.add(expressionKey);

                // 更新计数器
                if (operator == '+') {
                    additionCount++;
                } else {
                    subtractionCount++;
                }

                questionCount++;

                // 输出算式（包含答案）
                String expression = MathExerciseUtils.formatExpression(num1, num2, operator, true);
                System.out.printf("第%2d题: %s\t", questionCount, expression);

                // 每行显示QUESTIONS_PER_ROW道题后换行
                if (questionCount % QUESTIONS_PER_ROW == 0) {
                    System.out.println();
                }
            }
        }

        // 如果最后一行未满，补上换行
        if (questionCount % QUESTIONS_PER_ROW != 0) {
            System.out.println();
        }

        System.out.println("\n========================================");
        System.out.println("      题目生成完成！");
        System.out.println("      加法题: " + additionCount + " 道");
        System.out.println("      减法题: " + subtractionCount + " 道");
        System.out.println("      无重复算式");
        System.out.println("========================================");
    }
}