package V;

import javax.swing.*;
import java.awt.*;

public class EditorView {
    private JFrame frame;
    private JTextArea textArea;
    private JButton loadButton;
    private JButton saveButton;

    public EditorView() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Text Editor_ Chỉnh sửa theo cách cửa bạn ");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
      // khoi tạo gia dien _ mo dau khung tao // 
        textArea = new JTextArea(); // vùng nhâp 
        frame.add(new JScrollPane(textArea), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        loadButton = new JButton("Load");
        saveButton = new JButton("Save");
        buttonPanel.add(loadButton);
        buttonPanel.add(saveButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    public String getText() {
        return textArea.getText();
    }

    public void setText(String text) {
        textArea.setText(text);
    }

    public JButton getLoadButton() {
        return loadButton;
    }

    public JButton getSaveButton() {
        return saveButton;
    }

    public JFrame getFrame() {
        return frame;
    }
}
