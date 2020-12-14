package com.audioappraiser.audioapp.modelrepos;

import com.audioappraiser.audioapp.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
//import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository  extends JpaRepository<Project, Long> {
    public List<Project> findAllByOrderByRatingDesc();
}
