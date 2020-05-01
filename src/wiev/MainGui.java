package wiev;

import model.IWeight;
import store.ProductStore;
import store.WoodDirectory;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainGui {
    public JFrame frame;
    private JList list1;
    private JTextArea textArea1;
    private JPanel MainPanel;
    private JScrollPane scrollArea1;

    private WoodDirectory wd = new WoodDirectory();
    private ProductStore ps = new ProductStore();
    private DlgTimber dlgTimber = new DlgTimber();
    private DlgCilinder dlgCilinder = new DlgCilinder();
    private DlgWaste dlgWaste = new DlgWaste();
    private DlgWood dlgWood = new DlgWood();


    /**
     * Create the application
     */
    public MainGui() {
        initialize();
    }

    /**
     * Initilize the contens of the frame
     */
    private void initialize() {

        frame = new JFrame();
        frame.setBounds(200, 200, 600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Lab4 OOP");
        frame.setContentPane(MainPanel);
        //frame.setLocationRelativeTo(textArea1);
        //frame.setSize(600,300);


        //list1 = new JList<>();
        DefaultListModel<IWoodDialog> model = new DefaultListModel<>();
        model.addElement(dlgTimber);
        model.addElement(dlgCilinder);
        model.addElement(dlgWaste);
        model.addElement(dlgWood);
        list1.setModel(model);

        list1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                IWoodDialog dlg = (IWoodDialog) list1.getSelectedValue();
                dlg.setWoodDirectory(wd);
                dlg.setVisible(true);
                Object obj = dlg.getObject();
                if (obj != null) {
                    ps.add((IWeight) obj);
                }
                textArea1.setText(ps.toString());
            }
        });
    }
}
