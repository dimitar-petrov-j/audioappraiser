import React from "react";
import { cleanup } from "@testing-library/react";
import ShallowRenderer from "react-test-renderer/shallow";
import HomeAlbumContent from "../src/HomeAlbumContent";


afterEach(cleanup);

function HomeAlbumContent({props})
{
    console.log(props);

    const [content] = React.useState([props.content]);

    return(
    <div className="img-wrapper album-card" onClick={goToAlbumDetail}>
			<h2>{content[0].name}</h2>
			<ul>
        <li><a>Nº{content[0].place}</a></li>
        <li><a>{content[0].rating}</a></li>
			</ul>
		</div>
    );
}

export default HomeAlbumContent;