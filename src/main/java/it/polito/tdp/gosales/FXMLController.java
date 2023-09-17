package it.polito.tdp.gosales;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.gosales.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnCreaGrafo;

    @FXML
    private Button btnRicorsione;

    @FXML
    private Button btnVolumi;

    @FXML
    private ComboBox<?> cmbAnno;

    @FXML
    private ComboBox<?> cmbNazione;
    
    @FXML
    private TextField txtN;

    @FXML
    private TextArea txtResult;

    @FXML
    void doCalcolaVolumi(ActionEvent event) {

    }

    @FXML
    void doCreaGrafo(ActionEvent event) {

    }

    @FXML
    void doRicorsione(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert btnCreaGrafo != null : "fx:id=\"btnCreaGrafo\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnRicorsione != null : "fx:id=\"btnRicorsione\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnVolumi != null : "fx:id=\"btnVolumi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert cmbAnno != null : "fx:id=\"cmbAnno\" was not injected: check your FXML file 'Scene.fxml'.";
        assert cmbNazione != null : "fx:id=\"cmbNazione\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtN != null : "fx:id=\"txtN\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    
    public void setModel(Model model) {
    	this.model = model;
    }

}
