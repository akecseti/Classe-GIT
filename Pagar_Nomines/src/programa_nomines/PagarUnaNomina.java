package programa_nomines;

import treballadors.*; //importem totes les classes que tenim a l'altre paquet, el paquet treballadors

public class PagarUnaNomina {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Treballador treb = new Treballador();		
		treb.pagaSenzilla(12.23); //aquest treballador agafarà el nom i nom de feina que tenim per defecte
		
		Treballador treb2 = new Treballador("Andrei", "Informatic"); //a aquest nou treballador li passem nosaltres el nom i nomdeFeina
		treb2.pagaSenzilla(50.20);
		
		Treballador treb3 = new Treballador();
		treb3.setNom("Tomas");     
		treb3.setNomFeina("Programador XD");  //creem un nou treballador però enlloc de que agafi els valors per defecte els hi posem nosaltres amb set
		treb3.pagaSenzilla(10.10);
		
		Treballador_TempsComplet trebComp = new Treballador_TempsComplet();
		trebComp.getNom();
		System.out.println("\n"+trebComp.getNom());
		
		Alumne_DUAL precari = new Alumne_DUAL();
		precari.setPreuHora(1.5);
		System.out.println(precari.quantitatAPagar(50));
		System.out.println("Programa modificat!");
	}

}
