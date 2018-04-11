package it.polito.tdp.anagrammi.model;

import java.util.HashSet;
import java.util.Set;

import it.polito.tdp.anagrammi.DAO.AnagrammiDAO;

public class AnagrammiModel {
	
	Set <String> soluzione;
	AnagrammiDAO anagrammiDAO = new AnagrammiDAO ();
	
	
	public Set <String> calcolaAnagrammi (String parola){
		
		this.soluzione = new HashSet <String> ();
		
		int livello = 0;
		String parziale = "";
				
		this.cercaAnagrammi(livello, parziale, parola, parola.length());
		
		return soluzione;
	}
	
	
	// FUNZIONE RICORSIVA
	private void cercaAnagrammi(int livello, String parziale, String parola, int dim) {
		
		// condizione di terminazione
		if (parziale.length() == dim) {
			soluzione.add(parziale);
			return;
		}
		
		// generare una soluzione aggiungendo una lettera alla parziale
		for (int i = 0; i < dim; i++) {
			
			// filtro
			if (countChar(parziale, parola.charAt(i)) < countChar(parola, parola.charAt(i))) {
				parziale += parola.charAt(i);
		
				cercaAnagrammi (livello + 1, parziale, parola, dim);
				
				// backtracking
				parziale = parziale.substring(0, parziale.length() - 1);
			}
		}
		
	}


	private int countChar(String parziale, char c) {
		int count = 0;
		for (int i = 0; i < parziale.length(); i++)
			if (parziale.charAt(i) == c)
				count ++;
		return count;
	}


	public boolean isCorrect(String anagramma) {
		return this.anagrammiDAO.isCorrect(anagramma);
	}

	
	
}
