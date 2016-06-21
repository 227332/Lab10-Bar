package it.polito.tdp.model;



public class Event implements Comparable<Event> {
	
	/*
	 * ATT: ricorda di mettere i tipi enum come public, ltrimenti non posso usare nelle altre
	 * classi la scritta Event.TypeEvent.ARRIVO_GRUPPO_CLIENTI
	 */
	public enum TypeEvent {
		ARRIVO_GRUPPO_CLIENTI, PARTENZA_GRUPPO_CLIENTI
	}
	
	private long time; //uso long perchè il testo dice che il tempo è espresso in minuti
	private TypeEvent type;
	private CustomerGroup group; //entità coinvolta in tale evento...in questo caso un gruppo clienti
	
	
	public Event(long time, TypeEvent type, CustomerGroup group) {
		super();
		this.time = time;
		this.type = type;
		this.group = group;
	}
	
	
	
		
    public long getTime() {
		return time;
	}




	public void setTime(long time) {
		this.time = time;
	}




	public TypeEvent getType() {
		return type;
	}




	public void setType(TypeEvent type) {
		this.type = type;
	}




	public CustomerGroup getGroup() {
		return group;
	}




	public void setGroup(CustomerGroup group) {
		this.group = group;
	}




	@Override
	public String toString() {
		return "Event [time=" + time + ", type=" + type + ", group=" + group + "]";
	}




	public int compareTo(Event e) {
		return Long.compare(time, e.time);
	}
    
	
	
}
