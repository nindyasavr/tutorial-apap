package apap.tutorial.gopud.service;

import apap.tutorial.gopud.model.MenuModel;
import apap.tutorial.gopud.repository.MenuDb;
import apap.tutorial.gopud.repository.RestoranDb;

import apap.tutorial.gopud.rest.RestoranDetail;
import apap.tutorial.gopud.rest.Setting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MenuRestServiceImpl implements MenuRestService {
    @Autowired
    RestoranDb restoranDb;

    @Autowired
    MenuDb menuDb;

    private final WebClient webClient;


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

    @Override
    public Mono<String> getExclude(String ingredients) {
        return this.webClient.get().uri(Setting.recipeUrl + ingredients + "&apiKey=a2290f9163f646b4ad327daaaff439e4")
                .retrieve().bodyToMono(String.class);
    }

    public MenuRestServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(Setting.menuUrl).build();
    }

    @Override
    public Mono<String> getChef(String namaChef) {
        return this.webClient.get().uri(Setting.menuUrl + namaChef)
                .retrieve().bodyToMono(String.class);
    }

//    public Mono<RestoranDetail> postChef() {
//        MultiValueMap<String, String> data = new LinkedMultiValueMap<>();
//        data.add("nama", "Juni");
//        data.add("spesialis", "menuPastry");
//        return this.webClient.post().uri("/restoran/chef/nama").syncBody(data).retrieve().bodyToMono(Setting.menuUrl);
//    }
}
