

import axios from 'axios'

const PROJECTS_REST_API_URL = 'http://localhost:8080/api/projects';
const PROJECTS_ORDER_BY_RATING_REST_API_URL = "http://localhost:8080/api/projects-rating";
const PROJECT_BY_ID_REST_API_URL = 'http://localhost:8080/api/projects';


class ProjectService {

    getProjects(){
        return axios.get(PROJECTS_REST_API_URL);
    }

    getProjectsCharts(){
        return axios.get(PROJECTS_ORDER_BY_RATING_REST_API_URL);
    }

    getProjectById(id){
        return axios.get(PROJECT_BY_ID_REST_API_URL+"/"+id);
    }
}

export default new ProjectService();

