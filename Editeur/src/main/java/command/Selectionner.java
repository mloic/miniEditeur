package command;

import controller.SelectionnerItf;
import business.Buffer;

public class Selectionner implements Command{

	Buffer b;
	
	SelectionnerItf dataprovider;
	
	
	public SelectionnerItf getDataprovider() {
		return dataprovider;
	}


	public void setDataprovider(SelectionnerItf dataprovider) {
		this.dataprovider = dataprovider;
	}


	public Selectionner(Buffer b) {
		super();
		this.b = b;
	}


	@Override
	public void execute() {		
	
		
		b.selectionner(dataprovider.getDebut(), dataprovider.getFin());
	}



}
