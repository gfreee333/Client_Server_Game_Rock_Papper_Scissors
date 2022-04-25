import java.util.Objects;

public class Battle {
    enum Weapon {
        ROCK, SCISSORS, PAPER
    }
    public static int result = 0;
    public static String weapon;

    public static void main(String[] args) {
        while (!(result == 5)) {
            try {
                switch (Weapon.valueOf(weapon)) {
                    case ROCK:
                        if (Objects.equals(weapon, "PAPER")) {
                            System.out.println("Поражение");
                            break;
                        } else if (Objects.equals(weapon, "ROCK")) {
                            System.out.println("Ничья");
                            break;
                        } else if (Objects.equals(weapon, "SCISSORS")) {
                            result++;
                            System.out.println("Победа");
                            break;
                        }
                    case PAPER:
                        if (Objects.equals(weapon, "PAPER")) {
                            break;
                        } else if (Objects.equals(weapon, "SCISSORS")) {
                            break;
                        } else if (Objects.equals(weapon, "ROCK")) {
                            result++;
                            break;
                        }
                    case SCISSORS:
                        if (Objects.equals(weapon, "PAPER")) {
                            result++;
                            break;
                        } else if (Objects.equals(weapon, "SCISSORS")) {
                            break;
                        } else if (Objects.equals(weapon, "ROCK")) {
                            break;
                        }
                }
            } catch (Exception e) {
                System.out.println("Error: " + e + "\n");
            }
        }
    }
}
