package OtherFunction;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import util.StructureService;

public class SafariZone {
    public void safariZoneChallenge(){
        StructureService.lineSeperator();
        System.out.println("Welcome to the Safari Zone! Today's challenge: Sort the Pokémon!");
        StructureService.lineSeperator();

        System.out.print("Enter the Pokémon in your party (separated by a comma): ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

       LinkedList<String> pokemons = new LinkedList<>(Arrays.asList(input.split("\\s*,\\s*")));

        System.out.print("You entered: ");
        for(int i = 0; i < pokemons.size(); i++){
            if(i != pokemons.size() - 1){
                System.out.print(pokemons.get(i) + ", ");
            }else{
                System.out.println(pokemons.get(i));
            }
        }

        int stepCnt = 0;

        System.out.println("Sorting your Pokémon according to their unique preferences...");
        //Sorting Pokemon according to Eevee's preference
        if(pokemons.contains("Eevee")){
            stepCnt++;
            System.out.println("Step " + stepCnt + ": ");
            System.out.println("Eevee insists on being positioned either at the beginning of the\n" +
                    "lineup to showcase its adaptability.");

            pokemons.remove("Eevee");
            pokemons.addFirst("Eevee");
            displaySortedPokemons(pokemons, "Sorted List");
        }

        //Sorting Pokemon according to Pikachu's preference
        if(pokemons.contains("Pikachu")){
            stepCnt++;
            System.out.println("Step " + stepCnt + ": ");
            System.out.println("Pikachu demands to be placed at the center of the arrangement.");

            pokemons.remove("Pikachu");
            int centerIndex = pokemons.size() / 2;
            pokemons.add(centerIndex, "Pikachu");

            displaySortedPokemons(pokemons, "Partial Sort");
        }

        //Sorting Pokemon according to Snorlax's preference
        if(pokemons.contains("Snorlax")){
            stepCnt++;
            System.out.println("Step " + stepCnt + ": ");
            System.out.println("Snorlax insists on being positioned at the end of the lineup to\n" +
                    "ensure maximum relaxation.");

            pokemons.remove("Snorlax");
            pokemons.addLast("Snorlax");

            displaySortedPokemons(pokemons, "Partial Sort");
        }

        //Sorting Pokemon according to Jigglypuff's preference
        if(pokemons.contains("Jigglypuff")){
            stepCnt++;
            System.out.println("Step " + stepCnt + ": ");
            System.out.println("Jigglypuff prefers to be surrounded by other \"cute\" Pokémon for\n" +
                    "morale purposes.");

            pokemons.remove("Jigglypuff");
            int indexPikachu = pokemons.indexOf("Pikachu");
            if(indexPikachu != -1 && indexPikachu > 0){
                pokemons.add(indexPikachu, "Jigglypuff");
            }else if(indexPikachu == 0){
                pokemons.add(1, "Jigglypuff");
            }else{
                int insert = Math.max(1, Math.min(pokemons.size(), pokemons.size() - 1));
                pokemons.add(insert, "Jigglypuff");
            }

            displaySortedPokemons(pokemons, "Partial Sort");
        }

        //Sorting Pokemon according to Bulbasaur's preference
        if(pokemons.contains("Bulbasaur") && pokemons.contains("Charmander")){
            stepCnt++;
            System.out.println("Step " + stepCnt + ": ");
            System.out.println("Bulbasaur refuses to be placed next to Charmander.");

            int indexBulbasaur = pokemons.indexOf("Bulbasaur");
            int indexCharmander = pokemons.indexOf("Charmander");

            //"Math.abs" to check the absolute value of the difference
            //between position of  Bulbasaur and Charmander
            if(Math.abs(indexBulbasaur - indexCharmander) == 1){
                //If Bulbasaur is next to Charmander
                pokemons.remove("Charmander");
                pokemons.add(indexBulbasaur + 1, "Charmander");
            }

            displaySortedPokemons(pokemons, "Partial Sort");
        }

        //Sorting Pokemon according to Machop's preference
        if(pokemons.contains("Machop") && pokemons.contains("Snorlax")){
            stepCnt++;
            System.out.println("Step " + stepCnt + ": ");
            System.out.println("Machop demands to be placed next to the heaviest Pokemon in the\n" +
                    "lineup to show off its strength.");

            pokemons.remove("Machop");
            int indexSnorlax = pokemons.indexOf("Snorlax");
            pokemons.add(indexSnorlax, "Machop");

            displaySortedPokemons(pokemons, "Final Sorted List");
        }





        StructureService.lineSeperator();
        System.out.println("Your Pokémon are now sorted! Enjoy your adventure in the Safari Zone!");
        StructureService.lineSeperator();
    }

    public void displaySortedPokemons(LinkedList<String> pokemons, String prompt){
        System.out.print(prompt + ": ");
        for(int i = 0; i < pokemons.size(); i++){
            if(i != pokemons.size() - 1){
                System.out.print(pokemons.get(i) + ", ");
            }else{
                System.out.println(pokemons.get(i));
            }
        }
    }
}
