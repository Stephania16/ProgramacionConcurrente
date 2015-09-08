package rompe_empate_semaforos;

import java.util.concurrent.Semaphore;

public class Contador {
	int n;
	Semaphore mutex;
	
	Contador() {
		this.n = 0;
		this.mutex = new Semaphore(1);
	}
	
	void incrementar() {
		try {
			mutex.acquire();
		}
		catch(InterruptedException e) {}
		
		this.n++;
		
		mutex.release();
	}
	
	void decrementar() {
		try {
			mutex.acquire();
		}
		catch(InterruptedException e) {}
		
		this.n--;
		
		mutex.release();
	}
	
}
