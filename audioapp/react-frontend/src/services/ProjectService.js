import axios from "axios";

const PROJECTS_REST_API_URL = "http://localhost:8080/api/projects";
const PROJECTS_ORDER_BY_RATING_REST_API_URL = "http://localhost:8080/api/projects-rating";
const PROJECT_BY_ID_REST_API_URL = "http://localhost:8080/api/projects";
const PROJECTS_SEARCH_REST_API_URL = "http://localhost:8080/api/projects-search";


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

    getProjectBySearch(query){
        return axios.get(PROJECTS_SEARCH_REST_API_URL+"/"+query);
    }

    createProject(project){
        return axios.post(PROJECTS_REST_API_URL, {params:{
            name: project.name,
            artist: project.artist,
            rating: 0,
            reviews: 0,
            release_date: project.release_date,
            type: project.type,
            image: null
        }
        });
    }
}

export default new ProjectService();

