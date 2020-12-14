import React, { useState, useEffect} from 'react';
import HomeAlbumContent from "./HomeAlbumContent.js";
import ProjectService from "./services/ProjectService.js";
import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';

function Charts(){

    const [albums, readyAlbums] = useState([]);

    // function ProjectsRead()
    // {
    //     fetch('http://localhost:8080/api/projects')
    //         .then(response => response.text())
    //         .then(message => {
    //             PrintMessageToState(message)
    //         });
    // }

    // function PrintMessageToState(message){
    //     readyAlbums(message);
    // }

    useEffect(() => {
        ProjectService.getProjectsCharts().then((response) => {
            readyAlbums(response.data)
        });
    }, [])



    // function testProjects(){
    //     console.log(albums)
    // }

    function renderCharts(){
        
    }
    
    return(
        <div className="card-deck">
            {console.log(albums)}
            {albums.map(function(album,index){
                console.log("test")
                return(
                    <HomeAlbumContent
                    content={{place:index+1, id:album.id, name: album.name, artist: album.artist, releasedate: album.release_date, rating: album.rating, img: "https://e.snmc.io/i/fullres/s/ead2038df1155061252970b1c96bf24f/7125159"}}
                    />
                );
            })}
        </div>
    );
}

export default Charts;