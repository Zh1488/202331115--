import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== 实验七：数据处理与GUI ===");

        // 1. 生成50道习题
        System.out.println("1. 生成50道100以内加减法习题...");
        ExerciseGenerator generator = new ExerciseGenerator();
        List<Exercise> exercises = generator.generateExercises(50);

        // 2. 保存到CSV文件
        System.out.println("2. 保存到CSV文件...");
        CSVFileHandler fileHandler = new CSVFileHandler();
        fileHandler.saveToCSV(exercises, "data/exercises.csv");

        // 3. 从CSV读取数据
        System.out.println("3. 从CSV文件读取数据...");
        List<String[]> exerciseData = fileHandler.readFromCSV("data/exercises.csv");

        // 4. 启动GUI
        System.out.println("4. 启动GUI界面...");
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ExerciseGUI gui = new ExerciseGUI(exerciseData);
                gui.setVisible(true);
            }
        });

        System.out.println("程序启动完成！");
    }
}