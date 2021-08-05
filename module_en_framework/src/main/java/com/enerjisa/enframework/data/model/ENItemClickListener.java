package com.enerjisa.enframework.data.model;

/**
 * Created by Arda Kaplan at 27.07.2021 - 14:56
 * <p>
 * ardakaplan101@gmail.com
 * <p>
 * liste ekranlarında item ların clicklerinin alınması için gerekli olan sınıf
 */
public abstract class ENItemClickListener<W> {

    public abstract void onItemClick(W w, int index);

    /**
     * istenilen durumlarda kullanılsın, yoksa ekranda kalabalık yapmasın diye normal metot olarak yazıldı
     *
     * @param w     data object
     * @param index index in dataList
     */
    public void onItemLongClick(W w, int index) {

    }
}