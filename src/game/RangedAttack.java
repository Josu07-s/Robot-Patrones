package game;

public class RangedAttack implements AttackType {
    @Override
    public int performAttack() {
        System.out.println("¡Ataque a distancia (Rango)!");
        // Calculamos un daño distinto para el ataque a distancia
        return (int)(Math.random() * 15) + 10; 
    }
}