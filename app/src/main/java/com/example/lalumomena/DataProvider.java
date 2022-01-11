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
        kucings.add(new Kucing(ctx.getString(R.string.bengal_nama), ctx.getString(R.string.bengal_asal),
                ctx.getString(R.string.bengal_deskripsi), R.drawable.bengal));
        kucings.add(new Kucing(ctx.getString(R.string.persia_nama), ctx.getString(R.string.persia_asal),
                ctx.getString(R.string.bengal_deskripsi), R.drawable.persia));
        kucings.add(new Kucing(ctx.getString(R.string.brithis_short_hair_nama), ctx.getString(R.string.brithis_short_hair_asal),
                ctx.getString(R.string.bengal_deskripsi), R.drawable.brithis_short_hair));
         return kucings;
    }

    private static List<Ular> initDataUlar(Context ctx) {
        List<Ular> ulars = new ArrayList<>();
        ulars.add(new Ular(ctx.getString(R.string.kobra_nama), ctx.getString(R.string.kobra_asal),
                ctx.getString(R.string.kobra_deskripsi), R.drawable.kobra));
        ulars.add(new Ular(ctx.getString(R.string.sanca_nama), ctx.getString(R.string.sanca_asal),
                ctx.getString(R.string.sanca_deskripsi), R.drawable.sanca));
        ulars.add(new Ular(ctx.getString(R.string.boomslang_nama), ctx.getString(R.string.boomslang_asal),
                ctx.getString(R.string.boomslang_deskripsi), R.drawable.boomslang));
        return ulars;
    }

    private static List<Anjing> initDataAnjing(Context ctx) {
        List<Anjing> anjings = new ArrayList<>();
        anjings.add(new Anjing(ctx.getString(R.string.pitbull_nama), ctx.getString(R.string.pitbull_asal),
                ctx.getString(R.string.pitbull_deskripsi), R.drawable.pitbull));
        anjings.add(new Anjing(ctx.getString(R.string.sephear_nama), ctx.getString(R.string.sephear_asal),
                ctx.getString(R.string.sephear_deskripsi), R.drawable.sephear));
        anjings.add(new Anjing(ctx.getString(R.string.husky_nama), ctx.getString(R.string.husky_asal),
                ctx.getString(R.string.husky_deskripsi), R.drawable.husky));
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
