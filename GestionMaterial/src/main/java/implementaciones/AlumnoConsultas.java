package implementaciones;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.Alumno;
import dao.AlumnoImpl;
import dao.Portatil;

@Service
public class AlumnoConsultas {
	
	@Autowired
	private AlumnoImpl a;
	
	@Transactional
	public void InsertarAlumno(Alumno alumno) {
		a.InsertarAlumno(alumno);
	}

	
	@Transactional
	public List<Alumno> ListarAlumno() {
		// TODO Auto-generated method stub
		
		return a.ListarAlumno();
	}
	
	@Transactional
	public void EliminarAlumno(int id) {
		a.EliminarAlumno(id);
		
		
		
		
	}
	
	@Transactional
	public Portatil BuscarAlumnoPorPortatil(int id_alumno) {
		

		return a.BuscarAlumnoPorPortatil(id_alumno);
	}
	
	@Transactional
	public Alumno BuscarPortatil(int id_Portatil) {
		
		return a .BuscarPortatil(id_Portatil);
	}

}
