package com.ttte.fonte;
           //so far so good  Amon;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    private ActionBarDrawerToggle mDrawerToggle; // this all neccesary for the App actionbar to work
    private ViewPager viewpagerA;          //  the viewpager with swiping features
    private  DrawerLayout drawerLayout;
    private ListView drawerlistView;

    String[] pages;



    @Override
        public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
                                //this is normal stuff
        setContentView(R.layout.main);
        // Generate sample data


        pages = new String[] { "pager1","pager2","pager3" };

         drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        drawerlistView = (ListView)findViewById(R.id.left_drawer);
        drawerlistView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,pages)); // setting the adapter for the drawer listview to listen to
        // setting the adapter for the drawer listview to listen to
        viewpagerA =(ViewPager)findViewById(R.id.viewpager_a);
        viewpagerA.setAdapter(new AdapterA(getApplicationContext(),viewpagerA)); //setting the adapter for the viewpager to listen to
         drawerlistView.setOnItemClickListener(new DrawerItemClickListener());
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);

                                       // this is all for the action bar
        mDrawerToggle = new ActionBarDrawerToggle(
                this,                  /* host Activity */
                drawerLayout,         /* DrawerLayout object */
                R.drawable.ic_drawer,  /* nav drawer image to replace 'Up' caret */
                R.string.drawer_open,  /* "open drawer" description for accessibility */
                R.string.drawer_close  /* "close drawer" description for accessibility */
        ) {
            public void onDrawerClosed(View view) {
                getActionBar().setTitle("closed");        //on closing this is what appears
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            public void onDrawerOpened(View drawerView) {
                getActionBar().setTitle("Open");        //on opening this is what appears
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };
        drawerLayout.setDrawerListener(mDrawerToggle);  // the drawer is listening to open when the Actionbar is clicked
    }

    @Override               //this is for the action bar button
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggls
        mDrawerToggle.onConfigurationChanged(newConfig);
    }
                            //this implements the listview items clicked
    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              selectItem(position);
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menux, menu);
        return super.onCreateOptionsMenu(menu);
            //To change body of overridden methods use File | Settings | File Templates.
    }

    //this activates the Actionbar to pull out the drawer
    public boolean onOptionsItemSelected(MenuItem item) {
        // The action bar home/up action should open or close the drawer.
        // ActionBarDrawerToggle will take care of this.
        switch (item.getItemId())
        {
            case R.id.menu_save2:
                //here you place wat you want the code to do;
            case R.id.menu_save3:
                //here you place wat you want the code to do;;
        }
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;           ///this make the Actionbar real open
        }
        return true;
    }
    //here is where we define when wat is clicked this should happen
    private void selectItem(int position){

        switch (position){
            case 0:
                viewpagerA.setCurrentItem(0);      //change the page when the list item with id 0 is placed
            case 1:
                viewpagerA.setCurrentItem(1) ;        //change the page when the list item with id 1 is placed
            case 2:
                viewpagerA.setCurrentItem(2) ;        //change the page when the list item with id 1 is placed

                drawerlistView.setItemChecked(position, true);

                drawerLayout.closeDrawer(drawerlistView);
        }

    }

}
