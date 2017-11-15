package com.slinetech.app;

import com.slinetech.exceptions.StackException;
import com.slinetech.stacklist.StackList;

public class App {

	public static void main(String[] args) {
		StackList<String> names = new StackList<String>(5);
		try {
			names.push("Xavier");
			names.push("Alejando");
			names.push("Pauilina");
			names.push("Daniela");
			names.push("Ana");
			//names.push("Kike");
			names.printer();
			String dato = names.search("An");
			if(dato!=null)System.out.println(dato);
			else System.out.println("No se encontro el dato en la pila");
			String datoPeek=names.peek();
			if (datoPeek != null)System.out.println(datoPeek);
			
			names.pop();
			names.pop();
			
			names.printer();
			
			names.push("administracion");
			names.push("ColaLoca");
			
			//names.printer();
			System.out.println("\nImprimiendo pila");
			for(String value:names) {
				System.out.println(value);
			}
			
			names.list();//Impmir pila
			
			names.clean();
			names.printer();
		} catch (StackException e) {
			e.printStackTrace();
		}

	}

}
