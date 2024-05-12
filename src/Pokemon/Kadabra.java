package Pokemon;

public class Kadabra extends Pokemon{
    //Sabrina's Pokemon(Saffron City Gym)
    public Kadabra(){
        super("Kadabra", "Psychic", 38, 120, 190);
        this.weakAgainst = new String[]{"Bug", "Ghost", "Dark"};
        this.strongAgainst = new String[]{"Fighting", "Psychic"};

        Moves move1 = new Moves("Confusion", 50);
        Moves move2 = new Moves("Psybeam", 55);
        this.addMove(move1);
        this.addMove(move2);

    }
}
