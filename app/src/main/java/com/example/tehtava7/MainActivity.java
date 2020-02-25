package com.example.tehtava7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    public class kuuntelija extends BroadcastReceiver{

        public void onReceive (Context context, Intent intent)
        {
            String aika = Calendar.getInstance().getTime().toString();
            boolean screen;

            if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF))
            {
                screen = true;
                Toast.makeText(context,"asdasdasdsad",Toast.LENGTH_LONG);
            }
            else{

                screen = false;
                Toast.makeText(context,"asdasdasdsad",Toast.LENGTH_LONG);

            }



            Intent i = new Intent(context,IntentPalvelu.class);
            i.putExtra("tila",screen);
            i.putExtra("aika",aika);
            context.startService(i);

        }
    }
    kuuntelija kuu;
    TextView teksti;
    tauluDao td;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tietokanta db = Room.databaseBuilder(getApplicationContext(),
                tietokanta.class, "tietoa").allowMainThreadQueries().fallbackToDestructiveMigration().build();
        this.td = db.tauluDao();



        kuu = new kuuntelija();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_SCREEN_ON);
        intentFilter.addAction(Intent.ACTION_SCREEN_OFF);

        registerReceiver(kuu,intentFilter);
    }

    @Override
    protected void onResume() {

        teksti = findViewById(R.id.teksti);

        for (MyEntity s : td.getAllInDescendingOrder()){

            boolean n = s.screen;
            String x;

                if (n == true)
                    x = "kiinni";
                else
                    x ="auki";

                teksti.append("aika " + s.aika + " avain " + s.avain +" näyttö "+ x + " \n");




        }




        super.onResume();
    }
}
