/* eslint no-unused-vars: 0 */
import React, {useState, useRef } from "react";
import { v4 as uuidv4 } from 'uuid';
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
    const [projecttype, setProjectType] = useState({Album: 'ALBUM', Single: 'SINGLE', Mixtape: 'MIXTAPE'});
    const [projectdate, setProjectDate] = useState(new Date());

    //To remove before release
    const [successful, setSuccessful] = useState(false);
    const [message, setMessage] = useState("");

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

    const onChangeProjectDate = (e) => {
        const value = e.target.value;
        setProjectDate(value);
    };

    const handleProjectCreation = (e) => {
        e.preventDefault();

        setMessage("");
        setSuccessful(false);

        // form.current.validateAll();

        const project = new Object({projectname, projectartist, projecttype, projectdate});

        ProjectService.createProject(project).then(
            (response) => {
                window.location.reload();
                setSuccessful(true);
                console.log("success");
            },
            (error) => {
                setMessage(error);
                setSuccessful(false);
            }
        );
    };

    return(
        <Jumbotron>
            <Form onSubmit={handleProjectCreation} ref={form}>
                    <div>
                        <Form.Group controlId="formBasicUserename">
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

                        <Form.Group controlId="formBasicPassword">
                            <Form.Label>Artist Name</Form.Label>
                            <Form.Control
                                className="form-control"
                                name="artist"
                                value={projectartist}
                                onChange={onChangeProjectArtist}
                                validations={[required]}
                            />
                        </Form.Group>

                        <Form.Group controlId="formBasicPassword">
                            <Form.Label>Album Type</Form.Label>
                            <Form.Control
                                className="form-control"
                                name="type"
                                value={projecttype}
                                onChange={onChangeProjectType}
                                validations={[required]}
                            />
                        </Form.Group>

                        <Form.Group controlId="formBasicPassword">
                            <Form.Label>Date</Form.Label>
                            <Form.Control
                                className="form-control"
                                name="date"
                                value={projectdate}
                                onChange={onChangeProjectDate}
                                validations={[required]}
                            />
                            <DatePicker selected={projectdate} onChange={date => onChangeProjectDate(date)} />
                        </Form.Group>

                        <div className="form-group">
                            <Button variant="primary" type="submit">Sign In</Button>
                        </div>
                    </div>
            </Form>
        </Jumbotron>
    );
};

export default CreateContent;
