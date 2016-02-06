package br.com.blog.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import br.com.blog.model.Artigo;

@Repository
public class ArtigoDao{

	@PersistenceContext
	private EntityManager manager;


	public void save(Artigo artigo){
		manager.persist(artigo);
	}

	public List<Artigo> list(Pageable pageable) {
		return manager.createQuery("select p from Artigo p",Artigo.class)
				.getResultList();
	}

	public Artigo buscaPorId(int id){
		return manager.find(Artigo.class,id);
	}

	public void remove(Artigo artigo){
		Artigo artigoRemover = buscaPorId(artigo.getId());
		manager.remove(artigoRemover);
	}
	public void update(Artigo artigo) {
		manager.merge(artigo);

	}
}
