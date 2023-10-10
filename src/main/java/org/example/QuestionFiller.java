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

    public static boolean addQuestion(List<Question> questions){ //BDD
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите вопрос: ");
        String question = sc.nextLine();
        if (question.isEmpty()){
            return false;
        }
        List<String> answers = new ArrayList<>();
        String correctAnswer = "";
        for (int i=0; i<3; i++){
            System.out.println("Введите " + i + "й вариант ответа");
            answers.add(sc.nextLine());
            if (answers.get(i).isEmpty()){
                return false;
            }
        }
        System.out.println("Введите верный вариант ответа");
        correctAnswer = sc.nextLine();
        if (correctAnswer.isEmpty()){
            return false;
        }
        questions.add(new Question(question, answers, correctAnswer));

        return true;

    }


}
