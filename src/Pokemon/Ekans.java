package Pokemon;

public class Ekans extends Pokemon{
    //Pewter City and Vermilion City and Saffron Catchable
    public Ekans(){
        super("Ekans", "Poison", 15, 40, 75);
        this.weakAgainst = new String[]{"Ground", "Psychic", "Ghost"};
        this.strongAgainst = new String[]{"Fighting", "Grass", "Poison", "Bug"};

        Moves move1 = new Moves("Poison Sting", 20);
        Moves move2 = new Moves("Wrap", 15);
        this.addMove(move1);
        this.addMove(move2);

    }
}
