package it.polito.tdp.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class Model {

	//questa lista in realtà potevo anche non definirla,non è servita molto
	private List<Table> tables;
	/*
	 * OSS: ora definisco anche una mappa che mi associ i tavoli ai gruppi, perchè
	 * mi velocizza molto la ricerca dei tavoli quando dalla eventList estraggo un
	 * TypeEvent che è PARTENZA_GRUPPO_CLIENTI
	 */
	private Map<CustomerGroup,Table> tablesWithCustomers;
	Statistics stats;
	
	
	//lista degli eventi
	Queue<Event> eventList;
	
	
	public Model(){
		tables= new ArrayList<Table>();
		stats= new Statistics();
		eventList = new PriorityQueue<Event>();
		tablesWithCustomers= new HashMap<>();
	}
	
	
	
	public void addTable(int n){
		//OSS: posso usare tables.size()+1 come id per i tavoli, così ho valori da 1
		//a 15
		tables.add(new Table(tables.size()+1,n));
		stats.addNumTavoli();
	}
	
	public void addEvent(Event e){
		eventList.add(e);
	}
	
	public void simula(){
		Event e;
		while((e=eventList.poll())!=null){
			CustomerGroup g=e.getGroup();
			Table t;
			switch(e.getType()){
			case ARRIVO_GRUPPO_CLIENTI:
				stats.addNumGroups();
				stats.addTotCustomers(g.getNumPersone());
				t = findSmallestTableForGroup(g);
				if(t!=null){ 
					t.setLibero(false);
					t.setGroup(g);
					tablesWithCustomers.put(g, t);
					eventList.add(new Event(e.getTime()+g.getDurata(),
									Event.TypeEvent.PARTENZA_GRUPPO_CLIENTI,g));
					stats.addSatCustomers(g.getNumPersone());
					stats.addSatGroups();
					
				}
				else{
					//genero un valore random per decidere se vanno al bancone o no
					//Anche qui, dopo aver visto che funziona, tolgo il seme fissato
					//e uso solo Random()
					Random rn=new Random(1);
					if(rn.nextFloat()<=g.getToll()){
						//il gruppo si mette al bancone, ma non aggiungo nulla alla 
						//eventList tanto la capienza del bancone è illimitata
						stats.addSatCustomers(g.getNumPersone());
						stats.addSatGroups();
					}
					//else non aumento satCustomers	
				}
				break;
			case PARTENZA_GRUPPO_CLIENTI:
				t=tablesWithCustomers.get(g);//di sicuro t è diverso da null
				t.setLibero(true);
				t.setGroup(null);
				break;
			default:
				//RICORDA questo tipo di eccezione, posso usarla quando il tipo di evento
				//non si trova
				throw new IllegalArgumentException("Errore: tipo di evento non ammesso");
			
			}
			
		}
	}
	
	public Table findSmallestTableForGroup(CustomerGroup g){
		Table tmin=null;
		for(Table t: tables){
			if(t.isLibero()){
				if(t.getNumPosti()==g.getNumPersone())
					return t;
				if(t.getNumPosti()>g.getNumPersone())
					if(tmin==null || t.getNumPosti()<tmin.getNumPosti())
						tmin=t;															
			}
		}
		
		return tmin;//OSS:se non c'è nessun tavolo restituisce null
	}
	
	public Statistics getStats(){
		return stats;
	}
	
	public void clear(){
		tablesWithCustomers.clear();
		eventList.clear();
		stats.clear();
		
	}
}
	
	
