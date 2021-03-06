package a3.systemC.core;

import a3.monitor.MessageWindow;
import a3.monitor.MonitorUI;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

/**
 * Replica of {@link MessageWindow}
 *
 * @author Weinan Qiu
 * @since 1.0.0
 */
public class HeartBeatConsole extends JFrame implements MonitorUI {

    private JTextArea MessageArea;

    @Override
    public void displayUI() {
        this.setVisible(true);
    }

    public HeartBeatConsole(String title, int x, int y, int w, int h) {
        super(title);
        JPanel MessagePanel = new JPanel();

        this.getContentPane().setBackground( Color.blue );
        this.setBounds(x, y, w, h);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		MessageArea = new JTextArea((h/20),(w/12));
        MessageArea.setLineWrap(true);

        JScrollPane MessageAreaScrollPane = new JScrollPane(MessageArea);

        this.add(MessagePanel);
        MessagePanel.add(MessageAreaScrollPane);

        this.setVisible(true);
    }

    public void writeMessage( String message ) {
        Calendar TimeStamp = Calendar.getInstance();
        SimpleDateFormat TimeStampFormat = new SimpleDateFormat("yyyy MM dd::hh:mm:ss:SSS");
        String TimeString = TimeStampFormat.format(TimeStamp.getTime());
        MessageArea.append( TimeString + ":: " + message + "\n");
        MessageArea.setCaretPosition( MessageArea.getDocument().getLength() );

    }
}
