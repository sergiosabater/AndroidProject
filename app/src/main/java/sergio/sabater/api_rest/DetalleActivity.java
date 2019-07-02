package sergio.sabater.api_rest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

public class DetalleActivity extends AppCompatActivity {

    ArrayList<Plato> platos = new ArrayList<Plato>();
    int idMenu;
    int idPlato1;
    int idPlato2;
    int idPostre;

    Plato plato1;
    Plato plato2;
    Plato postre;

    private TextView menuTitle;
    private TextView primerPlatoNombre;
    private TextView primerPlatoTiempo;
    private TextView primerPlatoKcal;
    private TextView segundoPlatoNombre;
    private TextView segundoPlatoTiempo;
    private TextView segundoPlatoKcal;
    private TextView postreNombre;
    private TextView postreTiempo;
    private TextView postreKcal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        setTitle("Detalle del menú");

        // Obtenemos los valores que hemos pasado previamente a través del adaptador

        platos = (ArrayList<Plato>)getIntent().getSerializableExtra("listaplatos");
        idMenu = getIntent().getExtras().getInt("idMenu");
        idPlato1 = getIntent().getExtras().getInt("idPlato1");
        idPlato2 = getIntent().getExtras().getInt("idPlato2");
        idPostre = getIntent().getExtras().getInt("idPostre");

        menuTitle = findViewById(R.id.textView);
        primerPlatoNombre = findViewById(R.id.tv_1platoNombre);
        primerPlatoTiempo = findViewById(R.id.tv_1platoTiempo);
        primerPlatoKcal = findViewById(R.id.tv_1Plato_kcal);
        segundoPlatoNombre = findViewById(R.id.tv_2PlatoNombre);
        segundoPlatoTiempo = findViewById(R.id.tv_2Plato_Tiempo);
        segundoPlatoKcal = findViewById(R.id.tv_2Plato_kcal);
        postreNombre = findViewById(R.id.tv_PostreNombre);
        postreTiempo = findViewById(R.id.tv_Postre_Tiempo);
        postreKcal = findViewById(R.id.tv_Postre_kcal);

        menuTitle.setText("Menú "+idMenu);


        //Buscamos cada uno de los platos

        for(Plato p1 : platos){
            if(p1.getIdPlato()==idPlato1){
                plato1= p1;
                break; //Salimos del bucle una vez encontrado
            }
        }

        for(Plato p2 : platos){
            if(p2.getIdPlato()==idPlato2){
                plato2= p2;
                break;
            }
        }

        for(Plato p3 : platos){
            if(p3.getIdPlato()==idPostre){
                postre = p3;
                break;
            }
        }


        //Asignamos los valores correspondenties de cada plato a su TextView

        primerPlatoNombre.setText(plato1.getNombre());
        primerPlatoTiempo.setText(plato1.getTmpPreparacion()+" mins.");
        primerPlatoKcal.setText(plato1.getKcal()+" Kcal");
        segundoPlatoNombre.setText(plato2.getNombre());
        segundoPlatoTiempo.setText(plato2.getTmpPreparacion()+" mins.");
        segundoPlatoKcal.setText(plato2.getKcal()+" Kcal");
        postreNombre.setText(postre.getNombre());
        postreTiempo.setText(postre.getTmpPreparacion()+" mins.");
        postreKcal.setText(postre.getKcal()+" Kcal");

    }
}
