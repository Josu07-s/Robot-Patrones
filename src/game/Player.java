package game;

public class Player implements Enemy {
    private int life = 100;
    private int posx;
    private int posy; 

    // --- IMPLEMENTACIÓN DEL PATRÓN BRIDGE ---
    // El enemigo ahora tiene un comportamiento de ataque "enchufable"
    private AttackType attackBehavior;

    // Constructor: Al crear al jugador, le pasamos su ataque inicial
    public Player(AttackType attackBehavior) {
        this.attackBehavior = attackBehavior;
    }

    // Método que permite cambiar de ataque en tiempo de ejecución (Flexibilidad)
    public void setAttackBehavior(AttackType attackBehavior) {
        this.attackBehavior = attackBehavior;
    }
    // -----------------------------------------

    @Override
    public void move() {
        posx = (int)(Math.random() * 100);
        posy = (int)(Math.random() * 100);
    }

    @Override
    public int attack(Enemy enemy) {
        // En vez de tener el golpe fijo, delegamos la responsabilidad al Bridge
        int daño = attackBehavior.performAttack(); 
        return enemy.getHealth() - daño;
    }

    @Override
    public void takeDamage(int damage) {
        life = damage; 
    }

    @Override
    public int getHealth() {
        return life;
    }

    public int getPosx(){ 
        return this.posx; 
    }
    
    public void setPosx(int x){ 
        this.posx = x; 
    }
}