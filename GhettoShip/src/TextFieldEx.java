/**
 * Created by 072909328 on 6/9/2015.
 */
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TextFieldEx extends JPanel
{  // Instantiate a textfield for input and a textarea for output.
    private JTextField input = new JTextField();
    //private JTextArea output = new JTextArea(5, 15);

    public TextFieldEx()
    {  // Register a listener with the textfield
        TextFieldListener tfListener = new TextFieldListener();
        input.addActionListener(tfListener);
        // Don't let the user change the output.
        input.setEditable(true);
        // Add all the widgets to the applet
    }

    // The listener for the textfield.
    private class TextFieldListener implements ActionListener
    {  public void actionPerformed(ActionEvent evt)
    {  String inputString = input.getText();
        //output.append(inputString + "\n");
        input.setText("");
    }
    }
}
