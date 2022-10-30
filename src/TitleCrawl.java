import javax.swing.*;
import java.awt.*;

public class TitleCrawl extends JPanel{
    public void TitleCrawl() throws InterruptedException {
        setBackground(Color.black);
        setLayout(new BorderLayout());

        JPanel textPanel = new JPanel();
        add(textPanel, BorderLayout.CENTER);

        displayIntro(textPanel);
    }

    private void displayIntro(JPanel textPanel) throws InterruptedException {
        JLabel line1 = new TitleText("It's the year 2062");
        JLabel line2 = new TitleText("You are a horse");
        JLabel line3 = new TitleText("Space horse", true);
        textPanel.add(line1);
        Thread.sleep(2000);
        textPanel.add(line2);
        Thread.sleep(2000);
        textPanel.removeAll();
        textPanel.add(line3);
        Thread.sleep(10000);
    }

    private class TitleText extends JLabel {
        public TitleText(String text) {
            this(text, false);
        }

        public TitleText(String text, boolean mainTitle) {
            super(text, SwingConstants.CENTER);

            int fontSize;
            if (mainTitle) {
                setForeground(Color.decode("#C7AD43"));
                fontSize = 70;
            } else {
                setForeground(Color.decode("#34EBE1"));
                fontSize = 16;
            }
            setFont(new Font("Sans-Serif", Font.BOLD, fontSize));
        }
    }
}
