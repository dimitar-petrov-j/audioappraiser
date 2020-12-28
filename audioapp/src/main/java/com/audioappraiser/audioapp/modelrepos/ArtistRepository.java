package com.audioappraiser.audioapp.modelrepos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.audioappraiser.audioapp.model.Artist;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {
}
