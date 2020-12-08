package gr.codehub.controller;


import gr.codehub.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ViewsController {


    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index( ) {

        return "index";
    }

    @RequestMapping(value = "views/customer", method = RequestMethod.GET)
    public String viewCustomers(Model model) {
        model.addAttribute("customers", customerService.getAllCustomers());
        return "views/list";
    }

    @RequestMapping(value = "views/addCustomer", method = RequestMethod.GET)
    public String createCustomer() {
       return "views/create";
    }


}
