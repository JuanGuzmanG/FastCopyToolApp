package Logic;

import GUI.AddList;
import GUI.Main;

import javax.swing.*;

public class mainfct {
    public static void main(String[] args){
        //GUI creation and adjustments
        Main gui = new Main();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.pack();
        gui.setSize(1000,600);
        gui.setLocationRelativeTo(null);
        gui.setVisible(true);
    }

    //
    //         ooooooooooooooooooooooooooooooooooooooo
    //         ooo oooooooooooooooooooooooo ooo    ooo
    //         oo ooooooo   ooo          ooo ooooo  oo
    //         o oooooooo   ooo   ooooooooooo oo   ooo
    //         o oooooooo   ooo   ooooooooooo o      o
    //         o oooooooo   ooo   ooo    oooo oooooooo
    //         o oooooooo   ooo   ooooo  oooo oooooooo
    //         oo ooo       ooo          ooo ooooooooo
    //         ooo oooooooooooooooooooooooo oooooooooo
    //         ooooooooooooooooooooooooooooooooooooooo
    //
    // oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo
    // oooooooooooooooooooooooc,''''',;cooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooc;,,'''',cooooooooooooooooooooooooooooooooooolllllooooooooooooooooooo
    // oooooooooooooooooooool,.      .:looooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooool;.      .,loooooooooooooooooooooooolc:;,'...........';cloooooooooooo
    // oooooooooooooooooooo:.      .;looooooooooooooooooooooooooolc;;;;;;;;;;;;;;:cooooc:;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;cooooooooool;.      .:oooooooooooooooooooooo:.                   .,coooooooooo
    // ooooooooooooooooool;.     .,looooooooooooooooooooooooooooo;.               'loo;.                                        .;ooooooooooooc,.     .;loooooooooooooooooooo;.       ......        .;loooooooo
    // oooooooooooooooool'      .:ooooooooooooooooooooooooooooool.                .lol'                                         ,loooooooooooooo:.      ,looooooooooooooooooo;. ..';:cclllllc;'      .;oooooooo
    // ooooooooooooooooc.      'cooooooooooooooooooooooooooooooo:.                .lol'                                        .cooooooooooooooooc'      'looooooooooooooooooc;:loooooooooooooo;.     .looooooo
    // oooooooooooooooc.      ,loooooooooooooooooooooooooooooooo;                 .lol'                                        'loooooooooooooooool'      'coooooooooooooooooooooooooooooooooool.     .cooooooo
    // ooooooooooooooc.      ,looooooooooooooooooooooooooooooooo,                 .loo,                   ....................'coooooooooooooooooool,      'looooooooooooooooooooooooooooooooooc.     'looooooo
    // oooooooooooool'      ,loooooooooooooooooooooooooooooooool'                 .loo,                  ,llllllllllllllllllllooooooooooooooooooooool'      ,looooooooooooooooooooooooooooooooc'     .:oooooooo
    // ooooooooooooo;      'looooooooooooooooooooooooooooooooool'                 'loo,                 .coooooooooooooooooooooooooooooooooooooooooool'     .;ooooooooooooooooooooooooooooool;.     .:ooooooooo
    // oooooooooooo:.     .coooooooooooooooooooooooooooooooooooc.                 'loo,                 .loooooooooooooooooooooooooooooooooooooooooooo:.     .coooooooooooooooooooooooooooc,.     .,loooooooooo
    // oooooooooool,      ;ooooooooooooooooooooooooooooooooooooc.                 'loo,                 ,looooooooooooooooooooooooooooooooooooooooooooo,      ,ooooooooooooooooooooooool:'.     .,coooooooooooo
    // oooooooooooc.     .cooooooooooooooooooooooooooooooooooool.                 'loo,                  looooooooooooooooooooooooooooooooooooooooooooooc.     .coooooooooooooooooooolc,.      .;looooooooooooo
    // ooooooooooo;      ;oooooooooooooooooooooooooooooooooooool.                 'ooo;                 :oooooooolc::::::::::::clooooooooooooooooooooooo;      ;ooooooooooooooooolc,.      .,cooooooooooooooooo
    // ooooooooool'     .coooooooooooooooooooooooooooooooooooooo'                 ,ooo;                 .cooooooc.             ..:ooooooooooooooooooooooc.     'loooooooooooool:,.      .,clooooooooooooooooooo
    // ooooooooooc.     'loooooooooooooooooooooooooooooooooooooo,                 'oooc.                .coooooo,                'loooooooooooooooooooool.     .loooooooooooo:.       ..,;;;;;;;;;;;;;;;:looooo
    // ooooooooooc.     'loooooooooooooooooooooooooooooooooooool'                 'ooooc,..             'loooooo,                'loooooooooooooooooooool'     .coooooooooooo,                          .cooooo
    // oooooooooo:.     ,ooooooooooooooooooooooooooooooooooooool.                 ,oooo;.               ,ooooooo;                'loooooooooooooooooooooo,     .coooooooooooo;                          .cooooo
    // oooooooooo:.     ,ooooooooooooooooooooooooooooooooooooooc.                 ,oool.               .;ooooooo;                'loooooooooooooooooooooo,     .cooooooooooool:;;;;;;;;;;;;;;;;;;;;;;;;;clooooo
    // ooooooooooc.     ,ooooooooooooooooooooooooooooooooooooooc.                 ,oool.               .coooooool'               'loooooooooooooooooooool'     .coooooooooooooooooooooooooooooooooooooooooooooo
    // ooooooooooc.     'loooooooooooooooooooooooooooooooooooooc.                 ,oool.               .looooooool:,......... .  .loooooooooooooooooooool'     .loooooooooooooooooooooooooooooooooooooooooooooo
    // ooooooooool'     .coooooooooooooooooooooooooooooooooooooc.                 ;oool.               ,ooooooooo:;;,,''''...... 'loooooooooooooooooooooc.     'loooooooooooooooooooooooooooooooooooooooooooooo
    // ooooooooooo,     .:ooooooooooooooooooooooooooooooooooooo:.                .:oool'               'looooooo:.               ,oooooooooooooooooooooo;.     ;ooooooooooooooooooooooooooooooooooooooooooooooo
    // ooooooooooo:.     'loooooooooooooooooo:'...',ll:'......'.                 .coool'                .........               'loooooooooooooooooooool'     .:ooooooooooooooooooooooooooooooooooooooooooooooo
    // oooooooooool'     .:ooooooooooooooooo:.     .::.                          'loool'                                       .:oooooooooooooooooooooo;.     'looooooooooooooooooooooooooooooooooooooooooooooo
    // oooooooooooo:.     .loooooooooooooooo:.     .cl;.                         ;ooooo'                                       .coooooooooooooooooooooc.     .:oooooooooooooooooooooooooooooooooooooooooooooooo
    // ooooooooooool,      ,loooooooooooooooo;      ..,;'                       .cooooo,          ...                          .looooooooooooooooooool,      ,loooooooooooooooooooooooooooooooooooooooooooooooo
    // oooooooooooooc.     .;ooooooooooooooooc.        .,.                      ,oooooo;.     .,:clol;.            .,..        ,loooooooooooooooooooo;      'cooooooooooooooooooooooooooooooooooooooooooooooooo
    // oooooooooooooo:.     .:ooooooooooooooooc;,,,,,,,;;,,,,,,,,,,,,,,,,,,,,,,;looooool:;;;;:coooooool:;,,,,,,,,,;cooc:;;,,,;:loooooooooooooooooooo;.     .coooooooooooooooooooooooooooooooooooooooooooooooooo
    // ooooooooooooooo:.     .;oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo;.     .:ooooooooooooooooooooooooooooooooooooooooooooooooooo
    // oooooooooooooooo:.     .;looooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooool,      .:oooooooooooooooooooooooooooooooooooooooooooooooooooo
    // oooooooooooooooooc.      'cooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooc'      .cooooooooooooooooooooooooooooooooooooooooooooooooooooo
    // ooooooooooooooooooc'      .:oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooool:.      'coooooooooooooooooooooooooooooooooooooooooooooooooooooo
    // oooooooooooooooooool;.      'cooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooc'      .;looooooooooooooooooooooooooooooooooooooooooooooooooooooo
    // oooooooooooooooooooooc.      .,cooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooc,.      'cooooooooooooooooooooooooooooooooooooooooooooooooooooooooo
    // ooooooooooooooooooooool;.......,cooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooc,.......;loooooooooooooooooooooooooooooooooooooooooooooooooooooooooo
    // oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo
    //
}

