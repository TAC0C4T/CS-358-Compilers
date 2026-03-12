class Main extends Lib {
    public void main() {
        new Game().run();
    }
}

class Game extends Lib {
    int score;
    int lives;
    int level;

    public void run() {
        score = 0;
        lives = 3;
        level = 1;
        while (lives > 0) {
            int result = playLevel(level);
            if (result > 0) {
                score = score + result;
                level = level + 1;
            } else {
                lives = lives - 1;
            }
        }
        printInt(score);
        printStr("\n");
    }

    public int playLevel(int lvl) {
        int points = 0;
        int i = 0;
        while (i < lvl) {
            int bonus = i + lvl;
            points = points + bonus;
            i = i + 1;
            if (points > 100) {
                break;
            }
        }
        return points;
    }
}

class Player extends Game {
    int health;
    String name;

    public void init(String playerName, int startHealth) {
        name = playerName;
        health = startHealth;
        score = 0;
    }

    public int takeDamage(int dmg) {
        health = health - dmg;
        if (health < 0) {
            health = 0;
        }
        return health;
    }

    public boolean isAlive() {
        return health > 0;
    }
}

class Enemy extends Lib {
    int power;
    int speed;

    public void setup(int p, int s) {
        power = p;
        speed = s;
    }

    public int attack(int defense) {
        int dmg = power - defense;
        if (dmg < 0) {
            dmg = 0;
        }
        return dmg;
    }
}

class Boss extends Enemy {
    int phase;

    public int attack(int defense) {
        int baseDmg = power - defense;
        int bonusDmg = phase * 5;
        int total = baseDmg + bonusDmg;
        if (total < 0) {
            total = 0;
        }
        return total;
    }

    public void nextPhase() {
        phase = phase + 1;
        power = power + 10;
    }
}