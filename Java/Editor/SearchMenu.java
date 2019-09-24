import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class SearchMenu extends Manager{
	
	private JMenu searchMenu;
	private JMenuItem findItem;
	
	public SearchMenu(){
		searchMenu = new JMenu("Search");
		initializeFindItem();
		searchMenu.addSeparator();
	}
	
	private void initializeFindItem(){
		findItem = new JMenuItem("Find");
		findItem.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String input = JOptionPane.showInputDialog(null, "Find: ");
				if(textArea.getTextArea().getText().contains(input)){
					int start = textArea.getTextArea().getText().indexOf(input);
					textArea.getTextArea().select(start, start + input.length());
				}else{
					JOptionPane.showMessageDialog(null, "Could not find " + input + " in text");
				}
			}		
		});
		getSearchMenu().add(findItem);
	}

	public JMenu getSearchMenu() {
		return searchMenu;
	}
}
