package Pokemon;

public class Sandshrew extends Pokemon{
    //Vermilion City Catchable
    public Sandshrew() {
        super("Sandshrew", "Ground", 15, 50, 75);
        this.weakAgainst = new String[]{"Water", "Grass", "Ice"};
        this.strongAgainst = new String[]{"Poison", "Rock", "Electric", "Fire"};

        Moves move1 = new Moves("Scratch", 40);
        Moves move2 = new Moves("Sand Attack", 35);
        this.addMove(move1);
        this.addMove(move2);
    }
}
