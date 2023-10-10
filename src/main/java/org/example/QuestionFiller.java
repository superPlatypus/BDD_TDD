package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class QuestionFiller {
    public static boolean fill(List<Question> questions){
//        List<Question> questions = new ArrayList<>();
        questions.add(new Question("Одним из направлений какой религиозной философии является учение дзен?",
                Arrays.asList("Даосизм", "Иудаизм", "Индуизм"),
                "Буддизм"));
        questions.add(new Question("С какой фигуры начинаются соревнования по городошному спорту?",
                Arrays.asList("«Часовые»", "«Пулеметное гнездо»", "«Артиллерия»"),
                "«Пушка»"));
        questions.add(new Question("Кто из перечисленных был пажом во времена Екатерины II?",
                Arrays.asList("Д. И. Фонвизин", "Г. Р. Державин", "Н. М. Карамзин"),
                "А. Н. Радищев"));

        return true;
    }

    public static void addQuestion(List<Question> questions){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите вопрос: ");
        String question = sc.nextLine();
        List<String> answers = new ArrayList<>();
        String correctAnswer = "";
        for (int i=0; i<3; i++){
            System.out.println("Введите " + i + "й вариант ответа");
            answers.add(sc.nextLine());
        }
        System.out.println("Введите верный вариант ответа");
        correctAnswer = sc.nextLine();
        Question q = new Question(question, answers, correctAnswer);
        if (checkQuestion(questions, q)){
            questions.add(q);
        }
    }

    public static boolean checkQuestion(List<Question> questions, Question question){ //BDD
        if (question.getQuestion().isEmpty() ||
            question.getAnswers().stream().anyMatch(String::isEmpty) ||
            question.getCorrectAnswer().isEmpty()){
            return false;
        }
        return true;
    }


}
