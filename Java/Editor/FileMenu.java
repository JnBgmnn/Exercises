import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.DefaultEditorKit;

public class FileMenu extends UndoableListener{

	private JMenu fileMenu;
	private JMenuItem newItem;
	private JMenuItem openItem;
	private JMenuItem saveItem;
	private JMenuItem saveAsItem;
	private JMenuItem closeItem;
	
	public FileMenu(){
		setFileMenu(new JMenu("File"));
		initializeNewItem();
		getFileMenu().addSeparator();
		initializeOpenItem();	
		getFileMenu().addSeparator();
		initializeSaveItem();
		initializeSaveAsItem();	
		getFileMenu().addSeparator();
		initializeCloseItem();
	}
	
	private void initializeNewItem(){
		newItem = new JMenuItem("New");
		newItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				textArea.getTextArea().setText("");
				filename = "";
			}
		});
		getFileMenu().add(newItem);
	}
	
	private void initializeOpenItem(){
		openItem = new JMenuItem("Open...");
		openItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				showSaveDialog();
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File(cwd));
				int action = fileChooser.showOpenDialog(frame);
				if(action == JFileChooser.APPROVE_OPTION){
					BufferedReader reader;
					try {
						reader = new BufferedReader(new FileReader(fileChooser.getSelectedFile()));
						textArea.getTextArea().read(reader, textArea.getTextArea());
						addUndoableListener();						
						filename = fileChooser.getSelectedFile().getName(); 
					} catch (FileNotFoundException e2 ) {						
						e2.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		getFileMenu().add(openItem);
	}
	
	private void initializeSaveItem(){
		saveItem = new JMenuItem(new DefaultEditorKit.CutAction());
		saveItem.setText("Save...");
		saveItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				showSaveDialog();
			}
		});
		getFileMenu().add(saveItem);
	}
	
	private void initializeSaveAsItem(){
		saveAsItem = new JMenuItem("Save As...");
		saveAsItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File(cwd));
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
			}
		});
		getFileMenu().add(saveAsItem);
	}
	
	private void initializeCloseItem(){
		closeItem = new JMenuItem("Close");
		closeItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				showSaveDialog();
			}
		});
		getFileMenu().add(closeItem);
	}

	public JMenu getFileMenu() {
		return fileMenu;
	}

	public void setFileMenu(JMenu fileMenu) {
		this.fileMenu = fileMenu;
	}
}