import React, { useState, useEffect } from "react";
import { Component } from "react";
// import logo from "./logo.svg";

function Search() {
  const [album, setAlbum] = useState("");
  const [artist, setArtist] = useState("");

  return (
    <div className="App">
      <h1>Album Search</h1>

      <label name="artist">Artist:</label>
      <input
        type="text"
        id="artistText"
        name="artistText"
        value={artist}
        onChange={(e) => setArtist(e.target.value)}
      />
      <br />

      <label name="album">Album:</label>
      <input
        type="text"
        id="albumText"
        name="albumText"
        value={album}
        onChange={(e) => setAlbum(e.target.value)}
      />
      <br />

      <input
        type="button"
        id="amazoncom"
        name="amazoncom"
        value="amazon.com"
        onClick={(e) => handleAmazonComSearch(artist, album)}
      />
      <input
        type="button"
        id="amazonnl"
        name="amazonnl"
        value="amazon.nl"
        onClick={(e) => handleAmazonNLSearch(artist, album)}
      />
      <input
        type="button"
        id="ebaycom"
        name="ebaycom"
        value="ebay.com"
        onClick={(e) => handleEbayComSearch(artist, album)}
      />
    </div>
  );

  function handleAmazonComSearch(artist, album) {
    // console.log(album);
    // console.log(artist);

    const url =
      "https://www.amazon.com/s?k=" +
      artist.replace(/ /g, "+") +
      "+" +
      album.replace(/ /g, "+") +
      "&i=popular";
    window.location.href = url;

    // console.log(url);
  }

  function handleAmazonNLSearch(artist, album) {
    // console.log(album);
    // console.log(artist);

    const url =
      "https://www.amazon.nl/s?k=" +
      artist.replace(/ /g, "+") +
      "+" +
      album.replace(/ /g, "+") +
      "&i=popular";
    window.location.href = url;

    // console.log(url);
  }

  function handleEbayComSearch(artist, album) {
    // console.log(album);
    // console.log(artist);

    const url =
      "https://www.ebay.com/sch/i.html?_from=R40&_trksid=p2334524.m570.l1311&_nkw=" +
      artist.replace(/ /g, "+") +
      "+" +
      album.replace(/ /g, "+") +
      "&_sacat=0&LH_TitleDesc=0&_osacat=0&_odkw=" +
      artist.replace(/ /g, "+") +
      "+" +
      album.replace(/ /g, "+");
    window.location.href = url;

    // console.log(url);
  }
}

export default Search;
