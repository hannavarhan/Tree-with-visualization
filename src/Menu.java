import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.util.ArrayList;

public class Menu extends JFrame {

    BinaryTree<Integer> tree = new BinaryTree<>();
    BinaryTree<Animal> treeA = new BinaryTree<>();

    final private JLabel inscN = new JLabel("Number tree");
    JButton addN = new JButton("Insert into Number tree");
    JButton deleteN = new JButton("Delete from Number tree");
    JButton nlrN = new JButton("Root-Left-Rigth traversal");
    JButton lrnN = new JButton("Left-Right-Root traversal");
    JButton lnrN = new JButton("Left-Root-Right traversal");
    JButton findN = new JButton("Find element");
    JButton vN = new JButton("8");
    JTextArea enterElN = new JTextArea("Enter number element");
    JButton showN = new JButton("Show Number tree");

    final private JLabel inscA = new JLabel("Animal tree");
    JButton addA = new JButton("Insert into Animal tree");
    JButton deleteA = new JButton("Delete from Animal tree");
    JButton nlrA = new JButton("Root-Left-Rigth traversal");
    JButton lrnA = new JButton("Left-Right-Root traversal");
    JButton lnrA = new JButton("Left-Root-Right traversal");
    JButton findA = new JButton("Find element");
    JButton vA = new JButton("8");
    JTextArea enterElA = new JTextArea("Enter Animal");
    JButton showA = new JButton("Show Animal tree");

    JLabel label = new JLabel("");

    private JDialog createDialog(String t, int width, int height) {
        JDialog dialog = new JDialog(this, t, false);
        dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        dialog.setSize(width, height);
        return dialog;
    }

