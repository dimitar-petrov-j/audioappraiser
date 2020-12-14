import React, {Component} from "react";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import Header from "./Header.js";
import {Home, Charts, ProjectPage} from "./components.js";
// import { Link, withRouter } from "react-router-dom";
// import CardDeck from "react-bootstrap/CardDeck;"
import "./App.css";

class App extends Component {

    // state = {};

    // componentDidMount() {
    //     setInterval(this.hello, 250);
    // }

    // hello = () => {
    //     fetch('/api/hello')
    //         .then(response => response.text())
    //         .then(message => {
    //             this.setState({message: message});
    //         });
    // };

    render() {
        return (
            <div className="App">
                
                <Router>
                    <Header/>
                    <br/>
                    <Switch>
                        <Route path="/" exact component={()=> <Home/>} />
                        <Route path="/charts" exact component={()=> <Charts/>} />
                        {/* <Route path="/" exact component={()=> <Home/>} /> */}
                        <Route path="/content" component={() => <ProjectPage/>}/>
                    </Switch>
                </Router>
            </div>
        );
    }
}

export default App;