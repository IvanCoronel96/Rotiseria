package pb2.rotiseria;

public class Moto extends Delivery{
	
	private Integer capacidad = 5;
	private Boolean checkeo = true;
	private Integer contador = 0;

	public Moto(Repartidor repartidor) {
		super(repartidor);
	}

	public void cargarCaja(ListaDePedidos pedidos) {
		contador += pedidos.cantidadDePedidos();
	}
	
	public Boolean checkearCapacidadCaja() {
		if( contador > capacidad ) {
			this.checkeo = false;
		}
		return this.checkeo;
	}

	public Integer cantidadDePedidos() {
		return contador;
	}

}
