package pb2.rotiseria;

public class Bicicleta extends Delivery {

	private Integer capacidad = 4;
	private Boolean checkeo = true;
	private Integer contador = 0;
	
	public Bicicleta(Repartidor repartidor) {
		super(repartidor);
	}
	
	public void cargarCaja(Cliente item) {
		contador += item.cantidadDePedidos();
	}
	
	public Boolean comenzarViaje() {
		if( contador > capacidad ) {
			this.checkeo = false;
		}
		return this.checkeo;
	}

	public Integer cantidadDePedidos() {
		return contador;
	}
	
}
