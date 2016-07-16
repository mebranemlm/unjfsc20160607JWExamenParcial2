package daoi;

import java.util.List;

import util.Conexion;
import model.Aula;
import daol.AulaDAOL;

public class AulaDAOI implements AulaDAOL{

	Conexion cn = new Conexion();
	@Override
	public List<Aula> listar() throws Exception {
		cn.abrir();
		List<Aula> lista = cn.em.createQuery("select a from Aula a").getResultList(); 
		return lista;
	}

}
