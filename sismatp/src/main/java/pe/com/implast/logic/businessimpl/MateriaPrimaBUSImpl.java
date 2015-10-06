package pe.com.implast.logic.businessimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.implast.logic.business.MateriaPrimaBUS;
import pe.com.implast.model.beans.MateriaPrimaBean;
import pe.com.implast.model.dao.MateriaPrimaDAO;

@Service
public class MateriaPrimaBUSImpl implements MateriaPrimaBUS {

	
	
	@Autowired
	MateriaPrimaDAO materiaDAO;
	
	public void crearMateriaPrima(MateriaPrimaBean materiaPrima) {
		try{
			
		}catch(Exception e){
			
		}
		
	}

	public void obtenerMateriaPrima(int idMateriaPrima) {
		try{
			
		}catch (Exception e){
		
		}
		
	}

	public void actualizarMateriaPrima(MateriaPrimaBean materiaPrima) {
		try{
			
		} catch (Exception e){
			
		}
		
	}

	public void eliminarMateriaPrima(int idMateriaPrima) {
		try{
			
		}catch(Exception e){
			
		}
		
	}

}
