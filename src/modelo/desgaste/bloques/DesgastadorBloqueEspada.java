package modelo.desgaste.bloques;

public class DesgastadorBloqueEspada extends DesgastadorBloque {
    public DesgastadorBloqueEspada(int desgaste) {
        super(desgaste);
    }

    public int desgastarMadera() {
        return 0;
    }

    public int desgastarMetal() {
        return 0;
    }

    public int desgastarPiedra() {
        return 0;
    }

    public int desgastarDiamante() {
        return 0;
    }

    public int desgastarBoss() {
        return desgaste;
    }
}
