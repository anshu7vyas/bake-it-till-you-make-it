package com.anshulvyas.bakeittillyoumakeit.recipes;

import android.arch.lifecycle.ViewModelProvider;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.anshulvyas.bakeittillyoumakeit.R;
import com.anshulvyas.bakeittillyoumakeit.data.model.Recipe;
import com.anshulvyas.bakeittillyoumakeit.databinding.ActivityRecipesBinding;

import javax.inject.Inject;

public class RecipesActivity extends AppCompatActivity {

    ActivityRecipesBinding mActivityRecipesBinding;
    private Recipe mRecipe;
    RecipesActivityViewModel mRecipeActivityViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);

        mActivityRecipesBinding = DataBindingUtil.setContentView(this, R.layout.activity_recipes);

    }


}
