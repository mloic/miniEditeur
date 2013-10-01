package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import command.Command;

public class MyKeyListener implements KeyListener, TextProviderItf{

	Command c; 
	
	String character;
	
	/* (non-Javadoc)
	 * @see controller.TextProviderItf#getCharacter()
	 */
	@Override
	public String getCharacter() {
		return character;
	}



	public MyKeyListener(Command c) {
		super();
		this.c = c;
	}
	
	

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
		character = ""+ e.getKeyChar();
		c.execute();	
		
	}


}
