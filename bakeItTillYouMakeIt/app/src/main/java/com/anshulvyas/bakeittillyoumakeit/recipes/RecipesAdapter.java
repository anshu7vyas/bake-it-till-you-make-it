package com.anshulvyas.bakeittillyoumakeit.recipes;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anshulvyas.bakeittillyoumakeit.R;
import com.anshulvyas.bakeittillyoumakeit.data.model.Recipe;
import com.anshulvyas.bakeittillyoumakeit.databinding.RvRecipesListItemBinding;

import java.util.List;

public class RecipesAdapter extends RecyclerView.Adapter<RecipesAdapter.RecipesViewHolder> {

    private Context mContext;
    private List<Recipe> mRecipesList;

    RecipesAdapter (Context context) {
        this.mContext = context;
    }

    @NonNull
    @Override
    public RecipesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewDataBinding viewDataBinding = DataBindingUtil.inflate(
                LayoutInflater.from(mContext),
                R.layout.rv_recipes_list_item,
                parent,
                false);

        return new RecipesViewHolder(viewDataBinding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull RecipesViewHolder holder, int position) {
        Recipe recipe = mRecipesList.get(position);

        holder.rvRecipesListItemBinding.tvRecipeName.setText(recipe.getRecipeName());
        holder.rvRecipesListItemBinding.tvServings.setText(Integer.toString(recipe.getRecipeServings()));
    }

    @Override
    public int getItemCount() {
        if (null == mRecipesList) return 0;
        return mRecipesList.size();
    }

    class RecipesViewHolder extends RecyclerView.ViewHolder {
        RvRecipesListItemBinding rvRecipesListItemBinding;

        RecipesViewHolder(View itemView) {
            super(itemView);
            rvRecipesListItemBinding = DataBindingUtil.bind(itemView);
        }
    }

    public void setRecipesListData (List<Recipe> recipes) {
        mRecipesList = recipes;
        notifyDataSetChanged();
    }
}
