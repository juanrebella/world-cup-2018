package com.example.nacho.world_cup_russia_2018.View;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nacho.world_cup_russia_2018.Config.URLRest;
import com.example.nacho.world_cup_russia_2018.Model.HttpConnection;
import com.example.nacho.world_cup_russia_2018.Properties.ListTeams;
import com.example.nacho.world_cup_russia_2018.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

             /*----------- Variables -------------*/


    ActionBar actionBar;
    ListView lstmenu;
    DrawerLayout drawerLayout;
    TextView textView;
    ImageView Main;
    Toolbar toolbar;
    String json = "https://my-json-server.typicode.com/juanrebella/gitCloneMirror2/oceania";

    URL url;
    HttpConnection service;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String[] grupo_a = {"Rusia", "Uruguay", "Arabia Saudita", "EEgipto"};

        HttpConnection service = new HttpConnection();
        // new ListadoEquipos().execute();

        /*- Action Bar-*/
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_action_bar_icon);
        actionBar.setDisplayHomeAsUpEnabled(true);

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
                return true;

            case android.R.id.home:
                //ABRIMOS EL DRAWER
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void setupNavigationDrawerContent( NavigationView navigationView){
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

                                Intent intentTeams = new Intent(MainActivity.this, TeamsActivity.class);
                                finish();
                                startActivity(intentTeams);

                                break;
                            case R.id.item_navigation_drawer_matches:

                                /*- Partidos -*/

                                menuItem.setChecked(true);
                                drawerLayout.closeDrawer(GravityCompat.START);

                                Intent intentMatches = new Intent(MainActivity.this, MatchesActivity.class);
                                finish();
                                startActivity(intentMatches);

                                break;

                            case R.id.item_navigation_drawer_groups:
                                /*- Grupos -*/

                                menuItem.setChecked(true);
                                drawerLayout.closeDrawer(GravityCompat.START);

                                Intent intentGroups = new Intent(MainActivity.this, GroupsActivity.class);
                                finish();
                                startActivity(intentGroups);

                                break;

                            case R.id.item_navigation_drawer_stadiums:

                                /*- Estadios -*/

                                menuItem.setChecked(true);
                                drawerLayout.closeDrawer(GravityCompat.START);

                                Intent intentStadiums = new Intent(MainActivity.this, StadiumsActivity.class);
                                finish();
                                startActivity(intentStadiums);

                                break;

                            case R.id.item_navigation_drawer_about_us:

                                /*- Sobre Nosotros -*/

                                menuItem.setChecked(true);
                                drawerLayout.closeDrawer(GravityCompat.START);

                                Intent intentAboutUs = new Intent(MainActivity.this, AboutUsActivity.class);
                                finish();
                                startActivity(intentAboutUs);

                                break;

                        }
                        return true;
                    }
                });
    }


}
