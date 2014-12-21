package fr.ekito.gwt.server.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.ekito.gwt.server.model.City;

@Repository
@Transactional(readOnly = true)
public class CityRepository{

	@PersistenceContext
	private EntityManager entityManager;

	
	public City findByName(String name) {
		try {
			return entityManager.createNamedQuery(City.FIND_BY_NAME, City.class)
					.setParameter("name", name)
					.getSingleResult();
		} catch (PersistenceException e) {
			return null;
		}
	}

}
