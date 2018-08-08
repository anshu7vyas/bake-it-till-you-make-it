package com.anshulvyas.bakeittillyoumakeit.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class RecipeSteps implements Parcelable {

    /**
     * id : 0
     * shortDescription : Recipe Introduction
     * description : Recipe Introduction
     * videoURL : https://d17h27t6h515a5.cloudfront.net/topher/2017/April/58ffdc33_-intro-brownies/-intro-brownies.mp4
     * thumbnailURL :
     */

    @SerializedName("id")
    private int recipeStepId;

    @SerializedName("shortDescription")
    private String recipeStepShortDescription;

    @SerializedName("description")
    private String recipeStepDescription;

    @SerializedName("videoURL")
    private String recipeStepVideoURL;

    @SerializedName("thumbnailURL")
    private String recipeStepThumbnailURL;

    public RecipeSteps() {
        this.recipeStepId = 0;
        this.recipeStepShortDescription = "";
        this.recipeStepDescription = "";
        this.recipeStepThumbnailURL = "";
        this.recipeStepVideoURL = "";
    }

    public int getRecipeStepId() {
        return recipeStepId;
    }

    public void setRecipeStepId(int recipeStepId) {
        this.recipeStepId = recipeStepId;
    }

    public String getRecipeStepShortDescription() {
        return recipeStepShortDescription;
    }

    public void setRecipeStepShortDescription(String recipeStepShortDescription) {
        this.recipeStepShortDescription = recipeStepShortDescription;
    }

    public String getRecipeStepDescription() {
        return recipeStepDescription;
    }

    public void setRecipeStepDescription(String recipeStepDescription) {
        this.recipeStepDescription = recipeStepDescription;
    }

    public String getRecipeStepVideoURL() {
        return recipeStepVideoURL;
    }

    public void setRecipeStepVideoURL(String recipeStepVideoURL) {
        this.recipeStepVideoURL = recipeStepVideoURL;
    }

    public String getRecipeStepThumbnailURL() {
        return recipeStepThumbnailURL;
    }

    public void setRecipeStepThumbnailURL(String recipeStepThumbnailURL) {
        this.recipeStepThumbnailURL = recipeStepThumbnailURL;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.recipeStepShortDescription);
        dest.writeString(this.recipeStepDescription);
        dest.writeString(this.recipeStepThumbnailURL);
        dest.writeString(this.recipeStepVideoURL);
        dest.writeInt(this.recipeStepId);
    }

    private RecipeSteps(Parcel in) {
        recipeStepId = in.readInt();
        recipeStepShortDescription = in.readString();
        recipeStepDescription = in.readString();
        recipeStepVideoURL = in.readString();
        recipeStepThumbnailURL = in.readString();
    }

    public static final Creator<RecipeSteps> CREATOR = new Creator<RecipeSteps>() {
        @Override
        public RecipeSteps createFromParcel(Parcel in) {
            return new RecipeSteps(in);
        }

        @Override
        public RecipeSteps[] newArray(int size) {
            return new RecipeSteps[size];
        }
    };
}
