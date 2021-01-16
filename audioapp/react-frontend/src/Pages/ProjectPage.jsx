import React, { useState, useEffect} from "react";
import "../App.css";
import ProjectService from "../services/ProjectService.js";
import "bootstrap/dist/css/bootstrap.min.css";
import Jumbotron from "react-bootstrap/Jumbotron";
import Button from "react-bootstrap/Button";



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

    function handleAmazonComSearch(){
        const url =
        "https://www.amazon.com/s?k=" +
        album.artist.replace(/ /g, "+") +
        "+" +
        album.name.replace(/ /g, "+") +
        "&i=popular";
        window.location.href = url;
    }

    function handleAmazonNLSearch(){
        const url =
        "https://www.amazon.nl/s?k=" +
        album.artist.replace(/ /g, "+") +
        "+" +
        album.name.replace(/ /g, "+") +
        "&i=popular";
        window.location.href = url;
    }


    function handleEbayComSearch(){
        const url =
        "https://www.ebay.com/sch/i.html?_from=R40&_trksid=p2334524.m570.l1311&_nkw=" +
        album.artist.replace(/ /g, "+") +
        "+" +
        album.name.replace(/ /g, "+") +
        "&_sacat=0&LH_TitleDesc=0&_osacat=0&_odkw=" +
        album.artist.replace(/ /g, "+") +
        "+" +
        album.name.replace(/ /g, "+");
        window.location.href = url;
    }


    return(
        <Jumbotron className="jumbotron-albumpage">
            <img className="img-albumpage-wrapper" src="https://e.snmc.io/i/fullres/s/ead2038df1155061252970b1c96bf24f/7125159"/><br/>
            <div className="right-albumpage">
                <p>Name: {album.name}</p>
                <p>Artist: {album.artist}</p>
                <p>Score: {album.rating}</p>
                <Button onClick={handleAmazonComSearch} className="button-albumpage">Find in amazon.com</Button>
                <Button onClick={handleAmazonNLSearch} className="button-albumpage">Find in amazon.nl</Button>
                <Button onClick={handleEbayComSearch} className="button-albumpage">Find in ebay.com</Button>
            </div>

        </Jumbotron>
    );
}

export default ProjectPage;