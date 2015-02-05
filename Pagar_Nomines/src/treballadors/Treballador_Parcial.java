package treballadors;

public class Treballador_Parcial extends Treballador {

	private double preuHora;
	
	public void setPreuHora(double preuIn){
		preuHora = preuIn;
	}
	
	public double getPreuHora(){
		return this.preuHora;
	}
	
	public double quantitatAPagar(int hores){
		return preuHora * hores;
	}
}
