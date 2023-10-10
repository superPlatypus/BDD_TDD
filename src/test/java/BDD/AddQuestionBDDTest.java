package BDD;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Question;
import org.example.QuestionFiller;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddQuestionBDDTest {
    private boolean result;
    Question question;
    List<Question> questions = new ArrayList<>();

    @Given("Question {string}, {string} , {string}, {string}, {string}")
    public void question(String string, String string2, String string3, String string4, String string5) {
        question = new Question(string, Arrays.asList(string2, string3, string4), string5);
    }
    @When("User validate question")
    public void user_validate_question() {
        result = QuestionFiller.checkQuestion(questions, question);
    }
    @Then("Question is valid")
    public void question_is_valid() {
        Assertions.assertTrue(result);
    }

    @Given("Invalid question {string}, {string} , {string}, {string}, {string}")
    public void invalid_question(String string, String string2, String string3, String string4, String string5) {
        question = new Question(string, Arrays.asList(string2, string3, string4), string5);
    }
    @When("User validate invalid question")
    public void user_validate_invalid_question() {
        result = QuestionFiller.checkQuestion(questions, question);
    }
    @Then("Invalid qeustion is invalid")
    public void invalid_qeustion_is_invalid() {
        Assertions.assertFalse(result);
    }

}
