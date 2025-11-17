import java.util.ArrayList;
import java.util.List;

public class Cabina {
    int nroCabina;
    List<Persona> personasAbordo;

    public Cabina(int nroCabina) {
        this.nroCabina = nroCabina;
        this.personasAbordo = new ArrayList<>();
    }

    public boolean agregarPersona(Persona p) {
        if (personasAbordo.size() >= 10) return false;
        if (pesoActual() + p.peso > 850) return false;
        personasAbordo.add(p);
        return true;
    }

    public float pesoActual() {
        float total = 0;
        for (Persona p : personasAbordo) total += p.peso;
        return total;
    }

    public float ingresoCabina() {
        float ingreso = 0;
        for (Persona p : personasAbordo) {
            if (p.edad <= 25 || p.edad > 60) ingreso += 1.5f; // tarifa preferente
            else ingreso += 3.0f; // tarifa regular
        }
        return ingreso;
    }

    public float ingresoSoloRegular() {
        float ingreso = 0;
        for (Persona p : personasAbordo) {
            if (!(p.edad <= 25 || p.edad > 60)) ingreso += 3.0f;
        }
        return ingreso;
    }
}
