import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.text.Document;
import javax.swing.undo.UndoManager;

public class Manager {

	protected static UndoManager manager = new UndoManager();
	protected static String filename = "";
	protected static String cwd = "C:\\Users\\Jan\\EditorTest";
	protected static JFrame frame;	
	protected static Document doc;
	
	protected static EditMenu editMenu;
	protected static FileMenu fileMenu;
	protected static SearchMenu searchMenu;
	protected static TextArea textArea;
	
}
