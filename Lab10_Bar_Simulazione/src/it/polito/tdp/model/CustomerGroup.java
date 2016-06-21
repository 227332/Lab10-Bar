package it.polito.tdp.model;

public class CustomerGroup {

	private int id;
	private int numPersone;
	private long tempoArrivo;
	private long durata; //OSS: anche durata è meglio metterla a long
	private float toll; //OSS: se il testo dice float allora u usa float, NON double
	
	public CustomerGroup(int id, int numPersone, long tempoArrivo, long durata, float toll) {
		this.id=id;
		this.numPersone = numPersone;
		this.tempoArrivo = tempoArrivo;
		this.durata = durata;
		this.toll = toll;
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getNumPersone() {
		return numPersone;
	}


	public void setNumPersone(int numPersone) {
		this.numPersone = numPersone;
	}


	public long getTempoArrivo() {
		return tempoArrivo;
	}


	public void setTempoArrivo(long tempoArrivo) {
		this.tempoArrivo = tempoArrivo;
	}


	public long getDurata() {
		return durata;
	}


	public void setDurata(long durata) {
		this.durata = durata;
	}


	public float getToll() {
		return toll;
	}


	public void setToll(float toll) {
		this.toll = toll;
	}


	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		CustomerGroup other = (CustomerGroup) obj;
		if (id != other.id)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "CustomerGroup [id=" + id + ", numPersone=" + numPersone + ", tempoArrivo=" + tempoArrivo + ", durata="
				+ durata + ", toll=" + toll + "]";
	}
	
	
	
	
	
	
	
	
}
