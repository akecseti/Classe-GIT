package programa_nomines;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import treballadors.*;

public class PagarMultiplesNomines {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	File arxiu = null;
	FileReader fr = null; //el pipe (tub de lectura)
	BufferedReader br = null; //on emmagatzem la informació del pipe
	
	//Creem cada un dels treballadors, ja que són de tipus diferents
	Alumne_DUAL alumnedual = new Alumne_DUAL();
	Treballador_Parcial treballadorParcial = new Treballador_Parcial();
	Treballador_TempsComplet treballadorTempsComplet = new Treballador_TempsComplet();
	
	String tipus_treballador = "";  //Aqui guardarem el tipus de trebllador, ex: alumnedual, temps parcial...
	String agafar_preu_hora = "";   //Agafem el preu per hora que tenen els treballadors tipus alumnedual i temps parcial (variable tipus String que convertirem a double)
	double preu_hora = 0.0; //Aquí guardem el preu per hora que tenen els treballadors tipus alumnedual i temps parcial (després de convertir-lo a double) 
	String agafar_hores_totals = ""; //Agafem les hores totals que tenen els treballadors tipus alumnedual i temps parcial (variable tipus String que convertirem a int)
	int hores_totals = 0; //Aquí guardem les hores totals que tenen els treballadors tipus alumnedual i temps parcial (després de convertir-les a int)
	String nom_treballador = "";  //Agafem el nom de cada treballador
	String nom_feina = "";  //Agafem l'ofici de cada treballador

	
	try{
		//Obrim el fitxer
	    arxiu = new File("nomines.txt"); //el fitxer es diu nomines.txt
	    fr = new FileReader(arxiu);
	    br = new BufferedReader(fr);
	    
	    //Amb el bucle llegirem linia a linia
	    String linia;
		while((linia = br.readLine())!=null){//mentre hi ha linies per llegir			
			int i = 0;
	    	String [] paraula = linia.split(" "); //dividim el text en paraula per paraula
	    	while(i<paraula.length){
	    		nom_treballador = paraula[1]; //la segona paraula que llegim correspon al nom del treballador
	    		nom_feina = paraula[2]; //la tercera paraula que llegim correspon al nom del treball del treballador
	    		agafar_preu_hora = paraula[3]; //la quarta paraula que llegim correspon al preu per hora del treballador menys en el tipus de treballador TEMPS_COMPLET, que equival al salari setmanal
	    		agafar_hores_totals = paraula[4]; //la cinquena paraula que llegim correspon a les hores totals del treballador menys en el tipus de treballador TEMPS_COMPLET, que equival a les deduccions fiscals
	    		i++;
	    	}
	    		    	
	    	preu_hora = Double.parseDouble(agafar_preu_hora); //convertim la variable string preu_hora a tipus double per poder fer els càlculs
	    	hores_totals = Integer.parseInt(agafar_hores_totals);  //convertim la variable string hores_totals a numero enter per poder fer els càlculs
	    	 
	    	if(linia.startsWith("1")){ //si al començament de la línia hi ha un 1 es tracta del tipus de treballador temps_complet
		    	tipus_treballador = "TREBALLADOR A TEMPS COMPLET";
		    	treballadorTempsComplet.setsalariSetmanal(Double.parseDouble(paraula[3])); //li assignem el salari setmanal per poder calcular quan li correspon a pagar
		    	treballadorTempsComplet.deduccioFiscal(Double.parseDouble(paraula[4])); //li assignem les deduccions fiscals per poder calcular quan li correspon a pagar
		    	//quantitat a pagar correspon a la resta del salari setmanal - deduccions fiscals
		    	System.out.println("Al treballador "+nom_treballador+", treballador del tipus ("+tipus_treballador+"), que treballa de "+nom_feina+" li correspon ---> "+treballadorTempsComplet.quantitatAPagar()+" €"); 
	    	}else{
	    		if(linia.startsWith("2")){ //si al començament de la línia hi ha un 2 es tracta del tipus de treballador temps_parcial
	    			tipus_treballador = "TREBALLADOR A TEMPS PARCIAL";
	    			treballadorParcial.setPreuHora(preu_hora);
	    			System.out.println("\nAl treballador "+nom_treballador+", treballador del tipus ("+tipus_treballador+"), que treballa de "+nom_feina+" li correspon ---> "+treballadorParcial.quantitatAPagar(hores_totals)+" €");
	    		}
	    		else{
	    			tipus_treballador = "ALUMNE DUAL";  //si al començament de la línia hi ha un 3 es tracta del tipus de treballador alumne_dual
	    			alumnedual.setPreuHora(preu_hora);   	
			    	System.out.println("\nAl treballador "+nom_treballador+", treballador del tipus ("+tipus_treballador+"), que treballa de "+nom_feina+" li correspon ---> "+alumnedual.quantitatAPagar(hores_totals)+" €");
	    		}
	    	}	
		}
	    	
	    }catch(Exception e){
	    		System.out.println(e.getMessage());
	    }finally{
	    	//Entrarà al finally tant si falla com si no, per tal de tancar el fitxer
	    	try{
	    		if(null!=fr){
	    			fr.close();
	    		}
	    	}catch(Exception e){
	    		System.out.println(e.getMessage());
	    	}
	    }
	
		
	}

}