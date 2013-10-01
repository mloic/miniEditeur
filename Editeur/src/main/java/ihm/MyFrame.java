package ihm;

import java.awt.Button;
import java.awt.TextArea;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MyFrame implements Observer{

	
	
	private Button couper;
	public Button getCouper() {
		return couper;
	}

	public void setCouper(Button couper) {
		this.couper = couper;
	}

	public Button getColler() {
		return coller;
	}

	public void setColler(Button coller) {
		this.coller = coller;
	}

	public Button getCopier() {
		return copier;
	}

	public void setCopier(Button copier) {
		this.copier = copier;
	}

	public JTextArea getText() {
		return text;
	}

	public void setText(JTextArea text) {
		this.text = text;
	}

	private Button coller;
	private Button copier;
	private JTextArea text;

	public MyFrame() {
		JFrame f = new JFrame();
		f.setTitle("Test de JFrame"); 
	    f.setSize(800,600); 
		
		JPanel p = new JPanel();
		
			
		f.add(p);
		couper = new Button("couper");
		coller = new Button("coller");
		copier = new Button("copier");
		
		p.add(couper);
		p.add(copier);
		p.add(coller);
		
		text = new JTextArea(20,70);
		//text.setSize(300, 400);
		text.setVisible(true);
		text.show();
		p.add(text);
		
		f.show();
	}

	@Override
	public void update(Observable o, Object arg) {
		String s = (String) arg;
		System.err.println( "  s  " + s);
		
		text.setText("");
		text.setText(s);
		
	}
	
	

}

