package daoi;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import util.Conexion;
import model.Alumno;

import daol.AlumnoDAOL;

public class AlumnoDAOI implements AlumnoDAOL {

	Conexion cn = new Conexion();
	@Override
	public List<Alumno> buscarPorId(Alumno obj) throws Exception {
		cn.abrir();
		Query q = cn.em.createQuery("select a, a.RendAcademico.idRendAcad, a.Aula.idAula, a.Sexo.idSexo from Alumno a where a.idAlumno=:idAlumno");
		q.setParameter("idAlumno", obj.getIdAlumno());
		
		List<Object[]> lista_objetos =q.getResultList();
		List<Alumno> lista = new ArrayList<Alumno>();
		for(Object objs[]: lista_objetos){
			Alumno alumno=(Alumno) objs[0];
			lista.add(alumno);
		}
		
		return lista;
	}

	@Override
	public List<Alumno> buscarPorSexo(Alumno obj) throws Exception {
		cn.abrir();
		Query q = cn.em.createQuery("select a, a.RendAcademico.idRendAcad, a.Aula.idAula, a.Sexo.idSexo from Alumno a where a.Sexo.idSexo=:idSexo");
		q.setParameter("idSexo", obj.getSexo().getIdSexo());
		
		
		List<Object[]> lista_objetos =q.getResultList();
		List<Alumno> lista = new ArrayList<Alumno>();
		for(Object objs[]: lista_objetos){
			Alumno alumno=(Alumno) objs[0];
			lista.add(alumno);
		}
		
		return lista;
	}

	@Override
	public void insertar(Alumno obj) throws Exception {
		cn.abrir();
		try {
			cn.em.getTransaction().begin();
			cn.em.persist(obj);
			cn.em.getTransaction().commit();
		} catch (Exception e) {
			cn.em.getTransaction().rollback();
			System.out.println("Error al insertar:\n " + e.getMessage());
		}
		
	}

	@Override
	public void eliminar(Alumno obj) throws Exception {

		cn.abrir();
		try {
			cn.em.getTransaction().begin();
			Alumno oAlumno=cn.em.find(Alumno.class, obj.getIdAlumno());
			cn.em.remove(oAlumno);
			cn.em.getTransaction().commit();
		} catch (Exception e) {
			cn.em.getTransaction().rollback();
			System.out.println("Error al eliminar:\n " + e.getMessage());
		}
		
	}

}
