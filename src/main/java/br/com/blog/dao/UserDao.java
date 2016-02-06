package br.com.blog.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import br.com.blog.model.Users;



@Repository
public class UserDao implements UserDetailsService {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public UserDetails loadUserByUsername(String username)
	throws UsernameNotFoundException{
		String jpql="select u from Users u where u.login = :login";
		
		List<Users> users = em.createQuery(jpql, Users.class)
				.setParameter("login", username).getResultList();
		
		if(users.isEmpty()){
			throw new UsernameNotFoundException
			("O usuario "+username+" não existe");
			}
		return users.get(0);
		
			
	}
}
