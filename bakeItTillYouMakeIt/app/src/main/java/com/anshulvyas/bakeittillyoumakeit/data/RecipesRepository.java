package com.anshulvyas.bakeittillyoumakeit.data;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.anshulvyas.bakeittillyoumakeit.BakeItApplication;
import com.anshulvyas.bakeittillyoumakeit.data.model.Recipe;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecipesRepository {

    private static final String LOG_TAG = RecipesRepository.class.getSimpleName();

    @Inject
    Call<List<Recipe>> recipesList;

    public RecipesRepository (Application application) {
        ((BakeItApplication) application).getAppComponent().inject(this);
    }

    public LiveData<List<Recipe>> getRecipesLiveData() {
        final MutableLiveData<List<Recipe>> recipesMutableLiveData = new MutableLiveData<>();

        recipesList.enqueue(new Callback<List<Recipe>>() {
            @Override
            public void onResponse(Call<List<Recipe>> call, Response<List<Recipe>> response) {
                recipesMutableLiveData.setValue(response.body());
                Log.d(LOG_TAG, response.body().toString());
            }

            @Override
            public void onFailure(Call<List<Recipe>> call, Throwable t) {
                Log.e(LOG_TAG, t.getLocalizedMessage());
            }
        });

        return recipesMutableLiveData;
    }


}
