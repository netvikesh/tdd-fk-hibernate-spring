package net.vikesh.fk.web.component;

import com.google.common.collect.Lists;
import net.vikesh.fk.entity.component.NavBar;
import net.vikesh.fk.service.NavBarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * Created by vikes on 04-07-2017.
 */
@Controller
@RequestMapping(path = "/components/")
public class NavBarComponentController {

    @Resource
    private NavBarService navBarService;

    @RequestMapping(method = RequestMethod.GET, path = "navbar", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<Object> getNavBar() {
        ArrayList<NavBar> navBars = Lists.newArrayList(navBarService.getNavBar());
        return new ResponseEntity<>(navBars, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = "navbar", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<Object> saveSaveBar(@RequestBody NavBar navBar) {
        return new ResponseEntity<>(navBarService.saveNavBar(navBar), HttpStatus.OK);
    }
}
