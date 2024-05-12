package Pokemon;

public class Pidgey extends Pokemon{
    //Pewter City Catchable
    public Pidgey(){
        super("Pidgey", "Flying", 8, 20, 40);
        this.weakAgainst = new String[]{"Electric", "Ice", "Rock"};
        this.strongAgainst = new String[]{"Bug", "Grass", "Ghost"};

        Moves move1 = new Moves("Gut", 10);
        Moves move2 = new Moves("Sand Attack", 15);
        this.addMove(move1);
        this.addMove(move2);

    }
}
