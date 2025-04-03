import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class CustomCursorExample extends JFrame implements MouseListener, MouseMotionListener {

    // Создаем новый курсор
    private Cursor customCursor;

    public CustomCursorExample() {
        setTitle("Простой курсор");

        setSize(400, 300);

        // Закрываем приложение при закрытии окна
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Добавляем слушатели событий мыши
        addMouseListener(this);
        addMouseMotionListener(this);

        // Создаем курсор из изображения
        Image cursorImage = Toolkit.getDefaultToolkit().getImage("C:\\Users\\tanymet\\IdeaProjects\\Mouse\\src\\Cursor.png");
        customCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImage, new Point(0, 0), "Custom Cursor");

        setCursor(customCursor);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // Обработка клика мыши
        System.out.println("Mouse clicked at: " + e.getX() + ", " + e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Обработка нажатия кнопки мыши
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Обработка отпускания кнопки мыши
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // Обработка входа мыши в область окна
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Обработка выхода мыши из области окна
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // Обработка перетаскивания мыши
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // Обработка движения мыши
    }

    public static void main(String[] args) {
        // Запуск программы в потоке событий
        SwingUtilities.invokeLater(() -> {
            CustomCursorExample example = new CustomCursorExample();
            example.setVisible(true);
        });
    }
}

