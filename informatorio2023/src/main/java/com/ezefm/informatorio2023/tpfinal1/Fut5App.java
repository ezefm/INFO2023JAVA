package com.ezefm.informatorio2023.tpfinal1;

import com.ezefm.informatorio2023.tpfinal1.service.Fut5AppService;

public class Fut5App {
    static final Fut5AppService fut5AppService = new Fut5AppService();

    public static void main(String[] args) {

        fut5AppService.showMenu();

    }
}