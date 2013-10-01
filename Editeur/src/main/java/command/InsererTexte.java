package command;

import business.Buffer;
import controller.TextProviderItf;

public class InsererTexte implements Command{

	Buffer b;
	
	TextProviderItf textprovider;
	
	
	public TextProviderItf getTextprovider() {
		return textprovider;
	}


	public void setTextprovider(TextProviderItf textprovider) {
		this.textprovider = textprovider;
	}


	public InsererTexte(Buffer b) {
		super();
		this.b = b;
	}


	@Override
	public void execute() {
		b.insererTexte(textprovider.getCharacter());
	}



}
