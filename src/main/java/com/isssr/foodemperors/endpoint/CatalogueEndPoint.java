package com.isssr.foodemperors.endpoint;

import com.isssr.foodemperors.model.Catalogue;
import com.isssr.foodemperors.service.CatalogueService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.isssr.foodemperors.repository.CatalogueRepository;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by simone on 09/06/17.
 */
@RestController
@CrossOrigin(origins = "*")
public class CatalogueEndPoint {

    @Inject
    private CatalogueService catalogueService;

    @RequestMapping(path = "api/catalogue", method = RequestMethod.GET)
    public List<Catalogue> getCatalogue() {
        return catalogueService.getCatalogue();
    }
}
