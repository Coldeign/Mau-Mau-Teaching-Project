package maumau.config;

import Prog1Tools.IOTools;
import maumau.deck.DeckType;
import maumau.player.PlayerType;
import util.enumUtil.EnumUtils;

import java.io.*;
import java.util.Arrays;

public class Config {
    private static final String CFG_FILE_NAME = "config.cfg";
    private static final Config INSTANCE = new Config();
    private DeckType deckType;
    private PlayerType[] playerTypes;

    private Config(){
        readConfig();
        editConfig();
        saveConfig();
    }

    public static Config getInstance() {
        return INSTANCE;
    }

    public DeckType getDeckType() {
        return deckType;
    }

    public PlayerType[] getPlayerTypes() {
        return playerTypes;
    }

    @Override
    public String toString() {
        return "Config {" + "deckType = " + deckType +
                ", playerTypes = " + Arrays.toString(playerTypes) +
                '}';
    }

    private void readConfig() {
        File file = new File(CFG_FILE_NAME);

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("=");
                if (parts.length != 2) {
                    continue;
                }

                String key = parts[0].trim();
                String value = parts[1].trim();

                switch (key) {
                    case "deckType":
                        this.deckType = DeckType.valueOf(value);
                        break;
                    case "playerTypes":
                        String[] playerTypeStrings = value.split(",");
                        if (playerTypeStrings.length < 2) {
                            throw new InvalidConfigException();
                        }
                        this.playerTypes = new PlayerType[playerTypeStrings.length];
                        for (int i = 0; i < playerTypeStrings.length; i++) {
                            this.playerTypes[i] = PlayerType.valueOf(playerTypeStrings[i]);
                        }
                        break;
                }
            }
        } catch (IOException | IllegalArgumentException e) {
            e.printStackTrace();
            loadDefaultConfig();
            System.out.println("Loading default configuration...");
        } finally {
            System.out.println("Loaded " + this);
        }
    }

    private void saveConfig() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CFG_FILE_NAME))) {
            writer.write("deckType=" + deckType.name());
            writer.newLine();

            writer.write("playerTypes=");
            for (int i = 0; i < playerTypes.length; i++) {
                writer.write(playerTypes[i].name());
                if (i < playerTypes.length - 1) {
                    writer.write(",");
                }
            }
            System.out.println("Saved " + this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editConfig() {
        if (makeChangeToSetting("deck type")) {
            deckType = EnumUtils.getFromUserInput(DeckType.class);
        }
        if (makeChangeToSetting("players")) {
            int playerAmount;
            do {
                playerAmount = IOTools.readInt("How many players would you like?");
            } while (playerAmount < 2);
            playerTypes = new PlayerType[playerAmount];
            for (int i = 0; i < playerTypes.length; i++) {
                playerTypes[i] = EnumUtils.getFromUserInput(PlayerType.class);
            }
        }
    }

    private void loadDefaultConfig() {
        deckType = DeckType.LINKED_STACK;
        playerTypes = new PlayerType[] {PlayerType.HUMAN, PlayerType.COM};
    }

    private boolean makeChangeToSetting(String string) {
        char makeChange;
        do {
            makeChange  = IOTools.readChar("Make change to setting: " + string + "? (y/n) ");
        } while (makeChange != 'y' && makeChange != 'n');

        return switch (makeChange) {
            case 'y' -> true;
            case 'n' -> false;
            default -> throw new IllegalStateException("Unexpected value: " + makeChange); // technically unreachable
        };
    }
}
