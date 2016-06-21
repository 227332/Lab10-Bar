package it.polito.tdp.model;

public class Table {

	private int id;
	private int numPosti;
	private boolean libero;
	private CustomerGroup group; //gruppo che sta in quel tavolo
	
	public Table(int id,int n){
		this.id=id;
		numPosti=n;
		libero=true;
		group=null;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumPosti() {
		return numPosti;
	}

	public void setNumPosti(int numPosti) {
		this.numPosti = numPosti;
	}
	
	
	public boolean isLibero() {
		return libero;
	}

	public void setLibero(boolean libero) {
		this.libero = libero;
	}
	
	

	public CustomerGroup getGroup() {
		return group;
	}

	public void setGroup(CustomerGroup group) {
		this.group = group;
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
		Table other = (Table) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Table [id=" + id + ", numPosti=" + numPosti + "]";
	}
	
	
	
}
