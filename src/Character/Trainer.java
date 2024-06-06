package Character;
import Pokemon.Pokemon;

import java.util.ArrayList;
public class Trainer {
    private String username;
    private String location;
    private ArrayList<Pokemon> team;
    private ArrayList<String> badges;

    public Trainer() {
        this.location = "Pallet Town";
        this.username = null;
        this.team = new ArrayList<>();
        this.badges = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void displayTeam() {
        System.out.println("Your Team: ");
        if(team.isEmpty()){
            System.out.println("- None");
        }
        else{
            for(Pokemon pkm: team){
                System.out.println("- " + pkm.toString());
            }
        }
    }

    public String getPokemonNames() {
        StringBuilder names = new StringBuilder();
        for (Pokemon pokemon : team) {
            names.append(pokemon.getName()).append(", ");
        }
        // Remove the trailing comma and space
        if (names.length() > 0) {
            names.setLength(names.length() - 2);
        }
        return names.toString();
    }

    public ArrayList<Pokemon> getTeam() {
        return team;
    }

    public void addNewPokemon(Pokemon pokemon) {
        this.team.add(pokemon);
    }

    public void displayBadges() {
        System.out.println("Your Badges: ");
        if(badges.isEmpty()){
            System.out.println("- None");
        }
        else{
            for(String badge: badges){
                System.out.println("- " + badge);
            }
        }
    }

    public ArrayList<String> getBadges(){
        return this.badges;
    }

    public void addBadges(String newBadges) {
        this.badges.add(newBadges);
    }
}
