package Pokemon;

public class Kangaskhan extends Pokemon{
    //Fuchsia City Catchable
    public Kangaskhan() {
        super("Kangaskhan", "Normal", 35, 105, 165);
        this.weakAgainst = new String[]{"Fighting"};
        this.strongAgainst = new String[]{"Ghost"};

        Moves move1 = new Moves("Comet Punch", 50);
        Moves move2 = new Moves("Bite", 60);
        this.addMove(move1);
        this.addMove(move2);
    }

}
