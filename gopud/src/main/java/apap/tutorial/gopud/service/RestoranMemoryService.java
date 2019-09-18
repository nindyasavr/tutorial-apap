package apap.tutorial.gopud.service;

import apap.tutorial.gopud.model.RestoranModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestoranMemoryService implements RestoranService {
    private List<RestoranModel> listRestoran;
    public RestoranMemoryService() {
        listRestoran = new ArrayList<>();
    }

    @Override
    public void addRestoran(RestoranModel restoran) {
        listRestoran.add(restoran);
    }

    @Override
    public List<RestoranModel> getRestoranList() {
        return listRestoran;
    }


    @Override
    public RestoranModel getRestoranByIdRestoran(String idRestoran) {
        //RestoranModel theResto = null;
        for (int i = 0; i < getRestoranList().size(); i++) {
            String id = getRestoranList().get(i).getIdRestoran();
            if (id.equals(idRestoran)) {
                return getRestoranList().get(i);
            }
        } return null;
    }

}
