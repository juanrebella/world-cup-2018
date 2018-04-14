package com.example.nacho.world_cup_russia_2018.View;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.example.nacho.world_cup_russia_2018.Model.HttpConnection;
import com.example.nacho.world_cup_russia_2018.Properties.ListTeams;
import com.example.nacho.world_cup_russia_2018.R;

import java.util.LinkedList;
import java.util.List;

public class StadiumsActivity extends AppCompatActivity {


    ActionBar actionBar;
    DrawerLayout drawerLayout;
    TextView textView;
    ImageView Main;
    Toolbar toolbar;
    ListView listConmebol, listAsia;
    RequestQueue mQueue;

    HttpConnection service;
    ProgressDialog progressDialog;
    public List<ListTeams> listaConmebol = new LinkedList<ListTeams>(); // TODO: Cambiar a estadios


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stadiums);

        mQueue = Volley.newRequestQueue(getApplicationContext());

        /*- Action Bar y toolBar-*/
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_action_bar_icon);
        actionBar.setDisplayHomeAsUpEnabled(true);

        listConmebol = findViewById(R.id.lstConmebol);
        listAsia = findViewById(R.id.lstAsia);

        drawerLayout = findViewById(R.id.navigation_drawer_layout);


        NavigationView navigationView = findViewById(R.id.navigation_view);
        if (navigationView != null) {
            setupNavigationDrawerContent(navigationView);
        }

        setupNavigationDrawerContent(navigationView);


    }

    private void setupNavigationDrawerContent(NavigationView navigationView) {
            navigationView.setNavigationItemSelectedListener(
                    new NavigationView.OnNavigationItemSelectedListener() {
                        @Override
                        public boolean onNavigationItemSelected( MenuItem menuItem) {

                            switch (menuItem.getItemId()) {
                                case R.id.item_navigation_drawer_news:

                                /*- Noticias -*/

                                    menuItem.setChecked(true);
                                    drawerLayout.closeDrawer(GravityCompat.START);

                                    Intent intentNews = new Intent(StadiumsActivity.this, MainActivity.class);
                                    finish();
                                    startActivity(intentNews);

                                    break;

                                case R.id.item_navigation_drawer_teams:

                                /*- Equipos -*/
                                    menuItem.setChecked(true);
                                    drawerLayout.closeDrawer(GravityCompat.START);

                                    break;

                                case R.id.item_navigation_drawer_matches:

                                /*- Partidos -*/

                                    menuItem.setChecked(true);
                                    drawerLayout.closeDrawer(GravityCompat.START);

                                    Intent intentMatches = new Intent(StadiumsActivity.this, MatchesActivity.class);
                                    finish();
                                    startActivity(intentMatches);

                                    break;

                                case R.id.item_navigation_drawer_groups:

                                /*- Grupos -*/

                                    menuItem.setChecked(true);
                                    drawerLayout.closeDrawer(GravityCompat.START);

                                    Intent intentGroups = new Intent(StadiumsActivity.this, GroupsActivity.class);
                                    finish();
                                    startActivity(intentGroups);

                                    break;

                                case R.id.item_navigation_drawer_stadiums:

                                /*- Estadios -*/

                                    menuItem.setChecked(true);
                                    drawerLayout.closeDrawer(GravityCompat.START);

                                    break;

                                case R.id.item_navigation_drawer_about_us:

                                /*- Sobre Nosotros -*/

                                    menuItem.setChecked(true);
                                    drawerLayout.closeDrawer(GravityCompat.START);

                                    Intent intentAboutUs = new Intent(StadiumsActivity.this, AboutUsActivity.class);
                                    finish();
                                    startActivity(intentAboutUs);

                                    break;


                            }
                            return true;
                        }
                    });
    }
}
