package rompe_empate_semaforos;

public class Decrementador extends Thread {
	
	Contador c;
	
	Decrementador(Contador cont) {
		this.c = cont;
	}
	
	public void run() {
		this.c.decrementar();
	}
	
	
}
