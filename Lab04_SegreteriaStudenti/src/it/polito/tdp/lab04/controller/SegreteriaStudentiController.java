package it.polito.tdp.lab04.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SegreteriaStudentiController {
	
	private Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Corso> cmbCorsi;

    @FXML
    private Button btnCercaIscritti;

    @FXML
    private TextField txtMatricola;

    @FXML
    private Button btnCompleta;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtCognome;

    @FXML
    private Button btnCercaCorsi;

    @FXML
    private Button btnIscrivi;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;

    @FXML
    void doCercaCorsi(ActionEvent event) {
    	if(cmbCorsi.getValue() != null) {
	    	int matricola;
	    	try {
	    		matricola = Integer.parseInt(txtMatricola.getText());
	    	} catch (NumberFormatException e) {
	    		txtResult.appendText("Devi inserire una matricola\n");
	    		return;
	    	}
	    	
	    	boolean isIscritto = this.model.isStudenteIscritto(cmbCorsi.getValue(), matricola);
	    	if(isIscritto==true) {
	    		txtResult.appendText("Lo studente "+matricola+" è iscritto al corso "+cmbCorsi.getValue().getNome()+"\n");
	    	} else {
	    		txtResult.appendText("Lo studente "+matricola+" NON è iscritto al corso "+cmbCorsi.getValue().getNome()+"\n");
	    	}
	    	
    	} else {
    		int matricola;
	    	try {
	    		matricola = Integer.parseInt(txtMatricola.getText());
	    	} catch (NumberFormatException e) {
	    		txtResult.appendText("Devi inserire una matricola\n");
	    		return;
	    	}
	    	
	    	List<Corso> corsiSeguiti = new ArrayList<Corso>();
	    	corsiSeguiti=this.model.getCorsiSeguiti(matricola);
	    	String print="";
	    	for (Corso c : corsiSeguiti)
	    		print += c.toString()+"\n";
	    	txtResult.appendText(print);
    	}
    }

    @FXML
    void doCercaIscritti(ActionEvent event) {
    	Corso c = (Corso) this.cmbCorsi.getValue();
    	List<Studente> studentiCorso = new ArrayList<Studente>();
    	studentiCorso= model.getStudentiIscritti(c);
    	String stampa="";
    	for (Studente s : studentiCorso)
    		stampa += s.toString()+"\n";
    	txtResult.appendText(stampa);
    }

    @FXML
    void doCompleta(ActionEvent event) {
    	int matricola;
    	Studente s = null;
    	try {
    		matricola = Integer.parseInt(txtMatricola.getText());
    	} catch (NumberFormatException e) {
    		txtResult.appendText("Devi inserire una matricola\n");
    		return;
    	}
    	
    	txtNome.setText(this.model.completaStudente(matricola).getNome());
    	txtCognome.setText(this.model.completaStudente(matricola).getCognome());
    	
    	
    }

    @FXML
    void doCorsi(ActionEvent event) {
    	
    }

    @FXML
    void doIscrivi(ActionEvent event) {
    	if(cmbCorsi.getValue() != null) {
	    	int matricola;
	    	try {
	    		matricola = Integer.parseInt(txtMatricola.getText());
	    	} catch (NumberFormatException e) {
	    		txtResult.appendText("Devi inserire una matricola\n");
	    		return;
	    	}
	    	
	    	boolean isIscritto = this.model.isStudenteIscritto(cmbCorsi.getValue(), matricola);
	    	if(isIscritto==true) {
	    		txtResult.appendText("Lo studente "+matricola+" è già iscritto al corso: "+cmbCorsi.getValue().getNome());
	    	} else {
	    		if(this.model.iscriviStudente(cmbCorsi.getValue(), matricola)==true) {
	    			txtResult.appendText("Lo studente "+matricola+" è stato iscritto al corso: "+cmbCorsi.getValue().getNome()+"\n");
	    		} else {
	    			txtResult.appendText("Non è stato possibile iscrivere lo studente\n");
	    		}
	    	}
    	} else {
    		txtResult.appendText("Scegliere un corso");
    	}
    }

    @FXML
    void doReset(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert cmbCorsi != null : "fx:id=\"cmbCorsi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnCercaIscritti != null : "fx:id=\"btnCercaIscritti\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtMatricola != null : "fx:id=\"txtMatricola\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnCompleta != null : "fx:id=\"btnCompleta\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnCercaCorsi != null : "fx:id=\"btnCercaCorsi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnIscrivi != null : "fx:id=\"btnIscrivi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";

    }
    
    public void setModel (Model model) {
    	this.model=model;
    	cmbCorsi.getItems().addAll(model.getCorsi());
    }
    
}
