package it.polito.tdp.bar.model;

public class Event implements Comparable<Event> {
	
	public enum eventTypeEnum {
		ARRIVO_GRUPPO_CLIENTI, PARTENZA_GRUPPO_CLIENTI
	};

	public long timeStamp;
	public eventTypeEnum eventType;
	public GruppoCustomer customer;

	public Event(long timeStamp, eventTypeEnum eventType, GruppoCustomer customer) {
		this.timeStamp = timeStamp;
		this.eventType = eventType;
		this.customer = customer;
	}

	@Override
	public int compareTo(Event e) {
		return Long.compare(this.timeStamp, e.timeStamp);
	}
}
