package it.polito.tdp.anagrammi.model;

import java.util.Set;

public class TestModel {

	public static void main(String[] args) {
		
		AnagrammiModel model = new AnagrammiModel ();
		String parola = "tiziano";
		
		Set <String> anagrammi = model.calcolaAnagrammi(parola);

		System.out.println("Numero di anagrammi: " + anagrammi.size());
		
		for (String s : anagrammi)
			System.out.println(s);

	}

}
