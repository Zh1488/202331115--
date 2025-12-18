package 版本2;

// 版本2.0/MainV20.java
public class MainV20 {
    public static void main(String[] args) {
        System.out.println("========== 版本2.0：继承体系设计 ==========\n");

        ExerciseSystem system = new ExerciseSystem();

        System.out.println("1. 生成50道加法题：");
        system.generate50AdditionExercises();
        system.displayExercises();

        System.out.println("\n2. 生成50道减法题：");
        system.generate50SubtractionExercises();
        system.displayExercises();

        System.out.println("\n3. 生成50道混合题：");
        system.generate50MixedExercises();
        system.displayExercises();

        System.out.println("\n4. 生成100道混合题：");
        system.generate100MixedExercises();
        system.displayExercises();

        System.out.println("\n5. 生成150道题：");
        system.generate150Exercises();
        system.displayExercises();

        System.out.println("\n========== 版本2.0完成 ==========");
        System.out.println("实验要求全部完成：");
        System.out.println("✓ 算式抽象类 + 加减法子类");
        System.out.println("✓ 习题类 + 习题集系统类");
        System.out.println("✓ 50加法 + 50减法 + 50混合题生成");
        System.out.println("✓ 格式化显示功能");
    }
}
