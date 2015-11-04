package pe.com.implast.model.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
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
			
			SimpleJdbcInsert simpleJdbc=new SimpleJdbcInsert(jdbcTemplate.getDataSource()).withTableName("cliente").usingGeneratedKeyColumns("id_cli"); 
			Map<String,Object> params=new HashMap<String, Object>();
			params.put("COD_CLI", cliente.getCodigoCliente());
			params.put("RUC_CLI", cliente.getRuc());
			params.put("TEL_CLI", cliente.getTelefono());
			params.put("RAZ_SOC_CLI", cliente.getRazonSocial());
			params.put("NOM_CLI", cliente.getNombres());
			params.put("APE_CLI", cliente.getApellidos());
			simpleJdbc.compile();
			simpleJdbc.execute(params);
			
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
		String sql="Select cod_cli,raz_soc_cli,ruc_cli from Cliente";
		try{
				clientes=jdbcTemplate.query(sql, new RowMapper<ClienteBean>(){
				public ClienteBean mapRow(ResultSet result, int rownum)
						throws SQLException {
						ClienteBean cliente=new ClienteBean();
						cliente.setCodigoCliente(result.getString("COD_CLI"));
						cliente.setRazonSocial(result.getString("RAZ_SOC_CLI"));
						cliente.setRuc(result.getString("RUC_CLI"));
					return cliente;
				}
			});
		}catch (Exception e){
			LOG.error(e.getMessage(), e);
		}
		return clientes;
	}

	public List<ClienteBean> listarClientesPaginado(Integer pagina,
			Integer registros) {
		List<ClienteBean> clientes=null;
		String sql="Select cod_cli,raz_soc_cli,ruc_cli from Cliente LIMIT 10 OFFSET ?";

		Integer inicioPagina=null;
		pagina=pagina-1;
		if (pagina==0){
			inicioPagina=0;
		}else {
			inicioPagina=pagina*registros;
		}
		Object[] params=new Object[]{inicioPagina};
		
		try{
			clientes=jdbcTemplate.query(sql, params, new RowMapper<ClienteBean>(){
				public ClienteBean mapRow(ResultSet result, int rownum)
						throws SQLException {
					ClienteBean cliente=new ClienteBean();
					cliente.setCodigoCliente(result.getString("COD_CLI"));
					cliente.setRazonSocial(result.getString("RAZ_SOC_CLI"));
					cliente.setRuc(result.getString("RUC_CLI"));
					return cliente;
				}
			});	
		}catch (Exception e){
			LOG.error(e.getMessage(), e);
		}
		return clientes;
	}

	public Integer totalClientes() {
		Integer response=null;
		
		String sql="SELECT COUNT(*) FROM CLIENTE ";
		try{
			response=jdbcTemplate.queryForObject(sql, Integer.class);
		}catch (Exception e){
			LOG.error(e.getMessage(), e);
		}
		return response;
	}
	
	
	
	
}
