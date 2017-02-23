import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.Console;

/**
 * Created by michael on 10/8/14.
 */
public class GUI extends JFrame implements ItemListener, ActionListener, KeyListener {
    private final int BUTTONSIZE = 100;
    private final int TOPDIST = 5 * BUTTONSIZE;
    private final int WIDTH = 7 * BUTTONSIZE + TOPDIST, LENGTH = 17 * BUTTONSIZE;
    private final int FONTSIZE = 14;

    private JButton tildaButton, oneButton, twoButton, threeButton, fourButton, fiveButon, sixButton, sevenButton, eightButton, nineButton, zeroButton, hyphenButton, equalsButton, deleteButton;
    private JButton tabButton, qButton, wButton, eButton, rButton, tButton, yButton, uButton, iButton, oButton, pButton, lBracket, rBracket, backSlash;
    private JButton capsButton, aButton, sButton, dButton, fButton, gButton, hButton, jButton, kButton, lButton, colonButton, aposterphieButton, returnButton;
    private JButton lShift, zButton, xButton, cButton, vButton, bButton, nButton, mButton, commaButton, periodButton, forwardSlash, rShift;
    private JButton lControl, lWindows, lAlt, spaceBar, rAlt, rWindows, rControl, testButton;
    private JTextField typingArea;
    private JButton unusedButton;

    private JMenuBar menuBar;
    private JMenu file, help;
    private JMenuItem restart, about;

