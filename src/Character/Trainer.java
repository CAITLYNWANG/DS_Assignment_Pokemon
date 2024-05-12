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
        this.team = null;
        this.badges = null;
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

    public void getTeam() {
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

    public void addNewPokemon(Pokemon pokemon) {
        this.team.add(pokemon);
    }

    public void getBadges() {
        System.out.println("Your Badges: ");
        if(badges.isEmpty()){
            System.out.print("- None");
        }
        else{
            for(String badge: badges){
                System.out.println("- " + badge);
            }
        }
    }

    public void addBadges(String newBadges) {
        this.badges.add(newBadges);
    }
}
