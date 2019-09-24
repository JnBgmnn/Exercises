import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class Editor extends UndoableListener{
	
	private JScrollPane scrollPane;
	private JMenuBar bar;
	
	private Editor(){
		initializeFrame();
		initializeMenuBar();
		initializeMenus();
		initializeScrollPane();
		frame.setVisible(true);
	}
	
	private void initializeFrame(){
		frame = new JFrame("Notepad--");
		frame.setSize(700, 700);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent windowEvent){
				showSaveDialog();
			}
		});
	}
	
	private void initializeMenuBar(){
		bar = new JMenuBar();
		frame.setJMenuBar(bar);
	}
	
	private void initializeMenus(){
		textArea = new TextArea();
		fileMenu = new FileMenu();
		editMenu = new EditMenu();
		searchMenu = new SearchMenu();
		bar.add(fileMenu.getFileMenu());
		bar.add(editMenu.getEditMenu());
		bar.add(searchMenu.getSearchMenu());
	}
	
	private void initializeScrollPane(){
		scrollPane = new JScrollPane(textArea.getTextArea());
		frame.add(scrollPane);
	}
		
	public static void main(String[] args){
		Editor editor = new Editor();	
	}
}