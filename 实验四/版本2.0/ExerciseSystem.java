package 版本2;

// 版本2.0/ExerciseSystem.java
public class ExerciseSystem {
    private ExerciseSetV2 exerciseSet = new ExerciseSetV2();

    public void generate50AdditionExercises() {
        exerciseSet.clear();
        exerciseSet.generateAdditionExercises(50);
        System.out.println("已生成50道加法题");
    }

    public void generate50SubtractionExercises() {
        exerciseSet.clear();
        exerciseSet.generateSubtractionExercises(50);
        System.out.println("已生成50道减法题");
    }

    public void generate50MixedExercises() {
        exerciseSet.clear();
        exerciseSet.generateMixedExercises(25, 25);
        System.out.println("已生成50道混合题（25加+25减）");
    }

    public void generate100MixedExercises() {
        exerciseSet.clear();
        exerciseSet.generateMixedExercises(50, 50);
        System.out.println("已生成100道混合题（50加+50减）");
    }

    public void generate150Exercises() {
        exerciseSet.clear();
        exerciseSet.generateAdditionExercises(50);
        exerciseSet.generateSubtractionExercises(50);

        // 额外50道随机混合
        for (int i = 0; i < 50; i++) {
            if (Math.random() > 0.5) {
                exerciseSet.generateAdditionExercises(1);
            } else {
                exerciseSet.generateSubtractionExercises(1);
            }
        }
        System.out.println("已生成150道题（50加+50减+50混合）");
    }

    public void displayExercises() {
        exerciseSet.displayFormatted();
        System.out.println("总题数: " + exerciseSet.getCount());
    }
}
