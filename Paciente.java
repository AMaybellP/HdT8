import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Paciente implements Comparable<Paciente>{
	
	private String nombre;
	private String sintoma;
	private char codigo;
	
	public Paciente()
	{
		nuevoPaciente();
	}
	
	public Paciente(String n, String s, char c)
	{
		nombre= n;
		sintoma= s;
		codigo= c;
	}

	public void nuevoPaciente(){
        String lista= "";
        ArrayList<Paciente> pacientes= new ArrayList<Paciente>();
        try {
	         File file = new File("Pacientes.txt");
	         Scanner scanner = new Scanner(file);
	         while (scanner.hasNextLine()) {
	        	lista=lista+"/"+scanner.nextLine();
	         }
	         scanner.close();
	       } catch (FileNotFoundException e) {
	         e.printStackTrace();
	       }
        
        String n="";
        String s="";
        char c;
        Paciente paciente;
        System.out.println(lista);
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
						paciente= new Paciente(n,s,c);
						System.out.println(paciente.toString());
						pacientes.add(paciente);
						System.out.println("hashCode: "+paciente.hashCode());
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
				if (i==','&& r==0)
				{
					r=1;
				}
			}
		}
	}
	
	public String toString()
	{
		return "PACIENTE:\nNombre: "+nombre+"\n"+"Sintoma: "+sintoma+"\n"+"Codigo: "+ codigo;
	}

	public int hashCode()
	{
		return (70 - codigo);
		
	}
	@Override
	public int compareTo(Paciente a) {
		// TODO Auto-generated method stub
		return Integer.compare(this.hashCode(), a.hashCode());
	}
}
