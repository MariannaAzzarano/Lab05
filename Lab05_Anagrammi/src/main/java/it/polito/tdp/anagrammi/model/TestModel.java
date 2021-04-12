package it.polito.tdp.anagrammi.model;

import java.util.List;
import java.util.Map;

public class TestModel {

	public static void main(String[] args) {
		Model m = new Model();
		//m.anagrammi("eat");
		for(String s : m.anagrammi("tea")) {
			System.out.println(s);
		}
		
		System.out.println("\n\n\nCORRETTI E NON");
		Map<String, List<String>> anagrammi = m.anagrammiCorrettiENon("tea");
		for(String key : anagrammi.keySet()) {
			for(String s : anagrammi.get(key)) {
				System.out.println(key + " ---> "+ s);
			}
		}

	}
	
	

}
