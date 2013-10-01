package business;

import java.util.Observable;

public class Buffer extends Observable {

	int curs_currentpos = 0;
	Texte texte;
	Selection selection;
	PP pp;
	Texte neSertPas2;
	public Texte getTexte() {
		Texte neSertPas;
		return texte;
	}
	public Texte getTexte2() {
		Texte neSertPas;
		return texte;
	}

	public void setTexte(Texte texte) {
		this.texte = texte;
	}

	public int getCurs_currentpos() {
		return curs_currentpos;
	}

	public void setCurs_currentpos(int curs_currentpos) {
		if (curs_currentpos > this.texte.length())
			return;

		this.curs_currentpos = curs_currentpos;
	}

	public void couper() {
		// System.err.println(this.texte.getText().toString());
		String selec = this.texte
				.getText()
				.toString()
				.substring(selection.getCurseurdebut(),
						selection.getCurseurfin());
		pp.getTexte().getText().setLength(0);
		pp.getTexte().getText().append(selec);
		// System.err.println(pp.getTexte().getText().toString());
		String before = this.texte.getText().toString()
				.substring(0, selection.getCurseurdebut());
		String after = this.texte.getText().toString()
				.substring(selection.getCurseurfin(), texte.length());
		texte.getText().setLength(0);
		texte.getText().append(before + after);
		this.setCurs_currentpos(curs_currentpos - selec.length());
		this.setChanged();
		this.notifyObservers(this.texte.getText().toString());
	}
	public void couper2() {
		// System.err.println(this.texte.getText().toString());
		String selec = this.texte
				.getText()
				.toString()
				.substring(selection.getCurseurdebut(),
						selection.getCurseurfin());
		pp.getTexte().getText().setLength(0);
		pp.getTexte().getText().append(selec);
		// System.err.println(pp.getTexte().getText().toString());
		String before = this.texte.getText().toString()
				.substring(0, selection.getCurseurdebut());
		String after = this.texte.getText().toString()
				.substring(selection.getCurseurfin(), texte.length());
		texte.getText().setLength(0);
		texte.getText().append(before + after);
		this.setCurs_currentpos(curs_currentpos - selec.length());
		this.setChanged();
		this.notifyObservers(this.texte.getText().toString());
	}

	public void copier() {

		String selec = this.texte
				.getText()
				.toString()
				.substring(selection.getCurseurdebut(),
						selection.getCurseurfin());
		pp.getTexte().getText().setLength(0);
		pp.getTexte().getText().append(selec);
	}

	public void coller() {
		insererTexte(pp.getTexte().getText().toString());
	}

	public void insererTexte(String te) {
		texte.getText().insert(curs_currentpos, te);
		this.setCurs_currentpos(curs_currentpos + te.length());

		System.err.println("text in the buffer " + texte.getText().toString());
		System.err.println("current pos " + curs_currentpos);
		this.setChanged();
		this.notifyObservers(this.texte.getText().toString());

	}

	public void selectionner(int debut, int fin) {
		if (debut == fin) {
			this.setCurs_currentpos(debut);
			this.selection.setCurseurdebut(-1);
			this.selection.setCurseurfin(-1);

		} else {
			this.selection.setCurseurdebut(debut);
			this.selection.setCurseurfin(fin);
		}
	}

	public Selection getSelection() {
		return selection;
	}

	public void setSelection(Selection selection) {
		this.selection = selection;
	}

	public PP getPp() {
		return pp;
	}

	public void setPp(PP pp) {
		this.pp = pp;
	}

}
