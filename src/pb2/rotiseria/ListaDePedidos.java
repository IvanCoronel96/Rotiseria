package pb2.rotiseria;

import java.util.ArrayList;

public class ListaDePedidos {

	private Boolean extra = false;
	private ArrayList<String> pedidos = new ArrayList<String>();
	
	public void agregarPedido(String pedido) {
		pedidos.add(pedido);
	}
	
	public Integer cantidadDePedidos() {
		if(pedidos.size() > 3) {
			pedidos.add("1/4 de helado");
		}
		return pedidos.size();
	}

}
