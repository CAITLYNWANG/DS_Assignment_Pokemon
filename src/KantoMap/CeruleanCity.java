package KantoMap;
import Character.Misty;
import Character.GymLeader;
import Pokemon.*;

public class CeruleanCity extends City{
    public CeruleanCity(){
        super("Cerulean City");
        //Implement the connection
        this.addConnection("Pewter City", 12);
        this.addConnection("Saffron City", 6);
        this.addConnection("Lavender Town", 9);
        //Implement the wild pokemons
        this.addCatchablePokemon(new Spearow());
        this.addCatchablePokemon(new Meowth());
        this.addCatchablePokemon(new Ekans());
        //Implement the Challenge Gym Leader
        GymLeader gymLeader = new Misty();
        this.setGymLeader(gymLeader);
    }
}
