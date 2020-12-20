/* eslint react/prop-types: 0 */
import React, {useState} from "react";
import "./App.css";


function HomeAlbumContent(props)
{
    console.log(props);

    const [content] = useState([props.content]);

    function goToAlbumDetail(){
      //VERY SHODDY WAY OF REDIRECTING - LOOK FOR STH ELSE
      let change_initial = window.location.href;
      let change_replace_1 = change_initial.replace(/charts/g, "content");
      let change = change_replace_1.replace(/search/, "content");
      change = change + "/" + content[0].id;
      console.log(change);
      window.location.href= change;
    }

    return(
    <div className="img-wrapper album-card" onClick={goToAlbumDetail}>
			<img className="image-area" src={content[0].img} alt="Album"/>
			<h2>{content[0].name}</h2>
			<ul>
        <li><a>Nº{content[0].place}</a></li>
        <li><a>{content[0].rating}</a></li>
			</ul>
		</div>
    );
}

export default HomeAlbumContent;

/* <Card className='album-card'>
<Card.Img variant="top" src="holder.js/100px180" />
  <Card.Body >
      <Card.Title>Nº{props.album.place}<br/>{props.album.name}</Card.Title>
        <Card.Text>
        By {props.album.artist}. <br/> Released {props.album.releasedate} <br/>
        Rating: {props.album.rating}/5
        </Card.Text>
      <Button variant="primary">Check Details</Button>
  </Card.Body>
</Card> */