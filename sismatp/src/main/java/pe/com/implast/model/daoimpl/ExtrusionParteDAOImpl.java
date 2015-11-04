package pe.com.implast.model.daoimpl;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import pe.com.implast.model.beans.ParteExtrusionBean;
import pe.com.implast.model.dao.ExtrusionParteDAO;

@Repository
public class ExtrusionParteDAOImpl implements ExtrusionParteDAO{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	PlatformTransactionManager txManager;
	
	private static final Logger LOG=Logger.getLogger(ExtrusionParteDAOImpl.class);
	
	public void registraSalidaExtrusion(ParteExtrusionBean extrusionParte){

		TransactionDefinition def=new DefaultTransactionDefinition();
		TransactionStatus status=txManager.getTransaction(def);
		String sql="insert into ";
		try{
			
			//jdbcTemplate.update(sql, args)
			
			
			
			txManager.commit(status);
		}catch (Exception e){
			txManager.rollback(status);
			LOG.error(e.getMessage(), e);
		}
			
	}

	
}
