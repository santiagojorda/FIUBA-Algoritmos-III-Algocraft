package modelo.desgaste.bloques;

public class DesgastadorBloquePicoDebil extends DesgastadorBloque {
    public DesgastadorBloquePicoDebil(int desgaste) {
        super(desgaste);
    }

    public int desgastarMadera() {
        return 0;
    }

    public int desgastarMetal() {
        return 0;
    }

    public int desgastarPiedra() {
        return this.desgaste;
    }

    public int desgastarDiamante() {
        return 0;
    }

    public int desgastarBoss() {
        return 0;
    }
}
