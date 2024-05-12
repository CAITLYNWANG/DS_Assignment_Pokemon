package Pokemon;

public class Koffing extends Pokemon{
    //Koga's Pokemon(Fushia City Gym)
    public Koffing(){
        super("Koffing", "Poison", 33, 100, 165);
        this.weakAgainst = new String[]{"Flying", "Fire", "Psychic", "Rock" };
        this.strongAgainst = new String[]{"Fighting", "Grass", "Bug", "Fairy", "Poison"};

        Moves move1 = new Moves("Toxic", 50);
        Moves move2 = new Moves("Smoke Screen", 45);
        this.addMove(move1);
        this.addMove(move2);

    }
}
