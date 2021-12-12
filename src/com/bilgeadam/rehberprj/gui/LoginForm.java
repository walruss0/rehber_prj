package com.bilgeadam.rehberprj.gui;

import com.bilgeadam.rehberprj.dao.KullaniciDAO;
import com.bilgeadam.rehberprj.dto.KullaniciDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

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
        kullaniciAdiLB.setForeground(Color.red);
        setLocationRelativeTo(null);


        girisButon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              //  JOptionPane.showMessageDialog(null,"Butona basıldı!");
                if (adTF.getText().length()==0)
                {
                    JOptionPane.showMessageDialog(null, "Ad alanı boş geçilemez");
                    return;
                }
                if (String.valueOf(sifrePF.getPassword()).length()==0)
                {
                    JOptionPane.showMessageDialog(null,"Şifre alanı boş geçilemez");
                    return;
                }
                try {
                    KullaniciDTO kullanici = new KullaniciDTO();
                    kullanici.setKullaniciAdi(adTF.getText());
                    kullanici.setSifre(String.valueOf(sifrePF.getPassword()));

                    boolean sonuc = KullaniciDAO.giriseYetkiliMi(kullanici);
                    if (sonuc) JOptionPane.showMessageDialog(null,"Girişe yetkili!");
                    else JOptionPane.showMessageDialog(null,"Girişe yetkili değil!");


                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null,"Hata:"+ex.getMessage());
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null,"Hata:"+ex.getMessage());
                }



            }
        });
    }




}
