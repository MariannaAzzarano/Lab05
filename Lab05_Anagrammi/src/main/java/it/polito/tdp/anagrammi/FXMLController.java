package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txt_inserita;

    @FXML
    private Button btnCalcola;

    @FXML
    private TextArea txtAreaCorretto;

    @FXML
    private TextArea txtAreaErrato;

    @FXML
    private Button btnReset;

	private Model model;

    @FXML
    void doCalcola(ActionEvent event) {
    	String parola = txt_inserita.getText();
    	Map<String, List<String>> anagrammi = model.anagrammiCorrettiENon(parola);
    	String permutazioni = "";
    	for(String s : anagrammi.get("corretti")) {
    		permutazioni = permutazioni + s + "\n";
    	}
    	txtAreaCorretto.setText(permutazioni);
    	permutazioni = "";
    	for(String s : anagrammi.get("errati")) {
    		permutazioni = permutazioni + s + "\n";
    	}
    	txtAreaErrato.setText(permutazioni);
    }

    @FXML
    void doReset(ActionEvent event) {
    	txt_inserita.setText("");
    	txtAreaCorretto.setText("");
    	txtAreaErrato.setText("");

    }

    @FXML
    void initialize() {
        assert txt_inserita != null : "fx:id=\"txt_inserita\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCalcola != null : "fx:id=\"btnCalcola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtAreaCorretto != null : "fx:id=\"txtAreaCorretto\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtAreaErrato != null : "fx:id=\"txtAreaErrato\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }

	public void setModel(Model model) {
		this.model = model;
		
		
	}
}

