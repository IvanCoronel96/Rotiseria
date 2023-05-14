package pb2.rotiseria;

import java.util.ArrayList;

public class Cuenta {

	private ArrayList<String> items = new ArrayList<String>();
	private Integer total = 0;
	
	public void agregarItem(String item, Integer cantidad) {
		switch(item) {
		case "pizza de muzza":
			total += (1300*cantidad);
			break;
		case "pizza napolitana":
			total += (1500*cantidad);
			break;
		case "milanesa napolitana":
			total += (1800*cantidad);
			break;
		case "milanesa con papas fritas":
			total += (1700*cantidad);
			break;
		case "empanadas":
			total += (250*cantidad);
			break;
		case "canastitas":
			total += (250*cantidad);
			break;
		case "fideos con bolognesa":
			total += (750*cantidad);
			break;
		case "ravioles con estofado":
			total += (750*cantidad);
			break;
		case "guiso de lentejas":
			total += (750*cantidad);
			break;
		case "1kg de helado":
			total += (1200*cantidad);
			break;
		case "1/4 de helado":
			total += (800*cantidad);
			break;
			
		}
		
		if(this.items.size() == 3) {
			this.items.add(item);
			this.items.add("1/4 de helado");
		} else {
			this.items.add(item);
			}
		}
	
	public Integer paga(String metodo_de_pago) {
		switch(metodo_de_pago) {
		case "efectivo":
			total -= (total * 5 / 100); //Se hace descuento del 5%.
			break;
		case "transferencia":
			total += 0;
			break;
		case "tarjeta de credito":
			total += (total * 15 / 100); //Se recarga un 15%.
			break;
		}
		return total;
	}
	
	public Integer cantidadDePedidos() {
		return items.size();
	}

	public ArrayList<String> getItems() {
		return items;
	}
	
}