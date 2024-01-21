package it.polito.tdp.gosales;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.gosales.model.Model;
import it.polito.tdp.gosales.model.Retailers;
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
    private ComboBox<Integer> cmbAnno;

    @FXML
    private ComboBox<String> cmbNazione;
    
    @FXML
    private TextField txtN;

    @FXML
    private TextArea txtResult;

    @FXML
    void doCalcolaVolumi(ActionEvent event) {
    	this.txtResult.clear();
    	if (this.cmbAnno.getValue() == null && this.cmbNazione.getValue() == null) {
    		this.txtResult.setText("Creare prima il grafo! \n");
    		return;
    	}
    		List<Retailers> lista = this.model.volumiVendita();
    		this.txtResult.appendText("Il volume di vendita dei Retailers: \n");
    		for (Retailers r : lista) {
    			this.txtResult.appendText(r.getName() + " ---> " + r.getVolume() + "\n");
    		}

    }

    @FXML
    void doCreaGrafo(ActionEvent event) {
    	this.txtResult.clear();
    	String country = this.cmbNazione.getValue();
    	Integer anno = this.cmbAnno.getValue();
    	if(country == null) {
    		txtResult.setText("Selezionale una nazione dal menù a tendina! \n");
    		return;
    	}
    	if (anno == null) {
    		txtResult.setText("Selezionale un anno dal menù a tendina! \n");
    		return;
    	}
    	this.model.creaGrafo(country, anno);
    	this.txtResult.setText("Grafo corretamente creato! \n");
    	this.txtResult.appendText("Il grafo ha: # vertici: " + this.model.numV() + " e # archi: " + this.model.numA() + "\n");


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
    	this.cmbNazione.getItems().setAll(this.model.getNazioni());
    	this.cmbAnno.getItems().setAll(this.model.getAnno());
    }

}
