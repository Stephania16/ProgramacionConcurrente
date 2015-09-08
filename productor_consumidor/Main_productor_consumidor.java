package productor_consumidor;

public class Main_productor_consumidor {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nConsumidores = 3;
		int nProductores = 4;
		int sleepConsumidores = 500;
		int sleepProductores = 200;
		
		int capacidadAlmacen = 10;
		
		Almacen a = new Almacen(capacidadAlmacen);
		
		Consumidor[] c = new Consumidor[nConsumidores];
		Productor[] p = new Productor[nProductores];
		
		for(int i = 0; i < nConsumidores; i++)
			c[i] = new Consumidor(a, sleepConsumidores);
		
		for(int i = 0; i < nProductores; i++)
			p[i] = new Productor(a, sleepProductores);
		
		
		
		for(int i = 0; i < nConsumidores; i++)
			c[i].start();
		
		for(int i = 0; i < nProductores; i++)
			p[i].start();
		
		try {
			for(int i = 0; i < nConsumidores; i++)
				c[i].join();
			
			for(int i = 0; i < nProductores; i++)
				p[i].join();
		}
		catch(InterruptedException e) {
			System.out.println("ERROR");
		}
	}
}
