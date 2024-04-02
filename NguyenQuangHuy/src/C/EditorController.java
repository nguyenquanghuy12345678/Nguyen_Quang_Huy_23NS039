package C;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import V.EditorView;
import M.Document;

public class EditorController {
    private Document model;
    private EditorView view;

    public EditorController(Document model, EditorView view) {
        this.model = model;
        this.view = view;

        view.getLoadButton().addActionListener(new LoadListener());
        view.getSaveButton().addActionListener(new SaveListener());
    }

    class LoadListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(view.getFrame());
            if (result == JFileChooser.APPROVE_OPTION) {
                String filePath = fileChooser.getSelectedFile().getAbsolutePath();
                model.load(filePath);
                view.setText(String.join("\n", model.getContent()));
                JOptionPane.showMessageDialog(view.getFrame(), "File loaded successfully.");
            }
        }
    }

    class SaveListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String text = view.getText();
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showSaveDialog(view.getFrame());
            if (result == JFileChooser.APPROVE_OPTION) {
                String filePath = fileChooser.getSelectedFile().getAbsolutePath();
                model.setContent(Arrays.asList(text.split("\n")));
                model.save(filePath);
                JOptionPane.showMessageDialog(view.getFrame(), "Document saved successfully.");
            }
        }
    }
}
