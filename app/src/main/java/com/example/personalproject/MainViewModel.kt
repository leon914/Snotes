package com.example.personalproject

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.models.Note
import com.example.repository.NoteRepository
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import java.util.concurrent.TimeUnit

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repo = NoteRepository(application)

    private val cd = CompositeDisposable()

//    fun getNotes(): LiveData<List<Note>> {
//        val liveData = MutableLiveData<List<Note>>()
//
//        cd.add(
//            Observable.interval(1, TimeUnit.SECONDS).subscribe({
//                liveData.postValue(repo.getAll())
//            }, {
//
//            })
//        )
//
//        return liveData
//    }

    fun getNotes(): LiveData<Result<List<Note>>> {
        val liveData = MutableLiveData<Result<List<Note>>>()

        cd.add(
            Observable.interval(1, TimeUnit.SECONDS).subscribe({
                liveData.postValue(
                    Result.success(repo.getAll())
                )
            }, {
                Result.failure<Throwable>(it)
            })
        )

        return liveData
    }

    private fun allNotesInterval() {

    }

    override fun onCleared() {
        cd.dispose()
    }


}