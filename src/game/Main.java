package game;

import external.robo.EnemyRobot;

public class Main {
    public static void main(String[] args) {
        // 1. Creamos las implementaciones de ataque (Bridge)
        AttackType puños = new MeleeAttack();
        AttackType pistola = new RangedAttack();

        // 2. Creamos los enemigos pasándoles su ataque inicial (Bridge)
        Enemy enemy1 = new Player(puños);     // Parte con cuerpo a cuerpo
        Enemy enemy2 = new Player(pistola);   // Parte con rango

        // 3. Instanciamos el robot externo a través de nuestro Adapter (Adapter)
        EnemyRobot robotExterno = new EnemyRobot();
        Enemy robotEnemy = new RobotAdapter(robotExterno);

        System.out.println("--- INICIA EL COMBATE ---");
        
        // El Enemigo 1 ataca al Enemigo 2 usando puños (Melee)
        enemy2.takeDamage(enemy1.attack(enemy2));
        System.out.println("Vida del Enemigo 2: " + enemy2.getHealth());

        System.out.println("\n--- ¡El Enemigo 1 cambia su estrategia! ---");
        // Demostramos la flexibilidad del Bridge cambiando el ataque en vivo
        ((Player) enemy1).setAttackBehavior(pistola); 
        
        // Ahora ataca usando la pistola (Ranged)
        enemy2.takeDamage(enemy1.attack(enemy2));
        System.out.println("Vida del Enemigo 2: " + enemy2.getHealth());

        System.out.println("\n--- ¡Aparece el Robot Enemigo en el mapa! ---");
        // El robot ataca al Enemigo 2 usando los métodos adaptados del .jar
        enemy2.takeDamage(robotEnemy.attack(enemy2));
        System.out.println("Vida del Enemigo 2 tras el golpe del robot: " + enemy2.getHealth());
    }
}