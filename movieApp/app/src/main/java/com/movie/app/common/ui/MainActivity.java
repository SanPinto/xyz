package com.movie.app.common.ui;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.movie.app.R;
import com.movie.app.common.presenter.NavigationDrawerContract;
import com.movie.app.common.presenter.NavigationDrawrPresenterImpl;

public class MainActivity extends AppCompatActivity implements NavigationDrawerContract.NavigationDrawerView, AdapterView.OnItemClickListener {

    private ListView mNavigationListView;
    private NavigationDrawrPresenterImpl mPresenter;
    private NavigationDrawerAdapter mNavigationDrawerAdapter;
    private DrawerLayout mDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initPresenter();
        setNavigationMenu();

    }

    private void setNavigationMenu() {
        mNavigationDrawerAdapter = new NavigationDrawerAdapter(this, mPresenter.getNavigationItems(this));
        mNavigationListView.setAdapter(mNavigationDrawerAdapter);
        mNavigationListView.performItemClick(mNavigationListView.getChildAt(0), 0, mNavigationListView.getItemIdAtPosition(0));
        mNavigationListView.setSelection(0);
    }

    private void initPresenter() {
        mPresenter = new NavigationDrawrPresenterImpl();
        mPresenter.setView(this);
    }

    private void initViews() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        mDrawer.addDrawerListener(toggle);
        toggle.syncState();
        mNavigationListView = (ListView) findViewById(R.id.navigation_list);
        mNavigationListView.setOnItemClickListener(this);
    }

    private void closeDrawer() {
        mPresenter.closeDrawer(mDrawer);
    }

    @Override
    public void onBackPressed() {
        if (mPresenter.isDrawerOpen(mDrawer)) {
            closeDrawer();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
        if (mPresenter != null) {
            mPresenter.onNavigationItemSelected(mNavigationDrawerAdapter.getNavigationList(), pos,
                    getSupportFragmentManager(), this, R.id.container);
            mPresenter.closeDrawer(mDrawer);
        }

    }


    @Override
    public void updateNavDrawer(int position) {
        if (mNavigationListView != null) {
            mNavigationListView.setItemChecked(position, true);
        }
    }
}
