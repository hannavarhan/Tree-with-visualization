import javax.swing.*;
import java.awt.*;

public class DisplayTree<T> extends JFrame {
    BinaryTree<Integer> t = new BinaryTree<>();
    final int RADIUS = 50;
    final int YGAP = 60;

    public void displayTree(Graphics g, Node<T> root, int x, int y, int hGap) {
        if(root == null) {
            throw new NullPointerException("TREE IS EMPTY!");
        }
        g.drawOval(x - RADIUS, y - RADIUS, 2 * RADIUS, 2 * RADIUS);
        if (root != null){
            g.drawString(root.data.toString(), x - 15, y + 4);
        }
        if(root.left != null) {
            g.setColor(Color.BLACK);
            leftBranch(g, x, y, x - (hGap + 40), y + 50 + YGAP);
            displayTree(g, root.left, x - (hGap + 100), y + 150, hGap - 95);
        }
        if(root.right != null) {
            g.setColor(Color.BLACK);
            rightBranch(g, x, y, x + hGap + 40, y + 50 + YGAP);
            displayTree(g, root.right, x + (hGap + 100), y + 150, hGap - 95);
        }
    }

    private void leftBranch(Graphics g, int x1, int y1, int x2, int y2) {
        int x11 = (int)(x1 - 25 * Math.sqrt(2));
        int y11 = (int)(y1 + 25 * Math.sqrt(2));
        int x21 = (int)(x2 - RADIUS + 25 * Math.sqrt(2));
        int y21 = (int)(y2 + RADIUS - 25 * Math.sqrt(2));
        g.drawLine(x11, y11, x21, y21);
    }

    private void rightBranch(Graphics g, int x1, int y1, int x2, int y2) {
        int x11 = (int)(x1 + 25 * Math.sqrt(2));
        int y11 = (int)(y1 + 25 * Math.sqrt(2));
        int x21 = (int)(x2 + RADIUS - 25 * Math.sqrt(2));
        int y21 = (int)(y2 + RADIUS - 25 * Math.sqrt(2));
        g.drawLine(x11, y11, x21, y21);
    }
}