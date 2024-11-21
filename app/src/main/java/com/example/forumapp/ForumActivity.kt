package com.example.forumapp

// Activity responsável pela exibição das perguntas e respostas
class ForumActivity : AppCompatActivity() {
    private val viewModel: QuestionsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forum)

        val recyclerView = findViewById<RecyclerView>(R.id.questionsRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel.questionsLiveData.observe(this) { questions ->
            recyclerView.adapter = QuestionsAdapter(questions)
        }

        viewModel.fetchQuestions("kotlin")
    }
}
