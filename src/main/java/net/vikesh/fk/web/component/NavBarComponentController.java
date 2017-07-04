package net.vikesh.fk.web.component;

import com.google.common.collect.Lists;
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

/**
 * Created by vikes on 04-07-2017.
 */
@Controller
@RequestMapping(path = "/components/")
public class NavBarComponentController {

    @Resource
    private NavBarRepository navBarRepository;

    @RequestMapping(method = RequestMethod.GET, path = "navbar", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getNavBar() {
        ArrayList<NavBar> navBars = Lists.newArrayList(navBarRepository.findAll());
        return new ResponseEntity<>(navBars, HttpStatus.OK);
    }
}
