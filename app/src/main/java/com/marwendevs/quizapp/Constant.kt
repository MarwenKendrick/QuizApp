package com.marwendevs.quizapp

object Constant {
    const val USER_NAME : String = "user_name"
    const val TOTAL_QUESTIONS : String = "total_Questions"
    const val CORRECT_ANSWER : String = "Correct_Answers"

    fun getQuestion(): ArrayList<Question>{
        val questionList = ArrayList<Question>()

        val quiz1 = Question(
            id = 1,
            "Who is the owner of the facebook?",
            R.drawable.fb_owner,"Mark Zuckerberg","Marc Pingris","Steve Jobs","Elon Musk", 1
        )
        questionList.add(quiz1)

        val quiz2 = Question(
            id = 2,
            "Who is the owner of the SpaceX?",
            R.drawable.elon_musk,"Mark Zuckerberg","Marc Pingris","Steve Jobs","Elon Musk", 4
        )
        questionList.add(quiz2)

        val quiz3 = Question(
            id = 3,
            "Which of these Datatypes can you use for Numbers?",
            R.drawable.numbers,"String, Int, Double","Double, Int, Boolean","Double, Int, Float","All of the Above", 3
        )
        questionList.add(quiz3)

        val quiz4 = Question(
            id = 4,
            "Which data type does this variable have val pi = 3.14159?",
            R.drawable.pi," Int","Double","Float","Long", 3
        )
        questionList.add(quiz4)

        val quiz5 = Question(
            id = 5,
            "How do you create a text variable in kotlin?",
            R.drawable.kotlin,"var text = \"Hello World\"","var Text = HelloWold","var Text = \'HelloWold\'","All of The Above", 1
        )
        questionList.add(quiz5)

        val quiz6 = Question(
            id = 6,
            "How would you create an object/instance of this class?",
            R.drawable.quiz6,"var marwen = Person(Marwen)","var marwen = Person(\"Marwen\"","var marwen = Person(\"Marwen\",\"Tagalicud\"","All of The Above", 3
        )
        questionList.add(quiz6)
        val quiz7 = Question(
            id = 7,
            "What is the difference between a function and a method?",
            R.drawable.funvsmethod,"There is none","function are less complex","methods don't accept parameters","Methods are functions defined in classes", 4
        )
        questionList.add(quiz7)

        val quiz8 = Question(
            id = 8,
            "What is the name for the term of variables, methods, constructors... of a class",
            R.drawable.metadata,"buddies","colleagues","members","assistants", 3
        )
        questionList.add(quiz8)

        val quiz9 = Question(
            id = 9,
            "What is the name for the term of variables, methods, constructors... of a class",
            R.drawable.quiz9,
            "yes, the function drive is missing it's function body",
            "yes, interfaces must initialize its variables",
            "yes, both of the above",
            "no, it's all good. interfaces neither have to implement function bodies nor their variables. The class that uses the interface has to do it.",
            4
        )
        questionList.add(quiz9)

        val quiz10 = Question(
            10,
            "How would you make this cast safe?",
            R.drawable.quiz10,
            "val x: String? = y as String",
            "val x: String? = y as? String",
            "val x:String = y as? String?",
            "val x:String? = y as? String?",2
        )
        questionList.add(quiz10)

        return questionList
    }
}