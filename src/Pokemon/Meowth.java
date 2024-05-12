package Pokemon;

public class Meowth extends Pokemon{
    // Cerulean City and Celadon City catchable
    public Meowth() {
        super("Meowth", "Normal", 10, 35, 50);
        this.weakAgainst = new String[]{"Fighting"};
        this.strongAgainst = new String[]{"Ghost"};

        Moves move1 = new Moves("Scratch", 25);
        Moves move2 = new Moves("Bite", 30);
        this.addMove(move1);
        this.addMove(move2);
    }
}
