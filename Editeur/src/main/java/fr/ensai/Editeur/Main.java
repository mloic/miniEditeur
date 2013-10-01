package fr.ensai.Editeur;
import command.Coller;
import command.Copier;
import command.Couper;
import command.InsererTexte;
import command.Selectionner;

import controller.MyActionListener;
import controller.MyCaretListener;
import controller.MyKeyListener;
import ihm.MyFrame;
import business.Buffer;
import business.PP;
import business.Selection;
import business.Texte;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Buffer b = new Buffer();
		PP pp = new PP();
		Texte t1 = new Texte();
		Texte t2 = new Texte();
		Selection s = new Selection();
		b.setPp(pp);
		b.setSelection(s);
		b.setTexte(t1);
		pp.setTexte(t2);
		
		
		
		
		MyFrame frame  = new MyFrame();
		Couper command_couper = new Couper(b);
		MyActionListener listenercouper = new MyActionListener(command_couper);
		frame.getCouper().addActionListener(listenercouper);
		
		
		Coller command_coller = new Coller(b);
		MyActionListener listenercoller = new MyActionListener(command_coller);
		frame.getColler().addActionListener(listenercoller);
		

		Copier command_copier = new Copier(b);
		MyActionListener listenercopier = new MyActionListener(command_copier);
		frame.getCopier().addActionListener(listenercopier);
		
		InsererTexte command_inserer = new InsererTexte(b);
		MyKeyListener key = new MyKeyListener(command_inserer);
		command_inserer.setTextprovider(key);
		frame.getText().addKeyListener(key);
		
		
		Selectionner command_selectionner = new Selectionner(b);		
		MyCaretListener caret = new MyCaretListener(command_selectionner);
		command_selectionner.setDataprovider(caret);
		frame.getText().addCaretListener(caret );
		
		
		b.addObserver(frame);
		
	}
}
