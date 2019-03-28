package it.polito.tdp.lab04.model;

import java.util.*;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class Model {
	
	CorsoDAO daoCorso = new CorsoDAO();
	StudenteDAO daoStudente = new StudenteDAO();

	public Studente completaStudente(int matricola) {
		// TODO Auto-generated method stub
		List<Studente> studenti = new LinkedList<Studente>();
		studenti = daoStudente.getStudenti();
		for(Studente s : studenti) {
			if (s.getMatr()==matricola)
				return s;
		}
		return null;
	}

	public List<Corso> getCorsi() {
		// TODO Auto-generated method stub
		return daoCorso.getTuttiICorsi();
	}

	public List<Studente> getStudentiIscritti(Corso c) {
		// TODO Auto-generated method stub
		return daoCorso.getStudentiIscrittiAlCorso(c);
	}

	public List<Corso> getCorsiSeguiti(int matricola) {
		// TODO Auto-generated method stub
		return daoStudente.getCorsiSeguiti(matricola);
	}

	public boolean isStudenteIscritto(Corso value, int matricola) {
		// TODO Auto-generated method stub
		List<Corso> corsiSeguiti = new ArrayList<Corso>();
		corsiSeguiti=daoStudente.getCorsiSeguiti(matricola);
		return corsiSeguiti.contains(value);
	}

	public boolean iscriviStudente(Corso value, int matricola) {
		// TODO Auto-generated method stub
		List<Studente> studenti = new LinkedList<Studente>();
		studenti = daoStudente.getStudenti();
		Studente studente = null;
		for(Studente s : studenti) {
			if (s.getMatr()==matricola)
				studente = new Studente(matricola, s.getNome(), s.getCognome(), s.getCds());
		}
		return daoCorso.iscriviStudenteACorso(studente, value);
	}

	

	
}
