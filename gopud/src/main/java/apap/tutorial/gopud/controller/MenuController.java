package apap.tutorial.gopud.controller;

import apap.tutorial.gopud.model.MenuModel;
import apap.tutorial.gopud.model.RestoranModel;
import apap.tutorial.gopud.repository.MenuDb;
import apap.tutorial.gopud.service.MenuService;
import apap.tutorial.gopud.service.RestoranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.awt.*;
import java.util.List;

@Controller
public class MenuController {
    @Autowired
    MenuService menuService;

    @Qualifier("restoranServiceImpl")
    @Autowired
    RestoranService restoranService;

    @RequestMapping(value = "/menu/add/{idRestoran}", method = RequestMethod.GET)
    private String addProductFormPage(@PathVariable(value = "idRestoran") Long idRestoran, Model model) {
        MenuModel menu = new MenuModel();
        RestoranModel restoran = restoranService.getRestoranByIdRestoran(idRestoran).get();
        menu.setRestoran(restoran);
        model.addAttribute("menu", menu);
        return "form-add-menu";
    }

    @RequestMapping(value = "menu/add", method = RequestMethod.POST)
    private String addProductSubmit(@ModelAttribute MenuModel menu, Model model) {
        menuService.addMenu(menu);
        model.addAttribute("nama", menu.getNama());

        return "add-menu";
    }

    @RequestMapping(value = "menu/delete/{id}", method = RequestMethod.GET)
    private String deleteMenu(
            @PathVariable(value = "id") Long id, Model model) {
        MenuModel targetedMenu = menuService.findMenuById(id).get();
        menuService.deleteMenuById(targetedMenu);
//        listMenu.remove(targetedMenu);
        return "delete-menu";
    }

    @RequestMapping(value = "/menu/change/{id}", method = RequestMethod.GET)
    public String changeMenuFormPage(@PathVariable(value = "id") Long id, Model model) {
        MenuModel existMenu = menuService.findMenuById(id).get();
        model.addAttribute("menu", existMenu);
        return "form-change-menu";
    }

    @RequestMapping(value = "/menu/change/{id}", method = RequestMethod.POST)
    public String changeMenuFormPage(@PathVariable(value = "id") Long id, @ModelAttribute MenuModel menu, Model model) {
        MenuModel newMenu = menuService.changeMenu(menu);
        model.addAttribute("menu", newMenu);
        return "change-menu";
    }




//    //API yang digunakkan untuk menuju halaman form change restoran
//    @RequestMapping(value = "restoran/change/{idRestoran}", method = RequestMethod.GET)
//    public String changeRestoranFormPage(@PathVariable Long idRestoran, Model model) {
//        //Mengambil existing data restoran
//        RestoranModel existingRestoran = restoranService.getRestoranByIdRestoran(idRestoran).get();
//        model.addAttribute("restoran", existingRestoran);
//        return "form-change-restoran";
//    }
//
//    //API yang digunakan untuk submit form change restoran
//    @RequestMapping(value = "restoran/change/{idRestoran}", method = RequestMethod.POST)
//    public String changeRestoranFormSubmit(@PathVariable Long idRestoran, @ModelAttribute RestoranModel restoran, Model model) {
//        RestoranModel newRestoranData = restoranService.changeRestoran(restoran);
//        model.addAttribute("restoran", newRestoranData);
//        return "change-restoran";
//    }

}

