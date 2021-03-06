/*
 * This file is part of the Meteor Client distribution (https://github.com/MeteorDevelopment/meteor-client/).
 * Copyright (c) 2021 Meteor Development.
 */

package minegame159.meteorclient.accounts.gui;

import minegame159.meteorclient.MeteorClient;
import minegame159.meteorclient.accounts.Account;
import minegame159.meteorclient.accounts.AccountManager;
import minegame159.meteorclient.accounts.types.CrackedAccount;
import minegame159.meteorclient.gui.screens.WindowScreen;
import minegame159.meteorclient.gui.widgets.WButton;
import minegame159.meteorclient.gui.widgets.WLabel;
import minegame159.meteorclient.gui.widgets.WTextBox;

public class AddCrackedAccountScreen extends WindowScreen {


    public AddCrackedAccountScreen() {
        super("Add Cracked Account", true);

        // Name
        add(new WLabel("Name:"));
        WAccountField name = add(new WAccountField("", 400)).getWidget();
        name.setFocused(true);
        row();

        // Add
        WButton add = add(new WButton("Add")).fillX().expandX().getWidget();
        add.action = () -> {
            CrackedAccount account = new CrackedAccount(name.getText());
            if (!name.getText().trim().isEmpty() && !(AccountManager.INSTANCE.exists(account))) {
                AccountsScreen.addAccount(add, this, account);
            }
        };

    }
}