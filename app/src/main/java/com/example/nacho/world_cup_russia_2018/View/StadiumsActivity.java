package com.example.nacho.world_cup_russia_2018.View;

import android.app.AlertDialog;
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
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.nacho.world_cup_russia_2018.Adapter.StadiumAdapter;
import com.example.nacho.world_cup_russia_2018.Config.URLRest;
import com.example.nacho.world_cup_russia_2018.Model.HttpConnection;
import com.example.nacho.world_cup_russia_2018.Properties.ListStadiums;
import com.example.nacho.world_cup_russia_2018.Properties.ListTeams;
import com.example.nacho.world_cup_russia_2018.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

public class StadiumsActivity extends AppCompatActivity {


    ActionBar actionBar;
    DrawerLayout drawerLayout;
    TextView textView;
    ImageView Main;
    Toolbar toolbar;
    ListView lstStadiums;
    RequestQueue mQueue;
    StadiumAdapter adapter;
    String url = URLRest.urlApi;

    public List<ListStadiums> listaEstadios = new LinkedList<ListStadiums>(); // TODO: Cambiar a estadios


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

        lstStadiums = findViewById(R.id.lstStadiums);
        drawerLayout = findViewById(R.id.navigation_drawer_layout);

        lstStadiums.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "has clickeado "+position , Toast.LENGTH_SHORT).show();

                //TODO: al hacer clic en imágenes abrir una nueva activity y mostrar detalle (foto más grande).
            }
        });


        NavigationView navigationView = findViewById(R.id.navigation_view);
        if (navigationView != null) {
            setupNavigationDrawerContent(navigationView);
        }

        setupNavigationDrawerContent(navigationView);



        JsonObjectRequest json = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray =  response.getJSONArray("Stadiums");

                            for (int i = 0; i < jsonArray.length(); i++){
                                JSONObject object = jsonArray.getJSONObject(i);
                                ListStadiums objDatos = new ListStadiums();



                                String name = object.getString("stadiums_name");
                                String imagenes = object.getString("url");



                                objDatos.setNameStadium(name);
                                objDatos.setImages(imagenes);

                                listaEstadios.add(objDatos);

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        adapter.notifyDataSetChanged();
                    }

                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                AlertDialog.Builder add = new AlertDialog.Builder(StadiumsActivity.this);
                add.setMessage(error.getMessage()).setCancelable(true);
                AlertDialog alert = add.create();
                alert.setTitle("Error!!!");
                alert.show();

            }
        });

        mQueue.add(json);

        adapter = new StadiumAdapter(StadiumsActivity.this, listaEstadios);
        lstStadiums.setAdapter(adapter);

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
