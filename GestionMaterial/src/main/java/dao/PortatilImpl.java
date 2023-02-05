package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
public class PortatilImpl implements InterfazPortatil {

	
	@PersistenceContext
	EntityManager entity;
	
	@Override
	//insertar portatil
	public void Insertar(Portatil portatil) {
		// TODO Auto-generated method stub
		try {
		entity.persist(portatil);
		}catch(Exception e ) {
			System.out.println(e);
		}
	}

	@Override
	//Listar portatiles
	public List<Portatil> listarPortatil() {
		// TODO Auto-generated method stub
		String jpql = "SELECT p FROM Portatil p";
		Query query = entity.createQuery(jpql);
		
		return query.getResultList();
	}
	
	
	}


