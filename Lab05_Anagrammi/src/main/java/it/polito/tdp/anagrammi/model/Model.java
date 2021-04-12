package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import it.polito.tdp.anagrammi.DAO.AnagrammaDAO;

public class Model {
	
	private AnagrammaDAO aDAO;
	
	
	public Model() {
		this.aDAO = new AnagrammaDAO();
	}
	
	
	
	public List<String> anagrammi(String parola){
		List<String> risultato = new ArrayList<String>();
		permuta("", 0, parola, risultato);
		
		
		return risultato;     //completa e cambia il null
	}
	
    private void permuta(String parziale, int livello, String lettere, List<String> risultato) {
    	if(lettere.length()== 0) {
    		if(!risultato.contains(parziale)) {  //per non avere parole ripetute (quando una parola ha almeno due lettere uguali)
    			risultato.add(parziale);
    		}
    	}
    	else {
    		for(int pos=0; pos<lettere.length(); pos++) {   //pos è un puntatore sulle lettere della parola 'lettere'
    			String nuovoParziale = parziale + lettere.charAt(pos);
    			String nuovaLettere = lettere.substring(0, pos) + lettere.substring(pos+1);
    			
    			permuta(nuovoParziale, livello+1, nuovaLettere, risultato);
    			
    		}
    	}
		
	}
    
    public Map<String, List<String>> anagrammiCorrettiENon(String parola){
    	List<String> risultato = this.anagrammi(parola);
    	Map<String, List<String>> anagrammi = new LinkedHashMap<String, List<String>>();
    	anagrammi.put("corretti", new ArrayList<String>());
    	anagrammi.put("errati", new ArrayList<String>());
    	for(String s : risultato) {
    		if(aDAO.contiene(s)) {
    			anagrammi.get("corretti").add(s);
    		}
    		else {
    			anagrammi.get("errati").add(s);
    		}
    	}
    	return anagrammi;
    }

	

}
