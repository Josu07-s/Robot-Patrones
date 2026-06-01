package game;

public class MeleeAttack implements AttackType {
    @Override
    public int performAttack() {
        System.out.println("¡Ataque cuerpo a cuerpo (Melee)!");
        // Calculamos un daño aleatorio para el cuerpo a cuerpo
        return (int)(Math.random() * 10) + 5; 
    }
}