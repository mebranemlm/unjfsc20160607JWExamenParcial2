package daol;

import java.util.List;

import model.Alumno;

public interface AlumnoDAOL {

	public abstract List<Alumno> buscarPorId(Alumno obj) throws Exception;
	public abstract List<Alumno> buscarPorSexo(Alumno obj) throws Exception;
	public abstract void insertar (Alumno obj) throws Exception;
	public abstract void eliminar (Alumno obj) throws Exception;
}
