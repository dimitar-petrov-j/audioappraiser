/* eslint react/prop-types: 0 */
import React, {useState} from "react";
import "./App.css";


function HomeAlbumContent(props)
{
    console.log(props);

    const [content] = useState([props.content]);

    function goToAlbumDetail(){
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
