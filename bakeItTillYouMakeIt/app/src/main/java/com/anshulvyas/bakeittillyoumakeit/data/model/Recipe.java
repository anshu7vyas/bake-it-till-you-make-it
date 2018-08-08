package com.anshulvyas.bakeittillyoumakeit.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Recipe implements Parcelable {

    /**
     * id : 2
     * name : Brownies
     * ingredients : List<RecipeIngredients>
     * steps : List<RecipeSteps>
     * servings : 8
     * image : ""
     */

    @SerializedName("id")
    private int recipeId;

    @SerializedName("name")
    private String recipeName;

    @SerializedName("servings")
    private int recipeServings;

    @SerializedName("image")
    private String recipeImage;

    @SerializedName("ingredients")
    private List<RecipeIngredients> recipeIngredientsList;

    @SerializedName("steps")
    private List<RecipeSteps> recipeStepsList;

    public Recipe() {
        this.recipeId = 0;
        this.recipeName = "";
        this.recipeServings = 0;
        this.recipeImage = "";
        this.recipeIngredientsList = new ArrayList<>();
        this.recipeStepsList = new ArrayList<>();
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public int getRecipeServings() {
        return recipeServings;
    }

    public void setRecipeServings(int recipeServings) {
        this.recipeServings = recipeServings;
    }

    public String getRecipeImage() {
        return recipeImage;
    }

    public void setRecipeImage(String recipeImage) {
        this.recipeImage = recipeImage;
    }

    public List<RecipeIngredients> getRecipeIngredientsList() {
        return recipeIngredientsList;
    }

    public void setRecipeIngredientsList(List<RecipeIngredients> recipeIngredientsList) {
        this.recipeIngredientsList = recipeIngredientsList;
    }

    public List<RecipeSteps> getRecipeStepsList() {
        return recipeStepsList;
    }

    public void setRecipeStepsList(List<RecipeSteps> recipeStepsList) {
        this.recipeStepsList = recipeStepsList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.recipeId);
        dest.writeString(this.recipeName);
        dest.writeString(this.recipeImage);
        dest.writeInt(this.recipeServings);
        dest.writeList(this.recipeIngredientsList);
        dest.writeList(this.recipeStepsList);
    }


    private Recipe(Parcel in) {
        recipeId = in.readInt();
        recipeName = in.readString();
        recipeServings = in.readInt();
        recipeImage = in.readString();
        recipeIngredientsList = in.createTypedArrayList(RecipeIngredients.CREATOR);
        recipeStepsList = in.createTypedArrayList(RecipeSteps.CREATOR);
    }

    public static final Creator<Recipe> CREATOR = new Creator<Recipe>() {
        @Override
        public Recipe createFromParcel(Parcel in) {
            return new Recipe(in);
        }

        @Override
        public Recipe[] newArray(int size) {
            return new Recipe[size];
        }
    };
}
