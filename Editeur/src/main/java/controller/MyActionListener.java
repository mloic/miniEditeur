package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import command.Command;

public class MyActionListener implements ActionListener{
	
	Command c;

	public MyActionListener(Command c) {
		super();
		this.c = c;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		c.execute();
	}
	
}