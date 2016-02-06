package br.com.blog.conf;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.resource.VersionResourceResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import br.com.blog.controller.ArtigoController;
import br.com.blog.controller.CategoriesController;
import br.com.blog.controller.HomeController;
import br.com.blog.controller.LoginController;
import br.com.blog.dao.ArtigoDao;
import br.com.blog.dao.CategoriesDao;
import br.com.blog.dao.UserDao;

@EnableSpringDataWebSupport
@EnableWebMvc
@ComponentScan(basePackageClasses={ArtigoController.class,ArtigoDao.class,UserDao.class, HomeController.class,
		CategoriesController.class, CategoriesDao.class, LoginController.class})
public class AppWebConfiguration extends WebMvcConfigurerAdapter{

	@Bean
	public InternalResourceViewResolver internalResourceViewResolver(){

		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	@Bean
	public MessageSource messageSource(){
		ReloadableResourceBundleMessageSource bundle =
				new ReloadableResourceBundleMessageSource();
		bundle.setBasename("/WEB-INF/messages");
		bundle.setDefaultEncoding("UTF-8");
		bundle.setCacheSeconds(1); //indicar que o arquivo deve ser carregado a 1 segundo
		return bundle;

	}

	@Override
	public void configureDefaultServletHandling(
			DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**")
		.addResourceLocations("/resources/").setCachePeriod(31556926)
		.resourceChain (true) .addResolver (new VersionResourceResolver().addContentVersionStrategy( "/**" ));
	}
}
