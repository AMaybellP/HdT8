/**
	*Paciente, clase creadora de pacientes 
	*@version: 3.0
	*@author: Andrea Maybell Pena 15127 // Steven Rubio, 15044 
	*@since 2016-09-29
	*/

	
import java.io.File;
	import java.io.FileNotFoundException;
	import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;
	import java.util.Vector;
	
public class Paciente2 implements Comparable<Paciente2>{

		
		/***Atributos***/
		private String nombre;
		private String sintoma;
		private char codigo;
		
		/**
	 	 * Constructor sin parametros, crea objetos tipo paciente apartir de un .txt
	 	 * @param ninguno
	 	 * @return void
	 	 */
		public Paciente2()
		{
			nuevoPaciente2();
		}
		
		/**
	 	 * Constructor con parametros, crea pacientes a partir de los datos dados
	 	 * @param String n: nombre paciente
	 	 * 		  String s: sintoma paciente
	 	 * 		  char c: codigo de emergencia
	 	 * @return objeto tipo Paciente
	 	 */
		public Paciente2(String n, String s, char c)
		{
			nombre= n;
			sintoma= s;
			codigo= c;
		}

		/**
	 	 * A�ade Pacientes a un PriorityQueue
	 	 * @param ninguno
	 	 * @return void
	 	 */
		public void nuevoPaciente2(){
	        String lista= "";
	        PriorityQueue<Paciente2> pacientes= new PriorityQueue<Paciente2>();
	        
	        //lectura del .txt
	        try {
		         File file = new File("Pacientes.txt");
		         Scanner scanner = new Scanner(file);
		         while (scanner.hasNextLine()) {
		        	lista=lista+"/"+scanner.nextLine();//se guarda en un String
		         }
		         scanner.close();
		       } 
	        catch (FileNotFoundException e) {
		         e.printStackTrace();
		       }
	        
	        String n="";
	        String s="";
	        char c;
	        Paciente2 paciente;
	        // String a cadena de cadena de caracteres
	        char[] cadena= lista.toCharArray();
			int r=0;
			for (char i: cadena)
			{
				if(i=='/')
				{
					n="";
					s="";
					r=0;
				}
				if(i!='/')
				{
					if (i!=','&& r==2)
					{
						if(i!=' ')
						{
							c=i;
							//se crea el nuevo paciente
							paciente= new Paciente2(n,s,c);
							//se a�ade el paciente al vector
							pacientes.add(paciente);
						}
					}
					if(i!=','&& r==1)
					{
						s=s+i;
					}
					if (i==','&& r==1)
					{
						r=2;
					}
					if (i!=','&& r==0)
					{
						n=n+i;
					}
					if (i==','&& r==0){
						r=1;
						}
					}
				}
			int j;
			Object x[] = pacientes.toArray();
			for(j = 0; j< pacientes.size(); j++){
			System.out.println(x[pacientes.size()-1-j]);
			
			}
		}
			
		
		/**
	 	 * toString
	 	 * @param ninguno
	 	 * @return String con datos del paciente
	 	 */
		public String toString()
		{
			return nombre+","+sintoma+", "+codigo;
		}

		/**
	 	 * hashCode, codigo para comparar a los pacientes
	 	 * @param ninguno
	 	 * @return hashCode del paciente
	 	 */
		public int hashCode()
		{
			return (70 - codigo);	
		}
		
		/**
	 	 * compareTo
	 	 * @param Objeto tipo paciente con el que se comparar�
	 	 * @return -1: menor
	 	 * 		    0: igual
	 	 * 		    1: mayor
	 	 */
		public int compareTo(Paciente2 a) {
			// TODO Auto-generated method stub
			return Integer.compare(this.hashCode(), a.hashCode());
		}
	}

