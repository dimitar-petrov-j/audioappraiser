package com.audioappraiser.audioapp.controller;

import com.audioappraiser.audioapp.AudioappService;

import com.audioappraiser.audioapp.creation_reqs.ArtistCreationRequest;
import com.audioappraiser.audioapp.creation_reqs.ProjectCreationRequest;
import com.audioappraiser.audioapp.model.Project;
import com.audioappraiser.audioapp.model.Artist;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class AudioappController {
    private final AudioappService audioappService;

    //Projects CRUD
    @GetMapping("/projects")
        public ResponseEntity readProjects(@RequestParam(required = false) Long id){
        if(id == null) {
            return ResponseEntity.ok(audioappService.readAllProjects());
        }
        return ResponseEntity.ok(audioappService.readArtist(id));
    }

    @GetMapping("/projects/{projectId}")
    public ResponseEntity<Project> readProject (@PathVariable Long projectId) {
        return ResponseEntity.ok(audioappService.readProject(projectId));
    }

    @PostMapping("/projects")
    public ResponseEntity<Project> createProject (@RequestBody ProjectCreationRequest request) {
        return ResponseEntity.ok(audioappService.createProject(request));
    }

    @DeleteMapping("/projects/{projectId}")
    public ResponseEntity<Void> deleteProject (@PathVariable Long projectId) {
        audioappService.deleteProject(projectId);
        return ResponseEntity.ok().build();
    }

    //Artists CRUD
    @GetMapping("/artists")
    public ResponseEntity readArtists(@RequestParam(required = false) Long id){
        if(id == null) {
            return ResponseEntity.ok(audioappService.readAllArtists());
        }
        return ResponseEntity.ok(audioappService.readArtist(id));
    }

    @GetMapping("/artists/{aritistId}")
    public ResponseEntity<Artist> readArtist (@PathVariable Long artistId) {
        return ResponseEntity.ok(audioappService.readArtist(artistId));
    }

    @PostMapping("/artists")
    public ResponseEntity<Artist> createArtist (@RequestBody ArtistCreationRequest request) {
        return ResponseEntity.ok(audioappService.createArtist(request));
    }

    @DeleteMapping("/artists/{artistId}")
    public ResponseEntity<Void> deleteArtist (@PathVariable Long artistId) {
        audioappService.deleteArtist(artistId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/projects-javaconfig")
    public ResponseEntity<Project> createProjectWithJavaConfig (@RequestBody ProjectCreationRequest request) {
        return ResponseEntity.ok(audioappService.createProject(request));
    }

    @GetMapping("/projects-rating")
    public ResponseEntity readProjectsByRating(@RequestParam(required = false) Long id){
            return ResponseEntity.ok(audioappService.readAllProjectsByRating());

    }
}
