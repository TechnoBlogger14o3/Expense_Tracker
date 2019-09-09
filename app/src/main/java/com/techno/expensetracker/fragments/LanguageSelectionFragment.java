package com.techno.expensetracker.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.techno.expensetracker.Adapters.LangSelectionAdapter;
import com.techno.expensetracker.R;
import com.techno.expensetracker.model.LanguageSelectionDataModel;

import java.util.ArrayList;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class LanguageSelectionFragment extends CoreFragment implements LangSelectionAdapter.ItemListener {

    private View view;
    private RecyclerView languageSelectionRecyclerView;
    private LangSelectionAdapter adapter;
    private ArrayList<LanguageSelectionDataModel> modelArrayList = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_language_selection, container, false);
        showToolBar();
        hideBottomBar();
        setDisplayShowTitleEnabled(false);
        initView();
        return view;
    }

    private void initView() {
        languageSelectionRecyclerView = view.findViewById(R.id.languageSelectionRecyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(mActivity, 2);
        languageSelectionRecyclerView.setLayoutManager(gridLayoutManager);

        modelArrayList = new ArrayList<>();

        LanguageSelectionDataModel model = new LanguageSelectionDataModel();
        model.setText(getString(R.string.english));
        model.setColor("#FF8585");
        modelArrayList.add(model);

        model = new LanguageSelectionDataModel();
        model.setText(getString(R.string.hindi));
        model.setColor("#FFA16C");
        modelArrayList.add(model);

        model = new LanguageSelectionDataModel();
        model.setText(getString(R.string.kannada));
        model.setColor("#999DFF");
        modelArrayList.add(model);

        model = new LanguageSelectionDataModel();
        model.setText(getString(R.string.telugu));
        model.setColor("#F8CD38");
        modelArrayList.add(model);

        model = new LanguageSelectionDataModel();
        model.setText(getString(R.string.gujarati));
        model.setColor("#CB67FA");
        modelArrayList.add(model);

        model = new LanguageSelectionDataModel();
        model.setText(getString(R.string.marathi));
        model.setColor("#73CBFC");
        modelArrayList.add(model);

        model = new LanguageSelectionDataModel();
        model.setText(getString(R.string.tamil));
        model.setColor("#8AE982");
        modelArrayList.add(model);

        adapter = new LangSelectionAdapter(mActivity, modelArrayList, this);
        languageSelectionRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(LanguageSelectionDataModel item, int position) {
        for (int i = 0; i < modelArrayList.size(); i++) {
            if (i == position) {
                modelArrayList.get(i).setSelected(true);
            } else {
                modelArrayList.get(i).setSelected(false);
            }
        }
        adapter.notifyDataSetChanged();
    }
}
