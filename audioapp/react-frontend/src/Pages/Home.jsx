import React from "react";
// import ProjectService from "./services/ProjectService.js";
import "../App.css";
import "bootstrap/dist/css/bootstrap.min.css";
import Jumbotron from "react-bootstrap/Jumbotron";
import Card from "react-bootstrap/Card";
import CardDeck from "react-bootstrap/CardDeck";
import Button from "react-bootstrap/Button";
import Toast from "react-bootstrap/Toast";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import Carousel from "react-bootstrap/Carousel";



function Home(){
    return(
        <Jumbotron>
        <Carousel>
        <Carousel.Item interval={5000}>
            <img
            className="d-block w-100 h-75 slider"
            src="https://i.imgur.com/WFZX95f.jpg"
            alt="First slide" fluid 
            />
            <Carousel.Caption>
            <h3>First slide label</h3>
            <p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p>
            </Carousel.Caption>
        </Carousel.Item>
        <Carousel.Item interval={5000}>
            <img
            className="d-block w-100"
            src="https://i.imgur.com/pLvM4jP.jpg" fluid
            alt="Third slide"
            />
            <Carousel.Caption>
            <h3>Second slide label</h3>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
            </Carousel.Caption>
        </Carousel.Item>
        <Carousel.Item interval={5000}>
            <img
            className="d-block w-100"
            src="https://i.imgur.com/ZNlQMSS.jpg" fluid
            alt="Third slide"
            />
            <Carousel.Caption>
            <h3>Third slide label</h3>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
            </Carousel.Caption>
        </Carousel.Item>
        </Carousel>
        <br/>
        <CardDeck>
            <Card>
                <Card.Img variant="top" src="https://i.imgur.com/mXbgxpv.png" />
                <Card.Body>
                <Card.Title>Card title</Card.Title>
                <Card.Text>
                    This is a wider card with supporting text below as a natural lead-in to
                    additional content. This content is a little bit longer.
                </Card.Text>
                </Card.Body>
                <Card.Footer>
                <small className="text-muted">Last updated 3 mins ago</small>
                </Card.Footer>
            </Card>
            <Card>
                <Card.Img variant="top" src="https://i.imgur.com/uTnv8uB.png" />
                <Card.Body>
                <Card.Title>Card title</Card.Title>
                <Card.Text>
                    This card has supporting text below as a natural lead-in to additional
                    content.{" "}
                </Card.Text>
                </Card.Body>
                <Card.Footer>
                <small className="text-muted">Last updated 3 mins ago</small>
                </Card.Footer>
            </Card>
            <Card>
                <Card.Img variant="top" src="https://images.genius.com/68e3682f2d9128cfc55576414a571a2b.1000x563x1.jpg" />
                <Card.Body>
                <Card.Title>Card title</Card.Title>
                <Card.Text>
                    This is a wider card with supporting text below as a natural lead-in to
                    additional content. This card has even longer content than the first to
                    show that equal height action.
                </Card.Text>
                </Card.Body>
                <Card.Footer>
                <small className="text-muted">Last updated 3 mins ago</small>
                </Card.Footer>
            </Card>
            <Card>
                <Card.Img variant="top" src="https://i.redd.it/wbrp565sxje11.png" />
                <Card.Body>
                <Card.Title>Card title</Card.Title>
                <Card.Text>
                    This is a wider card with supporting text below as a natural lead-in to
                    additional content. This card has even longer content than the first to
                    show that equal height action.
                </Card.Text>
                </Card.Body>
                <Card.Footer>
                <small className="text-muted">Last updated 3 mins ago</small>
                </Card.Footer>
            </Card>
            </CardDeck>
            <br/>
        <br/>
        <Row>
            <Col><Card >
                <Card.Img variant="top" src="https://i.imgur.com/e4ulAHT.jpg" />
                <Card.Body>
                    <Card.Title>Card Title</Card.Title>
                    <Card.Text>
                    Some quick example text to build on the card title and make up the bulk of
                    the card&apos;s content. {" "}
                    </Card.Text>
                    <Button variant="primary">Review</Button>
                </Card.Body>
            </Card></Col>
            <Col><Toast>
            <Toast.Header>
            <img src="holder.js/20x20?text=%20" className="rounded mr-2" alt="" />
            <strong className="mr-auto">Bootstrap</strong>
            </Toast.Header>
            <Toast.Body>See? Just like this.</Toast.Body>
        </Toast>
        <Toast>
            <Toast.Header>
            <img src="holder.js/20x20?text=%20" className="rounded mr-2" alt="" />
            <strong className="mr-auto">Bootstrap</strong>
            </Toast.Header>
            <Toast.Body>Heads up, toasts will stack automatically</Toast.Body>
        </Toast>
        <Toast>
            <Toast.Header>
            <img src="holder.js/20x20?text=%20" className="rounded mr-2" alt="" />
            <strong className="mr-auto">Bootstrap</strong>
            </Toast.Header>
            <Toast.Body>Heads up, toasts will stack automatically</Toast.Body>
        </Toast>
        <Toast>
            <Toast.Header>
            <img src="holder.js/20x20?text=%20" className="rounded mr-2" alt="" />
            <strong className="mr-auto">Bootstrap</strong>
            </Toast.Header>
            <Toast.Body>Heads up, toasts will stack automatically</Toast.Body>
        </Toast>
        <Toast>
            <Toast.Header>
            <img src="holder.js/20x20?text=%20" className="rounded mr-2" alt="" />
            <strong className="mr-auto">Bootstrap</strong>
            </Toast.Header>
            <Toast.Body>Heads up, toasts will stack automatically</Toast.Body>
        </Toast></Col>
            <Col>3 of 3</Col>
        </Row>

        <br/>
        <Card className="bg-dark text-white">
        <Card.Img src="https://i.imgur.com/L0Np4gM.jpg" alt="Card image" />
        <Card.ImgOverlay>
            <br/>
            <Card.Text>
            Welcome to AudioAppraiser! A public database for musical artists and commercial musical projects!
            </Card.Text>
            <Card.Text>Currently storing 1 424 348 Artists , 4 394 470 Releases, 113 772 Labels, 79 785 111 Ratings, 2 499 210 Reviews</Card.Text>
        </Card.ImgOverlay>
        </Card>
        <br/>
        
        <img className="home-intro-content-img" src="https://i.imgur.com/n9H3tSh.png" />
        </Jumbotron>
    );
}

export default Home;