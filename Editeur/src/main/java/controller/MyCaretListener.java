package controller;

import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import command.Command;

public class MyCaretListener implements CaretListener, SelectionnerItf{

	Command c;

	
	int debut;
	/* (non-Javadoc)
	 * @see controller.SelectionnerItf#getDebut()
	 */
	@Override
	public int getDebut() {
		return debut;
	}


	/* (non-Javadoc)
	 * @see controller.SelectionnerItf#getFin()
	 */
	@Override
	public int getFin() {
		return fin;
	}


	int fin;
	
	public MyCaretListener(Command c) {
		super();
		this.c = c;
	}


	@Override
	public void caretUpdate(CaretEvent e) {
		if (e.getDot()> e.getMark()){
			debut = e.getMark();
			fin = e.getDot();
		}else{
			fin = e.getMark();
			debut = e.getDot();
		}
		
		
		//System.err.println(e.getDot() + "\n" + e.getMark());
		
		c.execute();
		// TODO Auto-generated method stub
		
	}


}