        public GUI(){
            super();
            this.setLayout(null);

            int mediumButttonSize = (7 * BUTTONSIZE) / 4;

            //menu bar
            menuBar = new JMenuBar();
            file = new JMenu("File");
            help = new JMenu("Help");
        restart = new JMenuItem("Start Over");
        about = new JMenuItem("About");

        menuBar.add(file);
        menuBar.add(help);
        file.add(about);
        help.add(restart);
        menuBar.setSize(LENGTH, 20);


        typingArea = new JTextField("");
        typingArea.setEditable(false);
            typingArea.setFont(new Font(typingArea.getFont().getName(), typingArea.getFont().getStyle(), typingArea.getFont().getSize() + 10));

        tildaButton = new JButton("`");
        oneButton = new JButton("1");
        twoButton = new JButton("2");
        threeButton = new JButton("3");
        fourButton = new JButton("4");
        fiveButon = new JButton("5");
        sixButton = new JButton("6");
        sevenButton = new JButton("7");
        eightButton = new JButton("8");
        nineButton = new JButton("9");
        zeroButton = new JButton("0");
        hyphenButton = new JButton("-");
        equalsButton = new JButton("=");
        deleteButton = new JButton("delete");

        tabButton = new JButton("tab");
        qButton = new JButton("Q");
        wButton = new JButton("W");
        wButton.setFont(new Font(wButton.getFont().getName(), Font.PLAIN, FONTSIZE));
        eButton = new JButton("E");
        rButton = new JButton("R");
        tButton = new JButton("T");
        yButton = new JButton("Y");
        uButton = new JButton("U");
        iButton = new JButton("I");
        oButton = new JButton("O");
        pButton = new JButton("P");
        lBracket = new JButton("[");
        rBracket = new JButton("]");
        backSlash = new JButton("\\");
        capsButton = new JButton("caps lock");
        aButton = new JButton("A");
        sButton = new JButton("S");
        dButton = new JButton("D");
        fButton = new JButton("F");
        gButton = new JButton("G");
        hButton = new JButton("H");
        jButton = new JButton("J");
        kButton = new JButton("K");
        lButton = new JButton("L");
        colonButton = new JButton(";");
        aposterphieButton = new JButton("'");
        returnButton = new JButton("return");
        lShift = new JButton("shift");
        zButton = new JButton("Z");
        xButton = new JButton("X");
        cButton = new JButton("C");
        vButton = new JButton("V");
        bButton = new JButton("B");
        nButton = new JButton("N");
        mButton = new JButton("M");
        commaButton = new JButton(",");
        periodButton = new JButton(".");
        forwardSlash = new JButton("/");
        rShift = new JButton("shift");

        lControl = new JButton("control");
        lWindows = new JButton("");
        lAlt = new JButton("alt");
        spaceBar = new JButton("");
        rAlt = new JButton("alt");
        rWindows = new JButton("");
        rControl = new JButton("control");
        testButton = new JButton("");

        unusedButton = new JButton("unused");

        this.setFocusable(false);
        typingArea.setSize(LENGTH - 2 * BUTTONSIZE, TOPDIST - 2 * BUTTONSIZE);
        typingArea.setLocation(BUTTONSIZE, BUTTONSIZE);
        typingArea.addKeyListener(this);

        //top line
        tildaButton.setSize(BUTTONSIZE, BUTTONSIZE);
        tildaButton.setLocation(BUTTONSIZE, TOPDIST);
        tildaButton.setFocusable(false);
        oneButton.setSize(BUTTONSIZE, BUTTONSIZE);
        oneButton.setLocation(2 * BUTTONSIZE, TOPDIST);
        oneButton.setFocusable(false);
        twoButton.setSize(BUTTONSIZE, BUTTONSIZE);
        twoButton.setLocation(3 * BUTTONSIZE, TOPDIST);
        twoButton.setFocusable(false);
        threeButton.setSize(BUTTONSIZE, BUTTONSIZE);
        threeButton.setLocation(4 * BUTTONSIZE, TOPDIST);
        threeButton.setFocusable(false);
        fourButton.setSize(BUTTONSIZE, BUTTONSIZE);
        fourButton.setLocation(5 * BUTTONSIZE, TOPDIST);
        fourButton.setFocusable(false);
        fiveButon.setSize(BUTTONSIZE, BUTTONSIZE);
        fiveButon.setLocation(6 * BUTTONSIZE, TOPDIST);
        fiveButon.setFocusable(false);
        sixButton.setSize(BUTTONSIZE, BUTTONSIZE);
        sixButton.setLocation(7 * BUTTONSIZE, TOPDIST);
        sixButton.setFocusable(false);
        sevenButton.setSize(BUTTONSIZE, BUTTONSIZE);
        sevenButton.setLocation(8 * BUTTONSIZE, TOPDIST);
        sevenButton.setFocusable(false);
        eightButton.setSize(BUTTONSIZE, BUTTONSIZE);
        eightButton.setLocation(9 * BUTTONSIZE, TOPDIST);
        eightButton.setFocusable(false);
        nineButton.setSize(BUTTONSIZE, BUTTONSIZE);
        nineButton.setLocation(10 * BUTTONSIZE, TOPDIST);
        nineButton.setFocusable(false);
        zeroButton.setSize(BUTTONSIZE, BUTTONSIZE);
        zeroButton.setLocation(11 * BUTTONSIZE, TOPDIST);
        zeroButton.setFocusable(false);
        hyphenButton.setSize(BUTTONSIZE, BUTTONSIZE);
        hyphenButton.setLocation(12 * BUTTONSIZE, TOPDIST);
        hyphenButton.setFocusable(false);
        equalsButton.setSize(BUTTONSIZE, BUTTONSIZE);
        equalsButton.setLocation(13 * BUTTONSIZE, TOPDIST);
        equalsButton.setFocusable(false);

        deleteButton.setSize(mediumButttonSize, BUTTONSIZE);
        deleteButton.setLocation(14 * BUTTONSIZE, TOPDIST);

        //first line
        tabButton.setSize(mediumButttonSize, BUTTONSIZE);
        tabButton.setLocation(BUTTONSIZE, TOPDIST + BUTTONSIZE);
        qButton.setSize(BUTTONSIZE, BUTTONSIZE);
        qButton.setLocation(mediumButttonSize + BUTTONSIZE, TOPDIST + BUTTONSIZE);
        wButton.setSize(BUTTONSIZE, BUTTONSIZE);
        wButton.setLocation(mediumButttonSize + (2 * BUTTONSIZE), TOPDIST + BUTTONSIZE);
        eButton.setSize(BUTTONSIZE, BUTTONSIZE);
        eButton.setLocation(mediumButttonSize + (3 * BUTTONSIZE), TOPDIST + BUTTONSIZE);
        rButton.setSize(BUTTONSIZE, BUTTONSIZE);
        rButton.setLocation(mediumButttonSize + (4 * BUTTONSIZE), TOPDIST + BUTTONSIZE);
        tButton.setSize(BUTTONSIZE, BUTTONSIZE);
        tButton.setLocation(mediumButttonSize + (5 * BUTTONSIZE), TOPDIST + BUTTONSIZE);
        yButton.setSize(BUTTONSIZE, BUTTONSIZE);
        yButton.setLocation(mediumButttonSize + (6 * BUTTONSIZE), TOPDIST + BUTTONSIZE);
        uButton.setSize(BUTTONSIZE, BUTTONSIZE);
        uButton.setLocation(mediumButttonSize + (7 * BUTTONSIZE), TOPDIST + BUTTONSIZE);
        iButton.setSize(BUTTONSIZE, BUTTONSIZE);
        iButton.setLocation(mediumButttonSize + (8 * BUTTONSIZE), TOPDIST + BUTTONSIZE);
        oButton.setSize(BUTTONSIZE, BUTTONSIZE);
        oButton.setLocation(mediumButttonSize + (9 * BUTTONSIZE), TOPDIST + BUTTONSIZE);
        pButton.setSize(BUTTONSIZE, BUTTONSIZE);
        pButton.setLocation(mediumButttonSize + (10 * BUTTONSIZE), TOPDIST + BUTTONSIZE);
        lBracket.setSize(BUTTONSIZE, BUTTONSIZE);
        lBracket.setLocation(mediumButttonSize + (11 * BUTTONSIZE), TOPDIST + BUTTONSIZE);
        rBracket.setSize(BUTTONSIZE, BUTTONSIZE);
        rBracket.setLocation(mediumButttonSize + (12 * BUTTONSIZE), TOPDIST + BUTTONSIZE);
        backSlash.setSize(BUTTONSIZE, BUTTONSIZE);
        backSlash.setLocation(mediumButttonSize + (13 * BUTTONSIZE), TOPDIST + BUTTONSIZE);

        //second line
        capsButton.setSize(2 * BUTTONSIZE, BUTTONSIZE);
        capsButton.setLocation(BUTTONSIZE, 2 * BUTTONSIZE + TOPDIST);
        aButton.setSize(BUTTONSIZE, BUTTONSIZE);
        aButton.setLocation(3 * BUTTONSIZE, 2 * BUTTONSIZE + TOPDIST);
        sButton.setSize(BUTTONSIZE, BUTTONSIZE);
        sButton.setLocation(4 * BUTTONSIZE, 2 * BUTTONSIZE + TOPDIST);
        dButton.setSize(BUTTONSIZE, BUTTONSIZE);
        dButton.setLocation(5 * BUTTONSIZE, 2 * BUTTONSIZE + TOPDIST);
        fButton.setSize(BUTTONSIZE, BUTTONSIZE);
        fButton.setLocation(6 * BUTTONSIZE, 2 * BUTTONSIZE + TOPDIST);
        gButton.setSize(BUTTONSIZE, BUTTONSIZE);
        gButton.setLocation(7 * BUTTONSIZE, 2 * BUTTONSIZE + TOPDIST);
        hButton.setSize(BUTTONSIZE, BUTTONSIZE);
        hButton.setLocation(8 * BUTTONSIZE, 2 * BUTTONSIZE + TOPDIST);
        jButton.setSize(BUTTONSIZE, BUTTONSIZE);
        jButton.setLocation(9 * BUTTONSIZE, 2 * BUTTONSIZE + TOPDIST);
        kButton.setSize(BUTTONSIZE, BUTTONSIZE);
        kButton.setLocation(10 * BUTTONSIZE, 2 * BUTTONSIZE + TOPDIST);
        lButton.setSize(BUTTONSIZE, BUTTONSIZE);
        lButton.setLocation(11 * BUTTONSIZE, 2 * BUTTONSIZE + TOPDIST);
        colonButton.setSize(BUTTONSIZE, BUTTONSIZE);
        colonButton.setLocation(12 * BUTTONSIZE, 2 * BUTTONSIZE + TOPDIST);
        aposterphieButton.setSize(BUTTONSIZE, BUTTONSIZE);
        aposterphieButton.setLocation(13 * BUTTONSIZE, 2 * BUTTONSIZE + TOPDIST);
        returnButton.setSize(mediumButttonSize, BUTTONSIZE);
        returnButton.setLocation(14 * BUTTONSIZE, 2 * BUTTONSIZE + TOPDIST);

        //third line
        int largeButtonSize = (10 * BUTTONSIZE) / 4;
        lShift.setSize(largeButtonSize, BUTTONSIZE);
        lShift.setLocation(BUTTONSIZE, 3 * BUTTONSIZE + TOPDIST);
        zButton.setSize(BUTTONSIZE, BUTTONSIZE);
        zButton.setLocation(largeButtonSize + BUTTONSIZE, 3 * BUTTONSIZE + TOPDIST);
        xButton.setSize(BUTTONSIZE, BUTTONSIZE);
        xButton.setLocation(largeButtonSize + 2 * BUTTONSIZE, 3 * BUTTONSIZE + TOPDIST);
        cButton.setSize(BUTTONSIZE, BUTTONSIZE);
        cButton.setLocation(largeButtonSize + 3 * BUTTONSIZE, 3 * BUTTONSIZE + TOPDIST);
        vButton.setSize(BUTTONSIZE, BUTTONSIZE);
        vButton.setLocation(largeButtonSize + 4 * BUTTONSIZE, 3 * BUTTONSIZE + TOPDIST);
        bButton.setSize(BUTTONSIZE, BUTTONSIZE);
        bButton.setLocation(largeButtonSize + 5 * BUTTONSIZE, 3 * BUTTONSIZE + TOPDIST);
        nButton.setSize(BUTTONSIZE, BUTTONSIZE);
        nButton.setLocation(largeButtonSize + 6 * BUTTONSIZE, 3 * BUTTONSIZE + TOPDIST);
        mButton.setSize(BUTTONSIZE, BUTTONSIZE);
        mButton.setLocation(largeButtonSize + 7 * BUTTONSIZE, 3 * BUTTONSIZE + TOPDIST);
        commaButton.setSize(BUTTONSIZE, BUTTONSIZE);
        commaButton.setLocation(largeButtonSize + 8 * BUTTONSIZE, 3 * BUTTONSIZE + TOPDIST);
        periodButton.setSize(BUTTONSIZE, BUTTONSIZE);
        periodButton.setLocation(largeButtonSize + 9 * BUTTONSIZE, 3 * BUTTONSIZE + TOPDIST);
        forwardSlash.setSize(BUTTONSIZE, BUTTONSIZE);
        forwardSlash.setLocation(largeButtonSize + 10 * BUTTONSIZE, 3 * BUTTONSIZE + TOPDIST);
        int rShiftSize = (9 * BUTTONSIZE) / 4;
        rShift.setSize(rShiftSize, BUTTONSIZE);
        rShift.setLocation(largeButtonSize + 11 * BUTTONSIZE, 3 * BUTTONSIZE + TOPDIST);

        //bottom line
        lControl.setSize(mediumButttonSize, BUTTONSIZE);
        lControl.setLocation(BUTTONSIZE, 4 * BUTTONSIZE + TOPDIST);
        int commandKeySize = (5 * BUTTONSIZE) / 4;
        lWindows.setSize(commandKeySize, BUTTONSIZE);
        lWindows.setLocation(BUTTONSIZE + mediumButttonSize, 4 * BUTTONSIZE + TOPDIST);
        lAlt.setSize(commandKeySize, BUTTONSIZE);
        lAlt.setLocation(BUTTONSIZE + mediumButttonSize + commandKeySize, 4 * BUTTONSIZE + TOPDIST);
        int spaceBarSize = (25 * BUTTONSIZE) / 4;
        spaceBar.setSize(spaceBarSize, BUTTONSIZE);
        spaceBar.setLocation(BUTTONSIZE + mediumButttonSize + 2 * commandKeySize, 4 * BUTTONSIZE + TOPDIST);
        rAlt.setSize(commandKeySize, BUTTONSIZE);
        rAlt.setLocation(BUTTONSIZE + mediumButttonSize + spaceBarSize + 2 * commandKeySize, 4 * BUTTONSIZE + TOPDIST);
        rWindows.setSize(commandKeySize, BUTTONSIZE);
        rWindows.setLocation(BUTTONSIZE + mediumButttonSize + spaceBarSize + 3 * commandKeySize, 4 * BUTTONSIZE + TOPDIST);
        rControl.setSize(mediumButttonSize, BUTTONSIZE);
        rControl.setLocation(BUTTONSIZE + mediumButttonSize + spaceBarSize + 4 * commandKeySize, 4 * BUTTONSIZE + TOPDIST);



        Container pane = getContentPane();
        pane.add(menuBar);
        pane.add(typingArea);
        pane.add(tildaButton);
        pane.add(oneButton);
        pane.add(twoButton);
        pane.add(threeButton);
        pane.add(fourButton);
        pane.add(fiveButon);
        pane.add(sixButton);
        pane.add(sevenButton);
        pane.add(eightButton);
        pane.add(nineButton);
        pane.add(zeroButton);
        pane.add(hyphenButton);
        pane.add(equalsButton);
        pane.add(deleteButton);
        pane.add(tabButton);
        pane.add(qButton);
        pane.add(wButton);
        pane.add(eButton);
        pane.add(rButton);
        pane.add(tButton);
        pane.add(yButton);
        pane.add(uButton);
        pane.add(iButton);
        pane.add(oButton);
        pane.add(pButton);
        pane.add(lBracket);
        pane.add(rBracket);
        pane.add(backSlash);
        pane.add(capsButton);
        pane.add(lShift);
        pane.add(aButton);
        pane.add(sButton);
        pane.add(dButton);
        pane.add(fButton);
        pane.add(gButton);
        pane.add(hButton);
        pane.add(jButton);
        pane.add(kButton);
        pane.add(lButton);
        pane.add(colonButton);
        pane.add(aposterphieButton);
        pane.add(returnButton);
        pane.add(zButton);
        pane.add(xButton);
        pane.add(cButton);
        pane.add(vButton);
        pane.add(bButton);
        pane.add(nButton);
        pane.add(mButton);
        pane.add(commaButton);
        pane.add(periodButton);
        pane.add(forwardSlash);
        pane.add(rShift);
        pane.add(lControl);
        pane.add(lWindows);
        pane.add(lAlt);
        pane.add(spaceBar);
        pane.add(rAlt);
        pane.add(rWindows);
        pane.add(rControl);
        pane.add(testButton);

        this.setSize(LENGTH, WIDTH);
        this.setVisible(true);
        this.setTitle("Typing App");
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        typingArea.requestFocus();
        Color normal = qButton.getBackground();
    }

