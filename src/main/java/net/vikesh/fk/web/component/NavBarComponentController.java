package net.vikesh.fk.web.component;

import net.vikesh.fk.entity.component.NavBar;
import net.vikesh.fk.repository.NavBarRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vikes on 04-07-2017.
 */
@Controller
@RequestMapping(path = "/components/")
public class NavBarComponentController {

    @Resource
    private NavBarRepository navBarRepository;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getNavBar() {
        Iterable<NavBar> allNavBars = navBarRepository.findAll();
        List<NavBar> navBars = new ArrayList<>(1);
        allNavBars.forEach(navBar -> {
            navBars.add(navBar);
        });
        return new ResponseEntity<>(navBars, HttpStatus.OK);
    }
}
