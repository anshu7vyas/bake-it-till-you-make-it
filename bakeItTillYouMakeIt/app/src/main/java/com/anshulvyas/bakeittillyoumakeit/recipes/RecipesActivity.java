package com.anshulvyas.bakeittillyoumakeit.recipes;

import android.arch.lifecycle.ViewModelProviders;
import android.content.res.Configuration;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;

import com.anshulvyas.bakeittillyoumakeit.R;
import com.anshulvyas.bakeittillyoumakeit.databinding.ActivityRecipesBinding;
import com.anshulvyas.bakeittillyoumakeit.di.DaggerViewModelFactory;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class RecipesActivity extends AppCompatActivity {

    ActivityRecipesBinding mActivityRecipesBinding;
    @Inject DaggerViewModelFactory mDaggerViewModelFactory;

    RecipesActivityViewModel mRecipeActivityViewModel;
    RecipesAdapter mRecipesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);

        int orientation = this.getResources().getConfiguration().orientation;

        mActivityRecipesBinding = DataBindingUtil.setContentView(this, R.layout.activity_recipes);

        mRecipeActivityViewModel = ViewModelProviders.of(this, mDaggerViewModelFactory).get(RecipesActivityViewModel.class);

        mRecipesAdapter = new RecipesAdapter(this);

        populateRecipesList(mRecipesAdapter, orientation);

        mRecipeActivityViewModel.getRecipesListLiveData().observe(this, v -> mRecipesAdapter.setRecipesListData(v));

    }

    private void populateRecipesList(RecipesAdapter recipesAdapter, int orientation) {
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            GridLayoutManager layoutManager = new GridLayoutManager (this, 3, LinearLayoutManager.VERTICAL, false);
            mActivityRecipesBinding.rvMovies.setLayoutManager(layoutManager);
        } else {
            GridLayoutManager layoutManager = new GridLayoutManager (this, 1, LinearLayoutManager.VERTICAL, false);
            mActivityRecipesBinding.rvMovies.setLayoutManager(layoutManager);
        }
        mActivityRecipesBinding.rvMovies.setAdapter(recipesAdapter);
    }
}
