package modelo.desgaste.bloques;

public class DesgastadorBloqueHacha extends DesgastadorBloque {
    public DesgastadorBloqueHacha(int desgaste) {
        super(desgaste);
    }

    public int desgastarMadera() {
        return desgaste;
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
        return 0;
    }
}
