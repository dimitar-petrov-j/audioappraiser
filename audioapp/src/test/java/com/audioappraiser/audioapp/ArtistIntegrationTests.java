package com.audioappraiser.audioapp;


import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.audioappraiser.audioapp.model.primary.Artist;
import com.audioappraiser.audioapp.modelrepos.primary.ArtistRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ArtistIntegrationTests {
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
