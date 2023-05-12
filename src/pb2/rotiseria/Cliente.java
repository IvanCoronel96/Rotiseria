package pb2.rotiseria;

import java.util.ArrayList;

public class Cliente {

	private ArrayList<String> items = new ArrayList<String>();
	
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

}