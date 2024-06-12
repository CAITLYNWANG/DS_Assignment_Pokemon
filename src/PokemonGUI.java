import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class PokemonGUI extends JFrame {

    // Game state variables
    private String playerName = "Player";
    private String currentCity = "Pallet Town";
    private ArrayList<Pokemon> pokemonTeam = new ArrayList<>();
    private ArrayList<String> badges = new ArrayList<>();
    private ArrayList<String> wildPokemons = new ArrayList<>();
    private Map<String, GymLeader> gymLeaders = new HashMap<>();
    private Random random = new Random();

    // GUI components
    private JTextArea displayArea;
    private JPanel buttonPanel;
    private JLabel imageLabel;
    private JLabel gymLeaderLabel;
    private JLabel wildPokemonLabel;

    public PokemonGUI() {
        setTitle("Pokemon Kanto Adventure");
        setSize(1024, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);
        scrollPane.setPreferredSize(new Dimension(1024, 50));
        add(scrollPane, BorderLayout.SOUTH);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 4));
        add(buttonPanel, BorderLayout.NORTH);

        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(imageLabel, BorderLayout.CENTER);

        gymLeaderLabel = new JLabel();
        gymLeaderLabel.setHorizontalAlignment(SwingConstants.LEFT);
        gymLeaderLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        add(gymLeaderLabel, BorderLayout.SOUTH);

        wildPokemonLabel = new JLabel();
        wildPokemonLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        wildPokemonLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        add(wildPokemonLabel, BorderLayout.SOUTH);

        JButton moveButton = new JButton("Move");
        moveButton.addActionListener(new MoveAction());
        buttonPanel.add(moveButton);

        JButton gymButton = new JButton("Challenge Gym Leader");
        gymButton.addActionListener(new GymAction());
        buttonPanel.add(gymButton);

        JButton wildPokemonButton = new JButton("Find Wild Pokemon");
        wildPokemonButton.addActionListener(new WildPokemonAction());
        buttonPanel.add(wildPokemonButton);

        JButton optionsButton = new JButton("Player Options");
        optionsButton.addActionListener(new OptionsAction());
        buttonPanel.add(optionsButton);

        initializeGymLeaders();
        showLogo();
        initializePlayer();
    }

    private void showLogo() {
        ImageIcon logoIcon = loadImage("image/pokemonlogo");
        if (logoIcon != null) {
            imageLabel.setIcon(logoIcon);
            displayArea.setText("Welcome to Pokemon - Kanto Adventures\n");
        } else {
            displayArea.setText("Pokemon logo not found.\n");
        }
    }

    private void initializePlayer() {
        // Initial Pokemon for the player
        Map<String, Integer> moves = new HashMap<>();
        moves.put("Vine Whip", 30);
        moves.put("Tackle", 20);
        ArrayList<String> strengths = new ArrayList<>();
        strengths.add("Water");
        strengths.add("Ground");
        strengths.add("Rock");
        ArrayList<String> weaknesses = new ArrayList<>();
        weaknesses.add("Fire");
        weaknesses.add("Flying");
        weaknesses.add("Psychic");
        pokemonTeam.add(new Pokemon("bulbasaur", "Grass/Poison", 5, 45, moves, strengths, weaknesses));
    }

    private void initializeGymLeaders() {
        gymLeaders.put("Viridian City",
                new GymLeader("Giovanni", "image/giovanni.jpg"));
        gymLeaders.put("Pewter City",
                new GymLeader("Brock", "image/brock.webp"));
        gymLeaders.put("Cerulean City",
                new GymLeader("Misty", "image/misty.webp"));
        gymLeaders.put("Vermilion City",
                new GymLeader("Lt. Surge", "image/ltsurge.png"));
        gymLeaders.put("Celadon City",
                new GymLeader("Erika", "image/erika.png"));
        gymLeaders.put("Fuchsia City",
                new GymLeader("Koga", "image/koga.png"));
        gymLeaders.put("Saffron City",
                new GymLeader("Sabrina", "image/sabrina.png"));
        gymLeaders.put("Cinnabar Island",
                new GymLeader("Blaine", "image/blaine.webp"));
        gymLeaders.put("Lavender Town",
                new GymLeader("Ghost Master", "image/koga.png"));
    }

    private void displayMap() {
        ImageIcon mapIcon = loadImage("image/map");
        if (mapIcon != null) {
            JFrame mapFrame = new JFrame("Map");
            mapFrame.setSize(1024, 768);
            JLabel mapLabel = new JLabel(mapIcon);
            mapFrame.add(mapLabel);
            mapFrame.setVisible(true);
        } else {
            displayArea.append("Map image not found.\n");
        }
    }

    private ImageIcon loadImage(String basePath) {
        String[] extensions = { ".png", ".jpg", ".jpeg", ".webp" };
        for (String ext : extensions) {
            String path = basePath + ext;
            File imgFile = new File(path);
            if (imgFile.exists()) {
                return new ImageIcon(path);
            }
        }
        return null;
    }

    private class MoveAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String[] cities = { "Viridian City", "Pewter City", "Cerulean City", "Vermilion City", "Celadon City",
                    "Fuchsia City", "Saffron City", "Cinnabar Island", "Lavender Town" };
            String city = (String) JOptionPane.showInputDialog(
                    PokemonGUI.this,
                    "Select a city to move to:",
                    "Move",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    cities,
                    currentCity);

            if (city != null && city.length() > 0) {
                currentCity = city;
                displayArea.append("Moving to " + currentCity + "...\n");
                displayArea.append("You are now in " + currentCity + ".\n");
                updateCityImage(currentCity);
                gymLeaderLabel.setIcon(null);
                wildPokemonLabel.setIcon(null);
            }
        }
    }

    private void updateCityImage(String city) {
        String basePath = "image/"
                + city.replace(" ", "").toLowerCase();
        ImageIcon cityIcon = loadImage(basePath);
        if (cityIcon != null) {
            imageLabel.setIcon(cityIcon);
        } else {
            displayArea.append("City image not found for " + currentCity + ".\n");
        }
    }

    private class GymAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            GymLeader gymLeader = gymLeaders.get(currentCity);
            if (gymLeader != null) {
                ImageIcon gymLeaderIcon = loadImage(gymLeader.getImagePath());
                if (gymLeaderIcon != null) {

                    JFrame gymleaderFrame = new JFrame("Gym Leader");
                    gymleaderFrame.setSize(200, 668);
                    JLabel gymLeaderLabel = new JLabel(gymLeaderIcon);
                    gymleaderFrame.add(gymLeaderLabel);
                    gymleaderFrame.setVisible(true);

                    badges.add(gymLeader.getName());
                } else {
                    displayArea.append("Gym leader image not found for " + currentCity + ".\n");
                }
            } else {
                displayArea.append("No gym leader for " + currentCity + ".\n");
            }
        }

        private ImageIcon loadImage(String basePath) {
            String[] extensions = { ".png", ".jpg", ".jpeg", ".webp" };
            for (String ext : extensions) {
                String path = basePath + ext;
                File imgFile = new File(path);
                if (imgFile.exists()) {
                    return new ImageIcon(path);
                }
            }
            return null;
        }

        private ImageIcon scaleImage(ImageIcon icon, int width, int height) {
            Image img = icon.getImage();
            Image scaledImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            return new ImageIcon(scaledImg);
        }

    }

    private class WildPokemonAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String[] pokemons = {
                    "bulbasaur", "charmander", "squirtle", "pidgey", "meowth", "growlithe",
                    "kadabra", "kangaskhan", "koffing", "krabby", "nidoqueen", "nidoran",
                    "onix", "pidgey", "ponyta", "raichu", "sandshrew", "scyther", "shellder",
                    "spearow", "staryu", "venonat", "victreebel", "vulpix", "ekans", "exeggutor"
            };
            String randomPokemon = pokemons[random.nextInt(pokemons.length)];
            String basePath = "image/" + randomPokemon;
            ImageIcon wildPokemonIcon = loadImage(basePath);
            if (wildPokemonIcon != null) {
                ImageIcon scaledWildPokemonIcon = scaleImage(wildPokemonIcon, 150, 150);
                wildPokemonLabel.setIcon(scaledWildPokemonIcon);
                wildPokemons.add(randomPokemon);
            } else {
                displayArea.append("Wild Pokemon image not found.\n");
            }
        }

        private ImageIcon scaleImage(ImageIcon icon, int width, int height) {
            Image img = icon.getImage();
            Image scaledImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            return new ImageIcon(scaledImg);
        }
    }

    private class OptionsAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String[] options = { "Show map", "Show My Pokemon", "Show My badges", "Save and Exit" };
            String option = (String) JOptionPane.showInputDialog(
                    PokemonGUI.this,
                    "Select an option:",
                    "Player Options",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    options,
                    "Show map");

            if (option != null && option.length() > 0) {
                switch (option) {
                    case "Show map":
                        displayMap();
                        break;
                    case "Show My Pokemon":
                        showPokemonTeam();
                        break;
                    case "Show My badges":
                        showBadges();
                        break;
                    case "Save and Exit":
                        saveGame();
                        break;
                }
            }
        }
    }

    private void showPokemonTeam() {
        StringBuilder pokemonList = new StringBuilder("Your Pokemon team:\n");
        for (Pokemon pokemon : pokemonTeam) {
            pokemonList.append(pokemon.toString()).append("\n");
        }
        for (String pokemon : wildPokemons) {
            pokemonList.append(pokemon).append("\n");
        }
        JOptionPane.showMessageDialog(this, pokemonList.toString(), "My Pokemon", JOptionPane.INFORMATION_MESSAGE);
    }

    private void showBadges() {
        StringBuilder badgeList = new StringBuilder("Your badges:\n");
        for (String badge : badges) {
            badgeList.append(badge).append("\n");
        }
        JOptionPane.showMessageDialog(this, badgeList.toString(), "My Badges", JOptionPane.INFORMATION_MESSAGE);
    }

    private void saveGame() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("savegame.dat"))) {
            out.writeObject(playerName);
            out.writeObject(currentCity);
            out.writeObject(pokemonTeam);
            out.writeObject(badges);
            out.writeObject(wildPokemons);
            displayArea.append("Game saved successfully.\n");
        } catch (IOException ex) {
            displayArea.append("Failed to save game.\n");
        }
    }

    private void loadGame() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("savegame.dat"))) {
            playerName = (String) in.readObject();
            currentCity = (String) in.readObject();
            pokemonTeam = (ArrayList<Pokemon>) in.readObject();
            badges = (ArrayList<String>) in.readObject();
            wildPokemons = (ArrayList<String>) in.readObject();
            displayArea.append("Game loaded successfully.\n");
        } catch (IOException | ClassNotFoundException ex) {
            displayArea.append("Failed to load game.\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PokemonGUI gui = new PokemonGUI();
            gui.setVisible(true);
        });
    }
}

class Pokemon implements Serializable {
    private String name;
    private String type;
    private int level;
    private int hp;
    private Map<String, Integer> moves;
    private ArrayList<String> strengths;
    private ArrayList<String> weaknesses;

    public Pokemon(String name, String type, int level, int hp, Map<String, Integer> moves,
            ArrayList<String> strengths, ArrayList<String> weaknesses) {
        this.name = name;
        this.type = type;
        this.level = level;
        this.hp = hp;
        this.moves = moves;
        this.strengths = strengths;
        this.weaknesses = weaknesses;
    }

    @Override
    public String toString() {
        return name + " - Level: " + level + ", Type: " + type + ", HP: " + hp;
    }
}

class GymLeader {
    private String name;
    private String imagePath;

    public GymLeader(String name, String imagePath) {
        this.name = name;
        this.imagePath = imagePath;
    }

    public String getName() {
        return name;
    }

    public String getImagePath() {
        return imagePath;
    }
}
