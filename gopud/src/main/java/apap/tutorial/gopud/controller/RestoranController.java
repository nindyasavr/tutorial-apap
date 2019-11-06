package apap.tutorial.gopud.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import apap.tutorial.gopud.model.MenuModel;
import apap.tutorial.gopud.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import apap.tutorial.gopud.model.RestoranModel;
import apap.tutorial.gopud.service.RestoranService;

@Controller
public class RestoranController {
    @Qualifier("restoranServiceImpl")
    @Autowired
    private RestoranService restoranService;

    @Autowired
    private MenuService menuService;

//    @RequestMapping("/")
//    public String home() {
//        return "home";
//    }

    // URL mapping yang digunakan untuk mengakses halaman add restoran
    @RequestMapping(value = "/restoran/add", method = RequestMethod.GET)
    public String addRestoranFormPage(Model model) {
        RestoranModel newRestoran = new RestoranModel();
        model.addAttribute("restoran", newRestoran);
        return "form-add-restoran";
    }

    //URL mapping yang digunakan untuk submit form yang telah anda masukkan pada halaman add restoran
    @RequestMapping(value = "/restoran/add", method = RequestMethod.POST)
    public String addRestoranSubmit(@ModelAttribute RestoranModel restoran, Model model) {
        restoranService.addRestoran(restoran);
        model.addAttribute("namaResto", restoran.getNama());
        return "add-restoran";
    }

    //URL mapping view
    @RequestMapping(path = "/restoran/view", method = RequestMethod.GET)
    public String view(
            // Request parameter untuk dipoass
            @RequestParam(value = "idRestoran") Long idRestoran, Model model
    ) {
        RestoranModel restoran = restoranService.getRestoranByIdRestoran(idRestoran).get();
        //Add model restoran ke "resto untuk dirender

        List<MenuModel> menuList = menuService.findAllMenuByIdRestoran(restoran.getIdRestoran());
        restoran.setListMenu(menuList);

        model.addAttribute("resto", restoran);
        model.addAttribute("listMenu", menuList);
        //Return view template
        return "view-restoran";
    }

    //API yang digunakkan untuk menuju halaman form change restoran
    @RequestMapping(value = "restoran/change/{idRestoran}", method = RequestMethod.GET)
    public String changeRestoranFormPage(@PathVariable Long idRestoran, Model model) {
        //Mengambil existing data restoran
        RestoranModel existingRestoran = restoranService.getRestoranByIdRestoran(idRestoran).get();
        model.addAttribute("restoran", existingRestoran);
        return "form-change-restoran";
    }

    //API yang digunakan untuk submit form change restoran
    @RequestMapping(value = "restoran/change/{idRestoran}", method = RequestMethod.POST)
    public String changeRestoranFormSubmit(@PathVariable Long idRestoran, @ModelAttribute RestoranModel restoran, Model model) {
        RestoranModel newRestoranData = restoranService.changeRestoran(restoran);
        model.addAttribute("restoran", newRestoranData);
        return "change-restoran";
    }

    @RequestMapping(value = "restoran/viewall", method = RequestMethod.GET)
    public String viewAllResto(Model model) {
        List<RestoranModel> listResto = restoranService.getRestoranList();
        listResto.sort(Comparator.comparing(RestoranModel::getNama));
        model.addAttribute("restoList", listResto);
        return "viewall-restoran";
    }

