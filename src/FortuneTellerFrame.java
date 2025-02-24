import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {
    private JTextArea fortuneTextArea;
    private ArrayList<String> fortunes;
    private int lastIndex = -1;

    public FortuneTellerFrame() {
        setTitle("Fortune Teller");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize((int) (Toolkit.getDefaultToolkit().getScreenSize().width * 0.75),
                (int) (Toolkit.getDefaultToolkit().getScreenSize().height * 0.75));
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        // Top Panel
        JPanel topPanel = new JPanel();
        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("resource/fortune.jpg"));
        JLabel titleLabel = new JLabel("Fortune Teller", icon, JLabel.CENTER);
        titleLabel.setFont(new Font("sansSerif", Font.PLAIN, 18));

        titleLabel.setVerticalTextPosition(SwingConstants.BOTTOM); // Text below the icon
        titleLabel.setHorizontalTextPosition(SwingConstants.CENTER); // Center text horizontally

        topPanel.add(titleLabel);

        add(topPanel, BorderLayout.NORTH);

        //Middle
        JPanel middlePanel = new JPanel();
        fortuneTextArea = new JTextArea(10,40);
        fortuneTextArea.setFont(new Font("SansSerif", Font.PLAIN, 18));
        fortuneTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(fortuneTextArea);
        middlePanel.add(scrollPane);
        add(middlePanel, BorderLayout.CENTER);

        //Bottom
        JPanel bottomPanel = new JPanel();
        JButton readFortuneBtn = new JButton("Read My Fortune");
        JButton quitBtn = new JButton("Quit");
        middlePanel.add(scrollPane);
        readFortuneBtn.setFont(new Font("SansSerif", Font.BOLD, 24));
        quitBtn.setFont(new Font("SansSerif", Font.BOLD, 24));

        readFortuneBtn.addActionListener((ActionEvent e) -> displayFortune());
        quitBtn.addActionListener((ActionEvent e) -> System.exit(0));

        bottomPanel.add(readFortuneBtn);
        bottomPanel.add(quitBtn);
        add(bottomPanel, BorderLayout.SOUTH);

        theFortunes();
    }
    private void theFortunes(){
        fortunes = new ArrayList<>();
        fortunes.add("You will have a bad day");
        fortunes.add("You will have a good day");
        fortunes.add("You will Fall in love");
        fortunes.add("You will soon be rich");
        fortunes.add("Explore more and you will find happiness");
        fortunes.add("The answer you seek is near you");
        fortunes.add("Someone is thinking about you right now");
        fortunes.add("Someone misses you ");
        fortunes.add("Take the risk");
        fortunes.add("Your action will be rewarded soon");
        fortunes.add("A friend will visit you soon");
        fortunes.add("You will be happy");
    }
    private void displayFortune() {
        Random random = new Random(); // Create random number generator
        int index;
        do {
            index = random.nextInt(fortunes.size()); // Generate random index
        } while (index == lastIndex); // Ensure it's different from last fortune
        lastIndex = index; // Update last index

        fortuneTextArea.append(fortunes.get(index) + "\n"); // Append fortune to text area
    }
}
