package KantoMap;
import Character.GymLeader;
import Pokemon.*;
import Character.LtSurge;

public class VermilionCity extends City{
    public VermilionCity(){
        super("Vermilion City");
        //Implement the connection
        this.addConnection("Saffron City", 3);
        this.addConnection("Fuchsia City", 7);
        this.addConnection("Lavender Town", 5);
        //Implement the wild pokemons
        this.addCatchablePokemon(new Krabby());
        this.addCatchablePokemon(new Sandshrew());
        this.addCatchablePokemon(new Shellder());
        //Implement the Challenge Gym Leader
        GymLeader gymLeader = new LtSurge();
        this.setGymLeader(gymLeader);
    }
}
