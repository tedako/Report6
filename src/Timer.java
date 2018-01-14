import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

        public class Timer extends JFrame {
            public static final long serialVersionUID = 1L;
    private int x; // 幅
    private int y; // 高さ
    private JLabel lab;
    private int hour;
    private int minute;

            public Timer(int t) {
                x = 500;
                y = 200;
                // タイトル
                this.setTitle("Timer");
                // サイズ
                this.setSize(x, y);
                // 画面中央
                this.setLocationRelativeTo(null);
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.setResizable(false);
                //時間表示
                hour = t;
                minute = 0;
                String s = t < 10 ? ("0" + t + ":00") : (t + ":00");
                lab = new JLabel(s, SwingConstants.CENTER);
                lab.setFont(new Font("Arial", Font.PLAIN, 120));
                this.getContentPane().add(lab);


                setVisible(true);
                startTimer();
            }

            public void showMsg() {
                JOptionPane.showMessageDialog(null, "Time up!", "終了",
                                JOptionPane.INFORMATION_MESSAGE);
            }

            public void startTimer() {
                while (true) {
                        try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        if (minute == 0) {
                                minute = 59;
                                hour--;
                            } else {
                                minute--;
                            }
                        String h = hour < 10 ? ("0" + hour) : Integer.toString(hour);
                        String m = minute < 10 ? ("0" + minute) : Integer.toString(minute);
                        lab.setText(h + ":" + m);
                        if (hour == 0 && minute == 0) {
                                showMsg();
                                break;
                            }
                    }
            }

            public static void main(String[] args) {
                Setting form = new Setting();
                form.setVisible(true);

                if (form.getTime() != -1) {
                        new Timer(form.getTime());
                    }

            }

        }