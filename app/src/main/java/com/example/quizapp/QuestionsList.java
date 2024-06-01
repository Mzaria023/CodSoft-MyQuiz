package com.example.quizapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class QuestionsList {

    private static List<Questions> csharpList() {

        final List<Questions> list = new ArrayList<>();

        //Create list of questions and potential answers
        final Questions question1 = new Questions("1. What is encapsulation?", "a)All of the above", "b) Enhancing security by restricting access to certain parts of an object.", "c) Wrapping up data members and methods into a single unit", "a) All of the above", "");
        final Questions question2 = new Questions("2. What is the Console.WriteLine() function do?", "a) Writes to the console with a new line", "b) Reads input", "d) Dynamic and Extensible", "a) Writes to the console with a new line", "");
        final Questions question3 = new Questions("3. Which keyword is used to create an instance of a class?", "a) keyword", "b) new", "c) identifier", "b) new", "");
        final Questions question4 = new Questions("4. Which operator is used for type casting in C#??", "a) =", "b) as", "c) -", "b) as", "");
        final Questions question5 = new Questions("5. What does the override keyword do in C#?", "a) Provides a new implementation for a virtual method in a derived class", "b)Hides the base class method", "c) Makes a method abstract", "a) Provides a new implementation for a virtual method in a derived class", "");

        //adding questions to list
        list.add(question1);
        list.add(question2);
        list.add(question3);
        list.add(question4);
        list.add(question5);
        return list;
    }


    private static List<Questions> javaList() {

        final List<Questions> list = new ArrayList<>();

        //Create list of questions and potential answers
        final Questions question1 = new Questions("1. Who invented Java Programming?", "a) Guido van Rossum", "b) James Gosling", "c) Dennis Ritchie", "b) James Gosling", "");
        final Questions question2 = new Questions("2. Which one of the following is not a Java feature?", "a) Object-oriented", "b) Use of pointers", "c) Dynamic and Extensible", "b) Use of pointer", "");
        final Questions question3 = new Questions("3. Which of these cannot be used for a variable name in Java?", "a) keyword", "b) identifier & keyword", "c) identifier", "a) keyword", "");
        final Questions question4 = new Questions("4. Which of the following is not an OOPS concept in Java?", "a) Compilation", "b) Inheritance", "c) Encapsulation", "a) Compilation", "");
        final Questions question5 = new Questions("5. What will be the error in the following Java code?\n" +
                "\n" +
                "    byte b = 50;\n" +
                "    b = b * 50;", "a) No error in this code", "b) b cannot contain value 100, limited by its range", "c) * operator has converted b * 50 into int, which can not be converted to byte without casting", "c) * operator has converted b * 50 into int, which can not be converted to byte without casting", "");

        //adding questions to list
        list.add(question1);
        list.add(question2);
        list.add(question3);
        list.add(question4);
        list.add(question5);

        return list;
    }

    private static List<Questions> sqlList() {

        final List<Questions> list = new ArrayList<>();

        //Create list of questions and potential answers
        final Questions question1 = new Questions("1. Which character is used to separate SQL statements in database systems?", "a) ;", "b) =", "c) -", "a) ;", "");
        final Questions question2 = new Questions("2. The SQL LIKE operator is used in which of the following clause?", "a) HAVING", "b) SELECT", "c) WHERE", "c) WHERE", "");
        final Questions question3 = new Questions("3.  Which of the following command is used to create a database in SQL?", "a) CREATE", "b) SELECT", "c) WHERE", "a) CREATE", "");
        final Questions question4 = new Questions("4. Which of the following SQL statement selects only unique values from ‘section’ column of table ‘school'?", "a) SELECT ALL section FROM school", "b) SELECT DISTINCT section FROM school;", "c) SELECT section FROM school", "b) SELECT DISTINCT section FROM school;", "");
        final Questions question5 = new Questions("5. Which of the following is NOT a valid keyword in SQL?", "a) WHERE", "b) SELECT", "c) INCLUDE", "c) INCLUDE", "");

        //adding questions to list
        list.add(question1);
        list.add(question2);
        list.add(question3);
        list.add(question4);
        list.add(question5);

        return list;
    }
    private static List<Questions> oracleList() {

        final List<Questions> list = new ArrayList<>();

        //Create list of questions and potential answers
        final Questions question1 = new Questions("1.  Which of the following is/are the DDL statements?", "a)Create", "b) Alter", "c) All of the above", "c) All of the above", "");
        final Questions question2 = new Questions("2. The SQL statement\n" + "SELECT SUBSTR(‘123456789’, INSTR(‘abcabcabc’, ‘b’), 4) FROM DUAL;", "a) 456789", "b) 1234" ,"c) 2345", "c)2345", "");
        final Questions question3 = new Questions("3. Which of the following keyword is used with Data Control Language (DCL) statements", "a) INSERT", "b) GRANT", "c) DELETE", "b) GRANT", "");
        final Questions question4 = new Questions("4. Which of the following command is used to obtain the structure of an Oracle table?", "a) DESCRIBE [TableName]", "b) STRUCTURE [TableName]", "c) DESC TABLE [TableName]", "a) DESCRIBE [TableName]", "");
        final Questions question5 = new Questions("5. Which of the following is used to logically group data together?", "a) Database", "b) Datafiles", "c) Tablespace", "c) Tablespace", "");

        //adding questions to list
        list.add(question1);
        list.add(question2);
        list.add(question3);
        list.add(question4);
        list.add(question5);

        return list;
    }
    public static List<Questions>getQuestions(String selectTopic){
        switch(selectTopic) {
            case "CSHARP":
                return csharpList();


            case "JAVA":
                return javaList();


            case "SQL":
                return sqlList();


            default:
                return oracleList();
        }
    }
}
