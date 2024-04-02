package Main;

import M.Document;
import V.EditorView;
import C.EditorController;

public class EditorMain {
    public static void main(String[] args) {
        Document model = new Document();
        EditorView view = new EditorView();
        EditorController controller = new EditorController(model, view);
    }
}
