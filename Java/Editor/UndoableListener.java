import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;

public class UndoableListener extends Manager{
	
	protected void addUndoableListener(){
		doc = textArea.getTextArea().getDocument();
		doc.addUndoableEditListener(new UndoableEditListener(){
			@Override
			public void undoableEditHappened(UndoableEditEvent e) {
				manager.addEdit(e.getEdit());
				editMenu.getUndoItem().setEnabled(manager.canUndo());
				editMenu.getRedoItem().setEnabled(manager.canRedo());
			}			
		});
	}
	
	
	protected void showSaveDialog(){
		int value = JOptionPane.showConfirmDialog(null, "Do you want to save?");
		switch (value){
		case JOptionPane.YES_OPTION:
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(new File(cwd));
			if(filename.equals("")){
				int action = fileChooser.showSaveDialog(frame);
				if(action == JFileChooser.APPROVE_OPTION){
					try {
						FileWriter writer = new FileWriter(fileChooser.getSelectedFile());
						writer.write(textArea.getTextArea().getText());
						writer.close();
						filename = fileChooser.getSelectedFile().getName(); 
					} catch (IOException e1) {					
						e1.printStackTrace();
					}
				}
			}else{			
				FileWriter writer;
				try {
					writer = new FileWriter(new File(cwd + filename));
					writer.write(textArea.getTextArea().getText());
					writer.close();					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			System.exit(0);
			break;
		case JOptionPane.NO_OPTION:
			System.exit(0);
		case JOptionPane.CANCEL_OPTION:
			break;
		case JOptionPane.CLOSED_OPTION:
			break;
		default:
			System.exit(0);
			break;
		}
	}

}
