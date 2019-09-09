package com.techno.expensetracker.Adapters;


import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.techno.expensetracker.R;
import com.techno.expensetracker.model.LanguageSelectionDataModel;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LangSelectionAdapter extends RecyclerView.Adapter<LangSelectionAdapter.ViewHolder> {

    protected ItemListener mListener;
    ArrayList<LanguageSelectionDataModel> mValues;
    Context mContext;

    public LangSelectionAdapter(Context context, ArrayList<LanguageSelectionDataModel> values, ItemListener itemListener) {
        mValues = values;
        mContext = context;
        mListener = itemListener;
    }

    @Override
    public LangSelectionAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_lang_slection_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LangSelectionAdapter.ViewHolder holder, int position) {
        holder.setData(mValues.get(position));
        holder.listItemRootView.setTag(position);
    }

    @Override
    public int getItemCount() {

        return mValues.size();
    }

    public interface ItemListener {
        void onItemClick(LanguageSelectionDataModel item, int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView listItemTVView;
        public RelativeLayout listItemRootView;
        public ImageView listItemSelectedView;
        LanguageSelectionDataModel item;

        public ViewHolder(View v) {

            super(v);
            listItemTVView = v.findViewById(R.id.listItemTVView);
            listItemRootView = v.findViewById(R.id.listItemRootView);
            listItemSelectedView = v.findViewById(R.id.listItemSelectedView);
            listItemRootView.setOnClickListener(this);
        }

        public void setData(LanguageSelectionDataModel item) {
            this.item = item;
            listItemTVView.setText(item.text);
            listItemTVView.setBackgroundColor(Color.parseColor(item.color));
            listItemSelectedView.setVisibility(item.isSelected() ? View.VISIBLE : View.GONE);
        }


        @Override
        public void onClick(View view) {
            int position = (int) view.getTag();
            if (mListener != null) {
                mListener.onItemClick(item, position);
            }
        }
    }
}
