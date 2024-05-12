package Pokemon;

public class Growlithe extends Pokemon{
    //Blaine's Pokemon(Cinnabar Island Gym)
    //Saffron City and Cinnabar Island Catchable
    public Growlithe(){
        super("Growlithe", "Fire", 42, 120, 210);
        this.weakAgainst = new String[]{"Ground", "Rock", "Water"};
        this.strongAgainst = new String[]{"Bug", "Steel", "Fire", "Grass", "Ice", "Fairy"};

        Moves move1 = new Moves("Ember", 40);
        Moves move2 = new Moves("Bite", 60);
        this.addMove(move1);
        this.addMove(move2);

    }
}
