package modelo.desgaste.bloques;

public abstract class DesgastadorBloque {
    protected int desgaste;

    public DesgastadorBloque(int desgaste) {
        this.desgaste = desgaste;
    }

    public abstract int desgastarMadera();

    public abstract int desgastarMetal();

    public abstract int desgastarPiedra();

    public abstract int desgastarDiamante();

    public abstract int desgastarBoss();
}
