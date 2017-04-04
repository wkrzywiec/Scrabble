package prk.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import prk.model.ScrabbleBoard;
import prk.model.TextFieldLimited;


public class MainWindowController {

	private Stage primaryStage;
	private ServerApp serverApp;
	private ClientApp clientApp;
	private boolean isServer;
	private ScrabbleBoard scrabbleBoard;

	@FXML
	TextArea textarea;
	@FXML TextFieldLimited txt00, txt01;

	public void setServerApp(ServerApp app, Stage primaryStage) {
		this.serverApp = app;
		this.primaryStage = primaryStage;
		this.isServer = true;
	}

	public void setClientApp(ClientApp app, Stage primaryStage) {
		this.clientApp = app;
		this.primaryStage = primaryStage;
		this.isServer = false;
	}

	public void initialize() {

	}

	public void confirm() {
		String message = this.isServer ? "Server: " : "Client: ";
		message += "confirmPressed";
		textarea.appendText(message + "\n");
		try {
			if (this.isServer)
				serverApp.getConnection().send(message);
			else
				clientApp.getConnection().send(message);
		} catch (Exception e) {
			textarea.appendText("Failed to send" + "\n");
		}
	}

	public TextArea getTextarea() {
		return textarea;
	}
	
	public void textFieldToMatrix(){
		
	}
}
