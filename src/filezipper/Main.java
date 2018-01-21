package filezipper;

    import javax.swing.*;
    import java.awt.*;
    import java.awt.event.*;


public class Main extends JFrame 
{
    private JButton bAdd;
    private JButton bRemove;
    private JButton bZip;
    
    JPanel mainPanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    private JList listaPlikow = new JList();
    
    private JMenuBar mainMenuBar = new JMenuBar();

    
    public Main()
    {
        this.setTitle("FileZipper");
        this.setBounds(300,300,300,300);
        this.getContentPane().add(mainMenuBar);
        this.getContentPane().add(mainPanel);
        
        Action akcjaDodawania = new Akcja("Dodaj") {};
        Action akcjaUsuwania = new Akcja("Usun") {};
        Action akcjaZipowania = new Akcja("Zip") {};
        
        bAdd = new JButton(akcjaDodawania);
        bRemove = new JButton(akcjaUsuwania);
        bZip = new JButton(akcjaZipowania);
        
        this.setJMenuBar(mainMenuBar);
        JMenu menuPlik = mainMenuBar.add(new JMenu("Plik"));
        
        JMenuItem menuOtworz = menuPlik.add(akcjaDodawania);
        JMenuItem menuUsun = menuPlik.add(akcjaUsuwania);
        JMenuItem menuZip = menuPlik.add(akcjaZipowania);
        
        GroupLayout layout = new GroupLayout(this.getContentPane());
        layout.setAutoCreateContainerGaps(true);
        layout.setAutoCreateGaps(true);
        
            layout.setHorizontalGroup(
                    layout.createSequentialGroup()
                    .addComponent(listaPlikow)
                    .addGroup(
                    layout.createParallelGroup().addComponent(bAdd).addComponent(bRemove).addComponent(bZip)
                    )
            );
            
            layout.setVerticalGroup(
                    layout.createParallelGroup()
                        .addComponent(listaPlikow)
                        .addGroup(
                        layout.createParallelGroup().addComponent(bAdd).addComponent(bRemove).addComponent(bZip)
                        )
            );
        
        this.getContentPane().setLayout(layout);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
    }
    
    
    private class Akcja extends AbstractAction
    {
        public Akcja (String nazwa)
        {
            this.putValue(Action.NAME, nazwa);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
        
    }
    
    
    
    public static void main(String[] args) 
    {
        new Main().setVisible(true);

    }
    
}
