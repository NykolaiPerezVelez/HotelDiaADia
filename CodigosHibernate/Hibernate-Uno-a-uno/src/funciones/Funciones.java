package funciones;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
   
public class Funciones {    	
	
	private static final ArrayList<GregorianCalendar> lstFeriados = new ArrayList<GregorianCalendar>();
	   
	public static int traerAnio(GregorianCalendar f){
		return f.get(Calendar.YEAR); 
	} 
 
	public static int traerMes(GregorianCalendar f){
		return f.get(Calendar.MONTH)+1;
	} 
	
	public static int traerDia(GregorianCalendar f){
		return f.get(Calendar.DAY_OF_MONTH);
	}
	
	public static boolean esBisiesto (int anio){
		return ((anio % 4 == 0) && ((anio % 100 != 0) || ( anio % 400 == 0)));
	} 
		
	public static boolean esFechaValida (int anio, int mes, int dia){
		boolean validacion;
		if ((anio <= 2015) && (mes <= 12) && (mes >= 0) && (dia > 0) && (dia <= 31)){ 
			if ((esBisiesto(anio) == true) && (mes == 2)){
					if (dia <=29){
						validacion = true;
					}else{ 
						validacion = false;
					}	
			}else{ 
				if ((mes == 4) || (mes == 6) || (mes == 9) || (mes == 11)){
					 if (dia <= 30){
						validacion = true;
					 }else{ 
						validacion = false;
					 }
				}else if((mes == 1) || (mes == 3) || (mes == 5) || (mes == 7) || (mes == 8) || (mes == 10)){
					 if (dia <= 31){
						validacion = true;
					 }else{ 
						validacion = false;
					 }
				}else{ 
					 if (dia <= 28){
						 validacion = true;
					 }else{
						  validacion = false;
					 }
				}
			}
		}else{
			validacion = false; 
		}	
		
	 return validacion;
	  } 
	
	public static GregorianCalendar traerFecha (int anio, int mes, int dia){
		GregorianCalendar fecha = new GregorianCalendar(anio, mes-1, dia);
		return fecha;	
	}
	
	public static GregorianCalendar traerFecha2 (String fechaprueba){ 
		GregorianCalendar fecha= new GregorianCalendar ();
		fecha.set(GregorianCalendar.DAY_OF_MONTH, Integer.parseInt(fechaprueba.substring(0,2)));
		fecha.set(GregorianCalendar.MONTH, Integer.parseInt(fechaprueba.substring(3,5))-1);
		fecha.set(GregorianCalendar.YEAR, Integer.parseInt(fechaprueba.substring(6,10)));
		return fecha;

	}
	
	public static String traerFechaCorta (GregorianCalendar f2){
		String fechaCorta;
		if (traerMes(f2) >= 10){  
			if (traerDia(f2)>= 10)
				fechaCorta = (traerDia(f2)+"/"+traerMes(f2)+"/"+traerAnio(f2));
			else
				fechaCorta = ("0"+traerDia(f2)+"/"+traerMes(f2)+"/"+traerAnio(f2));
		}else{ 
			if (traerDia(f2)>= 10)
				fechaCorta = (traerDia(f2)+"/0"+traerMes(f2)+"/"+traerAnio(f2));
			else 
				fechaCorta = ("0"+traerDia(f2)+"/0"+traerMes(f2)+"/"+traerAnio(f2));
		}
		return fechaCorta;
	}
	
	public static boolean esDiaHabil(GregorianCalendar f){
		boolean resultado = false;
		if ((f.get(Calendar.DAY_OF_WEEK) <= 6) && (f.get(Calendar.DAY_OF_WEEK) > 1))
			resultado = true;
		return resultado;		
	}
	
	public static String traerDiaDeLaSemana (GregorianCalendar f){
		String DiaSemanaLet = null;
		switch (f.get(Calendar.DAY_OF_WEEK)){ //Si tomamos al lunes como primer dia, se modificarian los case empezando por el "Lunes".
			case 1: 			  //Ademas, para que funcione, deberiamos tener modificado el metodo anterior con la configuracion explicada en los comentarios del mismo.
				DiaSemanaLet = "Domingo";  	
			break;
			
			case 2:
				DiaSemanaLet = "Lunes";
			break;
			
			case 3: 
				DiaSemanaLet = "Martes";
			break;
			
			case 4: 
				DiaSemanaLet = "Miercoles";
			break;
			
			case 5:
				DiaSemanaLet = "Jueves";
			break;
			
			case 6:
				DiaSemanaLet = "Viernes";
			break;
			
			case 7:
				DiaSemanaLet = "Sabado";
			break;					
		}
		
		return DiaSemanaLet;
	}
	
