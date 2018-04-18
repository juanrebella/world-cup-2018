package com.example.nacho.world_cup_russia_2018.View;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.nacho.world_cup_russia_2018.Adapter.StadiumAdapter;
import com.example.nacho.world_cup_russia_2018.Config.URLRest;
import com.example.nacho.world_cup_russia_2018.Properties.ListStadiums;
import com.example.nacho.world_cup_russia_2018.R;
import com.github.snowdream.android.widget.SmartImageView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

public class DetailsStadiumActivity extends AppCompatActivity {

    ActionBar actionBar;
    DrawerLayout drawerLayout;
    TextView nombreEstadio, titleDetailsStadium, ciudadEstadio;
    ImageView imageStadiumDetails;
    Toolbar toolbar;
    RequestQueue mQueue;
    StadiumAdapter adapter;
    String url = URLRest.urlApi;
    SmartImageView smartView;

    public String itemSelect, imgStadiumIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_stadium);

        mQueue = Volley.newRequestQueue(getApplicationContext());

        /*- Action Bar y toolBar-*/
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_action_bar_icon);
        actionBar.setDisplayHomeAsUpEnabled(true);

        drawerLayout = findViewById(R.id.navigation_drawer_layout);

        smartView = findViewById(R.id.imageStadiumDetails);
        titleDetailsStadium = findViewById(R.id.titleDetailsStadium);
        nombreEstadio = findViewById(R.id.nombreEstadio);
        ciudadEstadio = findViewById(R.id.ciudadEstadio);

        NavigationView navigationView = findViewById(R.id.navigation_view);
        if (navigationView != null) {
            setupNavigationDrawerContent(navigationView);
        }
        setupNavigationDrawerContent(navigationView);


        Bundle params = getIntent().getExtras();
        if (params != null) {

            //TODO: Pasar la imagen (json object) de StadiumActivity a DetailsStadiumActivity como Intent Putextra

            itemSelect = params.getString("titulo");
            titleDetailsStadium.setText(itemSelect);
        } else {
            Toast.makeText(getApplicationContext(), null, Toast.LENGTH_LONG).show();
        }

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

                //TODO: refrescar la activity, buscar solución.
                Toast.makeText(this, "Refrescando", Toast.LENGTH_SHORT).show();
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

                                Intent intentNews = new Intent(DetailsStadiumActivity.this, MainActivity.class);
                                finish();
                                startActivity(intentNews);

                                break;

                            case R.id.item_navigation_drawer_teams:

                                /*- Equipos -*/
                                menuItem.setChecked(true);
                                drawerLayout.closeDrawer(GravityCompat.START);
                                Intent intentTeams = new Intent(DetailsStadiumActivity.this, TeamsActivity.class);
                                finish();
                                startActivity(intentTeams);

                                break;

                            case R.id.item_navigation_drawer_matches:

                                /*- Partidos -*/

                                menuItem.setChecked(true);
                                drawerLayout.closeDrawer(GravityCompat.START);

                                Intent intentMatches = new Intent(DetailsStadiumActivity.this, MatchesActivity.class);
                                finish();
                                startActivity(intentMatches);

                                break;

                            case R.id.item_navigation_drawer_groups:

                                /*- Grupos -*/

                                menuItem.setChecked(true);
                                drawerLayout.closeDrawer(GravityCompat.START);

                                Intent intentGroups = new Intent(DetailsStadiumActivity.this, GroupsActivity.class);
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

                                Intent intentAboutUs = new Intent(DetailsStadiumActivity.this, AboutUsActivity.class);
                                finish();
                                startActivity(intentAboutUs);

                                break;


                        }
                        return true;
                    }
                });
    }

    }
