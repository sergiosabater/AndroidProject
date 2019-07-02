package sergio.sabater.api_rest;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MenusActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menus);
        setTitle("Listado de menús"); //Establecemos un nuevo título para la Activity


        //Cargamos el Fragment para mostrar el listado
        FragmentListado fl = new FragmentListado();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.FrgListado, fl).commit();

    }

}
