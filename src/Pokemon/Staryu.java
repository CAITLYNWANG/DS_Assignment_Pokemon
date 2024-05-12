package Pokemon;

public class Staryu extends Pokemon{
    //Misty's Pokemon(Cerulean City Gym)
    public Staryu(){
        super("Staryu", "Water", 18, 40, 90);
        this.weakAgainst = new String[]{"Grass", "Electric"};
        this.strongAgainst = new String[]{"Steel", "Water", "Ice", "Fire"};

        Moves move1 = new Moves("Tackle", 25);
        Moves move2 = new Moves("Water Gun", 30);
        this.addMove(move1);
        this.addMove(move2);

    }
}
