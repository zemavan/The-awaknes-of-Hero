import java.util.ArrayList;

public class Ranking {
    static final int MAX_RANKING = 10;
    private ArrayList<Reg> registros = new ArrayList<>();

    // Devuelve true si el candidato entra en el ranking
    public boolean add(String nombre, int puntos){
        // Con 10 registros, solo entra una puntuacion superior a la ultima
        if(registros.size() == MAX_RANKING && puntos <= registros.get(registros.size() - 1).getPuntos()){
            return false;
        }
        // Buscamos la posicion: tras todos los que tienen >= puntos (el mas antiguo va primero en empates)
        int pos = 0;
        while(pos < registros.size() && registros.get(pos).getPuntos() >= puntos){
            pos++;
        }
        registros.add(pos, new Reg(nombre, puntos));
        if(registros.size() > MAX_RANKING){
            registros.remove(registros.size() - 1);   // descartamos el ultimo
        }
        return true;
    }

    public void show(){
        if(registros.isEmpty()){
            System.out.println("El ranking esta vacio.");
            return;
        }
        System.out.println("--- RANKING ---");
        for(int i = 0; i < registros.size(); i++){
            System.out.println((i + 1) + ". " + registros.get(i).getNombre()
                    + " - " + registros.get(i).getPuntos());
        }
    }

}
