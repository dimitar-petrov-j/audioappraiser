package com.audioappraiser.audioapp.modelrepos.primary;

import org.springframework.data.jpa.repository.JpaRepository;
import com.audioappraiser.audioapp.model.primary.Artist;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {
    public Artist findByName(String name);
}
