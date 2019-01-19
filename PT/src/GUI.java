

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import verwaltung.Personalverwaltung;

@SuppressWarnings("serial")
public class GUI extends JFrame implements ActionListener{
	JPanel panel;
	JLabel label1;
	JTextField namensFeld;
	JComboBox<String> personalBox;
	JButton einstellenButton;
	JTextField gebFeld;
	JTextField gehaltField;
	JLabel label2;
	JLabel label3;
	JButton addButton;
	JButton deleteButton;
	private ButtonGroup buttonGroup1;
	private JRadioButton jRadioButton1;
	private JRadioButton jRadioButton2;
	private Personalverwaltung pw;
	
	GUI() {
		try {
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	    this.setTitle("Personalverwaltung");
	    this.setSize(1280, 720);
	    this.setResizable(true);
	    this.setLocation(0, 0);
	    panel=new JPanel();;
	    getContentPane().add(panel, BorderLayout.CENTER);
	    label1=new JLabel("Name:");
	    namensFeld=new JTextField("Mustermann",80);
	    pw=new Personalverwaltung();
        personalBox = new JComboBox<String>(pw.getPersonas());
	    einstellenButton=new JButton("Hinzufügen");
	    gebFeld=new JTextField("01.01.2000",50);
	    gehaltField=new JTextField("1000",50);
	    label2=new JLabel("Geburtsdatum:");
	    label3=new JLabel("Gehalt:");
	    addButton=new JButton("Hinzufügen");
	    deleteButton=new JButton("Löschen");
	    panel.add(personalBox);
	    panel.add(addButton);
	    panel.add(deleteButton);
	    JDialog jDialog1 = new JDialog(this);
	    BoxLayout jDialog1Layout = new BoxLayout(jDialog1.getContentPane(),
	    javax.swing.BoxLayout.Y_AXIS);
	    jDialog1.getContentPane().setLayout(jDialog1Layout);
	    jDialog1.getContentPane().add(getJRadioButton1());
	    jDialog1.getContentPane().add(getJRadioButton2());
	    jDialog1.getContentPane().add(label1);
	    jDialog1.getContentPane().add(namensFeld);
	    jDialog1.getContentPane().add(label2);
	    jDialog1.getContentPane().add(gebFeld);
	    jDialog1.getContentPane().add(label3);
	    jDialog1.getContentPane().add(gehaltField);
	    jDialog1.getContentPane().add(einstellenButton);
	    addButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent evt) {
	    		jDialog1.pack();
	    		jDialog1.setLocationRelativeTo(null);
	    		jDialog1.setVisible(true);
	    	}
	    });
	    einstellenButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent evt) {
	    		pw.einstellen(getJRadioButton1().isSelected(),namensFeld.getText(),gebFeld.getText(),gehaltField.getText());
	    		aktualisieren();
	    		jDialog1.dispose();
	    	}
	    });
	    deleteButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent evt) {
	    		pw.löschen(personalBox.getItemAt(personalBox.getSelectedIndex()));
	    		personalBox.removeItemAt(personalBox.getSelectedIndex());
	    	}
	    });
		} catch (Exception e) {
			e.printStackTrace();
			}
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
			GUI inst = new GUI();
			inst.setLocationRelativeTo(null);
			inst.setVisible(true);
			}
			});
	}

private ButtonGroup getButtonGroup1() {
if (buttonGroup1 == null) {
buttonGroup1 = new ButtonGroup();
}
return buttonGroup1;
}
private JRadioButton getJRadioButton1() {
if (jRadioButton1 == null) {
jRadioButton1 = new JRadioButton("Mitarbeiter",true);
jRadioButton1.setBounds(62, 5, 86, 18);
getButtonGroup1().add(jRadioButton1);
jRadioButton1.setActionCommand("BUTTON1 selected!");
jRadioButton1.addActionListener(this);
}
return jRadioButton1;
}
private JRadioButton getJRadioButton2() {
if (jRadioButton2 == null) {
jRadioButton2 = new JRadioButton();
jRadioButton2.setText("Manager");
jRadioButton2.setBounds(153, 5, 86, 18);
getButtonGroup1().add(jRadioButton2);
jRadioButton2.setActionCommand("BUTTON2 selected!");
jRadioButton2.addActionListener(this);
}
return jRadioButton2;
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}
private void aktualisieren() {
    personalBox.removeAllItems();
    String[] array=pw.getPersonas();
    for(int i=0;i<array.length;i++) {
    	personalBox.addItem(array[i]);
    }
}
}
