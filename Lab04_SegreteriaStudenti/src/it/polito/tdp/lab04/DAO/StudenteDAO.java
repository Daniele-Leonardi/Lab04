package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class StudenteDAO {

	public List<Studente> getStudenti() {

		final String sql = "SELECT * FROM studente";

		List<Studente> studenti = new LinkedList<Studente>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				int matr = rs.getInt("matricola");
				String cognome = rs.getString("cognome");
				String nome = rs.getString("nome");
				String cds = rs.getString("CDS");

				//System.out.println(matr + " " + cognome + " " + nome + " " + cds);

				// Crea un nuovo JAVA Bean Corso
				Studente s = new Studente(matr, nome, cognome, cds);
				
				// Aggiungi il nuovo oggetto Corso alla lista corsi
				studenti.add(s);
			}
			rs.close();
			conn.close();
			return studenti;

		} catch (SQLException e) {
		  e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}

	public List<Corso> getCorsiSeguiti(int matricola) {
		// TODO Auto-generated method stub
		final String sql= "SELECT * FROM corso c, iscrizione i WHERE c.codins = i.codins && i.matricola = ?";
		
		List<Corso> corsiSeguiti = new LinkedList<Corso>();
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, matricola);
			
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {

				String codins = rs.getString("codins");
				int numeroCrediti = rs.getInt("crediti");
				String nome = rs.getString("nome");
				int periodoDidattico = rs.getInt("pd");

				//System.out.println(codins + " " + numeroCrediti + " " + nome + " " + periodoDidattico);

				// Crea un nuovo JAVA Bean Corso
				Corso c = new Corso(codins, numeroCrediti, nome, periodoDidattico);
				
				// Aggiungi il nuovo oggetto Corso alla lista corsi
				corsiSeguiti.add(c);
			}
			rs.close();
			conn.close();
			return corsiSeguiti;
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}

	}

	public boolean isIscritto(Corso value, int matricola) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
}
