package com.anshulvyas.bakeittillyoumakeit.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class RecipeIngredients implements Parcelable {

    /**
     * quantity : 350
     * measure : G
     * ingredient : Bittersweet chocolate (60-70% cacao)
     */

    @SerializedName("quantity")
    private double ingredientQuantity;

    @SerializedName("measure")
    private String ingredientMeasure;

    @SerializedName("ingredient")
    private String ingredientName;

    public RecipeIngredients() {
        this.ingredientQuantity = 0;
        this.ingredientMeasure = "";
        this.ingredientName = "";
    }

    public double getIngredientQuantity() {
        return ingredientQuantity;
    }

    public void setIngredientQuantity(int ingredientQuantity) {
        this.ingredientQuantity = ingredientQuantity;
    }

    public String getIngredientMeasure() {
        return ingredientMeasure;
    }

    public void setIngredientMeasure(String ingredientMeasure) {
        this.ingredientMeasure = ingredientMeasure;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(ingredientQuantity);
        dest.writeString(ingredientMeasure);
        dest.writeString(ingredientName);
    }

    private RecipeIngredients(Parcel in) {
        ingredientQuantity = in.readDouble();
        ingredientMeasure = in.readString();
        ingredientName = in.readString();
    }

    public static final Parcelable.Creator<RecipeIngredients> CREATOR = new Parcelable.Creator<RecipeIngredients>() {
        @Override
        public RecipeIngredients createFromParcel(Parcel in) {
            return new RecipeIngredients(in);
        }

        @Override
        public RecipeIngredients[] newArray(int size) {
            return new RecipeIngredients[size];
        }
    };
}
