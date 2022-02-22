package stepDef;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import utils.DBUtil;

import java.util.List;

public class MyStepDefs {

    private final Logger logger = LogManager.getLogger(MyStepDefs.class);
    private final String query = "SELECT first_name, last_name from employees where manager_id = (select employee_id from employees where first_name = 'Payam')";

    @Given("User is able to connect to database")
    public void userIsAbleToConnectToDatabase() {
        DBUtil.createDBConnection();
    }

    @When("User sends the {string} to database")
    public void userSendsTheToDatabase(String query) {
        DBUtil.executeQuery(query);
    }

    @Then("validate information taken from the database displayed correct with the order")
    public void validateInformationTakenFromTheDatabaseDisplayedCorrectWithTheOrder(DataTable dataTable) {
        List<List<String>> list = dataTable.asLists();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 2; j++) {
                Assert.assertEquals(list.get(i).get(j), DBUtil.getQueryResultList(query).get(i).get(j));
            }
        }
    }
}
