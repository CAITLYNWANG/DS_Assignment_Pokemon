package Pokemon;

public class Onix extends Pokemon{
    //Brock's Pokemon(Pewter City Gym)
    public Onix(){
        super("Onix", "Rock", 12, 27, 60);
        this.weakAgainst = new String[]{"Fighting", "Ghost", "Steel", "Water", "Grass", "Ice"};
        this.strongAgainst = new String[]{"Electric", "Normal", "Flying", "Poison", "Rock", "Fire"};

        Moves move1 = new Moves("Tackle", 20);
        Moves move2 = new Moves("Bind", 15 );
        this.addMove(move1);
        this.addMove(move2);

    }


}
