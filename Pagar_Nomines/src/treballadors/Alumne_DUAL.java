package treballadors;

public class Alumne_DUAL extends Treballador_Parcial{

	public double quantitatAPagar(int hores){
		
		if(hores <=40) return getPreuHora() * hores;
		
		else{
			
			return getPreuHora() * 40 + getPreuHora() * 2 * (hores - 40);
		}
	}
}
