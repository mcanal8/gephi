/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gephi.branding.desktop;

import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.WindowManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@ActionID(
        category = "Tools",
        id = "org.gephi.branding.desktop.Macros"
)
@ActionRegistration(
        displayName = "#CTL_Macros"
)
@ActionReference(path = "Menu/Tools", position = 5800, separatorBefore = 3750)
@Messages("CTL_Macros=Macros")
public final class Macros implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
       SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MacrosPanelList component = new MacrosPanelList();
                component.updateList();
                
                JDialog dialog = new JDialog(WindowManager.getDefault().getMainWindow(),component.getName(), false);
                dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                dialog.getContentPane().add(component);
                dialog.setBounds(200, 200, 420, 350);
                dialog.setVisible(true);
            }
        });
    }
}
