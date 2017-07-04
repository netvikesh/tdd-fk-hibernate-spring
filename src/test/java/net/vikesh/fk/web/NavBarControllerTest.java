package net.vikesh.fk.web;

import com.google.gson.Gson;
import net.vikesh.fk.config.WebApplicationConfiguration;
import net.vikesh.fk.entity.component.NavBar;
import net.vikesh.fk.entity.component.NavNode;
import net.vikesh.fk.service.NavBarService;
import net.vikesh.fk.web.component.NavBarComponentController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by vikes on 04-07-2017.
 */
@ContextConfiguration(classes = {WebApplicationConfiguration.class})
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class NavBarControllerTest extends AbstractControllerTest {

    @InjectMocks
    private NavBarComponentController navBarComponentController;

    @Mock
    private NavBarService navBarService;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
        super.setupMocMvc(navBarComponentController);
    }

    @Test
    public void testIsStatusOk() throws Exception {
        List<NavBar> navBars = new ArrayList<>();
        navBars.add(new NavBar());
        when(navBarService.getNavBar()).thenReturn(navBars);
        mockMvc.perform(get("/components/navbar"))
                .andExpect(status().isOk());
    }

    @Test
    public void savesNavBar() throws Exception {
        List<NavNode> navNodes = new ArrayList<>();
        NavBar navBar = new NavBar();
        navBar.setNavNodes(navNodes);

        NavNode node1 = new NavNode();
        node1.setHref("/home");
        node1.setText("Home Page");
        navNodes.add(node1);
        Gson gson = new Gson();
        final String postRequest = gson.toJson(navBar);
        mockMvc.perform(post("/components/navbar", navBar).contentType(MediaType.APPLICATION_JSON_VALUE).content(postRequest))
                .andExpect(status().isOk());
    }

}
