package command;

import business.Buffer;

public class Coller implements Command{

	Buffer b;
	
	
	public Coller(Buffer b) {
		super();
		this.b = b;
	}


	@Override
	public void execute() {
		b.coller();
	}



}
