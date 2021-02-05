package ec.ups.edu.ExamenProveedor1JEE.DAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.ups.edu.ExamenProveedor1JEE.modelo.Producto;


@Stateless
public class ProductoDAO {

	
	@PersistenceContext 
	private EntityManager em;
	public void insertar (Producto p) {
		em.persist(p);
	}
	
	public Producto buscar (int codigo) {
		Producto p = em.find(Producto.class, codigo);
		return p;
	}
	
	public List<Producto> listar() {
		String jpql = "SELECT p FROM Producto p";
		Query q = em.createQuery(jpql, Producto.class);
		return q.getResultList();
	}
	
	public void actualizar (Producto p) {
		em.merge(p);
	}
	
}
