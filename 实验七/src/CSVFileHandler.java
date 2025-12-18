import java.io.*;
import java.util.List;

public class CSVFileHandler {

    public void saveToCSV(List<Exercise> exercises, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            // 写入表头
            writer.write("序号,题目,答案");
            writer.newLine();

            // 写入每道题目
            for (int i = 0; i < exercises.size(); i++) {
                Exercise ex = exercises.get(i);
                writer.write(String.format("%d,%d %c %d = ?, %d",
                        i + 1,
                        ex.getOperand1(),
                        ex.getOperator(),
                        ex.getOperand2(),
                        ex.getAnswer()
                ));
                writer.newLine();
            }

            System.out.println("已保存 " + exercises.size() + " 道题目到 " + filename);
            System.out.println("格式：序号,题目（隐藏答案）,答案（后台存储）");

        } catch (IOException e) {  // 注意是IOException，不是10Exception
            System.err.println("保存CSV文件失败: " + e.getMessage());
        }
    }

    public List<String[]> readFromCSV(String filename) {
        List<String[]> data = new java.util.ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            boolean firstLine = true;

            while ((line = reader.readLine()) != null) {
                if (firstLine) {
                    firstLine = false; // 跳过表头
                    continue;
                }

                String[] row = line.split(",");
                if (row.length >= 3) {
                    data.add(row);
                }
            }

            System.out.println("已读取 " + data.size() + " 条题目数据");

        } catch (IOException e) {
            System.err.println("读取CSV文件失败: " + e.getMessage());
        }

        return data;
    }
}