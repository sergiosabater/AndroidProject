package sergio.sabater.api_rest;

import android.os.StrictMode;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Parser {

    private ArrayList<Menu> menus;
    private ArrayList<Plato> platos;

    public Parser() {

    }

    public boolean parse(){
        boolean parsed = false;

        //Primero parseamos los menús

        //Para hacer referencia a Localhost en Android Studio usamos la ip 10.0.2.2
        String sql_menu = "http://10.0.2.2:8080/Menus/rest/menus/jsonmenus";

        //Estas líneas de código sirven para corregir algunos errores que se producen al hacer peticiones.
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        //Declaramos e inicializamos la variables que utilizamos.
        URL url = null;
        HttpURLConnection conn;

        try {

            //Establecemos la conexión
            url = new URL(sql_menu);
            conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            //Obtenemos los datos con un BufferedReader
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String inputLine;

            StringBuffer response = new StringBuffer();

            String json = "";

            //La variable 'response' se va cargando con los datos proporcionados por la conexión.
            while((inputLine = in.readLine()) != null){
                response.append(inputLine);
            }

            json = response.toString();

            JSONArray jsonArray = null;

            //Creamos un JSONArray pasando los datos almacenados en el String resultante.

            jsonArray = new JSONArray(json);

            menus = new ArrayList<Menu>();

            for (int i=0; i<jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                Menu menu = new Menu (jsonObject.getInt("idMenu"),
                        jsonObject.getInt("idPlato1"),
                        jsonObject.getInt("idPlato2"),
                        jsonObject.getInt("idPostre"));
                menus.add(menu);


            }


            //Cerramos la conexión
            conn.disconnect();

        } catch (IOException | JSONException e) {
            e.printStackTrace();
            Log.e("ERROR", e.getMessage());
        }


        //Ahora parseamos los platos disponibles

        String sql_plato = "http://10.0.2.2:8080/Menus/rest/platos/jsonplatos";

        URL url2 = null;
        HttpURLConnection conn2;

        try {

            //Establecemos la conexión
            url2 = new URL(sql_plato);
            conn2 = (HttpURLConnection)url2.openConnection();
            conn2.setRequestMethod("GET");
            conn2.connect();

            //Obtenemos los datos con un BufferedReader
            BufferedReader in = new BufferedReader(new InputStreamReader(conn2.getInputStream()));

            String inputLine;

            StringBuffer response = new StringBuffer();

            String json = "";

            //La variable 'response' se va cargando con los datos proporcionados por la conexión.
            while((inputLine = in.readLine()) != null){
                response.append(inputLine);
            }

            json = response.toString();

            JSONArray jsonArray = null;

            //Creamos un JSONArray pasando los datos almacenados en el String resultante.

            jsonArray = new JSONArray(json);

            platos = new ArrayList<Plato>();

            for (int i=0; i<jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                Plato plato = new Plato (jsonObject.getInt("idPlato"),
                        jsonObject.getString("nombre"),
                        jsonObject.getInt("kcal"),
                        jsonObject.getInt("tmpPreparacion"));
                platos.add(plato);


            }

            //Si hemos llegado hasta aquí, podemos asegurar que los objetos json han sido parseados
            parsed = true;

            //Cerramos la conexión
            conn2.disconnect();

        } catch (IOException | JSONException e) {
            e.printStackTrace();
            Log.e("ERROR", e.getMessage());
        }


        return parsed;
    }

    public ArrayList<Menu> getMenus(){

        //Ordenamos el ArrayList de menús para que aparezcan ordenados de menor a mayor.
        Collections.sort(this.menus, Menu.BY_ID);

        return this.menus;
    }

    public ArrayList<Plato> getPlatos(){
        return this.platos;
    }
}
