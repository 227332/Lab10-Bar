package it.polito.tdp.bar;



import java.util.Random;

import it.polito.tdp.model.CustomerGroup;
import it.polito.tdp.model.Event;
import it.polito.tdp.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class BarController {
	
	private Model model;
	private final int TOT_GROUPS=2000;
	
    @FXML
    private TextArea txtRisultato;
    
    public void setModel(Model model) {
    	
    	this.model=model;
    	
    	// Aggiungo i tavoli al simulatore, che qui è stesso il mio model
    	model.addTable(10);
    	model.addTable(10);

    	model.addTable(8);
    	model.addTable(8);
    	model.addTable(8);
    	model.addTable(8);

    	model.addTable(6);
    	model.addTable(6);
    	model.addTable(6);
    	model.addTable(6);

    	model.addTable(4);
    	model.addTable(4);
    	model.addTable(4);
    	model.addTable(4);
    	model.addTable(4);
    }
    
    @FXML
    void doSimula(ActionEvent event) {
    	
    	model.clear();//azzero le statistiche e svuoto l'eventList
    	txtRisultato.clear();
    	
		// Creo un nuovo generatore di numeri casuali con seed iniziale 42.
		//OSS: se invece uso Random() allora ogni volta che premo il bottone simula
		// ho un risultato diverso...Qui però per il momento voglio concentrarmi su 
		//una sola simulazione, finchè non sono sicura che il codice funzioni.
    	//Una volta che ho visto che funziona scrivo:
    	//Random rn = new Random();
		Random rn = new Random(42);
		
		long tempoUltimoArrivo = 0;
    	
    	//Genero in modo random 2000 eventi del tipo ARRIVO_GRUPPO_CLIENTI
    	for(int i=0; i<TOT_GROUPS; i++){
    		
    		/*
    		 * RICORDA: ecco come si generano i vari numeri casuali di vario tipo!!!
    		 */
    		
    		//nextInt(n) restituisce un intero tra 0 e n-1
    		long tempoArrivo = tempoUltimoArrivo + 1 + rn.nextInt(10);
    		tempoUltimoArrivo=tempoArrivo;
    		int numPersone =  1 + rn.nextInt(10);
    		
    		/*
    		 * OSS: purtroppo nextInt(n) non ha un analogo per il caso float, double o long, perciò
    		 * in questi casi devo per forza fare così:
    		 * - per double o float -> uso rn.nextDouble() e rn.nextFloat(), i quali restituiscono un
    		 * 						   double o float tra 0.0 e 1.0, e poi lo converto in un valore tra
    		 * 							[a,b] facendo a+(b-a)*rn.nextDouble() e a+(b-a)*rn.nextDouble()
    		 * - per long -> non posso usare neanche rn.nextLong() perchè esso mi dà un long grande
    		 * 				 a piacere! Perciò posso procedere in due modi:
    		 * 				  -- faccio rn.longs(1, a, b).toArray()[0]
    		 * 				  -- faccio (long)(a+Math.random()*(b-a)) o (long)(a+rn.nextDouble()*(b-a))
    		 * 				 CONVIENE L'ultimo dei due!!!
    		 */
			long durata = (long) (60 + rn.nextDouble() * 60);
			float toll = rn.nextFloat();
			

			// Genero un nuovo gruppo di clienti
			CustomerGroup customerGroup = 
					new CustomerGroup(i+1, numPersone, tempoArrivo, durata, toll);
			
			// Creo un nuovo evento e lo inserisco nella coda
			Event e = new Event(tempoArrivo, Event.TypeEvent.ARRIVO_GRUPPO_CLIENTI, customerGroup);
			model.addEvent(e);
    		
    	}
    	model.simula();
    	
    	txtRisultato.appendText(model.getStats().toString());
    	
    			
		
    }
    
    @FXML
    void initialize() {
        assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'Bar.fxml'.";
    }
}