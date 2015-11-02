package pe.com.implast.model.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import pe.com.implast.model.beans.ClienteBean;
import pe.com.implast.model.dao.ClienteDAO;

@Repository
public class ClienteDAOImpl implements ClienteDAO{

	private static final Logger LOG=Logger.getLogger(ClienteDAOImpl.class);
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void crearCliente(ClienteBean cliente) {
		try{
			
		}catch(Exception e){
			LOG.error(e);
		}
	}

	public ClienteBean obtenerCliente(int idCliente) {
		try{
			
		} catch(Exception e){
			LOG.error(e);
		}
		return null;
	}

	public void actualizarCliente(ClienteBean cliente) {
		try{
			
		}catch (Exception e){
			LOG.error(e);
		}
	}

	public void eliminarCliente(int idCliente) {
		try{
			
		} catch (Exception e){
			LOG.error(e);
		}
	}

	public List<ClienteBean> listarClientes() {
		List<ClienteBean> clientes=null;
		String sql="Select * from Clientes";
		try{
				clientes=jdbcTemplate.query(sql, new RowMapper<ClienteBean>(){
				public ClienteBean mapRow(ResultSet result, int rownum)
						throws SQLException {
						ClienteBean cliente=new ClienteBean();
						cliente.setCodigoCliente(result.getString(""));
						cliente.setRazonSocial(result.getString(""));
					return cliente;
				}
			});
		}catch (Exception e){
			LOG.error(e.getMessage(), e);
		}
		return clientes;
	}
	
	
	
	
}
