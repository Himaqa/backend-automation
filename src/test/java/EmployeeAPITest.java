import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.backend.FileUtil;
import org.backend.models.EmployeeRequest;
import org.backend.models.EmployeeResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import static io.restassured.RestAssured.given;

public class EmployeeAPITest {

    private FileUtil fileUtil;


    @BeforeClass
    public  void setup() {
        fileUtil = new FileUtil();
        RestAssured.baseURI = "https://6143a99bc5b553001717d06a.mockapi.io/testapi/v1/Users";
    }

    @Test
    public void createEmployee_whenValidRequest() throws IOException {
        List<EmployeeRequest>  employeeRequests = fileUtil.getTestData("test-data.xlsx");
        for (EmployeeRequest employeeRequest : employeeRequests) {
            Gson gson = new Gson();
            String requestData = gson.toJson(employeeRequest);
            Response response = given()
                    .body(requestData)
                    .when()
                    .post();
            Assert.assertEquals(HttpStatus.SC_CREATED, response.statusCode());
            Assert.assertNotNull(response.getBody());
            EmployeeResponse employeeResponse = response.as(EmployeeResponse.class, ObjectMapperType.GSON);
            Assert.assertNotNull(employeeResponse);
            Assert.assertNotNull(employeeResponse.getId());
            validateAndAssertEmployeeDataById(employeeResponse.getId());
        }
    }

    public  void validateAndAssertEmployeeDataById(String id) {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/"+id)
                .then()
                .extract().response();
        Assert.assertEquals(HttpStatus.SC_OK, response.statusCode());
        Assert.assertNotNull(response.getBody());
        EmployeeResponse employeeResponse = response.as(EmployeeResponse.class, ObjectMapperType.GSON);
        Assert.assertNotNull(employeeResponse);
        Assert.assertEquals(id,employeeResponse.getId());
        Assert.assertEquals("employee_firstname "+id, employeeResponse.getEmployee_firstname());
        Assert.assertEquals("employee_lastname "+id, employeeResponse.getEmployee_lastname());
        Assert.assertEquals("ademployee_emaildress "+id, employeeResponse.getAdemployee_emaildress());
        Assert.assertEquals("citemployee_addressy "+id, employeeResponse.getCitemployee_addressy());
        Assert.assertEquals("stateemployee_dev_level "+id, employeeResponse.getStateemployee_dev_level());
        Assert.assertEquals("employee_gender "+id, employeeResponse.getEmployee_gender());
    }

    @Test
    public  void get_allEmployeeDetails() {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get()
                .then()
                .extract().response();
        Assert.assertEquals(HttpStatus.SC_OK, response.statusCode());
        Assert.assertNotNull(response.getBody());
        List<EmployeeResponse> employeeResponse = response.as(List.class, ObjectMapperType.GSON);
        Assert.assertNotNull(employeeResponse);
        Assert.assertTrue(employeeResponse.size()>0);
    }
    //@Test
    public void deleteEmployeeDataById() {
        for (int i=250;i<300;i++){
            Response response = given()
                    .contentType(ContentType.JSON)
                    .when()
                    .delete("/"+i)
                    .then()
                    .extract().response();
        }

    }

}

