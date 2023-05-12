package pb2.rotiseria;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.alumno.pb2.ListaDePedidos;
import ar.edu.unlam.alumno.pb2.Moto;
import ar.edu.unlam.alumno.pb2.Repartidor;

public class TestRotiseria {

	@Test
	public void testQueSePuedaCrearUnaMotoYCargarPedidos() {
			
		//Preparacion
		Repartidor repartidor;
		Moto moto;
		ListaDePedidos cliente;
		
		final Integer cantidad_de_pedidos_esperada = 3;
				
		//Ejecucion
		repartidor = new Repartidor("Carlos");
		cliente = new ListaDePedidos();
		cliente.agregarPedido("pizza de muzza");
		cliente.agregarPedido("pizza napolitana");
		cliente.agregarPedido("una docena de empanadas");
		moto = new Moto(repartidor);
		moto.cargarCaja(cliente);
		
		//Verificacion
		assertNotNull(moto);
		assertNotNull(cliente);
		assertEquals(cantidad_de_pedidos_esperada, moto.cantidadDePedidos());
		assertTrue(moto.checkearCapacidadCaja());
		
	}

}
