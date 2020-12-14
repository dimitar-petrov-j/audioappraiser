import React from 'react';
import './App.css';
import HomeAlbumContent from "./HomeAlbumContent.js";
import 'bootstrap/dist/css/bootstrap.min.css';
import Jumbotron from 'react-bootstrap/Jumbotron';



function Home(){

    

    return(
        // <div>
        //     <div className="home-intro-content">
        //             <img className="home-intro-content-img" src="https://i.imgur.com/n9H3tSh.png" />
        //         <div className="home-intro-content-text">
        //             <p>Welcome to AudioAppraiser! A public database for musical artists and commercial musical projects!</p>
        //         </div>
        //         <br/>
        //         <p> 1,424,348 Artists, 4,394,470 Releases, 113,772 Labels, 79,785,111 Ratings, 2,499,210 Reviews </p>
        //     </div>
        //     <br/>
        //     <div>
        //         <h2 className="home-featured-review-header">Featured reviews</h2>
        //     </div>
        // </div>

        <Jumbotron>
        <img className="home-intro-content-img" src="https://i.imgur.com/n9H3tSh.png" />
        <p>
            Welcome to AudioAppraiser! A public database for musical artists and commercial musical projects!
        </p> <br/>
        <p>Currently storing 1 424 348 Artists , 4 394 470 Releases, 113 772 Labels, 79 785 111 Ratings, 2 499 210 Reviews</p>
        </Jumbotron>
    );
}

export default Home;