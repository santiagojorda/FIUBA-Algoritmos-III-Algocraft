package modelo.desgaste.herramienta;

import modelo.excepciones.DesgastadoPorCompletoError;

public class DesgastadorHerramientaLineal extends DesgastadorHerramienta {
    public double desgaste;

    public DesgastadorHerramientaLineal(double durabilidad, double coeficienteDeDesgaste) {
        super(durabilidad);
        this.desgaste = coeficienteDeDesgaste;
    }

    private boolean excedeLimitesDeDesgaste() {
        return (durabilidad - desgaste) <= 0;
    }

    public void desgastar() {
        if (excedeLimitesDeDesgaste()) {
            throw new DesgastadoPorCompletoError();
        }
        durabilidad -= desgaste;
    }
}
