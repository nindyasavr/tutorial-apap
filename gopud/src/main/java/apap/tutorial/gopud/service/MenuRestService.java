package apap.tutorial.gopud.service;
import apap.tutorial.gopud.model.MenuModel;
import reactor.core.publisher.Mono;

import java.util.List;
public interface MenuRestService {
    MenuModel createMenu(MenuModel menu);
    MenuModel changeMenu(Long idMenu, MenuModel menu);
    MenuModel getMenuByIdMenu(Long idMenu);
    List<MenuModel> retrieveListMenu();
    void deleteMenu(Long idMenu);
}
