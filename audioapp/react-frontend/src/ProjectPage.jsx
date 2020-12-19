import React, { useState, useEffect} from "react";
import "./App.css";
import ProjectService from "./services/ProjectService.js";
import "bootstrap/dist/css/bootstrap.min.css";
import Jumbotron from "react-bootstrap/Jumbotron";



function ProjectPage(){

    const [album, readyAlbum] = useState([]);

    useEffect(() => {

        //take value of id
        const value = window.location.href[window.location.href.length-1];

        console.log(value);


        ProjectService.getProjectById(value).then((response) => {
            readyAlbum(response.data);
        });

    }, []);

    return(
        <Jumbotron>
            <p>Name: {album.name}</p>
            <p>Artist: {album.artist}</p>
            <p>Score: {album.rating}</p>
        </Jumbotron>
    );
}

export default ProjectPage;