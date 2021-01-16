/* eslint no-unused-vars: 0 */
import React from "react";
import "../App.css";
import Navbar from "react-bootstrap/Navbar";
import Nav from "react-bootstrap/Nav";
import {Link, withRouter} from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";

function Header()
{
    return(
        <Navbar bg="dark" variant="dark" expand="lg">
          <Navbar.Brand to="/">AudioAppraiser</Navbar.Brand>
          <Navbar.Toggle aria-controls="basic-navbar-nav" />
          <Navbar.Collapse id="basic-navbar-nav">
            <Nav className="mr-auto">
              <Nav.Link as={Link} to="/">Home</Nav.Link>
              <Nav.Link as={Link} to="/charts">Charts</Nav.Link>
              <Nav.Link as={Link} to="/search">Search</Nav.Link>

              {/* <Nav.Link as={Link} to="/createcontent">Add Project/Artist</Nav.Link> */}
              {/* it is set to /register only for testing */}

              <Nav.Link as={Link} class="right" to="/register">Account</Nav.Link>
            </Nav>
          </Navbar.Collapse>
      </Navbar>
    );
}

export default Header;
