package treballadors;

public class Treballador {
	
	private String nom;
	private String nomFeina;
	
	//CLASSE CONSTRUCTORA AMB VALORS PER DEFECTE
	public Treballador(){
		this.nom="Joan";
		this.nomFeina="Currante";
	}
	
	//CLASSE CONSTRUCTORA AMB INTRODUCCIO DE DADES
	public Treballador(String nomIn, String feinaIn){
		this.nom = nomIn;
		this.nomFeina = feinaIn;
	}
	
	public void setNom(String nomIn){
		this.nom = nomIn;
	}
	
	public String getNom(){
		return nom;
	}
	
	public void setNomFeina(String feinaIn){
		this.nomFeina = feinaIn;
	}
	
	public String getNomFeina(){
		return nomFeina;
	}
	
	public void pagaSenzilla(double quantitatPaga){
		System.out.print("\nPagament a realitzar a "+nom);
		System.out.print(" "+nomFeina+" --->");
		System.out.print(" "+ quantitatPaga+" €");
	}
}
