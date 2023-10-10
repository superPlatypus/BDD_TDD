Feature: Question Validation

  Scenario: Valid question
    Given Question "Вопрос", "Ответ1" , "Ответ2", "Ответ3", "ВерныйОтвет"
    When User validate question
    Then Question is valid

 Scenario Outline: Invalid question
    Given Invalid question <question>, <st_answer> , <nd_answer>, <rd_answer>, <correctAnswer>
    When User validate invalid question
    Then Invalid qeustion is invalid
   Examples:
     | question | st_answer | nd_answer | rd_answer | correctAnswer |
     | ""       |"ans1"     | "ans2"    | "ans3"    | "corAns"     |
     |"question"|""         | "ans2"    | "ans3"    | "corAns"     |
     |"question"|"ans1"     | "ans2"    | "ans3"    | ""            |





