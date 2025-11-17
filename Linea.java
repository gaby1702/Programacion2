import java.util.ArrayList;
import java.util.List;

public class Linea {
    String color;
    List<Persona> filaPersonas;
    List<Cabina> cabinas;
    int cantidadCabinas;

    public Linea(String color) {
        this.color = color;
        filaPersonas = new ArrayList<>();
        cabinas = new ArrayList<>();
    }

    public void agregarCabina(int nroCab) {
        cabinas.add(new Cabina(nroCab));
        cantidadCabinas = cabinas.size();
    }

    public Cabina buscarCabina(int nro) {
        for (Cabina c : cabinas)
            if (c.nroCabina == nro) return c;
        return null;
    }

    public boolean verificarReglasCabinas() {
        for (Cabina c : cabinas) {
            if (c.personasAbordo.size() > 10) return false;
            if (c.pesoActual() > 850) return false;
        }
        return true;
    }

    public float ingresoLinea() {
        float total = 0;
        for (Cabina c : cabinas) total += c.ingresoCabina();
        return total;
    }

    public float ingresoSoloRegular() {
        float total = 0;
        for (Cabina c : cabinas) total += c.ingresoSoloRegular();
        return total;
    }
}
