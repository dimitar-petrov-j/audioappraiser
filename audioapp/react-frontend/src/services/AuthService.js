const API_URL = "http://localhost:8080/api/auth/";

const register = (username, password, real_name) => {
    return fetch(API_URL + "signup", {
        method: "post",
        headers: {
            "Accept": "application/json, text/plain",
            "Content-Type": "application/json;charset=UTF-8"
        },
        body: JSON.stringify({
                username: username,
                password: password,
                real_name: real_name,
                type: "ADMIN"
            }
        ),
    });
};

const login = (username, password) => {

    const data = {
        "username": username,
        "password": password
    };

    const headers = {
        "Content-Type": "application/json",
        "Access-Control-Origin": "*"
    };

    return fetch(API_URL + "signin", {
        method: "GET",
        headers: headers,
        body: JSON.stringify(data)
    })
        .then((response) => {
            return response.text()
                .then( (login) => {
                    const newLogin = JSON.parse(login);
                    if(newLogin.accessToken) {
                        console.log("store user");
                        localStorage.setItem("user", JSON.stringify(newLogin));
                    }
                    return login;
                });
        });
};

const logout = () => {
    localStorage.removeItem("user");
};

const getCurrentUser = () => {
    return JSON.parse(localStorage.getItem("user"));
};

export default {
    register,
    login,
    logout,
    getCurrentUser,
};