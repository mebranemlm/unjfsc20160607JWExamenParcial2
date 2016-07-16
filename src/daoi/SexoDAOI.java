package daoi;

import java.util.List;

import util.Conexion;
import model.Sexo;
import daol.SexoDAOL;

public class SexoDAOI implements SexoDAOL {

	Conexion cn = new Conexion();
	@Override
	public List<Sexo> listar() throws Exception {
		cn.abrir();
		List<Sexo> lista = cn.em.createQuery("select s from Sexo s").getResultList(); 
		return lista;
	}

}
