package util;
import Character.*;
import Pokemon.*;

import java.util.ArrayList;
import java.util.Random;

public class RoundBattleService {
    private Random random = new Random();
    public double otherAttackRateCalculate(Pokemon trainerPokemon, Pokemon otherPokemon){
        double otherAttackRate = 1.0;
        for(String weakType: trainerPokemon.getWeakAgainst()){
            if(otherPokemon.getType().equals(weakType)){
                System.out.println("The opponent " + otherPokemon.getName() + " 's type " +
                        otherPokemon.getType() + " is strong against your pokemon " + trainerPokemon.getName());
                otherAttackRate += 0.2;
            }
        }

        for(String strongType: trainerPokemon.getStrongAgainst()){
            if(otherPokemon.getType().equals(strongType)){
                System.out.println("The opponent " + otherPokemon.getName() + " 's type " +
                        otherPokemon.getType() + " is weak against your pokemon " + trainerPokemon.getName());
                otherAttackRate -= 0.2;
            }
        }

        return otherAttackRate;
    }

    public double trainerAttackRateCalculate(Pokemon trainerPokemon, Pokemon otherPokemon){
        double trainerAttackRate = 1.0;
        for(String weakType: otherPokemon.getWeakAgainst()){
            if(trainerPokemon.getType().equals(weakType)){
                System.out.println("Your pokemon " + trainerPokemon.getName() + "'s type " +
                        trainerPokemon.getType() + " is strong against the opponent " + otherPokemon.getName());
                trainerAttackRate += 0.2;
            }
        }

        for(String strongType: otherPokemon.getStrongAgainst()){
            if(trainerPokemon.getType().equals(strongType)){
                System.out.println("Your pokemon " + trainerPokemon.getName() + "'s type " +
                        trainerPokemon.getType() + " is weak against the opponent " + otherPokemon.getName());
                trainerAttackRate -= 0.2;
            }
        }

        return trainerAttackRate;
    }

    public void showStatus(Pokemon pokemon){
        System.out.println("[" + pokemon.getName() + " HP: " + pokemon.getHp() + "/" + pokemon.getShowHp() + "]");
    }

    public void gymLeaderBattle(Trainer trainer,  Pokemon trainerPokemon, GymLeader gymLeader){
        System.out.println("Prepare yourself for an intense battle!");
        System.out.print("Your Pokémon:");
        System.out.println(trainerPokemon.getName() + " - " + "Level: " + trainerPokemon.getLevel());
        StructureService.lineSeperator();
        System.out.println("Battle Start: Trainer " + trainer.getUsername() + " vs. " + "Gym Leader " + gymLeader.getLeaderName() + "!");
        System.out.println(gymLeader.getLeaderName() + " sends out " + gymLeader.getLeaderPokemon().getName() + " [Level " + gymLeader.getLeaderPokemon().getLevel() + "]!");
        System.out.println(trainerPokemon.getName() + " is sent out!");
        battle(trainer, trainerPokemon, gymLeader.getLeaderPokemon());
        if(gymLeader.getLeaderPokemon().getHp() <= 0){
            trainer.addBadges(gymLeader.getBadgeName());
            System.out.println("Congratulations! You have defeated Gym Leader " + gymLeader.getLeaderName() + " and earned the " + gymLeader.getBadgeName());
        }else{
            gymLeader.getLeaderPokemon().setHp(gymLeader.getLeaderPokemon().getShowHp());
            trainerPokemon.setHp(trainerPokemon.getShowHp());
        }

    }

    public void wildPokemonRoundBattle(Trainer trainer, Pokemon trainerPokemon, Pokemon otherPokemon){
        System.out.println("Prepare yourself for an intense battle!");
        System.out.println("Your Pokémon: ");
        System.out.println(trainerPokemon.getName() + " - " + "Level: " + trainerPokemon.getLevel());
        StructureService.lineSeperator();
        System.out.println("Battle Start: Trainer " + trainer.getUsername() + " vs. " + otherPokemon.getName());
        System.out.println("A wild " + otherPokemon.getName() + " [Level " + otherPokemon.getLevel() + "] " + "appeared!");
        battle(trainer, trainerPokemon, otherPokemon);
        if(otherPokemon.getHp() <= 0){
            int choice = StructureService.readChoice("The wild " + otherPokemon.getName() + " is weak. Do you want to try to catch it?\n 1. Yes\n 2. No\n", 2);
            if(choice == 1){
                otherPokemon.setHp(otherPokemon.getShowHp() / 2);
                trainer.addNewPokemon(otherPokemon);
            }
        }
    }

    private void battle(Trainer trainer, Pokemon trainerPokemon, Pokemon otherPokemon){
        double updatedOtherAttackRate = otherAttackRateCalculate(trainerPokemon, otherPokemon);
        double updatedTrainderAttackRate = trainerAttackRateCalculate(trainerPokemon, otherPokemon);
        int roundCnt = 0;
        do{
            roundCnt++;
            //Trainer's turn
            System.out.println("Round " + roundCnt + ": ");
            System.out.println(trainerPokemon.displayMoves());
            System.out.println("Which move will " + trainerPokemon.getName() + " use?");
            int choice = StructureService.readChoice("Your choice: ", 2) - 1;
            ArrayList<Moves> trainerPokemonMovesList = trainerPokemon.getMovesList();
            int trainerPokemonAttack =  (int)updatedTrainderAttackRate * trainerPokemonMovesList.get(choice).getAttack();
            System.out.println(trainerPokemon.getName() + " used " + trainerPokemonMovesList.get(choice).getMoveName());
            if(updatedTrainderAttackRate > 1){
                System.out.println("It's super effective!");
                System.out.print(otherPokemon.getName() + "'s HP drops significantly.");
            }else{
                System.out.print(otherPokemon.getName() + " barely felt that.");
            }

            if(otherPokemon.getShowHp() - trainerPokemonAttack > 0){
                otherPokemon.setHp(otherPokemon.getHp() - trainerPokemonAttack);
            }else{
                otherPokemon.setHp(0);
            }

            showStatus(otherPokemon);
            if(otherPokemon.getHp() == 0){
                System.out.println(otherPokemon.getName() + " faints!");
                System.out.println(trainerPokemon.getName() + " gained " + otherPokemon.getXp() + " xp.");
                trainerPokemon.xpCheck();
                break;
            }

            //Opponent's turn
            StructureService.lineSeperator();
            int otherPokemonChoice = random.nextInt(2);
            ArrayList<Moves> otherPokemonMovesList = otherPokemon.getMovesList();
            int otherPokemonAttack =  (int)updatedOtherAttackRate * otherPokemonMovesList.get(otherPokemonChoice).getAttack();
            System.out.println(otherPokemon.getName() + " used " + otherPokemonMovesList.get(otherPokemonChoice).getMoveName());
            if(updatedOtherAttackRate > 1){
                System.out.println("It's super effective!");
                System.out.print(trainerPokemon.getName() + "'s HP drops significantly.");
            }else{
                System.out.print(trainerPokemon.getName() + " barely felt that.");
            }

            if(trainerPokemon.getShowHp() - otherPokemonAttack > 0){
                trainerPokemon.setHp(trainerPokemon.getHp() - trainerPokemonAttack);
            }else{
                trainerPokemon.setHp(0);
            }

            showStatus(trainerPokemon);
            if(trainerPokemon.getHp() <= 0){
                System.out.println(trainerPokemon.getName() + " faints!");
                System.out.println("You failed the battle.");
                break;
            }
        }while(otherPokemon.getHp() > 0 && trainerPokemon.getHp() > 0);

    }
}
