package pb2.rotiseria;

public class Moto extends Delivery{
	
	private Integer capacidad = 8;
	private Boolean checkeo = true;
	private Integer contador = 0;

	public Moto(Repartidor repartidor, String licencia) {
		super(repartidor, licencia);
	}

	public void cargarCaja(Cuenta item) {
		contador += item.cantidadDePedidos();
	}
	
	public Boolean comenzarViaje() {
		if( contador > capacidad || super.getLicencia() == "" || contador == 0) {
			this.checkeo = false;
		}
		return this.checkeo;
	}

	public Integer cantidadDePedidos() {
		return contador;
	}

}