/**
 * Created by Michael on 10/17/2014.
 */

    import javax.swing.*;
    import java.awt.*;
    import java.awt.event.*;
    import java.io.Console;

    /**
     * Created by michael on 10/8/14.
     */
    public class GUI extends JFrame implements ItemListener, ActionListener, KeyListener {
        private final int BUTTONSIZE = 60;
        private final int TOPDIST = 300;
        private final int WIDTH = 7 * BUTTONSIZE + TOPDIST, LENGTH = 17 * BUTTONSIZE;
        private final int FONTSIZE = 14;

        private JButton tildaButton, oneButton, twoButton, threeButton, fourButton, fiveButon, sixButton, sevenButton, eightButton, nineButton, zeroButton, hyphenButton, equalsButton, deleteButton;
        private JButton tabButton, qButton, wButton, eButton, rButton, tButton, yButton, uButton, iButton, oButton, pButton, lBracket, rBracket, backSlash;
        private JButton capsButton, aButton, sButton, dButton, fButton, gButton, hButton, jButton, kButton, lButton, colonButton, aposterphieButton, returnButton;
        private JButton lShift, zButton, xButton, cButton, vButton, bButton, nButton, mButton, commaButton, periodButton, forwardSlash, rShift;
        private JButton lControl, lWindows, lAlt, spaceBar, rAlt, rWindows, rControl, testButton;
        private JTextField typingArea;

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


            typingArea.setSize(LENGTH - 2 * BUTTONSIZE, TOPDIST - 2 * BUTTONSIZE);
            typingArea.setLocation(BUTTONSIZE, BUTTONSIZE);
            typingArea.addKeyListener(this);
            typingArea.requestFocus();

            //top line
            tildaButton.setSize(BUTTONSIZE, BUTTONSIZE);
            tildaButton.setLocation(BUTTONSIZE, TOPDIST);
            oneButton.setSize(BUTTONSIZE, BUTTONSIZE);
            oneButton.setLocation(2 * BUTTONSIZE, TOPDIST);
            twoButton.setSize(BUTTONSIZE, BUTTONSIZE);
            twoButton.setLocation(3 * BUTTONSIZE, TOPDIST);
            threeButton.setSize(BUTTONSIZE, BUTTONSIZE);
            threeButton.setLocation(4 * BUTTONSIZE, TOPDIST);
            fourButton.setSize(BUTTONSIZE, BUTTONSIZE);
            fourButton.setLocation(5 * BUTTONSIZE, TOPDIST);
            fiveButon.setSize(BUTTONSIZE, BUTTONSIZE);
            fiveButon.setLocation(6 * BUTTONSIZE, TOPDIST);
            sixButton.setSize(BUTTONSIZE, BUTTONSIZE);
            sixButton.setLocation(7 * BUTTONSIZE, TOPDIST);
            sevenButton.setSize(BUTTONSIZE, BUTTONSIZE);
            sevenButton.setLocation(8 * BUTTONSIZE, TOPDIST);
            eightButton.setSize(BUTTONSIZE, BUTTONSIZE);
            eightButton.setLocation(9 * BUTTONSIZE, TOPDIST);
            nineButton.setSize(BUTTONSIZE, BUTTONSIZE);
            nineButton.setLocation(10 * BUTTONSIZE, TOPDIST);
            zeroButton.setSize(BUTTONSIZE, BUTTONSIZE);
            zeroButton.setLocation(11 * BUTTONSIZE, TOPDIST);
            hyphenButton.setSize(BUTTONSIZE, BUTTONSIZE);
            hyphenButton.setLocation(12 * BUTTONSIZE, TOPDIST);
            equalsButton.setSize(BUTTONSIZE, BUTTONSIZE);
            equalsButton.setLocation(13 * BUTTONSIZE, TOPDIST);

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

        }

        @Override
        public void itemStateChanged(ItemEvent e){

        }

        @Override
        public void actionPerformed(ActionEvent e){

        }
        @Override
        public void keyTyped(KeyEvent e){
            typingArea.requestFocus();
            System.out.println(e.getKeyChar());
            switch (e.getKeyChar()) {
                case 'q':
                    qButton.setFont(new Font(qButton.getFont().getName(), Font.BOLD, FONTSIZE));
                    break;
                case 'w':
                    wButton.setFont(new Font(wButton.getFont().getName(), Font.BOLD, FONTSIZE));
                    break;
                case 'e':
                    eButton.setFont(new Font(eButton.getFont().getName(), Font.BOLD, FONTSIZE));
                    break;
                case 'r':
                    rButton.setFont(new Font(rButton.getFont().getName(), Font.BOLD, FONTSIZE));
                    break;
                case 't':
                    tButton.setFont(new Font(tButton.getFont().getName(), Font.BOLD, FONTSIZE));
                    break;
                case 'y':
                    yButton.setFont(new Font(yButton.getFont().getName(), Font.BOLD, FONTSIZE));
                    break;
                case 'u':
                    uButton.setFont(new Font(uButton.getFont().getName(), Font.BOLD, FONTSIZE));
                    break;
                case 'i':
                    iButton.setFont(new Font(iButton.getFont().getName(), Font.BOLD, FONTSIZE));
                    break;
                case 'o':
                    oButton.setFont(new Font(oButton.getFont().getName(), Font.BOLD, FONTSIZE));
                    break;
                case 'p':
                    pButton.setFont(new Font(pButton.getFont().getName(), Font.BOLD, FONTSIZE));
                    break;
                case '[':
                    lBracket.setFont(new Font(lBracket.getFont().getName(), Font.BOLD, FONTSIZE));
                    break;
                case ']':
                    rBracket.setFont(new Font(rBracket.getFont().getName(), Font.BOLD, FONTSIZE));
                    break;
                case '\\':
                    backSlash.setFont(new Font(backSlash.getFont().getName(), Font.BOLD, FONTSIZE));
                    break;
                case 'a':
                    aButton.setFont(new Font(aButton.getFont().getName(), Font.BOLD, FONTSIZE));
                    break;
                case 's':
                    sButton.setFont(new Font(sButton.getFont().getName(), Font.BOLD, FONTSIZE));
                    break;
                case 'd':
                    dButton.setFont(new Font(dButton.getFont().getName(), Font.BOLD, FONTSIZE));
                    break;
                case 'f':
                    fButton.setFont(new Font(fButton.getFont().getName(), Font.BOLD, FONTSIZE));
                    break;
                case 'g':
                    gButton.setFont(new Font(gButton.getFont().getName(), Font.BOLD, FONTSIZE));
                    break;
                case 'h':
                    hButton.setFont(new Font(hButton.getFont().getName(), Font.BOLD, FONTSIZE));
                    break;
                case 'j':
                    jButton.setFont(new Font(jButton.getFont().getName(), Font.BOLD, FONTSIZE));
                    break;
                case 'k':
                    kButton.setFont(new Font(kButton.getFont().getName(), Font.BOLD, FONTSIZE));
                    break;
                case 'l':
                    lButton.setFont(new Font(lButton.getFont().getName(), Font.BOLD, FONTSIZE));
                    break;
                case ';':
                    colonButton.setFont(new Font(colonButton.getFont().getName(), Font.BOLD, FONTSIZE));
                    break;
                case '\'':
                    aposterphieButton.setFont(new Font(aposterphieButton.getFont().getName(), Font.BOLD, FONTSIZE));
                    break;
                case 'z':
                    zButton.setFont(new Font(zButton.getFont().getName(), Font.BOLD, FONTSIZE));
                    break;
                case 'x':
                    xButton.setFont(new Font(xButton.getFont().getName(), Font.BOLD, FONTSIZE));
                    break;
                case 'c':
                    cButton.setFont(new Font(cButton.getFont().getName(), Font.BOLD, FONTSIZE));
                    break;
                case 'v':
                    vButton.setFont(new Font(vButton.getFont().getName(), Font.BOLD, FONTSIZE));
                    break;
                case 'b':
                    bButton.setFont(new Font(bButton.getFont().getName(), Font.BOLD, FONTSIZE));
                    break;
                case 'n':
                    nButton.setFont(new Font(nButton.getFont().getName(), Font.BOLD, FONTSIZE));
                    break;
                case 'm':
                    mButton.setFont(new Font(mButton.getFont().getName(), Font.BOLD, FONTSIZE));
                    break;
                case ',':
                    commaButton.setFont(new Font(commaButton.getFont().getName(), Font.BOLD, FONTSIZE));
                    break;
                case '.':
                    periodButton.setFont(new Font(periodButton.getFont().getName(), Font.BOLD, FONTSIZE));
                    break;
                case '/':
                    forwardSlash.setFont(new Font(forwardSlash.getFont().getName(), Font.BOLD, FONTSIZE));
                    break;
                case '`':
                    tildaButton.setFont(new Font(tildaButton.getFont().getName(), Font.BOLD, FONTSIZE));
                    break;
                case '1':
                    oneButton.setFont(new Font(oneButton.getFont().getName(), Font.BOLD, FONTSIZE));
                    break;
                case '2':
                    twoButton.setFont(new Font(twoButton.getFont().getName(), Font.BOLD, FONTSIZE));
                    break;
                case '3':
                    threeButton.setFont(new Font(threeButton.getFont().getName(), Font.BOLD, FONTSIZE));
                    break;
                case '4':
                    fourButton.setFont(new Font(fourButton.getFont().getName(), Font.BOLD, FONTSIZE));
                    break;
                case '5':
                    fiveButon.setFont(new Font(fiveButon.getFont().getName(), Font.BOLD, FONTSIZE));
                    break;
                case '6':
                    sixButton.setFont(new Font(sixButton.getFont().getName(), Font.BOLD, FONTSIZE));
                    break;
                case '7':
                    sevenButton.setFont(new Font(sevenButton.getFont().getName(), Font.BOLD, FONTSIZE));
                    break;
                case '8':
                    eightButton.setFont(new Font(eightButton.getFont().getName(), Font.BOLD, FONTSIZE));
                    break;
                case '9':
                    nineButton.setFont(new Font(nineButton.getFont().getName(), Font.BOLD, FONTSIZE));
                    break;
                case '0':
                    zeroButton.setFont(new Font(zeroButton.getFont().getName(), Font.BOLD, FONTSIZE));
                    break;
                case '-':
                    hyphenButton.setFont(new Font(hyphenButton.getFont().getName(), Font.BOLD, FONTSIZE));
                    break;
                case '=':
                    equalsButton.setFont(new Font(equalsButton.getFont().getName(), Font.BOLD, FONTSIZE));
                    break;
                default:
                    if (e.getExtendedKeyCode() == KeyEvent.VK_ALT){
                        rAlt.setFont(new Font(rAlt.getFont().getName(), Font.BOLD, FONTSIZE));
                        lAlt.setFont(new Font(lAlt.getFont().getName(), Font.BOLD, FONTSIZE));
                    } else if(e.getExtendedKeyCode() == KeyEvent.VK_CONTROL){
                        rControl.setFont(new Font(rControl.getFont().getName(), Font.BOLD, FONTSIZE));
                        lControl.setFont(new Font(lControl.getFont().getName(), Font.BOLD, FONTSIZE));
                    } else if(e.getExtendedKeyCode() == KeyEvent.VK_ENTER){
                        returnButton.setFont(new Font(returnButton.getFont().getName(), Font.BOLD, FONTSIZE));
                    } else if (e.getExtendedKeyCode() == KeyEvent.VK_WINDOWS){
                        lWindows.setFont(new Font(lWindows.getFont().getName(), Font.BOLD, FONTSIZE));
                        rWindows.setFont(new Font(rWindows.getFont().getName(), Font.BOLD, FONTSIZE));
                    } else if (e.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE){
                        deleteButton.setFont(new Font(deleteButton.getFont().getName(), Font.BOLD, FONTSIZE));
                    } else if (e.getExtendedKeyCode() == KeyEvent.VK_SPACE){
                        spaceBar.setFont(new Font(spaceBar.getFont().getName(), Font.BOLD, FONTSIZE));
                    }
            }
        }
        @Override
        public void keyPressed(KeyEvent e){

        }
        @Override
        public void keyReleased(KeyEvent e){
            typingArea.requestFocus();
            switch (e.getKeyChar()){
                case 'q':
                    qButton.setFont(new Font(qButton.getFont().getName(), Font.PLAIN, FONTSIZE));
                    break;
                case 'w':
                    wButton.setFont(new Font(wButton.getFont().getName(), Font.PLAIN, FONTSIZE));
                    break;
                case 'e':
                    eButton.setFont(new Font(eButton.getFont().getName(), Font.PLAIN, FONTSIZE));
                    break;
                case 'r':
                    rButton.setFont(new Font(rButton.getFont().getName(), Font.PLAIN, FONTSIZE));
                    break;
                case 't':
                    tButton.setFont(new Font(tButton.getFont().getName(), Font.PLAIN, FONTSIZE));
                    break;
                case 'y':
                    yButton.setFont(new Font(yButton.getFont().getName(), Font.PLAIN, FONTSIZE));
                    break;
                case 'u':
                    uButton.setFont(new Font(uButton.getFont().getName(), Font.PLAIN, FONTSIZE));
                    break;
                case 'i':
                    iButton.setFont(new Font(iButton.getFont().getName(), Font.PLAIN, FONTSIZE));
                    break;
                case 'o':
                    oButton.setFont(new Font(oButton.getFont().getName(), Font.PLAIN, FONTSIZE));
                    break;
                case 'p':
                    pButton.setFont(new Font(pButton.getFont().getName(), Font.PLAIN, FONTSIZE));
                    break;
                case '[':
                    lBracket.setFont(new Font(lBracket.getFont().getName(), Font.PLAIN, FONTSIZE));
                    break;
                case ']':
                    rBracket.setFont(new Font(rBracket.getFont().getName(), Font.PLAIN, FONTSIZE));
                    break;
                case '\\':
                    backSlash.setFont(new Font(backSlash.getFont().getName(), Font.PLAIN, FONTSIZE));
                    break;
                case 'a':
                    aButton.setFont(new Font(aButton.getFont().getName(), Font.PLAIN, FONTSIZE));
                    break;
                case 's':
                    sButton.setFont(new Font(sButton.getFont().getName(), Font.PLAIN, FONTSIZE));
                    break;
                case 'd':
                    dButton.setFont(new Font(dButton.getFont().getName(), Font.PLAIN, FONTSIZE));
                    break;
                case 'f':
                    fButton.setFont(new Font(fButton.getFont().getName(), Font.PLAIN, FONTSIZE));
                    break;
                case 'g':
                    gButton.setFont(new Font(gButton.getFont().getName(), Font.PLAIN, FONTSIZE));
                    break;
                case 'h':
                    hButton.setFont(new Font(hButton.getFont().getName(), Font.PLAIN, FONTSIZE));
                    break;
                case 'j':
                    jButton.setFont(new Font(jButton.getFont().getName(), Font.PLAIN, FONTSIZE));
                    break;
                case 'k':
                    kButton.setFont(new Font(kButton.getFont().getName(), Font.PLAIN, FONTSIZE));
                    break;
                case 'l':
                    lButton.setFont(new Font(lButton.getFont().getName(), Font.PLAIN, FONTSIZE));
                    break;
                case ';':
                    colonButton.setFont(new Font(colonButton.getFont().getName(), Font.PLAIN, FONTSIZE));
                    break;
                case '\'':
                    aposterphieButton.setFont(new Font(aposterphieButton.getFont().getName(), Font.PLAIN, FONTSIZE));
                    break;
                case 'z':
                    zButton.setFont(new Font(zButton.getFont().getName(), Font.PLAIN, FONTSIZE));
                    break;
                case 'x':
                    xButton.setFont(new Font(xButton.getFont().getName(), Font.PLAIN, FONTSIZE));
                    break;
                case 'c':
                    cButton.setFont(new Font(cButton.getFont().getName(), Font.PLAIN, FONTSIZE));
                    break;
                case 'v':
                    vButton.setFont(new Font(vButton.getFont().getName(), Font.PLAIN, FONTSIZE));
                    break;
                case 'b':
                    bButton.setFont(new Font(bButton.getFont().getName(), Font.PLAIN, FONTSIZE));
                    break;
                case 'n':
                    nButton.setFont(new Font(nButton.getFont().getName(), Font.PLAIN, FONTSIZE));
                    break;
                case 'm':
                    mButton.setFont(new Font(mButton.getFont().getName(), Font.PLAIN, FONTSIZE));
                    break;
                case ',':
                    commaButton.setFont(new Font(commaButton.getFont().getName(), Font.PLAIN, FONTSIZE));
                    break;
                case '.':
                    periodButton.setFont(new Font(periodButton.getFont().getName(), Font.PLAIN, FONTSIZE));
                    break;
                case '/':
                    forwardSlash.setFont(new Font(forwardSlash.getFont().getName(), Font.PLAIN, FONTSIZE));
                    break;
                case '`':
                    tildaButton.setFont(new Font(tildaButton.getFont().getName(), Font.PLAIN, FONTSIZE));
                    break;
                case '1':
                    oneButton.setFont(new Font(oneButton.getFont().getName(), Font.PLAIN, FONTSIZE));
                    break;
                case '2':
                    twoButton.setFont(new Font(twoButton.getFont().getName(), Font.PLAIN, FONTSIZE));
                    break;
                case '3':
                    threeButton.setFont(new Font(threeButton.getFont().getName(), Font.PLAIN, FONTSIZE));
                    break;
                case '4':
                    fourButton.setFont(new Font(fourButton.getFont().getName(), Font.PLAIN, FONTSIZE));
                    break;
                case '5':
                    fiveButon.setFont(new Font(fiveButon.getFont().getName(), Font.PLAIN, FONTSIZE));
                    break;
                case '6':
                    sixButton.setFont(new Font(sixButton.getFont().getName(), Font.PLAIN, FONTSIZE));
                    break;
                case '7':
                    sevenButton.setFont(new Font(sevenButton.getFont().getName(), Font.PLAIN, FONTSIZE));
                    break;
                case '8':
                    eightButton.setFont(new Font(eightButton.getFont().getName(), Font.PLAIN, FONTSIZE));
                    break;
                case '9':
                    nineButton.setFont(new Font(nineButton.getFont().getName(), Font.PLAIN, FONTSIZE));
                    break;
                case '0':
                    zeroButton.setFont(new Font(zeroButton.getFont().getName(), Font.PLAIN, FONTSIZE));
                    break;
                case '-':
                    hyphenButton.setFont(new Font(hyphenButton.getFont().getName(), Font.PLAIN, FONTSIZE));
                    break;
                case '=':
                    equalsButton.setFont(new Font(equalsButton.getFont().getName(), Font.PLAIN, FONTSIZE));
                    break;
                default:
                    if (e.getExtendedKeyCode() == KeyEvent.VK_DELETE){
                        deleteButton.setFont(new Font(deleteButton.getFont().getName(), Font.PLAIN, FONTSIZE));
                    } else if (e.getExtendedKeyCode() == KeyEvent.VK_SHIFT){
                        lShift.setFont(new Font(lShift.getFont().getName(), Font.PLAIN, FONTSIZE));
                        rShift.setFont(new Font(rShift.getFont().getName(), Font.PLAIN, FONTSIZE));
                    } else if (e.getExtendedKeyCode() == KeyEvent.VK_WINDOWS){
                        rWindows.setFont(new Font(rWindows.getFont().getName(), Font.PLAIN, FONTSIZE));
                        lWindows.setFont(new Font(lWindows.getFont().getName(), Font.PLAIN, FONTSIZE));
                    }   else if (e.getExtendedKeyCode() == KeyEvent.VK_ENTER){
                        returnButton.setFont(new Font(returnButton.getFont().getName(), Font.PLAIN, FONTSIZE));
                    } else if (e.getExtendedKeyCode() == KeyEvent.VK_ALT){
                        rAlt.setFont(new Font(rAlt.getFont().getName(), Font.PLAIN, FONTSIZE));
                        lAlt.setFont(new Font(lAlt.getFont().getName(), Font.PLAIN, FONTSIZE));
                    } else if (e.getExtendedKeyCode() == KeyEvent.VK_CONTROL){
                        rControl.setFont(new Font(rControl.getFont().getName(), Font.PLAIN, FONTSIZE));
                        lControl.setFont(new Font(lControl.getFont().getName(), Font.PLAIN, FONTSIZE));
                    }
            }
        }
        public  static void main(String [] args){
            GUI gui = new GUI();
        }
    }

