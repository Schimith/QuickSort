package main;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import quicksort.QuickSort;

public class main {

	public static void main(String[] args) {

		//listas para guardar os dados separadamente
		ArrayList<Long> cpf = new ArrayList<Long>();
		ArrayList<String> nome = new ArrayList<String>();
		ArrayList<Integer> agencia = new ArrayList<Integer>();
		ArrayList<Long> conta = new ArrayList<Long>();
		ArrayList<Double> saldo = new ArrayList<Double>();

		//Leitura do arquivo
		try {
			BufferedReader leitor = new BufferedReader(
					new FileReader("arqvs/conta500alea.txt"));

			String linha = leitor.readLine();
			while (linha != null) {

				String guardarDados[] = linha.split(";");

				cpf.add(Long.parseLong(guardarDados[0]));			
				nome.add(guardarDados[1]);
				agencia.add(Integer.parseInt(guardarDados[2]));
				conta.add(Long.parseLong(guardarDados[3]));
				saldo.add(Double.parseDouble(guardarDados[4]));

				linha = leitor.readLine();
			}
			leitor.close();            

		} catch (FileNotFoundException ex) {
			System.out.println(ex);
		} catch (IOException ex) {
			System.out.println(ex);
		}catch (NumberFormatException ex) {
			System.out.println(ex);
		}

		//Ordenacao por cpf
		//Quicksort com vetor
		//Cria um vetor e passar os dados da lista para ele.

		//cpf
		Long[] c = new Long[cpf.size()];
		//nome
		String[] n = new String[cpf.size()];
		//agencia
		Integer[] ag = new Integer[cpf.size()];
		//conta
		Long[] co = new Long[cpf.size()];
		//saldo
		Double[] s = new Double[cpf.size()];
		
		for(int i=0; i<cpf.size(); i++){
			c[i] = cpf.get(i).longValue();
			n[i] = nome.get(i);
			ag[i] = agencia.get(i).intValue();
			co[i] = conta.get(i).longValue();
			s[i] = saldo.get(i).doubleValue();			
		}

		//Inicia a contagem de tempo
		long tempoInicial = System.currentTimeMillis();
		
		//Vetores carregados passar para o quicksort
		//c,0,cpf.size,n,ag,co,s
		quicksort.QuickSort.quick_sort(c, 0, cpf.size(), n, ag, co, s);
		
		//Os vetores c e n estao ordenados pelo valor de c(cpf)
		//Agora é só imprimir
		
		//Imprime no console
		//for(int i=0; i<cpf.size(); i++){
			//System.out.println(c[i] + ";" + n[i] + ";" + ag[i] + ";" + co[i] + ";" + s[i]);
		//}
		
        		
        //Gravacao do novo arquivo
	    try {
	      // Creates a FileWriter
	      FileWriter file = new FileWriter("result/QuickAlea500.txt");

	      // Creates a BufferedWriter
	      BufferedWriter output = new BufferedWriter(file);

	      // Writes the string to the file
		  for(int i=0; i<cpf.size(); i++){
				output.write(c[i] + ";" + n[i] + ";" + ag[i] + ";" + co[i] + ";" + s[i] + "\n");
		  }
		  // Flushes data to the destination      
	      System.out.println("Data is send to the file.");

	      // Closes the writer
	      output.close();
	    }

	    catch (Exception e) {
	      e.getStackTrace();
	    }
	    
	    
		//Finaliza a contagem de tempo
		long tempoFinal = System.currentTimeMillis();
		System.out.println();
		System.out.println("Executado em = " + (tempoFinal - tempoInicial) + " ms");
	}

}
