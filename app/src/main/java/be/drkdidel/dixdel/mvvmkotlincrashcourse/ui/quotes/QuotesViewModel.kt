package be.drkdidel.dixdel.mvvmkotlincrashcourse.ui.quotes

import androidx.lifecycle.ViewModel
import be.drkdidel.dixdel.mvvmkotlincrashcourse.data.Quote
import be.drkdidel.dixdel.mvvmkotlincrashcourse.data.QuoteRepository

class QuotesViewModel(private val quoteRepository: QuoteRepository): ViewModel() {

    fun getQuotes() = quoteRepository.getQuotes()

    fun addQuote(quote: Quote) = quoteRepository.addQuote(quote)
}