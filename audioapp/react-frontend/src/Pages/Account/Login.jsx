import React, {useState, useRef, useEffect} from "react";

import "bootstrap/dist/css/bootstrap.min.css";
import { Jumbotron, Form, Alert, Button } from "react-bootstrap";


import AuthService from "../../services/AuthService";


const required = (value) => {
    if (!value) {
        return (
            <Alert variant="danger">
                This field is required!
            </Alert>
        );
    }
};

const vusername = (value) => {
    if (value.length < 3 || value.length > 20) {
        return (
            <Alert variant="danger">
                The username must be between 3 and 20 characters.
            </Alert>
        );
    }
};

const vpassword = (value) => {
    if (value.length < 6 || value.length > 40) {
        return (
            <Alert variant="danger">
                The password must be between 6 and 40 characters.
            </Alert>
        );
    }
};

const Login = (props) => {
    const form = useRef();
    const checkBtn = useRef();

    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [successful, setSuccessful] = useState(false);
    const [message, setMessage] = useState("");

    const onChangeUsername = (e) => {
        const username = e.target.value;
        setUsername(username);
    };

    const onChangePassword = (e) => {
        const password = e.target.value;
        setPassword(password);
    };

    const handleLogin = (e) => {
        e.preventDefault();

        setMessage("");
        setSuccessful(false);

        form.current.validateAll();

        if (checkBtn.current.context._errors.length === 0) {
            AuthService.login(username, password).then(
                (response) => {
                    props.history.push("/Login");
                    window.location.reload();
                    setSuccessful(true);
                },
                (error) => {
                    console.log(error);

                    setMessage(error);
                    setSuccessful(false);
                }
            );
        }
    }

    return (
        <Jumbotron className="jumbotron-albumpage">
            <Form onSubmit={handleLogin} ref={form}>
                    <div>
                        <Form.Group controlId="formBasicUserename">
                            <Form.Label>Username</Form.Label>
                            <Form.Control
                                type="text"
                                className="form-control"
                                name="username"
                                value={username}
                                onChange={onChangeUsername}
                                validations={[required, vusername]}
                            />
                        </Form.Group>

                        <Form.Group controlId="formBasicPassword">
                            <Form.Label>Password</Form.Label>
                            <Form.Control
                                type="password"
                                className="form-control"
                                name="password"
                                value={password}
                                onChange={onChangePassword}
                                validations={[required, vpassword]}
                            />
                        </Form.Group>

                        <div className="form-group">
                            <Button variant="primary" type="submit">Sign In</Button>
                        </div>
                    </div>
            </Form>
        </Jumbotron>
    );
};