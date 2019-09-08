package com.techno.expensetracker.Activities;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.techno.expensetracker.R;
import com.techno.expensetracker.Utils.CommonUtils;
import com.techno.expensetracker.Utils.Constants;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class BaseActivity extends AppCompatActivity {

    protected String TAG = BaseActivity.class.getSimpleName();

    protected ViewGroup fullView;

    protected ViewGroup mRootLayout;

    protected Toolbar toolbar;

    protected FrameLayout frameLayout;

    protected Activity activity;

    protected Context context;

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
            fullView = (LinearLayout) getLayoutInflater().inflate(R.layout.activity_base, null);
            frameLayout = (FrameLayout) fullView.findViewById(R.id.activity_content_base);
            mRootLayout = (LinearLayout) fullView.findViewById(R.id.activity_container_base);
            getLayoutInflater().inflate(layoutResID, frameLayout, true);
            super.setContentView(fullView);
            toolbar = (Toolbar) findViewById(R.id.toolbarBase);
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
}

