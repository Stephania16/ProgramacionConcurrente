package rompe_empate_semaforos;

public class Incrementador extends Thread {
	
	Contador c;
	
	Incrementador(Contador cont) {
		this.c = cont;
	}
	
	public void run() {
		this.c.incrementar();
	}
}
