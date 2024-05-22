package KantoMap;
import Character.GymLeader;
import Pokemon.*;
import Character.Koga;
public class FuchsiaCity extends City{
    public FuchsiaCity(){
        super("Fuchsia City");
        //Implement the connection
        this.addConnection("Celadon City", 10);
        this.addConnection("Vermilion City", 7);
        this.addConnection("Lavender Town", 11);
        this.addConnection("Cinnabar Island", 5);
        //Implement the wild pokemons
        this.addCatchablePokemon(new Venonat());
        this.addCatchablePokemon(new Exeggcute());
        this.addCatchablePokemon(new Kangaskhan());
        //Implement the Challenge Gym Leader
        GymLeader gymLeader = new Koga();
        this.setGymLeader(gymLeader);
    }

}
