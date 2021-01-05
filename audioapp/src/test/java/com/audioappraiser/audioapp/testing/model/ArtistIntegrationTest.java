package com.audioappraiser.audioapp.testing.model;


import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.*;

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

import com.audioappraiser.audioapp.model.Project;
import com.audioappraiser.audioapp.model.Artist;
import com.audioappraiser.audioapp.model.AlbumType;
import com.audioappraiser.audioapp.modelrepos.ProjectRepository;
import com.audioappraiser.audioapp.modelrepos.ArtistRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ArtistIntegrationTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ArtistRepository artistRepository;

    @Test
    public void whenFindByName_thenReturnArtist(){
        //given
        Artist artist = new Artist();
        artist.setName("test artist");
        entityManager.persist(artist);
        entityManager.flush();

        //when
        Artist found = artistRepository.findByName("test artist");

        //then
        assertThat(found)
                .isEqualTo(artist);
    }
}
