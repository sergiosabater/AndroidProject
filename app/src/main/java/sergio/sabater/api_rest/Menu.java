package sergio.sabater.api_rest;


import java.util.Comparator;

public class Menu {

    private int idMenu;
    private int idPlato1;
    private int idPlato2;
    private int idPostre;

    public Menu() {
    }

    public Menu(int idMenu, int idPlato1, int idPlato2, int idPostre) {
        this.idMenu = idMenu;
        this.idPlato1 = idPlato1;
        this.idPlato2 = idPlato2;
        this.idPostre = idPostre;
    }

    public int getIdMenu() {
        return idMenu;
    }

    public int getIdPlato1() {
        return idPlato1;
    }

    public int getIdPlato2() {
        return idPlato2;
    }

    public int getIdPostre() {
        return idPostre;
    }


    //Comparator para ordenar la lista alfabéticamente
    public static final Comparator<Menu> BY_ID = new Comparator<Menu>() {
        @Override
        public int compare(Menu m1, Menu m2) {
            return m1.getIdMenu() - m2.getIdMenu();
        }
    };
}
