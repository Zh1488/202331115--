import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class ExerciseGUI extends JFrame {
    private List<String[]> exercises;
    private int currentIndex = 0;

    private JLabel questionLabel;
    private JButton prevButton;
    private JButton nextButton;
    private JLabel counterLabel;

    public ExerciseGUI(List<String[]> exercises) {
        this.exercises = exercises;

        // 设置窗口属性
        setTitle("口算习题浏览器");
        setSize(500, 200); // 高度减小，因为不显示答案
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // 创建界面组件
        createUI();

        // 显示第一道题
        displayExercise(currentIndex);
    }

    private void createUI() {
        // 使用边框布局
        setLayout(new BorderLayout());

        // 中心面板：题目显示
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBorder(BorderFactory.createEmptyBorder(40, 20, 40, 20));

        questionLabel = new JLabel("", SwingConstants.CENTER);
        questionLabel.setFont(new Font("微软雅黑", Font.BOLD, 28));
        centerPanel.add(questionLabel, BorderLayout.CENTER);

        add(centerPanel, BorderLayout.CENTER);

        // 底部面板：控制按钮
        JPanel bottomPanel = new JPanel(new FlowLayout());

        prevButton = new JButton("← 上一题");
        prevButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        prevButton.setPreferredSize(new Dimension(100, 30));
        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentIndex > 0) {
                    currentIndex--;
                    displayExercise(currentIndex);
                }
            }
        });

        nextButton = new JButton("下一题 →");
        nextButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        nextButton.setPreferredSize(new Dimension(100, 30));
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentIndex < exercises.size() - 1) {
                    currentIndex++;
                    displayExercise(currentIndex);
                }
            }
        });

        counterLabel = new JLabel();
        counterLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));

        bottomPanel.add(prevButton);
        bottomPanel.add(Box.createHorizontalStrut(20)); // 添加间距
        bottomPanel.add(counterLabel);
        bottomPanel.add(Box.createHorizontalStrut(20)); // 添加间距
        bottomPanel.add(nextButton);

        add(bottomPanel, BorderLayout.SOUTH);
    }

    private void displayExercise(int index) {
        if (exercises.isEmpty() || index < 0 || index >= exercises.size()) {
            return;
        }

        String[] exercise = exercises.get(index);

        // 只显示题目，不显示答案
        String questionText = exercise[1];  // 题目列（例如："25 + 36 = ?"）
        questionLabel.setText(questionText);

        // 更新计数器
        counterLabel.setText(String.format("第 %d / %d 题",
                index + 1, exercises.size()));

        // 更新按钮状态
        prevButton.setEnabled(index > 0);
        nextButton.setEnabled(index < exercises.size() - 1);

        // 调试信息（可选）
        System.out.println("显示第 " + (index + 1) + " 题: " + questionText);
        // 答案只在后台记录：exercise[2]
    }

    // 测试方法
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // 示例数据（不显示答案）
                List<String[]> sampleData = java.util.Arrays.asList(
                        new String[]{"1", "25 + 36 = ?", "61"},
                        new String[]{"2", "50 - 23 = ?", "27"},
                        new String[]{"3", "78 + 12 = ?", "90"},
                        new String[]{"4", "100 - 45 = ?", "55"},
                        new String[]{"5", "67 + 33 = ?", "100"}
                );

                ExerciseGUI gui = new ExerciseGUI(sampleData);
                gui.setVisible(true);
            }
        });
    }
}