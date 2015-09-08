package productor_consumidor;

import java.util.concurrent.Semaphore;

public class Productor extends Thread {
	
	Almacen almacen;
	
	Semaphore mutexP;
	
	int time;
	
	Productor(Almacen a, int t) {
		almacen = a;
		mutexP = new Semaphore(1);
		time = t;
	}
	
	public Producto producir() {
		try {
			sleep(time);
		}
		catch(InterruptedException e) {}
		
		Producto p = new Producto(this.getId());
		System.out.println("Produciendo: " + p.codigo);
		return p;
	}
	
	public void run() {
		while(true) {
			try {
				mutexP.acquire();
			}
			catch(Exception e) { }
			
			almacen.almacenar(this.producir());
			
			mutexP.release();
		}
	}
}
