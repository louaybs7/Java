package forms;

import forms.seance.seancesForm;
import forms.coachs.coachsForm;
import forms.members.membersForm;
import java.util.ArrayList;
import java.util.Date;
import models.*;

public class welcomeForm extends javax.swing.JFrame {

    ArrayList<coach> coachs = new ArrayList<coach>();
    ArrayList<membre> members = new ArrayList<models.membre>();
    //constructor
    public welcomeForm() {
        initComponents();
        coachs=dataBase.go.getCoachsData();
        members=dataBase.go.getMembersData();
        membersNum.setText(String.valueOf(members.size()));
        ActiveMembersNum.setText(String.valueOf(activeMembers()));
        coachsNum.setText(String.valueOf(coachs.size()));
    }
    //calculate the active members
    public int activeMembers(){
        int count =0;
        Date date = new Date();
        for(membre x:members){
            if (x.getSubscriptionLimit().after(date)){
                count++;
            }
        }
        return count;
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        mainPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        membersNum = new controls.JMyLabel(18);
        activeMembersLabel = new controls.JMyLabel(18);
        coachsLabel = new controls.JMyLabel(18);
        membersStatLabel1 = new controls.JMyLabel(18);
        coachsNum = new controls.JMyLabel(18);
        ActiveMembersNum = new controls.JMyLabel(18);
        staticsPanel = new javax.swing.JPanel();
        title = new controls.JTitleLabel();
        checkUserPanel = new javax.swing.JPanel();
        checkUserLabel = new controls.JMyLabel(12);
        checkUserTF = new javax.swing.JTextField();
        checkUserBtn = new controls.JMyButton();
        checkCoachPanel = new javax.swing.JPanel();
        checkCoachLabel = new controls.JMyLabel(12);
        checkCoachTF = new javax.swing.JTextField();
        checkCoachBtn = new controls.JMyButton();
        membersSectionBtn = new controls.JMySectionButton();
        seanceSectionBtn = new controls.JMySectionButton();
        coachSectionBtn = new controls.JMySectionButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setBackground(new java.awt.Color(0, 59, 70));

        jLabel1.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Statistiques :");

        activeMembersLabel.setText("Membres Actifs : ");

        coachsLabel.setText("Coachs : ");

        membersStatLabel1.setText("Membres :");

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(coachsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(coachsNum, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addComponent(membersStatLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(membersNum, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(activeMembersLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ActiveMembersNum, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(membersStatLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(membersNum, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(82, 82, 82)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ActiveMembersNum, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(activeMembersLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(coachsLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(coachsNum, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        staticsPanel.setBackground(new java.awt.Color(196, 223, 230));

        title.setText("Salle De Sport Fitness");

        checkUserPanel.setBackground(new java.awt.Color(0, 59, 70));

        checkUserLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        checkUserLabel.setForeground(new java.awt.Color(255, 255, 255));
        checkUserLabel.setText("Vérifier la validité de l'abonnement :");

        checkUserBtn.setText("Verifier");
        checkUserBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkUserBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout checkUserPanelLayout = new javax.swing.GroupLayout(checkUserPanel);
        checkUserPanel.setLayout(checkUserPanelLayout);
        checkUserPanelLayout.setHorizontalGroup(
            checkUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(checkUserPanelLayout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addComponent(checkUserBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(checkUserPanelLayout.createSequentialGroup()
                .addGroup(checkUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(checkUserPanelLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(checkUserLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, checkUserPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(checkUserTF, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        checkUserPanelLayout.setVerticalGroup(
            checkUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(checkUserPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(checkUserLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(checkUserTF, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(checkUserBtn)
                .addGap(22, 22, 22))
        );

        checkCoachPanel.setBackground(new java.awt.Color(0, 59, 70));

        checkCoachLabel.setText("Verifier La Carte De Coach");
        checkCoachLabel.setToolTipText("");

        checkCoachBtn.setText("Verifier");
        checkCoachBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkCoachBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout checkCoachPanelLayout = new javax.swing.GroupLayout(checkCoachPanel);
        checkCoachPanel.setLayout(checkCoachPanelLayout);
        checkCoachPanelLayout.setHorizontalGroup(
            checkCoachPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(checkCoachPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(checkCoachPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(checkCoachPanelLayout.createSequentialGroup()
                        .addComponent(checkCoachLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(checkCoachPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(checkCoachPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(checkCoachBtn)
                            .addComponent(checkCoachTF, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(24, Short.MAX_VALUE))))
        );
        checkCoachPanelLayout.setVerticalGroup(
            checkCoachPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(checkCoachPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(checkCoachLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(checkCoachTF, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(checkCoachBtn)
                .addGap(26, 26, 26))
        );

        membersSectionBtn.setText("Membres");
        membersSectionBtn.setActionCommand("");
        membersSectionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                membersSectionBtnActionPerformed(evt);
            }
        });

        seanceSectionBtn.setText("Seances");
        seanceSectionBtn.setActionCommand("");
        seanceSectionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seanceSectionBtnActionPerformed(evt);
            }
        });

        coachSectionBtn.setText("Coachs");
        coachSectionBtn.setActionCommand("");
        coachSectionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coachSectionBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout staticsPanelLayout = new javax.swing.GroupLayout(staticsPanel);
        staticsPanel.setLayout(staticsPanelLayout);
        staticsPanelLayout.setHorizontalGroup(
            staticsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(staticsPanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(staticsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(staticsPanelLayout.createSequentialGroup()
                        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(staticsPanelLayout.createSequentialGroup()
                        .addGroup(staticsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(checkUserPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(membersSectionBtn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(coachSectionBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(staticsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkCoachPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(seanceSectionBtn))
                        .addGap(39, 39, 39))))
        );
        staticsPanelLayout.setVerticalGroup(
            staticsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(staticsPanelLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(staticsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(checkCoachPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkUserPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                .addGroup(staticsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(membersSectionBtn)
                    .addComponent(seanceSectionBtn)
                    .addComponent(coachSectionBtn))
                .addGap(86, 86, 86))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(staticsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(staticsPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //open members section
    private void membersSectionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_membersSectionBtnActionPerformed
        // TODO add your handling code here:
        dispose();
        gym.Tools.openForm(new membersForm());
    }//GEN-LAST:event_membersSectionBtnActionPerformed
    // get coachs section
    private void coachSectionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coachSectionBtnActionPerformed
        // TODO add your handling code here:
        dispose();
        gym.Tools.openForm(new coachsForm());
    }//GEN-LAST:event_coachSectionBtnActionPerformed
    // get seances section
    private void seanceSectionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seanceSectionBtnActionPerformed
        // TODO add your handling code here:
        dispose();
        gym.Tools.openForm(new seancesForm());
    }//GEN-LAST:event_seanceSectionBtnActionPerformed
    // check the validity of the member subscription
    private void checkUserBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkUserBtnActionPerformed
        // TODO add your handling code here:
        int id = Integer.parseInt(checkUserTF.getText());
        Date date = new Date();
        for(membre x : members){
            if (x.getId()==id && x.getSubscriptionLimit().after(date) && x.getStatut().equals("valid")) {
                gym.Tools.msgBox("Abonnement Valide !");
                return ;
            }
        }
        gym.Tools.msgBox("Abonnement Non Valide !");
    }//GEN-LAST:event_checkUserBtnActionPerformed
    // check the coach card id
    private void checkCoachBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkCoachBtnActionPerformed
        // TODO add your handling code here:
        int id = Integer.parseInt(checkCoachTF.getText());
        for(coach x : coachs){
            if (x.getId()==id ) {
                gym.Tools.msgBox("Carte Valide !");
                return ;
            }
        }
        gym.Tools.msgBox("Carte Non Valide !");
    }//GEN-LAST:event_checkCoachBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ActiveMembersNum;
    private javax.swing.JLabel activeMembersLabel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton checkCoachBtn;
    private javax.swing.JLabel checkCoachLabel;
    private javax.swing.JPanel checkCoachPanel;
    private javax.swing.JTextField checkCoachTF;
    private javax.swing.JButton checkUserBtn;
    private javax.swing.JLabel checkUserLabel;
    private javax.swing.JPanel checkUserPanel;
    private javax.swing.JTextField checkUserTF;
    private javax.swing.JButton coachSectionBtn;
    private javax.swing.JLabel coachsLabel;
    private javax.swing.JLabel coachsNum;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel membersNum;
    private javax.swing.JButton membersSectionBtn;
    private javax.swing.JLabel membersStatLabel1;
    private javax.swing.JButton seanceSectionBtn;
    private javax.swing.JPanel staticsPanel;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
