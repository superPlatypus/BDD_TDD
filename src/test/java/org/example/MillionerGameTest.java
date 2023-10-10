package org.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class MillionerGameTest {
    Question question;
    @Before
    public void init(){
        question = new Question("question", Arrays.asList("a", "b", "c"), "d");
    }

    @Test
    public void getFiftyFifty() {
        List<String> answers = MillionerGame.getFiftyFifty(question);
        boolean result = answers.contains(question.getCorrectAnswer()) && answers.size() == 2;
        Assert.assertTrue(result);
    }

    @Test
    public void getAllAnswers() {
        List<String> answers = MillionerGame.getAllAnswers(question);
        boolean result = answers.size() == 4 &&
//                answers.contains(question.getAnswers());
                answers.contains(question.getAnswers().get(0)) &&
                answers.contains(question.getAnswers().get(1)) &&
                answers.contains(question.getAnswers().get(2)) &&
                answers.contains(question.getCorrectAnswer());
        Assert.assertTrue(result);
    }


}