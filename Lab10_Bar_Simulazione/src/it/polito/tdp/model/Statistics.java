package it.polito.tdp.model;

public class Statistics {
	private int totCustomers=0;
	private int satCustomers=0; //numero di clienti soddisfatti
	private int numTavoli=0;
	private int numGroups=0;
	private int satGroups=0;
	public int getTotCustomers() {
		return totCustomers;
	}
	public void addTotCustomers(int n) {
		this.totCustomers = this.totCustomers+n ;
	}
	public int getSatCustomers() {
		return satCustomers;
	}
	public void addSatCustomers(int n) {
		this.satCustomers = this.satCustomers+n;
	}
	public int getNumTavoli() {
		return numTavoli;
	}
	public void addNumTavoli() {
		numTavoli ++;
	}
	
	public int getNumGroups() {
		return numGroups;
	}
	public void addNumGroups() {
		numGroups++;
	}
	
	public int getSatGroups() {
		return satGroups;
	}
	public void addSatGroups() {
		satGroups ++;
	}
	public void setTotCustomers(int totCustomers) {
		this.totCustomers = totCustomers;
	}
	public void setSatCustomers(int satCustomers) {
		this.satCustomers = satCustomers;
	}
	public void setNumTavoli(int numTavoli) {
		this.numTavoli = numTavoli;
	}
	public void setNumGroups(int numGroups) {
		this.numGroups = numGroups;
	}
	public void setSatGroups(int satGroups) {
		this.satGroups = satGroups;
	}
	@Override
	public String toString() {
		return "\n Statistics:\n totCustomers=" + totCustomers + "\n satCustomers=" + satCustomers + "\n numTavoli="
				+ numTavoli + "\n numGroups=" + numGroups + "\n satGroups=" + satGroups + "\n";
	}
	public void clear() {
		// TODO Auto-generated method stub
		totCustomers=0;
		satCustomers=0;
		numGroups=0;
		satGroups=0;
		
	}

	

	
	
	
}
