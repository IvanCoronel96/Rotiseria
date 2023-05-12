package pb2.rotiseria;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.alumno.pb2.Auto;
import ar.edu.unlam.alumno.pb2.ListaDePedidos;
import ar.edu.unlam.alumno.pb2.Moto;
import ar.edu.unlam.alumno.pb2.Repartidor;

public class TestRotiseria {

	@Test
	public void queSePuedaCrearUnaMotoYCargarPedidos() {
			
		//Preparacion
		Repartidor repartidor;
		Moto moto;
		final String nombre_repartidor = "Juan";
		final String licencia = "A1";
		Cliente cliente;
		final Integer cantidad_de_items_esperada = 3;
				
		//Ejecucion
		repartidor = new Repartidor(nombre_repartidor);
		cliente = new Cliente();
		cliente.agregarItem("pizza de muzza");
		cliente.agregarItem("pizza napolitana");
		cliente.agregarItem("una docena de empanadas");
		moto = new Moto(repartidor, licencia);
		moto.cargarCaja(cliente);
		
		//Verificacion
		assertNotNull(moto);
		assertNotNull(cliente);
		assertEquals(cantidad_de_items_esperada, moto.cantidadDePedidos());
		assertTrue(moto.comenzarViaje());
		
	}
	
	@Test
	public void queSePuedanCargarVariosClientes() {
			
		//Preparacion
		Repartidor repartidor;
		Moto moto;
		final String nombre = "Juan";
		final String licencia = "A1";
		Cliente cliente1, cliente2, cliente3;
		final Integer cantidad_de_items_esperada = 5;
				
		//Ejecucion
		repartidor = new Repartidor(nombre);
		cliente1 = new Cliente();
		cliente2 = new Cliente();
		cliente3 = new Cliente();
		cliente1.agregarItem("pizza de muzza");
		cliente1.agregarItem("pizza napolitana");
		cliente1.agregarItem("una docena de empanadas");
		cliente2.agregarItem("milanesa napolitana");
		cliente3.agregarItem("1kg de helado");
		moto = new Moto(repartidor, licencia);
		moto.cargarCaja(cliente1);
		moto.cargarCaja(cliente2);
		moto.cargarCaja(cliente3);
		
		//Verificacion
		assertNotNull(moto);
		assertNotNull(cliente1);
		assertNotNull(cliente2);
		assertNotNull(cliente3);
		assertEquals(cantidad_de_items_esperada, moto.cantidadDePedidos());
		assertTrue(moto.comenzarViaje());
		
	}
	
}