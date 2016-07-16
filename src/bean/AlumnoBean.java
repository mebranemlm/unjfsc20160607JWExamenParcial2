package bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.validator.ValidatorException;

import daoi.AlumnoDAOI;
import daoi.AulaDAOI;
import daoi.RendAcademicoDAOI;
import daoi.SexoDAOI;
import model.Alumno;
import model.Aula;
import model.RendAcademico;
import model.Sexo;

public class AlumnoBean {

	public int idAlumno;
	public RendAcademico RendAcademico;
	public String nombres;
	public int edad;
	public double talla;
	public Aula Aula;
	public Sexo Sexo;
	public Date fechaRegistro;
	
	
	private AlumnoDAOI oAlumnoDAOI = new AlumnoDAOI();
	private AulaDAOI oAulaDAOI = new AulaDAOI();
	private RendAcademicoDAOI oRendAcademicoDAOI = new RendAcademicoDAOI();
	private SexoDAOI oSexoDAOI = new SexoDAOI();
	
	public List<Alumno> listaAlumno;
	public List<Aula> listaAula;
	public List<RendAcademico> listaRendAcademico;
	public List<Sexo> listaSexo;
	
	public int listaAlumno_size;
	public int filaSeleccionada;
	public String opcionSeleccionada="ID";
	
	public void limpiar() throws Exception{
		setIdAlumno(0);
		setNombres("");
		setEdad(0);
		setTalla(0);
		setRendAcademico(new RendAcademico());
		setAula(new Aula());
		setSexo(new Sexo());
		setFechaRegistro(null);
	}

	public void llenaCombo() throws Exception{
		listaAula=oAulaDAOI.listar();
		listaRendAcademico=oRendAcademicoDAOI.listar();
		listaSexo=oSexoDAOI.listar();
	}
	
	public void buscarAlumno() throws Exception{
		Alumno oAlumno = new Alumno();
		listaAlumno = new ArrayList<Alumno>();
		
		if(opcionSeleccionada.equals("ID")){
			oAlumno.setIdAlumno(getIdAlumno());
			listaAlumno=oAlumnoDAOI.buscarPorId(oAlumno);
		}else{
			oAlumno.setSexo(getSexo());
			listaAlumno=oAlumnoDAOI.buscarPorSexo(oAlumno);
		}
		listaAlumno_size=listaAlumno.size();
	}
	
	public void insertar()throws Exception{
		//Thread.sleep(5000);
		Alumno oAlumno= new Alumno();
		oAlumno.setIdAlumno(getIdAlumno());
		oAlumno.setRendAcademico(getRendAcademico());
		oAlumno.setNombres(getNombres());
		oAlumno.setEdad(getEdad());
		oAlumno.setTalla(getTalla());
		oAlumno.setAula(getAula());
		oAlumno.setSexo(getSexo());
		oAlumno.setFechaRegistro(getFechaRegistro());
		try {
			oAlumnoDAOI.insertar(oAlumno);
		} catch (Exception e) {
			System.out.println("NO SE PUDO INSERTAR");
			System.out.println(e.getMessage());
		}

	}
	
	public void seleccionar_fila(ActionEvent e)
	{
		String fila=e.getComponent().getAttributes().get("attr_idAlumno").toString();
		System.out.println("Id seleccionado:"+ fila);
		filaSeleccionada=Integer.parseInt(fila);
	}
	