    @RequestMapping(value = "restoran/delete/{idRestoran}", method = RequestMethod.GET)
    public String deleteResto(@PathVariable(value = "idRestoran") Long idRestoran, Model model) {
        if (restoranService.getRestoranByIdRestoran(idRestoran).isEmpty()){
            return "error-message";
        }
        RestoranModel deleteResto = restoranService.getRestoranByIdRestoran(idRestoran).get();
        if (deleteResto.getListMenu().size() == 0) {
            restoranService.deleteRestoranById(idRestoran);
            model.addAttribute("resto", deleteResto);
            return "delete-restoran";
        }
        return "error-message";
    }





//    //URL mapping add
//    @RequestMapping("/restoran/add")
//    public String add(
//            //Request Parameter untuk di pass
//            @RequestParam(value = "idRestoran", required = true) String idRestoran,
//            @RequestParam(value = "nama", required = true) String nama,
//            @RequestParam(value = "alamat", required = true) String alamat,
//            @RequestParam(value = "nomorTelepon", required = true) Integer nomorTelepon,
//            Model model
//    ) {
//        // Membuat objek RestoranModel
//        RestoranModel restoran = new RestoranModel(idRestoran, nama, alamat, nomorTelepon);
//
//        // Memanggil Service addRestoran
//        restoranService.addRestoran(restoran);
//
//        // Add variabel nama restoran ke "namaResto" untuk dirender
//        model.addAttribute("namaResto", nama);
//
//        // Return View Template
//        return "add-restoran";
//    }
//
//    //URL mapping untuk getRestoranByIdRestoran
//    @RequestMapping("/restoran/view")
//    public String view(
//            // Request Parameter untuk di pass
//            @RequestParam(value = "idRestoran") String idRestoran, Model model
//    ) {
//       // Mengambil Objek RestoranModel yang dituju
//        RestoranModel restoran = restoranService.getRestoranByIdRestoran(idRestoran);
//        if (restoran == null) {
//            return "error-message";
//        }
//        // Add model restoran ke "resto" untuk dirender
//        model.addAttribute("resto", restoran);
//
//        // Return view template
//        return "view-restoran";
//    }
//
//    // URL path untuk view restoran
//    @RequestMapping(value = "/restoran/view/id-restoran/{idRestoran}")
//    public String viewRestoWithPathVariable(
//            @PathVariable(value = "idRestoran", required = true) String idRestoran, Model model) {
//        // Mengambil Objek RestoranModel yang dituju
//        RestoranModel restoran = restoranService.getRestoranByIdRestoran(idRestoran);
//        if (restoran == null) {
//            return "error-message";
//        } // Add model restoran ke "resto" untuk dirender
//            model.addAttribute("resto", restoran);
//            return "view-restoran";
//    }
//
//    // URL mapping untuk getRestoranList
//    @RequestMapping("/restoran/viewall")
//    public String viewall(Model model) {
//        // Mengambil semua objek RestoranModel yang ada
//        List<RestoranModel> listRestoran = restoranService.getRestoranList();
//        // Add model restoran ke "resto" untuk dirender
//        model.addAttribute("restoList", listRestoran);
//        // Return view template
//        return "viewall-restoran";
//    }
//
//    @RequestMapping(value = "/restoran/update/id-restoran/{idRestoran}/nomor-telepon/{nomorTelepon}")
//    public String updateNoTelp(
//            @PathVariable(value = "idRestoran", required = true) String idRestoran,
//            @PathVariable(value = "nomorTelepon", required = true) Integer nomorTelepon,
//            Model model) {
//        // Mengambil Objek RestoranModel yang dituju
//        RestoranModel restoran = restoranService.getRestoranByIdRestoran(idRestoran);
//        if (restoran == null) {
//            return "error-message";
//        }
//            restoran.setNomorTelepon(nomorTelepon);
//            // Add model restoran ke "resto" untuk dirender
//            model.addAttribute("resto", restoran);
//            return "update-notelp";
//    }
//
//    // URL Mapping untuk delete
//    @RequestMapping(value = "/restoran/delete/id/{idRestoran}")
//    public String delete(
//            @PathVariable(value = "idRestoran", required = true) String idRestoran,
//            Model model) {
//        // Mengambil Objek RestoranModel yang dituju
//        RestoranModel restoran = restoranService.getRestoranByIdRestoran(idRestoran);
//        if (restoran == null) {
//            return "error-message";
//        }
//        List<RestoranModel> listResto = restoranService.getRestoranList();
//        for (RestoranModel resto : listResto) {
//            if (restoran.equals(resto)) {
//                listResto.remove(resto);
//                // Add model restoran ke "resto" untuk dirender
//                model.addAttribute("resto", restoran);
//                return "delete-restoran";
//            } else {
//                return "error-message";
//            }
//        }
//        return null;
//    }
}
