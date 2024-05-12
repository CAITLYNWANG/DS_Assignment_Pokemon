package Pokemon;

public class Nidoqueen extends Pokemon{
    //Giovanni's Pokemon(Viridian City Gym)
    public Nidoqueen(){
        super("Nidoqueen", "Ground", 44, 140, 220);
        this.weakAgainst = new String[]{"Psychic", "Ice", "Water"};
        this.strongAgainst = new String[]{"Bug", "Poison", "Fighting", "Rock", "Fairy"};

        Moves move1 = new Moves("Superpower", 65);
        Moves move2 = new Moves("Bite", 60);
        this.addMove(move1);
        this.addMove(move2);

    }
}
