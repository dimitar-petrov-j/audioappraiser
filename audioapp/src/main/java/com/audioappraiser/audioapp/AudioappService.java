package com.audioappraiser.audioapp;

import com.audioappraiser.audioapp.creationreqs.*;
import com.audioappraiser.audioapp.modelrepos.*;
import com.audioappraiser.audioapp.model.*;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AudioappService {

    private final ArtistRepository artistRepository;
    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;


    //SELECT/READ METHODS START
    public Artist readArtist(Long id)
    {
        Optional<Artist> artist = artistRepository.findById(id);
        if(artist.isPresent()) return artist.get();
        throw new EntityNotFoundException("Artist with this id not found");
    }

    public List<Artist> readAllArtists(){
        return artistRepository.findAll();
    }

    public Project readProject(Long id)
    {
        Optional<Project> project = projectRepository.findById(id);
        if(project.isPresent()) return project.get();
        throw new EntityNotFoundException("Project with this id not found");
    }

    public List<Project> readAllProjects(){
        return projectRepository.findAll();
    }

    public List<Project> readAllProjectsByRating(){
        List<Project> projects = projectRepository.findAllByOrderByRatingDesc();
        return projects;
    }

    public User readUser(Long id)
    {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()) return user.get();
        throw new EntityNotFoundException("User with this id not found");
    }

    public List<User> readAllUsers(){
        return userRepository.findAll();
    }
    //SELECT/READ METHODS END

    //CREATE METHODS START
    public Project createProject(ProjectCreationRequest project) {
        Optional<Artist> artist = artistRepository.findById(project.getArtist_id());
        if (!artist.isPresent()) {
            throw new EntityNotFoundException("Artist Not Found");
        }
        Project projectToCreate = new Project();
        BeanUtils.copyProperties(project, projectToCreate);
        projectToCreate.setArtist(artist.get().toString());
        return projectRepository.save(projectToCreate);
    }

    public Artist createArtist(ArtistCreationRequest artist) {
        Artist artistToCreate = new Artist();
        BeanUtils.copyProperties(artist, artistToCreate);
        return artistRepository.save(artistToCreate);
    }
    //CREATE METHODS END

    //DELETE METHODS START
    public void deleteProject(Long id){
        projectRepository.deleteById(id);
    }

    public void deleteArtist(Long id){
        artistRepository.deleteById(id);
    }
}

