import React, {Component} from 'react';
import './App.css';


function HomeAlbumContent(props)
{
    console.log(props)

    function goToAlbumDetail(){
      let change = window.location.href;
      change = change + "/" + props.content.id;
      window.location.href=change;
    }

    return(
    <div class="img-wrapper album-card" onClick={goToAlbumDetail}>
			<img class="image-area" src={props.content.img} alt="Album"/>
			<h2>{props.content.name}</h2>
			<ul>
        <li><a>Nº{props.content.place}</a></li>
        <li><a>{props.content.rating}</a></li>
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