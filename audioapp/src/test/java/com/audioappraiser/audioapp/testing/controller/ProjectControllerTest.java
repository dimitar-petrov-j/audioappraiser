package com.audioappraiser.audioapp.testing.controller;

import static com.audioappraiser.audioapp.model.AlbumType.ALBUM;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notANumber;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.*;

import com.audioappraiser.audioapp.controller.AudioappController;
import com.audioappraiser.audioapp.creationreqs.ProjectCreationRequest;
import com.audioappraiser.audioapp.model.Project;
import com.audioappraiser.audioapp.modelrepos.ArtistRepository;
import com.audioappraiser.audioapp.modelrepos.ProjectRepository;
import com.audioappraiser.audioapp.modelrepos.RoleRepository;
import com.audioappraiser.audioapp.modelrepos.UserRepository;
import com.audioappraiser.audioapp.service.AudioappService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(value = AudioappController.class,  excludeAutoConfiguration = SecurityAutoConfiguration.class)
public class ProjectControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private AudioappService service;

    @MockBean
    private ProjectRepository projectRepository;

    @MockBean
    private ArtistRepository artistRepository;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private RoleRepository roleRepository;

    @MockBean
    private ProjectCreationRequest projectCreationRequest;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void givenProjects_whenGetProjects_thenStatus200() throws Exception{
        Project project = new Project();

        List<Project> allProjects = Arrays.asList(project);

        given(service.readAllProjects()).willReturn(allProjects);

        mvc.perform(get("/api/projects")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(1)))
            .andExpect(jsonPath("$[0].name", is(project.getName())));
    }
}
