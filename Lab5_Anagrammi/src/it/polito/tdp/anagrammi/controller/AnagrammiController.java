package it.polito.tdp.anagrammi.controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;

import it.polito.tdp.anagrammi.model.AnagrammiModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AnagrammiController {
	
	private AnagrammiModel model;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtParola"
    private TextField txtParola; // Value injected by FXMLLoader

    @FXML // fx:id="btnCalcola"
    private Button btnCalcola; // Value injected by FXMLLoader

    @FXML // fx:id="txtAreaCorretta"
    private TextArea txtAreaCorretta; // Value injected by FXMLLoader

    @FXML // fx:id="txtAreaErrata"
    private TextArea txtAreaErrata; // Value injected by FXMLLoader

    @FXML // fx:id="btnReset"
    private Button btnReset; // Value injected by FXMLLoader

    @FXML
    void doCalcola(ActionEvent event) {
    	
    	this.txtAreaCorretta.clear();
    	this.txtAreaErrata.clear();
    	
    	String parola = this.txtParola.getText().toLowerCase().trim();
    	
    	if (!parola.matches("[a-zA-Z?]*")) {
    		this.txtAreaCorretta.appendText("Inserire una parola valida!");
    		return;
    	}
    	
    	Set <String> anagrammi = model.calcolaAnagrammi(parola);
    	
    	for (String s : anagrammi)
    		if (model.isCorrect(s))
    			this.txtAreaCorretta.appendText(s + "\n");
    		else
    			this.txtAreaErrata.appendText(s + "\n");
    }	

    @FXML
    void doReset(ActionEvent event) {
    	this.txtAreaCorretta.clear();
    	this.txtAreaErrata.clear();
    	this.txtParola.clear();
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnCalcola != null : "fx:id=\"btnCalcola\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtAreaCorretta != null : "fx:id=\"txtAreaCorretta\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtAreaErrata != null : "fx:id=\"txtAreaErrata\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Anagrammi.fxml'.";

    }

	public void setModel(AnagrammiModel model) {
		this.model = model;
	}
}
