package javax.swing;

// @author GabrielOmr

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class ImagePanel extends JPanel{
    private BufferedImage image;
    private byte[] imageByte;
    
    public ImagePanel(){
        Dimension dimension = new Dimension(80, 75);
        this.setPreferredSize(dimension);
        this.setMaximumSize(dimension);
        this.setMinimumSize(dimension);
        this.setSize(dimension);
        this.setOpaque(false);
        this.addMouseListener(mouseAdapter);
        this.setBackground(Color.red);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        if(image != null){ g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this); }
        else{ 
            try {
                String windowsPath="C:\\Users\\GabrielOmr\\Dropbox\\Projects\\NetBeans\\Desktop_Management\\resources\\images\\default_logo.jpg";
                String linuxPath="";
                this.image = ImageIO.read(new File(windowsPath));
                g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
            } catch (IOException ex) { Logger.getLogger(ImagePanel.class.getName()).log(Level.SEVERE, null, ex); }
        }
    }

    public byte[] getImageByte() { return imageByte; }

    public void setImage(byte[] image) throws IOException {
        ByteArrayInputStream bais = new ByteArrayInputStream(image);
        this.image=ImageIO.read(bais);
        repaint();
    }

    @Override
    public void repaint(){ super.repaint(); }
    
    private final MouseAdapter mouseAdapter= new MouseAdapter() {
        @Override
        public void mouseDragged(MouseEvent e) {
            super.mouseDragged(e);
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.showOpenDialog(e.getComponent());
                fileChooser.getSelectedFile();
                image = ImageIO.read(fileChooser.getSelectedFile());
                repaint();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ImageIO.write( image, "jpg", baos );
                baos.flush();
                imageByte = baos.toByteArray();
                baos.close();
            } catch (IOException ex) { Logger.getLogger(ImagePanel.class.getName()).log(Level.SEVERE, null, ex); }
        }
        
    };
}
