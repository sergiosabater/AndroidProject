package sergio.sabater.api_rest;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class FragmentListado extends Fragment {

    private ArrayList<Menu> menus = new ArrayList<Menu>();
    private ArrayList<Plato> platos = new ArrayList<Plato>();
    private RecyclerView rvListado;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Parser parser = new Parser();
        if(parser.parse()){
            this.menus = parser.getMenus();
            this.platos = parser.getPlatos();
        }else{
            Log.e("ERROR", "Se ha producido un error");
        }
        return inflater.inflate(R.layout.fragment_listado, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        rvListado = (RecyclerView)getView().findViewById(R.id.rvListado);
        MenusAdapter adapter = new MenusAdapter(getActivity(), menus, platos);
        rvListado.setAdapter(adapter);
        rvListado.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
    }
}
