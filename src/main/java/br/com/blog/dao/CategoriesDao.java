package br.com.blog.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.blog.model.Categories;

@Repository
public class CategoriesDao {

	@PersistenceContext
	private EntityManager manager;

	public void save(Categories categories){
		manager.persist(categories);
	}

	public List<Categories> list(){
		return manager.createQuery("select p from Categories p", Categories.class)
				.getResultList();
	}
}
