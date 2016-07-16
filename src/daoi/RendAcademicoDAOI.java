package daoi;

import java.util.List;

import util.Conexion;
import model.RendAcademico;
import daol.RendAcademicoDAOL;

public class RendAcademicoDAOI implements RendAcademicoDAOL {

	Conexion cn = new Conexion();
	@Override
	public List<RendAcademico> listar() throws Exception {
		cn.abrir();
		List<RendAcademico> lista = cn.em.createQuery("select ra from RendAcademico ra").getResultList(); 
		return lista;
	}

}
