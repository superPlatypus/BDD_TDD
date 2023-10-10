package org.example;

import java.util.*;

public class MillionerGame {
    static List<Question> questions = new ArrayList<>();
//    static QuestionFiller questionFiller = new QuestionFiller();
    public static void main(String[] args) {
        System.out.println("Нажми 1 что бы играть, 2 что бы добавить вопрос");
        Scanner sc = new Scanner(System.in);

        switch (sc.nextInt()){
            case 1:
                QuestionFiller.fill(questions);
                play();
                break;
            case 2:
                QuestionFiller.addQuestion(questions);
                main(args);
                break;
            default:
                System.out.println("Ты дурак?");
                main(args);
                break;
        }
    }
    public static void play() {
        boolean helpCount = true;
//        List<Question> questions = new ArrayList<>();

        questions.forEach(System.out::println);
        Scanner sc = new Scanner(System.in);
        int prize = 1000;
        int n;
        for (Question question: questions) {
            System.out.println(question.getQuestion());
            List<String> answers = getAllAnswers(question);

            showAnswers(answers);
            if (helpCount){
                System.out.println("------\n4) Подсказка 50/50");
            }
            n = sc.nextInt();
            if (!check(n,helpCount, 2)){
                System.out.println("Ты дурак!!!!!");
                break;
            }
            if (n == 4 && helpCount){
                helpCount = false;
                answers = getFiftyFifty(question);
                showAnswers(answers);
                n = sc.nextInt();
                if (!check(n,helpCount, 0)){
                    System.out.println("Ты дурак!!!!!");
                    break;
                }
            }
            if (answers.get(n).equals(question.getCorrectAnswer())){
                System.out.println("Верно!");
                System.out.println("Ваш приз: " + prize);
                prize *= 10;
            }
            else{
                System.out.println("Ошибка!");
                break;
            }

        }
        System.out.println("Конец игры!");

    }

    static List<String> getAllAnswers(Question question){
        List<String> answers = new ArrayList<>(question.getAnswers());
        answers.add(question.getCorrectAnswer());
        Collections.shuffle(answers);
        return answers;
    }

    static List<String> getFiftyFifty(Question question){ // TDD
        List<String> answers = new ArrayList<>();
        answers.add(question.getCorrectAnswer());
        answers.add(question.getAnswers().get(new Random().nextInt(3)));
        Collections.shuffle(answers);
        return answers;
    }

    static void showAnswers(List<String> answers){
        for (int i=0; i< answers.size(); i++){
            System.out.println(i + ") " + answers.get(i));
        }
    }

    static boolean check(int n, boolean helpCount, int ifHelpUsed){
        int intHelpCount = helpCount ? 1 : 0;
        return  (n > -1 && n < 2 + intHelpCount + ifHelpUsed);
    }


}
