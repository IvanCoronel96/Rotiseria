package pb2.rotiseria;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.alumno.pb2.Auto;
import ar.edu.unlam.alumno.pb2.ListaDePedidos;
import ar.edu.unlam.alumno.pb2.Moto;
import ar.edu.unlam.alumno.pb2.Repartidor;

public class TestRotiseria {
	
	@Test
	public void queUnDeliveryNoPuedaSalirARepartirSinItemsCargados() {
			
		//Preparacion
		Repartidor repartidor;
		Moto moto;
		final String nombre_repartidor = "Juan";
		final String licencia = "A1";
		Cliente cliente;
		final Integer cantidad_de_items_esperada = 0; //La caja estaría vacía.
				
		//Ejecucion
		repartidor = new Repartidor(nombre_repartidor);
		cliente = new Cliente();
		cliente.agregarItem("pizza de muzza");
		cliente.agregarItem("pizza napolitana");
		cliente.agregarItem("una docena de empanadas");
		moto = new Moto(repartidor, licencia);
		// moto.cargarCaja(cliente); --> Evito cargar pedidos al delivery.
		
		//Verificacion
		assertNotNull(moto);
		assertNotNull(cliente);
		assertEquals(cantidad_de_items_esperada, moto.cantidadDePedidos());
		assertFalse(moto.comenzarViaje());
		
	}

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
	public void queElRepartidorEnMotoNoPuedaIniciarViajeSiNoTieneLicencia() {
			
		//Preparacion
		Repartidor repartidor;
		Moto moto;
		final String nombre_repartidor = "Juan";
		final String licencia = "";
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
		assertFalse(moto.comenzarViaje()); // --> No tiene licencia, entonces no puede repartir.
		
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
	
	@Test
	public void queSePuedaCrearUnaBiciYNoSePuedanExcederEnCargaDePedidos() {
			
		//Preparacion
		Repartidor repartidor;
		Bicicleta bicicleta;
		final String nombre_repartidor = "Martín";
		Cliente cliente1, cliente2;
		final Integer cantidad_de_items_esperada = 5;
				
		//Ejecucion
		repartidor = new Repartidor(nombre_repartidor);
		cliente1 = new Cliente();
		cliente2 = new Cliente();
		cliente1.agregarItem("pizza de muzza");
		cliente1.agregarItem("pizza napolitana");
		cliente1.agregarItem("una docena de empanadas");
		cliente2.agregarItem("una docena de canastitas");
		cliente2.agregarItem("pizza napolitana");
		bicicleta = new Bicicleta(repartidor);
		bicicleta.cargarCaja(cliente1);
		bicicleta.cargarCaja(cliente2);
		
		//Verificacion
		assertNotNull(bicicleta);
		assertNotNull(cliente1);
		assertNotNull(cliente2);
		assertEquals(cantidad_de_items_esperada, bicicleta.cantidadDePedidos());
		assertFalse(bicicleta.comenzarViaje()); // --> Se sobrepasa la capacidad de carga de la bicicleta y retorna FALSE.
		
	}
	
	@Test
	public void queSeActiveElRecargoCuandoElClientePagueConTarjetaDeCredito() {
		
		//Métodos de pago: 1.Efectivo.
		//				   2.Transferencia.
		//				   3.Tarjeta de crédito.
			
		//Preparacion
		Cliente cliente;
				
		//Ejecucion
		cliente = new Cliente();
		cliente.agregarItem("pizza de muzza");
		cliente.agregarItem("pizza napolitana");
		cliente.agregarItem("una docena de empanadas");
		
		//Verificacion
		assertNotNull(cliente);
		assertFalse(cliente.paga(1)); // --> No se activa el recargo.
		assertFalse(cliente.paga(2)); // --> No se activa el recargo.
		assertTrue(cliente.paga(3)); // --> Se activa el recargo y retorna TRUE.
		
	}
	
	@Test
	public void queSiUnCLienteSuperaLos3PedidosSeLeRegaleUnCuartoDeHelado() {
			
		//Preparacion
		Repartidor repartidor;
		Moto moto;
		final String nombre_repartidor = "Sebastian";
		final String licencia = "A1";
		Cliente cliente;
		final Integer cantidad_de_items_esperada = 5;
				
		//Ejecucion
		repartidor = new Repartidor(nombre_repartidor);
		cliente = new Cliente();
		moto = new Moto(repartidor, licencia);
		cliente.agregarItem("pizza de muzza");
		cliente.agregarItem("pizza napolitana");
		cliente.agregarItem("una docena de empanadas");
		cliente.agregarItem("una docena de canastitas"); // --> Solo se agregaron 4 pedidos, pero al sobrepasar los 3 pedidos se le hace un regalo al cliente.
		moto.cargarCaja(cliente);
		
		//Verificacion
		assertNotNull(moto);
		assertNotNull(cliente);
		assertEquals(cantidad_de_items_esperada, moto.cantidadDePedidos());
		assertTrue(cliente.getItems().contains("1/4 de helado")); // --> Busco si se agrego el regalo al pedido del cliente
		assertTrue(moto.comenzarViaje());
		
	}
	
}