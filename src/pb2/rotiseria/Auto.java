package pb2.rotiseria;

public class Auto extends Delivery{
	
	private Integer capacidad = 10;
	private Boolean checkeo = true;
	private Integer contador = 0;

	public Auto(Repartidor repartidor, String licencia) {
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