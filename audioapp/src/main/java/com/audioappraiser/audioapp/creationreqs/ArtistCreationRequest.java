package com.audioappraiser.audioapp.creationreqs;

import com.audioappraiser.audioapp.model.primary.Project;
import java.util.Date;
import java.util.List;

public class ArtistCreationRequest {
    private String name;
    private String alias;
    private Date birthdate;
    private String description;
    private List<Project> projects;
}
