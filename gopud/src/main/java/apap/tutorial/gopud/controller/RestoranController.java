package apap.tutorial.gopud.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import apap.tutorial.gopud.model.RestoranModel;
import apap.tutorial.gopud.service.RestoranService;

@Controller
public class RestoranController {
    @Autowired
    private RestoranService restoranService;
    //URL mapping add
    @RequestMapping("/restoran/add")
    public String add(
            //Request Parameter untuk di pass
            @RequestParam(value = "idRestoran", required = true) String idRestoran,
            @RequestParam(value = "nama", required = true) String nama,
            @RequestParam(value = "alamat", required = true) String alamat,
            @RequestParam(value = "nomorTelepon", required = true) Integer nomorTelepon,
            Model model
    ) {
        // Membuat objek RestoranModel
        RestoranModel restoran = new RestoranModel(idRestoran, nama, alamat, nomorTelepon);

        // Memanggil Service addRestoran
        restoranService.addRestoran(restoran);

        // Add variabel nama restoran ke "namaResto" untuk dirender
        model.addAttribute("namaResto", nama);

        // Return View Template
        return "add-restoran";
    }

    //URL mapping untuk getRestoranByIdRestoran
    @RequestMapping("/restoran/view")
    public String view(
            // Request Parameter untuk di pass
            @RequestParam(value = "idRestoran") String idRestoran, Model model
    ) {
       // Mengambil Objek RestoranModel yang dituju
        RestoranModel restoran = restoranService.getRestoranByIdRestoran(idRestoran);
        if (restoran == null) {
            return "error-message";
        }
        // Add model restoran ke "resto" untuk dirender
        model.addAttribute("resto", restoran);

        // Return view template
        return "view-restoran";
    }

    // URL path untuk view restoran
    @RequestMapping(value = "/restoran/view/id-restoran/{idRestoran}")
    public String viewRestoWithPathVariable(
            @PathVariable(value = "idRestoran", required = true) String idRestoran, Model model) {
        // Mengambil Objek RestoranModel yang dituju
        RestoranModel restoran = restoranService.getRestoranByIdRestoran(idRestoran);
        if (restoran == null) {
            return "error-message";
        } // Add model restoran ke "resto" untuk dirender
            model.addAttribute("resto", restoran);
            return "view-restoran";
    }

    // URL mapping untuk getRestoranList
    @RequestMapping("/restoran/viewall")
    public String viewall(Model model) {
        // Mengambil semua objek RestoranModel yang ada
        List<RestoranModel> listRestoran = restoranService.getRestoranList();
        // Add model restoran ke "resto" untuk dirender
        model.addAttribute("restoList", listRestoran);
        // Return view template
        return "viewall-restoran";
    }

    @RequestMapping(value = "/restoran/update/id-restoran/{idRestoran}/nomor-telepon/{nomorTelepon}")
    public String updateNoTelp(
            @PathVariable(value = "idRestoran", required = true) String idRestoran,
            @PathVariable(value = "nomorTelepon", required = true) Integer nomorTelepon,
            Model model) {
        // Mengambil Objek RestoranModel yang dituju
        RestoranModel restoran = restoranService.getRestoranByIdRestoran(idRestoran);
        if (restoran == null) {
            return "error-message";
        }
            restoran.setNomorTelepon(nomorTelepon);
            // Add model restoran ke "resto" untuk dirender
            model.addAttribute("resto", restoran);
            return "update-notelp";
    }

    // URL Mapping untuk delete
    @RequestMapping(value = "/restoran/delete/id/{idRestoran}")
    public String delete(
            @PathVariable(value = "idRestoran", required = true) String idRestoran,
            Model model) {
        // Mengambil Objek RestoranModel yang dituju
        RestoranModel restoran = restoranService.getRestoranByIdRestoran(idRestoran);
        if (restoran == null) {
            return "error-message";
        }
        List<RestoranModel> listResto = restoranService.getRestoranList();
        for (RestoranModel resto : listResto) {
            if (restoran.equals(resto)) {
                listResto.remove(resto);
                // Add model restoran ke "resto" untuk dirender
                model.addAttribute("resto", restoran);
                return "delete-restoran";
            } else {
                return "error-message";
            }
        }
        return null;
    }
}
