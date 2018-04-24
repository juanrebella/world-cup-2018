package com.example.nacho.world_cup_russia_2018.View;

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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.example.nacho.world_cup_russia_2018.R;

public class AboutUsActivity extends AppCompatActivity {

            ActionBar actionBar;
            DrawerLayout drawerLayout;
            TextView textView;
            ImageView imgStadiumIcon;
            Toolbar toolbar;
            ListView lstStadiums;
            RequestQueue mQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        //TODO: agregarle algo más (foto, datos, empresa que la creó, etc).

        /*- Action Bar y toolBar-*/
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_action_bar_icon);
        actionBar.setDisplayHomeAsUpEnabled(true);


        lstStadiums = findViewById(R.id.lstStadiums);
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

                                Intent intentNews = new Intent(AboutUsActivity.this, MainActivity.class);
                                finish();
                                startActivity(intentNews);

                                break;

                            case R.id.item_navigation_drawer_teams:

                                /*- Equipos -*/
                                menuItem.setChecked(true);
                                drawerLayout.closeDrawer(GravityCompat.START);
                                Intent intentTeams = new Intent(AboutUsActivity.this, TeamsActivity.class);
                                finish();
                                startActivity(intentTeams);

                                break;

                            case R.id.item_navigation_drawer_matches:

                                /*- Partidos -*/

                                menuItem.setChecked(true);
                                drawerLayout.closeDrawer(GravityCompat.START);

                                Intent intentMatches = new Intent(AboutUsActivity.this, MatchesActivity.class);
                                finish();
                                startActivity(intentMatches);

                                break;

                            case R.id.item_navigation_drawer_groups:

                                /*- Grupos -*/

                                menuItem.setChecked(true);
                                drawerLayout.closeDrawer(GravityCompat.START);

                                Intent intentGroups = new Intent(AboutUsActivity.this, GroupsActivity.class);
                                finish();
                                startActivity(intentGroups);

                                break;

                            case R.id.item_navigation_drawer_stadiums:

                                /*- Estadios -*/

                                menuItem.setChecked(true);
                                drawerLayout.closeDrawer(GravityCompat.START);
                                Intent intentStadiums = new Intent(AboutUsActivity.this, StadiumsActivity.class);
                                finish();
                                startActivity(intentStadiums);

                                break;

                            case R.id.item_navigation_drawer_about_us:

                                /*- Sobre Nosotros -*/

                                menuItem.setChecked(true);
                                drawerLayout.closeDrawer(GravityCompat.START);


                                break;


                        }
                        return true;
                    }
                });
    }

}
