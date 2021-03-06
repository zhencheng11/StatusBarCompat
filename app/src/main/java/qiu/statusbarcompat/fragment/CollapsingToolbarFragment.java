package qiu.statusbarcompat.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import qiu.niorgai.StatusBarCompat;
import qiu.statusbarcompat.R;

/**
 * Compat CollapsingToolbarLayout
 * Created by qiu on 7/27/16.
 */
public class CollapsingToolbarFragment extends BaseFragment {

    public CollapsingToolbarFragment() {

    }

    private AppBarLayout mAppBarLayout;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;
    private Toolbar mToolbar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_collapsing_tool_bar, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(true);

        mAppBarLayout = (AppBarLayout) view.findViewById(R.id.appbar);
        mCollapsingToolbarLayout = (CollapsingToolbarLayout) view.findViewById(R.id.collapsing_toolbar);
        mCollapsingToolbarLayout.setTitle(getString(R.string.app_name));
        mToolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(mToolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        StatusBarCompat.setStatusBarColorForCollapsingToolbar(getActivity(), mAppBarLayout, mCollapsingToolbarLayout, mToolbar, Color.YELLOW);
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden) {
            StatusBarCompat.setStatusBarColorForCollapsingToolbar(getActivity(), mAppBarLayout, mCollapsingToolbarLayout, mToolbar, Color.YELLOW);
        }
    }
}
