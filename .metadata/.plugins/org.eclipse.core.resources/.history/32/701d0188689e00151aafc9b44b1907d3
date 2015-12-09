import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;


public class ToDo extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Container con;
	
	Container menu;
	
	File file = new File("./last.todos");
	
	JTextField nItemName;
	
	JButton addItemBtn, removeSelectedItemBtn, clearListBtn;
	
	JList<String> list;
	
	DefaultListModel<String> listModel;
	
	KeyListener listener = new KeyboardListener();
	
	class KeyboardListener implements KeyListener{

		@Override
		public void keyTyped(KeyEvent e) {
			//System.out.println(e.getExtendedKeyCode());
			if(e.getExtendedKeyCode() == 10 /*ENTER*/){
				addItem();
			}
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
			
		
	
	public static void main(String[] args) {
		new ToDo();
	}
	
	private void saveToDos() {
		String csv = "";
		int listSize = listModel.getSize();
		for(int i = 0; i < listSize; i++){
			csv += listModel.getElementAt(i) + ";";
		}
		
		try{
		@SuppressWarnings("resource")
		BufferedWriter out = new BufferedWriter(
				new OutputStreamWriter(
						new FileOutputStream(file), "UTF8"));
		System.out.println("Writing list content: \"" + csv + "\" into file.");
		out.write(csv);
		out.close();
		}catch(IOException e){
			System.out.println("Error writing list content: \"" + csv + "\" into file.");
		}
	}
	
	public ToDo(){
		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(final WindowEvent e){
				System.out.println("Application has been closed by the user!");
				saveToDos();
				System.exit(0);
			}
		});
		
		setTitle("todo");
		setSize(450, 350);
		
		con = getContentPane();
		menu = new JPanel();
		
		con.setLayout(new BorderLayout());
		menu.setLayout(new GridLayout(3, 1));
		
		nItemName  = new JTextField();
		nItemName.addKeyListener(listener);
		
		con.add(nItemName, BorderLayout.NORTH);
		con.add(menu, BorderLayout.EAST);
		
		//TODO cleanup
		addItemBtn = new JButton("add item");
		removeSelectedItemBtn = new JButton("remove selected");
		clearListBtn = new JButton("clear all");
		
		menu.add(addItemBtn);
		menu.add(removeSelectedItemBtn);
		menu.add(clearListBtn);
		
		list = new JList<String>();
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		
		listModel = new DefaultListModel<String>();
		
		list.setModel(listModel);
		
		//con.add(list, BorderLayout.CENTER); //obsolete if JScrollPane used
		con.add(scrollPane, BorderLayout.CENTER);
		
		setupButtons();
		
		setVisible(true);
		System.out.println("Application has started!");
	}

	private void setupButtons() {
		addItemBtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				addItem();
			}
		});
		
		removeSelectedItemBtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				removeSelected();
			}
		});
		
		clearListBtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				clearList();
			}
		});
		
	}
	
	private void addItem(){
		String name = nItemName.getText();
		if(name.length() > 0){
			System.out.println("Adding item \"" + name + "\" to the list.");
			listModel.addElement(name);
		}
		nItemName.setText("");
	}
	
	@SuppressWarnings("unused")
	private void removeSelected_legacy(){ //TODO fix
		int[] selected = list.getSelectedIndices();
		for (int i: selected){
			String tmp = listModel.getElementAt(i);
			listModel.remove(i);
			System.out.println("Removed \"" + tmp + "\" from list.");
		}
	}
	
	private void removeSelected(){
		int[] selected = list.getSelectedIndices();
		int lastItemInArray = selected[selected.length-1];
		String tmp;
		while(selected.length > 0){
			tmp = listModel.getElementAt(lastItemInArray);
			listModel.remove(lastItemInArray);
			selected = list.getSelectedIndices();
			lastItemInArray = selected.length > 1 ? selected[selected.length-1] : 0 ;
			System.out.println("Removed \"" + tmp + "\" from list.");
		}
	}
	
	private void clearList(){
		listModel.clear();
		System.out.println("Removed all items from the list.");
	}
}
