package bv.com.cmdev;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LambdaActionListener {

    public static void main(String[] args) {

        JButton button = new JButton();
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("Hello World!");
            }
        });

        JButton buttons = new JButton();
        buttons.addActionListener(actionEvent -> {
            System.out.println("Hello World!");
        });

    }

}