package command;

import business.Buffer;

public class Copier implements Command{

	Buffer b;
	
	
	public Copier(Buffer b) {
		super();
		this.b = b;
	}


	@Override
	public void execute() {
		b.copier();
	}



}
