package com.audioappraiser.audioapp.modelrepos;

import com.audioappraiser.audioapp.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
//import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository  extends JpaRepository<Project, Long> {
    public List<Project> findAllByOrderByRatingDesc();

//    @Query(value = "SELECT * FROM audioappraiser_content.projects WHERE name LIKE '%:name%' OR artist LIKE '%:name%';", nativeQuery = true)
    public List<Project> findAllByArtistContainingOrNameContaining(String name, String name2);
    //@Param("name")

}
