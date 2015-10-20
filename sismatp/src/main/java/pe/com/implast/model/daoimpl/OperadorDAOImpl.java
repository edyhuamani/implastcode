package pe.com.implast.model.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import pe.com.implast.model.beans.OperadorBean;
import pe.com.implast.model.dao.OperadorDAO;

@Repository
public class OperadorDAOImpl implements OperadorDAO{
	
	private static final Logger LOG=Logger.getLogger(OperadorDAOImpl.class);
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	public void createOperador(OperadorBean operador) {
		try{
			String sql="insert into operador(idOperador,codigoOperador,nombreOperador) values (?,?,?)";
			jdbcTemplate.update(sql,operador.getIdOperador(),operador.getCodigoOperador(),operador.getNombreOperador());
		}catch (Exception e){
			LOG.error(e.getMessage(), e);
		}
		
	}

	public OperadorBean retrieveOperador(int idOperador) {
		OperadorBean operador=null;
		try{
//		String sql="";
//		=jdbcTemplate.queryForObject(sql,{""},new RowMapper<T>() {
//
//			public T mapRow(ResultSet arg0, int arg1) throws SQLException {
//				// TODO Auto-generated method stub
//				return null;
//			}
//		});
		}catch(Exception e){
			LOG.error(e.getMessage(), e);
		}
		return operador;
	}

	public void updateOperador(OperadorBean mprima) {
		// TODO Auto-generated method stub
		
	}

	public void deleteOperador(int idOperador) {
		// TODO Auto-generated method stub
		
	}

	public List<OperadorBean> obtenerListaOperador() {
		List<OperadorBean> operadores=null;
		try{
			String sql="select * from operador";
			operadores=jdbcTemplate.query(sql, new RowMapper<OperadorBean>(){

				public OperadorBean mapRow(ResultSet rs, int rownum)
						throws SQLException {
					OperadorBean operador=new OperadorBean();
					operador.setCodigoOperador(rs.getString("codigoOperador"));
					operador.setNombreOperador(rs.getString("nombreOperador"));
					return operador;
				}});
		}catch (DataAccessException da){
			LOG.error(da.getMessage(),da);
		}catch (Exception e){
			LOG.error(e.getMessage(), e);
		}
		return operadores;
	}
	
	
	public List<OperadorBean> obtenerListaOperadorPaginado(Integer pagina,Integer registros){
		List<OperadorBean> operadores=new ArrayList<OperadorBean>();
		Integer inicioPagina=0;
		if (pagina.intValue()==1){
			pagina=pagina-1;
			inicioPagina=pagina;
		}else{
			pagina=pagina-1;
			inicioPagina=pagina*registros;
		}
		String sql="SELECT * FROM OPERADOR LIMIT 10 OFFSET ?";
		try{
			operadores=jdbcTemplate.query(sql, new Object[] {inicioPagina}, new RowMapper<OperadorBean>() {
				public OperadorBean mapRow(ResultSet result, int rownum) throws SQLException {
					OperadorBean operador=new OperadorBean();
					operador.setCodigoOperador(result.getString("codigoOperador"));
					operador.setNombreOperador(result.getString("nombreOperador"));
					return operador;
				}
			});
		}catch (Exception  e){
			LOG.error(e.getMessage(),e);
		}
		return operadores; 
	}

	public Integer totalOperadores() {
		Integer totalOperadores=null;
		try{
			String sql="Select count(*) from Operador";
			totalOperadores=jdbcTemplate.queryForObject(sql, Integer.class);
		}catch (DataAccessException de){
			LOG.error(de.getMessage(), de);
		}catch (Exception e){
			LOG.error(e.getMessage(), e);
		}
		return totalOperadores;
	}

}
