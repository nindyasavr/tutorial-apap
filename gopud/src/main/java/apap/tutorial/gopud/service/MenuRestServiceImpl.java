package apap.tutorial.gopud.service;

import apap.tutorial.gopud.model.MenuModel;
import apap.tutorial.gopud.repository.MenuDb;
import apap.tutorial.gopud.repository.RestoranDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MenuRestServiceImpl implements MenuRestService {
    @Autowired
    RestoranDb restoranDb;

    @Autowired
    MenuDb menuDb;

    @Override
    public MenuModel createMenu(MenuModel menu) {
        return menuDb.save(menu);
    }

    @Override
    public MenuModel changeMenu(Long idMenu, MenuModel menu) {
        MenuModel targetedMenu = menuDb.findById(idMenu).get();
        targetedMenu.setDeskripsi(menu.getDeskripsi());
        targetedMenu.setDurasiMasak(menu.getDurasiMasak());
        targetedMenu.setHarga(menu.getHarga());
        targetedMenu.setNama(menu.getNama());
        menuDb.save(targetedMenu);
        return targetedMenu;
    }

    @Override
    public MenuModel getMenuByIdMenu(Long idMenu) {
        return menuDb.findById(idMenu).get();
    }

    @Override
    public List<MenuModel> retrieveListMenu() {
        return menuDb.findAll();
    }

    @Override
    public void deleteMenu(Long idMenu) {
        MenuModel deletedMenu = getMenuByIdMenu(idMenu);
        menuDb.delete(deletedMenu);
    }
}
