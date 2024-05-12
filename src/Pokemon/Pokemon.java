package Pokemon;
import java.util.ArrayList;
public class Pokemon {
    protected String name;
    protected String type;
    protected String[] strongAgainst;
    protected String[] weakAgainst;

    protected int level;
    protected int hp;
    protected int xp;
    protected ArrayList<Moves> movesList;


    public Pokemon(String name, String type, int level, int hp, int xp) {
        this.name = name;
        this.type = type;
        this.level = level;
        this.hp = hp;
        this.xp = 0;
        this.movesList = new ArrayList<>();
    }

    public Pokemon(){

    }

    public void addMove(Moves move){
        this.movesList.add(move);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String[] getStrongAgainst() {
        return strongAgainst;
    }

    public void setStrongAgainst(String[] strongAgainst) {
        //TODO: use I/O to read Pokemon's attributes
    }

    public void getWeakAgainst() {
        for(String weak: weakAgainst){

        }
    }

    public void setWeakAgainst(String[] weakAgainst) {
        //TODO: use I/O to read Pokemon's attributes
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }


    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }
    public void xpCheck(){
        while(true){
            if(level <= 10 && xp >= 100){
                //Levels 1-10 take 100xp each.
                xp -= 100;
                levelUp();
            }else if(level > 10 && level <= 30 && xp >= 200){
                //Levels 10-30 take 200xp each.
                xp -= 200;
                levelUp();
            }else if(level > 30 && xp >= 300){
                //And 30+ take 300xp each.
                xp -= 300;
                levelUp();
            }else{
                break;
            }
        }
    }


    public void levelUp() {
        //this.hp += ?;
        this.level++;
        for(Moves move: movesList){
            move.setAttack(move.getAttack() + 2);
        }
    }

    @Override
    public String toString() {
        //TODO: use I/O to read Pokemon's attributes
        return null;

    }
}