    Menu() {
        super("Work with treetreetreetreetreetreetreetreetreetreetreetreetreetreetreetreetreetree");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container container = getContentPane();

        JPanel north = new JPanel();
        north.setLayout(new FlowLayout());
        north.add(addN);
        north.add(deleteN);
        north.add(addA);
        north.add(deleteA);

        JPanel west = new JPanel();
        west.setLayout(new GridLayout(6, 1));
        west.add(inscN);
        west.add(nlrN);
        west.add(lrnN);
        west.add(lnrN);
        west.add(vN);
        west.add(findN);

        JPanel east = new JPanel();
        east.setLayout(new GridLayout(6, 1));
        east.add(inscA);
        east.add(nlrA);
        east.add(lrnA);
        east.add(lnrA);
        east.add(vA);
        east.add(findA);

        JPanel center = new JPanel();
        center.setLayout(new GridLayout(4, 2));
        center.add(new JLabel(""));
        center.add(new JLabel(""));
        center.add(enterElN);
        center.add(enterElA);
        center.add(label);

        JPanel south = new JPanel();
        south.setLayout(new FlowLayout());
        south.add(showN);
        south.add(showA);

        container.add(north, BorderLayout.NORTH);
        container.add(west, BorderLayout.WEST);
        container.add(east, BorderLayout.EAST);
        container.add(center, BorderLayout.CENTER);
        container.add(south, BorderLayout.SOUTH);

        addN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    label.setText("");
                    int info = Integer.parseInt(enterElN.getText());
                    tree.add(info);
                } catch(NumberFormatException ex) {
                    label.setText("ILLEGAL VALUE!");
                }
            }
        });

        addA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    label.setText("");
                    String info = enterElA.getText();
                    info.trim();
                    ArrayList<String> temp = new ArrayList<>();
                    for(String el : info.split(" ")) {
                        temp.add(el);
                    }
                    Animal a;
                    if (temp.size() == 1) {
                        a = new Animal(temp.get(0));
                    } else if (temp.size() == 2) {
                        a = new Animal(temp.get(0), Integer.parseInt(temp.get(1)));
                    } else {
                        throw new IllegalArgumentException("ILLEGAL VALUE!");
                    }
                    treeA.add(a);
                } catch(IllegalArgumentException ex) {
                    label.setText(ex.getMessage());
                }
            }
        });

        deleteN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    label.setText("");
                    int info = Integer.parseInt(enterElN.getText());
                    tree.delete(info);
                } catch(NumberFormatException ex) {
                    label.setText("ILLEGAL VALUE!");
                } catch(NullPointerException ex) {
                    label.setText(ex.getMessage());
                }
            }
        });

        deleteA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    label.setText("");
                    String info = enterElA.getText();
                    info.trim();
                    ArrayList<String> temp = new ArrayList<>();
                    for(String el : info.split(" ")) {
                        temp.add(el);
                    }
                    Animal a;
                    if (temp.size() == 2) {
                        a = new Animal(temp.get(0), Integer.parseInt(temp.get(1)));
                    } else {
                        throw new IllegalArgumentException("ILLEGAL VALUE!");
                    }
                    treeA.delete(a);
                } catch(Exception ex) {
                    label.setText(ex.getMessage());
                }
            }
        });

        nlrN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    label.setText("");
                    ArrayList<Integer> list = tree.printNLR();
                    JTextArea text = new JTextArea();
                    for(Integer el : list) {
                        text.append(el.toString() + "\n");
                    }
                    JDialog dialog = createDialog("Root-Left-Right traversal", 300, 500);
                    dialog.setVisible(true);
                    dialog.add(text);
                } catch (Exception ex) {
                    label.setText(ex.getMessage());
                }
            }
        });

        nlrA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    label.setText("");
                    ArrayList<Animal> list = treeA.printNLR();
                    JTextArea text = new JTextArea();
                    for(Animal el : list) {
                        text.append(el.toString() + "\n");
                    }
                    JDialog dialog = createDialog("Root-Left-Right traversal", 300, 500);
                    dialog.setVisible(true);
                    dialog.add(text);
                } catch (Exception ex) {
                    label.setText(ex.getMessage());
                }
            }
        });

        lnrN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    label.setText("");
                    ArrayList<Integer> list = tree.printLNR();
                    JTextArea text = new JTextArea();
                    for(Integer el : list) {
                        text.append(el.toString() + "\n");
                    }
                    JDialog dialog = createDialog("Left-Root-Right traversal", 300, 500);
                    dialog.setVisible(true);
                    dialog.add(text);
                } catch (Exception ex) {
                    label.setText(ex.getMessage());
                }
            }
        });

        lnrA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    label.setText("");
                    ArrayList<Animal> list = treeA.printLNR();
                    JTextArea text = new JTextArea();
                    for(Animal el : list) {
                        text.append(el.toString() + "\n");
                    }
                    JDialog dialog = createDialog("Left-Root-Right traversal", 300, 500);
                    dialog.setVisible(true);
                    dialog.add(text);
                } catch (Exception ex) {
                    label.setText(ex.getMessage());
                }
            }
        });

        lrnN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    label.setText("");
                    ArrayList<Integer> list = tree.printLRN();
                    JTextArea text = new JTextArea();
                    for(Integer el : list) {
                        text.append(el.toString() + "\n");
                    }
                    JDialog dialog = createDialog("Left-Right-Root traversal", 300, 500);
                    dialog.setVisible(true);
                    dialog.add(text);
                } catch (Exception ex) {
                    label.setText(ex.getMessage());
                }
            }
        });

        lrnA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    label.setText("");
                    ArrayList<Animal> list = treeA.printLRN();
                    JTextArea text = new JTextArea();
                    for(Animal el : list) {
                        text.append(el.toString() + "\n");
                    }
                    JDialog dialog = createDialog("Left-Right-Root traversal", 300, 500);
                    dialog.setVisible(true);
                    dialog.add(text);
                } catch (Exception ex) {
                    label.setText(ex.getMessage());
                }
            }
        });

        findN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int info = Integer.parseInt(enterElN.getText());
                    boolean res = tree.containsValue(info);
                    if(res) {
                        label.setText("There is such an element");
                    } else label.setText("There is no such an element");

                } catch(NumberFormatException ex) {
                    label.setText("ILLEGAL VALUE!");
                } catch(NullPointerException ex) {
                    label.setText(ex.getMessage());
                }
            }
        });

        findA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String info = enterElA.getText();
                    info.trim();
                    ArrayList<String> temp = new ArrayList<>();
                    for(String el : info.split(" ")) {
                        temp.add(el);
                    }
                    Animal a;
                    if (temp.size() == 2) {
                        a = new Animal(temp.get(0), Integer.parseInt(temp.get(1)));
                    } else {
                        throw new IllegalArgumentException("ILLEGAL VALUE!");
                    }
                    boolean res = treeA.containsValue(a);
                    if(res) {
                        label.setText("There is such an element");
                    } else label.setText("There is no such an element");
                } catch(Exception ex) {
                    label.setText(ex.getMessage());
                }
            }
        });

        vN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    label.setText(tree.maxInsideTop().toString());
                } catch(Exception ex) {
                    label.setText(ex.getMessage());
                }
            }
        });

        vA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    label.setText(treeA.maxInsideTop().toString());
                } catch(Exception ex) {
                    label.setText(ex.getMessage());
                }
            }
        });

        showN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DisplayTree d = new DisplayTree();
                JDialog dialog = createDialog("Number treetreetree", 1400, 900);
                JPanel pane = new JPanel() {
                    Graphics2D g2;
                    protected void paintComponent(Graphics g) {
                        super.paintComponent(g);
                        g2 = (Graphics2D)g;
                        try {
                            d.displayTree(g2, tree.getRoot(), 700, 75, 200);
                        }catch (NullPointerException ex) {
                            label.setText(ex.getMessage());
                        }
                    }
                };
                dialog.setContentPane(pane);
                dialog.setVisible(true);
            }
        });

        showA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DisplayTree d = new DisplayTree();
                    JPanel pane = new JPanel() {
                        Graphics2D g2;

                        protected void paintComponent(Graphics g) {
                            super.paintComponent(g);
                            g2 = (Graphics2D) g;
                            try {
                                d.displayTree(g, treeA.getRoot(), 700, 75, 200);
                            } catch (NullPointerException ex) {
                                label.setText(ex.getMessage());
                            }
                        }
                    };
                    JDialog dialog = createDialog("Animal treetreetree", 1400, 900);
                    dialog.setContentPane(pane);
                    dialog.setVisible(true);
            }
        });

        setSize(700, 300);
        setVisible(true);
    }
}