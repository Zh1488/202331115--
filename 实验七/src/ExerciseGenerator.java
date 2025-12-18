import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class ExerciseGenerator {
    private Random random = new Random();

    public List<Exercise> generateExercises(int count) {
        List<Exercise> exercises = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            exercises.add(generateValidExercise());
        }

        return exercises;
    }

    private Exercise generateValidExercise() {
        while (true) {
            int operand1 = random.nextInt(101);
            int operand2 = random.nextInt(101);
            char operator = random.nextBoolean() ? '+' : '-';

            // 确保减法结果非负
            if (operator == '-' && operand1 < operand2) {
                int temp = operand1;
                operand1 = operand2;
                operand2 = temp;
            }

            Exercise exercise = new Exercise(operand1, operand2, operator);
            if (exercise.isValid()) {
                return exercise;
            }
        }
    }
}