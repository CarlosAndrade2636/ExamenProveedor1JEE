package ec.ups.edu.ExamenProveedor1JEE.ON;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.ups.edu.ExamenProveedor1JEE.DAO.DetalleDAO;
import ec.ups.edu.ExamenProveedor1JEE.DAO.ProductoDAO;
import ec.ups.edu.ExamenProveedor1JEE.modelo.Detalle;
import ec.ups.edu.ExamenProveedor1JEE.modelo.Producto;

@Stateless
public class PedidosON {
 
	@Inject
	private ProductoDAO pdao;
	
	@Inject
	private DetalleDAO detdao;
	
	
	
	public List<Producto> listado(){
		return pdao.listar();
	}
	
	public void actualizar(Producto p) {
	pdao.actualizar(p);
		
	}
	

	public Producto buscar(int codigo) {
		return pdao.buscar(codigo);
	}
	
	
	public void nuevoPedido (Detalle d) {
		for (Detalle item : listadoDetalles()) {
			if(item.getProducto().getCodigo()==d.getProducto().getCodigo()) {
				Detalle det = new Detalle();
				det.setCodigo(d.getCodigo());
				det.setCantidad(d.getCantidad()+item.getCantidad());
				det.setProducto(d.getProducto());
			}else {
				detdao.insertar(d);
			}
		}
	}
	
	public List<Detalle> listadoDetalles(){
		return detdao.listar();
	}

	}

