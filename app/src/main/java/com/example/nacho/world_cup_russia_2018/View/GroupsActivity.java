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
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nacho.world_cup_russia_2018.Adapter.GroupAdapter;
import com.example.nacho.world_cup_russia_2018.Model.HttpConnection;
import com.example.nacho.world_cup_russia_2018.Properties.ListStadiums;
import com.example.nacho.world_cup_russia_2018.Properties.ListTeams;
import com.example.nacho.world_cup_russia_2018.R;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;

public class GroupsActivity extends AppCompatActivity {

    ActionBar actionBar;
    ListView lstGroups;
    DrawerLayout drawerLayout;
    TextView titleGroup;
    ImageView Main;
    Toolbar toolbar;
    Spinner spinner;
    GroupAdapter adapterGroup;
    URL url;
    HttpConnection service;
    ProgressDialog progressDialog;
    public List<ListTeams> listTeams = new LinkedList<ListTeams>();
    public String option = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groups);

        lstGroups = findViewById(R.id.lstGroups);
        drawerLayout = findViewById(R.id.navigation_drawer_layout);



//    adapterGroup = new GroupAdapter(GroupsActivity.this, listTeams);
//     lstGroups.setAdapter(adapterGroup);
        HttpConnection service = new HttpConnection();
        // new ListadoEquipos().execute();


        /*- Action Bar-*/
        toolbar = findViewById(R.id.toolbar);
        hideToolbar();
        setSupportActionBar(toolbar);

        /*Action Bar*/
        actionBar();

        /*Spinner*/
        setSpinner();


//TODO: al hacer clic en algun elemento de la lista, transformar el layout en grupos y titulos.

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v, int i, long id) {

                String text = spinner.getSelectedItem().toString();

                //TODO: Corregir el switch (no lee la lista ni el adaptador).
                switch (i)
                {
                    case (1):
                       Toast.makeText(getApplicationContext(), "hola "+ text, Toast.LENGTH_SHORT ).show();

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


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

    private void setSpinner(){
        spinner = findViewById(R.id.spinner);

        ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(getApplicationContext(),
                R.array.spinner_array, android.R.layout.simple_list_item_1);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

    }
}
