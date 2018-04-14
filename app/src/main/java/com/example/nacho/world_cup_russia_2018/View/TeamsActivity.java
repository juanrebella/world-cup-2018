package com.example.nacho.world_cup_russia_2018.View;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.nacho.world_cup_russia_2018.Adapter.TeamsAdapter;
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
import java.util.LinkedList;
import java.util.List;

public class TeamsActivity extends AppCompatActivity {

    ActionBar actionBar;
    DrawerLayout drawerLayout;
    TextView textView;
    ImageView Main;
    Toolbar toolbar;
    ListView listConmebol, listAsia;
    String url = URLRest.urlApi;


    RequestQueue mQueue;
    /*- Variables Json Object -*/


    TeamsAdapter adapter, adapter2;
    private int status = 0;

    HttpConnection service;
    ProgressDialog progressDialog;
    public List<ListTeams> listaConmebol = new LinkedList<ListTeams>();
    public List<ListTeams> listaAsia = new LinkedList<ListTeams>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams);

        mQueue = Volley.newRequestQueue(getApplicationContext());


        /*- Action Bar-*/
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Log.e("ERROR2", "Hasta acá llegó bien!");

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


        //Listas

        listConmebol.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Has clickeado algo " + position, Toast.LENGTH_SHORT).show();

            }
        });

        listAsia.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Has clickeado algo " + position + " en asia", Toast.LENGTH_SHORT).show();

            }
        });




        JsonObjectRequest json = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray =  response.getJSONArray("conmebol");

                            for (int i = 0; i < jsonArray.length(); i++){
                                JSONObject object = jsonArray.getJSONObject(i);
                                ListTeams objDatos = new ListTeams();



                                String name = object.getString("name");
                                String group = object.getString("group_id");
                                String trophies = object.getString("trophies");
                                String imagenes = object.getString("url");


                                objDatos.setTeamName("Equipo " +name);
                                objDatos.setGroup("Grupo " +group);
                                objDatos.setTrophies("Títulos: " +trophies);
                                objDatos.setImages(imagenes);

                                listaConmebol.add(objDatos);




                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        adapter.notifyDataSetChanged();
                    }

                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                AlertDialog.Builder add = new AlertDialog.Builder(TeamsActivity.this);
                add.setMessage(error.getMessage()).setCancelable(true);
                AlertDialog alert = add.create();
                alert.setTitle("Error!!!");
                alert.show();

            }
      });

        mQueue.add(json);


        JsonObjectRequest json2 = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray =  response.getJSONArray("asia");

                            for (int i = 0; i < jsonArray.length(); i++){
                                JSONObject object = jsonArray.getJSONObject(i);
                                ListTeams objDatos2 = new ListTeams();



                                String name = object.getString("name");
                                String group = object.getString("group_id");
                                String trophies = object.getString("trophies");
                                String imagenes = object.getString("url");


                                objDatos2.setTeamName("Equipo " +name);
                                objDatos2.setGroup("Grupo " +group);
                                objDatos2.setTrophies("Títulos: " +trophies);
                                objDatos2.setTrophies(imagenes);


                                listaAsia.add(objDatos2);




                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        adapter2.notifyDataSetChanged();
                    }

                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                AlertDialog.Builder add = new AlertDialog.Builder(TeamsActivity.this);
                add.setMessage(error.getMessage()).setCancelable(true);
                AlertDialog alert = add.create();
                alert.setTitle("Error!!!");
                alert.show();

            }
        });

        mQueue.add(json2);


            adapter = new TeamsAdapter(TeamsActivity.this, listaConmebol);
            adapter2 = new TeamsAdapter(TeamsActivity.this, listaAsia);

        listConmebol.setAdapter(adapter);
        listAsia.setAdapter(adapter2);
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

                Toast.makeText(this, "Refrescando", Toast.LENGTH_SHORT).show();
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

                                Intent intentNews = new Intent(TeamsActivity.this, MainActivity.class);
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

                                Intent intentMatches = new Intent(TeamsActivity.this, MatchesActivity.class);
                                finish();
                                startActivity(intentMatches);

                                break;

                            case R.id.item_navigation_drawer_groups:

                                /*- Grupos -*/

                                menuItem.setChecked(true);
                                drawerLayout.closeDrawer(GravityCompat.START);

                                Intent intentGroups = new Intent(TeamsActivity.this, GroupsActivity.class);
                                finish();
                                startActivity(intentGroups);

                                break;

                            case R.id.item_navigation_drawer_stadiums:

                                /*- Estadios -*/

                                menuItem.setChecked(true);
                                drawerLayout.closeDrawer(GravityCompat.START);

                                Intent intentStadiums = new Intent(TeamsActivity.this, StadiumsActivity.class);
                                finish();
                                startActivity(intentStadiums);

                                break;

                            case R.id.item_navigation_drawer_about_us:

                                /*- Sobre Nosotros -*/

                                menuItem.setChecked(true);
                                drawerLayout.closeDrawer(GravityCompat.START);

                                Intent intentAboutUs = new Intent(TeamsActivity.this, AboutUsActivity.class);
                                finish();
                                startActivity(intentAboutUs);

                                break;


                        }
                        return true;
                    }
                });
      }



}
