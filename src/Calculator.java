import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


class Calculator {
    Frame f = new Frame("AWT Mini Calculator");
    Label l1 = new Label("First Number");
    Label l2 = new Label("Second Number");
    Label l3 = new Label("Operator");
    Label l4 = new Label("Result");
    TextField t1 = new TextField();
    TextField t2 = new TextField();
    TextField t3 = new TextField();
    Choice operator = new Choice();
    Button button = new Button("IZRACUNAJ");

    Calculator() {

        //SETOVANJE LOKACIJE I DIMENZIJE LABEL-A I TEXTFIEL-A
        l1.setBounds(50, 100, 100, 20);
        l2.setBounds(50, 140, 100, 20);
        l3.setBounds(50, 180, 100, 20);
        l4.setBounds(50, 270, 100, 20);
        t1.setBounds(200, 100, 100, 20);
        t2.setBounds(200, 140, 100, 20);
        operator.setBounds(200, 180, 100, 20);
        button.setBounds(50, 230, 300, 20);
        button.setBackground(Color.yellow);
        t3.setBounds(200, 270, 170, 20);
        t3.setBackground(Color.lightGray);

        //DODAVANJE OPERATORA SABIRANJE,ODUZIMANJE,MNOZENJE,DIJELJENJE
        operator.add("Operatori");
        operator.add("+");
        operator.add("-");
        operator.add("*");
        operator.add("/");


        //DODAVANJE KOMPONENTE U FRAME
        f.add(l1);
        f.add(l2);
        f.add(l3);
        f.add(l4);
        f.add(operator);
        f.add(t1);
        f.add(t2);
        f.add(t3);
        f.add(button);

        // SETOVANJE LAYOUT-A
        f.setLayout(null);
        f.setSize(500, 400);
        f.setVisible(true);
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });


        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int nub1 = Integer.parseInt(t1.getText());
                int nub2 = Integer.parseInt(t2.getText());

                if (operator.getSelectedItem().equals("Operatori")) {
                    t3.setText(String.valueOf("Izaberi operator!!"));
                }

                if (operator.getSelectedItem().equals("+")) {
                    t3.setText(String.valueOf(nub1 + nub2));
                }
                if (operator.getSelectedItem().equals("-")) {
                    t3.setText(String.valueOf(nub1 - nub2));
                }
                if (operator.getSelectedItem().equals("*")) {
                    t3.setText(String.valueOf(nub1 * nub2));
                }
                if (operator.getSelectedItem().equals("/")) {
                    if (nub1 == 0 || nub2 == 0) {
                        t3.setText(String.valueOf("Nije moguće deljenje 0"));
                    } else {
                        t3.setText(String.valueOf(nub1 / nub2));
                    }
                }

            }
        });

    }


    public static void main(String[] args) {

        new Calculator();

    }
}
