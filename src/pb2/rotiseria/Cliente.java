package pb2.rotiseria;

import java.util.ArrayList;

public class Cliente {

	private ArrayList<String> items = new ArrayList<String>();
	private String paga_con = "";
	private Boolean recargo = false;
	
	public void agregarItem(String item) {
		if(items.size() == 3) {
			items.add(item);
			items.add("1/4 de helado");
		} else {
			items.add(item);
		}
	}
	
	public Integer cantidadDePedidos() {
		return items.size();
	}

	public Boolean paga(Integer metodo_de_pago) {
		switch(metodo_de_pago) {
		case 1: //Efectivo
			paga_con = "Efectivo";
			break;
		case 2: //Transferencia
			paga_con = "Tranferencia";
			break;
		case 3: //Tarjeta de crédito
			paga_con = "Tarjeta de crédito";
			recargo = true;
			break;
		}
		return recargo;
	}

	public String getPaga_con() {
		return paga_con;
	}

	public ArrayList<String> getItems() {
		return items;
	}
	
}