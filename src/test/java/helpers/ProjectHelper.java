package helpers;

import configuration.Endpoints;
import io.restassured.response.Response;
import models.Project;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;

public class ProjectHelper {

    public Project getProject(int project_id){
        return given()
                .pathParam("project_id", project_id)
                .get(Endpoints.GET_PROJECT)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(Project.class);

    }

    public Response getProjectResponse(int project_id){
        return given()
                .pathParam("project_id", project_id)
                .get(Endpoints.GET_PROJECT);
        }

    public void deleteProject(int project_id){
       given()
                .pathParam("project_id", project_id)
                .post(Endpoints.DELETE_PROJECT)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);
    }

    public void getProjectAfterDelete(int project_id) {
        given()
                .pathParam("project_id", project_id)
                .get(Endpoints.GET_PROJECT)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_BAD_REQUEST);

    }
}
