import javax.swing.JFrame;

public class FrameSinglePlay {

    public FrameSinglePlay() 
    {
        JFrame frame = new JFrame();
        SnakeGameSinglePlay screen = new SnakeGameSinglePlay();
        

        frame.add(screen);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Snake Single Player Edition");
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        
    }
}
