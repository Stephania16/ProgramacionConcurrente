package productor_consumidor;

public interface Interfaz_Almacen {
	public void almacenar(Producto p);
	public Producto extraer();
}
