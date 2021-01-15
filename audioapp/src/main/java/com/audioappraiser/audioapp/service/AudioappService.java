package com.audioappraiser.audioapp.service;

import com.audioappraiser.audioapp.creationreqs.*;
import com.audioappraiser.audioapp.model.primary.Artist;
import com.audioappraiser.audioapp.model.primary.Project;
import com.audioappraiser.audioapp.model.secondary.User;

import com.audioappraiser.audioapp.modelrepos.primary.ArtistRepository;
import com.audioappraiser.audioapp.modelrepos.primary.ProjectRepository;
import com.audioappraiser.audioapp.modelrepos.secondary.RoleRepository;
import com.audioappraiser.audioapp.modelrepos.secondary.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.BeanUtils;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.sql.DataSource;

@Service
@RequiredArgsConstructor
public class AudioappService {

    private final ArtistRepository artistRepository;
    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

//    @Autowired
//    @Qualifier("primaryDataSource")
//    private final DataSource primaryDataSource;
//
//    @Autowired
//    @Qualifier("secondaryDataSource")
//    private final DataSource secondaryDataSource;

    @Autowired
    private final EntityManagerFactory entityManagerFactory;

//        private PasswordEncoder encoder(){
//            return new PasswordEncoder() {
//                @Override
//                public String encode(CharSequence rawPassword) {
//                    return null;
//                }
//
//                @Override
//                public boolean matches(CharSequence rawPassword, String encodedPassword) {
//                    return false;
//                }
//            };
//        }


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

    public List<Project> readProjectsBySearch(String name){
        List<Project> projectsWithNameMatch = projectRepository.findAllByArtistContainingOrNameContaining(name, name);
        return projectsWithNameMatch;
    }

    public User readUserById(Long id)
    {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()) return user.get();
        throw new EntityNotFoundException("User with this id not found");
    }

    public User readUser(String username, String password){
        Optional<User> foundUser = userRepository.findByUsernameAndPassword(username, password);
        if(!foundUser.isPresent()){
            throw new EntityNotFoundException("User Not Found");
        }
        return foundUser.get();
    }

    public List<User> readAllUsers(){
        return userRepository.findAll();
    }
    //SELECT/READ METHODS END

    //CREATE METHODS START
    public Project createProject(ProjectCreationRequest project) {
        Project projectToCreate = new Project();
        BeanUtils.copyProperties(project, projectToCreate);
        return projectRepository.save(projectToCreate);
    }

    public Project createProjectWithArtist(ProjectCreationRequest project) {
        Artist artist = artistRepository.findByName(project.getArtist());
        if (artist == null) {
            throw new EntityNotFoundException("Artist Not Found");
        }
        Project projectToCreate = new Project();
        BeanUtils.copyProperties(project, projectToCreate);
        projectToCreate.setArtist(artist.getName().toString());
        return projectRepository.save(projectToCreate);
    }

    public Artist createArtist(ArtistCreationRequest artist) {
        Artist artistToCreate = new Artist();
        BeanUtils.copyProperties(artist, artistToCreate);
        return artistRepository.save(artistToCreate);
    }

    public User createUser(UserCreationRequest user){
        User userToCreate = new User();

        BeanUtils.copyProperties(user, userToCreate);
        return userRepository.save(userToCreate);
    }
    //CREATE METHODS END

    //DELETE METHODS START
    public void deleteProject(Long id){
        projectRepository.deleteById(id);
    }

    public void deleteArtist(Long id){
        artistRepository.deleteById(id);
    }
    //DELETE METHODS END
}