package apap.tutorial.gopud.restcontroller;

import apap.tutorial.gopud.model.MenuModel;
import apap.tutorial.gopud.model.RestoranModel;
import apap.tutorial.gopud.rest.RestoranDetail;
import apap.tutorial.gopud.service.MenuRestService;
import apap.tutorial.gopud.service.RestoranRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;
import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1")
public class MenuRestController {
    @Autowired
    private MenuRestService menuRestService;

    @PostMapping(value = "/menu")
    private MenuModel createMenu(@Valid @RequestBody MenuModel menu, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Request body has invalid type or missing field");
        }
        else {
            return menuRestService.createMenu(menu);
        }
    }

    @GetMapping(value = "/menu/{idMenu}")
    private MenuModel retrieveMenu(@PathVariable("idMenu") Long idMenu) {
        try {
            return menuRestService.getMenuByIdMenu(idMenu);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "ID Menu "+String.valueOf(idMenu)+" Not Found");
        }
    }



    @DeleteMapping(value = "/menu/{idMenu}")
    private ResponseEntity<String> deleteMenu(@PathVariable("idMenu") Long idMenu) {
        try {
            menuRestService.deleteMenu(idMenu);
            return ResponseEntity.ok("Restoran with ID " + String.valueOf(idMenu) + " Deleted!");
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Menu with ID " + String.valueOf(idMenu)+" Not Found!");
        }
    }

    @PutMapping(value = "/menu/{menuId}")
    private MenuModel updateMenu(
            @PathVariable (value = "idMenu") Long idMenu,
            @RequestBody MenuModel menu
    ) {
        try {
            return menuRestService.changeMenu(idMenu, menu);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ID Menu " + String.valueOf(idMenu)+" Not Found");
        }
    }

    @GetMapping(value = "/menus")
    private List<MenuModel> retrieveListMenu(){
        return menuRestService.retrieveListMenu();
    }


    @GetMapping(value = "/recipe/excludeIngredients={ingredient}")
    private Mono<String> searchExclude(@PathVariable String ingredient){
        return menuRestService.getExclude(ingredient);
    }

    @GetMapping(value = "/restoran/chef/nama")
    private Mono<String> searchChef(@RequestParam String namaChef){
        return menuRestService.getChef(namaChef);
    }


}
