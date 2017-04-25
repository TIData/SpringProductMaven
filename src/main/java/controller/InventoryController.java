
package controller;

import domain.Product;
import domain.ProductManager;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author sebastiaan
 */
@Controller
@RequestMapping("/inventory")
public class InventoryController {
    
    @Autowired
    private ProductManager productManager;
    
    @ModelAttribute("productList")
    public List<Product> populateProducts() {
        return productManager.getProducts();
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String productOverview(Model model) {
        return "productOverview";
    }
    
}
