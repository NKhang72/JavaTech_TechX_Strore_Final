package tdtu.edu.vn.service;

import java.util.List;

import tdtu.edu.vn.entity.Menu;

public interface MenuService {
	public List<Menu> getAllMenus();

	public Menu saveMenu(Menu menu);

	public Menu getMenuById(Long id);

	public Menu updateMenu(Menu menu);
	
	public void deleteMenuById(Long id);

}
