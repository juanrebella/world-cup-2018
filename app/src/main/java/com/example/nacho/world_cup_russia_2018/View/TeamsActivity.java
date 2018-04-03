package com.example.nacho.world_cup_russia_2018.View;

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
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nacho.world_cup_russia_2018.Adapter.TeamsAdapter;
import com.example.nacho.world_cup_russia_2018.Config.URLRest;
import com.example.nacho.world_cup_russia_2018.Model.HttpConnection;
import com.example.nacho.world_cup_russia_2018.Properties.ListTeams;
import com.example.nacho.world_cup_russia_2018.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class TeamsActivity extends AppCompatActivity {

    ActionBar actionBar;
    DrawerLayout drawerLayout;
    TextView textView;
    ImageView Main;
    Toolbar toolbar;
    ListView listView;
    private String url = URLRest.urlOceania;
    JSONArray jsonArray;

    private int status = 0;

    HttpConnection service;
    ProgressDialog progressDialog;
    public List<ListTeams> lista = new LinkedList<ListTeams>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams);


        HttpConnection service = new HttpConnection();
        new ListTeams2().execute();

        /*- Action Bar-*/
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_action_bar_icon);
        actionBar.setDisplayHomeAsUpEnabled(true);

        listView = (ListView)findViewById(R.id.lstMenu);

        drawerLayout = findViewById(R.id.navigation_drawer_layout);

        NavigationView navigationView = findViewById(R.id.navigation_view);
        if (navigationView != null) {
            setupNavigationDrawerContent(navigationView);
        }

        setupNavigationDrawerContent(navigationView);



    }


    public class ListTeams2 extends AsyncTask<Void, Void, JSONArray> {


        String response = "";
        HashMap<String, String> postDataParams;
        //String urlparams = url + "title";

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog=new ProgressDialog(TeamsActivity.this);
            progressDialog.setMessage("Buscando datos..");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }



        @Override
        protected JSONArray doInBackground(Void... params) {


            try {
                JSONObject jsonResponse;
                jsonResponse = new JSONObject(response);
                status = jsonResponse.getInt("status");
                jsonArray = jsonResponse.optJSONArray("response");


            } catch (JSONException e) {
                e.printStackTrace();
            }

            return jsonArray;
        }

        @Override
        protected void onPostExecute(JSONArray jsonArray) {
            super.onPostExecute(jsonArray);
            if (progressDialog.isShowing()) {
                progressDialog.dismiss();
                if (status == 200) {
                    for (int i = 0; i < jsonArray.length(); i++) {
                        try {

                            ListTeams objDatos = new ListTeams();

                            int id;
                            String name;

                            /* */

                            JSONObject objet = jsonArray.getJSONObject(i);

                            id = objet.getInt("team_id");
                            name = objet.getString("name");

                            objDatos.setIdTeam(id);
                            objDatos.setTeamName(name);

                            lista.add(objDatos);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }


                   TeamsAdapter adapter= new TeamsAdapter(TeamsActivity.this, lista ,R.layout.teams_list_view);
                    listView.setAdapter(adapter);

                }

            }
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

                                /*- Pasta -*/

                                menuItem.setChecked(true);
                                drawerLayout.closeDrawer(GravityCompat.START);

                                Intent intentNews = new Intent(TeamsActivity.this, MainActivity.class);
                                finish();
                                startActivity(intentNews);

                                return true;

                            case R.id.item_navigation_drawer_teams:

                                /*- Minutas -*/
                                menuItem.setChecked(true);
                                drawerLayout.closeDrawer(GravityCompat.START);

                                Intent intentTeams = new Intent(TeamsActivity.this, TeamsActivity.class);
                                finish();
                                startActivity(intentTeams);

                                return true;

                            case R.id.item_navigation_drawer_matches:

                                /*- Ensalada -*/

                                menuItem.setChecked(true);
                                drawerLayout.closeDrawer(GravityCompat.START);

                                Intent intentMatches = new Intent(TeamsActivity.this, MatchesActivity.class);
                                finish();
                                startActivity(intentMatches);

                                return true;

                            case R.id.item_navigation_drawer_groups:
                                /*- Parrilla -*/

                                menuItem.setChecked(true);
                                drawerLayout.closeDrawer(GravityCompat.START);

                                Intent intentGroups = new Intent(TeamsActivity.this, GroupsActivity.class);
                                finish();
                                startActivity(intentGroups);

                                return true;

                            case R.id.item_navigation_drawer_stadiums:

                                /*- Mariscos -*/

                                menuItem.setChecked(true);
                                drawerLayout.closeDrawer(GravityCompat.START);

                                Intent intentStadiums = new Intent(TeamsActivity.this, StadiumsActivity.class);
                                finish();
                                startActivity(intentStadiums);

                                return true;

                            case R.id.item_navigation_drawer_about_us:

                                /*- Mariscos -*/

                                menuItem.setChecked(true);
                                drawerLayout.closeDrawer(GravityCompat.START);

                                Intent intentAboutUs = new Intent(TeamsActivity.this, AboutUsActivity.class);
                                finish();
                                startActivity(intentAboutUs);

                                return true;


                        }
                        return true;
                    }
                });
    }
}
