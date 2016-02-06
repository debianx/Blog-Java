package br.com.blog.controller;

import java.util.List;
import java.util.stream.Stream;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.blog.dao.ArtigoDao;
import br.com.blog.dao.CategoriesDao;
import br.com.blog.model.Artigo;


@Controller
@Transactional
@RequestMapping("/admin")
public class ArtigoController {

	@Autowired
	private ArtigoDao artigoDao;
	@Autowired
	private CategoriesDao categoriesDao;
	
	//Formulário para cadastrar
	@RequestMapping("/artigos/form")
	public ModelAndView form(Artigo artigo, Pageable pageable){
		ModelAndView modelAndView = new ModelAndView("/artigos/form");
		modelAndView.addObject("categories",categoriesDao.list());
		modelAndView.addObject("artigos", artigoDao.list(pageable));
		return modelAndView;
	}
	//Salvar os artigos
	@RequestMapping(value="/artigos/save",method=RequestMethod.POST, name="saveArtigo")
	public ModelAndView save(@Valid Artigo artigo, BindingResult bindingResult,RedirectAttributes redirectAttributes){
		
		if(bindingResult.hasErrors()){
			return form(artigo, null);
		}
		artigoDao.save(artigo);
		redirectAttributes.addFlashAttribute("sucesso","Artigo cadastrado com sucesso");
		return new ModelAndView("redirect:/admin/artigos");
	}
	
	//Exibir os artigos
	@RequestMapping(value="/artigos",method=RequestMethod.GET)
	public String list(Model model, Pageable pageable){
		/*ModelAndView modelAndView = new ModelAndView("artigos/list");	
		//model.addAttribute("artigos", artigoDao.list(pageable))
		modelAndView.addObject("artigos", artigoDao.list(pageable));
		return modelAndView;*/
		
		model.addAttribute("artigos",artigoDao.list(pageable));
		return "artigos/list";
	}
	

	//Deletar artigos
	@RequestMapping(value="/artigos/remove/{id}")
	public String remove(@PathVariable("id")int id,Artigo artigo){
		artigoDao.remove(artigo);	  
		return "redirect:/artigos";
	}

	@RequestMapping(value="/artigos/atualizar/{id}")
	public String mostrar(@PathVariable("id")int id, Model model){
		model.addAttribute("artigos",artigoDao.buscaPorId(id));
		return "/artigos/atualizar";
	}
	@RequestMapping(value="/artigos/update")
	public String atualizar(Artigo artigo){
		artigoDao.update(artigo);
		return "redirect:";
	}
}
