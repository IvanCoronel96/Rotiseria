package pb2.rotiseria;

public class Delivery {

	private Repartidor repartidor;
	private String licencia;

	public Delivery(Repartidor repartidor) { //Constructor para bicicletas delivery
		this.repartidor = repartidor;
	}
	
	public Delivery(Repartidor repartidor, String licencia) { //Contructor para motos delivery
		this.repartidor = repartidor;
		this.licencia = licencia;
	}

	public Repartidor getRepartidor() {
		return repartidor;
	}

	public void setRepartidor(Repartidor repartidor) {
		this.repartidor = repartidor;
	}

	public String getLicencia() {
		return licencia;
	}

	public void setLicencia(String licencia) {
		this.licencia = licencia;
	}

}