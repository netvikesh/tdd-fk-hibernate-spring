package net.vikesh.fk.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Vikesh
 */
@Controller
@RequestMapping(path = "/")
public class HomePageController {

    @RequestMapping(method = RequestMethod.GET)
    public String homePage() {
        return "index";
    }
}
