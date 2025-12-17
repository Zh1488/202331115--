import java.util.Random;

/**
 * Lab_01.java
 * 实验一：50道100以内加减法口算习题程序
 * 说明：按照实验要求，程序自动生成题目并附答案，方便核对。
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("       50道100以内加减法口算题");
        System.out.println("========================================");
        System.out.println(); // 空行

        Random random = new Random();
        int questionNumber = 1; // 题目序号

        // 循环生成50道题目
        for (int i = 0; i < 50; i++) {
            int num1 = random.nextInt(101); // 生成0-100的随机数
            int num2 = random.nextInt(101);
            boolean isAddition = random.nextBoolean(); // 随机决定是加法还是减法
            String operator;
            int correctAnswer;

            if (isAddition) {
                // 处理加法：确保两数之和不大于100
                while (num1 + num2 > 100) {
                    num1 = random.nextInt(101);
                    num2 = random.nextInt(101);
                }
                operator = "+";
                correctAnswer = num1 + num2;
            } else {
                // 处理减法：确保被减数不小于减数，结果非负[citation:4][citation:9]
                if (num1 < num2) {
                    int temp = num1;
                    num1 = num2;
                    num2 = temp;
                }
                operator = "-";
                correctAnswer = num1 - num2;
            }

            // 格式化输出题目和答案
            System.out.printf("第%2d题: %3d %s %3d = ?\t\t【答案：%d】%n",
                    questionNumber, num1, operator, num2, correctAnswer);
            questionNumber++;
        }

        System.out.println("\n========================================");
        System.out.println("        题目生成完毕！共50题。");
        System.out.println("========================================");
    }
}