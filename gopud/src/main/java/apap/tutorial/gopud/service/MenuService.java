package apap.tutorial.gopud.service;

import apap.tutorial.gopud.model.MenuModel;
import java.util.List;
import java.util.Optional;

public interface MenuService {
    void addMenu(MenuModel menu);
    List<MenuModel> findAllMenuByIdRestoran(Long idRestoran);
    public void deleteMenuById(MenuModel menu);
//    public MenuModel findMenuById(List<MenuModel> listMenu, Long idMenu)
    Optional<MenuModel> findMenuById(Long idMenu);
    MenuModel changeMenu(MenuModel menu);
}
