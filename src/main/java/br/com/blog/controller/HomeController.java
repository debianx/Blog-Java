package br.com.blog.controller;

import javax.transaction.Transactional;

import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.blog.dao.ArtigoDao;
import br.com.blog.dao.CategoriesDao;

@Transactional
@Controller
public class HomeController {

	@Autowired
	private ArtigoDao artigoDao;
	
	@Autowired
	private CategoriesDao categoriesDao;

	@RequestMapping("/")
	//Exibir os artigos
	public ModelAndView list(Pageable pageable){
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("artigos", artigoDao.list(pageable));
		modelAndView.addObject("categories",categoriesDao.list());
		return modelAndView;
	}
	
	@RequestMapping("/admin")
	public ModelAndView adm(){
		ModelAndView modelAndView = new ModelAndView("admin/admin");
		return modelAndView;
	}
}	
