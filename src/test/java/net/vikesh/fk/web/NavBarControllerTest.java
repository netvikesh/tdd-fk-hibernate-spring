package net.vikesh.fk.web;

import net.vikesh.fk.config.WebApplicationConfiguration;
import net.vikesh.fk.entity.component.NavBar;
import net.vikesh.fk.repository.NavBarRepository;
import net.vikesh.fk.web.component.NavBarComponentController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
    private NavBarRepository navBarRepository;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
        super.setupMocMvc(navBarComponentController);
    }

    @Test
    public void testIsStatusOk() throws Exception {
        List<NavBar> navBars = new ArrayList<>();
        navBars.add(new NavBar());
        when(navBarRepository.findAll()).thenReturn(navBars);
        mockMvc.perform(get("/components/navbar"))
                .andExpect(status().isOk());
    }
}
