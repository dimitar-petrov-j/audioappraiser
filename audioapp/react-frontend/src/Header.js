import React from "react";
import "./App.css";
import Navbar from "react-bootstrap/Navbar";
import Nav from "react-bootstrap/Nav";
import {Link, withRouter} from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";

function Header()
{
    return(
        // <div class="header">
        //     {/* <a class="App-title">AudioAppraiser</a> */}
        //     <img className="App-logo" src="https://i.imgur.com/n9H3tSh.png" />
        //     <Link to="/">Home</Link>
        //     <Link class="active" to="/charts">Charts</Link>
        //     <Link class="right" to="/account">Account <i class="fa fa-user"/></Link>
        // </div>

        <Navbar bg="dark" variant="dark" expand="lg">
          <Navbar.Brand to="/">AudioAppraiser</Navbar.Brand>
          <Navbar.Toggle aria-controls="basic-navbar-nav" />
          <Navbar.Collapse id="basic-navbar-nav">
            <Nav className="mr-auto">
              <Nav.Link as={Link} to="/">Home</Nav.Link>
              <Nav.Link as={Link} to="/charts">Charts</Nav.Link>
              <Nav.Link as={Link} to="/search">Search</Nav.Link>
              <Nav.Link as={Link} class="right" to="/account">Account</Nav.Link>
            </Nav>
          </Navbar.Collapse>
      </Navbar>
    );
}

export default Header;

/* <Navbar collapseOnSelect expand="lg" bg="dark" variant="dark">
                        <img className="App-logo" src="https://i.imgur.com/n9H3tSh.png" />

  <Navbar.Brand to="/">AudioAppraiser</Navbar.Brand>
  <Navbar.Toggle aria-controls="responsive-navbar-nav" />
  <Navbar.Collapse id="responsive-navbar-nav">
    <Nav className="mr-auto">
      <Nav.Link to="/charts">Charts</Nav.Link>
    </Nav>
    <Nav>
      <Nav.Link to="/account">Account <i class="fa fa-user"/></Nav.Link>
    </Nav>
  </Navbar.Collapse>
  <br/>
</Navbar> */