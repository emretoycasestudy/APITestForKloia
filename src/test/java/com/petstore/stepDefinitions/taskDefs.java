package com.petstore.stepDefinitions;

import com.petstore.base.Cases;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class taskDefs {
    Cases cases=new Cases();
    @Given("the user goes to the API")
    public void the_user_goes_to_the_API() {
        cases.beforeclass();
    }

    @When("the user create new dog information")
    public void the_user_create_new_dog_information() {
        cases.postMethod();
    }

    @Then("the user verify the response")
    public void the_user_verify_the_response() {
        System.out.println("Create new dog information");
    }

    @When("the user get request of new pets info")
    public void the_user_get_request_of_new_pets_info() {
    cases.getMethod();
    }

    @Then("the user verify get response body")
    public void the_user_verify_get_response_body() {

        System.out.println("Get new dogs informations");
    }


    @When("the user use delete request for deleting")
    public void the_user_use_delete_request_for_deleting() {
    cases.deleteMethod();
    }

    @Then("the user verify the delete new pets info")
    public void the_user_verify_the_delete_new_pets_info() {
        System.out.println("Deleted new dogs informations");
    }


}
