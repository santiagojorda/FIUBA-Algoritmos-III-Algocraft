package modelo.materiales;

public interface ItemAtacador {
    void usarContra(ItemAtacable item);

    int desgastarMadera();

    void desgastarmeContraMadera();

    int desgastarMetal();

    void desgastarmeContraMetal();

    int desgastarPiedra();

    void desgastarmeContraPiedra();

    int desgastarDiamante();

    void desgastarmeContraDiamante();

    int desgastarBoss();

    void desgastarmeContraBoss();
}
