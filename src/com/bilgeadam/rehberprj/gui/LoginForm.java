package com.bilgeadam.rehberprj.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame {
    private JTextField adTF;
    private JPasswordField sifrePF;
    private JButton girisButon;
    private JLabel sifreLB;
    private JLabel kullaniciAdiLB;
    private JPanel jPanel1;
    private JPanel jPanel2;

    public LoginForm()
    {
        add(jPanel1);




        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setTitle("Giriş Ekranı");
        setSize(300,200);
        jPanel1.setBackground(Color.black);
        setLocationRelativeTo(null);


        girisButon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Butona basıldı!");
            }
        });
    }




}
