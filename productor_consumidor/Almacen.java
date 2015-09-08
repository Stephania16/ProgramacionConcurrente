package productor_consumidor;

import java.util.concurrent.Semaphore;

public class Almacen implements Interfaz_Almacen{

	int capacidad;
	Producto[] buffer;
	int inicio;
	int fin;
	
	Semaphore empty;
	Semaphore full;
	
	Almacen(int cap) {
		capacidad = cap;
		buffer = new Producto[capacidad];
		inicio = 0;
		fin = 0;
		
		empty = new Semaphore(capacidad);
		full = new Semaphore(0);
	}
	
	@Override
	public void almacenar(Producto p) {
		// TODO Auto-generated method stub
		try {
			empty.acquire();
		}
		catch(Exception e) { }
		
		buffer[fin] = p;
		fin = (fin + 1) % capacidad;
		
		full.release();
	}

	@Override
	public Producto extraer() {
		// TODO Auto-generated method stub
		try {
			full.acquire();
		}
		catch(Exception e) { }
		
		Producto p = buffer[inicio];
		inicio = (inicio +1) % capacidad;
		
		empty.release();
		
		return p;
	}

}
