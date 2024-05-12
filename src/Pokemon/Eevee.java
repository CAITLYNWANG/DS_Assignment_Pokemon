package Pokemon;

public class Eevee extends Pokemon{
    //Celandor City Catchable
    public Eevee() {
        super("Eevee", "Normal", 25, 55, 125);
        this.weakAgainst = new String[]{"Fighting"};
        this.strongAgainst = new String[]{"Ghost"};

        Moves move1 = new Moves("Tackle", 40);
        Moves move2 = new Moves("Tail Whip", 35);
        this.addMove(move1);
        this.addMove(move2);
    }
}
