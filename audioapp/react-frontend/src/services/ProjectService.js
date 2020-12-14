

import axios from 'axios'

const PROJECTS_REST_API_URL = 'http://localhost:8080/api/projects';
const PROJECTS_ORDER_BY_RATING_REST_API_URL = "http://localhost:8080/api/projects-rating";

class ProjectService {

    getProjects(){
        return axios.get(PROJECTS_REST_API_URL);
    }

    getProjectsCharts(){
        return axios.get(PROJECTS_ORDER_BY_RATING_REST_API_URL);
    }
}

export default new ProjectService();

