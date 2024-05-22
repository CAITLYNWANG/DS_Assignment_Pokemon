package util;

public class DialogueService {
    public static void printIntroName(){
        System.out.println("OAK: Hello there! Welcome to the world of Pokémon! My name is Oak!\n" +
                "People call me the Pokémon Prof! This world is inhabited by creatures\n" +
                "called Pokémon! For some people, Pokémon are pets. Others use them for\n" +
                "fights. Myself... I study Pokémon as a profession.");

        System.out.println("OAK: First, what is your name?");

    }

    public static void printIntroPokemon(){
        System.out.println("OAK: Right! So your name is Amaan! Welcome to the world of Pokemon.\n" +
                "It's time to choose your starting pokemon.");
    }

    public static void printTalkToMom(String playerName){
        System.out.println("MOM: Oh, " + playerName + "! You're leaving on your adventure with Pokémon? How\n" +
                "exciting! I know you've always dreamed of this day. Remember, the bond\n" +
                "you share with your Pokémon is the most important thing. Take care of\n" +
                "them, and they'll take care of you. Don't worry about me; I'll be just\n" +
                "fine here. I can't wait to hear all about your adventures and the new\n" +
                "friends you're going to make. Remember, no matter how far you go, I'm\n" +
                "always here for you. Be brave, be kind, and everything will turn out\n" +
                "just fine. I'm so proud of you already! Now, go on, your adventure\n" +
                "awaits! Oh, and don’t forget to change your underwear every day! Safe\n" +
                "travels, my dear!\"" );
    }
}
