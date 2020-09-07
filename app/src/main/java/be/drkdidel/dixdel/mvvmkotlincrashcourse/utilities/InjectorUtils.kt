package be.drkdidel.dixdel.mvvmkotlincrashcourse.utilities

import be.drkdidel.dixdel.mvvmkotlincrashcourse.data.FakeDatabase
import be.drkdidel.dixdel.mvvmkotlincrashcourse.data.QuoteRepository
import be.drkdidel.dixdel.mvvmkotlincrashcourse.ui.quotes.QuotesViewModelFactory

object InjectorUtils {

    fun provideQuotesViewModelFactory(): QuotesViewModelFactory {
        val quoteRepository = QuoteRepository.getInstance(FakeDatabase.getInstance().quoteDao)
        return QuotesViewModelFactory(quoteRepository)
    }
}