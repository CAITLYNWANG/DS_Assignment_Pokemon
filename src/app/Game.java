package app;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.HashMap;

import KantoMap.*;
import Character.*;
import OtherFunction.*;
import Pokemon.*;
import util.*;

import java.io.*;
import java.util.ArrayList;

//import library of JSON
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Game {
    Scanner scanner = new Scanner(System.in);
    Trainer trainer = null;
    boolean nameSet = false;
    boolean pokemonSet = false;
    RoundBattleService roundBattleService = new RoundBattleService();
    HashMap<String, User> users = new HashMap<>();String currentUsername = null;

    protected void begin() {
        StructureService.printASCII("title");
        StructureService.printHeading("Welcome to Pokemon - Kanto Adventures");
        StructureService.continueGame();

        loadUsers();
        printLoginMenu();

        printBeginningMenu();

        if (trainer.getUsername() == null) {
            // A new adventure
            // Set player's name
            DialogueService.printIntroName();
            while (!nameSet) {
                StructureService.lineSeperator();
                System.out.print(ColorText.colorText("Enter your name: ", ColorText.BLUE));
                String playerSetName = scanner.next();
                System.out.println("Is your name " + playerSetName + " ?");
                System.out.println("[1] Yes!");
                System.out.println("[2] No I wanna change my name.");
                int input = StructureService.readChoice("---> ", 2);
                if (input == 1) {
                    trainer.setUsername(playerSetName);
                    nameSet = true;
                }
            }

            StructureService.lineSeperator();
            DialogueService.printIntroPokemon();
            StructureService.lineSeperator();

            System.out.println("[1] Bulbasaur [Grass - Level 5]\n" +
                               "[2] Squirtle [Water - Level 5]\n" +
                               "[3] Charmander [Fire - Level 5]");
            while (!pokemonSet) {
                // Set player's initial pokemon
                StructureService.lineSeperator();
                int input = StructureService.readChoice(ColorText.colorText("---> ", ColorText.BLUE), 3);
                switch (input) {
                    case 1:
                        trainer.addNewPokemon(new Bulbasaur());
                        pokemonSet = true;
                        break;
                    case 2:
                        trainer.addNewPokemon(new Squirtle());
                        pokemonSet = true;
                        break;
                    case 3:
                        trainer.addNewPokemon(new Charmander());
                        pokemonSet = true;
                        break;
                }
            }

            StructureService.lineSeperator();
            System.out.println("OAK: You chose " + trainer.getTeam().get(0).getName() + ", an amazing choice. Best of luck!");
            printInGameMenu(trainer);
        } else {
            printInGameMenu(trainer);
        }
    }

    private void printLoginMenu() {
        StructureService.printHeading("Login or Register");
        System.out.println("[1] Login");
        System.out.println("[2] Register");
        StructureService.lineSeperator();

        int choice = StructureService.readChoice("---> ", 2);
        if (choice == 1) {
            login();
        } else {
            register();
        }
    }

    private void login() {
        while (true) {
            StructureService.lineSeperator();
            System.out.print(ColorText.colorText("Enter username: ", ColorText.BLUE));
            String username = scanner.next();
            System.out.print(ColorText.colorText("Enter password: ", ColorText.BLUE));
            String password = scanner.next();

            if (users.containsKey(username) && users.get(username).getPassword().equals(password)) {
                currentUsername = username;
                System.out.println("Login successful! Welcome " + username);
                return;
            } else {
                System.out.println("Invalid username or password. ");
                printLoginMenu();
                break;
            }
        }
    }

    private void register() {
        while (true) {
            String password = "";
            StructureService.lineSeperator();
            System.out.print(ColorText.colorText("Enter new username: ", ColorText.BLUE));
            String username = scanner.next();
            currentUsername = username;
            if (users.containsKey(username)) {
                System.out.println("Username already taken.");
                printLoginMenu();
                break;
            }else{
                System.out.print(ColorText.colorText("Enter new password: ", ColorText.BLUE));
                password = scanner.next();
            }

            users.put(username, new User(username, password));
            saveUsers();
            System.out.println("Registration successful! Welcome.");
            return;
        }
    }

    private void loadUsers() {
        try (Reader reader = new FileReader(Constants.USER_FILE)) {
            Gson gson = new Gson();
            User[] userArray = gson.fromJson(reader, User[].class);
            if (userArray != null) {
                for (User user : userArray) {
                    users.put(user.getUsername(), user);
                }
            }
        } catch (IOException e) {
            System.out.println("No existing user data found.");
        }
    }

    private void saveUsers() {
        try (Writer writer = new FileWriter(Constants.USER_FILE)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(users.values().toArray(new User[0]), writer);
            System.out.println("User data saved successfully!");
        } catch (IOException e) {
            System.out.println("Cannot save user data.");
            e.printStackTrace();
        }
    }

    public void printBeginningMenu() {
        String status1 = getSaveFileStatus(getUserSaveFile(currentUsername, Constants.SAVE_FILE_1));
        String status2 = getSaveFileStatus(getUserSaveFile(currentUsername, Constants.SAVE_FILE_2));
        String status3 = getSaveFileStatus(getUserSaveFile(currentUsername, Constants.SAVE_FILE_3));

        System.out.println("[1]Load Game: ");
        System.out.print("a. Save 1 - " + status1);
        System.out.print("     ");
        System.out.print("b. Save 2 - " + status2);
        System.out.print("     ");
        System.out.print("c. Save 3 - " + status3);
        System.out.println("     ");

        System.out.println("[2]Start a new Adventure: ");
        System.out.print("a. Save 1 - " + needOverride(status1));
        System.out.print("     ");
        System.out.print("b. Save 2 - " + needOverride(status2));
        System.out.print("     ");
        System.out.print("c. Save 3 - " + needOverride(status3));
        System.out.println("     ");

        System.out.println("[3]Exit");
        StructureService.lineSeperator();

        while (trainer == null) {
            switch (StructureService.readChoice("--->  ", new String[]{"1a", "1b", "1c", "2a", "2b", "2c", "3"})) {
                case "1a":
                    trainer = loadTrainer(currentUsername, getUserSaveFile(currentUsername, Constants.SAVE_FILE_1));
                    break;
                case "1b":
                    trainer = loadTrainer(currentUsername, getUserSaveFile(currentUsername, Constants.SAVE_FILE_2));
                    break;
                case "1c":
                    trainer = loadTrainer(currentUsername, getUserSaveFile(currentUsername, Constants.SAVE_FILE_3));
                    break;
                case "2a":
                    trainer = new Trainer();
                    saveTrainer(trainer, getUserSaveFile(currentUsername, Constants.SAVE_FILE_1));
                    break;
                case "2b":
                    trainer = new Trainer();
                    saveTrainer(trainer, getUserSaveFile(currentUsername, Constants.SAVE_FILE_2));
                    break;
                case "2c":
                    trainer = new Trainer();
                    saveTrainer(trainer, getUserSaveFile(currentUsername, Constants.SAVE_FILE_3));
                    break;
                case "3":
                    System.exit(0);
            }
            // If the trainer is not set correctly
            if (trainer == null || trainer.getUsername() == null) {
                System.out.println("You haven't created a trainer yet.");
                nameSet = false;
            } else {
                nameSet = true;
            }
        }
    }


    public void printInGameMenu(Trainer trainer) {
        Map map = new Map();
        boolean inMenu = true;

        while (inMenu) {
            StructureService.printHeading("MENU");
            System.out.println("You are currently in " + trainer.getLocation());
            City curCity = map.findCityByName(trainer.getLocation());
            StructureService.lineSeperator();

            ArrayList<String> choices = new ArrayList<>();
            System.out.println("[1] Move to: ");
            for (int i = 0; i < curCity.getConnections().size(); i++) {
                if (i != curCity.getConnections().size() - 1) {
                    System.out.print(Constants.LETTER_NUMBER[i] + ". " + curCity.getConnections().get(i).getCityName());
                    System.out.print("   ");
                } else {
                    System.out.println(Constants.LETTER_NUMBER[i] + ". " + curCity.getConnections().get(i).getCityName());
                }
                choices.add("1" + Constants.LETTER_NUMBER[i]);
            }

            if (curCity.getName().equals("Pallet Town")) {
                System.out.print("[2] Talk to Mom");
            } else if (curCity.getName().equals("Lavender Town")) {
                System.out.print("[2] PokeMaze");
            } else {
                System.out.print("[2] Challenge Gym leader ");
            }
            System.out.println(curCity.displayGymLeader());
            choices.add("2");

            System.out.print("[3] Fight Wild Pokemon ");
            curCity.displayCatchablePokemon();
            choices.add("3");

            System.out.println("[4] Player Options");
            System.out.println("a.Show map      b.Show My Pokemon      c.Show My badges      d.Save and Exit");
            choices.add("4a");
            choices.add("4b");
            choices.add("4c");
            choices.add("4d");

            if (curCity.getName().equals("Saffron City")) {
                System.out.println("[5] Rival's Race");
                choices.add("5");
            }

            if (curCity.getName().equals("Fuchsia City")) {
                System.out.println("[5] Safari Zone");
                choices.add("5");
            }

            StructureService.lineSeperator();
            String input = StructureService.readChoice("--->", choices.toArray(new String[0]));
            StructureService.lineSeperator();
            switch (input) {
                case "2":
                    if (curCity.getName().equals("Pallet Town")) {
                        DialogueService.printTalkToMom(trainer.getUsername());
                        StructureService.continueGame();
                    } else if (curCity.getName().equals("Lavender Town")) {
                        PokeMaze pokeMaze = new PokeMaze();
                        pokeMaze.mazeChallenge();
                        StructureService.continueGame();
                    } else {
                        GymLeader gymLeader = curCity.getGymLeader();
                        if (!trainer.getBadges().contains(gymLeader.getBadgeName())) {
                            // Trainer hasn't got the gym badge
                            System.out.println("You are about to challenge Gym Leader " + gymLeader.getLeaderName());
                            System.out.println(gymLeader.getDialogue());
                            roundBattleService.gymLeaderBattle(trainer, choosePokemon(trainer), gymLeader);
                            StructureService.continueGame();
                        } else {
                            // Trainer has already got the gym badge
                            System.out.println("You cannot challenge the gym leader again.");
                            StructureService.continueGame();
                        }
                    }
                    break;
                case "3":
                    Random random = new Random();
                    int wildPokemonNumber = random.nextInt(3);
                    roundBattleService.wildPokemonRoundBattle(trainer, choosePokemon(trainer), curCity.getCatchablePokemons().get(wildPokemonNumber));
                    break;
                case "4a":
                    map.displayMap(trainer);
                    StructureService.continueGame();
                    break;
                case "4b":
                    trainer.displayTeam();
                    StructureService.continueGame();
                    break;
                case "4c":
                    trainer.displayBadges();
                    StructureService.continueGame();
                    break;
                case "4d":
                    if (getSaveFileStatus(Constants.SAVE_FILE_1).equals("empty")) {
                        saveTrainer(trainer, getUserSaveFile(currentUsername, Constants.SAVE_FILE_1));
                    } else if (getSaveFileStatus(Constants.SAVE_FILE_2).equals("empty")) {
                        saveTrainer(trainer, getUserSaveFile(currentUsername, Constants.SAVE_FILE_2));
                    } else if (getSaveFileStatus(Constants.SAVE_FILE_3).equals("empty")) {
                        saveTrainer(trainer, getUserSaveFile(currentUsername, Constants.SAVE_FILE_3));
                    } else {
                        System.out.println("You have no place to store your progress.");
                    }
                    System.exit(0);
                case "5":
                    if (curCity.getName().equals("Saffron City")) {
                        RivalRace rivalRace = new RivalRace();
                        rivalRace.rivalRaceChallenge();
                        StructureService.continueGame();
                    } else if (curCity.getName().equals("Fuchsia City")) {
                        SafariZone safariZone = new SafariZone();
                        safariZone.safariZoneChallenge();
                        StructureService.continueGame();
                    }
                    break;
                default:
                    if (input.startsWith("1")) {
                        String connectionLetter = input.substring(1);
                        int connectionIndex = Arrays.asList(Constants.LETTER_NUMBER).indexOf(connectionLetter);
                        trainer.setLocation(curCity.getConnections().get(connectionIndex).getCityName());
                    }
            }
        }
    }

    private static Pokemon choosePokemon(Trainer trainer) {
        trainer.displayTeam();
        int input = StructureService.readChoice("Choose a pokemon to battle: ", trainer.getTeam().size());
        Pokemon chosenPokemon = null;
        for (int i = 1; i <= input; i++) {
            chosenPokemon = trainer.getTeam().get(i - 1);
        }
        return chosenPokemon;
    }

    private Trainer loadTrainer(String username, String saveFile) {
        try (Reader reader = new FileReader(saveFile)) {
            Gson gson = new Gson();
            return gson.fromJson(reader, Trainer.class);
        } catch (IOException e) {
            return null;
        }
    }



    private void saveTrainer(Trainer trainer, String saveFile) {
        try (Writer writer = new FileWriter(saveFile)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(trainer, writer);
            System.out.println("Save successfully!");
        } catch (IOException e) {
            System.out.println("Cannot save the file.");
            e.printStackTrace();
        }
    }


    private String getSaveFileStatus(String saveFile) {
        Trainer trainer = loadTrainer(currentUsername, saveFile);
        if (trainer != null && trainer.getUsername() != null) {
            return trainer.getUsername();
        } else {
            return "empty";
        }
    }


    private static String needOverride(String status) {
        return (status.equals("empty") ? "new" : "Override");
    }

    private String getUserSaveFile(String username, String baseFile) {
        return username + "_" + baseFile;
    }

}
