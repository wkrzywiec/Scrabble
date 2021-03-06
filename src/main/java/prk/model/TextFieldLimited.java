package prk.model;

import javafx.scene.control.TextField;

/**
 * Klasa dziedzicząca po klasie TextField, reprezentująca pola do wpisywania liter
 * 
 * @author Wojciech Krzywiec 
 */

public class TextFieldLimited extends TextField {

	private final int limit = 1;

	@Override
	public void replaceText(int start, int end, String text) {
		super.replaceText(start, end, text);
		verify();
		if (getText()!=null) {
			setText(getText().toUpperCase());
		}
	}

	@Override
	public void replaceSelection(String text) {
		super.replaceSelection(text);
		verify();
		setText(getText().toUpperCase());
	}

	private void verify() {
		if (getText().length() > limit) {
			setText(getText().substring(0, limit));
		}
		if (!getText().matches("[a-zA-ZąĄćĆęĘłŁóÓńŃśŚżŻźŹ*]"))
			setText(null);

	}

}
