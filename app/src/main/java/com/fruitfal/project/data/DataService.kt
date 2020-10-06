package com.fruitfal.project.data

import com.fruitfal.project.model.AllCommitsModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface DataService {
    @GET
    fun fetchAllCommits(@Url url: String?): Observable<List<AllCommitsModel>>?

}