    @Override
    public void itemStateChanged(ItemEvent e){

    }

    @Override
    public void actionPerformed(ActionEvent e){

    }


    void buttonYellow(JButton selectedButton){
        selectedButton.setBackground(Color.yellow);
    }

    void buttonNormal(JButton selectedButton){
        selectedButton.setBackground(unusedButton.getBackground());
    }

    void addText(char newText){
        typingArea.setText(typingArea.getText() + newText);
    }


    @Override
    public void keyTyped(KeyEvent e){
        typingArea.requestFocus();
        if (e.getExtendedKeyCode() == KeyEvent.VK_ALT){
            buttonYellow(rAlt);
            buttonYellow(lAlt);
        } else if(e.getKeyCode() == KeyEvent.VK_CONTROL){
            buttonYellow(rControl);
            buttonYellow(lControl);
        } else if(e.getExtendedKeyCode() == KeyEvent.VK_ENTER){
            buttonYellow(returnButton);
        } else if (e.getExtendedKeyCode() == KeyEvent.VK_WINDOWS){
            buttonYellow(lWindows);
            buttonYellow(rWindows);
        } else if (e.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE){
            buttonYellow(deleteButton);
        } else if (e.getExtendedKeyCode() == KeyEvent.VK_SPACE){
            buttonYellow(spaceBar);
        }
        switch (e.getKeyChar()) {
            case 'q':
            case 'Q':
                buttonYellow(qButton);
                break;
            case 'w':
            case 'W':
                buttonYellow(wButton);
                break;
            case 'e':
            case 'E':
                buttonYellow(eButton);
                break;
            case 'r':
            case 'R':
                buttonYellow(rButton);
                break;
            case 't':
            case 'T':
                buttonYellow(tButton);
                break;
            case 'y':
            case 'Y':
                buttonYellow(yButton);
                break;
            case 'u':
            case 'U':
                buttonYellow(uButton);
                break;
            case 'i':
            case 'I':
                buttonYellow(iButton);
                break;
            case 'o':
            case 'O':
                buttonYellow(oButton);
                break;
            case 'p':
            case 'P':
                buttonYellow(pButton);
                break;
            case '[':
                buttonYellow(lBracket);
                break;
            case ']':
                buttonYellow(rBracket);
                break;
            case '\\':
                buttonYellow(backSlash);
                break;
            case 'a':
            case 'A':
                buttonYellow(aButton);

                break;
            case 's':
            case 'S':
                buttonYellow(sButton);
                break;
            case 'd':
            case 'D':
                buttonYellow(dButton);
                break;
            case 'f':
            case 'F':
                buttonYellow(fButton);
                break;
            case 'g':
            case 'G':
                buttonYellow(gButton);
                break;
            case 'h':
            case 'H':
                buttonYellow(hButton);
                break;
            case 'j':
            case 'J':
                buttonYellow(jButton);
                break;
            case 'k':
            case 'K':
                buttonYellow(kButton);
                break;
            case 'l':
            case 'L':
                buttonYellow(lButton);
                break;
            case ';':
            case ':':
                buttonYellow(colonButton);
                break;
            case '\'':
                buttonYellow(aposterphieButton);
                break;
            case 'z':
            case 'Z':
                buttonYellow(zButton);
                break;
            case 'x':
            case 'X':
                buttonYellow(xButton);
                break;
            case 'c':
            case 'C':
                buttonYellow(cButton);
                break;
            case 'v':
            case 'V':
                buttonYellow(vButton);
                break;
            case 'b':
            case 'B':
                buttonYellow(bButton);
                break;
            case 'n':
            case 'N':
                buttonYellow(nButton);
                break;
            case 'm':
            case 'M':
                buttonYellow(mButton);
                break;
            case ',':
                buttonYellow(commaButton);
                break;
            case '.':
                buttonYellow(periodButton);
                break;
            case '/':
                buttonYellow(forwardSlash);
                break;
            case '`':
                buttonYellow(tildaButton);
                break;
            case '1':
                buttonYellow(oneButton);
                break;
            case '2':
                buttonYellow(twoButton);
                break;
            case '3':
                buttonYellow(threeButton);
                break;
            case '4':
                buttonYellow(fourButton);
                break;
            case '5':
                buttonYellow(fiveButon);
                break;
            case '6':
                buttonYellow(sixButton);
                break;
            case '7':
                buttonYellow(sevenButton);
                break;
            case '8':
                buttonYellow(eightButton);
                break;
            case '9':
                buttonYellow(nineButton);
                break;
            case '0':
                buttonYellow(zeroButton);
                break;
            case '-':
                buttonYellow(hyphenButton);
                break;
            case '=':
                buttonYellow(equalsButton);
                break;
            case ' ':
                buttonYellow(spaceBar);
                break;
        }
        addText(e.getKeyChar());
    }
    @Override
    public void keyPressed(KeyEvent e){

    }
    @Override

