package quicksort;

public class QuickSort {
	
	public static void quick_sort(Long[] c, int ini, int fim, String[] n, Integer[] ag, Long[] co, Double[] s) {	
		int meio;

		if (ini < fim) {
			meio = partition(c, ini, fim, n, ag, co, s);
			quick_sort(c, ini, meio, n, ag, co, s);
			quick_sort(c, meio + 1, fim, n, ag, co, s);
		}
	}

	public static int partition(Long[] c, long ini, long fim, String[] n, Integer[] ag, Long[] co, Double[] s) {

		int pivoAgencia;
		long pivoCpf,pivoConta, topo, i;
		Double pivoSaldo;
		String pivoNome;
		pivoCpf = c[(int) ini];
		pivoNome = n[(int) ini];
		pivoAgencia = ag[(int) ini];
		pivoConta = co[(int) ini];
		pivoSaldo = s[(int) ini];
		
		topo = ini;

		for (i = ini + 1; i < fim; i++) {
			if (c[(int) i] < pivoCpf) {
				//cpf
				c[(int) topo] = c[(int) i];
				//nome
				n[(int) topo] = n[(int) i];
				//agencia
				ag[(int) topo] = ag[(int) i];		
				//conta
				co[(int) topo] = co[(int) i];
				//saldo
				s[(int) topo] = s[(int) i];
				
				//cpf
				c[(int) i] = c[(int) (topo + 1)];
				//nome
				n[(int) i] = n[(int) (topo + 1)];
				//agencia
				ag[(int) i] = ag[(int) (topo + 1)];
				//conta
				co[(int) i] = co[(int) (topo + 1)];
				//saldo
				s[(int) i] = s[(int) (topo + 1)];
				
				//incrementa
				topo++;
			}
		}

		
		c[(int) topo] = pivoCpf;
		n[(int) topo] = pivoNome;
		ag[(int) topo] = pivoAgencia;
		co[(int) topo] = pivoConta;
		s[(int) topo] = pivoSaldo;
		
		return (int) topo;
	}
	

}
