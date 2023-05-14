package pb2.rotiseria;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.alumno.pb2.Auto;
import ar.edu.unlam.alumno.pb2.ListaDePedidos;
import ar.edu.unlam.alumno.pb2.Moto;
import ar.edu.unlam.alumno.pb2.Repartidor;

public class TestRotiseria {

	@Test
	public void queSePuedaCargarUnaMotoConPedidos() {
			
		//Preparacion
		Repartidor repartidor;
		Moto moto;
		final String nombre_repartidor = "Juan";
		final String licencia = "A1";
		Cuenta cliente;
		final Integer cantidad_de_items_esperada = 3;
				
		//Ejecucion
		repartidor = new Repartidor(nombre_repartidor);
		cliente = new Cuenta();
		cliente.agregarItem("pizza de muzza", 1);
		cliente.agregarItem("pizza napolitana", 1);
		cliente.agregarItem("empanadas", 12);
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
		Cuenta cliente1, cliente2, cliente3;
		final Integer cantidad_de_items_esperada = 5;
				
		//Ejecucion
		repartidor = new Repartidor(nombre);
		cliente1 = new Cuenta();
		cliente2 = new Cuenta();
		cliente3 = new Cuenta();
		cliente1.agregarItem("pizza de muzza", 1);
		cliente1.agregarItem("pizza napolitana", 1);
		cliente1.agregarItem("empanadas", 12);
		cliente2.agregarItem("milanesa napolitana", 1);
		cliente3.agregarItem("1kg de helado", 1);
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
	public void queUnDeliveryNoPuedaSalirARepartirSinItemsCargados() {
			
		//Preparacion
		Repartidor repartidor;
		Moto moto;
		final String nombre_repartidor = "Juan";
		final String licencia = "A1";
		Cuenta cliente;
		final Integer cantidad_de_items_esperada = 0; //La caja estaría vacía.
				
		//Ejecucion
		repartidor = new Repartidor(nombre_repartidor);
		cliente = new Cuenta();
		cliente.agregarItem("pizza de muzza", 1);
		cliente.agregarItem("pizza napolitana", 1);
		cliente.agregarItem("empanadas", 12);
		moto = new Moto(repartidor, licencia);
		// moto.cargarCaja(cliente); --> Evito cargar pedidos al delivery.
		
		//Verificacion
		assertNotNull(moto);
		assertNotNull(cliente);
		assertEquals(cantidad_de_items_esperada, moto.cantidadDePedidos());
		assertFalse(moto.comenzarViaje());
		
	}
	
	@Test
	public void queElRepartidorEnMotoNoPuedaIniciarViajeSiNoTieneLicencia() {
			
		//Preparacion
		Repartidor repartidor;
		Moto moto;
		final String nombre_repartidor = "Juan";
		final String licencia = "";
		Cuenta cliente;
		final Integer cantidad_de_items_esperada = 3;
				
		//Ejecucion
		repartidor = new Repartidor(nombre_repartidor);
		cliente = new Cuenta();
		cliente.agregarItem("pizza de muzza", 1);
		cliente.agregarItem("pizza napolitana", 1);
		cliente.agregarItem("empanadas", 1);
		moto = new Moto(repartidor, licencia);
		moto.cargarCaja(cliente);
		
		//Verificacion
		assertNotNull(moto);
		assertNotNull(cliente);
		assertEquals(cantidad_de_items_esperada, moto.cantidadDePedidos());
		assertFalse(moto.comenzarViaje()); // --> No tiene licencia, entonces no puede repartir.
		
	}
	
	@Test
	public void queSePuedaCrearUnaBiciYNoSePuedanExcederEnCargaDePedidos() {
			
		//Preparacion
		Repartidor repartidor;
		Bicicleta bicicleta;
		final String nombre_repartidor = "Martín";
		Cuenta cliente1, cliente2;
		final Integer cantidad_de_items_esperada = 5;
				
		//Ejecucion
		repartidor = new Repartidor(nombre_repartidor);
		cliente1 = new Cuenta();
		cliente2 = new Cuenta();
		cliente1.agregarItem("pizza de muzza", 1);
		cliente1.agregarItem("pizza napolitana", 1);
		cliente1.agregarItem("empanadas", 12);
		cliente2.agregarItem("canastitas", 6);
		cliente2.agregarItem("pizza napolitana", 1);
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
	public void queFuncionenTodosLosMetodosDePago() {
		
		//Métodos de pago: Efectivo.
		//				   Transferencia.
		//				   Tarjeta de crédito.
			
		//Preparacion
		Cuenta cliente1, cliente2, cliente3;
		final Integer total_esperado1 = 5510;
		final Integer total_esperado2 = 4100;
		final Integer total_esperado3 = 5175;
				
		//Ejecucion
		cliente1 = new Cuenta();
		cliente2 = new Cuenta();
		cliente3 = new Cuenta();
		
		cliente1.agregarItem("pizza de muzza", 1);   //$1300 total: $5800
		cliente1.agregarItem("pizza napolitana", 1); //$1500
		cliente1.agregarItem("empanadas", 12);       //$3000
		
		cliente2.agregarItem("pizza de muzza", 2);   //$2600 total: $4100
		cliente2.agregarItem("canastitas", 6);       //$1500
		
		cliente3.agregarItem("pizza napolitana", 2); //$3000 total: $4500
		cliente3.agregarItem("empanadas", 6);        //$1500
		
		//Verificacion
		assertNotNull(cliente1);
		assertNotNull(cliente2);
		assertNotNull(cliente3);
		assertEquals(total_esperado1, cliente1.paga("efectivo"));           // --> Tiene descuento del 5%.
		assertEquals(total_esperado2, cliente2.paga("transferencia"));      // --> No tiene recargo.
		assertEquals(total_esperado3, cliente3.paga("tarjeta de credito")); // --> Tiene recargo del 15%.
		
	}
	
	@Test
	public void queSiUnCLienteSuperaLos3PedidosSeLeRegaleUnCuartoDeHelado() {
			
		//Preparacion
		Repartidor repartidor;
		Moto moto;
		final String nombre_repartidor = "Sebastian";
		final String licencia = "A1";
		Cuenta cliente;
		final Integer cantidad_de_items_esperada = 5;
				
		//Ejecucion
		repartidor = new Repartidor(nombre_repartidor);
		cliente = new Cuenta();
		moto = new Moto(repartidor, licencia);
		cliente.agregarItem("pizza de muzza", 1);
		cliente.agregarItem("pizza napolitana", 1);
		cliente.agregarItem("empanadas", 12);
		cliente.agregarItem("canastitas", 6); // --> Solo se agregaron 4 pedidos, pero al sobrepasar los 3 pedidos se le hace un regalo al cliente.
		moto.cargarCaja(cliente);
		
		//Verificacion
		assertNotNull(moto);
		assertNotNull(cliente);
		assertEquals(cantidad_de_items_esperada, moto.cantidadDePedidos());
		assertTrue(cliente.getItems().contains("1/4 de helado")); // --> Busco si se agrego el regalo al pedido del cliente
		assertTrue(moto.comenzarViaje());
		
	}
	
}