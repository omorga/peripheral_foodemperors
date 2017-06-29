package com.isssr.foodemperors.service;

import com.isssr.foodemperors.model.Property;
import org.springframework.stereotype.Service;
import com.isssr.foodemperors.repository.PropertyRepository;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by Caim03 on 12/06/17.
 */

@Service
public class PropertyService{

    @Inject
    private PropertyRepository propertyRepository;

    public Property saveProperty(Property property) {
        return propertyRepository.save(property);
    }

    public List<Property> searchAll() {
        return propertyRepository.findAll();
    }

    public Property searchByName(String name) {
        return propertyRepository.findById(name);
    }
}
