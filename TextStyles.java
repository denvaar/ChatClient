package ChatClient;

import java.awt.Color;
import javax.swing.text.*;

/*
    TextStyles

    This class is a container for several different styles of text
    to display on the Client window.

*/
final public class TextStyles {

    private final SimpleAttributeSet userText;
    private final SimpleAttributeSet messageText;
    private final SimpleAttributeSet systemText;
    private final SimpleAttributeSet systemErrorText;
    private final SimpleAttributeSet systemMessageText;

    public TextStyles() {

        systemText = new SimpleAttributeSet();
        StyleConstants.setFontFamily(systemText, "Arial");
        StyleConstants.setForeground(systemText, new Color(0x00, 0xC0, 0x00));
        StyleConstants.setItalic(systemText, true);

        systemErrorText = new SimpleAttributeSet();
        StyleConstants.setFontFamily(systemErrorText, "Arial");
        StyleConstants.setForeground(systemErrorText, Color.RED);
        StyleConstants.setItalic(systemErrorText, true);
        
        systemMessageText = new SimpleAttributeSet();
        StyleConstants.setFontFamily(systemMessageText, "Arial");
        StyleConstants.setForeground(systemMessageText, Color.GRAY);
        StyleConstants.setItalic(systemMessageText, true);


        messageText = new SimpleAttributeSet();
        StyleConstants.setFontFamily(messageText, "Arial");
        StyleConstants.setForeground(messageText, Color.BLACK);
        StyleConstants.setItalic(messageText, false);

        userText = new SimpleAttributeSet();
        StyleConstants.setFontFamily(userText, "Arial");
        StyleConstants.setForeground(userText, Color.BLUE);
        StyleConstants.setItalic(userText, true);

    }

    public SimpleAttributeSet systemTextStyle() { return this.systemText; }
    public SimpleAttributeSet systemMessageTextStyle() { return this.systemMessageText; }
    public SimpleAttributeSet systemErrorTextStyle() { return this.systemErrorText; }
    public SimpleAttributeSet userTextStyle() { return this.userText; }
    public SimpleAttributeSet messageTextStyle() { return this.messageText; }

}
