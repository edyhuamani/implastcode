package pe.com.implast.model.daoimpl;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.com.implast.model.beans.ProveedorBean;
import pe.com.implast.model.dao.ProveedorDAO;

@Repository
public class ProveedorDAOImpl  implements ProveedorDAO {

	private static final Logger LOG=Logger.getLogger(ProveedorDAOImpl.class);
	
	@Autowired
	SessionFactory sessionFactory;
	
	public void createProveedor(ProveedorBean mprima) {
		try{
			Session session=sessionFactory.getCurrentSession();
			session.beginTransaction();
			session.save(mprima);
			Transaction tx=session.getTransaction();
			tx.commit();
			session.close();
		}catch(Exception e){
			LOG.error(e.getMessage(),e);
		}
	}

	public ProveedorBean retrieveProveedor(int idProveedor) {
			Session session=sessionFactory.getCurrentSession();
			session.beginTransaction();
			ProveedorBean proveedo=(ProveedorBean) session.get(ProveedorBean.class, idProveedor);
			session.close();	
			return proveedo;
	}

	public void updateProveedor(ProveedorBean mprima) {
			Session session=sessionFactory.getCurrentSession();
			session.beginTransaction();
			ProveedorBean proveedo=(ProveedorBean) session.get(ProveedorBean.class, mprima.getIdProveedor());
			proveedo.setDireccion(mprima.getDireccion());
			proveedo.setRazonSocial(mprima.getRazonSocial());
			session.update(proveedo);
			session.getTransaction().commit();
			session.close();
			
	}

	public void deleteProveedor(int idProveedor) {
			Session session=sessionFactory.getCurrentSession();
			session.beginTransaction();
			ProveedorBean proveedor=(ProveedorBean) session.get(ProveedorBean.class, idProveedor);
			session.delete(proveedor);
			session.getTransaction().commit();
			session.close();
	}

}
