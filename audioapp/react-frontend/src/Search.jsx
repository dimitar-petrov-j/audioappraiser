/* eslint no-unused-vars: 0 */
import React, { useState} from "react";
import ProjectService from "./services/ProjectService.js";
import HomeAlbumContent from "./HomeAlbumContent.js";
import InputGroup from "react-bootstrap/InputGroup";
import Button from "react-bootstrap/Button";
import FormControl from "react-bootstrap/FormControl";
import "bootstrap/dist/css/bootstrap.min.css";
import "./App.css";

function Search(){
    
    const [search, updateSearch] = useState([]);
    const [albums, readyAlbums] = useState([]);


    function handleInputChange(e){
        updateSearch(e.target.value);
    }

    function searchQuery(){
        console.log(search);

        ProjectService.getProjectBySearch(search).then((response) => {
            readyAlbums(response.data);
        });

        // return(
        //     <div className="card-deck">
        //         {console.log(albums)}
        //         {albums.map(function(album,index){
        //             return(
        //                 <HomeAlbumContent key={index}
        //                 content={{place:index+1, id:album.id, name: album.name, artist: album.artist, releasedate: album.release_date, rating: album.rating, img: "https://e.snmc.io/i/fullres/s/ead2038df1155061252970b1c96bf24f/7125159"}}
        //                 />
        //             );
        //         })}
        //     </div>
        // );
    }

    return(
        <div>
            <InputGroup className="mb-3">
                <FormControl
                placeholder="Input album name or artist"
                aria-label="Input album name or artist"
                aria-describedby="basic-addon2"
                onChange={handleInputChange}
                />
                <InputGroup.Append>
                <Button variant="outline-secondary" onClick={searchQuery}>Button</Button>
                </InputGroup.Append>
            </InputGroup>
            <br/>
            <div className="card-deck">
                 {console.log(albums)}
                 {albums.map(function(album,index){
                     return(
                         <HomeAlbumContent key={index}
                         content={{place:index+1, id:album.id, name: album.name, artist: album.artist, releasedate: album.release_date, rating: album.rating, img: "https://e.snmc.io/i/fullres/s/ead2038df1155061252970b1c96bf24f/7125159"}}
                         />
                     );
                 })}
             </div>
        </div>
    );
}

export default Search;