package treballadors;

public class Treballador_TempsComplet extends Treballador {
	
	private double salariSetmanal;
	private double deduccioFiscal;
	
	public void setsalariSetmanal(double salariSetmanalIn){
		this.salariSetmanal = salariSetmanalIn;
	}
	
	public double getsalariSetmanal(){
		return salariSetmanal;
	}
	
	public void deduccioFiscal(double deduccioFiscalIn){
		this.deduccioFiscal = deduccioFiscalIn;
	}
	
	public double getdeduccioFiscal(){
		return deduccioFiscal;
	}

	public double quantitatAPagar(){
		return salariSetmanal - deduccioFiscal;
	}
}
