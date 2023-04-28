package tdtu.edu.vn.controller;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import tdtu.edu.vn.entity.Category;
import tdtu.edu.vn.entity.Menu;
import tdtu.edu.vn.entity.News;
import tdtu.edu.vn.entity.Product;
import tdtu.edu.vn.repository.UserRepository;
import tdtu.edu.vn.service.CategoryService;
import tdtu.edu.vn.service.MenuService;
import tdtu.edu.vn.service.NewsService;
import tdtu.edu.vn.service.ProductService;
@Controller
public class NewsController {
	public ProductService productService;
	public CategoryService categoryService;
	public MenuService menuService;
	public UserRepository userRepository;
	public NewsService newsService;
	
	//public IndexController(ProductService productService, CategoryService categoryService, MenuService menuService,UserRepository userRepository) {}

	
	public NewsController(ProductService productService, CategoryService categoryService, MenuService menuService,NewsService newsService, UserRepository userRepository) {
		super();
		this.productService = productService;
		this.categoryService=categoryService;
		this.menuService=menuService;
		this.userRepository=userRepository;
		this.newsService=newsService;
	}
	@GetMapping("/news/page")
	public String newsIndex(Model model, @RequestParam("p") Optional<Integer> p,@RequestParam("field") Optional<String> field) {
		int c,pageCount;
		int total=newsService.count();
		if(total%7!=0) {
			pageCount=total/7;
		}
		else {
			pageCount=(total/7)+1;
		}
		if(p==null || p.hashCode()<0 ) {
			c=0;
		}
		else if(p.hashCode() >= pageCount) {
			c=p.hashCode()-1;
		}
		else {
			c=p.hashCode();
		}
		Sort sort= Sort.by(Direction.DESC, field.orElse("createDate"));
		Pageable pageable= PageRequest.of(c, 7,sort);
		
		Page<News> page= newsService.getAllNewsShow(pageable);
		model.addAttribute("listNews", page);
		return "news";
	}
	
	@GetMapping("/news/detail/{id}")
	public String newsDetail(@PathVariable Long id, Model model) {
		model.addAttribute("news", newsService.getNewsById(id));
		
		return "newsSingle";
	}
	@GetMapping("/admin/news/new")
	public String createNewsForm(Model model) {
		News news= new News();
		model.addAttribute("news", news);
		return "create_news";

	}
	@PostMapping("/admin/news/new")
	public String createNews(@RequestParam("title") String title,@RequestParam("content") String content
			,@RequestParam(value = "hide", required = false) String checkboxValue, @RequestParam("image") MultipartFile photo) {
		
		News news=new News();
		if(checkboxValue != null) {
			news.setHide(true);
		}
		else {
			news.setHide(false);
		}
		news.setTitle(title);
		news.setContent(content);
		Date date=new Date();
		news.setCreateDate(date);
		if (photo.isEmpty()) {
			return "/admin";
		} else {
			Path path = Paths.get("uploads/");
			try {
				InputStream inputStream = photo.getInputStream();
				
				Files.copy(inputStream, path.resolve(photo.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
				
				news.setImage(photo.getOriginalFilename().toLowerCase());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		newsService.saveNews(news);
		return "redirect:/admin/news/page";
	}
	@GetMapping("/admin/news/edit/{id}")
	public String editNewsForm(@PathVariable Long id, Model model) {
		model.addAttribute("news", newsService.getNewsById(id));
		return "edit_news";
	}
	@PostMapping("/admin/news/{id}")
	public String editNewsForm(@PathVariable Long id,@RequestParam("title") String title,@RequestParam("content") String content
			,@RequestParam(value = "hide", required = false) String checkboxValue, @RequestParam("image") MultipartFile photo) {
		News news= newsService.getNewsById(id);
		if(checkboxValue != null) {
			news.setHide(true);
		}
		else {
			news.setHide(false);
		}
		news.setTitle(title);
		news.setContent(content);
		Date date=new Date();
		news.setCreateDate(date);
		if (photo.isEmpty()) {
			return "/admin";
		} else {
			Path path = Paths.get("uploads/");
			try {
				InputStream inputStream = photo.getInputStream();
				
				Files.copy(inputStream, path.resolve(photo.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
				
				news.setImage(photo.getOriginalFilename().toLowerCase());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		newsService.updateNews(news);
		return "redirect:/admin/news/page";
	}

	@GetMapping("/admin/news/{id}")
	public String deleteNews(@PathVariable Long id) {
		newsService.deleteNewsById(id);
		return "redirect:/admin/news/page";
	}
	@ModelAttribute("category")
	public List<Category> categgory(){
		return categoryService.getAllCategorys();
	}
	@ModelAttribute("menu")
	public List<Menu> menu(){
		return menuService.getAllMenus();
	}
	


}
