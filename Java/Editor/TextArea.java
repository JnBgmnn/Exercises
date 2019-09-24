import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.undo.CannotUndoException;

public class TextArea extends Manager{
	
	private JTextArea textArea;
	
	public TextArea(){
		initializeTextArea();
		initializeKeyBingings();
	}
	
	private void initializeTextArea(){
		setTextArea(new JTextArea());
		getTextArea().setLineWrap(true);
		frame.add(getTextArea());
	}
	
	@SuppressWarnings("serial")
	private void initializeKeyBingings(){
		getTextArea().getActionMap().put("Undo", new AbstractAction("Undo"){
			public void actionPerformed(ActionEvent arg0) {
				try{
					if(manager.canUndo()){
						manager.undo();
					}
				}catch(CannotUndoException e1){
					e1.printStackTrace();
				}
			}		
		});
		getTextArea().getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_DOWN_MASK), "Undo");
		
		getTextArea().getActionMap().put("Redo", new AbstractAction("Redo"){
			public void actionPerformed(ActionEvent arg0) {
				try{
					if(manager.canRedo()){
						manager.redo();
					}
				}catch(CannotUndoException e1){
					e1.printStackTrace();
				}
			}		
		});
		getTextArea().getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_Y, InputEvent.CTRL_DOWN_MASK), "Redo");
		
		getTextArea().getActionMap().put("Save...", new AbstractAction("Save..."){
			public void actionPerformed(ActionEvent arg0) {
				try{
					JFileChooser fileChooser = new JFileChooser();
					fileChooser.setCurrentDirectory(new File(cwd));
					if(filename.equals("")){
						int action = fileChooser.showSaveDialog(frame);
						if(action == JFileChooser.APPROVE_OPTION){
							try {
								FileWriter writer = new FileWriter(fileChooser.getSelectedFile());
								writer.write(getTextArea().getText());
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
							writer.write(getTextArea().getText());
							writer.close();					
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				}catch(CannotUndoException e1){
					e1.printStackTrace();
				}
			}		
		});
		getTextArea().getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK), "Save...");

		getTextArea().getActionMap().put("Save As...", new AbstractAction("Save As..."){
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File(cwd));
				int action = fileChooser.showSaveDialog(frame);
				if(action == JFileChooser.APPROVE_OPTION){
					try {
						FileWriter writer = new FileWriter(fileChooser.getSelectedFile());
						writer.write(getTextArea().getText());
						writer.close();
						filename = fileChooser.getSelectedFile().getName();
					} catch (IOException e1) {					
						e1.printStackTrace();
					}
				}
			}		
		});
		getTextArea().getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.ALT_DOWN_MASK+InputEvent.CTRL_DOWN_MASK), "Save As...");
	}
	
	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}
}