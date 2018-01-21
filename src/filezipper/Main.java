package filezipper;

    import javax.swing.*;
    import java.awt.*;
    import java.awt.event.*;


public class Main extends JFrame 
{
    private JButton bAdd;
    private JButton bRemove;
    private JButton bZip;
    
    private JList listaPlikow = new JList(new String[] {"Emil","Paulina","Karolina","Jagoda","Janusz"});
    
    private JMenuBar mainMenuBar = new JMenuBar();

    
    public Main()
    {
        this.setTitle("FileZipper");
        this.setBounds(300,300,300,300);
            
        Action akcjaDodawania = new Akcja("Dodaj", "Dodaj nowy wpis do archiwum", "ctrl D", new ImageIcon("dodaj.png"));
        Action akcjaUsuwania = new Akcja("Usuń", "Usuń zaznaczone wpisy z archiwum", "ctrl U", new ImageIcon("usun.png"));
        Action akcjaZipowania = new Akcja("Zip", "Archiwizuj zaznaczone wpisy", "ctrl Z");
        
        bAdd = new JButton(akcjaDodawania);
        bRemove = new JButton(akcjaUsuwania);
        bZip = new JButton(akcjaZipowania);
        
        this.setJMenuBar(mainMenuBar);
        JMenu menuPlik = mainMenuBar.add(new JMenu("Plik"));
        
        JMenuItem menuOtworz = menuPlik.add(akcjaDodawania);
        JMenuItem menuUsun = menuPlik.add(akcjaUsuwania);
        JMenuItem menuZip = menuPlik.add(akcjaZipowania);
        
        listaPlikow.setBorder(BorderFactory.createEtchedBorder());
        
        GroupLayout layout = new GroupLayout(this.getContentPane());
        layout.setAutoCreateContainerGaps(true);
        layout.setAutoCreateGaps(true);
        
            layout.setHorizontalGroup(
                    layout.createSequentialGroup()
                    .addComponent(listaPlikow,100,150, Short.MAX_VALUE)
                    .addContainerGap(10, Short.MAX_VALUE)
                    .addGroup(
                    layout.createParallelGroup()
                            .addComponent(bAdd)
                            .addComponent(bRemove)
                            .addComponent(bZip)
                    )
            );
            
            layout.setVerticalGroup(
                    layout.createParallelGroup()
                        .addComponent(listaPlikow, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(
                        layout.createSequentialGroup()
                                .addComponent(bAdd)
                                .addComponent(bRemove)
                                .addGap(10, 40, Short.MAX_VALUE)
                                .addComponent(bZip)
                        )
            );
        
        this.getContentPane().setLayout(layout);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
    }
    
    
    private class Akcja extends AbstractAction
    {
        public Akcja (String nazwa, String opis, String klawiaturowySkrot)
        {
            this.putValue(Action.NAME, nazwa);
            this.putValue(Action.SHORT_DESCRIPTION, opis);
            this.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(klawiaturowySkrot));
          
        }
        
        public Akcja (String nazwa, String opis, String klawiaturowySkrot, Icon ikona)
        {
            this(nazwa, opis, klawiaturowySkrot);
            this.putValue(Action.SMALL_ICON, ikona);
        }

        @Override
        public void actionPerformed(ActionEvent e) 
        {
            if (e.getActionCommand().equals("Dodaj"))
                System.out.println("Dodawanie");
            else if (e.getActionCommand().equals("Usuń"))
                System.out.println("Usuwanie");
            else if (e.getActionCommand().equals("Zip"))
                System.out.println("Archiwizacja");
        }
        
    }

    
    public static void main(String[] args) 
    {
        new Main().setVisible(true);

    }
    
}
