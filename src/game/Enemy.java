package game;

public interface Enemy {
    void move();
    int attack(Enemy enemy);
    void takeDamage(int damage);
    int getHealth();
}