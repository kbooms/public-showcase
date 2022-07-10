package com.kevinbooms;

import java.util.Scanner;

/*
 * *************************
 * JUMP TO FLAG GAME -coded by Kevin Booms 7/9/2022
 * Description: The player is prompted to enter a Flag Height, and a "Big jump" height.
 * The game calculates and displays how many jumps up a climbing wall it will take to reach
 * the flag.
 *
 */
public class JumpToFlag {

    // properties
    private int playerHeight = 0;
    private int flagHeight; // the height of the flag
    private int countJumps = 0; // jump counter for the game
    private int bigJump; // the height of a player big jump
    private final int LIL_JUMP = 1; // the height of a regular jump, 1 space
    private
        // constructor
    JumpToFlag(int flagHeight, int bigJump) {
        this.flagHeight = flagHeight;
        this.bigJump = bigJump;
        System.out.println("New game started with " + getFlagHeight() + ", " +  getBigJump() + ", " + getPlayerHeight());
    }

    // gets/sets
    public int getPlayerHeight() {
        return playerHeight;
    }
    public void setPlayerHeight(int playerHeight) {
        this.playerHeight = playerHeight;
    }
    public int getFlagHeight() {
        return flagHeight;
    }
    public int getCountJumps() { return countJumps;}
    public void setCountJumps(int countJumps) {
        this.countJumps = countJumps;
    }
    public int getBigJump() {
        return bigJump;
    }
    public int getLIL_JUMP() {
        return LIL_JUMP;
    }

    // method to determine if player is at flag
    public boolean isPlayerAtFlag() {
        return (getPlayerHeight() >= getFlagHeight());
    }
    // method to determine if a big jump can happen
    public boolean canDoBigJump() {
        return (getFlagHeight() >= getPlayerHeight() + getBigJump());
    }
    // method to calculate next jump
    public int calculateJump() {
        if (canDoBigJump()) {
            setPlayerHeight(getPlayerHeight() + getBigJump()); // do a big jump
        } else {
            setPlayerHeight(getPlayerHeight() + getLIL_JUMP()); // otherwise do a regular jump
        }
        setCountJumps(getCountJumps() + 1);
        return getPlayerHeight();
    }
    // method to display game over message
    public void gameOver() {
        System.out.println("You made it to the flag in " + getCountJumps() + " jumps!");
    }

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.print("Please enter the Flag Height: ");
        int gameFlagHeight = userInput.nextInt();

        System.out.print("Please enter the Big Jump Height: ");
        int gameBigJump = userInput.nextInt();

        JumpToFlag playJumpGame = new JumpToFlag(gameFlagHeight, gameBigJump);
        while(!playJumpGame.isPlayerAtFlag()) {
            playJumpGame.calculateJump();
        }
        playJumpGame.gameOver();

    }
}
