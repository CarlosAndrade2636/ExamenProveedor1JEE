package ec.ups.edu.ExamenProveedor1JEE.servicios;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import ec.ups.edu.ExamenProveedor1JEE.ON.PedidosON;
import ec.ups.edu.ExamenProveedor1JEE.modelo.Detalle;
import ec.ups.edu.ExamenProveedor1JEE.modelo.Producto;

@Path ("/productos")
public class Productos {
	
	@Inject
	private PedidosON proON;
	
	@GET
	@Path("/productos")
	@Produces("aplication/json")
	public List<Producto> listaProductos()  {

		List<Producto> listado = new ArrayList<Producto>();

		listado = proON.listado();
		return listado;
	}
	
	@POST
	@Path("/detalle")
	@Produces("application/json")
	@Consumes("application/json")
	public String guardarPedido(Detalle detalle) {
		System.out.println(detalle.toString());
		String res = "";
		try {
			proON.nuevoPedido(detalle);
			res = "Exito";
		} catch (Exception e) {
			res = "Error";
		}
		return res;
	}
	
	@POST
	@Path("/actualizarStock")
	@Produces("application/json")
	@Consumes("application/json")
	public String actualizar(Producto producto) {
		System.out.println(producto.toString());
		String res = "";
		try {
			proON.actualizar(producto);
			res = "Exito";
		} catch (Exception e) {
			res = "Error";
		}
		return res;
	}
}
