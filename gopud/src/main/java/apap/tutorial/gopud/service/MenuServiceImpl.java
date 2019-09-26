package apap.tutorial.gopud.service;

import org.springframework.beans.factory.annotation.Autowired;
import apap.tutorial.gopud.model.MenuModel;
import apap.tutorial.gopud.repository.MenuDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class MenuServiceImpl implements MenuService{
    @Autowired
    private MenuDb menuDb;

    @Override
    public void addMenu(MenuModel menu) {
        menuDb.save(menu);
    }

    @Override
    public List<MenuModel> findAllMenuByIdRestoran(Long idRestoran) {
        return menuDb.findByRestoranIdRestoran(idRestoran);
    }

//    @Override
//    public MenuModel changeMenu(MenuModel menu) {
//        MenuModel targetedMenu = menuDb.findById(menu.getId()).get();
//        try {
//            targetedMenu.setDeskripsi(menu.getDeskripsi());
//            targetedMenu.setDurasiMasak(menu.getDurasiMasak());
//            targetedMenu.setHarga(menu.getHarga());
//            targetedMenu.setNama(menu.getNama());
//            menuDb.save(targetedMenu);
//        } catch (NullPointerException nullException) {
//            return null;
//        }
//        return null;
//
//    }

}
