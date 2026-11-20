import java.util.ArrayList;

public class Invenatario {
    private ArrayList<Integer> pociones = new ArrayList<>(); // cada valor = vida que cura

    public Invenatario(int cantidad, int valor) {
        for (int i = 0; i < cantidad; i++) {
            pociones.add(valor);
        }
    }

    public boolean hayPociones(){
        return !pociones.isEmpty();
    }

    // Llamar solo si hasPotions() es true
    public int usePociones(){
        return pociones.remove(pociones.size() - 1);
    }

    public void show() {
        System.out.println("Pociones: " + pociones.size());
    }
}
