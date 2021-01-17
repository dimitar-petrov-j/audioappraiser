/* eslint no-unused-vars: 0 */
import React, {useState, useRef } from "react";
import ProjectService from "../services/ProjectService";
import DatePicker from "react-datepicker";

import "../App.css";
import "bootstrap/dist/css/bootstrap.min.css";
import "react-datepicker/dist/react-datepicker.css";
import Jumbotron from "react-bootstrap/Jumbotron";
import Button from "react-bootstrap/Button";
import Alert from "react-bootstrap/Alert";
import Form from "react-bootstrap/Form";



const required = (value) => {
    if (!value) {
        return (
            <Alert variant="danger">
                This field is required!
            </Alert>
        );
    }
};

const CreateContent = (props) =>{
    const form = useRef();

    const [projectname, setProjectName] = useState("");
    const [projectartist, setProjectArtist] = useState("");
    const [projecttype, setProjectType] = useState({Album: "ALBUM", Single: "SINGLE", Mixtape: "MIXTAPE", EP: "EP"});
    const [projectdate, setProjectDate] = useState(new Date());

    const onChangeProjectName = (e) => {
        const value = e.target.value;
        setProjectName(value);
    };

    const onChangeProjectArtist = (e) => {
        const value = e.target.value;
        setProjectArtist(value);
    };

    const onChangeProjectType = (e) => {
        const value = e.target.value;
        setProjectType(value);
    };

    const handleProjectCreation = (e) => {
        e.preventDefault();

        const project = new Object({id: 10, name: projectname, artist: projectartist, type: projecttype, release_date: projectdate});

        ProjectService.createProject(project).then(
            (response) => {
                window.location.reload();
                console.log("success");
            },
            (error) => {
                console.log("error");
            }
        );
    };

    return(
        <div>
        <Jumbotron className="jumbotron-albumpage">
            <Form onSubmit={handleProjectCreation} ref={form}>
                    <div>
                        <Form.Group>
                            <Form.Label>Project Name</Form.Label>
                            <Form.Control
                                type="text"
                                className="form-control"
                                name="username"
                                value={projectname}
                                onChange={onChangeProjectName}
                                validations={[required]}
                            />
                        </Form.Group>

                        <Form.Group>
                            <Form.Label>Artist Name</Form.Label>
                            <Form.Control
                                className="form-control"
                                name="artist"
                                value={projectartist}
                                onChange={onChangeProjectArtist}
                                validations={[required]}
                            />
                        </Form.Group>

                        <Form.Group>
                            <Form.Label>Album Type</Form.Label><br/>
                                <input
                                type="radio"
                                value="ALBUM"
                                name="type"
                                className="form-check-input"
                                onClick={onChangeProjectType}
                                /> Album
                                <br/>
                                <input
                                type="radio"
                                value="SINGLE"
                                name="type"
                                className="form-check-input"
                                onClick={onChangeProjectType}
                                /> Single
                                <br/>
                                <input
                                type="radio"
                                value="EP"
                                name="type"
                                className="form-check-input"
                                onClick={onChangeProjectType}
                                /> EP
                                <br/>
                                <input
                                type="radio"
                                value="MIXTAPE"
                                name="type"
                                className="form-check-input"
                                onClick={onChangeProjectType}
                                /> Mixtape
                        </Form.Group>

                        <Form.Group controlId="formDate">
                            <DatePicker selected={projectdate} onChange={date => setProjectDate(date)} />
                        </Form.Group>

                        <div className="form-group">
                            <Button variant="primary" type="submit">Submit</Button>
                        </div>
                    </div>
            </Form>
        </Jumbotron>

        {/* <Jumbotron className="jumbotron-albumpage">
        <Form onSubmit={handleArtistCreation} ref={form}>
                    <div>
                        <Form.Group>
                            <Form.Label>Artist Name</Form.Label>
                            <Form.Control
                                type="text"
                                className="form-control"
                                name="artistname"
                                value={artistname}
                                onChange={onChangeArtistName}
                                validations={[required]}
                            />
                        </Form.Group>

                        <Form.Group>
                            <Form.Label>Artist Alias</Form.Label>
                            <Form.Control
                                className="form-control"
                                name="artist"
                                value={artistalias}
                                onChange={onChangeArtistAlias}
                                validations={[required]}
                            />
                        </Form.Group>

                        <Form.Group controlId="formDate">
                            <DatePicker selected={projectdate} onChange={date => setProjectDate(date)} />
                        </Form.Group>

                        <div className="form-group">
                            <Button variant="primary" type="submit">Submit Artist</Button>
                        </div>
                    </div>
            </Form>
        </Jumbotron> */}
        </div>
    );
};

export default CreateContent;
