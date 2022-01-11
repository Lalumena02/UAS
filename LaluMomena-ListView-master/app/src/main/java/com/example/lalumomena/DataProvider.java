package com.example.lalumomena;

import android.content.Context;

import com.example.lalumomena.model.Hewan;
import com.example.lalumomena.model.Anjing;
import com.example.lalumomena.model.Kucing;
import com.example.lalumomena.model.Ular;

import java.util.ArrayList;
import java.util.List;
public class DataProvider {

    private static List<Hewan> hewans = new ArrayList<>();

    private static List<Kucing> initDataKucing(Context ctx) {
        List<Kucing> kucings = new ArrayList<>();
        kucings.add(new Kucing("Bengal", "America",
                " Kucing bengal adalah keturunan keempat dari hasil persilangan antara kucing american shorthair dengan kucing asian leopard", R.drawable.bengal));
        kucings.add(new Kucing("Persia ", "Turki",
                "Kucing persia adalah ras kucing domestik berbulu panjang dengan karakter wajah bulat dan moncong pendek. Namanya mengacu pada Persia, nama lama Iran, di mana kucing serupa ditemukan.", R.drawable.persia));
        kucings.add(new Kucing("Brithis short hair", "Inggris",
                "Kucing bulu pendek britania adalah salah satu ras kucing tertua yang nenek moyang dipercayai memiliki hubungan dengan bangsa Romawi yang pernah dahulu menguasai Inggris.", R.drawable.brithis_short_hair));
        return kucings;
    }

    private static List<Ular> initDataUlar(Context ctx) {
        List<Ular> ulars = new ArrayList<>();
        ulars.add(new Ular("Kobra", "Afrika",
                "Ular sendok atau kobra adalah sebutan khusus untuk semua jenis ular berbisa (Elapidae) yang memiliki kemampuan memipihkan lehernya hingga membentuk seperti sendok atau tudung.", R.drawable.kobra));
        ulars.add(new Ular("Sanca", "Afrika ",
                "Sanca adalah sebutan umum untuk semua jenis ular pembelit yang diklasifikasikan sebagai familia Pythonidae.", R.drawable.sanca));
        ulars.add(new Ular("Boomslang", "Afrika",
                "Boomslang (dari Bahasa Afrikaans, Boom =\"Pohon\" dan Slang =\"Ular\") atau benama latin Dispholidus typus adalah spesies ular pohon kolubrid yang tersebar luas di Benua Afrika. ", R.drawable.boomslang));
        return ulars;
    }

    private static List<Anjing> initDataAnjing(Context ctx) {
        List<Anjing> anjings = new ArrayList<>();
        anjings.add(new Anjing("Pitbull", "Amerika",
                "Pit bull adalah nama umum untuk jenis anjing yang diturunkan dari bulldog dan terrier.", R.drawable.pitbull));
        anjings.add(new Anjing("Sephear", "Jerman",
                "Anjing Gembala Jerman adalah salah satu ras murni anjing yang populer.", R.drawable.sephear));
        anjings.add(new Anjing("Husky ", "siberia",
                "Husky termasuk dalam jenis anjing ras berukuran sedang dan berbulu tebal.", R.drawable.husky));
        return anjings;
    }

    private static void initAllHewans(Context ctx) {
        hewans.addAll(initDataKucing(ctx));
        hewans.addAll(initDataUlar(ctx));
        hewans.addAll(initDataAnjing(ctx));
    }

    public static List<Hewan> getAllHewan(Context ctx) {
        if (hewans.size() == 0) {
            initAllHewans(ctx);
        }
        return  hewans;
    }

    public static List<Hewan> getHewansByTipe(Context ctx, String jenis) {
        List<Hewan> hewansByType = new ArrayList<>();
        if (hewans.size() == 0) {
            initAllHewans(ctx);
        }
        for (Hewan h : hewans) {
            if (h.getJenis().equals(jenis)) {
                hewansByType.add(h);
            }
        }
        return hewansByType;
    }
}
