package tests.api;


import helpers.ProjectHelper;
import models.Project;
import org.testng.annotations.Test;

public class ProjectApiTest extends BaseApiTest {
    ProjectHelper projectHelper;

    @Test
    public void positiveTest(){

        Project expectedProject = Project.builder()
                .name("WP Test")
                .typeOfProject(1)
                .announcement("Test An")
                .build();

        //Assert.assertTrue(projectHelper.getProject(1).equals(expectedProject));
    }
    @Test
    public void negativeInvalidProjectTest(){
        //Assert.assertEquals(projectHelper.getProjectResponse(500).getStatusCode(), HttpStatus.SC_BAD_REQUEST);

    }
    @Test
    public void positiveCountProjectsTest(){
     //   Assert.assertEquals(projectHelper.getAllProjects().size(),12);
    }
}
