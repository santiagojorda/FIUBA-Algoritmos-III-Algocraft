package modelo.desgaste.bloques;

public class DesgastadorBloquePico extends DesgastadorBloque {
    public DesgastadorBloquePico(int desgaste) {
        super(desgaste);
    }

    public int desgastarMadera() {
        return 0;
    }

    public int desgastarMetal() {
        return this.desgaste;
    }

    public int desgastarPiedra() {
        return this.desgaste;
    }

    public int desgastarDiamante() {
        return this.desgaste;
    }

    public int desgastarBoss() {
        return 0;
    }
}
