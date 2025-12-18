package 版本1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ExerciseSet {
    private List<Exercise> exercises = new ArrayList<>();
    private Random random = new Random();

    public void generateExercises(int count, char operator) {
        exercises.clear();
        int generated = 0;

        while (generated < count) {
            int op1 = random.nextInt(101);
            int op2 = random.nextInt(101);

            if (operator == '-' && op1 < op2) {
                int temp = op1;
                op1 = op2;
                op2 = temp;
            }

            Exercise ex = new Exercise(op1, op2, operator);
            if (ex.isValid()) {
                exercises.add(ex);
                generated++;
            }
        }
    }

    public void displayWithAnswers() {
        System.out.println("===== 习题集（带答案） =====");
        for (int i = 0; i < exercises.size(); i++) {
            System.out.printf("第%2d题: %s%n", i + 1, exercises.get(i));
        }
    }

    public void displayWithoutAnswers() {
        System.out.println("===== 习题集（不带答案） =====");
        for (int i = 0; i < exercises.size(); i++) {
            System.out.printf("第%2d题: %s%n", i + 1, exercises.get(i).toStringWithoutAnswer());
        }
    }

    public int getCount() {
        return exercises.size();
    }
}