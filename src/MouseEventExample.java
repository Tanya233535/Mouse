import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MouseEventExample extends JPanel implements MouseListener {

    private ArrayList<Point> points;

    public MouseEventExample() {
        points = new ArrayList<>();
        addMouseListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        for (Point point : points) {
            g.fillRect(point.x, point.y, 20, 20);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // Добавляем новую точку в список при щелчке мыши
        if (SwingUtilities.isLeftMouseButton(e)) {
            points.add(e.getPoint());
            repaint(); // Перерисовываем панель
        }
    }

    @Override
    public void mousePressed(MouseEvent e) { }

    @Override
    public void mouseReleased(MouseEvent e) { }

    @Override
    public void mouseEntered(MouseEvent e) { }

    @Override
    public void mouseExited(MouseEvent e) { }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Простое добавление");
        MouseEventExample panel = new MouseEventExample();
        frame.add(panel);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