	public static String traerMesEnLetras (GregorianCalendar f){
		String nombMes = null;
		switch (traerMes(f)-1){    	//Como el metodo traerMes nos devuelve el mes con +1, lo nivelamos otra vez. 
		
		case 0: 
			nombMes = "Enero";
		break;
		
		case 1:
			nombMes = "Febrero";
		break;
		
		case 2: 
			nombMes = "Marzo";
		break;
		
		case 3: 
			nombMes = "Abril";
		break;
		
		case 4:
			nombMes = "Mayo";
		break;
		
		case 5: 
			nombMes = "Junio";
		break;
		
		case 6:
			nombMes = "Julio";
		break;
		
		case 7:
			nombMes = "Agosto"; 
		break;
		
		case 8:
			nombMes = "Septiembre";
		break;
		
		case 9:
			nombMes = "Octubre";
		break;
		
		case 10:
			nombMes = "Noviembre";
		break;
		 
		case 11:
			nombMes = "Diciembre";
		break;
		
		}	
		
		return nombMes;
	}  
	  
	public static String traerFechaLarga (GregorianCalendar f){
		String FechaLarga;
		if (traerDia(f) < 10) 
			FechaLarga = (traerDiaDeLaSemana(f)+" 0"+traerDia(f)+" de "+traerMesEnLetras(f)+" del "+traerAnio(f));
		else 
			FechaLarga = (traerDiaDeLaSemana(f)+" "+traerDia(f)+" de "+traerMesEnLetras(f)+" del "+traerAnio(f));
		return FechaLarga;
	} 
	
	public static boolean sonFechasIguales (GregorianCalendar f, GregorianCalendar f2){
		boolean fechaComparar = false;
		if (((traerAnio(f) == traerAnio(f2)) && (traerMes(f)) == traerMes(f2)) && (traerDia(f) == traerDia(f2)))
				fechaComparar = true;
		
		return fechaComparar;	 
	}
	
	public static int traerCantDiasDeUnMes(int anio, int mes){ 
		int cantidad;
		if ((esBisiesto(anio)== true) && (mes== 2)) 
			cantidad = 29;
		else 
			if ((mes == 4) || (mes== 6) || (mes == 9) || (mes== 11))
				cantidad = 30;
			else if ((mes == 1) || (mes == 3) || (mes == 5 ) || (mes == 7) || (mes == 8) || (mes == 10) || (mes == 12))
				cantidad = 31;
			else 
				cantidad = 28; 
		return cantidad;		
	}
	
	public static double aproximar2Decimal (double valor){
		 return Math.rint(valor*100)/100;             //Rinth (redondea un numero al entero mas proximo).
		 											  //Entonces se le pasa numero en decimal (o no) * 10 (elevado a la cantidad de cifras que queremos redondear). Finalmente, dividimos el resultado por lo mismo que multiplicamos el valor.
	}												  //Por ej: Redondear a 2 decimales el valor = 2.346  -> redondear(2.346*100) -> redondear(234.6) -> 235 -> 235/100 -> 2,35. Entonces 2.346 quedo convertido en 2.35
	
	public static double convertirADouble(int n){ 	  //Convierte un entero a un double pero, como siempre las conversiones se hacen sobre strings o substrings:
		return Double.parseDouble(String.valueOf(n)); //Llama a un metodo de la clase String (de java) que convierte el entero a string 
	}												  //Y finalmente convierte ese string a un double
	
	public static boolean esNumero(char c){
		String diccionario_num = "0123456789";
		int i = 0;
		char charArray[] = diccionario_num.toCharArray();
		//System.out.println(charArray.length);
		boolean esNum = false;
		for (i = 0; i<charArray.length; i++){  	//recorre el array de chars y compara con el char recibido como parametro
			if (c == charArray[i]){
				esNum = true;
				i = charArray.length;	
			}
		}
		return esNum;
	}
	
	public static boolean esLetra(char c){
		String diccionario_char = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
		int i = 0;
		char charArray[] = diccionario_char.toCharArray();	
		boolean esUnaLetra = false;
		for (i= 0; i<charArray.length; i++){
			if (c == charArray[i]){
				esUnaLetra = true;
				i = charArray.length;
			}
		}
		return esUnaLetra;		
				 
	}
	
	public static boolean esCadenaNumeros(String cadenaX){
	  char arrayAnalizar[] = cadenaX.toCharArray();
	  int contador = 0;
	  boolean esCadenaNumeros = true;
	  while ((contador < arrayAnalizar.length) && (esCadenaNumeros == true)){
		  if (arrayAnalizar[contador] != ' '){
			  if (esNumero(arrayAnalizar[contador]) == false){ //(0, 1, 2, 20)
				  esCadenaNumeros = false;
			  }
		  } 
		  contador++;
	  }
	 return esCadenaNumeros;	  
	}  
			
