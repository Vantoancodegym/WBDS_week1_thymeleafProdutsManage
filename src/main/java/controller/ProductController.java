package controller;

import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.ProductService;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("")
    public ModelAndView showAll(){
        ModelAndView modelAndView=new ModelAndView("showAll");
        List<Product> list=productService.findAll();
        modelAndView.addObject("list",list);
        return modelAndView;
    }
    @GetMapping("create")
    public ModelAndView showFormCreate(){
        ModelAndView modelAndView=new ModelAndView("create");
        modelAndView.addObject("product",new Product());
        return modelAndView;
    }
    @PostMapping("create")
     public ModelAndView create(@ModelAttribute Product product){
        int id=(int) (Math.random()*10000);
        product.setId(id);
        productService.save(product);
        return new ModelAndView("redirect:/products");
    }
    @GetMapping("edit")
    public ModelAndView showFormEdit(@RequestParam int id){
        ModelAndView modelAndView=new ModelAndView("edit");
        Product product=productService.findById(id);
        modelAndView.addObject("product",product);
        return modelAndView;
    }
    @PostMapping("edit")
    public ModelAndView edit(@RequestParam int id, Product product){
        product.setId(id);
        productService.update(id,product);
        return new ModelAndView("redirect:/products");
    }
    @GetMapping("delete")
    public ModelAndView edit(@RequestParam int id){
        productService.remove(id);
        return new ModelAndView("redirect:/products");
    }
    @PostMapping("find")
    public ModelAndView find(@RequestParam int id){
        ModelAndView modelAndView=new ModelAndView("result");
        Product product= productService.findById(id);
        modelAndView.addObject("product",product);
        return modelAndView;

    }

}
