package be.drkdidel.dixdel.mvvmkotlincrashcourse.ui.quotes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import be.drkdidel.dixdel.mvvmkotlincrashcourse.data.QuoteRepository

class QuotesViewModelFactory(private val quoteRepository: QuoteRepository): ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return QuotesViewModel(quoteRepository) as T
    }
}