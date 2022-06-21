package tests.ap;

import configuration.ReadProperties;
import dbEntities.MilestoneTable;
import helpers.ProjectHelper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import models.Project;
import models.ProjectType;
import org.apache.http.protocol.HTTP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import services.DataBaseService;
import tests.db.BaseDBTest;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class BaseApiTest {

    Logger logger = LoggerFactory.getLogger(BaseDBTest.class);

    MilestoneTable milestoneTable;

    public DataBaseService dataBaseService;

    @BeforeTest
    public void setupEnv() {
//        RestAssured.baseURI = ReadProperties.getUrl();
//
//        RestAssured.requestSpecification = given()
//                .header(HTTP.CONTENT_TYPE, ContentType.JSON)
//                .auth().preemptive().basic(ReadProperties.username(), ReadProperties.password());
    }

    @AfterTest
    public void closeConnection() {
        dataBaseService.closeConnection();
    }

    //todo remove it
    public static final int BASE_TEST_PROJECT_ID = 76;

    public Project baseProject;
    public ProjectHelper projectHelper = new ProjectHelper();

    @BeforeClass
    public void setupBaseTestProject() {
        //todo test with it in final
        RestAssured.baseURI = ReadProperties.getUrl();

        RestAssured.requestSpecification = given()
                .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                .auth().preemptive().basic(ReadProperties.username(), ReadProperties.password());

        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("name", "[AUTO TEST] Base test project");
        jsonAsMap.put("announcement", "[AUTO TEST] Base test project announcement");
        jsonAsMap.put("show_announcement", true);
        jsonAsMap.put("suite_mode", ProjectType.SINGLE_SUITE_MODE);

        baseProject = projectHelper.addProject(jsonAsMap);

        dataBaseService = new DataBaseService();


        milestoneTable = new MilestoneTable(dataBaseService);
        milestoneTable.dropTable();
        milestoneTable.createMilestoneTable();

        milestoneTable.addMilestone(baseProject.projectId,"milestone1", "Test1");
        milestoneTable.addMilestone(baseProject.projectId, "milestone2", "Test2");
        milestoneTable.addMilestone(baseProject.projectId, "milestone3", "Test3");
    }

    @AfterClass
    public void deleteBaseTestProject() {
        //todo test with it in final
       projectHelper.deleteProject(baseProject.getProjectId());
    }

    @AfterTest
    public void teardownEnv() {
        RestAssured.reset();
        dataBaseService.closeConnection();
    }
}

