package apap.tutorial.gopud.service;
import apap.tutorial.gopud.model.MenuModel;
import apap.tutorial.gopud.model.RestoranModel;
import apap.tutorial.gopud.repository.MenuDb;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MenuServiceImplTest {
    @InjectMocks
    MenuService menuService = new MenuServiceImpl();
    @Mock
    MenuDb menuDb;

    @Test
    public void whenAddValidMenuItShouldCallMenuRepositorySave() {
        MenuModel newMenu = new MenuModel();
        newMenu.setNama("tempe");
        newMenu.setHarga(BigInteger.valueOf(10000));
        newMenu.setDurasiMasak(10);
        newMenu.setDeskripsi("tempe goreng lezat");
        menuService.addMenu(newMenu);
        verify(menuDb, times(1)).save(newMenu);
    }

    @Test
    public void whenGetMenuListCalledItShouldReturnAllMenu() {
        List<MenuModel> allMenuInDatabase = new ArrayList<>();
        for (int loopTimes = 3; loopTimes > 0; loopTimes--) {
            allMenuInDatabase.add(new MenuModel());
        }
        when(menuService.findAllMenuByIdRestoran(1L)).thenReturn(allMenuInDatabase);
        List<MenuModel> dataFromServiceCall = menuService.findAllMenuByIdRestoran(1L);
        assertEquals(3, dataFromServiceCall.size());
        verify(menuDb, times(1)).findByRestoranIdRestoran(1L);

    }

    @Test
    public void whenGetMenuByIdCalledByExistingDataItShouldReturnCorrectData() {
        MenuModel returnedData = new MenuModel();
        returnedData.setNama("ayam");
        returnedData.setDeskripsi("Ayam goreng kentucky");
        returnedData.setId((long)1);
        returnedData.setHarga(BigInteger.valueOf(10000));
        returnedData.setDurasiMasak(10);
        when(menuService.findMenuById(1L)).thenReturn(Optional.of(returnedData));
        Optional<MenuModel> dataFromServiceCall =
                menuService.findMenuById(1L);
        verify(menuDb, times(1)).findById(1L);
        assertTrue(dataFromServiceCall.isPresent());
        MenuModel dataFromOptional = dataFromServiceCall.get();
        assertEquals("ayam", dataFromOptional.getNama());
        assertEquals("Ayam goreng kentucky", dataFromOptional.getDeskripsi());
        assertEquals(Long.valueOf(1), dataFromOptional.getId());
        assertEquals(BigInteger.valueOf(10000), dataFromOptional.getHarga());
        assertEquals(Integer.valueOf(10), dataFromOptional.getDurasiMasak());
    }

    @Test
    public void whenChangeMenuCalledItShouldChangeMenuData() {
        MenuModel updatedData = new MenuModel();
        updatedData.setNama("ayam");
        updatedData.setDeskripsi("ayam bakar");
        updatedData.setId((long)1);
        updatedData.setHarga(BigInteger.valueOf(10000));
        updatedData.setDurasiMasak(10);
        when(menuService.findMenuById(1L)).thenReturn(Optional.of(updatedData));
        when(menuService.changeMenu(updatedData)).thenReturn(updatedData);
        MenuModel dataFromServicefCall = menuService.changeMenu(updatedData);
        assertEquals("ayam", dataFromServicefCall.getNama());
        assertEquals("ayam bakar", dataFromServicefCall.getDeskripsi());
        assertEquals(Long.valueOf(1), dataFromServicefCall.getId());
        assertEquals(BigInteger.valueOf(10000), dataFromServicefCall.getHarga());
        assertEquals(Integer.valueOf(10), dataFromServicefCall.getDurasiMasak());
    }

    @Test
    public void whenDeleteMenuItShouldCallMenuRepositoryRemove() {
        MenuModel newMenu = new MenuModel();
        newMenu.setNama("tempe");
        newMenu.setHarga(BigInteger.valueOf(10000));
        newMenu.setDurasiMasak(10);
        newMenu.setDeskripsi("tempe goreng lezat");
        menuService.deleteMenu(newMenu);
        verify(menuDb, times(1)).delete(newMenu);
    }
}
