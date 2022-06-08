package models;

import lombok.Builder;
import lombok.Data;
import org.testng.annotations.Test;

@Data
@Builder
public class Project {
        private String name;
        private String announcement;
        private boolean isShowAnnouncement;
        @SerializedName(value = "suite_mode")
        private int typeOfProject;
        @SerializedName(value = "is_completed")
        private boolean isCompleted;
        private User user;
}

        Project newProject = Project.builder()
        .name("WP_Test_01")
        .build();

        given()
        .body(String.format("{\n" +
        "  \"name\": \"%s\"\n" +
        "}", newProject.getName()))
        .when()
        .post(Endpoints.ADD_PROJECT)
        .then()
        .log().body()
        .statusCode(HttpStatus.SC_OK);


@Test
public void addProject2() {
        Project project = Project.builder()
        .name("WP_Project_02")
        .typeOfProject(ProjectType.SINGLE_SUITE_MODE)
        .build();

        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("name", project.getName());
        jsonAsMap.put("suite_mode", project.getTypeOfProject());

        given()
        .body(jsonAsMap)
        .when()
        .post(Endpoints.ADD_PROJECT)
        .then()
        .log().body()
        .statusCode(HttpStatus.SC_OK);
        }
