package tdtu.edu.vn.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import tdtu.edu.vn.entity.Menu;
import tdtu.edu.vn.repository.MenuRepository;
import tdtu.edu.vn.service.MenuService;
@Service
public class MenuServiceImpl implements MenuService{
	private MenuRepository menuRepository;
	public MenuServiceImpl(MenuRepository menuRepository) {
		super();
		this.menuRepository = menuRepository;
	}
	@Override
	public List<Menu> getAllMenus()
	{
		return menuRepository.findAll();
	}
	
	@Override
	public Menu saveMenu(Menu menu)
	{
		return menuRepository.save(menu);
	}
	@Override
	public Menu getMenuById(Long id)
	{
		return menuRepository.findById(id).get();
	}
	@Override
	public Menu updateMenu(Menu menu)
	{
		return menuRepository.save(menu);
	}
	@Override
	public void deleteMenuById(Long id) 
	{
		 menuRepository.deleteById(id);
	}
}
