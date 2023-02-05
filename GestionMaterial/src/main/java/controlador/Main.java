package controlador;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import dao.Alumno;
import dao.Portatil;
import dao.PortatilImpl;
import dto.AdaoServicio;
import dto.AdaoServicioIMPL;
import dto.AdtoServicio;
import dto.AdtoServicioIMPL;
import dto.AlumnoDTO;
import dto.PortatilDTO;

import implementaciones.AlumnoConsultas;
import implementaciones.PortatilConsultas;


@Controller
public class Main {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String muuid = java.util.UUID.randomUUID().toString();
		int idAlumno;
		int idPortatilListar;
		int menu;
		Portatil elegir;
		boolean salir = false;
		Calendar actual = Calendar.getInstance();
		ApplicationContext contexto = new ClassPathXmlApplicationContext("bean.xml");
		AlumnoConsultas alumnoConsultas = (AlumnoConsultas)contexto.getBean(AlumnoConsultas.class);
		PortatilConsultas portatilConsultas = (PortatilConsultas)contexto.getBean(PortatilConsultas.class);
		
		AlumnoDTO alumnoDTO;
		Alumno alumno= new Alumno();
		
		PortatilDTO portatilDTO;
		
		Portatil portatil= new Portatil();
		
		AdaoServicio Adao = new AdaoServicioIMPL();
		AdtoServicio Adto = new AdtoServicioIMPL();
		
		List<Portatil> lista = new ArrayList<>();
		lista = portatilConsultas.listarPortatil();
		
		List<Alumno> listaAl = new ArrayList<>();
		listaAl = alumnoConsultas.ListarAlumno();
		
		int tamaño = lista.size()-1;
		
		
		Scanner scan = new Scanner(System.in);
		do { 
		
		System.out.println(" Matrícula alumno");
		System.out.println("Alta de portátil");
		System.out.println("Consulta portátil asignado a un alumno");
		System.out.println("Consulta alumno asignado a un portátil");
		System.out.println("Ver todos los alumnos con su asignación de portátil");
		System.out.println("salir");
		
			System.out.println("Elija una de las opciones");
			menu= scan.nextInt();
			
			
		switch(menu) {
		case 1:
			
			
			System.out.println("Ha elegido usted matricular alumno");
			
			System.out.println("indique el portatil para asignar por su id, este es el número de portátiles: "+lista.size());
			idPortatilListar=scan.nextInt();
			
			
			alumnoDTO = Adto.AlumnoaDTO(actual, "javier","474574",lista.get(idPortatilListar));
			alumno= Adao.AlumnoaDAO(alumnoDTO);
			alumnoConsultas.InsertarAlumno(alumno);
			
			break;
			
		case 2:
			System.out.println("Ha elegido usted dar de baja a un alumno");
			System.out.println("Dígame el id del alumno a eliminar: ");
			idAlumno=scan.nextInt();
			alumnoConsultas.EliminarAlumno(idAlumno);
			break;
			
		case 3:
			System.out.println("Ha elegido usted dar de alta un portátil");
			portatilDTO = Adto.PortatilaDTO(actual, "asf", "fdad");
			portatil= Adao.PortatilaDAO(portatilDTO);
			portatilConsultas.Insertar(portatil);
			break;
			
		case 4:
			
			System.out.println("Ha elegido usted consultar portátil asignado a un alumno");
			
			portatilDTO = Adto.PortatilaDTO(alumnoConsultas.BuscarAlumnoPorPortatil(1).getMd_date(),alumnoConsultas.BuscarAlumnoPorPortatil(1).getMarca(),
					alumnoConsultas.BuscarAlumnoPorPortatil(1).getModelo());
			
			System.out.println("modelo: " +portatilDTO.getModelo() + "marca: " + portatilDTO.getMarca()); 
			break;
		case 5:
			System.out.println("Ha elegido usted consultar alumno asignado a un portátil");
			 alumno=alumnoConsultas.BuscarPortatil(1);
			 System.out.println(alumno.getNombre() +" " +alumno.getTelefono());
			break;
			
		case 6:
			System.out.println("Ha elegido usted ver todos los alumnos con su asignación de portátil");
			for(Alumno a : listaAl) {
				System.out.println("id:"+a.getId_alumno() + " nombre:" + a.getNombre() + " id-portatil:" + a.getPortatil().getId());
			}
			break;
			
		case 7:
			System.out.println("Hasta pronto");
			break;
			
		
			
			
		}}while(menu!=7);

	}

}
