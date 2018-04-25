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
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nacho.world_cup_russia_2018.Model.HttpConnection;
import com.example.nacho.world_cup_russia_2018.R;

import java.net.URL;

public class GroupsActivity extends AppCompatActivity {

    ActionBar actionBar;
    ListView lstmenu;
    DrawerLayout drawerLayout;
    TextView textView;
    ImageView Main;
    Toolbar toolbar;
    Spinner spinner;

    URL url;
    HttpConnection service;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groups);



        String[] grupos = {"Grupo A", "Grupo B", "Grupo C",
                         "Grupo D", "Grupo E", "Grupo F", "Grupo G", "Grupo H"};

        HttpConnection service = new HttpConnection();
        // new ListadoEquipos().execute();

        /*- Action Bar-*/
        toolbar = findViewById(R.id.toolbar);
        hideToolbar();
        setSupportActionBar(toolbar);

        /*Action Bar*/
        actionBar();

        /*Spinner*/
        setSpinner(grupos);


        lstmenu = findViewById(R.id.lstMenu);
        drawerLayout = findViewById(R.id.navigation_drawer_layout);

        NavigationView navigationView = findViewById(R.id.navigation_view);
        if (navigationView != null) {
            setupNavigationDrawerContent(navigationView);
        }

        setupNavigationDrawerContent(navigationView);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        //Inflamos el menú
        getMenuInflater().inflate(R.menu.menu_icons, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {



            case R.id.refreshMain:
                //ABRIMOS EL DRAWER
                //Refrescaríamos la pantalla para ver noticias

                Toast.makeText(this, "Refrescando ...", Toast.LENGTH_SHORT).show();
                drawerLayout.openDrawer(GravityCompat.START);
                return true;

            case android.R.id.home:
                //ABRIMOS EL DRAWER
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
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


                                    break;

                                case R.id.item_navigation_drawer_teams:

                                /*- Equipos -*/
                                    menuItem.setChecked(true);
                                    drawerLayout.closeDrawer(GravityCompat.START);

                                    Intent intentTeams = new Intent(GroupsActivity.this, TeamsActivity.class);
                                    finish();
                                    startActivity(intentTeams);

                                    break;
                                case R.id.item_navigation_drawer_matches:

                                /*- Partidos -*/

                                    menuItem.setChecked(true);
                                    drawerLayout.closeDrawer(GravityCompat.START);

                                    Intent intentMatches = new Intent(GroupsActivity.this, MatchesActivity.class);
                                    finish();
                                    startActivity(intentMatches);

                                    break;

                                case R.id.item_navigation_drawer_groups:
                                /*- Grupos -*/

                                    menuItem.setChecked(true);
                                    drawerLayout.closeDrawer(GravityCompat.START);


                                    break;

                                case R.id.item_navigation_drawer_stadiums:

                                /*- Estadios -*/

                                    menuItem.setChecked(true);
                                    drawerLayout.closeDrawer(GravityCompat.START);

                                    Intent intentStadiums = new Intent(GroupsActivity.this, StadiumsActivity.class);
                                    finish();
                                    startActivity(intentStadiums);

                                    break;

                                case R.id.item_navigation_drawer_about_us:

                                /*- Sobre Nosotros -*/

                                    menuItem.setChecked(true);
                                    drawerLayout.closeDrawer(GravityCompat.START);

                                    Intent intentAboutUs = new Intent(GroupsActivity.this, AboutUsActivity.class);
                                    finish();
                                    startActivity(intentAboutUs);

                                    break;

                            }
                            return true;
                        }
                    });
    }

    private void hideToolbar(){
        toolbar.setTitle("");
    }

    private void actionBar() {
        actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_action_bar_icon);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    private void setSpinner(String[] grupos){
        spinner = findViewById(R.id.spinner);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(GroupsActivity.this,
                android.R.layout.simple_list_item_1, grupos);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

    }
}
