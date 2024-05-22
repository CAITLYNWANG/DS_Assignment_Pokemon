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
        this.catchablePokemons = new ArrayList<>();
    }

    public void addConnection(String cityName, int weight){
        connections.add(new Connection(cityName, weight));
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

    public void setGymLeader(GymLeader gymLeader) {
        this.gymLeader = gymLeader;
    }
    public GymLeader getGymLeader(){
        return this.gymLeader;
    }
    public List<Connection> getConnections() {
        return connections;
    }
    public void displayCatchablePokemon(){
        if(!catchablePokemons.isEmpty()){
            System.out.print("[");
            for(int i = 0; i < catchablePokemons.size(); i++){
                if(i < catchablePokemons.size() - 1){
                    System.out.print(catchablePokemons.get(i).getName() + ", ");
                }else{
                    System.out.println(catchablePokemons.get(i).getName() + " are common]");
                }
            }
        }else{
            System.out.println(" ");
        }
    }

    public String displayGymLeader(){
        return gymLeader.toString();
    }
}
