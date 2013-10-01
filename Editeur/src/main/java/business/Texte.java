package business;

public class Texte {

	
	private StringBuffer text = new StringBuffer();

	public StringBuffer getText() {
		return text;
	}

	public void setText(StringBuffer text) {
		this.text = text;
	}
	
	public int length() {
		return text.length();
	}

}
