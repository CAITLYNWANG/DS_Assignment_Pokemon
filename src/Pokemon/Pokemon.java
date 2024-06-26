package Pokemon;
import java.util.ArrayList;
public class Pokemon {
    protected String name;
    protected String type;
    protected String[] strongAgainst;
    protected String[] weakAgainst;

    protected int level;
    protected int hp;
    protected int showHp;
    protected int xp;
    protected ArrayList<Moves> movesList;


    public Pokemon(String name, String type, int level, int hp, int xp) {
        this.name = name;
        this.type = type;
        this.level = level;
        this.hp = hp;
        this.showHp = hp;
        this.xp = xp;
        this.movesList = new ArrayList<>();
    }

    public Pokemon(){

    }

    public void addMove(Moves move){
        this.movesList.add(move);
    }
    public String displayMoves() {
        StringBuilder sb = new StringBuilder();
        for (Moves move : movesList) {
            sb.append("- ").append(move.getMoveName())
                    .append(" [").append(move.getAttack())
                    .append(" damage]").append("\n");
        }
        return sb.toString();
    }


    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }


    public String[] getStrongAgainst() {
        return strongAgainst;
    }
    public String displayStrongAgainst(String[] strongAgainst){
        StringBuilder sb = new StringBuilder();
        for(String sa: strongAgainst){
            sb.append("- ").append(sa).append("\n");
        }
        return sb.toString();
    }

    public String[] getWeakAgainst() {
        return weakAgainst;
    }

    public String displayWeakAgainst(String[] weakAgainst){
        StringBuilder sb = new StringBuilder();
        for(String wa: weakAgainst){
            sb.append("- ").append(wa).append("\n");
        }
        return sb.toString();
    }



    public int getLevel() {
        return level;
    }


    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getShowHp() {
        return showHp;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public ArrayList<Moves> getMovesList() {
        return movesList;
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
        this.hp += 20;
        this.showHp += 20;
        for(Moves move: movesList){
            move.setAttack(move.getAttack() + 2);
        }
        System.out.println(name + " leveled up.");
        System.out.println(name + "[Level " + level + " --> " + "Level " + (++level) + "]");
    }

    @Override
    public String toString() {
        return name + " - " + "Level: " + level + "\n"
                + "Type: " + type +"\n"
                + "HP: " + hp + "\n"
                + "XP: " + xp + "\n"
                + "Moves: " + "\n"
                + displayMoves()
                + "Strong Against: " + "\n"
                + displayStrongAgainst(strongAgainst)
                +"Weak Against: " + "\n"
                + displayWeakAgainst(weakAgainst);

    }
}
