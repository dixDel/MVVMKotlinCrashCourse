package be.drkdidel.dixdel.mvvmkotlincrashcourse.ui.quotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import be.drkdidel.dixdel.mvvmkotlincrashcourse.R
import be.drkdidel.dixdel.mvvmkotlincrashcourse.data.Quote
import be.drkdidel.dixdel.mvvmkotlincrashcourse.utilities.InjectorUtils
import kotlinx.android.synthetic.main.activity_quotes.*
import java.lang.StringBuilder

class QuotesActivity : AppCompatActivity() {

    private val viewModel: QuotesViewModel by lazy {
        val factory = InjectorUtils.provideQuotesViewModelFactory()
        ViewModelProvider(this, factory).get(QuotesViewModel::class.java)
    }

    private val quoteObserver = Observer<List<Quote>> { quotes ->
        val stringBuilder = StringBuilder()
        quotes.forEach { quote ->
            stringBuilder.append("$quote\n\n")
        }
        textView_quotes.text = stringBuilder.toString()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes)

        initializeUi()
    }

    private fun initializeUi() {
        viewModel.getQuotes().observe(this, quoteObserver)

        button_add_quote.setOnClickListener {
            val quote = Quote(editText_quote.text.toString(), editText_author.text.toString())
            viewModel.addQuote(quote)
            editText_quote.setText("")
            editText_author.setText("")
        }
    }
}