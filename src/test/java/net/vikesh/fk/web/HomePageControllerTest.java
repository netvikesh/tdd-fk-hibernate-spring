package net.vikesh.fk.web;

import net.vikesh.fk.config.WebApplicationConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author Vikesh
 */
@ContextConfiguration(classes = {WebApplicationConfiguration.class})
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class HomePageControllerTest extends AbstractControllerTest {

    @InjectMocks
    private HomePageController homePageController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        super.setupMocMvc(homePageController);
    }

    @Test
    public void statusIs200() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(forwardedUrl("/WEB-INF/views/index.jsp"));
    }

}
