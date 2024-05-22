package KantoMap;
import Character.GymLeader;
import Pokemon.*;
import Character.Sabrina;
public class SaffronCity extends City{
    public SaffronCity(){
        super("Saffron City");
        //Implement the connection
        this.addConnection("Celadon City", 4);
        this.addConnection("Vermilion City", 3);
        this.addConnection("Lavender Town", 3);
        this.addConnection("Cerulean City", 6);
        //Implement the wild pokemons
        this.addCatchablePokemon(new Ekans());
        this.addCatchablePokemon(new Vulpix());
        this.addCatchablePokemon(new Growlithe());
        //Implement the Challenge Gym Leader
        GymLeader gymLeader = new Sabrina();
        this.setGymLeader(gymLeader);
    }
}
