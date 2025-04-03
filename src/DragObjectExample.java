import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DragObjectExample extends JPanel implements MouseListener, MouseMotionListener {
    private int objectX = 100;
    private int objectY = 100;
    private boolean dragging = false;
    private int mouseXOffset, mouseYOffset; // смещение курсора мыши относительно объекта

    public DragObjectExample() {
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillRect(objectX, objectY, 50, 50); // рисуем квадрат
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Проверяем, попадает ли курсор в область объекта
        if (e.getButton() == MouseEvent.BUTTON3) { // правая кнопка мыши
            if (e.getX() >= objectX && e.getX() <= objectX + 50 &&
                    e.getY() >= objectY && e.getY() <= objectY + 50) {
                dragging = true;
                mouseXOffset = e.getX() - objectX; // вычисляем смещение
                mouseYOffset = e.getY() - objectY;
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Окончание перетаскивания
        if (e.getButton() == MouseEvent.BUTTON3) {
            dragging = false;
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // Перемещение объекта при перетаскивании
        if (dragging) {
            objectX = e.getX() - mouseXOffset; // обновляем позицию объекта
            objectY = e.getY() - mouseYOffset;
            repaint(); // перерисовываем панель
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
    @Override
    public void mouseMoved(MouseEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Простое перемещение объекта");
        DragObjectExample panel = new DragObjectExample();
        frame.add(panel);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
