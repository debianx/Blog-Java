package br.com.blog.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.blog.dao.CategoriesDao;
import br.com.blog.model.Categories;

@Controller
@Transactional
@RequestMapping("/admin")
public class CategoriesController {

	@Autowired
	private CategoriesDao categoriesDao;

	@RequestMapping("/categories/form")
	public ModelAndView form(){
		ModelAndView modelAndView = new ModelAndView("categories/form");
		modelAndView.addObject("categories",categoriesDao.list());
		return modelAndView;	
	}	
	//Save categories
	@RequestMapping(value="/categories/save",method= RequestMethod.POST)
	public ModelAndView save(Categories categories, RedirectAttributes redirectAttributes){
		categoriesDao.save(categories);
		redirectAttributes.addFlashAttribute("sucesso","Categoria cadastrada com sucesso");
		return new ModelAndView("redirect:/admin/categories");
	}

	@RequestMapping(value="/categories", method= RequestMethod.GET)
	public ModelAndView list(){
		ModelAndView modelAndView = new ModelAndView("categories/list");
		modelAndView.addObject("categories",categoriesDao.list());
		return modelAndView;
	}

}