	public static boolean esCadenaLetras(String cadenaX){
		char arrayAnalizar[] = cadenaX.toCharArray();
		int contador = 0; 
		boolean esCadenaLetras = true; 
		while ((contador < arrayAnalizar.length) && (esCadenaLetras == true)){
			if (arrayAnalizar[contador] != ' '){
				if (esLetra(arrayAnalizar[contador]) == false){ 
					esCadenaLetras = false;
				} 
			}
		contador++;	
		}
		return esCadenaLetras;
	}	
	
	public static boolean esSexoValido(char c){ 
		String diccionario_sexo = "FfMm";
		boolean sexoValido = false;
		int i = 0;
		for (i= 0; i<(diccionario_sexo.length()); i++){ 
			if (c == diccionario_sexo.charAt(i)){
				sexoValido = true;
			}
		}
		return sexoValido;  		  
						
	}
	
	public static String traerHora(GregorianCalendar f){ //PARA TRAER LA FECHA CORTA + HORA -> JUNTAR CODIGO DE ESTE METODO CON EL DE FECHACORTA
		int hora = f.get(GregorianCalendar.HOUR);
		int minutos = f.get(GregorianCalendar.MINUTE);
		return (hora+":"+minutos); 
		
	 	
	}
	
	public static ArrayList<GregorianCalendar> cargarLstFeriados(){ 
		try {
			File dirBase = new File("src/Datos/feriados.xml"); 
			String ruta = dirBase.getAbsolutePath();
			BufferedReader br = new BufferedReader(new FileReader(ruta));
			
			String entrada;
			String cadena = "";
			
			while ((entrada = br.readLine()) != null) 
				cadena += entrada;
			
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			
			InputSource archivo = new InputSource();
			archivo.setCharacterStream(new StringReader(cadena));
			
			Document documento = db.parse(archivo);
			documento.getDocumentElement().normalize();
			
			NodeList nodeLista = documento.getElementsByTagName("feriado");
			
			String[] tags = {"anio", "mes", "dia"};
			
			for (int s = 0; s < nodeLista.getLength(); s++) { 
				
				Node nodo = nodeLista.item(s);
				String[] valores = new String[tags.length];
				if (nodo.getNodeType() == Node.ELEMENT_NODE) {
					Element elemento = (Element) nodo;
					for (int i = 0; i < tags.length; i++) {
						NodeList nombreElementoLista = elemento.getElementsByTagName(tags[i]);
						Element nombreElemento = (Element) nombreElementoLista.item(0);
						NodeList nombre = nombreElemento.getChildNodes();
						valores[i] = ((Node) nombre.item(0)).getNodeValue().toString();
					}
					
					int anio= Integer.parseInt(valores[0]);
					int mes= Integer.parseInt(valores[1]);
					int dia = Integer.parseInt(valores[2]);  
					GregorianCalendar p= new GregorianCalendar(anio, mes, dia);
					lstFeriados.add(p);
					}
				}
				br.close(); 
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		return lstFeriados;
	}
	
	public static boolean esHabil(GregorianCalendar f){
		boolean esHabil = true; 
		int anio = f.get(Calendar.YEAR);
		int mes =  f.get(Calendar.MONTH);
		int dia = f.get(Calendar.DAY_OF_MONTH); 
		int i = 0;
		if ((f.get(Calendar.DAY_OF_WEEK) == 1) || (f.get(Calendar.DAY_OF_WEEK) == 7)){
			esHabil = false;
		}
		if (esHabil == true){
			for (i= 0; i<lstFeriados.size(); i++){
				if (anio == lstFeriados.get(i).get(Calendar.YEAR)){
					if (mes == lstFeriados.get(i).get(Calendar.MONTH)){
						if (dia == lstFeriados.get(i).get(Calendar.DAY_OF_MONTH)){
							esHabil = false;
							i = lstFeriados.size();
						}
					}	
				} 
			}	
		}   
		
		return esHabil;	 
	}
	
	public static GregorianCalendar traerPrimerDiaHabil(GregorianCalendar f){
		int anio = f.get(Calendar.YEAR);
		int mes  = f.get(Calendar.MONTH); 
		int dia = f.get(Calendar.DAY_OF_MONTH); 
		GregorianCalendar temporal = new GregorianCalendar(anio, mes, dia);
		temporal.add(Calendar.DATE, 1);
		while (esHabil(temporal) == false){
			temporal.add(Calendar.DATE, 1);
		}
		return temporal;
	}  
	
} //Cierra la clase funciones