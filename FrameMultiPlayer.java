import javax.swing.JFrame;

public class FrameMultiPlayer {

    public FrameMultiPlayer() 
    {
        JFrame frame = new JFrame();
        SnakeGameMulti screen = new SnakeGameMulti();
        frame.add(screen);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Snake");
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        
    }
}
