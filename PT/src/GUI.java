

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import verwaltung.Personalverwaltung;

public class GUI extends JFrame{
	private static final long serialVersionUID = 132;
	JPanel panel;
	JLabel label1;
	JPasswordField masterKeyField;
	JComboBox<String> platformKeyBox;
	JButton generateButton;
	JTextField generatedKeyField;
	JTextField platformKeyField;
	JLabel label2;
	JButton addButton;
	JButton deleteButton;
	BufferedReader reader;
	FileWriter writer;
	File savedPlatforms;
	
	GUI() {
	    this.setTitle("SecuroPass");
	    this.setSize(1920, 1080);
	    this.setResizable(true);
	    this.setLocation(0, 0);
	    panel=new JPanel();
	    label1=new JLabel("Master-Passwort eingeben:");
	    masterKeyField=new JPasswordField("",80);
	    Personalverwaltung pw=new Personalverwaltung();
	    String comboBoxList[] = pw.getPersonas();
        platformKeyBox = new JComboBox<String>(comboBoxList);
	    generateButton=new JButton("Generieren");
	    generatedKeyField=new JTextField("",50);
	    platformKeyField=new JTextField("",50);
	    label2=new JLabel("Plattform:");
	    addButton=new JButton("Hinzufügen");
	    deleteButton=new JButton("Löschen");
	    panel.add(label1);
	    panel.add(masterKeyField);
	    panel.add(platformKeyBox);
	    panel.add(generateButton);
	    panel.add(generatedKeyField);
	    panel.add(label2);
	    panel.add(platformKeyField);
	    panel.add(addButton);
	    panel.add(deleteButton);
	    addButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent evt) {
	    	}
	    });
	    generateButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent evt) {
	    	}
	    });
	    deleteButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent evt) {
	    	}
	    });
	    this.add(panel);
	    checkPlatform();
	}
	private void checkPlatform() {
		try {
			savedPlatforms = new File("SavedPlatforms.txt"); //C:/User/Documents/SecuroPass/
			if(!savedPlatforms.exists()) {
				savedPlatforms.createNewFile();
			}
			reader = new BufferedReader(new FileReader(savedPlatforms));
			String ss=reader.readLine();
			while(ss!=null) {
				platformKeyBox.addItem(ss);
				ss=reader.readLine();
			}
			reader.close();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		GUI frame=new GUI();
	    frame.setVisible(true);
	}

}
