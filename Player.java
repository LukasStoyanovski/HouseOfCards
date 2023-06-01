public class Player {
    private String name;
    private int points;

    public Player(String name) {
        this.name = name;
        points = 0;
    }

    public Player() {
        this(null);
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addPoints(int points) {
        this.points += points;
    }

    @Override
    public String toString() {
        return "Player [name=" + name + ", points=" + points + "]";
    }

}