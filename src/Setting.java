import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Setting extends JDialog implements ActionListener {
    private int width;
    private int height;
    private Container cnt;
    private JButton btnOK;
    private JButton btnCancel;
    private JTextField txtTime;
    private JPanel panel;
    private JLabel lab;
    private int time;

            public Setting() {
                width = 300;
                height = 100;
                this.setSize(width, height);
                this.setLocationRelativeTo(null);
                this.setTitle("Setting");
                this.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
                this.setResizable(false);
                cnt = this.getContentPane();
                cnt.setLayout(new BorderLayout());

                lab = new JLabel("  Time :");
                txtTime = new JTextField();
                btnOK = new JButton("Set");
                btnCancel = new JButton("Cancel");
                panel = new JPanel();

                panel.setLayout(new GridLayout(2, 2));
                panel.add(lab);
                panel.add(txtTime);
                panel.add(btnOK);
                panel.add(btnCancel);

                cnt.add(panel, BorderLayout.CENTER);

                btnOK.addActionListener(this);
                 btnCancel.addActionListener(this);

                time = -1;
            }

            public void showErrorMsg(String msg) {
                JOptionPane.showMessageDialog(null, msg,
                            "Error" ,JOptionPane.ERROR_MESSAGE);
            }

            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btnOK){
                        try {
                                time = Integer.parseInt(txtTime.getText());
                                if (time < 1 || time > 60) {
                                        showErrorMsg("1 - 60 までの範囲で入力");
                                        time = -1;
                                        return;
                                    }
                            } catch (Exception ex) {
                                showErrorMsg("数値入力");
                                return;
                            }
                        dispose();
                    }else if (e.getSource() == btnCancel){
                        dispose();
                    }
            }

            public int getTime() {
                return time;
            }
}
