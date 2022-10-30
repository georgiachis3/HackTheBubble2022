import javax.swing.*;

public class Main {
    private static JPanel contentPane;

    public static void main(String[] args) {
        JFrame frame = new JFrame();

        frame.setSize(600, 400);

        contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        frame.setVisible(true);
    }
}
