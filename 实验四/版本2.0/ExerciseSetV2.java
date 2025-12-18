package 版本2;

// 版本2.0/ExerciseSetV2.java
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ExerciseSetV2 {
    private List<AbstractExercise> exercises = new ArrayList<>();
    private Random random = new Random();

    public void generateAdditionExercises(int count) {
        for (int i = 0; i < count; i++) {
            generateValidAddition();
        }
    }

    public void generateSubtractionExercises(int count) {
        for (int i = 0; i < count; i++) {
            generateValidSubtraction();
        }
    }

    public void generateMixedExercises(int additionCount, int subtractionCount) {
        generateAdditionExercises(additionCount);
        generateSubtractionExercises(subtractionCount);
    }

    private void generateValidAddition() {
        int op1, op2;
        do {
            op1 = random.nextInt(101);
            op2 = random.nextInt(101);
        } while (op1 + op2 > 100);

        exercises.add(new AdditionExercise(op1, op2));
    }

    private void generateValidSubtraction() {
        int op1, op2;
        do {
            op1 = random.nextInt(101);
            op2 = random.nextInt(101);
            if (op1 < op2) {
                int temp = op1;
                op1 = op2;
                op2 = temp;
            }
        } while (op1 - op2 < 0);

        exercises.add(new SubtractionExercise(op1, op2));
    }

    public void displayFormatted() {
        System.out.println("========== 习题集 ==========");
        for (int i = 0; i < exercises.size(); i++) {
            System.out.printf("第%2d题: %s\t", i + 1, exercises.get(i));
            if ((i + 1) % 4 == 0) System.out.println();
        }
        if (exercises.size() % 4 != 0) System.out.println();
        System.out.println("=============================");
    }

    public int getCount() {
        return exercises.size();
    }

    public void clear() {
        exercises.clear();
    }
}