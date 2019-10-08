package apap.tutorial.gopud.controller;

import apap.tutorial.gopud.model.MenuModel;
import apap.tutorial.gopud.model.RestoranModel;
import apap.tutorial.gopud.repository.MenuDb;
import apap.tutorial.gopud.service.MenuService;
import apap.tutorial.gopud.service.RestoranService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MenuController {
    @Autowired
    MenuService menuService;

    @Qualifier("restoranServiceImpl")
    @Autowired
    RestoranService restoranService;

//    @RequestMapping(value = "/menu/add/{idRestoran}", method = RequestMethod.GET)
//    private String addProductFormPage(@PathVariable(value = "idRestoran") Long idRestoran, Model model) {
//        MenuModel menu = new MenuModel();
//        RestoranModel restoran = restoranService.getRestoranByIdRestoran(idRestoran).get();
//        menu.setRestoran(restoran);
//        model.addAttribute("menu", menu);
//        return "form-add-menu";
//    }
//
//    @RequestMapping(value = "menu/add", method = RequestMethod.POST)
//    private String addProductSubmit(@ModelAttribute MenuModel menu, Model model) {
//        menuService.addMenu(menu);
//        model.addAttribute("nama", menu.getNama());
//
//        return "add-menu";
//    }

    @RequestMapping(value = "/menu/delete", method = RequestMethod.POST)
    private String deleteMenu(
            @ModelAttribute RestoranModel restoran, Model model) {
        for (MenuModel menu : restoran.getListMenu()) {
            menuService.deleteMenu(menu);
        }
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

    @RequestMapping(value = "menu/add/{idRestoran}", method = RequestMethod.GET)
    public String add(@PathVariable("idRestoran") Long idRestoran, Model model) {
        RestoranModel restoran = restoranService.getRestoranByIdRestoran(idRestoran).get();
        ArrayList<MenuModel> menuList = new ArrayList<>();
        restoran.setListMenu(menuList);
        menuList.add(new MenuModel());
        model.addAttribute("restoran", restoran);
        return "form-add-menu";
    }

    @RequestMapping(value = "/menu/add", method = RequestMethod.POST)
    public String addProductSubmit(@ModelAttribute RestoranModel restoran, Model model){
        RestoranModel target = restoranService.getRestoranByIdRestoran(restoran.getIdRestoran()).get();
        for (MenuModel addedMenu : restoran.getListMenu()) {
            addedMenu.setRestoran(target);
            menuService.addMenu(addedMenu);
        }
        return "add-menu";
    }

    @RequestMapping(value = "menu/add", params = {"addRow"}, method = RequestMethod.POST)
    public String addRowFormMenu(RestoranModel restoran, MenuModel menu, BindingResult bindingResult, Model model) {
        if (restoran.getListMenu() == null) {
            restoran.setListMenu(new ArrayList<>());
        }
        restoran.getListMenu().add(menu);
        model.addAttribute("restoran", restoran);
        return "form-add-menu";
    }

    @RequestMapping(value = "menu/add", params = {"removeRow"}, method = RequestMethod.POST)
    public String removeRowFormMenu(RestoranModel restoran, BindingResult bindingResult, final HttpServletRequest req, Model model) {
        final Integer rowId = Integer.valueOf(req.getParameter("removeRow"));
        restoran.getListMenu().remove(rowId.intValue());
        model.addAttribute("restoran", restoran);
        return "form-add-menu";
    }


}

