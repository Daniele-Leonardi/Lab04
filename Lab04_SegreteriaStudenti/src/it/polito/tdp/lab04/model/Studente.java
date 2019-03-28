package it.polito.tdp.lab04.model;

public class Studente {
	private int matr;
	private String nome;
	private String cognome;
	private String cds;
	public Studente(int matr, String nome, String cognome, String cds) {
		super();
		this.matr = matr;
		this.nome = nome;
		this.cognome = cognome;
		this.cds = cds;
	}
	public int getMatr() {
		return matr;
	}
	public void setMatr(int matr) {
		this.matr = matr;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getCds() {
		return cds;
	}
	public void setCds(String cds) {
		this.cds = cds;
	}
	@Override
	public String toString() {
		return "Studente [matr=" + matr + ", nome=" + nome + ", cognome=" + cognome + ", cds=" + cds + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + matr;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Studente other = (Studente) obj;
		if (matr != other.matr)
			return false;
		return true;
	}
	
}
