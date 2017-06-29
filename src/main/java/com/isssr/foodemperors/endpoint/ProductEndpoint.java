package com.isssr.foodemperors.endpoint;

import com.isssr.foodemperors.model.Product;
import com.isssr.foodemperors.repository.ProductRepository;
import com.isssr.foodemperors.service.ProductService;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by mariusdragosionita on 23/05/17.
 */
@RestController
@CrossOrigin(origins = "*")
public class ProductEndpoint {

    @Inject
    private ProductRepository productRepository;

    @Inject
    private ProductService productService;


    @RequestMapping(path = "api/product/save", method = RequestMethod.POST)
    public Product saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    //TODO MERGE WITH API/PRODUCT/SAVE
    @RequestMapping(path = "api/product", method = RequestMethod.POST)
    public Product saveProduct2(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @RequestMapping(path = "api/product/findby/name/{name}", method = RequestMethod.GET)
    public List<Product> searchProduct(@PathVariable String name) {
        return productRepository.findByName(name);
    }

    @RequestMapping(path = "api/product/findby/category/properties/{strings}", method = RequestMethod.GET)
    public List<Product> searchProductByProperties(@PathVariable String strings) {
        return productService.getByCategoryAndProperties(strings);
    }

    @RequestMapping(path = "api/products", method = RequestMethod.GET)
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @RequestMapping(path = "api/product/{id}", method = RequestMethod.DELETE)
    public Long deleteProduct(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) {

        Long product =  productRepository.deleteById(id);
        if (product == 0){
            response.setStatus(404);
            return null;
        }
        return product;
    }

    @RequestMapping(path = "api/product/update", method = RequestMethod.PUT)
    public Product updateProduct(@RequestBody Product product) {
        /* La funzione save inserisce un elemento se non esiste, altrimenti lo aggiorna */
        return productRepository.save(product);
    }

    //TODO MERGE WITH API/PRODUCT/UPDATE
    @RequestMapping(path = "api/product", method = RequestMethod.PUT)
    public Product updateProduct2(@RequestBody Product product) {
        return productService.saveProduct(product);
    }


}
