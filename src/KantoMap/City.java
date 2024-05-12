package KantoMap;
import java.util.ArrayList;
import java.util.List;
import Pokemon.*;
import Character.GymLeader;
public class City {
    private String name;
    private List<Connection> connections;
    private List<Pokemon> catchablePokemons;
    private  GymLeader gymLeader;
    public City(){

    }

    public City(String name){
        this.name = name;
        this.connections = new ArrayList<>();
    }

    public void addConnection(String city, int weight){
        connections.add(new Connection(city, weight));
    }

    public void addCatchablePokemon(Pokemon pokemon){
        catchablePokemons.add(pokemon);
    }

    public List<Pokemon> getCatchablePokemons() {
        return catchablePokemons;
    }

    public String getName() {
        return name;
    }

    public List<Connection> getConnections() {
        return connections;
    }
}
