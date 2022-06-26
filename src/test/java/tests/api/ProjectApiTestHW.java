package tests.api;

import configuration.Endpoints;
import models.Project;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ProjectApiTestHW extends BaseApiTest{

    @Test
    public void updateProjectApiTest() {
        Project project = Project.builder()
                .announcement("Update Test1")
                .build();

        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("announcement", project.getAnnouncement());

        Project newProject = given()
                .pathParam("project_id", 73)
                .body(jsonAsMap)
                .when()
                .post(Endpoints.UPDATE_PROJECT)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .assertThat()
                .body("announcement", equalTo("Update Test1"))
                .extract() //десирилизация ответа в нужный объект(Project)
                .as(Project.class);
    }

    @Test
    public void deleteProjectApiTest() {
        projectHelper.deleteProject(66);
        projectHelper.getProjectAfterDelete(66);
    }
}
