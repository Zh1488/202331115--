package 版本1;
public class MainV10 {
    public static void main(String[] args) {
        System.out.println("========== 版本1.0：基础类设计 ==========\n");

        // 1. 测试算式类
        System.out.println("1. 单个算式测试：");
        Exercise ex1 = new Exercise(25, 30, '+');
        System.out.println("算式: " + ex1 + "，有效: " + ex1.isValid());

        Exercise ex2 = new Exercise(50, 30, '-');
        System.out.println("算式: " + ex2 + "，有效: " + ex2.isValid());

        // 2. 测试习题类
        System.out.println("\n2. 习题类测试：");

        ExerciseSet set1 = new ExerciseSet();
        set1.generateExercises(5, '+');
        set1.displayWithAnswers();

        ExerciseSet set2 = new ExerciseSet();
        set2.generateExercises(5, '-');
        set2.displayWithoutAnswers();

        System.out.println("\n========== 版本1.0完成 ==========");
    }
}
