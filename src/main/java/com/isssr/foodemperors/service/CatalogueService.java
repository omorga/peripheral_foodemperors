package com.isssr.foodemperors.service;

import com.isssr.foodemperors.model.Catalogue;
import com.isssr.foodemperors.repository.CatalogueRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Caim03 on 26/06/17.
 */

@Service
public class CatalogueService {

    @Inject
    private CatalogueRepository catalogueRepository;

    public List<Catalogue> getCatalogue() {
        return catalogueRepository.findAll();
    }
}
