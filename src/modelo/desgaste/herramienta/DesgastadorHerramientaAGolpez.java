package modelo.desgaste.herramienta;

import modelo.excepciones.DesgastadoPorCompletoError;

public class DesgastadorHerramientaAGolpez extends DesgastadorHerramienta {
    public int usos;

    public DesgastadorHerramientaAGolpez(double durabilidad, int usosMaximos) {
        super(durabilidad);
        this.usos = usosMaximos;
    }

    private boolean noTieneMasUsos() {
        return (usos == 0);
    }

    private void romperPorCompleto() {
        durabilidad = 0;
    }

    public void desgastar() {
        usos--;
        if (noTieneMasUsos()) {
            romperPorCompleto();
            throw new DesgastadoPorCompletoError();
        }
    }
}
