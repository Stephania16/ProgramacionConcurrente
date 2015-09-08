package rompe_empate_semaforos;

public class Main_rompe_empate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int M = 1000;
		
		Incrementador[] inc = new Incrementador[M];
		Decrementador[] dec = new Decrementador[M];
		
		Contador c = new Contador();
		
		for(int i = 0; i < M; i++) {
			inc[i] = new Incrementador(c);
			dec[i] = new Decrementador(c);
		}
		
		for(int i = 0; i < M; i++) {
			inc[i].start();
			dec[i].start();
		}
		
		try {
			for(int i = 0; i < M; i++) {
				inc[i].join();
				dec[i].join();
			}
			
			System.out.println("Valor del contador: " + c.n);
		}
		catch(InterruptedException e) {
			System.out.println("ERROR");
		}
	}

}
