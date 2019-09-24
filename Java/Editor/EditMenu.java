import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.DefaultEditorKit;
import javax.swing.undo.CannotUndoException;

public class EditMenu extends UndoableListener{
	
	private JMenu editMenu;
	private JMenuItem undoItem;
	private JMenuItem redoItem;
	private JMenuItem cutItem;
	private JMenuItem copyItem;
	private JMenuItem pasteItem;
	private JMenuItem selectAllItem;
	
	public EditMenu(){
		setEditMenu(new JMenu("Edit"));
		initializeUndoItem();		
		getEditMenu().addSeparator();
		initializeRedoItem();
		getEditMenu().addSeparator();
		initializeCCPItems();
		initializeSelectAllItem();	
	}
	
	private void initializeUndoItem(){
		setUndoItem(new JMenuItem("Undo"));		
		getUndoItem().setEnabled(manager.canUndo());
		getUndoItem().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try{
					if(manager.canUndo()){
						manager.undo();
					}
				}catch(CannotUndoException e1){
					e1.printStackTrace();
				}finally{
					getUndoItem().setEnabled(manager.canUndo());
					getRedoItem().setEnabled(manager.canRedo());
				}
			}		
		});
		getEditMenu().add(getUndoItem());
		addUndoableListener();
	}

	private void initializeRedoItem(){
		setRedoItem(new JMenuItem("Redo"));
		getRedoItem().setEnabled(manager.canRedo());
		getRedoItem().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try{
					manager.redo();
				}catch(CannotUndoException e1){
					e1.printStackTrace();
				}finally{
					getRedoItem().setEnabled(manager.canRedo());
					getUndoItem().setEnabled(manager.canUndo());
				}
			}		
		});
		getEditMenu().add(getRedoItem());
	}

	private void initializeCCPItems(){
		cutItem = new JMenuItem(new DefaultEditorKit.CutAction());
		cutItem.setText("Cut");
		cutItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK));
		getEditMenu().add(cutItem);
		
		copyItem = new JMenuItem(new DefaultEditorKit.CopyAction());
		copyItem.setText("Copy");
		copyItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK));
		getEditMenu().add(copyItem);
		
		pasteItem = new JMenuItem(new DefaultEditorKit.PasteAction());
		pasteItem.setText("Paste");
		pasteItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_DOWN_MASK));
		getEditMenu().add(pasteItem);
	}
	
	private void initializeSelectAllItem(){
		selectAllItem = new JMenuItem("Select All");
		selectAllItem.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				textArea.getTextArea().selectAll();
			}		
		});
		getEditMenu().add(selectAllItem);
	}

	public JMenuItem getRedoItem() {
		return redoItem;
	}
	
	private void setRedoItem(JMenuItem redoItem) {
		this.redoItem = redoItem;	
	}

	public JMenuItem getUndoItem() {
		return undoItem;
	}
	
	private void setUndoItem(JMenuItem undoItem) {
		this.undoItem = undoItem;	
	}

	public JMenu getEditMenu() {
		return editMenu;
	}

	public void setEditMenu(JMenu editMenu) {
		this.editMenu = editMenu;
	}
}