	public void eliminar() throws Exception{
		Alumno oAlumno=new Alumno();
		oAlumno.setIdAlumno(getFilaSeleccionada());
		oAlumnoDAOI.eliminar(oAlumno);
		
		buscarAlumno();
	}
	
	

	
	public void validaId(FacesContext arg0,UIComponent arg1,Object arg2) throws Exception	
	{
		String msj="";
		
		try {
			int i=(Integer)arg2;
			System.out.println(i);
			if(i<1){
				msj="Debe ingresar un ID mayor a cero.";	
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			msj="Debe ingresar un ID.";		
			
		}
		
		if(msj.equals("")){
			return;
		}else{
			throw new ValidatorException(new FacesMessage(msj));	
		}
	}


	public void validaNombre(FacesContext arg0,UIComponent arg1,Object arg2) throws Exception	
	{
		if(((String)arg2).length()<1)
		{
			throw new ValidatorException(new FacesMessage("Debe ingresar un nombre."));			
		}
		else
		{
			return;
		}
	}
	
	public void validaEdad(FacesContext arg0,UIComponent arg1,Object arg2) throws Exception	
	{
		String msj="";
		
		try {
			double i=(Integer)arg2;
			System.out.println(i);
			if(i<1){
				msj="Debe ingresar una edad mayor a cero.";	
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			msj="Debe ingresar una edad";		
			
		}
		
		if(msj.equals("")){
			return;
		}else{
			throw new ValidatorException(new FacesMessage(msj));	
		}
	}
	
	
	
	public void validaTalla(FacesContext arg0,UIComponent arg1,Object arg2) throws Exception	
	{
String msj="";
		
		try {
			double i=(Double)arg2;
			System.out.println(i);
			if(i<1){
				msj="Debe ingresar una talla mayor a cero.";	
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			msj="Debe ingresar una talla.";		
			
		}
		
		if(msj.equals("")){
			return;
		}else{
			throw new ValidatorException(new FacesMessage(msj));	
		}
	}
	
	
	
	public void validaRendAcad(FacesContext arg0,UIComponent arg1,Object arg2) throws Exception	
	{
String msj="";
		
		try {
			int i=(Integer)arg2;
			System.out.println(i);
			if(i<1){
				msj="Seleccione un Rendimiento Académico.";	
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			msj="Seleccione un Rendimiento Académico.";		
			
		}
		
		if(msj.equals("")){
			return;
		}else{
			throw new ValidatorException(new FacesMessage(msj));	
		}
	}
	
	
	public void validaAula(FacesContext arg0,UIComponent arg1,Object arg2) throws Exception	
	{
String msj="";
		
		try {
			int i=(Integer)arg2;
			System.out.println(i);
			if(i<1){
				msj="Seleccione una Aula.";	
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			msj="Seleccione una Aula.";		
			
		}
		
		if(msj.equals("")){
			return;
		}else{
			throw new ValidatorException(new FacesMessage(msj));	
		}
	}
	
	public void validaSexo(FacesContext arg0,UIComponent arg1,Object arg2) throws Exception	
	{
String msj="";
		
		try {
			int i=(Integer)arg2;
			System.out.println(i);
			if(i<1){
				msj="Seleccione un sexo.";	
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			msj="Seleccione un sexo";		
			
		}
		
		if(msj.equals("")){
			return;
		}else{
			throw new ValidatorException(new FacesMessage(msj));	
		}
	}
	
	
	public void validaFecha(FacesContext arg0,UIComponent arg1,Object arg2) throws Exception	
	{
		System.out.println(arg2);
		return;
//		if(((String)arg2).length()<1)
//		{
//			throw new ValidatorException(new FacesMessage("Debe ingresar una fecha."));			
//		}
//		else
//		{
//			return;
//		}
	}
	
	
	
	public int getIdAlumno() {
		return idAlumno;
	}
	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}
	public RendAcademico getRendAcademico() {
		return RendAcademico;
	}
	public void setRendAcademico(RendAcademico rendAcademico) {
		RendAcademico = rendAcademico;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public double getTalla() {
		return talla;
	}
	public void setTalla(double talla) {
		this.talla = talla;
	}
	public Aula getAula() {
		return Aula;
	}
	public void setAula(Aula aula) {
		Aula = aula;
	}
	public Sexo getSexo() {
		return Sexo;
	}
	public void setSexo(Sexo sexo) {
		Sexo = sexo;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public List<Alumno> getListaAlumno() {
		return listaAlumno;
	}
	public void setListaAlumno(List<Alumno> listaAlumno) {
		this.listaAlumno = listaAlumno;
	}
	public List<Aula> getListaAula() {
		return listaAula;
	}
	public void setListaAula(List<Aula> listaAula) {
		this.listaAula = listaAula;
	}
	public List<RendAcademico> getListaRendAcademico() {
		return listaRendAcademico;
	}
	public void setListaRendAcademico(List<RendAcademico> listaRendAcademico) {
		this.listaRendAcademico = listaRendAcademico;
	}
	public List<Sexo> getListaSexo() {
		return listaSexo;
	}
	public void setListaSexo(List<Sexo> listaSexo) {
		this.listaSexo = listaSexo;
	}
	public int getFilaSeleccionada() {
		return filaSeleccionada;
	}
	public void setFilaSeleccionada(int filaSeleccionada) {
		this.filaSeleccionada = filaSeleccionada;
	}
	public String getOpcionSeleccionada() {
		return opcionSeleccionada;
	}
	public void setOpcionSeleccionada(String opcionSeleccionada) {
		this.opcionSeleccionada = opcionSeleccionada;
	}
	
	
	public int getListaAlumno_size() {
		return listaAlumno_size;
	}

	public void setListaAlumno_size(int listaAlumno_size) {
		this.listaAlumno_size = listaAlumno_size;
	}

	@PostConstruct
	public void init(){
		RendAcademico =new RendAcademico();
		Aula = new Aula();
		Sexo = new Sexo();
	}
	
}
