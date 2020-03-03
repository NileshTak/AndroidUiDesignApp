/*
 * Copyright (C) 2018-2019 Samuel Wall
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.nilprojects.androiduidesign.Activities.TargetPrompt;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import com.nilprojects.androiduidesign.CommonUtils.Utils;
import com.nilprojects.androiduidesign.R;

import org.jetbrains.annotations.NotNull;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;
import uk.co.samuelwall.materialtaptargetprompt.MaterialTapTargetPrompt;
import uk.co.samuelwall.materialtaptargetprompt.MaterialTapTargetSequence;
import uk.co.samuelwall.materialtaptargetprompt.extras.backgrounds.FullscreenPromptBackground;
import uk.co.samuelwall.materialtaptargetprompt.extras.backgrounds.RectanglePromptBackground;
import uk.co.samuelwall.materialtaptargetprompt.extras.focals.RectanglePromptFocal;

public class MainActivityTargetPrompt extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener
{
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }

    private ActionMode mActionMode;
    private ActionMode.Callback mActionModeCallback = new ActionMode.Callback()
    {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu)
        {
            MenuInflater inflater = mode.getMenuInflater();
            inflater.inflate(R.menu.actionmode, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu)
        {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item)
        {
            mActionMode.finish();
            return true;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode)
        {
            mActionMode = null;
        }
    };

    MaterialTapTargetPrompt mFabPrompt;

    public void showFabPrompt(View view)
    {
        if (mFabPrompt != null)
        {
            return;
        }
        SpannableStringBuilder secondaryText = new SpannableStringBuilder("Tap the envelope to start composing your first email");
        secondaryText.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this, R.color.colorAccent)), 8, 15, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        SpannableStringBuilder primaryText = new SpannableStringBuilder("Send your first email");
        primaryText.setSpan(new BackgroundColorSpan(ContextCompat.getColor(this, R.color.colorAccent)), 0, 4, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        mFabPrompt = new MaterialTapTargetPrompt.Builder(MainActivityTargetPrompt.this)
                .setTarget(findViewById(R.id.fab))
                .setFocalPadding(R.dimen.dp40)
                .setPrimaryText(primaryText)
                .setSecondaryText(secondaryText)
                .setBackButtonDismissEnabled(true)
                .setAnimationInterpolator(new FastOutSlowInInterpolator())
                .setPromptStateChangeListener((prompt, state) -> {
                    if (state == MaterialTapTargetPrompt.STATE_FOCAL_PRESSED
                            || state == MaterialTapTargetPrompt.STATE_NON_FOCAL_PRESSED)
                    {
                        mFabPrompt = null;
                        //Do something such as storing a value so that this prompt is never shown again
                    }
                })
                .create();
        if (mFabPrompt != null)
        {
            mFabPrompt.show();
        }
    }

    public void showFabPromptFor(View view)
    {
        new MaterialTapTargetPrompt.Builder(MainActivityTargetPrompt.this)
                .setTarget(findViewById(R.id.fab))
                .setFocalPadding(R.dimen.dp40)
                .setPrimaryText("showFor(7000)")
                .setSecondaryText("This prompt will show for 7 seconds")
                .setAnimationInterpolator(new FastOutSlowInInterpolator())
                .setPromptStateChangeListener((prompt, state) -> {
                    if (state == MaterialTapTargetPrompt.STATE_SHOW_FOR_TIMEOUT)
                    {

                        Toast.makeText(MainActivityTargetPrompt.this,
                            "Prompt timedout after 7 seconds", Toast.LENGTH_SHORT)
                            .show();
                    }
                })
                .showFor(7000);
    }

    public void showNavPrompt(View view)
    {
        new MaterialTapTargetPrompt.Builder(this)
                .setTarget(R.id.navfab)
                .setPrimaryText(R.string.example_fab_title)
                .setSecondaryText(R.string.example_fab_description)
                .setAnimationInterpolator(new FastOutSlowInInterpolator())
                .setMaxTextWidth(R.dimen.tap_target_menu_max_width)
                .show();
    }

    public void showSideNavigationPrompt(View view)
    {
        final MaterialTapTargetPrompt.Builder tapTargetPromptBuilder = new MaterialTapTargetPrompt.Builder(this)
                .setPrimaryText(R.string.menu_prompt_title)
                .setSecondaryText(R.string.menu_prompt_description)
                .setContentDescription(R.string.menu_prompt_content_description)
                .setFocalPadding(R.dimen.dp40)
                .setAnimationInterpolator(new FastOutSlowInInterpolator())
                .setMaxTextWidth(R.dimen.tap_target_menu_max_width)
                .setIcon(R.drawable.ic_menu);
        final Toolbar tb = this.findViewById(R.id.toolbar);
        tapTargetPromptBuilder.setTarget(tb.getChildAt(1));

        tapTargetPromptBuilder.setPromptStateChangeListener((prompt, state) -> {
            if (state == MaterialTapTargetPrompt.STATE_FOCAL_PRESSED)
            {
                //Do something such as storing a value so that this prompt is never shown again
            }
        });
        tapTargetPromptBuilder.show();
    }

    public void showOverflowPrompt(View view)
    {
        final MaterialTapTargetPrompt.Builder tapTargetPromptBuilder = new MaterialTapTargetPrompt.Builder(this)
                .setPrimaryText(R.string.overflow_prompt_title)
                .setSecondaryText(R.string.overflow_prompt_description)
                .setAnimationInterpolator(new FastOutSlowInInterpolator())
                .setMaxTextWidth(R.dimen.tap_target_menu_max_width)
                .setIcon(R.drawable.ic_more_vert);
        final Toolbar tb = this.findViewById(R.id.toolbar);
        final View child = tb.getChildAt(2);
        if (child instanceof ActionMenuView)
        {
            final ActionMenuView actionMenuView = ((ActionMenuView) child);
            tapTargetPromptBuilder.setTarget(actionMenuView.getChildAt(actionMenuView.getChildCount() - 1));
        }
        else
        {
            Toast.makeText(this, R.string.overflow_unavailable, Toast.LENGTH_SHORT).show();
        }
        tapTargetPromptBuilder.show();
    }

    public void showSearchPrompt(View view)
    {
        new MaterialTapTargetPrompt.Builder(this)
                .setPrimaryText(R.string.search_prompt_title)
                .setSecondaryText(R.string.search_prompt_description)
                .setAnimationInterpolator(new FastOutSlowInInterpolator())
                .setMaxTextWidth(R.dimen.tap_target_menu_max_width)
                .setIcon(R.drawable.ic_search)
                .setTarget(R.id.action_search)
                .show();
    }

    public void showBottomSheetDialogPrompt(View view)
    {
        final BottomSheetDialogFragmentExample bottomSheetDialogFragmentExample =
                new BottomSheetDialogFragmentExample();

        bottomSheetDialogFragmentExample.show(getSupportFragmentManager(),
                bottomSheetDialogFragmentExample.getTag());
    }

    public void showStylePrompt(View view)
    {
        final MaterialTapTargetPrompt.Builder builder = new MaterialTapTargetPrompt.Builder(this, R.style.MaterialTapTargetPromptTheme_FabTarget);
        final Toolbar tb = this.findViewById(R.id.toolbar);
        final View child = tb.getChildAt(2);
        if (child instanceof ActionMenuView)
        {
            final ActionMenuView actionMenuView = ((ActionMenuView) child);
            builder.setTarget(actionMenuView.getChildAt(actionMenuView.getChildCount() - 1));
        }
        else
        {
            Toast.makeText(this, R.string.overflow_unavailable, Toast.LENGTH_SHORT).show();
        }
        builder.setIcon(R.drawable.ic_more_vert)
                .show();
    }

    public void showRectPrompt(View view)
    {
        new MaterialTapTargetPrompt.Builder(this)
                .setTarget(view)
                .setPrimaryText("Different shapes")
                .setSecondaryText("Extend PromptFocal or PromptBackground to change the shapes")
                .setPromptBackground(new RectanglePromptBackground())
                .setPromptFocal(new RectanglePromptFocal())
                .show();
    }

    public void showFullscreenRectPrompt(View view)
    {
        new MaterialTapTargetPrompt.Builder(this)
                .setTarget(view)
                .setPrimaryText("Different shapes")
                .setSecondaryText("Extend PromptFocal or PromptBackground to change the shapes")
                .setPromptBackground(new FullscreenPromptBackground())
                .setPromptFocal(new RectanglePromptFocal())
                .show();
    }

    public void showDialog(View view)
    {
        startActivity(new Intent(this, DialogStyleActivity.class));
    }

    public void showSupportFragmentDialog(View view)
    {
        new SupportDialogFragmentExample().show(this.getSupportFragmentManager(), "DIALOGFRAGMENT");
    }

    public void showActionModePrompt(View view)
    {
        mActionMode = this.startSupportActionMode(mActionModeCallback);
        new MaterialTapTargetPrompt.Builder(MainActivityTargetPrompt.this)
                .setPrimaryText(R.string.action_mode_prompt_title)
                .setSecondaryText(R.string.action_mode_prompt_description)
                .setFocalPadding(R.dimen.dp40)
                .setAnimationInterpolator(new FastOutSlowInInterpolator())
                .setMaxTextWidth(R.dimen.tap_target_menu_max_width)
                .setTarget(findViewById(R.id.action_mode_close_button))
                .setIcon(R.drawable.ic_back)
                .show();
    }

    public void showKotlinActivity(View view)
    {
        startActivity(new Intent(this, KotlinActivity.class));
    }


    public void showCentreActivity(View view)
    {
        startActivity(new Intent(this, CentrePositionActivity.class));
    }

    public void showCardsActivity(View view)
    {
        startActivity(new Intent(this, CardActivity.class));
    }

    public void showSequence(View view) {

        new MaterialTapTargetSequence()
            .addPrompt(new MaterialTapTargetPrompt.Builder(MainActivityTargetPrompt.this)
                .setTarget(findViewById(R.id.fab))
                .setPrimaryText("Step 1")
                .setSecondaryText("This will show for 4 seconds")
                .setFocalPadding(R.dimen.dp40)
                .create(), 4000)
            .addPrompt(new MaterialTapTargetPrompt.Builder(MainActivityTargetPrompt.this)
                .setTarget(findViewById(R.id.action_search))
                .setPrimaryText("Step 2")
                .setSecondaryText("This will show till you press it")
                .setAnimationInterpolator(new LinearOutSlowInInterpolator())
                .setFocalPadding(R.dimen.dp40)
                .setIcon(R.drawable.ic_search))
            .show();
    }

    public void showListActivity(View view)
    {
        startActivity(new Intent(this, ListActivity.class));
    }

    public void showNoAutoDismiss(View view)
    {
        if (mFabPrompt != null)
        {
            return;
        }
        mFabPrompt = new MaterialTapTargetPrompt.Builder(MainActivityTargetPrompt.this)
                .setTarget(findViewById(R.id.fab))
                .setPrimaryText("No Auto Dismiss")
                .setSecondaryText("This prompt will only be removed after tapping the envelop")
                .setAnimationInterpolator(new FastOutSlowInInterpolator())
                .setAutoDismiss(false)
                .setAutoFinish(false)
                .setCaptureTouchEventOutsidePrompt(true)
                .setPromptStateChangeListener((prompt, state) -> {
                    if (state == MaterialTapTargetPrompt.STATE_FOCAL_PRESSED)
                    {
                        prompt.finish();
                        mFabPrompt = null;
                    }
                    else if (state == MaterialTapTargetPrompt.STATE_NON_FOCAL_PRESSED)
                    {
                        mFabPrompt = null;
                    }
                })
                .show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_target_prompt);
        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            if (mFabPrompt != null)
            {
                mFabPrompt.finish();
                mFabPrompt = null;
            }
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                    .setAction("Action", null).show();

            Utils.INSTANCE.navigateToGithub("https://github.com/sjwall/MaterialTapTargetPrompt",this);

        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed()
    {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NotNull MenuItem item)
    {
        // Handle navigation view item clicks here.
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
