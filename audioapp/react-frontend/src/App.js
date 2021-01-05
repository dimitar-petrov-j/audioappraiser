import React, {Component} from "react";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import Header from "./Components/Header.js";
import {Home, Charts, ProjectPage, Search, Register} from "./Pages/components.js";
// import { Link, withRouter } from "react-router-dom";
// import CardDeck from "react-bootstrap/CardDeck;"
import "./App.css";
import CreateContent from "./Pages/CreateContent.jsx";

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
                        <Route path="/search" exact component={()=> <Search/>} />
                        <Route path="/content" component={() => <ProjectPage/>}/>
                        <Route path="/createcontent" component={() => <CreateContent/>}/>
                        <Route path="/register" exact component={()=><Register/>} />
                    </Switch>
                </Router>
            </div>
        );
    }
}

export default App;