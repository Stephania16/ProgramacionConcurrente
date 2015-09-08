package productor_consumidor;

import java.util.concurrent.Semaphore;

public class Consumidor extends Thread {
	
	Almacen almacen;
	
	Semaphore mutexC;
	
	int time;
	
	Consumidor(Almacen a, int t) {
		almacen = a;
		mutexC = new Semaphore(1);
		time = t;
	}
	
	public void consumir(Producto p) {
		try {
			sleep(time);
		}
		catch(InterruptedException e) {}
		
		System.out.println("Consumiendo producto: " + p.codigo);
	}
	
	public void run() {
		while(true) {
			try {
				mutexC.acquire();
			}
			catch(Exception e) { }
			
			this.consumir(almacen.extraer());
			
			mutexC.release();
		}
	}
}
