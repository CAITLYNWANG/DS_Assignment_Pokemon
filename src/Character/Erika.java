package Character;
import Pokemon.Vileplume;

public class Erika extends GymLeader{
    public Erika(){
        super("Erika", "Rainbow Badge",new Vileplume());
        this.setDialogue("I am a student of the art of flower arranging.\n" +
                "My Pokémon are solely of the Grass type.");
    }
}
