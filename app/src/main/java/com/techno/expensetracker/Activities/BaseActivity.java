package com.techno.expensetracker.Activities;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.techno.expensetracker.R;
import com.techno.expensetracker.Utils.CommonUtils;
import com.techno.expensetracker.Utils.Constants;
import com.techno.expensetracker.fragments.HomeDashBoardFragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class BaseActivity extends AppCompatActivity {

    protected Activity activity;
    protected Context context;
    private String TAG = BaseActivity.class.getSimpleName();
    private ViewGroup fullView;
    private ViewGroup mRootLayout;
    private Toolbar toolbar;
    private FrameLayout frameLayout;
    private BottomNavigationView mBottomBar;
    private Window window;
    private int apiLevel = 0;

    @Override
    public void setContentView(int layoutResID) {
        try {
            context = activity = this;
            apiLevel = android.os.Build.VERSION.SDK_INT;
            if (apiLevel > 20) {
                window = getWindow();
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                setStatusBarBackground(getResources().getColor(R.color.transparent));
                setStatusBarBackground(
                        getResources()
                                .getDrawable(R.drawable.background_statusbar_tri_color));
            }
            fullView = (ViewGroup) getLayoutInflater().inflate(R.layout.activity_base, null);
            frameLayout = fullView.findViewById(R.id.activity_content_base);
            mRootLayout = (RelativeLayout) fullView.findViewById(R.id.activity_container_base);
            mBottomBar = fullView.findViewById(R.id.bottomBarBase);
            getLayoutInflater().inflate(layoutResID, frameLayout, true);
            super.setContentView(fullView);
            toolbar = findViewById(R.id.toolbarBase);
            setSupportActionBar(toolbar);

            setDisplayHomeAsUpEnabled(true);
            setHomeButtonEnabled(true);
            setDefaultDisplayHomeAsUpEnabled(true);
            setDisplayShowTitleEnabled(true);

            if (!Constants.IS_TABLET) {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            }
        } catch (Exception e) {

        }
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
    }

    @Override
    protected void onPause() {
        CommonUtils.hideKeyBoard(activity, fullView);
        super.onPause();
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() <= 1) {
            finish();
        } else {
            super.onBackPressed();
        }
    }

    public void setToolbarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    public void setToolbarTitle(int title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    public void setToolbarSubTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setSubtitle(title);
        }
    }

    public void setToolbarSubTitle(int title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setSubtitle(title);
        }
    }

    public void showToolBar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().show();
        }
    }

    public void hideToolBar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }

    public void showBottomBar() {
        if (mBottomBar != null) {
            mBottomBar.setVisibility(View.VISIBLE);
        }
    }

    public void hideBottomBar() {
        if (mBottomBar != null) {
            mBottomBar.setVisibility(View.GONE);
        }
    }

    public void setBackNavigationIcon(Drawable drawable) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setIcon(drawable);
        }
    }

    public void setBackNavigationIcon(int icon) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setIcon(icon);
        }
    }

    public void setDisplayHomeAsUpEnabled(boolean enable) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(enable);
        }
    }

    public void setHomeButtonEnabled(boolean enable) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setHomeButtonEnabled(enable);
        }
    }

    public void setDefaultDisplayHomeAsUpEnabled(boolean enable) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(enable);
        }
    }

    public void setDisplayShowTitleEnabled(boolean enable) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(enable);
        }
    }

    public void setStatusBarBackground(int color) {
        if (window != null) {
            window.setStatusBarColor(color);
        }
    }

    public void setStatusBarBackground(Drawable drawable) {
        if (window != null) {
            window.setBackgroundDrawable(drawable);
        }
    }

    public void setRootBackground(Drawable drawable) {
        if (mRootLayout != null) {
            mRootLayout.setBackground(drawable);
        }
    }

    public void setRootBackground(int drawable) {
        if (mRootLayout != null) {
            mRootLayout.setBackgroundResource(drawable);
        }
    }

    public void callFragment(Fragment fragment, boolean isFragmentAdd) {
        if (!isFinishing()) {
            String fragmentTag = fragment.getClass().getSimpleName();
            int backStackEntryCount = getSupportFragmentManager().getBackStackEntryCount();
            if (backStackEntryCount > 0) {
                String name = getSupportFragmentManager().getBackStackEntryAt(backStackEntryCount - 1).getName();

                if (name.equals(fragmentTag)) {
                    return;
                }
            }
            FragmentManager manager = getSupportFragmentManager();
            if (fragmentTag.equalsIgnoreCase(HomeDashBoardFragment.class.getSimpleName())) {
                //If user press home screen, need to clear stack, if user press again back button in home for closing app
                boolean fragmentPopped = manager.popBackStackImmediate(fragmentTag, 0);
            }
            FragmentTransaction ft = manager.beginTransaction();
            if (isFragmentAdd) {
                ft.add(R.id.fragment_id_container, fragment, fragmentTag);
            } else {
                ft.replace(R.id.fragment_id_container, fragment, fragmentTag);
            }
            ft.addToBackStack(fragmentTag);
            ft.commitAllowingStateLoss();
        }
    }

    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.navigation_home:
                Toast.makeText(this, "Home clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navigation_report:
                Toast.makeText(this, "Report clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navigation_video:
                Toast.makeText(this, "Video clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navigation_profile:
                Toast.makeText(this, "Profile clicked", Toast.LENGTH_SHORT).show();
                break;
        }
        return false;
    }
}

