package pe.com.implast.model.daoimpl;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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
		//SELECT currval(pg_get_serial_sequence('users', 'id'));
		String sql="INSERT INTO EXTRUSION_PARTE(";
				sql+=""+
				"ID_EXT_PART,NUM_ORD_TRAB,FEC_ORD_TRAB,FEC_ENT_TRAB ,COD_MAQ ,COD_SAP,COD_CLI,"+
				"COD_STA,COD_PROD,ANCHO,ESPESOR,TRATADO,SOLAPA,FUELLE,COD_OPE,COD_SUP,COD_TIP_MANGA,"+
				"GR_LIN ,MATP_MAX ,	MATP_MIN,PROD_MAX,PROD_MIN,	SCRAP_MAX )"+ 
				" VALUES(DEFAULT,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		String pattern="dd/mm/yyyy";		
		try{
		
			SimpleDateFormat simpleDate=new SimpleDateFormat(pattern);
			Date fechaOrdenTrabajo=simpleDate.parse(extrusionParte.getFechaOT());
			Date fechaEntrega=simpleDate.parse(extrusionParte.getFechaEntrega());		
			Object[] args=new Object[]{
			
				extrusionParte.getOrdenTrabajo(),
				fechaOrdenTrabajo,
				fechaEntrega,
				extrusionParte.getCodigoMaquina(),
				extrusionParte.getCodigoSap(),
				extrusionParte.getCodigoCliente(),
				extrusionParte.getStatus(),
				extrusionParte.getCodigoProducto(),
				Double.valueOf(extrusionParte.getAncho()),
				Double.valueOf(extrusionParte.getEspesor()),
				extrusionParte.getTratado(),
				extrusionParte.getSolapa(),
				extrusionParte.getFuelle(),
				extrusionParte.getCodigoOperador(),
				extrusionParte.getCodigoSupervisor(),
				extrusionParte.getCodigoTipoManga(),
				Double.valueOf(extrusionParte.getGrMLin()),
				Double.valueOf(extrusionParte.getMaximoMateriaPrima()),
				Double.valueOf(extrusionParte.getMinimoMateriaPrima()),
				Double.valueOf(extrusionParte.getMaximoProduccion()),
				Double.valueOf(extrusionParte.getMinimoProduccion()),
				Double.valueOf(extrusionParte.getScrap())
			};
			
			jdbcTemplate.update(sql, args);
			
			txManager.commit(status);
		}catch (DataAccessException de){
			txManager.rollback(status);
			LOG.error(de.getMessage(), de);
		}catch (Exception e){
			LOG.error(e.getMessage(),e);
		}
			
	}

	
}
