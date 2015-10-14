package pe.com.implast.utils;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OperadoresUtil {
	public static Integer obtenerCociente(Integer dividendo, Integer divisor){
		if((dividendo%divisor)==0){
			return dividendo/divisor;
		}else{
			return dividendo/divisor+1;
		}
		
	}
	
	public static Date StringToDate(String fecha){
		
		DateFormat horaFormato = new SimpleDateFormat("HH:mm:ss");
		Date horaActual = new Date();
		
		fecha = fecha + " " + horaFormato.format(horaActual);
		
		DateFormat fechaFormato; 
		Date dateActual = null; 
		fechaFormato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		if(fecha==null || fecha.equals("")){
			return null;
		}else{
			try {
				dateActual = fechaFormato.parse(fecha);
			} catch (ParseException e) {
				//e.printStackTrace();
			}
			
			return dateActual;
		}
		
		
	}
public static Date StringToDateSinHora(String fecha){
		
		
		DateFormat fechaFormato; 
		Date dateActual = null; 
		fechaFormato = new SimpleDateFormat("dd/MM/yyyy");
		
		if(fecha==null || fecha.equals("")){
			return null;
		}else{
			try {
				dateActual = fechaFormato.parse(fecha);
			} catch (ParseException e) {
				//e.printStackTrace();
			}
			
			return dateActual;
		}
		
		
	}
	
	public static Double StringToDouble(String valor){
		
		
		if(valor.equals("")){
			return 0.0;
		}
		else{
			valor=valor.replace(",","");
			return Double.parseDouble(valor);
		}
	}
	
	public static Integer StringToInteger(String valor){
		
		if(valor.equals("")){
			return 0;
		}
		else{
			return Integer.parseInt(valor);
		}
	}
	
	public static boolean IntegerToBoolean(Integer valor){
		
		if(valor==1){
			return true;
		}
		else{
			return false;
		}
		
	}
	
public static String IntegerToResponse(Integer valor){
		
		if(valor==1){
			return "Si";
		}
		else{
			return "No";
		}
		
	}

public static int diferenciasDeFechas(Date fechaInicial, Date fechaFinal) {
	DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
	String fechaInicioString = df.format(fechaInicial);
	try {
	fechaInicial = df.parse(fechaInicioString);
	} catch (ParseException ex) {
	}
	String fechaFinalString = df.format(fechaFinal);
	 try {
	fechaFinal = df.parse(fechaFinalString);
	} catch (ParseException ex) {
	}
	 long fechaInicialMs = fechaInicial.getTime();
	 long fechaFinalMs = fechaFinal.getTime();
	long diferencia = fechaFinalMs - fechaInicialMs;
	double dias = Math.floor(diferencia / (1000 * 60 * 60 * 24));
	return ((int) dias);
}

public static String obtenerRutaTemporales(){
	
	File currentDirectory = new File(new File(".").getAbsolutePath());
	
	String ruta = currentDirectory.getAbsolutePath();
    int indice = ruta.indexOf("bin");
    ruta = ruta.substring(0,indice-1) + "\\standalone\\tmp\\";
    
    System.out.println("Ruta temporales: " + ruta);
    
	return ruta;
}

public static String obtenerRutaTemporal(){
	File currentDirectory = new File(new File(".").getAbsolutePath());
	
	String ruta = currentDirectory.getPath();
	int indice = ruta.indexOf("bin");
	ruta = ruta.substring(0,indice-1);
	ruta=ruta+obtenerSeparadorCarpetas()+"standalone"+obtenerSeparadorCarpetas()+"tmp"+obtenerSeparadorCarpetas();
    
    System.out.println("Ruta temporales: " + ruta);
    
	return ruta;
}
	

public static boolean isWindows() {
	String OS = System.getProperty("os.name").toLowerCase();
	return (OS.indexOf("win") >= 0);

}
public static String obtenerSeparadorCarpetas(){
	if(isWindows()){
		return "\\";
	}else{
		return "/";
	}
}

public static String obtenerCadenaEspacios(Integer tamanio){
	
	StringBuilder cadena = new StringBuilder();
	cadena.append(ConstantesUtil.VACIO);
	for (int i = 0; i < tamanio; i++) {
		cadena.append(ConstantesUtil.ESPACIO);
	}
    
	return cadena.toString();
}

public static String obtenerCadenaCeros(Integer tamanio){
	
	StringBuilder cadena = new StringBuilder();
	cadena.append(ConstantesUtil.VACIO);
	for (int i = 0; i < tamanio; i++) {
		cadena.append(ConstantesUtil.ESPACIO);
	}
    
	return cadena.toString();
}

public static String obtenerCadenaCaracterRepetido(String Caracter,Integer tamanio){
	
	StringBuilder cadena = new StringBuilder();
	cadena.append(ConstantesUtil.VACIO);
	for (int i = 0; i < tamanio; i++) {
		cadena.append(Caracter);
	}
    
	return cadena.toString();
}

public static boolean esNuloOVacio(String valor1,String valor2,String valor3,String valor4,String valor5,String valor6,String valor7) {
	
	boolean rsta = true;	
	if (valor1 != null && !valor1.equals("")) 
		rsta= false;
	if (valor2 != null && !valor2.equals("")) 
		rsta= false;
	if (valor3 != null && !valor3.equals("")) 
		rsta= false;
	if (valor4 != null && !valor4.equals("")) 
		rsta= false;
	if (valor5 != null && !valor5.equals("")) 
		rsta= false;
	if (valor6 != null && !valor6.equals("")) 
		rsta= false;
	if (valor7 != null && !valor7.equals("")) 
		rsta= false;	
	return rsta;
}

}
