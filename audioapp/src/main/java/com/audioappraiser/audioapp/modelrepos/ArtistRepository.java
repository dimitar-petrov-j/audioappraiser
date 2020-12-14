package com.audioappraiser.audioapp.modelrepos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.audioappraiser.audioapp.model.Artist;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
}
