package com.example.myportofolio;

import java.util.ArrayList;

class PortofolioData {
    private static String[] portofolio = {
            "Portofolio A ",
            "Portofolio B ",
            "Portofolio C ",
            "Portofolio D ",
            "Portofolio E ",
            "Portofolio F ",
            "Portofolio G ",
            "Portofolio H ",
            "Portofolio I ",
            "Portofolio J ",
    };

    private static String[] portofolioDetails = {
            "Portofolio A ",
            "Portofolio B ",
            "Portofolio C ",
            "Portofolio D ",
            "Portofolio E ",
            "Portofolio F ",
            "Portofolio G ",
            "Portofolio H ",
            "Portofolio I ",
            "Portofolio J ",
             };

    private static int[] portofolioImages = {
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,

    };

    static ArrayList<ModelPortofolio> getListData() {
        ArrayList<ModelPortofolio> list = new ArrayList<>();
        for (int position = 0; position < portofolio.length; position++) {
            ModelPortofolio modelPortofolio = new ModelPortofolio();
            modelPortofolio.setName(portofolio[position]);
            modelPortofolio.setDetail(portofolioDetails[position]);
            modelPortofolio.setPhoto(portofolioImages[position]);
            list.add(modelPortofolio);
        }
        return list;
    }
}
