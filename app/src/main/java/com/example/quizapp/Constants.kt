package com.example.quizapp

object Constants{

    const val TOTALQUESTIONS:String = "total questions"
    const val USER_NAME:String = "username"
    const val CORRECT_ANSWERS:String = "correct answer"

    fun getQuestions(): ArrayList<Questions>{
        val questionsList = ArrayList<Questions>()

        // 1
        val q1 = Questions(
            1,
            "What Country does this flag belong to?",
             R.drawable.ic_flag_of_argentina,
            "Argentina",
            "Australia",
            "Armenia",
            "Austria",
            1
            )
        questionsList.add(q1)

        // 2
        val q2 = Questions(
            2,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_australia,
            "Angola",
            "Austria",
            "Australia",
            "Armenia",
            3
        )

        questionsList.add(q2)

        // 3
        val q3 = Questions(
            3,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_brazil,
            "Belarus",
            "Belize",
            "Brunei",
            "Brazil",
            4
        )

        questionsList.add(q3)

        // 4
        val q4 = Questions(
            4,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_belgium,
            "Bahamas",
            "Belgium",
            "Barbados",
            "Belize",
            2
        )

        questionsList.add(q4)

        // 5
        val q5 = Questions(
            5,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_fiji,
            "Gabon",
            "France",
            "Fiji",
            "Finland",
            3
        )

        questionsList.add(q5)

        // 6
        val q6 = Questions(
            6,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_germany,
            "Germany",
            "Georgia",
            "Greece",
            "none of these",
            1
        )

        questionsList.add(q6)

        // 7
        val q7 = Questions(
            7,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_denmark,
            "Dominica",
            "Egypt",
            "Denmark",
            "Ethiopia",
            3
        )

        questionsList.add(q7)

        // 8
        val q8 = Questions(
            8,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_india,
            "Ireland",
            "Iran",
            "Hungary",
            "India",
            4
        )

        questionsList.add(q8)

        // 9
        val q9 = Questions(
            9,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_new_zealand,
            "Australia",
            "New Zealand",
            "Tuvalu",
            "United States of America",
            2
        )

        questionsList.add(q9)

        // 10
        val q10 = Questions(
            10,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_kuwait,
            "Kuwait",
            "Jordan",
            "Sudan",
            "Palestine",
            1
        )

        questionsList.add(q10)

        return questionsList
    }
}