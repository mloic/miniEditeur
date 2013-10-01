package command;

import business.Buffer;

public class Couper implements Command{

	Buffer b;
	
	
	public Couper(Buffer b) {
		super();
		this.b = b;
	}


	@Override
	public void execute() {
		b.couper();
	}



}