    public void keyReleased(KeyEvent e){
        typingArea.requestFocus();
        switch (e.getKeyChar()){
            case 'q':
            case 'Q':
                buttonNormal(qButton);
                break;
            case 'w':
            case 'W':
                buttonNormal(wButton);
                break;
            case 'e':
            case 'E':
                buttonNormal(eButton);
                break;
            case 'r':
            case 'R':
                buttonNormal(rButton);
                break;
            case 't':
            case 'T':
                buttonNormal(tButton);
                break;
            case 'y':
            case 'Y':
                buttonNormal(yButton);
                break;
            case 'u':
            case 'U':
                buttonNormal(uButton);
                break;
            case 'i':
            case 'I':
                buttonNormal(iButton);
                break;
            case 'o':
            case 'O':
                buttonNormal(oButton);
                break;
            case 'p':
            case 'P':
                buttonNormal(pButton);
                break;
            case '[':
                buttonNormal(lBracket);
                break;
            case ']':
                buttonNormal(rBracket);
                break;
            case '\\':
                buttonNormal(backSlash);
                break;
            case 'a':
            case 'A':
                buttonNormal(aButton);
                break;
            case 's':
            case 'S':
                buttonNormal(sButton);
                break;
            case 'd':
            case 'D':
                buttonNormal(dButton);
                break;
            case 'f':
            case 'F':
                buttonNormal(fButton);
                break;
            case 'g':
            case 'G':
                buttonNormal(gButton);
                break;
            case 'h':
            case 'H':
                buttonNormal(hButton);
                break;
            case 'j':
            case 'J':
                buttonNormal(jButton);
                break;
            case 'k':
            case 'K':
                buttonNormal(kButton);
                break;
            case 'l':
            case 'L':
                buttonNormal(lButton);
                break;
            case ';':
                buttonNormal(colonButton);
                break;
            case '\'':
                buttonNormal(aposterphieButton);
                break;
            case 'z':
            case 'Z':
                buttonNormal(zButton);
                break;
            case 'x':
            case 'X':
                buttonNormal(xButton);
                break;
            case 'c':
            case 'C':
                buttonNormal(cButton);
                break;
            case 'v':
            case 'V':
                buttonNormal(vButton);
                break;
            case 'b':
            case 'B':
                buttonNormal(bButton);
                break;
            case 'n':
            case 'N':
                buttonNormal(nButton);
                break;
            case 'm':
            case 'M':
                buttonNormal(mButton);
                break;
            case ',':
                buttonNormal(commaButton);
                break;
            case '.':
                buttonNormal(periodButton);
                break;
            case '/':
                buttonNormal(backSlash);
                break;
            case '`':
                buttonNormal(tildaButton);
                break;
            case '1':
                buttonNormal(oneButton);
                break;
            case '2':
                buttonNormal(twoButton);
                break;
            case '3':
                buttonNormal(threeButton);
                break;
            case '4':
                buttonNormal(fourButton);
                break;
            case '5':
                buttonNormal(fiveButon);
                break;
            case '6':
                buttonNormal(sixButton);
                break;
            case '7':
                buttonNormal(sevenButton);
                break;
            case '8':
                buttonNormal(eightButton);
                break;
            case '9':
                buttonNormal(nineButton);
                break;
            case '0':
                buttonNormal(zeroButton);
                break;
            case '-':
                buttonNormal(hyphenButton);
                break;
            case '=':
                buttonNormal(equalsButton);
                break;
            case ' ':
                buttonNormal(spaceBar);
                break;
            default:
                if (e.getExtendedKeyCode() == KeyEvent.VK_DELETE){
                    buttonNormal(deleteButton);
                } else if (e.getExtendedKeyCode() == KeyEvent.VK_SHIFT){
                    buttonNormal(lShift);
                    buttonNormal(rShift);
                } else if (e.getExtendedKeyCode() == KeyEvent.VK_WINDOWS){
                    buttonNormal(rWindows);
                    buttonNormal(lWindows);
                }   else if (e.getExtendedKeyCode() == KeyEvent.VK_ENTER){
                    buttonNormal(returnButton);
                } else if (e.getExtendedKeyCode() == KeyEvent.VK_ALT){
                    buttonNormal(rAlt);
                    buttonNormal(lAlt);
                } else if (e.getExtendedKeyCode() == KeyEvent.VK_CONTROL){
                    buttonNormal(lControl);
                    buttonNormal(rControl);
                }
        }

    }
    public  static void main(String [] args){
        GUI gui = new GUI();
    }
}