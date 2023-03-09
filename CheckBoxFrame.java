import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class CheckBoxFrame extends JFrame
{
    private JTextField textField;
    private JCheckBox boldJCheckBox;
    private JCheckBox italicCheckBox;
    
    public CheckBoxFrame()
    {
        super("JCheackBox Test");
        setLayout(new FlowLayout() );
        
        textField = new JTextField("Watch the font style change",20);
        
        textField.setFont(new Font("Serif", Font.PLAIN,14) );
        add(textField);
        
        boldJCheckBox = new JCheckBox("bold");
        italicCheckBox = new JCheckBox("Italic");
        add(boldJCheckBox);
        add(italicCheckBox);
        
        CheckBoxHandler handler =new CheckBoxHandler();
        boldJCheckBox.addItemListener(handler);
        italicCheckBox.addItemListener(handler);
    }
    
    private class CheckBoxHandler implements ItemListener
    {

        @Override
        public void itemStateChanged(ItemEvent e) {
            Font font = null;
            
            if (boldJCheckBox.isSelected() && italicCheckBox.isSelected() )
                font = new Font("Serif", Font.BOLD + Font.ITALIC, 14);
            else if (boldJCheckBox.isSelected() )
                font = new Font("Serif",Font.BOLD, 14);
            else if (italicCheckBox.isSelected() )
                font = new Font("Serif", Font.ITALIC,14);
            else
                font = new Font ("Serif", Font.PLAIN,14);
            
            textField.setFont(font);
        }
    }
}