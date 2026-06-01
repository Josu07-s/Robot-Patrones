package game;

import external.robo.EnemyRobot;

public class RobotAdapter implements Enemy {
    
    private EnemyRobot robot;

    public RobotAdapter(EnemyRobot robot) {
        this.robot = robot;
    }

    @Override
    public void move() {
        // Al robot hay que decirle cuántos pasos dar, le ponemos un valor por defecto
        robot.moveForward(5); 
        System.out.println("El robot avanza 5 espacios usando sus orugas.");
    }

    @Override
    public int attack(Enemy enemy) {
        int dañoDelRobot = 15; // Le inventamos un daño
        robot.smash(dañoDelRobot); 
        System.out.println("¡El robot usa smash!");
        
        // Seguimos la misma lógica de cálculo que tiene tu clase Player.java
        return enemy.getHealth() - dañoDelRobot; 
    }

    @Override
    public void takeDamage(int damage) {
        // Traducimos el recibir daño a recibir una descarga
        robot.receiveShock(damage);
        System.out.println("El robot recibe una descarga de " + damage);
    }

    @Override
    public int getHealth() {
        // Traducimos la vida a su nivel de energía
        return robot.energyLevel();
    }
}