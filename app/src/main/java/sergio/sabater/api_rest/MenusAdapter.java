package sergio.sabater.api_rest;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MenusAdapter extends RecyclerView.Adapter<MenusAdapter.MenuViewHolder>{

    private Context context;
    private ArrayList<Menu> menus;
    private ArrayList<Plato> platos;

    public MenusAdapter(Context context, ArrayList<Menu> menus, ArrayList<Plato> platos) {
        this.context = context;
        this.menus = menus;
        this.platos = platos;
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_menu, viewGroup, false);
        MenuViewHolder holder = new MenuViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder menuViewHolder, final int i) {

        menuViewHolder.tv_menu.setText("Menú "+(menus.get(i).getIdMenu())); //revisar, podria dar error

        menuViewHolder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Pasamos todos los parametros que necesitamos a la Activity del detalle.

                Toast.makeText(context, "Menú "+menus.get(i).getIdMenu(), Toast.LENGTH_SHORT).show();
                int idMenu = menus.get(i).getIdMenu();
                int idPlato1 = menus.get(i).getIdPlato1();
                int idPlato2 = menus.get(i).getIdPlato2();
                int idPostre = menus.get(i).getIdPostre();
                Intent intent = new Intent(context.getApplicationContext(), DetalleActivity.class);
                intent.putExtra("idMenu", idMenu);
                intent.putExtra("idPlato1", idPlato1);
                intent.putExtra("idPlato2", idPlato2);
                intent.putExtra("idPostre", idPostre);
                intent.putExtra("listaplatos", platos);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return menus.size();
    }

    public class MenuViewHolder extends RecyclerView.ViewHolder{

        TextView tv_menu;
        ConstraintLayout parentLayout;

        public MenuViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_menu = itemView.findViewById(R.id.tv_menu);
            parentLayout = itemView.findViewById(R.id.parent_layout);

        }
    }
}
