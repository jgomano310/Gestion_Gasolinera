package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
public class AlumnoImpl implements InterfazAlumno {

	@PersistenceContext
	EntityManager entity;
	
	
	
	//insertar alumnos
	@Override
	public void InsertarAlumno(Alumno alumno) {
		try {
		entity.persist(alumno);
		entity.clear();
		}catch(Exception e)
		
		{
			System.out.println(e);
		}
		
	}
	
	

	//listar todos los alumnos
	@Override
	public List<Alumno> ListarAlumno() {
		// TODO Auto-generated method stub
		try {
		String jpql = "SELECT a FROM Alumno a WHERE a.portatil !=null";
		Query query = entity.createQuery(jpql);
		
		return query.getResultList();
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
		
	}

	
	//eliminar alumno por id
	@Override
	public void EliminarAlumno(int id) {
		
		
		try {
		String jpql = "DELETE FROM Alumno a WHERE a.id=:id_alumno";
		Query query = entity.createQuery(jpql);
		query.setParameter("id_alumno", id);
		int eliminados = query.executeUpdate();
		System.out.println("el numero de eliminados es: " +eliminados);
		}catch(Exception e){
			System.out.println(e);
		}
		
	}



	//se conoce el número de alumno se busca el portátil
	@Override
	public Portatil BuscarAlumnoPorPortatil(int id_alumno) {
		
		try {
		String jpql = "SELECT al FROM Alumno al WHERE al.id=:id_alumno";
		Query query = entity.createQuery(jpql);
		query.setParameter("id_alumno", id_alumno);
		List<Alumno> lista = (List<Alumno>) query.getResultList();
		Portatil portatil = lista.get(0).getPortatil();
		
		
		return portatil;
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}


		//se concoe el número del portatil y se busca el alumno
	@Override
	public Alumno BuscarPortatil(int id_Portatil) {
		String jpql = "SELECT al FROM Alumno al WHERE al.portatil.id=:id_Portatil";
		Alumno alumno= new Alumno();
		Query query = entity.createQuery(jpql);
		query.setParameter("id_Portatil", id_Portatil);
		List<Alumno> lista = (List<Alumno>) query.getResultList();
		// alumno = lista.get(0).getId_alumno(),
		// (Alumno)lista.get(0).getId();
	
		return alumno;
	}




	
	}


