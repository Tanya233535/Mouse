import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MouseWheelClickExample extends JPanel implements MouseListener {

    private ArrayList<Rectangle> rectangles;

    public MouseWheelClickExample() {
        rectangles = new ArrayList<>();
        addMouseListener(this);
        rectangles.add(new Rectangle(50, 50, 100, 100));
        rectangles.add(new Rectangle(200, 50, 100, 100));
        rectangles.add(new Rectangle(350, 50, 100, 100));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        for (Rectangle rect : rectangles) {
            g.drawRect(rect.x, rect.y, rect.width, rect.height);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON2) { // Проверяем, что клик был колесиком
            Rectangle clickedRect = null;
            for (Rectangle rect : rectangles) {
                if (rect.contains(e.getPoint())) {
                    clickedRect = rect;
                    break;
                }
            }
            if (clickedRect != null) {
                rectangles.remove(clickedRect); // Удаляем прямоугольник
                repaint(); // Перерисовываем панель
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Простое удаление");
        MouseWheelClickExample panel = new MouseWheelClickExample();
        frame.add(panel);
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

